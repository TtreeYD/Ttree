package com.yedam.smartree.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import groovy.util.logging.Log4j2;

@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler{
	
	 // message
	   @Override
	   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

	   }

	   // connection established
	   @Override
	   public void afterConnectionEstablished(WebSocketSession session) throws Exception {

	   }

	   // connection closed
	   @Override
	   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	   
	   }
}
