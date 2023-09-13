package com.yedam.smartree.check.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class CheckVO {
	private String prdtChkCode;
	private String prdtCode;
	private String prcsRsCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prdtChkDate;
	private int prdtChkCnt;
	private String prdtChkResult;
	private String prdtManager;
	private String prdtChkStdCode;
}
