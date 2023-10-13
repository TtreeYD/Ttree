package com.yedam.smartree.check.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class CheckVO {
	//제품검사
	private String prdtChkCode;
	private String prdtCode;
	private String prcsRsCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date prdtChkDate;
	private int prdtChkCnt;
	private String prdtChkResult;
	private String prdtManager;
	private String prdtChkStdCode;
	private String prdtChkVal;
	private String prdtChkFit;
	private String prdtChkSit;
	private String prdtfinChk;
	private String searchDate;
	private String prdtName;
	
	//제품검사기준목록
	private String prdtChkNum;
	
	//품질검사기준
	private String chkStdCode;
	private String chkName;
	private String chkDt;
	private String chkStd;
	
	
	//생산
	private String prodInstCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date prodInstDate;
	private int passCnt;
	
}
