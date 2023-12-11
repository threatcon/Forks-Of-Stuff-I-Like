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

import { Translation } from '../i18';


// english
// 
// Translated by: Marcel Joachim Kloubert (https://github.com/mkloubert)
export const TRANSLATION: Translation = {
    browser: {
        openFailed: "Could not OPEN url {0:trim,surround}: {1:trim}",
    },
    errors: {
        withCategory: '[FEHLER] {0:trim}: {1}',
    },
    host: {
        notStarted: "Server has NOT been started!",
        started: "Host now runs on port {0:trim}",
        startFailed: "The host could not be STARTED: {0:trim}",
        stopFailed: "The host could not be STOPPED: {0:trim}",
        stopped: "Host has been STOPPED.",
    },
    isNo: {
        dir: "{0:trim,surround} is no directory!",
        file: "{0:trim,surround} is no file!",
    },
    popups: {
        newVersion: {
            message: "You are running new version of 'vs-rest-api' ({0:trim})!",
            showChangeLog: 'Show changelog...',
        },
    },
    whiteboard: {
        initFailed: "Could not initialize whiteboard: {0}",
    },
};
