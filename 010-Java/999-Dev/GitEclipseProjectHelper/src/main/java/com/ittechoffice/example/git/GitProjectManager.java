package com.ittechoffice.example.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.dircache.DirCache;

import com.ittechoffice.example.fx.Appl;

public class GitProjectManager {
	
	private Git git;
	private String path;
	
	public GitProjectManager(String Path) throws GitAPIException{
		System.out.println("RUNNING");
		this.path = path;
        Git git = Git.init()
                .setDirectory(new File(Path))
                .call();
        DirCache dirCache = git.add().addFilepattern(".").call();
        System.out.println("Dir Cache Entry Count" + dirCache.getEntryCount());
        git.commit().setMessage("Updated by GitAssistant4e").call();
        git.pull().call();
	}
	
	public static void main(String[] args) throws GitAPIException{
		GitProjectManager GitProjectManager = new GitProjectManager(Appl.properties.getProperty(Appl.EXAMPLE_HOME));
	}
	
}
