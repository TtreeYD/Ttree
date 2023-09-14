package com.yedam.smartree.eqm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class EqmInspVO {

	// 설비 점검 테이블
	private String inspCode;
	private String eqmCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recentInspDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date repairDate;
	private String inspDt;
	private String actionDt;
	private String inspJudg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nextInspDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate;
	private String inptManager;
	private String noperCode;
	private String eqmName;
	
}
