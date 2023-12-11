/**
 * This file is part of the vscode-deploy-reloaded distribution.
 * Copyright (c) Marcel Joachim Kloubert.
 * 
 * vscode-deploy-reloaded is free software: you can redistribute it and/or modify  
 * it under the terms of the GNU Lesser General Public License as   
 * published by the Free Software Foundation, version 3.
 *
 * vscode-deploy-reloaded is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

import * as _ from 'lodash';
import * as Crypto from 'crypto';
import * as deploy_contracts from './contracts';
import * as deploy_delete from './delete';
import * as deploy_files from './files';
import * as deploy_gui from './gui';
import * as deploy_helpers from './helpers';
import * as deploy_html from './html';
import * as deploy_log from './log';
import * as deploy_packages from './packages';
import * as deploy_plugins from './plugins';
import * as deploy_scm from './scm';
import * as deploy_targets from './targets';
import * as deploy_transformers from './transformers';
import * as deploy_workspaces from './workspaces';
import * as Enumerable from 'node-enumerable';
import * as FS from 'fs';
import * as HtmlEntities from 'html-entities';
import * as i18 from './i18';
import * as Path from 'path';
import * as vscode from 'vscode';


interface ScmFileFilter {
    exclude?: string[];
    files?: string[];    
}

type ScmFileFilterStorage = { [ branch: string ]: ScmFileFilter };

const KEY_SCM_COMMIT_FILE_FILTERS = 'vscdrScmCommitFileFilters';

async function checkBeforeDeploy(
    target: deploy_targets.Target,
    plugin: deploy_plugins.Plugin,
    files: string[],
    mappingScopeDirs: string[],
    cancelToken: vscode.CancellationToken,
): Promise<boolean> {
    const TARGET_NAME = deploy_targets.getTargetName(target);
    const WORKSPACE = target.__workspace;

    if (!deploy_helpers.toBooleanSafe(target.checkBeforeDeploy)) {
        return true;
    }

    if (!deploy_plugins.canList(plugin, target)) {
        let selectedValue: number;

        const SELECTED_ITEM = await WORKSPACE.showWarningMessage(
            WORKSPACE.t('deploy.checkBeforeDeploy.notSupported', TARGET_NAME),
            {
                isCloseAffordance: true,
                title: WORKSPACE.t('no'),
                value: 0,
            },
            {
                title: WORKSPACE.t('yes'),
                value: 1,
            }
        );
        if (SELECTED_ITEM) {
            selectedValue = SELECTED_ITEM.value;
        }

        if (1 !== selectedValue) {
            return false;
        }
    }

    WORKSPACE.output
             .append( WORKSPACE.t('deploy.checkBeforeDeploy.beginOperation', TARGET_NAME) + ' ');
    try {
        const LIST_RESULTS: deploy_contracts.KeyValuePairs<deploy_plugins.ListDirectoryResult> = {};

        const FILES_AND_PATHS: deploy_contracts.KeyValuePairs<deploy_contracts.WithNameAndPath> = {};
        for (const F of files) {
            const NAME_AND_PATH = deploy_targets.getNameAndPathForFileDeployment(target, F,
                                                                                 mappingScopeDirs);
            if (false !== NAME_AND_PATH) {
                FILES_AND_PATHS[F] = NAME_AND_PATH;
            }
        }

        for (const F in FILES_AND_PATHS) {            
            if (cancelToken.isCancellationRequested) {
                return false;
            }

            try {
                const NAME_AND_PATH = FILES_AND_PATHS[F];

                const KEY = NAME_AND_PATH.path;
                if (!_.isNil( LIST_RESULTS[KEY] )) {
                    continue;
                }

                const CTX: deploy_plugins.ListDirectoryContext = {
                    cancellationToken: cancelToken,
                    dir: NAME_AND_PATH.path,
                    isCancelling: undefined,
                    target: target,
                    workspace: WORKSPACE,
                };

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    get: () => cancelToken.isCancellationRequested,
                });

                const LIST = await plugin.listDirectory(CTX);
                if (LIST) {
                    LIST_RESULTS[KEY] = LIST;
                }
            }
            catch (e) {
                WORKSPACE.logger
                         .trace(e, 'deploy.checkBeforeDeploy(1)');
            }
        }

        const NEWER_FILES: deploy_contracts.KeyValuePairs<deploy_files.FileInfo[]> = {};
        for (const PATH in LIST_RESULTS) {
            const LIST = LIST_RESULTS[PATH];

            for (const F in FILES_AND_PATHS) {
                const NAME_AND_PATH = FILES_AND_PATHS[F];
                if (PATH !== NAME_AND_PATH.path) {
                    continue;
                }

                const FILE_NAME = Path.basename(F);
                const FILE_STATS = await deploy_helpers.lstat(F);

                for (const RF of deploy_helpers.asArray(LIST.files)) {
                    if (RF.name !== FILE_NAME) {
                        continue;
                    }

                    const REMOTE_MTIME = deploy_helpers.asUTC(RF.time);
                    if (REMOTE_MTIME) {
                        const LOCAL_TIME = deploy_helpers.asUTC(FILE_STATS.mtime);
                        if (LOCAL_TIME) {
                            if (REMOTE_MTIME.isAfter(LOCAL_TIME)) {
                                if (_.isNil(NEWER_FILES[F])) {
                                    NEWER_FILES[F] = [];
                                }

                                NEWER_FILES[F].push(RF);
                            }
                        }
                    }
                }
            }
        }

        WORKSPACE.output
                 .appendLine( `[${ WORKSPACE.t('done') }]` );

        const OLDER_FILES = Object.keys(NEWER_FILES).sort((x, y) => {
            return deploy_helpers.compareValuesBy(x, y,
                                                  i => deploy_helpers.normalizeString(i));
        });
        if (OLDER_FILES.length > 0) {
            let selectedValue: number;

            const SELECTED_ITEM = await WORKSPACE.showWarningMessage(
                WORKSPACE.t('deploy.checkBeforeDeploy.newerFilesFound', OLDER_FILES.length),
                {
                    isCloseAffordance: true,
                    title: WORKSPACE.t('no'),
                    value: 0,
                },
                {
                    title: WORKSPACE.t('yes'),
                    value: 1,
                }
            );
            if (SELECTED_ITEM) {
                selectedValue = SELECTED_ITEM.value;
            }

            switch (selectedValue) {
                case 0:
                    {
                        const HTML_ENCODER = new HtmlEntities.AllHtmlEntities();

                        const TITLE = WORKSPACE.t('deploy.checkBeforeDeploy.report.title', TARGET_NAME);

                        const TABLE_HEADER_LOCAL_FILE = HTML_ENCODER.encode(
                            WORKSPACE.t('deploy.checkBeforeDeploy.report.localFile')
                        );
                        const TABLE_HEADER_REMOTE_FILE = HTML_ENCODER.encode(
                            WORKSPACE.t('deploy.checkBeforeDeploy.report.remoteFile')
                        );
                        const TABLE_HEADER_LAST_CHANGE = HTML_ENCODER.encode(
                            WORKSPACE.t('deploy.checkBeforeDeploy.report.lastChange')
                        );
                        const TABLE_HEADER_SIZE = HTML_ENCODER.encode(
                            WORKSPACE.t('deploy.checkBeforeDeploy.report.size')
                        );

                        let md = `# ${HTML_ENCODER.encode(TITLE)}\n`;
                        
                        md += `\n`;
                        md += `${TABLE_HEADER_LOCAL_FILE} | ${TABLE_HEADER_LAST_CHANGE} | ${TABLE_HEADER_SIZE} | ${TABLE_HEADER_REMOTE_FILE} | ${TABLE_HEADER_LAST_CHANGE} | ${TABLE_HEADER_SIZE}\n`;
                        md += `------------|:-------------:|:-------------:|-------------|:-------------:|:-------------:\n`;

                        for (const F of OLDER_FILES) {
                            const NEWER_FILE_LIST = NEWER_FILES[F];

                            const STATS = await deploy_helpers.lstat(F);
                            const LOCAL_MTIME = deploy_helpers.asLocalTime(STATS.mtime);
                            const LOCAL_SIZE = deploy_helpers.toStringSafe(STATS.size);

                            for (const RF of NEWER_FILE_LIST) {
                                const REMOTE_MTIME = deploy_helpers.asLocalTime(RF.time);
                                const REMOTE_SIZE = deploy_helpers.toStringSafe(RF.size);

                                const TABLE_CELL_LOCAL_FILE = HTML_ENCODER.encode(F);
                                const TABLE_CELL_LOCAL_FILE_MTIME = HTML_ENCODER.encode(
                                    LOCAL_MTIME.format( WORKSPACE.t('time.dateTimeWithSeconds') )
                                );
                                const TABLE_CELL_LOCAL_FILE_SIZE = HTML_ENCODER.encode(LOCAL_SIZE);
                                
                                const TABLE_CELL_REMOTE_FILE = HTML_ENCODER.encode(
                                    '/' + 
                                    deploy_helpers.normalizePath(
                                        '/' +
                                        deploy_helpers.normalizePath(RF.path) + 
                                        '/' +
                                        deploy_helpers.normalizePath(RF.name)
                                    )
                                );
                                const TABLE_CELL_REMOTE_FILE_MTIME = HTML_ENCODER.encode(
                                    REMOTE_MTIME.format( WORKSPACE.t('time.dateTimeWithSeconds') )
                                );
                                const TABLE_CELL_REMOTE_FILE_SIZE = HTML_ENCODER.encode(REMOTE_SIZE);

                                md += `${TABLE_CELL_LOCAL_FILE} | ${TABLE_CELL_LOCAL_FILE_MTIME} | ${TABLE_CELL_LOCAL_FILE_SIZE} | ${TABLE_CELL_REMOTE_FILE} | ${TABLE_CELL_REMOTE_FILE_MTIME} | ${TABLE_CELL_REMOTE_FILE_SIZE}\n`;
                            }
                        }

                        await deploy_html.openMarkdownDocument(md, {
                            documentTitle: TITLE,
                        });
                    }
                    return false;

                case 1:
                    break;  // start deployment

                default:
                    return false;
            }
        }

        return !cancelToken.isCancellationRequested;
    }
    catch (e) {
        WORKSPACE.output
                 .appendLine( `[${ WORKSPACE.t('error', e) }]` );

        return false;
    }
}

/**
 * Deploys all opened files.
 * 
 * @param {deploy_workspaces.Workspace|deploy_workspaces.Workspace[]} workspaces The available workspaces.
 */
export async function deployAllOpenFiles(workspaces: deploy_workspaces.Workspace | deploy_workspaces.Workspace[]) {
    workspaces = deploy_helpers.asArray(workspaces);
    if (workspaces.length < 1) {
        deploy_helpers.showWarningMessage(
            i18.t('workspaces.noneFound')
        );

        return;
    }

    const DOCUMENTS = deploy_helpers.asArray(vscode.workspace.textDocuments).filter(d => {
        return !d.isClosed &&
               !d.isUntitled;
    });
    if (DOCUMENTS.length < 1) {
        deploy_helpers.showWarningMessage(
            i18.t('editors.noOpen')
        );

        return;
    }

    const CREATE_FILE_LIST_RELOADER = (ws: deploy_workspaces.Workspace): () => string[] => {
        return () => {
            return DOCUMENTS.map(doc => {
                if (!deploy_helpers.isEmptyString(doc.fileName)) {
                    if (ws.isPathOf(doc.fileName)) {
                        return doc;
                    }
                }

                return false;
            }).filter(e => {
                return false !== e;
            }).map((doc: vscode.TextDocument) => {
                return Path.resolve(doc.fileName);
            }).filter(f => {
                return FS.existsSync(f) &&
                       FS.lstatSync(f).isFile();
            });
        };
    };

    for (const WS of workspaces) {
        const RELOADER = CREATE_FILE_LIST_RELOADER(WS);

        const FILES = RELOADER();
        if (FILES.length < 1) {
            continue;
        }

        const TARGET = await deploy_targets.showTargetQuickPick(
            WS.context.extension,
            WS.getUploadTargets(),
            {
                placeHolder: WS.t('workspaces.selectTarget',
                                  WS.name),
            },
        );
        if (!TARGET) {
            continue;
        }

        const TARGET_NAME = deploy_targets.getTargetName(TARGET);

        try {
            await deploy_helpers.applyFuncFor(
                deployFilesTo,
                WS
            )(FILES, TARGET,
              RELOADER);
        }
        catch (e) {
            WS.showErrorMessage(
                WS.t('deploy.errors.operationToTargetFailed',
                     TARGET_NAME, e),
            );
        }
    }
}

/**
 * Deploys a files from a file list of the active text editor.
 * 
 * @param {vscode.ExtensionContext} context The extension context.
 */
export async function deployFileList(context: vscode.ExtensionContext) {
    const WORKSPACE = await deploy_workspaces.showWorkspaceQuickPick(
        context,
        deploy_workspaces.getAllWorkspaces(),
        {
            placeHolder: i18.t('workspaces.selectWorkspace'),
        }
    );
    if (!WORKSPACE) {
        return;
    }

    await WORKSPACE.startDeploymentOfFilesFromActiveDocument(
        async (target, files) => {
            await deploy_helpers.applyFuncFor(
                deployFilesTo,
                target.__workspace,
            )(files, target,
              () => files);
        }
    );
}

/**
 * Deploys files to a target.
 * 
 * @param {string[]} files The files to deploy.
 * @param {deploy_targets.Target} target The target to deploy to.
 * @param {deploy_contracts.Reloader<string>} fileListReloader A function that reloads the list of files.
 */
export async function deployFilesTo(files: string[],
                                    target: deploy_targets.Target,
                                    fileListReloader: deploy_contracts.Reloader<string>) {
    const ME: deploy_workspaces.Workspace = this;

    await ME.deployQueue.add(async () => {
        await deploy_helpers.withProgress(async (progress) => {
            await deploy_helpers.applyFuncFor(
                deployFilesToWithProgress,
                ME,
            )(progress,
              files,
              target,
              fileListReloader);
        }, {
            location: vscode.ProgressLocation.Notification,
            cancellable: true,
            title: `🚀 ` + ME.t('deploy.deployingFiles'),        
        });
    });
}

async function deployFilesToWithProgress(progress: deploy_helpers.ProgressContext,
                                         files: string[],
                                         target: deploy_targets.Target,
                                         fileListReloader: deploy_contracts.Reloader<string>) {
    const ME: deploy_workspaces.Workspace = this;

    target = ME.prepareTarget(target);

    if (ME.isInFinalizeState) {
        return;
    }
    
    if (!files) {
        return;
    }

    const NORMALIZE_FILE_LIST = () => {
        files = files.filter(f => !ME.isFileIgnored(f));
    };

    if (!fileListReloader) {
        const INITIAL_LIST = files.map(f => f);

        fileListReloader = () => INITIAL_LIST;
    }

    NORMALIZE_FILE_LIST();

    // preparements
    let reloadFileList = false;
    const PREPARE_CANCELLED = !deploy_helpers.toBooleanSafe(
        await deploy_targets.executePrepareTargetOperations({
            cancellationToken: progress.cancellationToken,
            files: files,
            deployOperation: deploy_contracts.DeployOperation.Deploy,
            onReloadFileList: () => {
                reloadFileList = true;
            },
            target: target,
        }),
        true
    );
    if (PREPARE_CANCELLED) {
        return;
    }

    if (reloadFileList) {
        files = deploy_helpers.asArray(
            await Promise.resolve(
                fileListReloader()
            )
        );

        NORMALIZE_FILE_LIST();
    }

    if (files.length < 1) {
        return;
    }

    if (!target) {
        return;
    }

    await ME.deactivateAutoDeployOperationsFor(async () => {
        await deploy_helpers.applyFuncFor(
            saveBeforeDeploy,
            ME
        )(target, files);
    });

    const TARGET_NAME = deploy_targets.getTargetName(target);
    const STATE_KEY = deploy_helpers.toStringSafe(target.__id);

    const PLUGINS = ME.getUploadPlugins(target);
    if (PLUGINS.length < 1) {
        ME.showWarningMessage(
            ME.t('targets.noPluginsFound')
        );

        return;
    }

    let transformer = await ME.loadDataTransformer(target);
    if (false === transformer) {
        throw new Error(ME.t('targets.errors.couldNotLoadDataTransformer',
                             TARGET_NAME));
    }

    transformer = deploy_transformers.toDataTransformerSafe(
        deploy_transformers.toPasswordTransformer(transformer, target)
    );

    const TRANSFORMER_OPTIONS = deploy_helpers.cloneObject(target.transformerOptions);

    const SYNC_WHEN_STATES = ME.syncWhenOpenStates;

    const MAPPING_SCOPE_DIRS = await deploy_targets.getScopeDirectoriesForTargetFolderMappings(target);

    const CANCELLATION_SOURCE = new vscode.CancellationTokenSource();
    
    progress.cancellationToken.onCancellationRequested(() => {
        try {
            CANCELLATION_SOURCE.cancel();
        }
        catch (e) {
            ME.logger
              .trace(e, 'deploy.deployFilesToWithProgress().progressCancelToken.onCancellationRequested()');
        }
    });
    if (progress.cancellationToken.isCancellationRequested) {
        CANCELLATION_SOURCE.cancel();
    }

    const IS_MULTI_ROOT = deploy_workspaces.getAllWorkspaces().length > 1;
    const GET_FILE_PATH_FOR_DISPLAY = (f: string) => {
        if (!IS_MULTI_ROOT) {
            const RELATIVE_PATH = ME.toRelativePath(f);
            if (false !== RELATIVE_PATH) {
                return deploy_helpers.toDisplayablePath(RELATIVE_PATH);
            }
        }

        return f;
    };

    try {
        const ITEMS_FOR_PROGRESS: any[] = [];
        const TOTAL_COUNT = files.length * PLUGINS.length;
        const INCREMENT = TOTAL_COUNT > 0 ? (1.0 / TOTAL_COUNT * 100.0)
                                          : 0;
        const UPDATE_PROGRESS = (item: any, msg: string) => {
            let inc: number;
            if (ITEMS_FOR_PROGRESS.indexOf(item) < 0) {
                ITEMS_FOR_PROGRESS.push(item);
                inc = INCREMENT;
            }

            progress.baseContext.report({
                // increment: inc,
                message: msg,
            });
        };

        while (PLUGINS.length > 0) {
            if (CANCELLATION_SOURCE.token.isCancellationRequested) {
                break;
            }

            const PI = PLUGINS.shift();

            const POPUP_STATS: deploy_gui.ShowPopupWhenFinishedStats = {
                failed: [],
                operation: deploy_contracts.DeployOperation.Deploy,
                succeeded: [],
            };

            const OVERALL_WATCH = deploy_helpers.startWatch();

            // "finished button"
            await ME.invokeForFinishedButton(
                deploy_contracts.DeployOperation.Deploy,
                (btn) => btn.hide(),
            );
            const UPDATE_FINISHED_BTN = async (err: any) => {
                await ME.invokeForFinishedButton(
                    deploy_contracts.DeployOperation.Deploy,
                    async (btn) => {
                        const NOW = deploy_helpers.now();

                        let icon = `🚀`;
                        let color: string = 'statusBar.foreground';
                        if (err) {
                            color = 'errorForeground';
                            icon = `🔥`;
                        }
                        else {
                            if (POPUP_STATS.failed.length > 0) {
                                if (POPUP_STATS.succeeded.length < 1) {
                                    color = 'errorForeground';
                                    icon = `🔥`;
                                }
                                else {
                                    color = 'editorWarning.foreground';
                                    icon = `⚠️`;
                                }
                            }
                        }                        

                        btn.color = new vscode.ThemeColor(color);
                        btn.text = `${icon} ` +
                                   `[${NOW.format( ME.t('time.timeWithSeconds') )}] ` + 
                                   ME.t('deploy.finishedButton.text',
                                        OVERALL_WATCH.stop());
                        btn.tooltip = ME.t('deploy.finishedButton.tooltip');

                        ME.showFinishedButton(deploy_contracts.DeployOperation.Deploy);
                    }
                );
            };        

            try {
                if (!(await checkBeforeDeploy(target, PI, files, MAPPING_SCOPE_DIRS, CANCELLATION_SOURCE.token))) {
                    continue;
                }

                ME.output.appendLine('');
                
                if (files.length > 1) {
                    ME.output.appendLine(
                        `🚀 ` + ME.t('deploy.startOperation',
                                      TARGET_NAME)
                    );
                }

                let watch: deploy_helpers.StopWatch;
                const START_WATCH = () => watch = deploy_helpers.startWatch();
                const STOP_WATCH = () => {
                    if (watch) {
                        ME.output.appendLine(` [${watch.stop()} ms]`);
                    }

                    watch = null;
                };

                const FILES_TO_UPLOAD = deploy_helpers.from(files.map(f => {
                    const NAME_AND_PATH = deploy_targets.getNameAndPathForFileDeployment(target, f,
                                                                                         MAPPING_SCOPE_DIRS);
                    if (false === NAME_AND_PATH) {
                        return null;
                    }                    

                    const LF = new deploy_plugins.LocalFileToUpload(ME, f, NAME_AND_PATH);
                    LF.onBeforeUpload = async function(destination?: string) {
                        const NOW = deploy_helpers.now();

                        if (arguments.length < 1) {
                            destination = NAME_AND_PATH.path;
                        }
                        destination = `${deploy_helpers.toStringSafe(destination)} (${TARGET_NAME})`;

                        const PROGRESS_MSG = `🚀 ` +
                                             (TOTAL_COUNT > 1 ? `(${(ITEMS_FOR_PROGRESS.length + 1)} / ${TOTAL_COUNT}) ` : '') + 
                                             ME.t('deploy.deployingFile',
                                                  GET_FILE_PATH_FOR_DISPLAY(f), destination);

                        ME.output.append(
                            `[${NOW.format( ME.t('time.timeWithSeconds') )}] ` + 
                            PROGRESS_MSG + ' '
                        );

                        UPDATE_PROGRESS(LF, PROGRESS_MSG);

                        if (CANCELLATION_SOURCE.token.isCancellationRequested) {
                            ME.output.appendLine(`[${ME.t('canceled')}]`);
                        }
                        else {
                            START_WATCH();
                        }
                    };
                    LF.onUploadCompleted = async (err?: any) => {
                        if (err) {
                            ME.output.append(`🔥: '${ deploy_helpers.toStringSafe(err) }'`);

                            POPUP_STATS.failed.push( f );
                        }
                        else {
                            const SYNC_WHEN_OPEN_ID = ME.getSyncWhenOpenKey(target);
                            if (false !== SYNC_WHEN_OPEN_ID) {
                                // reset 'sync when open' state
                                delete SYNC_WHEN_STATES[SYNC_WHEN_OPEN_ID];
                            }

                            ME.output.append(`✅`);

                            POPUP_STATS.succeeded.push( f );
                        }

                        STOP_WATCH();
                    };

                    LF.transformer = <deploy_transformers.DataTransformer>transformer;
                    LF.transformerSubContext = {
                        deployOperation: deploy_contracts.DeployOperation.Deploy,
                        file: LF.file,
                        remoteFile: deploy_helpers.normalizePath(
                            NAME_AND_PATH.path + '/' + NAME_AND_PATH.name,
                        ),
                        target: target,
                    };
                    LF.transformerOptions = TRANSFORMER_OPTIONS;
                    LF.transformerStateKeyProvider = () => {
                        return STATE_KEY;
                    };

                    return LF;
                })).where(f => !_.isNil(f)).orderBy(f => {
                    return deploy_helpers.normalizeString(f.path).length;
                }).thenBy(f => {
                    return deploy_helpers.normalizeString(f.path);
                }).thenBy(f => {
                    return deploy_helpers.normalizeString(f.name).length;
                }).thenBy(f => {
                    return deploy_helpers.normalizeString(f.name);
                }).toArray();

                const CTX: deploy_plugins.UploadContext = {
                    cancellationToken: CANCELLATION_SOURCE.token,
                    files: FILES_TO_UPLOAD,
                    isCancelling: undefined,
                    target: target,
                };

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    enumerable: true,

                    get: () => {
                        return CTX.cancellationToken.isCancellationRequested;
                    }
                });

                const SHOW_CANCELED_BY_OPERATIONS_MESSAGE = () => {
                    ME.output.appendLine(
                        `✖️ ` + ME.t('deploy.canceledByOperation',
                                     TARGET_NAME)
                    );
                };

                let operationIndex: number;

                const GET_OPERATION_NAME = (operation: deploy_targets.TargetOperation) => {
                    let operationName = deploy_helpers.toStringSafe(operation.name).trim();
                    if ('' === operationName) {
                        operationName = deploy_helpers.normalizeString(operation.type);
                        if ('' === operationName) {
                            operationName = deploy_targets.DEFAULT_OPERATION_TYPE;
                        }

                        operationName += ' #' + (operationIndex + 1);
                    }

                    return operationName;
                };

                // beforeDeploy
                operationIndex = -1;
                ME.output.appendLine('');
                const BEFORE_DEPLOY_ABORTED = !deploy_helpers.toBooleanSafe(
                    await deploy_targets.executeTargetOperations({
                        cancellationToken: progress.cancellationToken,
                        files: FILES_TO_UPLOAD.map(ftu => {
                            return ftu.path + '/' + ftu.name;
                        }),
                        onBeforeExecute: async (operation) => {
                            ++operationIndex;

                            ME.output.append(
                                `⚡ ` + ME.t('targets.operations.runningBeforeDeploy',
                                            GET_OPERATION_NAME(operation))
                            );

                            if (CANCELLATION_SOURCE.token.isCancellationRequested) {
                                ME.output.appendLine(`✖️`);
                            }
                            else {
                                START_WATCH();
                            }
                        },
                        onExecutionCompleted: async (operation, err, doesContinue) => {
                            if (err) {
                                ME.output.append(`🔥: '${ deploy_helpers.toStringSafe(err) }'`);
                            }
                            else {
                                ME.output.append(`✅`);
                            }

                            STOP_WATCH();
                        },
                        operation: deploy_targets.TargetOperationEvent.BeforeDeploy,
                        target: target,
                    })
                , true);
                if (BEFORE_DEPLOY_ABORTED) {
                    SHOW_CANCELED_BY_OPERATIONS_MESSAGE();
                    continue;
                }

                await Promise.resolve(
                    PI.uploadFiles(CTX)
                );

                // deployed
                operationIndex = -1;
                const AFTER_DEPLOY_ABORTED = !deploy_helpers.toBooleanSafe(
                    await deploy_targets.executeTargetOperations({
                        cancellationToken: progress.cancellationToken,
                        files: FILES_TO_UPLOAD.map(ftu => {
                            return ftu.path + '/' + ftu.name;
                        }),
                        onBeforeExecute: async (operation) => {
                            ++operationIndex;

                            ME.output.append(
                                `⚡ ` + ME.t('targets.operations.runningAfterDeployed',
                                            GET_OPERATION_NAME(operation))
                            );

                            if (CANCELLATION_SOURCE.token.isCancellationRequested) {
                                ME.output.appendLine(`✖️`);
                            }
                            else {
                                START_WATCH();
                            }
                        },
                        onExecutionCompleted: async (operation, err, doesContinue) => {
                            if (err) {
                                ME.output.append(`🔥: '${ deploy_helpers.toStringSafe(err) }'`);
                            }
                            else {
                                ME.output.append(`✅`);
                            }

                            STOP_WATCH();
                        },
                        operation: deploy_targets.TargetOperationEvent.AfterDeployed,
                        target: target,
                    })
                , true);
                if (AFTER_DEPLOY_ABORTED) {
                    SHOW_CANCELED_BY_OPERATIONS_MESSAGE();
                    continue;
                }

                if (files.length > 1) {
                    ME.output.appendLine('');
                    ME.output.appendLine(
                        `🚀 ` +
                        ME.t('deploy.finishedOperation',
                             TARGET_NAME)
                    );
                }

                UPDATE_FINISHED_BTN(null);
            }
            catch (e) {
                ME.output.appendLine(
                    `🔥 ` + 
                    ME.t('deploy.finishedOperationWithErrors',
                         TARGET_NAME, e)
                );

                POPUP_STATS.failed = files;
                POPUP_STATS.succeeded = [];

                UPDATE_FINISHED_BTN(e);
            }
            finally {
                deploy_helpers.applyFuncFor(
                    deploy_gui.showPopupWhenFinished,
                    ME
                )( POPUP_STATS );                
            }
        }
    }
    finally {
        deploy_helpers.tryDispose(CANCELLATION_SOURCE);
    }
}

/**
 * Deploys a file to a target.
 * 
 * @param {string} file The file to deploy.
 * @param {deploy_targets.Target} target The target to deploy to.
 */
export async function deployFileTo(file: string, target: deploy_targets.Target) {
    const ME: deploy_workspaces.Workspace = this;

    if (ME.isInFinalizeState) {
        return;
    }

    if (!target) {
        return;
    }

    if (!ME.canBeHandledByMe(target)) {
        throw new Error(ME.t('deploy.errors.invalidWorkspace',
                             file, ME.name));
    }

    file = Path.resolve(file);

    await deploy_helpers.applyFuncFor(
        deployFilesTo,
        ME
    )([ file ], target,
      null);
}

/**
 * Deploys a package.
 * 
 * @param {deploy_packages.Package} pkg The package to deploy. 
 * @param {deploy_targets.TargetResolver} targetResolver A function to receive optional targets.
 */
export async function deployPackage(pkg: deploy_packages.Package, targetResolver: deploy_targets.TargetResolver) {
    const ME: deploy_workspaces.Workspace = this;

    if (ME.isInFinalizeState) {
        return;
    }

    if (!pkg) {
        return;
    }

    const PACKAGE_BTN = pkg.__button;
    try {
        if (PACKAGE_BTN) {
            PACKAGE_BTN.hide();
        }

        if (!ME.canBeHandledByMe(pkg)) {
            throw new Error(ME.t('pull.errors.invalidWorkspaceForPackage',
                                 deploy_packages.getPackageName(pkg), ME.name));
        }

        const RELOADER = async () => {
            const FILES_FROM_FILTER = await ME.findFilesByFilter(
                deploy_packages.preparePackageForFileFilter(pkg)
            );
            
            await deploy_packages.importPackageFilesFromGit(
                pkg,
                deploy_contracts.DeployOperation.Deploy,
                FILES_FROM_FILTER,
            );

            return FILES_FROM_FILTER;
        };

        const FILES_TO_DEPLOY = await RELOADER();
        if (FILES_TO_DEPLOY.length < 1) {
            ME.showWarningMessage(
                ME.t('noFiles')
            );

            return;
        }

        const TARGETS = deploy_helpers.applyFuncFor(deploy_packages.getTargetsOfPackage, ME)(
            pkg, targetResolver
        );
        if (false === TARGETS) {
            return;
        }

        const SELECTED_TARGET = await deploy_targets.showTargetQuickPick(
            ME.context.extension,
            TARGETS.filter(t => deploy_targets.isVisibleForPackage(t, pkg)),
            {
                placeHolder: ME.t('deploy.selectTarget'),
            }
        );
        if (!SELECTED_TARGET) {
            return;
        }

        await deploy_helpers.applyFuncFor(
            deployFilesTo, ME
        )(FILES_TO_DEPLOY,
          SELECTED_TARGET,
          RELOADER);
    }
    finally {
        if (PACKAGE_BTN) {
            PACKAGE_BTN.show();
        }
    }
}

/**
 * Deploys a file when is has been changed.
 * 
 * @param {string} file The file to check. 
 */
export async function deployOnChange(file: string) {
    const WORKSPACE: deploy_workspaces.Workspace = this;

    if (WORKSPACE.isInFinalizeState) {
        return;
    }

    const CFG = WORKSPACE.config;
    if (!CFG) {
        return;
    }
    
    const STATE = WORKSPACE.workspaceSessionState;
    if (!STATE) {
        return;
    }

    const KEY = Path.resolve(file);

    const FILES_IN_PROGRESS = STATE['auto']['deploy']['on_change_or_save'];

    if (true === FILES_IN_PROGRESS[KEY]) {
        return;
    }

    FILES_IN_PROGRESS[KEY] = true;
    const RESTORE_IN_PROGRESS_STATE = () => {
        delete FILES_IN_PROGRESS[KEY];
    };

    let pauseFilesFor: number;
    const FINISHED = async () => {
        deploy_helpers.tryDisposeAndDelete(STATE['auto'], deploy_packages.KEY_PAUSE_FILES_FOR);

        if (isNaN(pauseFilesFor)) {
            RESTORE_IN_PROGRESS_STATE();
        }
        else {
            STATE['auto'][ deploy_packages.KEY_PAUSE_FILES_FOR ] = deploy_helpers.createTimeout(() => {
                RESTORE_IN_PROGRESS_STATE();
            }, pauseFilesFor);
        }
    };

    try {
        const OPTS: deploy_packages.AutoDeployFileOptions = {
            file: file,
            settingsResolver: (pkg) => pkg.deployOnChange,
            fastFileCheckFlagResolver: (pkg) => {
                return deploy_packages.getFastFileCheckFlag(
                    pkg, (p) => p.fastCheckOnChange,
                    CFG, (c) => c.fastCheckOnChange,
                );
            },
            errorMsgTemplate: 'deploy.onChange.failed',
            prepareForPackage: (pkg) => {
                pauseFilesFor = deploy_packages.getPauseFilesForValue(pkg, pauseFilesFor);
            },
        };
    
        await deploy_helpers.applyFuncFor(
            deploy_packages.autoDeployFile, WORKSPACE
        )(OPTS);
    }
    finally {
        await FINISHED();
    }
}

/**
 * Deploys a file when is has been saved.
 * 
 * @param {string} file The file to check. 
 */
export async function deployOnSave(file: string) {
    const WORKSPACE: deploy_workspaces.Workspace = this;

    if (WORKSPACE.isInFinalizeState) {
        return;
    }

    const CFG = WORKSPACE.config;
    if (!CFG) {
        return;
    }

    const STATE = WORKSPACE.workspaceSessionState;
    if (!STATE) {
        return;
    }

    const KEY = Path.resolve(file);
    
    const FILES_IN_PROGRESS = STATE['auto']['deploy']['on_change_or_save'];

    if (true === FILES_IN_PROGRESS[KEY]) {
        return;
    }

    FILES_IN_PROGRESS[KEY] = true;
    const RESTORE_IN_PROGRESS_STATE = () => {
        delete FILES_IN_PROGRESS[KEY];
    };

    let pauseFilesFor: number;
    const FINISHED = async () => {
        deploy_helpers.tryDisposeAndDelete(STATE['auto'], deploy_packages.KEY_PAUSE_FILES_FOR);

        if (isNaN(pauseFilesFor)) {
            RESTORE_IN_PROGRESS_STATE();
        }
        else {
            STATE['auto'][ deploy_packages.KEY_PAUSE_FILES_FOR ] = deploy_helpers.createTimeout(() => {
                RESTORE_IN_PROGRESS_STATE();
            }, pauseFilesFor);
        }
    };

    try {
        const OPTS: deploy_packages.AutoDeployFileOptions = {
            file: file,
            settingsResolver: (pkg) => pkg.deployOnSave,
            fastFileCheckFlagResolver: (pkg) => {
                return deploy_packages.getFastFileCheckFlag(
                    pkg, (p) => p.fastCheckOnSave,
                    CFG, (c) => c.fastCheckOnSave,
                );
            },
            errorMsgTemplate: 'deploy.onSave.failed',
            prepareForPackage: (pkg) => {
                pauseFilesFor = deploy_packages.getPauseFilesForValue(pkg, pauseFilesFor);
            },
        };
    
        await deploy_helpers.applyFuncFor(
            deploy_packages.autoDeployFile, WORKSPACE
        )(OPTS);
    }
    finally {
        await FINISHED();
    }
}

/**
 * Deploys a commit of a SCM client.
 * 
 * @param {deploy_scm.SourceControlClient} client The scm client.
 * @param {deploy_targets.Target} target The target to deploy to.
 */
export async function deployScmCommit(client: deploy_scm.SourceControlClient,
                                      target: deploy_targets.Target) {
    if (!client) {
        return;
    }

    const ME: deploy_workspaces.Workspace = this;

    const COMMIT = await deploy_scm.showSCMCommitQuickPick(client);
    if (!COMMIT) {
        return;
    }

    const CHANGES = await Promise.resolve( COMMIT.changes() );

    let branch: string;
    if (COMMIT.branch) {
        branch = COMMIT.branch.id;
    }
    branch = deploy_helpers.normalizeString(branch);

    const STORAGE_KEY = Crypto.createHash('sha256')
                              .update(branch)
                              .digest('hex');

    let filterStorage: ScmFileFilterStorage = ME.state.get<ScmFileFilterStorage>(KEY_SCM_COMMIT_FILE_FILTERS);
    if (!_.isPlainObject(filterStorage)) {
        filterStorage = {};
    }

    let fileFilters: ScmFileFilter = filterStorage[STORAGE_KEY];
    if (!_.isPlainObject(fileFilters)) {
        fileFilters = {};
    }
    fileFilters = {
        files: deploy_helpers.asArray(fileFilters.files)
                             .map(f => deploy_helpers.toStringSafe(f))
                             .filter(f => !deploy_helpers.isEmptyString(f)),
        exclude: deploy_helpers.asArray(fileFilters.exclude)
                               .map(e => deploy_helpers.toStringSafe(e))
                               .filter(e => !deploy_helpers.isEmptyString(e)),
    };

    // ask for files to include
    const FILES_TO_INCLUDE = await vscode.window.showInputBox({
        placeHolder: ME.t('deploy.gitCommit.patterns.askForFilesToInclude.placeHolder'),
        prompt: ME.t('deploy.gitCommit.patterns.askForFilesToInclude.prompt'),
        value: fileFilters.files.join(';'),
    });
    if (_.isNil(FILES_TO_INCLUDE)) {
        return;
    }

    let fileToIncludePatterns = FILES_TO_INCLUDE.split(';').filter(p => {
        return !deploy_helpers.isEmptyString(p);
    });
    fileFilters.files = fileToIncludePatterns.map(p => p);

    if (fileToIncludePatterns.length < 1) {
        fileToIncludePatterns.push('**');
    }

    // ask for files to exclude
    const FILES_TO_EXCLUDE = await vscode.window.showInputBox({
        placeHolder: ME.t('deploy.gitCommit.patterns.askForFilesToExclude.placeHolder'),
        prompt: ME.t('deploy.gitCommit.patterns.askForFilesToExclude.prompt'),
        value: fileFilters.exclude.join(';'),
    });
    if (_.isNil(FILES_TO_EXCLUDE)) {
        return;
    }

    let filesToExcludePatterns = FILES_TO_EXCLUDE.split(';').filter(p => {
        return !deploy_helpers.isEmptyString(p);
    });
    fileFilters.exclude = filesToExcludePatterns.map(p => p);

    try {    
        const FILES_TO_DELETE: string[] = [];
        const FILES_TO_UPLOAD: string[] = [];
        for (const C of CHANGES) {
            const FILE = deploy_helpers.toStringSafe(C.file);
            if (deploy_helpers.isEmptyString(FILE)) {
                continue;
            }

            if (!deploy_helpers.checkIfDoesMatchByFileFilter('/' + FILE,
                                                             deploy_helpers.toMinimatchFileFilter(fileFilters))) {
                continue;  // does not match pattern(s)
            }

            const FULL_PATH = Path.resolve(
                Path.join(
                    ME.rootPath,
                    FILE,
                )
            );

            switch (C.type) {
                case deploy_scm.FileChangeType.Added:
                case deploy_scm.FileChangeType.Modified:
                    FILES_TO_UPLOAD.push( FULL_PATH );
                    break;

                case deploy_scm.FileChangeType.Deleted:
                    FILES_TO_DELETE.push( FULL_PATH );
                    break;
            }
        }

        // first delete files
        if (FILES_TO_DELETE.length > 0) {
            await deploy_helpers.applyFuncFor(
                deploy_delete.deleteFilesIn,
                ME,
            )(FILES_TO_DELETE, target,
              null,
              false);
        }

        // then upload files
        if (FILES_TO_UPLOAD.length > 0) {
            await deploy_helpers.applyFuncFor(
                deployFilesTo,
                ME,
            )(FILES_TO_UPLOAD, target,
              null);
        }
    }
    finally {
        filterStorage[STORAGE_KEY] = fileFilters;

        ME.state.update(KEY_SCM_COMMIT_FILE_FILTERS, filterStorage).then(() => {
        }, (err) => {
            deploy_log.CONSOLE
                      .trace(err, 'deploy.deployScmCommit(1)');
        });
    }
}

/**
 * Deploys uncommited changes of a SCM client.
 * 
 * @param {deploy_scm.SourceControlClient} client The scm client.
 * @param {deploy_targets.Target} target The target to deploy to.
 */
export async function deployUncommitedScmChanges(client: deploy_scm.SourceControlClient,
                                                 target: deploy_targets.Target) {
    if (!client) {
        return;
    }

    const ME: deploy_workspaces.Workspace = this;

    const CHANGES = await client.changes();
    if (!CHANGES) {
        return;
    }

    const FILES_TO_DELETE: string[] = [];
    const FILES_TO_UPLOAD: string[] = [];
    for (const C of CHANGES) {
        const FILE = deploy_helpers.toStringSafe(C.file);
        if (deploy_helpers.isEmptyString(FILE)) {
            continue;
        }

        const FULL_PATH = Path.resolve(
            Path.join(
                client.cwd,
                FILE,
            )
        );

        switch (C.type) {
            case deploy_scm.FileChangeType.Added:
            case deploy_scm.FileChangeType.Modified:
                FILES_TO_UPLOAD.push( FULL_PATH );
                break;

            case deploy_scm.FileChangeType.Deleted:
                FILES_TO_DELETE.push( FULL_PATH );
                break;
        }
    }

    // first delete files
    if (FILES_TO_DELETE.length > 0) {
        await deploy_helpers.applyFuncFor(
            deploy_delete.deleteFilesIn,
            ME,
        )(FILES_TO_DELETE, target,
          null,
          false);
    }

    // then upload files
    if (FILES_TO_UPLOAD.length > 0) {
        await deploy_helpers.applyFuncFor(
            deployFilesTo,
            ME,
        )(FILES_TO_UPLOAD, target,
          null);
    }
}

/**
 * Registers commands for deploy operations.
 * 
 * @param {vscode.ExtensionContext} context The extension context.
 */
export function registerDeployCommands(context: vscode.ExtensionContext) {
    context.subscriptions.push(
        // deploy
        vscode.commands.registerCommand('extension.deploy.reloaded.deploy', async () => {
            try {
                const QUICK_PICKS: deploy_contracts.ActionQuickPick[] = [
                    {
                        action: async () => {
                            await vscode.commands.executeCommand('extension.deploy.reloaded.deployFile');
                        },
                        label: '$(rocket)  ' + i18.t('deploy.currentFile.label'),
                        description: i18.t('deploy.currentFile.description'),
                    },
                    {
                        action: async () => {
                            await vscode.commands.executeCommand('extension.deploy.reloaded.deployWorkspace');
                        },
                        label: '$(rocket)  ' + i18.t('deploy.package.label'),
                        description: i18.t('deploy.package.description'),
                    },
                    {
                        action: async () => {
                            await vscode.commands.executeCommand('extension.deploy.reloaded.deployAllOpenFiles');
                        },
                        label: '$(rocket)  ' + i18.t('deploy.allOpenFiles.label'),
                        description: i18.t('deploy.allOpenFiles.description'),
                    },
                    {
                        action: async () => {
                            await vscode.commands.executeCommand('extension.deploy.reloaded.deployGitCommit');
                        },
                        label: '$(git-commit)  ' + i18.t('deploy.gitCommit.label'),
                        description: i18.t('deploy.gitCommit.description'),
                    },
                    {
                        action: async () => {
                            await vscode.commands.executeCommand('extension.deploy.reloaded.deployUncomittedGitFiles');
                        },
                        label: '$(git-commit)  ' + i18.t('deploy.uncomittedGitFiles.label'),
                        description: i18.t('deploy.uncomittedGitFiles.description'),
                    },
                    {
                        action: async () => {
                            await vscode.commands.executeCommand('extension.deploy.reloaded.deployFileList');
                        },
                        label: '$(list-ordered)  ' + i18.t('deploy.fileList.label'),
                        description: i18.t('deploy.fileList.description'),
                    }
                ];

                const SELECTED_ITEM = await vscode.window.showQuickPick(QUICK_PICKS);
                if (SELECTED_ITEM) {
                    await Promise.resolve(
                        SELECTED_ITEM.action()
                    );
                }
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deploy');

                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy file list
        vscode.commands.registerCommand('extension.deploy.reloaded.deployFileList', async () => {
            try {
                await deployFileList(context);
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deployFileList');
                
                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy workspace
        vscode.commands.registerCommand('extension.deploy.reloaded.deployWorkspace', async () => {
            try {
                const PKG = await deploy_packages.showPackageQuickPick(
                    context,
                    deploy_packages.getAllPackagesSorted(),
                    {
                        placeHolder: i18.t('packages.selectPackage'),
                    }
                );

                if (PKG) {
                    await PKG.__workspace
                             .deployPackage(PKG);
                }
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deployWorkspace');
                
                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy current file
        vscode.commands.registerCommand('extension.deploy.reloaded.deployFile', async () => {
            try {
                await deploy_targets.invokeForActiveEditorAndTarget(
                    i18.t('targets.selectTarget'),
                    async (file, target) => {
                        await target.__workspace
                                    .deployFileTo(file, target);
                    }
                );
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deployFile');
                
                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy all open files
        vscode.commands.registerCommand('extension.deploy.reloaded.deployAllOpenFiles', async () => {
            try {
                await deployAllOpenFiles(
                    deploy_workspaces.getActiveWorkspaces()
                );
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deployAllOpenFiles');
                
                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy git commit
        vscode.commands.registerCommand('extension.deploy.reloaded.deployGitCommit', async () => {
            try {
                const WORKSPACE = await deploy_workspaces.showWorkspaceQuickPick(
                    context,
                    deploy_workspaces.getActiveWorkspaces(),
                    {
                        placeHolder: i18.t('workspaces.selectWorkspace')
                    }
                );

                if (!WORKSPACE) {
                    return;
                }

                const TARGET = await WORKSPACE.showTargetQuickPick();
                if (!TARGET) {
                    return;
                }

                await WORKSPACE.deployGitCommit(TARGET);
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deployGitCommit');
                
                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy uncommited git files
        vscode.commands.registerCommand('extension.deploy.reloaded.deployUncomittedGitFiles', async () => {
            try {
                const WORKSPACE = await deploy_workspaces.showWorkspaceQuickPick(
                    context,
                    deploy_workspaces.getActiveWorkspaces(),
                    {
                        placeHolder: i18.t('workspaces.selectWorkspace')
                    }
                );

                if (!WORKSPACE) {
                    return;
                }

                const TARGET = await WORKSPACE.showTargetQuickPick();
                if (!TARGET) {
                    return;
                }

                await WORKSPACE.deployUncomittedGitChanges(TARGET);
            }
            catch (e) {
                deploy_log.CONSOLE
                          .trace(e, 'extension.deploy.reloaded.deployUncomittedGitFiles');
                
                deploy_helpers.showErrorMessage(
                    i18.t('deploy.errors.operationFailed')
                );
            }
        }),

        // deploy package files
        vscode.commands.registerCommand('extension.deploy.reloaded.deployPackageFiles', async (packageNames: string | string[], targetNames: string | string[]) => {
            packageNames = deploy_helpers.asArray( packageNames ).map(p => {
                return deploy_helpers.normalizeString(p);
            }).filter(p => '' !== p);

            targetNames = deploy_helpers.asArray( targetNames ).map(t => {
                return deploy_helpers.normalizeString(t);
            }).filter(t => '' !== t);

            const ALL_WORKSPACES = deploy_workspaces.getAllWorkspaces();

            for (const PN of packageNames) {
                const MATCHING_PACKAGES = deploy_helpers.from( ALL_WORKSPACES ).selectMany(ws => {
                    return ws.getPackages();
                }).where(p => {
                    return PN === deploy_helpers.normalizeString(p.name);
                });

                for (const MP of MATCHING_PACKAGES) {
                    try {
                        await deploy_helpers.applyFuncFor(
                            deployPackage, MP.__workspace
                        )(MP, () => targetNames);
                    }
                    catch (e) {
                        deploy_log.CONSOLE
                                  .trace(e, 'extension.deploy.reloaded.deployPackageFiles(1)');
                    }
                }
            }
        }),
    );
}

async function saveBeforeDeploy(target: deploy_targets.Target, files: string[]) {
    const ME: deploy_workspaces.Workspace = this;

    const CFG = ME.config;
    if (!CFG) {
        return;
    }

    if (!deploy_helpers.toBooleanSafe(CFG.saveBeforeDeploy, true)) {
        return;
    }

    const DIRTY_TEXT_EDITORS = Enumerable.from(deploy_helpers.asArray(vscode.window.visibleTextEditors)).where(te => {
        return te.document &&
               !te.document.isUntitled &&
               !deploy_helpers.isEmptyString(te.document.fileName) &&
               te.document.isDirty;
    }).toArray();
    if (DIRTY_TEXT_EDITORS.length < 1) {
        return;
    }

    let matchingEditors: vscode.TextEditor[] = [];

    for (const F of files) {
        const FILE_URI = vscode.Uri.file(F);

        for (const DTE of DIRTY_TEXT_EDITORS) {
            const EDITOR_URI = vscode.Uri.file(DTE.document.fileName);
            if (EDITOR_URI.fsPath === FILE_URI.fsPath) {
                matchingEditors.push( DTE );
            }
        }
    }

    matchingEditors = Enumerable.from(matchingEditors)
                                .distinct(true)
                                .toArray();
    if (matchingEditors.length < 1) {
        return;
    }

    for (const TE of matchingEditors) {
        await TE.document.save();
    }
}
