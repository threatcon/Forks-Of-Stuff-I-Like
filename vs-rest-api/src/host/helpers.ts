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

import * as rapi_contracts from '../contracts';
import * as rapi_helpers from '../helpers';
import * as URL from 'url';
import * as ZLib from 'zlib';


/**
 * Describes a callback for the 'loadCSSAndJavascript()' function.
 * 
 * @param {string} css The loaded CSS data (if found).
 * @param {string} js The loaded JavaScript data (if found).
 */
export type LoadCSSAndJavascriptCallback = (css: string, js: string) => void;

/**
 * The result of 'compressForResponse()' function.
 */
export interface CompressForResponseResult {
    /**
     * The compressed data.
     */
    compressed?: Buffer;
    /**
     * The suggested content encoding to use for the response.
     */
    contentEncoding?: string;
    /**
     * The suggested data to send.
     */
    dataToSend: Buffer;
    /**
     * The occurred error.
     */
    error?: any;
    /**
     * The uncompressed data as buffer.
     */
    uncompressed: Buffer;
}


/**
 * Tries to compress data for a reponse.
 * 
 * @param {any} data The data to compress.
 * @param {rapi_contracts.RequestContext} ctx The underlying request context.
 * @param {string} encoding The custom text encoding to use, if 'data' is no buffer.
 * 
 * @return {PromiseLike<CompressForResponseResult>} The result.
 */
export function compressForResponse(data: any,
                                    ctx: rapi_contracts.RequestContext,
                                    encoding?: string): PromiseLike<CompressForResponseResult> {
    encoding = rapi_helpers.normalizeString(encoding);
    if (!encoding) {
        encoding = 'utf8';
    }
    
    return new Promise<CompressForResponseResult>((resolve, reject) => {
        try {
            let uncompressed = rapi_helpers.asBuffer(data, encoding);
            if (!uncompressed) {
                uncompressed = Buffer.alloc(0);
            }

            let compressed: Buffer;
            let contentEncoding: string;
            let dataToSend = uncompressed;
            let completed = (err?: any) => {
                resolve({
                    compressed: compressed,
                    contentEncoding: contentEncoding,
                    dataToSend: dataToSend,
                    error: err,
                    uncompressed: uncompressed,
                });
            };
        
            let acceptEncodings = rapi_helpers.toStringSafe(
                rapi_helpers.getHeaderValue(ctx.request.headers, 'Accept-Encoding'))
                    .toLowerCase()
                    .split(',')
                    .map(x => rapi_helpers.toStringSafe(x).toLowerCase().trim())
                    .filter(x => x);

            if (acceptEncodings.indexOf('gzip') > -1) {
                // gzip

                ZLib.gzip(uncompressed, (err, compressedData) => {
                    if (!err) {
                        if (compressedData.length < uncompressed.length) {
                            contentEncoding = 'gzip';

                            compressed = compressedData;
                            dataToSend = compressed;
                        }
                    }

                    completed(err);
                });
            }
            else if (acceptEncodings.indexOf('deflate') > -1) {
                // deflate

                ZLib.deflate(uncompressed, (err, compressedData) => {
                    if (!err) {
                        if (compressedData.length < uncompressed.length) {
                            contentEncoding = 'deflate';

                            compressed = compressedData;
                            dataToSend = compressed;
                        }
                    }

                    completed(err);
                });
            }
            else {
                // no encoding

                completed();
            }
        }
        catch (e) {
            reject(e);
        }
    });
}

/**
 * Sends an error response.
 * 
 * @param {any} err The error to send.
 * @param {rapi_contracts.RequestContext} ctx The request context.
 * @param {number} code The custom status code to send.
 */
export function sendError(err: any, ctx: rapi_contracts.RequestContext, code = 500) {
    try {
        ctx.response.statusCode = code;
        ctx.response.statusMessage = rapi_helpers.toStringSafe(err);

        ctx.response.end();
    }
    catch (e) {
        this.controller.log(`[ERROR] host.helpers.sendError(): ${rapi_helpers.toStringSafe(e)}`);
    }
}

/**
 * Sends a "forbidden" response.
 * 
 * @param {rapi_contracts.RequestContext} ctx The request context.
 * @param {number} code The custom status code to send.
 */
export function sendForbidden(ctx: rapi_contracts.RequestContext, code = 403) {
    try {
        ctx.response.statusCode = code;

        ctx.response.end();
    }
    catch (e) {
        this.controller.log(`[ERROR] host.helpers.sendForbidden(): ${rapi_helpers.toStringSafe(e)}`);
    }
}

/**
 * Sends a "method not allowed" response.
 * 
 * @param {rapi_contracts.RequestContext} ctx The request context.
 * @param {number} code The custom status code to send.
 */
export function sendMethodNotAllowed(ctx: rapi_contracts.RequestContext, code = 405) {
    try {
        ctx.response.statusCode = code;

        ctx.response.end();
    }
    catch (e) {
        this.controller.log(`[ERROR] host.helpers.sendMethodNotAllowed(): ${rapi_helpers.toStringSafe(e)}`);
    }
}

/**
 * Sends a "not found" response.
 * 
 * @param {rapi_contracts.RequestContext} ctx The request context.
 * @param {number} code The custom status code to send.
 */
export function sendNotFound(ctx: rapi_contracts.RequestContext, code = 404) {
    try {
        ctx.response.statusCode = code;

        ctx.response.end();
    }
    catch (e) {
        this.controller.log(`[ERROR] host.helpers.sendNotFound(): ${rapi_helpers.toStringSafe(e)}`);
    }
}

/**
 * Sends a "not implemented" response.
 * 
 * @param {rapi_contracts.RequestContext} ctx The request context.
 * @param {number} code The custom status code to send.
 */
export function sendNotImplemented(ctx: rapi_contracts.RequestContext, code = 501) {
    try {
        ctx.response.statusCode = code;

        ctx.response.end();
    }
    catch (e) {
        this.controller.log(`[ERROR] host.helpers.sendNotImplemented(): ${rapi_helpers.toStringSafe(e)}`);
    }
}

/**
 * Sends an "unauthorized" response.
 * 
 * @param {rapi_contracts.RequestContext} ctx The request context.
 * @param {number} code The custom status code to send.
 */
export function sendUnauthorized(ctx: rapi_contracts.RequestContext, code = 401) {
    try {
        let realm = rapi_helpers.toStringSafe(ctx.config.realm);
        if (rapi_helpers.isEmptyString(realm)) {
            realm = 'REST API for Visual Studio Code (vs-rest-api)';
        }

        let headers: any = {
            'WWW-Authenticate': `Basic realm="${realm}"`,
        };

        ctx.response.writeHead(code, headers);

        ctx.response.end();
    }
    catch (e) {
        this.controller.log(`[ERROR] host.helpers.sendUnauthorized(): ${rapi_helpers.toStringSafe(e)}`);
    }
}

/**
 * Extracts the query parameters of an URL to an object.
 * 
 * @param {URL.Url} url The URL.
 * 
 * @return {Object} The parameters of the URL as object.
 */
export function urlParamsToObject(url: URL.Url): Object {
    if (!url) {
        return url;
    }

    let params: any;
    if (!rapi_helpers.isEmptyString(url.query)) {
        // s. https://css-tricks.com/snippets/jquery/get-query-params-object/
        params = url.query.replace(/(^\?)/,'')
                          .split("&")
                          .map(function(n) { return n = n.split("="), this[rapi_helpers.normalizeString(n[0])] =
                                                                           rapi_helpers.toStringSafe(decodeURIComponent(n[1])), this}
                          .bind({}))[0];
    }

    if (!params) {
        params = {};
    }

    return params;
}
