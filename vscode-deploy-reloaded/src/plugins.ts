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
import * as deploy_clients from './clients';
import * as deploy_contracts from './contracts';
import * as deploy_files from './files';
import * as deploy_helpers from './helpers';
import * as deploy_targets from './targets';
import * as deploy_transformers from './transformers';
import * as deploy_values from './values';
import * as deploy_workspaces from './workspaces';
import * as i18 from './i18';
import * as Stream from 'stream';
import * as vscode from 'vscode';


/**
 * A function / method that is called BEFORE a file is going to be deleted.
 * 
 * @param {string} [destination] The custom destination to display.
 */
export type BeforeDeleteFileCallback = (destination?: string) => PromiseLike<void>;

/**
 * A function / method that is called BEFORE a file is going to be downloaded.
 * 
 * @param {string} [source] The custom source to display.
 */
export type BeforeDownloadFileCallback = (source?: string) => PromiseLike<void>;

/**
 * A function / method that is called BEFORE a folder is going to be removed.
 * 
 * @param {string} [destination] The custom destination to display.
 */
export type BeforeRemoveFolderCallback = (destination?: string) => PromiseLike<void>;

/**
 * A function / method that is called BEFORE a file is going to be uploaded.
 * 
 * @param {string} [destination] The custom destination to display.
 */
export type BeforeUploadFileCallback = (destination?: string) => PromiseLike<void>;

/**
 * A delete context.
 */
export interface DeleteContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends FilesContext<TTarget> {
    /**
     * The files to delete.
     */
    readonly files: FileToDelete[];
}

/**
 * A function / method that is called AFTER a delete operation for a file has been finished.
 * 
 * @param {any} [err] The error (if occurred).
 * @param {boolean} [deleteLocal] Tells the calling "client" that it should delete its local version or not.
 */
export type DeleteFileCompletedCallback = (err?: any, deleteLocal?: boolean) => PromiseLike<void>;

/**
 * A download context.
 */
export interface DownloadContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends FilesContext<TTarget> {
    /**
     * The files to download.
     */
    readonly files: FileToDownload[];
}

/**
 * A downloaded file.
 */
export interface DownloadedFile extends vscode.Disposable, deploy_contracts.WithNameAndPath {
    /**
     * Reads the whole content of the file.
     * 
     * @return {PromiseLike<Buffer>} The read data.
     */
    readonly read: () => Buffer | PromiseLike<Buffer>;
}

/**
 * A function / method that is called AFTER a download operation for a file has been finished.
 * 
 * @param {any} err The error (if occurred).
 * @param {DownloadedFile|Buffer|string|Stream.Stream} [file] The downloaded file (if available).
 */
export type DownloadFileCompletedCallback = (err: any, file?: DownloadedFile | Buffer | string | Stream.Stream) => PromiseLike<void>;

/**
 * A context for handling files.
 */
export interface FilesContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends TargetContext<TTarget> {
}

/**
 * A file to delete.
 */
export interface FileToDelete extends deploy_workspaces.WorkspaceFile {
    /**
     * The method that should be invoked BEFORE a deletion of that file starts.
     */
    readonly onBeforeDelete: BeforeDeleteFileCallback;
    /**
     * The method that should be invoked AFTER a deletion of that file has been finished.
     */
    readonly onDeleteCompleted: DeleteFileCompletedCallback;
}

/**
 * A file to download.
 */
export interface FileToDownload extends deploy_workspaces.WorkspaceFile {
    /**
     * The method that should be invoked BEFORE a download of that file starts.
     */
    readonly onBeforeDownload: BeforeDownloadFileCallback;
    /**
     * The method that should be invoked AFTER a download of that file has been finished.
     */
    readonly onDownloadCompleted: DownloadFileCompletedCallback;
}

/**
 * A file to upload.
 */
export interface FileToUpload extends deploy_workspaces.WorkspaceFile {
    /**
     * The method that should be invoked BEFORE an upload of that file starts.
     * 
     * @param {string} [destination] A custom value for the destination.
     */
    readonly onBeforeUpload: BeforeUploadFileCallback;
    /**
     * The method that should be invoked AFTER an upload of that file has been finished.
     * 
     * @param {any} [err] The error (if occurred).
     */
    readonly onUploadCompleted: UploadFileCompletedCallback;
    /**
     * Reads the complete content of that file async.
     * 
     * @return {PromiseLike<Buffer>} The promise with the loaded data.
     */
    readonly read: () => PromiseLike<Buffer>;
}

/**
 * A folder to remove.
 */
export interface FolderToRemove extends deploy_workspaces.WorkspaceDirectory {
    /**
     * The method that should be invoked BEFORE the folder is going to be removed.
     */
    readonly onBeforeRemove: BeforeRemoveFolderCallback;
    /**
     * The method that should be invoked AFTER the folder has been removed.
     */
    readonly onRemoveCompleted: RemoveFolderCompletedCallback;
}

/**
 * The result for the 'initialize' method of a plugin.
 */
export type InitializePluginResult = boolean | void;

/**
 * A context for listening a directory.
 */
export interface ListDirectoryContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends TargetContext<TTarget>, deploy_workspaces.WorkspaceItem {
    /**
     * The directory to list.
     */
    readonly dir?: string;
}

/**
 * A 'list directory' result.
 */
export interface ListDirectoryResult<TTarget extends deploy_targets.Target = deploy_targets.Target>
    extends deploy_files.WithDirectoriesAndFiles
{
    /**
     * Information about the underlying directory itself.
     */
    readonly info: deploy_files.DirectoryInfo;
    /**
     * The other / unknown elements.
     */
    readonly others: deploy_files.FileSystemInfo[];
    /**
     * The underlying target.
     */
    readonly target: TTarget;
}

/**
 * Result type of new plugins.
 */
export type NewPlugins = Plugin | PromiseLike<Plugin> | Plugin[] | PromiseLike<Plugin[]>;

/**
 * A plugin.
 */
export interface Plugin<TTarget extends deploy_targets.Target = deploy_targets.Target> extends NodeJS.EventEmitter, vscode.Disposable {
    /**
     * [INTERNAL] DO NOT DEFINE OR OVERWRITE THIS PROPERTY BY YOUR OWN!
     * 
     * Gets the filename of the plugin.
     */
    __file?: string;
    /**
     * [INTERNAL] DO NOT DEFINE OR OVERWRITE THIS PROPERTY BY YOUR OWN!
     * 
     * Gets the full path of the plugin's file.
     */
    __filePath?: string;
    /**
     * [INTERNAL] DO NOT DEFINE OR OVERWRITE THIS PROPERTY BY YOUR OWN!
     * 
     * Gets the index of the plugin.
     */
    __index?: number;
    /**
     * [INTERNAL] DO NOT DEFINE OR OVERWRITE THIS PROPERTY BY YOUR OWN!
     * 
     * Gets the type of the plugin.
     */
    __type?: string;

    /**
     * Gets if the plugin can delete files or not.
     */
    readonly canDelete?: boolean;
    /**
     * Gets if the plugin can download files or not.
     */
    readonly canDownload?: boolean;
    /**
     * Gets if the plugin can list directories or not.
     */
    readonly canList?: boolean;
    /**
     * Gets if the plugin can remove whole folders or not.
     */
    readonly canRemoveFolders?: boolean;
    /**
     * Gets if the plugin can upload files or not.
     */
    readonly canUpload?: boolean;
    /**
     * Initializes the plugin.
     * 
     * @return {InitializePluginResult|PromiseLike<InitializePluginResult>} The result.
     */
    readonly initialize?: () => InitializePluginResult | PromiseLike<InitializePluginResult>;
    /**
     * Deletes files.
     * 
     * @param {DeleteContext<TTarget>} The context.
     */
    readonly deleteFiles?: (context: DeleteContext<TTarget>) => void | PromiseLike<void>;
    /**
     * Downloads files.
     * 
     * @param {DownloadContext<TTarget>} The context.
     */
    readonly downloadFiles?: (context: DownloadContext<TTarget>) => void | PromiseLike<void>;
    /**
     * List a directory.
     * 
     * @param {ListDirectoryContext<TTarget>} The context.
     * 
     * @return {ListDirectoryResult<TTarget>|PromiseLike<ListDirectoryResult<TTarget>>} The result.
     */
    readonly listDirectory?: (context: ListDirectoryContext<TTarget>) => ListDirectoryResult<TTarget> | PromiseLike<ListDirectoryResult<TTarget>>;
    /**
     * Removes folders.
     * 
     * @param {RemoveFoldersContext<TTarget>} The context.
     */
    readonly removeFolders?: (context: RemoveFoldersContext<TTarget>) => void | PromiseLike<void>;
    /**
     * Uploads files.
     * 
     * @param {UploadContext<TTarget>} The context.
     */
    readonly uploadFiles?: (context: UploadContext<TTarget>) => void | PromiseLike<void>;
}

/**
 * A plugin context.
 */
export interface PluginContext {
    /**
     * The output channel for that plugin.
     */
    readonly outputChannel: vscode.OutputChannel;
}

/**
 * A plugin module.
 */
export interface PluginModule {
    /**
     * Creates new plugins.
     * 
     * @param {context: PluginContext} The context of that plugin.
     * 
     * @return {NewPlugins} The new plugins.
     */
    readonly createPlugins: (context: PluginContext) => NewPlugins;
}

/**
 * A result for preparing a base target.
 */
export type PrepareBaseTargetResult<TTarget = deploy_targets.Target> = TTarget | false;

/**
 * A result for preparing targets.
 */
export type PrepareTargetsResult = deploy_targets.Target | deploy_targets.Target[] | false;

/**
 * A function / method that is called AFTER a delete operation for a folder has been finished.
 * 
 * @param {any} [err] The error (if occurred).
 * @param {boolean} [deleteLocal] Tells the calling "client" that it should delete its local version or not.
 */
export type RemoveFolderCompletedCallback = (err?: any, deleteLocal?: boolean) => PromiseLike<void>;

/**
 * A remove folders context.
 */
export interface RemoveFoldersContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends TargetContext<TTarget> {
    /**
     * A list of one or more folders to remove.
     */
    readonly folders: FolderToRemove[];
}

/**
 * A context based on a target.
 */
export interface TargetContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends deploy_contracts.Cancelable {
    /**
     * Gets the underlying target.
     */
    readonly target: TTarget;
}

/**
 * An upload context.
 */
export interface UploadContext<TTarget extends deploy_targets.Target = deploy_targets.Target> extends FilesContext<TTarget> {
    /**
     * The files to upload.
     */
    readonly files: FileToUpload[];
}

/**
 * A function / method that is called AFTER an upload operation for a file has been finished.
 * 
 * @param {any} [err] The error (if occurred).
 */
export type UploadFileCompletedCallback = (err?: any) => PromiseLike<void>;


/**
 * Wraps another 'FileToDelete' object.
 */
export class FileToDeleteWrapper implements FileToDelete {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {FileToDelete} baseFile The file to wrap.
     */
    constructor(public readonly baseFile: FileToDelete) {
        this.onBeforeDelete = this.baseFile.onBeforeDelete;
        this.onDeleteCompleted = this.baseFile.onDeleteCompleted;
    }

    /** @inheritdoc */
    public get file() {
        return this.baseFile.file;
    }

    /** @inheritdoc */
    public get name() {
        return this.baseFile.name;
    }

    /** @inheritdoc */
    public onBeforeDelete: BeforeDeleteFileCallback;

    /** @inheritdoc */
    public onDeleteCompleted: DeleteFileCompletedCallback;

    /** @inheritdoc */
    public get path() {
        return this.baseFile.path;
    }

    /** @inheritdoc */
    public get workspace() {
        return this.baseFile.workspace;
    }
}

/**
 * Wraps another 'FileToDownload' object.
 */
export class FileToDownloadWrapper implements FileToDownload {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {FileToDownload} baseFile The file to wrap.
     */
    constructor(public readonly baseFile: FileToDownload) {
        this.onBeforeDownload = this.baseFile.onBeforeDownload;
        this.onDownloadCompleted = this.baseFile.onDownloadCompleted;
    }

    /** @inheritdoc */
    public get file() {
        return this.baseFile.file;
    }

    /** @inheritdoc */
    public get name() {
        return this.baseFile.name;
    }

    /** @inheritdoc */
    public onBeforeDownload: BeforeDownloadFileCallback;

    /** @inheritdoc */
    public onDownloadCompleted: DownloadFileCompletedCallback;

    /** @inheritdoc */
    public get path() {
        return this.baseFile.path;
    }

    /** @inheritdoc */
    public get workspace() {
        return this.baseFile.workspace;
    }
}

/**
 * Wraps another 'FileToUpload' object.
 */
export class FileToUploadWrapper implements FileToUpload {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {FileToUpload} baseFile The file to wrap.
     */
    constructor(public readonly baseFile: FileToUpload) {
        this.onBeforeUpload = this.baseFile.onBeforeUpload;
        this.onUploadCompleted = this.baseFile.onUploadCompleted;
    }

    /** @inheritdoc */
    public get file() {
        return this.baseFile.file;
    }

    /** @inheritdoc */
    public get name() {
        return this.baseFile.name;
    }

    /** @inheritdoc */
    public onBeforeUpload: BeforeUploadFileCallback;

    /** @inheritdoc */
    public onUploadCompleted: UploadFileCompletedCallback;

    /** @inheritdoc */
    public get path() {
        return this.baseFile.path;
    }

    /** @inheritdoc */
    public async read() {
        return await this.baseFile.read();
    }

    /** @inheritdoc */
    public get workspace() {
        return this.baseFile.workspace;
    }
}


/**
 * A local file to upload.
 */
export abstract class FileToUploadBase implements FileToUpload {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {deploy_workspaces.Workspace} workspace The underlying workspace.
     * @param {string} file The path to the local file. 
     * @param {deploy_contracts.WithNameAndPath} _NAME_AND_PATH Name and relative path information.
     */
    constructor(public readonly workspace: deploy_workspaces.Workspace,
                public readonly file: string,
                private readonly _NAME_AND_PATH: deploy_contracts.WithNameAndPath) {
    }

    /** @inheritdoc */
    public get name() {
        return this._NAME_AND_PATH.name;
    }

    /** @inheritdoc */
    public onBeforeUpload: BeforeUploadFileCallback = async () => {
    }

    /** @inheritdoc */
    public onUploadCompleted: UploadFileCompletedCallback = async () => {
    }

    /** @inheritdoc */
    public get path() {
        return this._NAME_AND_PATH.path;
    }

    /** @inheritdoc */
    public readonly read = async function() {
        const ME: FileToUploadBase = this;

        let data = await ME.onRead();

        if (ME.transformer) {
            let stateKeyProvider = ME.transformerStateKeyProvider;
            if (!stateKeyProvider) {
                stateKeyProvider = () => {
                    return deploy_helpers.normalizePath(
                        ME._NAME_AND_PATH.path + '/' + ME._NAME_AND_PATH.name
                    );
                };
            }

            const STATE_KEY = await Promise.resolve(
                stateKeyProvider()
            );

            const CONTEXT: deploy_transformers.DataTransformerContext = {
                _: require('lodash'),
                context: ME.transformerSubContext,
                events: ME.workspace.workspaceSessionState['upload']['events'],
                extension: ME.workspace.context.extension,
                folder: ME.workspace.folder,
                globalEvents: deploy_helpers.EVENTS,
                globals: ME.workspace.globals,
                globalState: ME.workspace.workspaceSessionState['upload']['states']['global'],
                homeDir: deploy_helpers.getExtensionDirInHome(),
                logger: ME.workspace.createLogger(),
                mode: deploy_transformers.DataTransformerMode.Transform,
                options: ME.transformerOptions,
                output: ME.workspace.output,
                replaceWithValues: (val) => {
                    return ME.workspace
                             .replaceWithValues(val);
                },
                require: (id) => {
                    return deploy_helpers.requireFromExtension(id);
                },
                sessionState: deploy_helpers.SESSION,
                settingFolder: ME.workspace.settingFolder,
                state: undefined,
                workspaceRoot: ME.workspace.rootPath,
            };

            // CONTEXT.state
            Object.defineProperty(CONTEXT, 'state', {
                enumerable: true,

                get: () => {
                    return ME.workspace.workspaceSessionState['upload']['states']['data_transformers'][STATE_KEY];
                },

                set: (newValue) => {
                    ME.workspace.workspaceSessionState['upload']['states']['data_transformers'][STATE_KEY] = newValue;
                }
            });
            
            data = await Promise.resolve(
                ME.transformer(
                    data, CONTEXT
                )
            );
        }

        return data;
    };

    /**
     * The logic for the 'read()' method.
     * 
     * @return {Promise<Buffer>} The promise with the read data.
     */
    protected abstract async onRead();

    /**
     * The data transformer.
     */
    public transformer: deploy_transformers.DataTransformer;

    /**
     * The options for the data transformer.
     */
    public transformerOptions: any;

    /**
     * An sub context object for the transformer context.
     */
    public transformerSubContext: any;

    /**
     * A function that provides a key for the state value
     * of a data transformer.
     */
    public transformerStateKeyProvider: () => any;
}

/**
 * A local file to upload.
 */
export class LocalFileToUpload extends FileToUploadBase {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {deploy_workspaces.Workspace} workspace the underlying workspace.
     * @param {string} file The path to the local file.
     * @param {deploy_contracts.WithNameAndPath} nameAndPath Name and relative path information.
     */
    constructor(workspace: deploy_workspaces.Workspace,
                file: string,
                nameAndPath: deploy_contracts.WithNameAndPath) {
        super(workspace, file, nameAndPath);
    }

    /** @inheritdoc */
    protected async onRead() {
        return await deploy_helpers.readFile(this.file);
    }
}

/**
 * A basic plugin.
 */
export abstract class PluginBase<TTarget extends deploy_targets.Target = deploy_targets.Target>
    extends deploy_helpers.DisposableBase
    implements Plugin
{
    /**
     * Initializes a new instance of that class.
     * 
     * @param {PluginContext} context The underlying context.
     */
    constructor(public readonly context: PluginContext) {
        super();
    }

    /** @inheritdoc */
    public __file: string;
    /** @inheritdoc */
    public __filePath: string;
    /** @inheritdoc */
    public __index: number;
    /** @inheritdoc */
    public __type: string;

    /** @inheritdoc */
    public get canDelete() {
        return false;
    }
    /** @inheritdoc */
    public get canDownload() {
        return false;
    }
    /** @inheritdoc */
    public get canList() {
        return false;
    }
    /** @inheritdoc */
    public get canRemoveFolders() {
        return false;
    }
    /** @inheritdoc */
    public get canUpload() {
        return true;
    }


    /** @inheritdoc */
    public async deleteFiles(context: DeleteContext<TTarget>): Promise<void> {
        throw new Error(`'deleteFiles()' is NOT implemented!`);
    }

    /** @inheritdoc */
    public async downloadFiles(context: DownloadContext<TTarget>): Promise<void> {
        throw new Error(`'downloadFiles()' is NOT implemented!`);
    }

    /**
     * Returns the cache for a target.
     * 
     * @param {deploy_targets.Target} target The target.
     * 
     * @return {deploy_helpers.CacheProvider} The cache.
     */
    protected getCache(target: deploy_targets.Target): deploy_helpers.CacheProvider {
        let cache: deploy_helpers.CacheProvider;
        if (target) {
            cache = target.__cache;
        }

        if (!cache) {
            cache = new deploy_helpers.MemoryCache();  // fallback
        }

        return cache;
    }

    /**
     * Returns an existing path for a target, based on the settings folder.
     * 
     * @param {deploy_targets.Target} target The underlying target.
     * @param {string} path The path.
     * 
     * @return {Promise<string|boolean>} The promise with the existing, full normalized path or (false) if path does not exist.
     */
    protected async getExistingSettingPath(target: deploy_targets.Target, path: string)
        : Promise<false | string>
    {
        const WORKSPACE = this.getWorkspaceOfTarget(target);
        if (WORKSPACE) {
            return await WORKSPACE.getExistingSettingPath(path);
        }

        return false;
    }

    /**
     * Returns the workspace of a target.
     * 
     * @param {deploy_targets.Target} target The target.
     * @param {TDefault} defaultValue The default value if workspace is not available.
     * 
     * @return {deploy_workspaces.Workspace|TDefault} The workspace or the default value.
     */
    protected getWorkspaceOfTarget<TDefault = undefined>(target: deploy_targets.Target, defaultValue?: TDefault)
        : deploy_workspaces.Workspace | TDefault
    {
        if (target) {
            return target.__workspace;
        }

        return defaultValue;
    }

    /** @inheritdoc */
    public async initialize() {
    }

    /**
     * Checks if a path is part of the workspace of a target.
     * 
     * @param {deploy_targets.Target} target The underlying target.
     * @param {string} path The path to check.
     * 
     * @return {boolean} Is part of workspace or not. 
     */
    protected isPathOf(target: deploy_targets.Target, path: string) {
        const WORKSPACE = this.getWorkspaceOfTarget(target);
        if (WORKSPACE) {
            return WORKSPACE.isPathOf(path);
        }

        return false;
    }

    /** @inheritdoc */
    public async listDirectory(context: ListDirectoryContext<TTarget>): Promise<ListDirectoryResult<TTarget>> {
        throw new Error(`'listDirectory()' is NOT implemented!`);
    }

    /** @inheritdoc */
    public async removeFolders(context: RemoveFoldersContext<TTarget>): Promise<void> {
        throw new Error(`'removeFolders()' is NOT implemented!`);
    }

    /**
     * Handles a value as string and replaces placeholders.
     * 
     * @param {deploy_targets.Target} target The underlying target.
     * @param {any} val The value to parse.
     * @param {deploy_values.Value|deploy_values.Value[]} [additionalValues] Additional values.
     * 
     * @return {string} The parsed value.
     */
    protected replaceWithValues(target: deploy_targets.Target,
                                val: any, additionalValues?: deploy_values.Value | deploy_values.Value[]) {
        additionalValues = deploy_helpers.asArray(additionalValues);

        const WORKSPACE = this.getWorkspaceOfTarget(target);
        if (WORKSPACE) {
            return WORKSPACE.replaceWithValues(val, additionalValues);
        }
        else {
            return deploy_values.replaceWithValues(additionalValues, val);
        }
    }

    /**
     * Returns a translated string by key and a target.
     * 
     * @param {deploy_targets.Target} target The underlying target.
     * @param {string} key The key.
     * @param {any} [args] The optional arguments.
     * 
     * @return {string} The "translated" string.
     */
    protected t(target: deploy_targets.Target, key: string, ...args: any[]): string {
        const WORKSPACE = this.getWorkspaceOfTarget(target);
        if (WORKSPACE) {
            return WORKSPACE.t
                            .apply(WORKSPACE,
                                   [ <any>key ].concat(args));
        }
        else {
            return i18.t
                      .apply(null, [ <any>key ].concat(args));
        }
    }

    /** @inheritdoc */
    public async uploadFiles(context: UploadContext<TTarget>): Promise<void> {
        throw new Error(`'uploadFiles()' is NOT implemented!`);
    }
}

/**
 * A context for an async file client plugin.
 */
export interface AsyncFileClientPluginContext<TTarget extends deploy_targets.Target = deploy_targets.Target,
                                              TClient extends deploy_clients.IAsyncFileClient = deploy_clients.IAsyncFileClient> {
    /**
     * The underlying client.
     */
    readonly client: TClient;
    /**
     * Returns the "real" path of a sub directory.
     * 
     * @param {string} subDir The sub directory.
     * 
     * @return {string} The "real" path.
     */
    readonly getDir: (subDir: string) => string;
    /**
     * Returns the "real" path of a sub directory, which can be exported.
     * 
     * @param {string} subDir The sub directory.
     * 
     * @return {string} The "export" path.
     */
    readonly getExportPath?: (subDir: string) => string;
    /**
     * The underlying target.
     */
    readonly target: TTarget;
}

/**
 * A plugin based on an async file client.
 */
export abstract class AsyncFileClientPluginBase<TTarget extends deploy_targets.Target = deploy_targets.Target,
                                                TClient extends deploy_clients.IAsyncFileClient = deploy_clients.IAsyncFileClient,
                                                TContext extends AsyncFileClientPluginContext<TTarget, TClient> = AsyncFileClientPluginContext<TTarget, TClient>>
    extends PluginBase<TTarget>
{
    /** @inheritdoc */
    public get canDelete() {
        return true;
    }
    /** @inheritdoc */
    public get canDownload() {
        return true;
    }
    /** @inheritdoc */
    public get canList() {
        return true;
    }
    /** @inheritdoc */
    public get canRemoveFolders() {
        return true;
    }

    /**
     * Creates a context for a target.
     * 
     * @param {TTarget} target The target.
     * 
     * @return {TContext|PromiseLike<TContext>} The created context.
     */
    protected abstract createContext(target: TTarget): TContext | PromiseLike<TContext>;

    /** @inheritdoc */
    public async deleteFiles(context: DeleteContext<TTarget>): Promise<void> {
        const ME = this;

        await ME.invokeForConnection(context.target, async (conn) => {
            if (context.isCancelling) {
                return;
            }

            for (const FILE of context.files) {
                if (context.isCancelling) {
                    break;
                }

                try {
                    const REMOTE_DIR = '/' + FILE.path;

                    await FILE.onBeforeDelete(REMOTE_DIR);

                    await conn.client.deleteFile(
                        conn.getDir(FILE.path) + '/' + FILE.name,
                    );

                    await FILE.onDeleteCompleted();
                }
                catch (e) {
                    await FILE.onDeleteCompleted(e);
                }
            }
        });
    }

    /** @inheritdoc */
    public async downloadFiles(context: DownloadContext<TTarget>): Promise<void> {
        const ME = this;

        await ME.invokeForConnection(context.target, async (conn) => {
            if (context.isCancelling) {
                return;
            }

            for (const FILE of context.files) {
                if (context.isCancelling) {
                    break;
                }

                try {
                    const REMOTE_DIR = '/' + FILE.path;

                    await FILE.onBeforeDownload(REMOTE_DIR);

                    const DOWNLOADED_DATA = await conn.client.downloadFile(
                        conn.getDir(FILE.path) + '/' + FILE.name
                    );
                    
                    await FILE.onDownloadCompleted(
                        null,
                        DOWNLOADED_DATA ? createDownloadedFileFromBuffer(FILE, DOWNLOADED_DATA) : <any>DOWNLOADED_DATA,
                    );
                }
                catch (e) {
                    await FILE.onDownloadCompleted(e);
                }
            }
        });
    }

    private async invokeForConnection<TResult = any>(target: TTarget,
                                                     action: (context: TContext) => TResult): Promise<TResult> {
        const CTX = await Promise.resolve(
            this.createContext(target)
        );
        if (!CTX) {
            return;
        }

        try {
            return await Promise.resolve(
                action(CTX)
            );
        }
        finally {
            deploy_helpers.tryDispose(CTX.client);
        }
    }

    /** @inheritdoc */
    public async listDirectory(context: ListDirectoryContext<TTarget>): Promise<ListDirectoryResult<TTarget>> {
        const ME = this;

        return await ME.invokeForConnection(context.target, async (conn) => {
            if (context.isCancelling) {
                return;
            }

            const DIR = conn.getDir(context.dir);

            let exportPath: string;
            if (conn.getExportPath) {
                exportPath = conn.getExportPath(context.dir);
            }
            if (deploy_helpers.isEmptyString(exportPath)) {
                exportPath = DIR;
            }
            exportPath = deploy_helpers.toStringSafe(exportPath);
            if (!exportPath.trim().startsWith('/')) {
                exportPath = '/' + exportPath;
            }

            const RESULT: ListDirectoryResult<TTarget> = {
                dirs: [],
                files: [],
                info: deploy_files.createDefaultDirectoryInfo(context.dir, {
                    exportPath: exportPath,
                }),
                others: [],
                target: context.target,
            };

            const LIST = await conn.client.listDirectory(DIR);
            if (LIST) {
                for (const FSI of LIST) {
                    if (!FSI) {
                        continue;
                    }

                    switch (FSI.type) {
                        case deploy_files.FileSystemType.Directory:
                            RESULT.dirs.push(<deploy_files.DirectoryInfo>FSI);
                            break;

                        case deploy_files.FileSystemType.File:
                            RESULT.files.push(<deploy_files.FileInfo>FSI);
                            break;

                        default:
                            RESULT.others.push(FSI);
                            break;
                    }
                }
            }

            return RESULT;
        });
    }

    /** @inheritdoc */
    public async removeFolders(context: RemoveFoldersContext<TTarget>) {
        const ME = this;

        await ME.invokeForConnection(context.target, async (conn) => {
            if (context.isCancelling) {
                return;
            }

            for (const FOLDER of context.folders) {
                if (context.isCancelling) {
                    break;
                }

                try {
                    const REMOTE_DIR = '/' + FOLDER.path;

                    await FOLDER.onBeforeRemove(REMOTE_DIR);

                    await conn.client.removeFolder(
                        conn.getDir(FOLDER.path) + '/' + FOLDER.name
                    );

                    await FOLDER.onRemoveCompleted();
                }
                catch (e) {
                    await FOLDER.onRemoveCompleted(e);
                }
            }
        });
    }

    /** @inheritdoc */
    public async uploadFiles(context: UploadContext<TTarget>): Promise<void> {
        const ME = this;

        await ME.invokeForConnection(context.target, async (conn) => {
            if (context.isCancelling) {
                return;
            }

            for (const FILE of context.files) {
                if (context.isCancelling) {
                    break;
                }

                try {
                    const REMOTE_DIR = '/' + FILE.path;

                    await FILE.onBeforeUpload(REMOTE_DIR);

                    await conn.client.uploadFile(
                        conn.getDir(FILE.path) + '/' + FILE.name,
                        await FILE.read(),
                    );

                    await FILE.onUploadCompleted();
                }
                catch (e) {
                    await FILE.onUploadCompleted(e);
                }
            }
        });
    }
}

/**
 * A simple implementation of a file to delete.
 */
export class SimpleFileToDelete implements FileToDelete {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {deploy_workspaces.Workspace} workspace the underlying workspace.
     * @param {string} file The path to the (local) file.
     * @param {deploy_contracts.WithNameAndPath} _NAME_AND_PATH Name and relative path information.
     */
    constructor(public readonly workspace: deploy_workspaces.Workspace,
                public readonly file: string,
                private readonly _NAME_AND_PATH: deploy_contracts.WithNameAndPath) {
    }

    /** @inheritdoc */
    public get name() {
        return this._NAME_AND_PATH.name;
    }

    /** @inheritdoc */
    public onBeforeDelete: BeforeDeleteFileCallback = async () => {
    }

    /** @inheritdoc */
    public onDeleteCompleted: DeleteFileCompletedCallback = async () => {
    }

    /** @inheritdoc */
    public get path() {
        return this._NAME_AND_PATH.path;
    }
}

/**
 * A simple implementation of a file to download.
 */
export class SimpleFileToDownload implements FileToDownload {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {deploy_workspaces.Workspace} workspace the underlying workspace.
     * @param {string} file The path to the (local) file.
     * @param {deploy_contracts.WithNameAndPath} _NAME_AND_PATH Name and relative path information.
     */
    constructor(public readonly workspace: deploy_workspaces.Workspace,
                public readonly file: string,
                private readonly _NAME_AND_PATH: deploy_contracts.WithNameAndPath) {
    }

    /** @inheritdoc */
    public get name() {
        return this._NAME_AND_PATH.name;
    }

    /** @inheritdoc */
    public onBeforeDownload: BeforeDownloadFileCallback = async () => {
    }

    /** @inheritdoc */
    public onDownloadCompleted: DownloadFileCompletedCallback = async () => {
    }

    /** @inheritdoc */
    public get path() {
        return this._NAME_AND_PATH.path;
    }
}

/**
 * A simple implementation of a folder to remove.
 */
export class SimpleFolderToRemove implements FolderToRemove {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {deploy_workspaces.Workspace} workspace the underlying workspace.
     * @param {string} directory The path to the (local) directory.
     * @param {deploy_contracts.WithNameAndPath} _NAME_AND_PATH Name and relative path information.
     */
    constructor(public readonly workspace: deploy_workspaces.Workspace,
                public readonly directory: string,
                private readonly _NAME_AND_PATH: deploy_contracts.WithNameAndPath) {
    }

    /** @inheritdoc */
    public get name() {
        return this._NAME_AND_PATH.name;
    }

    /** @inheritdoc */
    public onBeforeRemove: BeforeRemoveFolderCallback = async () => {
    }

    /** @inheritdoc */
    public onRemoveCompleted: RemoveFolderCompletedCallback = async () => {
    }

    /** @inheritdoc */
    public get path() {
        return this._NAME_AND_PATH.path;
    }
}


/**
 * Creates a new instance of a 'downloaded file' from a buffer.
 * 
 * @param {deploy_workspaces.WorkspaceFile} file The underlying workspace file.
 * @param {Buffer} buff The buffer with the data.
 * 
 * @return {DownloadedFile} The new object.
 */
export function createDownloadedFileFromBuffer(file: deploy_workspaces.WorkspaceFile, buff: Buffer): DownloadedFile {
    const DOWNLOADED: DownloadedFile = {
        dispose: () => {
            buff = null;
        },
        name: undefined,
        path: undefined,
        read: async () => {
            return buff;
        },
    };

    // DOWNLOADED.name
    Object.defineProperty(DOWNLOADED, 'name', {
        enumerable: true,

        get: () => {
            return file.name;
        }
    });

    // DOWNLOADED.path
    Object.defineProperty(DOWNLOADED, 'path', {
        enumerable: true,
        
        get: () => {
            return file.path;
        }
    });
    
    return DOWNLOADED;
}


/**
 * An iterable plugin.
 */
export abstract class IterablePluginBase<TTarget extends deploy_targets.Target & deploy_targets.TargetProvider> extends PluginBase<TTarget> {
    /** @inheritdoc */
    public get canDelete() {
        return true;
    }
    /** @inheritdoc */
    public get canDownload() {
        return true;
    }
    /** @inheritdoc */
    public get canList() {
        return true;
    }
    /** @inheritdoc */
    public get canRemoveFolders() {
        return true;
    }

    /** @inheritdoc */
    public async deleteFiles(context: DeleteContext<TTarget>) {
        const ME = this;

        await ME.invokeForEachTarget(
            <any>await Promise.resolve(
                ME.prepareBaseTarget(context.target)
            ),
            await ME.getTargets(context.target, deploy_contracts.DeployOperation.Delete),
            deploy_contracts.DeployOperation.Delete,
            () => context.isCancelling,
            async (target, plugin) => {
                const CTX: DeleteContext = {
                    cancellationToken: undefined,
                    files: (await ME.mapFilesForTarget(
                        context.target,
                        target,
                        context.files
                    )).map(f => {
                        return deploy_targets.wrapOnBeforeFileCallbackForTarget(
                            f,
                            target,
                            'onBeforeDelete'
                        );
                    }),
                    isCancelling: undefined,
                    target: target,
                };

                // CTX.cancellationToken
                Object.defineProperty(CTX, 'cancellationToken', {
                    enumerable: true,

                    get: () => {
                        return context.cancellationToken;
                    }
                });

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    enumerable: true,

                    get: () => {
                        return context.isCancelling;
                    }
                });

                await Promise.resolve(
                    plugin.deleteFiles(CTX)
                );
            }
        );
    }

    /** @inheritdoc */
    public async downloadFiles(context: DownloadContext<TTarget>) {
        const ME = this;
        
        await ME.invokeForEachTarget(
            <any>await Promise.resolve(
                ME.prepareBaseTarget(context.target)
            ),
            await ME.getFirstTarget(context.target, deploy_contracts.DeployOperation.Pull),
            deploy_contracts.DeployOperation.Pull,
            () => context.isCancelling,
            async (target, plugin) => {
                const CTX: DownloadContext = {
                    cancellationToken: undefined,
                    files: (await ME.mapFilesForTarget(
                        context.target,
                        target,
                        context.files
                    )).map(f => {
                        return deploy_targets.wrapOnBeforeFileCallbackForTarget(
                            f,
                            target,
                            'onBeforeDownload'
                        );
                    }),
                    isCancelling: undefined,
                    target: target,
                };

                // CTX.cancellationToken
                Object.defineProperty(CTX, 'cancellationToken', {
                    enumerable: true,

                    get: () => {
                        return context.cancellationToken;
                    }
                });

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    enumerable: true,

                    get: () => {
                        return context.isCancelling;
                    }
                });

                await Promise.resolve(
                    plugin.downloadFiles(CTX)
                );
            }
        );
    }

    private async getFirstTarget(target: TTarget, operation: deploy_contracts.DeployOperation): Promise<deploy_targets.Target | false> {
        const TARGETS = await this.getTargets(target, operation, true);
        if (false === TARGETS) {
            return false;
        }
        
        return deploy_helpers.asArray(
            <any>TARGETS
        )[0];
    }

    /**
     * Extracts the list of available targets based on a parent target.
     * 
     * @param {TTarget} target The parent target.
     * @param {deploy_contracts.DeployOperation} operation The underlying operation.
     * @param {boolean} [throwIfNonFound] Throw error if non was found or not.
     * 
     * @return {deploy_targets.Target[]|false}
     */
    protected async getTargets(target: TTarget, operation: deploy_contracts.DeployOperation, throwIfNonFound = false)
        : Promise<deploy_targets.Target[] | false>
    {
        const WORKSPACE = this.getWorkspaceOfTarget(target);
        if (!WORKSPACE) {
            return false;
        }

        const TARGETS = deploy_targets.getTargetsByName(target.targets, target.__workspace.getTargets());
        if (false === TARGETS) {
            throw new Error(WORKSPACE.t('targets.atLeastOneNotFound'));
        }

        if (throwIfNonFound) {
            if (TARGETS.length < 1) {
                throw new Error(WORKSPACE.t('targets.noneFound'));
            }
        }

        deploy_targets.throwOnRecurrence(
            target, TARGETS
        );

        const PREPARED_TARGETS = await Promise.resolve(
            this.prepareTargetsMany(target, TARGETS, operation)
        );

        if (false === PREPARED_TARGETS) {
            return false;
        }

        return deploy_helpers.asArray(<any>PREPARED_TARGETS);
    }

    private async invokeForEachTarget(
        myTarget: TTarget | false,
        targets: deploy_targets.Target | deploy_targets.Target[] | false,
        operation: deploy_contracts.DeployOperation,
        isCancelling: () => boolean,
        action: (target: deploy_targets.Target, plugin: Plugin) => any
    ) {
        const ME = this;

        if (!myTarget) {
            return;
        }

        if (false === targets) {
            return;
        }

        let pluginResolver: (target: deploy_targets.Target) => Plugin[];
        switch (operation) {
            case deploy_contracts.DeployOperation.Delete:
                pluginResolver = (t) => t.__workspace.getDeletePlugins(t);
                break;

            case deploy_contracts.DeployOperation.Deploy:
                pluginResolver = (t) => t.__workspace.getUploadPlugins(t);
                break;

            case deploy_contracts.DeployOperation.ListDirectory:
                pluginResolver = (t) => t.__workspace.getListPlugins(t);
                break;

            case deploy_contracts.DeployOperation.Pull:
                pluginResolver = (t) => t.__workspace.getDownloadPlugins(t);
                break;
        }

        for (const T of deploy_helpers.asArray(targets)) {
            if (isCancelling()) {
                return;
            }

            const PREPARED_TARGETS = await Promise.resolve(
                ME.prepareTarget(myTarget, T, operation)
            );

            if (false === PREPARED_TARGETS) {
                return;
            }

            const ALL_TARGETS = deploy_helpers.asArray(
                <any>PREPARED_TARGETS
            );

            for (const TARGET of ALL_TARGETS) {
                for (const PI of pluginResolver(TARGET)) {
                    if (isCancelling()) {
                        return;
                    }

                    await Promise.resolve(
                        action(TARGET, PI)
                    );
                }
            } 
        }
    }

    /** @inheritdoc */
    public async listDirectory(context: ListDirectoryContext<TTarget>) {
        const ME = this;

        let firstResult: ListDirectoryResult;

        await ME.invokeForEachTarget(
            <any>await Promise.resolve(
                ME.prepareBaseTarget(context.target)
            ),
            await ME.getFirstTarget(context.target, deploy_contracts.DeployOperation.ListDirectory),
            deploy_contracts.DeployOperation.ListDirectory,
            () => context.isCancelling,
            async (target, plugin) => {
                const CTX: ListDirectoryContext = {
                    cancellationToken: undefined,
                    dir: context.dir,
                    isCancelling: undefined,
                    target: target,
                    workspace: target.__workspace,
                };

                // CTX.cancellationToken
                Object.defineProperty(CTX, 'cancellationToken', {
                    enumerable: true,

                    get: () => {
                        return context.cancellationToken;
                    }
                });

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    enumerable: true,

                    get: () => {
                        return context.isCancelling;
                    }
                });

                firstResult = await Promise.resolve(
                    plugin.listDirectory(CTX)
                );
            }
        );

        let result: ListDirectoryResult<TTarget>;
        if (firstResult) {
            result = {
                dirs: deploy_helpers.asArray(firstResult.dirs),
                files: deploy_helpers.asArray(firstResult.files),
                info: deploy_files.createDefaultDirectoryInfo(context.dir),
                others: deploy_helpers.asArray(firstResult.others),
                target: context.target,
            };
        }

        return result;
    }

    /**
     * Maps file objects for a specific target.
     * 
     * @param {TTarget} baseTarget The base target, using by that plugin.
     * @param {Target} target The underlying target.
     * @param {TFile|TFile[]} files The file targets to (re)map.
     * 
     * @return {Promise<TFile[]>} The promise with the new, mapped objects.
     */
    protected async mapFilesForTarget<TFile extends deploy_contracts.WithNameAndPath = deploy_contracts.WithNameAndPath>(
        baseTarget: TTarget,
        target: deploy_targets.Target,
        files: TFile | TFile[]
    )
    {
        return await deploy_targets.mapFilesForTarget(target, files);
    }

    /**
     * Maps folder objects for a specific target.
     * 
     * @param {TTarget} baseTarget The base target, using by that plugin.
     * @param {Target} target The underlying target.
     * @param {TFolder|TFolder[]} folders The folder targets to (re)map.
     * 
     * @return {Promise<TFolder[]>} The promise with the new, mapped objects.
     */
    protected async mapFoldersForTarget<TFolder extends deploy_contracts.WithNameAndPath = deploy_contracts.WithNameAndPath>(
        baseTarget: TTarget,
        target: deploy_targets.Target,
        folders: TFolder | TFolder[]
    )
    {
        return await deploy_targets.mapFoldersForTarget(target, folders);
    }

    /**
     * Prepares a base target.
     * 
     * @param {TTarget} baseTarget The base target.
     * 
     * @return {PrepareBaseTargetResult<TTarget>|PromiseLike<PrepareBaseTargetResult<TTarget>>} The result of the prepared target.
     */
    protected prepareBaseTarget(baseTarget: TTarget)
        : PrepareBaseTargetResult<TTarget> | PromiseLike<PrepareBaseTargetResult<TTarget>>
    {
        return baseTarget;
    }

    /**
     * Prepares a target.
     * 
     * @param {TTarget} myTarget The base target.
     * @param {deploy_targets.Target} target The input target.
     * @param {deploy_contracts.DeployOperation} operation The underlying operation.
     * 
     * @return {PrepareTargetsResult|PromiseLike<PrepareTargetsResult>} The target(s) to use.
     */
    protected prepareTarget(myTarget: TTarget, target: deploy_targets.Target, operation: deploy_contracts.DeployOperation)
        : PrepareTargetsResult | PromiseLike<PrepareTargetsResult> {
        return target;
    }
    
    /**
     * Prepares targets.
     * 
     * @param {TTarget} myTarget The base target.
     * @param {deploy_targets.Target|deploy_targets.Target[]} targets The input targets.
     * @param {deploy_contracts.DeployOperation} operation The underlying operation.
     * 
     * @return {PrepareTargetsResult|PromiseLike<PrepareTargetsResult>} The target(s) to use.
     */
    protected prepareTargetsMany(myTarget: TTarget, targets: deploy_targets.Target | deploy_targets.Target[], operation: deploy_contracts.DeployOperation)
        : PrepareTargetsResult | PromiseLike<PrepareTargetsResult> {
        return deploy_helpers.asArray(targets);
    }

    /** @inheritdoc */
    public async removeFolders(context: RemoveFoldersContext<TTarget>): Promise<void> {
        const ME = this;

        await ME.invokeForEachTarget(
            <any>await Promise.resolve(
                ME.prepareBaseTarget(context.target)
            ),
            await ME.getTargets(context.target, deploy_contracts.DeployOperation.RemoveFolders),
            deploy_contracts.DeployOperation.RemoveFolders,
            () => context.isCancelling,
            async (target, plugin) => {
                const CTX: RemoveFoldersContext = {
                    cancellationToken: undefined,
                    folders: (await ME.mapFoldersForTarget(
                        context.target,
                        target,
                        context.folders
                    )).map(f => {
                        return deploy_targets.wrapOnBeforeFolderCallbackForTarget(
                            f,
                            target,
                            'onBeforeRemove'
                        );
                    }),
                    isCancelling: undefined,
                    target: target,                    
                };

                // CTX.cancellationToken
                Object.defineProperty(CTX, 'cancellationToken', {
                    enumerable: true,

                    get: () => {
                        return context.cancellationToken;
                    }
                });

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    enumerable: true,

                    get: () => {
                        return context.isCancelling;
                    }
                });

                await Promise.resolve(
                    plugin.removeFolders(CTX)
                );
            }
        );
    }

    /** @inheritdoc */
    public async uploadFiles(context: UploadContext<TTarget>) {
        const ME = this;

        await ME.invokeForEachTarget(
            <any>await Promise.resolve(
                ME.prepareBaseTarget(context.target)
            ),
            await ME.getTargets(context.target, deploy_contracts.DeployOperation.Deploy),
            deploy_contracts.DeployOperation.Deploy,
            () => context.isCancelling,
            async (target, plugin) => {
                const CTX: UploadContext = {
                    cancellationToken: undefined,
                    files: (await ME.mapFilesForTarget(
                        context.target,
                        target,
                        context.files
                    )).map(f => {
                        return deploy_targets.wrapOnBeforeFileCallbackForTarget(
                            f,
                            target,
                            'onBeforeUpload'
                        );
                    }),
                    isCancelling: undefined,
                    target: target,
                };

                // CTX.cancellationToken
                Object.defineProperty(CTX, 'cancellationToken', {
                    enumerable: true,

                    get: () => {
                        return context.cancellationToken;
                    }
                });

                // CTX.isCancelling
                Object.defineProperty(CTX, 'isCancelling', {
                    enumerable: true,

                    get: () => {
                        return context.isCancelling;
                    }
                });

                await Promise.resolve(
                    plugin.uploadFiles(CTX)
                );
            }
        );
    }
}


/**
 * Checks if a plugin can delete files.
 * 
 * @param {Plugin} plugin The plugin.
 * @param {deploy_targets.Target} target The target.
 * 
 * @return {boolean} Can delete or not.
 */
export function canDelete(plugin: Plugin, target: deploy_targets.Target) {
    return canDo(plugin, target,
                 p => p.canDelete, p => p.deleteFiles);
}

function canDo(
    plugin: Plugin, target: deploy_targets.Target,
    canFlagResolver: (p: Plugin) => boolean, methodResolver: (p: Plugin) => Function,
) {
    if (!plugin || !target) {
        return false;
    }

    const PLUGIN_TYPE = deploy_helpers.normalizeString( plugin.__type );
    const TARGET_TYPE = deploy_targets.normalizeTargetType( target );

    const CAN_FLAG = deploy_helpers.toBooleanSafe( canFlagResolver(plugin) );
    const METHOD = methodResolver(plugin);

    return (TARGET_TYPE === PLUGIN_TYPE || '' === PLUGIN_TYPE) &&
           (CAN_FLAG && !_.isNil(METHOD));
}

/**
 * Checks if a plugin can download files.
 * 
 * @param {Plugin} plugin The plugin.
 * @param {deploy_targets.Target} target The target.
 * 
 * @return {boolean} Can download or not.
 */
export function canDownload(plugin: Plugin, target: deploy_targets.Target) {
    return canDo(plugin, target,
                 p => p.canDownload, p => p.downloadFiles);
}

/**
 * Checks if a plugin can list directories.
 * 
 * @param {Plugin} plugin The plugin.
 * @param {deploy_targets.Target} target The target.
 * 
 * @return {boolean} Can list or not.
 */
export function canList(plugin: Plugin, target: deploy_targets.Target) {
    return canDo(plugin, target,
                 p => p.canList, p => p.listDirectory);
}

/**
 * Checks if a plugin can remove folders.
 * 
 * @param {Plugin} plugin The plugin.
 * @param {deploy_targets.Target} target The target.
 * 
 * @return {boolean} Can remove folders or not.
 */
export function canRemoveFolders(plugin: Plugin, target: deploy_targets.Target) {
    return canDo(plugin, target,
                 p => p.canRemoveFolders, p => p.removeFolders);
}

/**
 * Checks if a plugin can upload files.
 * 
 * @param {Plugin} plugin The plugin.
 * @param {deploy_targets.Target} target The target.
 * 
 * @return {boolean} Can upload or not.
 */
export function canUpload(plugin: Plugin, target: deploy_targets.Target) {
    return canDo(plugin, target,
                 p => p.canUpload, p => p.uploadFiles);
}
