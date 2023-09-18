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
	
	private String dtProdPlanCode;
	private String prdtName;
	private int prdtSs;
	private int prodRank;
	private String prodPlanNote;
	private String prdtCode;
	
	private String orderDtCode;
	private int orderDtCnt;
	
}
