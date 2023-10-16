package com.yedam.smartree.websocket;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@Autowired
	private SimpMessagingTemplate template;

	@GetMapping("/cust")
	public Iterator<String> cust(){
		String text = "[" + new Date() + "]:" + "cust select";
        this.template.convertAndSend("/topic/cust", text);
		return null;
	}
	
	
}
