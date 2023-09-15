package com.yedam.smartree.business.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BusinessVO {
	//주문테이블
	private String orderCode;
	private String bpCode;
	private String bpName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date orderDate;
	private String orderManager;
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	@JsonFormat(pattern = "yyyy-MM-dd" , timezone = "Asia/Seoul")
	private Date dodDate;
	private String dodState;
	
	//주문상세
	private String orderDtCode;
	private String prdtName;
	private String prdtCode;
	private int orderDtCnt;
	
	//거래처목록
	
}
