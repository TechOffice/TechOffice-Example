package com.ittechoffice.example;
import java.io.File;
import java.nio.file.Paths;

public class Appl {
	public static void main(String[] args) throws Exception{
//        Server server = new Server(8080);
//        ServletHandler handler = new ServletHandler();
//        server.setHandler(handler);
//        
//        handler.addServletWithMapping(ApplServlet.class, "/*");
//        
//        server.start();
//        server.join();
		String root = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
		File webappFile = new File(root, "src/webapp");
		System.out.println(root);
	}
}
