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
	private int prcsNum;
	
	private String prdtName;
	private int prdtSs;
	private int prodRank;
	private String prdtCode;
	
	private String orderDtCode;
	private int orderDtCnt;
	
	private String result;
}
