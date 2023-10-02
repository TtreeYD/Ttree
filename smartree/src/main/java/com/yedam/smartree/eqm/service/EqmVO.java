package com.yedam.smartree.eqm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date mfgDate;
	private String eqmImg;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
	private Date recentInspDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
 	private Date nextInspDate;
	private String eqmState;
	
	
	
}
