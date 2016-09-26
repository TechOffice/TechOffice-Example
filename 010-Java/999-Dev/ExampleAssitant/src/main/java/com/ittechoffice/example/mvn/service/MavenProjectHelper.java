package com.ittechoffice.example.mvn.service;

import java.io.File;

public class MavenProjectHelper {
	
	public static boolean isMavenProject(File folder){
		File[] files = folder.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.getName().equals("pom.xml")){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMissingGitKeep(File file){
		File mainResources = new File(file.getPath() + "/src/main/resources/.gitkeep");
		File testJava = new File(file.getPath() + "/src/test/java/.gitkeep");
		File testResources = new File(file.getPath() + "/src/test/resources/.gitkeep");
		if (!mainResources.exists()){
			return true;
		}
		if (!testJava.exists()){
			return true;
		}
		if (!testResources.exists()){
			return true;
		}
		return false;
	}
}
