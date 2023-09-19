package com.yedam.smartree.prod.service;

import lombok.Data;

@Data
public class PrdtProdVO {
	//거래처
	private String bpCode;
	private String bpName;
	private String bpType;
	private String bpMain;
	//제품
	private String prdtCode;
	private String prdtName;
	private String prdtType;
	private String prdtUnit;
	
	private String prodPlanCode;
}
