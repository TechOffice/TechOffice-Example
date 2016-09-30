package com.ittechoffice.example;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

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
		String webappPath = webappFile.getPath();
		System.out.println(webappFile);
		
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setDescriptor(webappPath+"/WEB-INF/web.xml");
        context.setResourceBase(webappPath);
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();
        server.join();

		
	}
}
