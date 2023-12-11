Option Explicit

Dim FSO
Set FSO = createObject("Scripting.FileSystemObject")

Dim objDocument
Dim myDocument
set myDocument = GetObject(bookPath)
Dim vbaApplication

vbaApplication = myDocument.application

Dim isLogInfo
isLogInfo = True

Dim ProjectRoot
ProjectRoot = GetProjectRoot()


Sub OpenDocumentFileWE(bookPath)
  '' is objDocument running?
  Dim IsRunApp
  On Error Resume Next
  Set objDocument = GetObject(vbaApplication)
  IsRunApp= True
  If Err.Number <> 0 OR objDocument Is Nothing Then
    '' if false, launch excel
    IsRunApp = False
  End If
  On Error Goto 0

  '' if not running, start objDocument
  On Error Resume Next
  If IsRunApp= False Then
    Set objDocument = CreateObject(vbaApplication)
  End If

  If Err.Number <> 0 OR objDocument Is Nothing Then
    WScript.StdErr.WriteLine "Can not run objDocument"
    objDocument = Nothing
    LogDebug "CreateObject error", "Can not get application instance"
    WScript.Quit(100)
  End If
  objDocument.visible = True

  On Error Goto 0
  '' if xlam and no book, create new book.
  Dim ext
  Dim bookTemp
  ext = LCase(FSO.GetExtensionName(bookPath)) ' without dot extension
  Dim pageCount
  if vbaApplication = vbaApplication then
     pageCount = objDocument.Workbooks.Count
  else
    pageCount = objDocument.Documents.Count
  end if
  LogDebug "Pages", pageCount
  
  If pageCount = 0 And ext = "xlam" Then
    set bookTemp = objDocument.Workbooks.Add()
    LogDebug "Add book to Excel instance", ""
  End if

  '' check, is open target Excel file 
  Dim bookName
  bookName = FSO.GetFileName(bookPath)
  LogDebug "Document name is: ", bookName

  Dim item, IsOpenFile
  IsOpenFile = False
  For Each item in objDocument.item
    If LCase(item.Name) = LCase(bookName) Then    
      IsOpenFile = True
      Exit For
    End if
  Next
  
  '' get book instance
  On Error Resume Next
  Dim myDocument
  If IsOpenFile = False Then

    if vbaApplication = vbaApplication then
      Set myDocument = objDocument.Workbooks.Open(bookPath)
    else
      Set myDocument = objDocument.Documents.Open(bookPath)
    end if

  Else
    Set myDocument = GetObject(bookPath)
  End if

  If Err.Number <> 0 OR myDocument Is Nothing Then
    WScript.StdErr.WriteLine "Can not Get Document."
    Set objDocument = Nothing
    WScript.Quit(100)
  End If
  
  Set objDocument = Nothing
  Call Catch("OpenDocumentFileWE", 9999)
  On Error Goto 0
End Sub


Sub CloseDocumentFileWE(bookName)
  '' is objDocument running?
  Dim IsRunApp
  On Error Resume Next
  Set objDocument = GetObject(,vbaApplication)
  If objDocument Is Nothing Then
      LogDebug "Info", "No application running"
      WScript.Quit(0)
  End If
  
  If Err.Number <> 0 Then
      LogDebug "Err", Err.Description
      WScript.Quit(Err.Number)
  End If
  On Error Goto 0

  On Error Resume Next
  Dim item, IsOpenFile
  IsOpenFile = False
  For Each item in objDocument.item
    If LCase(item.Name) = LCase(bookName) Then    
      IsOpenFile = True
      item.Close False
      Exit For
    End if
  Next

  Call Catch("CloseDocumentFileWE", 9999)
End Sub


Function DeleteFilesInFolder(folderPath)
    LogDebug "Delete files in the folder", folderPath
    If folderPath = "" Then
        Exit Function
    End if
    Dim objFolder

    Set objFolder = FSO.GetFolder(folderPath)
    Dim objFile
    Dim objFileName
    For each objFile in objFolder.files
        objFileName = objFile.Name
        FSO.DeleteFile folderPath & "\" & objFileName
        LogDebug "Removed", objFileName
    Next
    Call Catch("DeleteFilesInFolder", 9999)
End Function



Function GetProjectRoot()
  GetProjectRoot = FSO.getParentFolderName(FSO.getParentFolderName(WScript.ScriptFullName))
End Function


Sub OpenVbe()
  On Error Resume Next
  Set objDocument = GetObject(,vbaApplication)
  If objDocument Is Nothing Then
      WScript.StdErr.WriteLine ("Create application instance!!")
      WScript.Quit(4000)
  End If

  '' open vbe 1695
  On Error Resume Next
  on error goto 0
  Dim ctrl
  Set ctrl = GetMenuCtrlWE(1695)
  If Err.Number <> 0 Or ctrl Is Nothing Then
      WScript.StdErr.WriteLine ("Check objDocument Object Model Security")
      WScript.StdErr.WriteLine Err.Description
  Else
      If ctrl.Enabled = True Then
          ctrl.Execute
      Else
          '' not enable
      End IF
  End If

  Call Catch("OpenVbe", 9999)
End Sub



Sub TestIfCompiled()
    on error resume Next
    Dim ctrlCompile
    Set ctrlCompile = GetVbeMenuCtrlWE(578)

    If ctrlCompile.Enabled = True Then
      call LogInfo("TestIfCompiled", "do compile.")
      ctrlCompile.Execute
    Else
      call LogInfo("TestIfCompiled", "vba already complied, go a head")
    End IF

    If ctrlCompile.Enabled = True Then
      Call OpenVbe()
      WScript.StdErr.WriteLine "Can not compile VBA. May be a compile error!! Check VBE"
      WScript.Quit(100)
    End if
    Call Catch("TestIfCompiled", 9999)
End Sub

Sub TestRunningVba()
    on error resume Next
    Set objDocument = GetObject(,vbaApplication)
    Dim ctrlPause
    ''pause 189
    Set ctrlPause  = GetVbeMenuCtrlWE(189)

    If ctrlPause.Enabled = True Then
      '' vba not running, go a head.
      call LogInfo("TestRunningVba", "vba not running, go a head")
    Else
      '' now pause, so not enabled.
      Call OpenVbe()
      WScript.StdErr.WriteLine ("Can not run. May be paused in VBE.")
      WScript.Quit(1003)
    End IF
    on error goto 0

    '' test vba run or not
    on error resume Next
    Dim ctrlContinue
    ''continue 186
    Set ctrlContinue = GetVbeMenuCtrlWE(186)

    If ctrlContinue.Enabled = True Then
      '' vba not running, go a head.
    Else
      '' now pause, so not enabled.
      Call OpenVbe()
      WScript.StdErr.WriteLine ("Can not run. May be running in VBE.")
      WScript.Quit(1006)
    End IF

    Call Catch("TestRunningVba", 9999)
End Sub

Sub ActivateVbeProjectWE(projectFilePath)
    Set objDocument = GetObject(,vbaApplication)

    On error Resume Next
    Dim targetFilePath
    targetFilePath = LCase(projectFilePath)
    Dim n
    For Each n In objDocument.VBE.VBProjects
        If LCase(n.FileName) = targetFilePath Then
            Set objDocument.VBE.ActiveVBProject = n
            LogDebug "Activate Project", objDocument.VBE.ActiveVBProject.Name
            Exit For
        End if

        If Err.Number = 76 Then
            ' do next
        ElseIf Err.Number <> 0 Then
          WScript.StdErr.WriteLine ("ActivateVbeProjectWE error: " & projectFilePath)
          WScript.StdErr.WriteLine Err.Description
          WScript.Quit(1007)
        End If
    Next

    Call Catch("ActivateVbeProjectWE error: " & projectFilePath, 9999)
End Sub

Function GetMenuCtrlWE(commandIndex)
  On Error Resume Next
  Set objDocument = GetObject(,vbaApplication)
  Dim ctrl
  Set ctrl = objDocument.Application.CommandBars.FindControl(, commandIndex)
  Call Catch("Get command error: " & CStr(commandIndex), 2011)

  If ctrl Is Nothing Then
      WScript.StdErr.WriteLine ("Get command error: " & CStr(commandIndex))
      WScript.StdErr.WriteLine Err.Description
      WScript.Quit(2011)
  End If
  Set GetMenuCtrlWE = ctrl
  Call Catch("GetMenuCtrlWE: " & CStr(commandIndex), 9999)
End Function

Function GetVbeMenuCtrlWE(commandIndex)
  On Error Resume Next
  Set objDocument = GetObject(,vbaApplication)
  Dim ctrl
  Set ctrl = objDocument.VBE.ActiveVBProject.VBE.CommandBars.FindControl(, commandIndex)
  Call Catch("Get command error: " & CStr(commandIndex), 2011)

  If ctrl Is Nothing Then
      WScript.StdErr.WriteLine ("Get Vbe command error: " & CStr(commandIndex))
      WScript.StdErr.WriteLine Err.Description
      WScript.Quit(2011)
  End If
  Set GetVbeMenuCtrlWE = ctrl
  Call Catch("GetVbeMenuCtrlWE", 9999)
End Function

Sub LogDebug(title, value)
  call LogCore("DBG", title, value)
End Sub
Sub LogInfo(title, value)
  If isLogInfo Then
  call LogCore("INF", title, value)
  End if
End Sub
Sub LogError(title, value)
  call LogCore("ERR", title, value)
End Sub

Sub LogCore(messageType, title, value)
    ''exit Sub
    Dim outTitle
    Dim outValue
    outTitle = title
    outValue = value
    If outTitle = "" Then
        outTitle = "(_empty_)"
    End if
    If outValue = "" Then
        outValue = "(_empty_)"
    End if
    WScript.StdOut.WriteLine "VBS:" & messageType & ":" & outTitle & " : " & outValue
End Sub

Function GetModuleName(modulePath, refIsSheetClass)
    '' sheet module is exported with .sht.cls
    '' test this extension
    Dim fso    
    Set fso = CreateObject("Scripting.FileSystemObject")

    Dim withoutFirstExt
    withoutFirstExt = fso.GetBaseName(modulePath) 'filename without .ext
    GetModuleName = withoutFirstExt

    Dim secondExt
    secondExt = LCase(fso.GetExtensionName(withoutFirstExt))
    
    refIsSheetClass = secondExt = "doc"
    If refIsSheetClass  Then
      GetModuleName = fso.GetBaseName(withoutFirstExt)
    End If
End Function


Function Catch(errMsg, errCodeExit)
  If errCodeExit = 0 Then
    On Error Goto 0
  End If

  If Err.Number <> 0 Then
      WScript.StdErr.WriteLine (errCodeExit)
      WScript.StdErr.WriteLine (errMsg)
      WScript.StdErr.WriteLine Err.Description
      WScript.StdErr.WriteLine erl
      LogError "Catch", errMsg & "(" & Err.Description & ")"
      If errCodeExit > 1000 Then
        WScript.Quit(errCodeExit)
      End if
  End if

  If Err.Number = errCodeExit Then
    Catch = True
    On Error Goto 0
  End If
End Function


Sub Test001()
  LogInfo "Info", "common"
End Sub




