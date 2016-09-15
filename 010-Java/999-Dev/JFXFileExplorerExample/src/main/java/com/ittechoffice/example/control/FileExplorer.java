package com.ittechoffice.example.control;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FileExplorer extends VBox {
	
	private String path;
	
	public FileExplorer(String path){
		this.path = path;
		init();
	}
	
	private void init(){
		File dir = new File(path);
		File[] files = dir.listFiles();
		for(int i =0; i<files.length; i++){
			File file = files[i];
			FxFile fxFile = new FxFile(file);
			this.getChildren().add(fxFile);
		}
	}
	
	
}
