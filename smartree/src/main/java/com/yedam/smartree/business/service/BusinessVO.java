package com.yedam.smartree.business.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BusinessVO {
	//주문테이블
	private String orderCode;
	private String bpCode;
	private String bpName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	private String orderManager;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dodDate;
	private String dodState;
	
	//주문상세
	private String orderDtCode;
	private String prdtName;
	private int orderDtCnt;
	
}
