package com.ittechoffice.example.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.ittechoffice.example.fx.Appl;
import com.ittechoffice.example.mvn.MavenProjectManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MavenProjectManagerController implements Initializable {
	
	@FXML
	private Label numMvnProjLabel;
	
	@FXML
	private Label numInvalidMvnProjLabel;
	
	@FXML
	private Label validMvnProjLogLabel;
	
	private MavenProjectManager mavenProjectManager;
	
	public void initialize(URL fxmlFileLocation, ResourceBundle resources){
		String exampleHome = Appl.properties.getProperty(Appl.EXAMPLE_HOME);

		// Init MavenProjectManager  
		mavenProjectManager = new MavenProjectManager(exampleHome);
		mavenProjectManager.findMavenProject();
		int numMvnProj = mavenProjectManager.getNumMvnProj();
		numMvnProjLabel.setText(Integer.toString(numMvnProj));	
		int numInvalidMvnProj = mavenProjectManager.getNumInvalidMvnProj();
		numInvalidMvnProjLabel.setText(Integer.toString(numInvalidMvnProj));
	}
	
    @FXML
    private void validMvnProj(){
    	try {
			mavenProjectManager.completedMissingFolder();
			int numMvnProj = mavenProjectManager.getNumMvnProj();
			numMvnProjLabel.setText(Integer.toString(numMvnProj));	
			int numInvalidMvnProj = mavenProjectManager.getNumInvalidMvnProj();
			numInvalidMvnProjLabel.setText(Integer.toString(numInvalidMvnProj));
			
			validMvnProjLogLabel.setText("Completed");
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }

}
