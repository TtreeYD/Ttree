package com.yedam.smartree.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloMessage {
	  private String sender;
	  private String name;
	  private String cmd;
}
