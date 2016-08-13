package com.ittechoffice.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "Example Project";
	}
	
	@RequestMapping("/access")
	@ResponseBody
	public String access(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null){
			System.out.println("authenticated");
		}
		return "access";
	}
}
