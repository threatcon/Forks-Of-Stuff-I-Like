/// <reference types="node" />

// The MIT License (MIT)
// 
// vs-rest-api (https://github.com/mkloubert/vs-rest-api)
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

import * as FS from 'fs';
const i18next = require('i18next');
import * as Path from 'path';
import * as rapi_helpers from './helpers';
import * as vscode from 'vscode';


/**
 * Stores the strings of a translation.
 */
export interface Translation {
    browser: {
        openFailed: string;
    },
    errors: {
        withCategory: string;
    },
    host: {
        notStarted: string;
        started: string;
        startFailed: string;
        stopFailed: string;
        stopped: string;
    },
    isNo: {
        dir: string;
        file: string;
    },
    popups: {
        newVersion: {
            message: string;
            showChangeLog: string;
        },
    },
    whiteboard: {
        initFailed: string;
    },
}


/**
 * Returns a translated string by key.
 * 
 * @param {string} key The key.
 * @param {any} [args] The optional arguments.
 * 
 * @return {string} The "translated" string.
 */
export function t(key: string, ...args: any[]): string {
    let formatStr = i18next.t(rapi_helpers.toStringSafe(key).trim());
    formatStr = rapi_helpers.toStringSafe(formatStr);

    return rapi_helpers.formatArray(formatStr, args);
}

/**
 * Initializes the language repository.
 * 
 * @param {string} [lang] The custom language to use.
 * 
 * @returns {PromiseLike<any>} The promise.
 */
export function init(lang?: string): PromiseLike<any> {
    if (rapi_helpers.isEmptyString(lang)) {
        lang = vscode.env.language;
    }
    lang = rapi_helpers.toStringSafe(lang).toLowerCase().trim();
    if (!lang) {
        lang = 'en';
    }

    return new Promise<any>((resolve, reject) => {
        let completed = rapi_helpers.createSimplePromiseCompletedAction(resolve, reject);

        try {
            let langDir = Path.join(__dirname, 'lang');

            let resources: any = {};

            // initialize 'i18next'
            // with collected data
            let initLang = () => {
                i18next.init({
                    lng: lang,
                    resources: resources,
                    fallbackLng: 'en',
                }, (err, tr) => {
                    completed(err, tr);
                });
            };

            // load language files
            let loadFiles = () => {
                FS.readdir(langDir, (err, files) => {
                    if (err) {
                        completed(err);
                        return;
                    }

                    // load files
                    for (let i = 0; i < files.length; i++) {
                        try {
                            let fileName = files[i];
                            if (fileName.length < 3) {
                                continue;
                            }

                            if ('.js' != fileName.substr(fileName.length - 3)) {
                                continue;  // no JavaScript file
                            }

                            let langName = fileName.substr(0, fileName.length - 3).toLowerCase().trim();
                            if (!langName) {
                                continue;  // no language name available
                            }

                            let fullPath = Path.join(langDir, fileName);
                            fullPath = Path.resolve(fullPath);

                            let stats = FS.lstatSync(fullPath);
                            if (!stats.isFile()) {
                                continue;  // no file
                            }

                            // deleted cached data
                            // and load current translation
                            // from file
                            delete require.cache[fullPath];
                            resources[langName] = {
                                translation: require(fullPath).TRANSLATION,
                            };
                        }
                        catch (e) {
                            rapi_helpers.log(`[vs-deploy :: ERROR] i18.init(): ${rapi_helpers.toStringSafe(e)}`);
                        }
                    }

                    initLang();
                })
            };

            // check if directory
            let checkIfDirectory = () => {
                FS.lstat(langDir, (err, stats) => {
                    if (stats.isDirectory()) {
                        loadFiles();
                    }
                    else {
                        completed(new Error(`'${langDir}' is no directory!`));
                    }
                });
            };

            FS.exists(langDir, (exists) => {
                if (exists) {
                    checkIfDirectory();
                }
                else {
                    initLang();
                }
            });
        }
        catch (e) {
            completed(e);
        }
    });
}
