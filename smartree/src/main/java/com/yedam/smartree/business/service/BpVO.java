package com.yedam.smartree.business.service;

import lombok.Data;

@Data
public class BpVO {
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
	int prdtTotal;
}
