package com.yedam.smartree.business.service;

import java.util.Date;

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
	private Date prdtRecieveDate;
	private String recieveManager;
	private String prdtChkCode;
	private int prdtSaveCnt;
}
