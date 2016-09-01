package com.ittechoffice.example.springmvc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Controller
public class SimpleController {
	
    private ResponseBodyEmitter emitter;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(ModelMap model){
		return "home";		
	}
	
	@RequestMapping("/emit")
	public ResponseBodyEmitter  handle() {
	    return emitter;
	}

	@RequestMapping("/send")
	@ResponseBody
	public String send(@RequestParam("message") String message) throws IOException{
		emitter.send(message);
		return message;
	}
	
}
