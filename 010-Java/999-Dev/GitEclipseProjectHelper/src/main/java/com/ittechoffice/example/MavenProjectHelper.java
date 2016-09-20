package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MavenProjectHelper {
	
	private String path;
	private List<File> mvnProjList;
	private List<File> mvnProjListMissingFolder;
	
	public MavenProjectHelper(String path){
		this.path = path;
		this.mvnProjList = new ArrayList<File>();
		this.mvnProjListMissingFolder = new ArrayList<File>();
	}
	
	private boolean isMavenProject(File folder){
		File[] files = folder.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.getName().equals("pom.xml")){
				return true;
			}
		}
		return false;
	}
	
	private boolean isMissingGitKeep(File file){
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
	
	public void findMavenProject(File root){
		File[] files = root.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.isDirectory()){
				if (isMavenProject(file)){
					mvnProjList.add(file);
					if (isMissingGitKeep(file)){
						mvnProjListMissingFolder.add(file);
					}
				}else{
					findMavenProject(file);
				}
			}
		}
	}
	
	public void completedMissingFolder() throws IOException{
		for (File file: mvnProjListMissingFolder){
			File mainResources = new File(file.getPath() + "/src/main/resources/.gitkeep");
			File mainFolder = new File(file.getPath() + "/src/main");
			File mainResourcesFolder = new File(file.getPath() + "/src/main/resources");

			File testFolder = new File(file.getPath() + "/src/test");
			File testJavaFolder = new File(file.getPath() + "/src/test/java");
			File testResourcesFolder = new File(file.getPath() + "/src/test/resources");
			File testJava = new File(file.getPath() + "/src/test/java/.gitkeep");
			File testResources = new File(file.getPath() + "/src/test/resources/.gitkeep");
			
			if (!mainFolder.exists()){
				mainFolder.mkdirs();
			}
			
			if (!mainResourcesFolder.exists()){
				mainResourcesFolder.mkdirs();
			}
			
			if (!mainResources.exists()){
				System.out.println(mainResources.getPath() + " created");
				mainResources.createNewFile();
			}
			
			if (!testFolder.exists()){
				testFolder.mkdirs();
			}
			
			if (!testJavaFolder.exists()){
				testJavaFolder.mkdirs();
			}
			
			if (!testResourcesFolder.exists()){
				testResourcesFolder.mkdirs();
			}
			
			if (!testJava.exists()){
				System.out.println(testJava.getPath() + " created");
				testJava.createNewFile();
			}
			
			if (!testResources.exists()){
				System.out.println(testResources.getPath() + " created");
				testResources.createNewFile();
			}
		}
	}
	
	public void findMavenProject(){
		System.out.println("Finding Maven Project in " + path);
		this.mvnProjList = new ArrayList<File>();
		this.mvnProjListMissingFolder = new ArrayList<File>();
		File root = new File(path);
		findMavenProject(root);
		System.out.println("Found " + mvnProjList.size() + " Maven Projects");
	}
}
