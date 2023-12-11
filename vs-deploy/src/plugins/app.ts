/// <reference types="node" />

// The MIT License (MIT)
// 
// vs-deploy (https://github.com/mkloubert/vs-deploy)
// Copyright (c) Marcel Joachim Kloubert <marcel.kloubert@gmx.net>
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to
// deal in the Software without restriction, including without limitation the
// rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
// sell copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
// FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.

import * as deploy_contracts from '../contracts';
import * as deploy_helpers from '../helpers';
import * as deploy_objects from '../objects';
import * as deploy_values from '../values';
import * as deploy_workspace from '../workspace';
import * as i18 from '../i18';
import * as Path from 'path';
import * as vscode from 'vscode';


interface DeployTargetApp extends deploy_contracts.DeployTarget, deploy_contracts.ProcessObject {
    app?: string;
    arguments?: string | string[];
    separator?: string;
    submitFileList?: boolean;
    wait?: boolean;
    runInTerminal?: boolean;
}

function createAppArgsList(file: string, app: string, args: string[]): string[] {
    file = deploy_helpers.toStringSafe(file);

    if (app) {
        if (!Path.isAbsolute(app)) {
            app = Path.join(deploy_workspace.getRootPath(), app);
        }
    }
    
    if (!args) {
        args = [];
    }

    args = args.map(x => {
                        x = deploy_helpers.toStringSafe(x);
                        x = deploy_helpers.replaceAllStrings(x, '${file}', file);

                        return x;
                    });

    return [ app ].concat(args)
                  .filter(x => x);
}

class AppPlugin extends deploy_objects.MultiFileDeployPluginBase {
    /** @inheritdoc */
    public deployWorkspace(files: string[], target: DeployTargetApp, opts?: deploy_contracts.DeployWorkspaceOptions) {
        let me = this;
        
        if (!opts) {
            opts = {};
        }

        let completed = (err?: any) => {
            files.forEach(x => {
                if (opts.onBeforeDeployFile) {
                    opts.onBeforeDeployFile(me, {
                        destination: app,
                        file: x,
                        target: target,
                    });
                }

                if (opts.onFileCompleted) {
                    opts.onFileCompleted(me, {
                        error: err,
                        file: x,
                        target: target,
                    });
                }
            });

            if (opts.onCompleted) {
                opts.onCompleted(me, {
                    error: err,
                    target: target,
                });
            }
        };

        let app = deploy_helpers.toStringSafe(target.app);
        app = me.context.replaceWithValues(app);

        let submitTheListOfFiles = deploy_helpers.toBooleanSafe(target.submitFileList, true);
        let waitForApp = deploy_helpers.toBooleanSafe(target.wait);

        if (deploy_helpers.toBooleanSafe(target.runInTerminal)) {
            // run in terminal

            let args = deploy_helpers.asArray(target.arguments)
                                     .map(x => deploy_helpers.toStringSafe(x))
                                     .filter(x => x);

            if (submitTheListOfFiles) {
                args = args.concat(files);
            }

            let terminalName = '[vs-deploy]';
            if (!deploy_helpers.isEmptyString(target.name)) {
                terminalName += ' ' + deploy_helpers.toStringSafe(target.name).trim();
            }

            if (!Path.isAbsolute(app)) {
                app = Path.join(deploy_workspace.getRootPath(), app);
            }
            app = Path.resolve(app);

            let terminal = vscode.window.createTerminal(terminalName,
                                                        app, args);
            terminal.show();
        }
        else {
            let firstFile = files[0];
            let nextFiles = files.filter((x, i) => i > 0);

            let args = [];
            if (target.arguments) {
                args = args.concat(deploy_helpers.asArray(target.arguments));
            }

            if (submitTheListOfFiles) {
                args = args.concat(nextFiles)
                           .filter(x => x);
            }

            let separator = deploy_helpers.toStringSafe(target.separator);
            if ('' === separator) {
                separator = ' ';
            }

            let appOpts: any;
            let firstAppArg: any;
            if (submitTheListOfFiles) {
                firstAppArg = firstFile;
                appOpts = createAppArgsList(nextFiles.join(separator), app, args);
            }
            else {
                if (args.length < 1) {
                    firstAppArg = app;
                }
                else {
                    firstAppArg = args[0];
                    appOpts = createAppArgsList(nextFiles.join(separator), app,
                                                args.filter((x, i) => i > 0));
                }
            }

            deploy_helpers.open(firstAppArg, {
                app: appOpts,
                env: deploy_helpers.makeEnvVarsForProcess(target, <deploy_values.ValueBase[]>me.context.values()),
                wait: waitForApp,
            }).then(() => {
                completed();
            }).catch((err) => {
                completed(err);
            });
        }
    }

    public info(): deploy_contracts.DeployPluginInfo {
        return {
            description: i18.t('plugins.app.description'),
        };
    }
}

/**
 * Creates a new Plugin.
 * 
 * @param {deploy_contracts.DeployContext} ctx The deploy context.
 * 
 * @returns {deploy_contracts.DeployPlugin} The new instance.
 */
export function createPlugin(ctx: deploy_contracts.DeployContext): deploy_contracts.DeployPlugin {
    return new AppPlugin(ctx);
}
