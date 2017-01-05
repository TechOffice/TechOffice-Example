Set fileSystemObject = CreateObject("Scripting.FileSystemObject")
Set objWord = CreateObject("Word.Application")
objWord.Visible = True
Set docFile = fileSystemObject.getFile("Test.docx")
Set activeDocumet = objWord.Documents.Open(docFile.Path)
activeDocumet.ActiveWindow.LargeScroll 1