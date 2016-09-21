package com.ittechoffice.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.ittechoffice.example.javaproj.MavenProjectManager;

public class Appl {
	
	public static final String CONFIG_FOLDER_NAME = ".ittechoffice";
	public static final String APP_PROPERTIES_FILE = "application.properties";
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
		String exampleHome = Appl.properties.getProperty("example_home");
		MavenProjectManager helper = new MavenProjectManager(exampleHome);
		helper.findMavenProject();
		helper.completedMissingFolder();
	}
}
