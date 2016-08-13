package com.ittechoffice.example;

import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
    
	@RequestMapping("/")
	public String home() {
        return "welcome";
    }
	
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder().sources(SampleController.class).run(args);
    }

}
