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
	private FileExplorer fileExplorer;
	
	private Status status = Status.VIEW;
	private boolean selected = false;
	
	public enum Status {
		VIEW, EDIT;
	}
	
	public FxFile(File file, FileExplorer fileExplorer){
		this.name = file.getName();
		this.path = file.getPath();
		this.fileExplorer = fileExplorer;
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
				if (!selected){
					label.setStyle("-fx-background-color: LightSkyBlue ");
				}
				
			}
		});
		label.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				if (!selected){
					label.setStyle("-fx-background-color: transparent");
				}
			}
		});
		final FxFile that = this;
		label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
			public void handle(MouseEvent arg0) {
				fileExplorer.setSelectedFile(that);
				select();
			}
		});

		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER){
					rename();	
				}
				
			}
		});
	}
	
	public void select(){
		selected = true;
		label.setStyle("-fx-background-color: blue");
	}
	
	public void unselect(){
		selected = false;
		if (status.equals(Status.EDIT)){
			rename();
		}
		label.setStyle("-fx-background-color: transparent");
	}
	
	public void edit(){
		this.label.setVisible(false);
		this.textField.setVisible(true);
		this.status = Status.EDIT;
	}
	
	public void rename(){
		this.label.setVisible(true);
		this.textField.setVisible(false);
		String newFileName = textField.getText();
		this.name = newFileName;
		this.label.setText(newFileName);
	}
	
}
