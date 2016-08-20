ChromeUtils = function(fileStorageLocation){
	/**
	* Storage Key for storing file entry
	*/
	this.fileStorageLocation = fileStorageLocation;
	/**
	* file entry
	*/
	this.file;
	/**
	* Content of file entry
	*/
	this.fileContent;
	
	//init 
	this.init();
};

ChromeUtils.prototype = {
	/**
	*
	*/
	init: function(){
		console.log("init");
		that = this;
		storageFileObj = {};
		storageFileObj[this.fileStorageLocation] = null;
		$.when(
			
				chrome.storage.sync.get(storageFileObj, 
					function(items){
						if (items[that.fileStorageLocation] != null){
							chrome.fileSystem.restoreEntry(items[that.fileStorageLocation], function(entry){
								that.file = entry
							});
						}
				    }
				)
			
			
			
			
		).done(function(){
			console.log("completed");
		});
	},
	/**
	* Open File
	*/
	openFile: function(){
		that = this;
		chrome.fileSystem.chooseEntry({type:"openWritableFile"}, function(entity){
			that.file = entity;
			that.file.file(function(file){
				fileReader = new FileReader();
				fileReader.onload = function(e){
					that.fileContent = e.target.result;
				}
				fileReader.readAsText(file);			
			});
			// sync entity to storage
			storageObj = {}
			storageObj[that.fileStorageLocation] = chrome.fileSystem.retainEntry(entity);
			chrome.storage.sync.set(storageObj);
		});
	},
	/**
	* Save File
	*/
	saveFile: function(content){
		that = this;
		if (this.file != null){
			this.file.createWriter(function(writer){
				writer.onwriteend = function(e){
					console.log("completed");
				}
				writer.write(
					new Blob( [content] ),
					{type:"text/plain"}
				);
			});
		}	
	}
};