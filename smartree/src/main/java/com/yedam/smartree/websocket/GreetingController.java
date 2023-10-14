package com.yedam.smartree.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	  public Greeting greeting(HelloMessage message) throws Exception {
		String sender = message.getSender();
	    Thread.sleep(300);
	    return new Greeting(HtmlUtils.htmlEscape(sender + ": " + message.getName()));
	  }
	
}
