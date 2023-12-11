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

import * as deploy_contracts from './contracts';
import * as deploy_helpers from './helpers';
import * as Enumerable from 'node-enumerable';
import * as FS from 'fs';
import * as i18 from './i18';
const MergeDeep = require('merge-deep');
import * as Path from 'path';
import * as vs_deploy from './deploy';
import * as vscode from 'vscode';


/**
 * A target with plugins.
 */
export interface TargetWithPlugins {
    /**
     * The plugins of the underlying target.
     */
    plugins: deploy_contracts.DeployPlugin[];
    /**
     * The underlying target.
     */
    target: deploy_contracts.DeployTarget;
}

/**
 * Returns targets with their plugins.
 * 
 * @param {deploy_contracts.DeployTarget | deploy_contracts.DeployTarget[]} targets One or more target.
 * @param {(deploy_contracts.DeployPlugin|deploy_contracts.DeployPlugin[])} plugins All known plugins.
 * 
 * @returns {TargetWithPlugins[]} The targets with their plugins.
 */
export function getPluginsForTarget(targets: deploy_contracts.DeployTarget | deploy_contracts.DeployTarget[],
                                    plugins: deploy_contracts.DeployPlugin | deploy_contracts.DeployPlugin[]): TargetWithPlugins[] {
    let allTargets = deploy_helpers.asArray(targets)
                                   .filter(x => x);

    return Enumerable.from(allTargets).select<TargetWithPlugins>(t => {
        let targetType = deploy_helpers.normalizeString(t.type);

        let matchingPlugins = deploy_helpers.asArray(plugins);
        matchingPlugins = matchingPlugins.filter(x => x);
        matchingPlugins = matchingPlugins.filter(pi => {
            let pluginType = deploy_helpers.normalizeString(pi.__type);

            return '' === pluginType ||
                   pluginType === targetType;
        });

        return {
            plugins: matchingPlugins,
            target: t,
        };
    }).toArray();
}

/**
 * Returns the list of targets.
 * 
 * @returns {DeployTarget[]} The targets.
 */
export function getTargets(): deploy_contracts.DeployTarget[] {
    let me: vs_deploy.Deployer = this;

    let targets = me.allTargetsFromConfig;

    // load from
    targets = deploy_helpers.loadBaseSettingsFromFiles(targets, me.getValues());

    // inherit and merge
    targets = deploy_helpers.mergeInheritables(targets);

    let myName = me.name;
    targets = deploy_helpers.sortTargets(targets, () => myName);

    // isFor
    targets = targets.filter(t => {
        let validHosts = deploy_helpers.asArray(t.isFor)
                                       .map(x => deploy_helpers.normalizeString(x))
                                       .filter(x => '' !== x);

        if (validHosts.length < 1) {
            return true;
        }

        return validHosts.indexOf(myName) > -1;
    });

    // platforms
    targets = deploy_helpers.filterPlatformItems(targets);

    // if
    targets = me.filterConditionalItems(targets);

    return targets.map(t => {
        return deploy_helpers.applyValues(t, me.getValues());
    });
}
