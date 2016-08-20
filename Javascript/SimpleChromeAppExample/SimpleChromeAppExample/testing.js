var file;

$(function(){
	fileStorageLocation = "ChromeUtilsFileStorageLocation";
	chromeUtils = new ChromeUtils(fileStorageLocation);
	if (chromeUtils.file != null){
		console.log("first");
		$("#filePath").html(chromeUtils.file.fullPath);
	}
	console.log("first2");
	
	//  
	$("#saveBtn").click(function(){
		chromeUtils.saveFile();
	});
	
	$("#openFile").click(function(){
		chromeUtils.openFile();
		if (chromeUtils.file != null){
			$("#textareaEditor").val(chromeUtils.fileContent);
			$("#filePath").html(chromeUtils.file.fullPath);
		}
	});
	
});

