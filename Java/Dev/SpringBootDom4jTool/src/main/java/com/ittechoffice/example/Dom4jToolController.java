package com.ittechoffice.example;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Dom4jToolController {
	
	@Autowired
	private Dom4jToolService dom4jToolService;
	
	@RequestMapping("/")
	public String home(){
		return "Dom4jTool";
	}
	
	@RequestMapping("/parse")
	@ResponseBody
	public String parse(@RequestParam(value="xml", required=true) String xml) throws DocumentException{
		return dom4jToolService.parse(xml);
	}
	
	@ExceptionHandler({DocumentException.class})
	@ResponseBody
	public String dom4jError(HttpServletRequest req, Exception ex) {
		ex.printStackTrace();
		return "Dom4J Exception";
	}
}
