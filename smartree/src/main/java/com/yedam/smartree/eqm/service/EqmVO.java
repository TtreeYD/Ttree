package com.yedam.smartree.eqm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EqmVO {
	
	//설비테이블
	private String eqmCode;
	private String eqmName;
	private String eqmUcheck;
	private int eqmMaxTemp;
	private int eqmMinTemp;
	private String eqmManager;
	private String eqmDivision;
	private int inspCycle;
	private String mfgComp;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mfgDate;
	private String eqmImg;

}
