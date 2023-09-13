package com.yedam.smartree.prod.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProdVO {
	private String prodPlanCode;
	private String orderCode;
	private String prodPlanName;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prodPlanDate;
	private String prodName;
	private Date prodPlanSdate;
	private Date prodPlanEdate;
	private int prodPlanCnt;
	
	private String dtProdPlanCode;
	private String prdtName;
	private int prdtSs;
	private int prodRank;
	private String prodPlanNote;
	private String prdtCode;
	
}
