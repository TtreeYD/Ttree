package com.yedam.smartree.websocket;

import java.util.ArrayList;
import java.util.List;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
	
	List<HelloMessage> messageList = new ArrayList<HelloMessage>();
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	  public HelloMessage greeting(HelloMessage message) throws Exception {
		messageList.add(message);
	    Thread.sleep(300);
	    return message;
	  }
	
	@GetMapping("/message")
	@ResponseBody
		public List<HelloMessage> message(){
		
		return messageList;
	}
}
