package com.yedam.smartree.websocket;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloMessage {
	  private String sender;
	  private String content;
	  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Seoul")
	  private Date sendTime;
	  
	  
	  
	  private String cmd;
}
