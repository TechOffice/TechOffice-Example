package com.ittechoffice.example.control;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class FxFile extends Pane{
	private String name;
	private String path;
	
	private Label label;
	private TextField textField;
	
	private Status status = Status.VIEW;
	
	public enum Status {
		VIEW, EDIT;
	}
	
	public FxFile(File file){
		this.name = file.getName();
		this.path = file.getPath();
		
		init();
	}
	
	private void init(){
		label = new Label(name);
		label.setVisible(true);
		textField = new TextField(name);
		textField.setVisible(false);
		this.getChildren().add(label);
		this.getChildren().add(textField);
		label.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				label.setStyle("-fx-background-color: LightSkyBlue ");
			}
		});
		label.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				label.setStyle("-fx-background-color: transparent");
			}
		});
		label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				edit();
			}
		});
		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER){
					String newFileName = textField.getText();
					rename(newFileName);	
				}
			}
		});
	}
	
	public void edit(){
		this.label.setVisible(false);
		this.textField.setVisible(true);
	}
	
	public void rename(String name){
		this.label.setVisible(true);
		this.textField.setVisible(false);
	}
	
}
