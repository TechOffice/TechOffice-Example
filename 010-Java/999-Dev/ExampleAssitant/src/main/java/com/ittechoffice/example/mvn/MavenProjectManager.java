package com.ittechoffice.example.mvn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MavenProjectManager {
	
	private String path;
	private List<File> mvnProjList;
	private List<File> invalidMvnProjList;
	
	public MavenProjectManager(String path){
		this.path = path;
		this.mvnProjList = new ArrayList<File>();
		this.invalidMvnProjList = new ArrayList<File>();
	}
	
	public void findMavenProject(File root){
		File[] files = root.listFiles();
		for (int i=0; i<files.length; i ++){
			File file = files[i];
			if (file.isDirectory()){
				if (MavenProjectHelper.isMavenProject(file)){
					mvnProjList.add(file);
					if (MavenProjectHelper.isMissingGitKeep(file)){
						invalidMvnProjList.add(file);
					}
				}else{
					findMavenProject(file);
				}
			}
		}
	}
	
	public void completedMissingFolder() throws IOException{
		for (File file: invalidMvnProjList){
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
		findMavenProject();
	}
	
	public int getNumInvalidMvnProj(){
		return invalidMvnProjList.size();
	}
	
	public int getNumMvnProj(){
		return mvnProjList.size();
	}
	
	public List<File> findMavenProject(){
		System.out.println("Finding Maven Project in " + path);
		this.mvnProjList = new ArrayList<File>();
		this.invalidMvnProjList = new ArrayList<File>();
		File root = new File(path);
		findMavenProject(root);
		System.out.println("Found " + mvnProjList.size() + " Maven Projects");
		return mvnProjList;
	}
	
	
}
