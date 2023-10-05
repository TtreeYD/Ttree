package com.yedam.smartree.prod.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ProdVO {
	private String prodPlanCode;
	private String orderCode;
	private String prodPlanName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date prodPlanDate;
	private String prodName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date prodPlanSdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date prodPlanEdate;
	private int prodPlanCnt;
	private String prodPlanNote;
	
	private String dtProdPlanCode;
	
	private String dtProdInstCode;
	private String prodInstCode;
	private String prodInstName;
	private String prodInstManager;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date prodInstDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date prodInstSdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date prodInstEdate;
	private int prodInstRank;
	private int prodInstCnt;
	private int prodinstIncompCnt;
	private String prodInstYn;
	
	
	private String prdtName;
	private int prdtSs;
	private int prodRank;
	private String prdtCode;
	
	
	private String orderDtCode;
	private int orderDtCnt;
	
	
	private String result;
	//완제품공정흐름도
	private String prcsCode;
	private int prcsOrder;
	private int prdtTotal;
	private int prdtProdCnt;
	private int prcsMaxnum;
	private int prdtProdErrCnt;
	
	//공정실적관리
	private String prcsRsCode;
	private String eqmCode;
	private String eqmName;
	@DateTimeFormat(pattern = "HH:mm:ss")
	@JsonFormat(pattern = "HH:mm:ss",timezone = "Asia/Seoul")
	private Date prcsSdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
	private Date prcsEdate;
	private int prdtCnt;
	private int errCnt;
	private int passCnt;
	private String manager;
	private int prdtProdSum;

	private String prcsStdCode;
	private String prcsName;//공정명
	
	// 홀딩
	String holdingCode;
	String mtlLotNum;
	int holdingCnt;

}
