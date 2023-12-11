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

import * as deploy_clients from '../clients';
import * as deploy_files from '../files';
import * as deploy_helpers from '../helpers';
import * as deploy_log from '../log';
const Dropbox = require('dropbox');
import * as Moment from 'moment';


/**
 * Options for a FTP connection.
 */
export interface DropboxOptions {
    /**
     * The access token to use.
     */
    readonly accessToken?: string;
}


/**
 * A Dropbox file client.
 */
export class DropBoxClient extends deploy_clients.AsyncFileListBase {
    /**
     * Initializes a new instance of that class.
     * 
     * @param {DropboxOptions} options The options for the client. 
     */
    constructor(public readonly options: DropboxOptions) {
        super();

        let accessToken = deploy_helpers.toStringSafe(options.accessToken).trim();
        if ('' === accessToken) {
            accessToken = undefined;
        }

        this.connection = new Dropbox({ 
            accessToken: accessToken
        });
    }

    /**
     * Gets the underlying Dropbox instance.
     */
    public readonly connection: any;

    /** @inheritdoc */
    public async deleteFile(path: string): Promise<boolean> {
        path = toDropBoxPath(path);
        
        try {
            await this.connection.filesDeleteV2({
                path: path,
            });
            
            return true;
        }
        catch (e) {
            deploy_log.CONSOLE
                      .trace(e, 'clients.dropbox.DropBoxClient.deleteFile(1)');

            return false;
        }
    }

    /** @inheritdoc */
    public async downloadFile(path: string): Promise<Buffer> {
        path = toDropBoxPath(path);

        const META_DATA = await this.connection.filesDownload({
            path: path,
        });

        return new Buffer(META_DATA.fileBinary, 'binary');
    }

    /** @inheritdoc */
    public async listDirectory(path: string) {
        const ME = this;

        path = toDropBoxPath(path);

        const RESULT: deploy_files.FileSystemInfo[] = [];

        const LIST = await this.connection.filesListFolder({
            include_media_info: true,
            include_mounted_folders: true,
            path: path,
            recursive: false,
        });
        if (LIST && LIST.entries) {
            for (const ENTRY of LIST.entries) {
                switch (deploy_helpers.normalizeString(ENTRY['.tag'])) {
                    case 'file':
                        {
                            const FI: deploy_files.FileInfo = {
                                download: async () => {
                                    return await ME.downloadFile(
                                        deploy_helpers.normalizePath(
                                            deploy_helpers.normalizePath(path) + '/' + ENTRY.name
                                        )
                                    );
                                },
                                //TODO: exportPath: false,
                                name: ENTRY.name,
                                path: deploy_helpers.normalizePath(path),
                                size: ENTRY.size,
                                time: Moment(ENTRY.server_modified),
                                type: deploy_files.FileSystemType.File,
                            };

                            RESULT.push(FI);
                        }
                        break;

                    case 'folder':
                        {
                            const DI: deploy_files.DirectoryInfo = {
                                //TODO: exportPath: false,
                                name: ENTRY.name,
                                path: deploy_helpers.normalizePath(path),
                                type: deploy_files.FileSystemType.Directory,
                            };

                            RESULT.push(DI);
                        }
                        break;

                    default:
                        {
                            const FSI: deploy_files.FileSystemInfo = {
                                //TODO: exportPath: false,
                                name: ENTRY.name,
                                path: deploy_helpers.normalizePath(path),
                            };

                            RESULT.push(FSI);
                        }
                        break;
                }
            }
        }

        return RESULT;
    }

    /** @inheritdoc */
    public async removeFolder(path: string): Promise<boolean> {
        path = toDropBoxPath(path);
        if ('/' === path) {
            return false;  // NOT the root folder!
        }

        try {
            await this.connection.filesDeleteV2({
                path: path,
            });

            return true;
        }
        catch (e) {
            deploy_log.CONSOLE
                      .trace(e, 'clients.dropbox.DropBoxClient.removeFolder(1)');

            return false;
        }
    }

    /** @inheritdoc */
    public get type() {
        return 'dropbox';
    }

    /** @inheritdoc */
    public async uploadFile(path: string, data: Buffer): Promise<void> {
        path = toDropBoxPath(path);

        await this.connection.filesUpload({
            autorename: false,
            contents: data,
            mode: 'overwrite',
            mute: false,
            path: path,
        });
    }
}


/**
 * Creates a new client.
 * 
 * @param {DropboxOptions} opts The options for the new client.
 * 
 * @return {DropBoxClient} The new client.
 */
export function createClient(opts: DropboxOptions): DropBoxClient {
    if (!opts) {
        return <any>opts;
    }

    return new DropBoxClient(opts);
}

/**
 * Converts to a Dropbox path.
 * 
 * @param {string} p The path to convert.
 * 
 * @return {string} The converted path. 
 */
export function toDropBoxPath(p: string) {
    p = deploy_helpers.normalizePath(p);

    if ('.' === p) {
        p = '';
    }
    if ('' !== p) {
        p = '/' + p;
    }

    return p;
}
