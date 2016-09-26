package test.ittechoffice.example.mvn;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.ittechoffice.example.fx.Appl;
import com.ittechoffice.example.mvn.MavenProjectManager;

public class MavenProjectManagerTest {
	
	@Test
	public void getDummyFileListTest(){
		String exampleHome = Appl.properties.getProperty(Appl.EXAMPLE_HOME);
		MavenProjectManager mavenProjectManager = new MavenProjectManager(exampleHome);
		mavenProjectManager.getMavenProjectList();
		List<File> dummyFileList = mavenProjectManager.getDummyFileList();
		for(File dummyFile: dummyFileList){
			System.out.println(dummyFile.getPath());
		}
	}
}
