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


/**
 * An folder mapping entry.
 */
export type FolderMappingEntry = string | FolderMappingSettings;

/**
 * An object with folder mappings.
 */
export type FolderMappings = { [pattern: string]: FolderMappingEntry };

/**
 * Folder mapping settings.
 */
export interface FolderMappingSettings {
    /**
     * The target path if mapping matches.
     */
    readonly to: string;
}
