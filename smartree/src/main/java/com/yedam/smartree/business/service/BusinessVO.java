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
	private String prodPlanYn;
	//주문상세
	private String orderDtCode;
	private String prdtName;
	private String prdtCode;
	private int orderDtCnt;
	private int orderDtPrice;
	int prdtTotal;
	

	private String prodPlanCnt;
	private int prodRank;
	private String prodPlanNote;

	private int prdtOutCnt;//출고수량
	private int prdtLeftCnt;//잔여수량


	
}
