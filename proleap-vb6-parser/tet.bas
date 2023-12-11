Attribute VB_Name = "modCreateMenuLists"
Option Explicit

Sub CreateMenuLists(ByRef PageCollection As Collection, ByRef PageGroup As Pages)

    Dim Drawing As PageInfo, Index As Long, Page As Visio.Page, ListItems As Long, ItemList As Long, NavigationPages As String, DrawingList As String, NewRow As Long
    
    Index = 1
    ListItems = PageGroup.Count - 1
    ItemList = 0
    
    For Each Drawing In PageCollection
        If Index = 1 Then
            NavigationPages = Drawing.PageName
            DrawingList = Drawing.DrawingReference
        Else
            NavigationPages = NavigationPages & "," & Drawing.PageName
            DrawingList = DrawingList & "," & Drawing.DrawingReference
        End If
        Index = Index + 1
    Next
    
    Index = 1

    For Each Page In PageGroup
        Set Page = PageGroup.Item(Index)
        Set Drawing = New PageInfo
        
        NewRow = Page.PageSheet.AddRow(visSectionUser, visRowLast, visTagDefault)
        Page.PageSheet.CellsSRC(visSectionUser, NewRow, visUserValue).RowNameU = "DrawingList"
        Page.PageSheet.CellsSRC(visSectionUser, NewRow, visUserValue).FormulaU = """" & DrawingList & """"
        NewRow = Page.PageSheet.AddRow(visSectionUser, visRowLast, visTagDefault)
        Page.PageSheet.CellsSRC(visSectionUser, NewRow, visUserValue).RowNameU = "PageNames"
        Page.PageSheet.CellsSRC(visSectionUser, NewRow, visUserValue).FormulaU = """" & NavigationPages & """"
        
'        Page.PageSheet.DeleteRow visSectionUser, visRowLast
'        Page.PageSheet.DeleteRow visSectionUser, visRowLast
        Index = Index + 1
        
    Next

End Sub
