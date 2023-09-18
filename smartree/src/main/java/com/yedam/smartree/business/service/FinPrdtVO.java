package com.yedam.smartree.business.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FinPrdtVO {

	private String prdtLotNo;
	private String prdtCode;
	private String prdtName;
	private int prdtRecieveCnt;
	private int prdtSum;
	
	private int prdtCnt;
	private String prdtUnit;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date prdtRecieveDate;
	private String recieveManager;
	private String prdtChkCode;
	private int prdtSaveCnt;
}
