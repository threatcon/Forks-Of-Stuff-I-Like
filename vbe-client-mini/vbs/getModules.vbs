Option Explicit
'' getModules.vbs
'' get count of modules in a vbe project
''

'' load external vbs.
Dim fso
Set fso = createObject("Scripting.FileSystemObject")
Execute fso.OpenTextFile(fso.getParentFolderName(WScript.ScriptFullName) & "\vbsCommon.vbs").ReadAll()

'' get gook path
Dim projectRoot
projectRoot = fso.getParentFolderName(fso.getParentFolderName(WScript.ScriptFullName))
Dim bookPath
If WScript.Arguments.Count = 1 Then
    bookPath = WScript.Arguments(0)
Else
    '' for debug
    bookPath = fso.BuildPath(projectRoot, "xlsms\macrotest.xlsm")
End If

'' debug output information
LogDebug "################", WScript.ScriptName
LogDebug "bookPath", bookPath


If fso.FileExists(bookPath) = False Then
    WScript.StdEr.WriteLine "File does not exists: " & fso.GetFileName(bookPath) 
    WScript.Quit(10)
End If

Dim dirModules
dirModules = fso.GetParentFolderName(bookPath) & "\src_" & fso.GetFileName(bookPath)

'' from vbsCommon.vbs
OpenExcelFileWE bookPath

Dim book
Set book = GetObject(bookPath)
Dim vbaApplication 
set vbaApplication = book.Application

'' export modules
If book.VBProject.Protection <> 0 Then
    vbaApplication.Close
    set vbaApplication = Nothing
    WScript.Quit(10)
end If

On Error Resume Next
'' do something
Dim VBComponents
Set VBComponents = book.VBProject.VBComponents
Dim count
' count = VBComponents.Count
' WScript.StdOut.WriteLine count
count = 0
Dim vbComponent
For Each vbComponent In VBComponents
  If vbComponent.CodeModule.CountOfLines > 0 Then
      IF vbComponent.Type = 100 Then
          count = count + 1
      ElseIf vbComponent.Type = 1  Then 'bas
          count = count + 1
      ElseIf vbComponent.Type = 2  Then 'cls
          count = count + 1
      ElseIf vbComponent.Type = 3 Then 'frm
          count = count + 2
      End If
  End If
Next
WScript.StdOut.WriteLine count

If Err.Number <> 0 Then
    WScript.StdErr.WriteLine "Error get vba modules."
    WScript.Quit(Err.Number)
End If
On Error Goto 0

Set book = Nothing
Set vbaApplication = Nothing
Set fso = Nothing
WScript.Quit(0)
