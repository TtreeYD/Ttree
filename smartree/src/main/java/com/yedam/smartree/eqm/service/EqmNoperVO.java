package com.yedam.smartree.eqm.service;

import lombok.Data;

@Data
public class EqmNoperVO {
	// 비가동테이블
	private String noperCode;
	private String reasonKnd;
	private String reason;
	private String noperSdate;
	private String noperLdate;
	private String noperManager;
	private String inspIcheck;
	private String eqmCode;
	private String eqmName;
	
}
