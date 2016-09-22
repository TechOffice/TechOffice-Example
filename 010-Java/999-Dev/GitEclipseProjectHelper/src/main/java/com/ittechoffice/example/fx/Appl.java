package com.ittechoffice.example.fx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ittechoffice.example.mvn.MavenProjectManager;

public class Appl {
	
	public static final String CONFIG_FOLDER_NAME = ".ittechoffice";
	public static final String APP_PROPERTIES_FILE = "application.properties";
	public static final String EXAMPLE_HOME = "example_home";
	
	public static Properties properties  = null;
	
	static {
		try {
			String homePath = System.getProperty("user.home");
			String configFolderPath = homePath + "\\" + CONFIG_FOLDER_NAME;
			File propertyFile = new File(configFolderPath, APP_PROPERTIES_FILE);
			File configFolder = new File(configFolderPath);
			if (!configFolder.exists()){
				configFolder.mkdirs();
			}
			propertyFile.createNewFile();
			FileInputStream inputStream = new FileInputStream(propertyFile);
			properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		String exampleHome = Appl.properties.getProperty(Appl.EXAMPLE_HOME);
		MavenProjectManager mavenProjectManager = new MavenProjectManager(exampleHome);
		mavenProjectManager.findMavenProject();
		mavenProjectManager.completedMissingFolder();
	}
}
