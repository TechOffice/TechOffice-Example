package com.ittechoffice.example.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ittechoffice.example.example.FeNotFolderException;
import com.ittechoffice.example.model.FeFile;
import com.ittechoffice.example.model.FeFile.FeFileType;

@Service
public class FileExploerService {
	
	public List<FeFile> list(String parent) throws FeNotFolderException{
		List<FeFile> feFileList = new ArrayList<FeFile>();
		File folder = new File(parent);
		if (!folder.isDirectory()){
			throw new FeNotFolderException();
		}
		String[] fileNames = folder.list();
		for (String fileName: fileNames){
			File file = new File("parent/" + fileName);
			FeFile feFile = new FeFile();
			feFile.setParent(parent);
			feFile.setName(fileName);
			if (file.isFile()){
				feFile.setType(FeFileType.file);
			}else if (file.isDirectory()){
				feFile.setType(FeFileType.folder);
			}
			feFileList.add(feFile);
		}
		return feFileList;
	}
	
}
