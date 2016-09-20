package com.ittechoffice.example.control;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FxPath extends Pane{
	private String path;
	
	public FxPath(String path){
		this.path = path;
		Label pathLabel = new Label(path);
		this.getChildren().add(pathLabel);
	}
	
}
