package com.yedam.smartree.check.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class CheckVO {
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
	
	private String prdtName;
	
}
