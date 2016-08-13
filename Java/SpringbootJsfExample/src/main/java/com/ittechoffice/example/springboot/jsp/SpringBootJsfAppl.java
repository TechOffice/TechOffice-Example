package com.ittechoffice.example.springboot.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class SpringBootJsfAppl extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootJsfAppl.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootJsfAppl.class, args);
	}
}
