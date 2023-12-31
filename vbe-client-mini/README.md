
# vbecm README

vbe-client-mini

This is vbe client mini.
Vba module export, import extension for vs code.
This extension thinks Excel as Excel Server.

[日本語](./README-jp.md)


![animation](./images/AnimationVbecm.gif)

## Requirement


* Windows 10
* Excel

## Before use


### Macro Settings


Set on  next settings

* Macro Settings
    * Enable all macors(not recommended; potensially dangerouse code can run)
* Developer Macro Settings
    * Trust access to the VBA project object model

### vscode setting files.insertFinalNewline


You should better set setting files.insertFinalNewline On.
When vbe imports a module ends with not a newline and exports it,
the module is added a newline. So vbecm detect difference imported from exported.

### vscode encoding


If your locale vbe encoding is not convertible to utf-8,
you set properly vscode encoding for vba module. Do not use auto detect.
For Japanese, if set auto detect, sometimes detect error occur.

### exclude settings


You should better exclude the .base and .vbe folder at the explorer and the search.

```

"files.exclude": {
"**/.base": true,
"**/.vbe": true,
"**/.frx": true
},
"search.exclude": {
"**/.base": true,
"**/.vbe": true,
},

```
### settings


* Vbecm: Auto Refresh Diff
    * Set On, the diff tree view is refreshed automatically

* Vbecm: Vbs Encode
    * At cjk language area, vbs message not work good beside Japanese. Set encoding option
        vbecm.vbsEncode, for japanese 'windows-31j'

* Vbecm: Diff Exclude
    * When there are folders for not vba, the diff tree view detects them.
        you set the folder to exclude.

* Vbecm: Open Encoding Test
    * For japanese. When the vscode opens files with non sjis encoding, it shows message.
        If many mistake happen, please set off.

### Recommendation


if you need, it is better to install VSCode VBA below.
* https://marketplace.visualstudio.com/items?itemName=spences10.VBA

## Features


Before use this extension, you must back up your xlsm or xlam file.

### Explorer context menu for an xlsm and an xlam


* Export all VBA modules
    * Export vba modules form a xlsm file to a folder.
    * select a xlsm file in the explorer, and right click, and select export.
        you can find a Src_[xxx.xlsm] folder at the same folder.
* Import all VBA modules
    * Import vba modules to a xlsm file.
    * you can import modules from a src_file.xlsm folder.
* compile VBA
    * Do compile.
    * vbecm can not detect complete to compile, so please check on the VBE.
* Export only frx modules
    * Export frx modules
    * You can not know frx is modified or not.  If you modified a frm on the vscode,
        you can export only frx files.

### Explorer context menu for a Src_[xxx.xlsm] folder


* Push All Vba modules
    * Push all modules form a Src_[xxx.xlsm] folder
    * you can push all modules in the source folder to the excel book.
* Pull All Vba modules
    * Pull all modules to a Src_[xxx.xlsm] folder
* Check modified
    * Check modification among srcXXX, .vbe and .base.
    * The result is shown at Explore Diff
* Compile Project
    * Compile select folder project.

### Explorer context menu for DIFF:


Modified modules are shown in the DIFF.

#### src(base)


If there is some modification in the src folder, the modified modules are shown.
Vbecm checks the modification between the src and base folder.

You can click to compare the module in base and the module in the src.

You can right click to push the module to a Excel.

#### vbe(base)


If there is some modification in the VBE, the modified modules are shown.
Vbecm checks the modification between the src and vbe folder.

You can click to compare the module in base and the module in the vbe.

The resolve command is removed on the latest version.

#### confilicting


When vbecm detects some confiliction between the source and the vbe,
this tree is activate.
Click this item, and show a diff tab between the source and the vbe.
You edit the source and commit.

### editor context menu


* Push VBA module
    * Push vba module to a xlsm file on an editor.
    * Selected module is imported to a xlsm file.
* Run Sub function
    * run Sub() function on a editor.
    * select a sub XXX() line, and right click, and select run.
* Pull VBA module
    * Pull selected module form xlsm file.
    * If you modified the module, vbe overwrites the modules in the src with vbe
* Goto Vbe module
    * Goto the code of module on the vbe form the editor you select.
        It does not work for a workbook module.

### Folders


#### src_[excelBookName] folder


When you export modules, the modules are in the src_[excelBookName] folder.

#### .base folder


In the src_[excelBookName] folder, you can see a .base folder.
When you commit or import modules, this folder is updated.
And when you export modules, vbecm tests if there are difference between the src_[excelBookName]  and .base folders.

#### .vbe folder


In the src_[excelBookName] folder, you can see a .vbe folder.
When you commit or import modules or check modification, this folder is updated.
And when you import modules, vbecm tests if there are difference between the .vbe  and .base folders.

## How to build


https://code.visualstudio.com/api/working-with-extensions/publishing-extension

```

npm install -g vsce
vsce package --target win32-x64
vsce publish

```

## Known problems


* Sometimes, Excel remain on background. You should kill the process on a task manager. Sorry.
* Sometimes, you meet export or import error. So you recover from a backup excel book.
* When vbecm is working, [[vbecm]] is displayed on the status bar.
    If no vbecm menus displayed without [[vbecm]] , maybe bugs, please reload your vscode.
* When you import a sheet module, sometimes you find new empty line at end of module.
* Sometime, you may see the folder src_GUID. It stays when some errors occur. Please delete it.

## Shallow dive


Not deep dive.

### Sheet modules and Workbook modules


Sheet modules and Workbook modules are exported to [ModuleName].sht.cls.
For vbecm distinguishes normal class modules from sheet(book) modules.
Thanks for the [VbaDeveloper](https://github.com/hilkoc/vbaDeveloper "VbaDeveloper")

### Opened excel file


While vbecm is working, Excel dose not close. Please close the Excel when you end using it.

### For xlam file


When you use an xlam file, vbecm add a book to the excel instance.

### Import frm


When you import a frm module, you find a extra line added.
vbecm will delete the line.

### Diff algorism

we are using the dir-compare and we are very grateful to be able to use it.
https://github.com/gliviu/dir-compare
And we want the option IGNORE CONTENT CASE, we fork and add some modification.
We think there's probably a way to easily extend it without forking.

## Release Notes


[see change log](./CHANGELOG.md)

