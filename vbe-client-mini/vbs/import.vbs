Option Explicit

'' load function
Dim fso
Set fso = createObject("Scripting.FileSystemObject")
Execute fso.OpenTextFile(fso.getParentFolderName(WScript.ScriptFullName) & "\vbsCommon.vbs").ReadAll()

'' get project root
Dim projectRoot
projectRoot = fso.getParentFolderName(fso.getParentFolderName(WScript.ScriptFullName))

'' get book path
Dim bookPath
'' if modulePath is empty, import all modules
Dim modulePath
Dim moduleFolderPath
Dim isUseFromModule
Dim isUseSheetModule
modulePath = ""
isUseFromModule = True
isUseSheetModule = True
If WScript.Arguments.Count = 3 Then
    bookPath = WScript.Arguments(0)
    '' module path include xxxx.sht.cls
    modulePath = WScript.Arguments(1)
    moduleFolderPath = WScript.Arguments(2)
Else
    '' for debug
    bookPath = fso.BuildPath(projectRoot, "xlsms\macroTest.xlsm")
    modulePath = "C:\projects\toramame-hub\vbe-client-mini\xlsms\src_macrotest.xlsm\Module2.bas"
End If

if moduleFolderPath = "" Then
  moduleFolderPath = fso.GetParentFolderName(bookPath) & "\src_" & fso.GetFileName(bookPath) 
End If

'' debug output information
LogDebug "################", WScript.ScriptName
LogDebug "bookPath", bookPath
LogDebug "modulePath", modulePath
LogDebug "moduleFolderPath", moduleFolderPath

IF fso.FolderExists(moduleFolderPath) = False Then
    WScript.StdErr.WriteLine ("No src Folder: " & moduleFolderPath)
    WScript.Quit(10)
End If



'' 
On Error Resume Next

'' from vbsCommon.vbs
OpenDocumentFileWE bookPath

Dim book
Set book = GetObject(bookPath)
Dim vbaApplication
Set vbaApplication = book.Application

If Err.Number <> 0 Then
    WScript.StdErr.WriteLine ("Can not application: " & bookPath)
    book.Close
    WScript.Quit(Err.Number)
End If
On Error Goto 0

'' running check
call TestRunningVba()


On Error Resume Next
'' delete modules form xlsm

Call DeleteVbaModules(book, modulePath, isUseFromModule, isUseSheetModule)

If Err.Number <> 0 Then
    WScript.StdErr.WriteLine ("Can not delete modules: " & bookPath)
    WScript.Quit(Err.Number)
End If
On Error Goto 0

On Error Resume Next
''' Import VBA module files
Call importVbaModules(fso.GetFolder(moduleFolderPath), book, bookPath, modulePath, isUseFromModule, isUseSheetModule)
book.Save

If Err.Number <> 0 Then
    WScript.StdErr.WriteLine ("Can not import modules: " & bookPath)
    LogDebug "importVbaModules Err", Err.description
    WScript.Quit(Err.Number)
End If
On Error Goto 0

WScript.StdOut.WriteLine "Import Complete"
WScript.Quit(0)


''///////////////////////////
'' if moduleName is empty, delete all modules.
Function DeleteVbaModules(book, modulePath, isUseFromModule, isUseSheetModule)
    Dim vBComponents 
    Set vBComponents = book.VBProject.VBComponents

    Dim moduleName
    Dim isSrcSheetCls
    moduleName = GetModuleName(modulePath, isSrcSheetCls) 'filename without .ext
    
    Dim vbComponent 
    For Each vbComponent In vBComponents
        If (moduleName = "" Or LCase(moduleName) = LCase(vbComponent.Name)) Then
            If vbComponent.Type = 100 Then
                If isUseSheetModule Then
                    vbComponent.CodeModule.DeleteLines 1, vbComponent.CodeModule.CountOfLines
                    LogDebug "Delete Content",vbComponent.Name
                End If
            ElseIf vbComponent.Type = 3 Then
                If isUseFromModule Then
                    LogDebug "Remove vbComponent",vbComponent.Name
                    vBComponents.Remove vbComponent
                End If
            Else
                '' 2(cls), 1(bas)
                LogDebug "Remove vbComponent",vbComponent.Name
                vBComponents.Remove vbComponent
            End If
        End If
    Next 
End Function

'' if modulePath is empty, import all modules.
Public Sub importVbaModules(modulesFolder, book, applicationDocumentPath, modulePath, isUseFromModule, isUseSheetModule)
    'As VBIDE.VBComponents
    Dim vBComponents
    Set vBComponents = book.VBProject.VBComponents
    
    Dim fso    
    Set fso = CreateObject("Scripting.FileSystemObject")

    '' xxxx.sht.cls must convert to xxx
    Dim moduleName
    moduleName = ""
    If applicationDocumentPath <> "" Then
      moduleName = LCase(fso.GetFileName(modulePath))
    End If

    Dim objFile
    Dim fileExtension
    For Each objFile In fso.GetFolder(modulesFolder).Files
        '' selected module or all modules
        If moduleName = LCase(objFile.Name) Or moduleName = "" Then
          fileExtension = LCase(fso.GetExtensionName(objFile.Name))
          If  fileExtension = "bas" Then
              Call vBComponents.Import (objFile.Path)
              LogDebug "Import bas module", objFile.Path
          ElseIf fileExtension = "frm" Then
              Call importFormModule(vBComponents, objFile.Path, isUseFromModule)
          ElseIf (fileExtension = "cls") Then
              '' cls file include a normal cls or sheet cls
              importClassModule applicationDocumentPath, objFile.Path, isUseSheetModule
          End If
        End if
        If Err.Number <> 0 Then
            WScript.StdErr.WriteLine ("Can not import modules: " & bookPath)
            LogDebug "importVbaModules Err", Err.description
            WScript.Quit(Err.Number)
        End If

    Next

    Set modulesFolder = Nothing
    Set objFile = Nothing
End Sub

'' import class module
Public Function importClassModule(applicationDocumentPath, modulePath, isUseSheetModule)
    Dim fso    
    Set fso = CreateObject("Scripting.FileSystemObject")

    '' check .sht.cls or normal.cls
    Dim moduleName
    Dim isSrcSheetCls
    moduleName = GetModuleName(modulePath, isSrcSheetCls)

    Dim book
    Set book = GetObject(applicationDocumentPath)

    Dim vbComponent
    Dim IsSheet
    IsSheet = False
    For Each vbComponent in book.VBProject.VBComponents
        If moduleName = vbComponent.Name And vbComponent.Type = 100 Then
            IsSheet = True
            Exit For
        End if
    Next

    If IsSheet and isSrcSheetCls then
        If isUseSheetModule Then
            Dim sourceFile
            Set sourceFile  = fso.OpenTextFile(modulePath)
            Dim fileContent
            fileContent = sourceFile.ReadAll
            sourceFile.Close
            Set sourceFile = Nothing
            LogDebug "Import sheet cls Content", vbComponent.Name
            vbComponent.CodeModule.InsertLines 1, fileContent
        End If
    ElseIf isSrcSheetCls Then
        '' module is sheet cls, but the book has not the sheet name
        '' do not import
    Else
        LogDebug "Import cls module", modulePath
        book.VBProject.VBComponents.Import modulePath
    End if

    Set book = Nothing
    Set vbComponent = Nothing
    set fso = Nothing
End Function

Public Function importFormModule(vBComponents, modulePath, isOptionImport)
    If isOptionImport = False Then
        Exit Function
    End if

    Call vBComponents.Import (modulePath)
    LogDebug "Import frm module", modulePath 

    Dim fso    
    Set fso = CreateObject("Scripting.FileSystemObject")
    Dim moduleName
    moduleName = fso.GetBaseName(modulePath) 'filename without .ext

    With VBComponents(moduleName).CodeModule
        If .CountOfLines <= 1 Then
            Exit Function
        End IF

        '' when import, one line is added. here delete the line. 
        If Trim(.Lines(1, 1)) = "" Then
            Call .DeleteLines(1, 1)
        End if
    End With
End Function



