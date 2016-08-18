package com.ittechoffice.example;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleSpringWebSocketController {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(100); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }
	
	@RequestMapping("/")
	public String subscribe(){
		return "subscribe";
	}

}
