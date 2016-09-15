package com.ittechoffice.example.control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.VBox;

public class FileExplorer extends VBox {
	
	private String path;
	private FxFile selectedFile;
	private List<FxFile> fxFiles;
	
	public FileExplorer(String path){
		this.path = path;
		fxFiles = new ArrayList<FxFile>();
		init();
	}
	
	private void init(){
		File dir = new File(path);
		File[] files = dir.listFiles();
		for(int i =0; i<files.length; i++){
			File file = files[i];
			FxFile fxFile = new FxFile(file, this);
			fxFiles.add(fxFile);
			this.getChildren().add(fxFile);
		}
		
	}
	
	public void setSelectedFile(FxFile fxFile){
		if (selectedFile != null){
			selectedFile.unselect();
		}
		this.selectedFile = fxFile;
	}
	
	public void renameFile(){
		if (selectedFile != null){
			selectedFile.edit();
		}
	}
	
	public void nextFile(){
		if (selectedFile != null){
			int selectedIndex = this.fxFiles.indexOf(selectedFile);
			if (selectedIndex < this.fxFiles.size() ){
				int index = selectedIndex + 1;
				FxFile fxFile = this.fxFiles.get(index);
				this.setSelectedFile(fxFile);
			}
		}
	}
	
}
