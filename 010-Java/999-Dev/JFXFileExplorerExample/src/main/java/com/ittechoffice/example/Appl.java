package com.ittechoffice.example;

import com.ittechoffice.example.control.FileExplorer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Appl extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		 VBox root = new VBox();
		 Scene scene = new Scene(root, 500, 500, Color.WHITE);

		 Label label = new Label("Hello World JavaFX");
		 root.getChildren().add(label);
		 
		 FileExplorer fileExplorer = new FileExplorer("D://");
		 root.getChildren().add(fileExplorer);

		 primaryStage.setTitle("Hellow World JavaFX");
		 primaryStage.setScene(scene);
		 primaryStage.show();		
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
