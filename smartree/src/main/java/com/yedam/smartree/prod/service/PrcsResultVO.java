package com.yedam.smartree.prod.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PrcsResultVO {
	String prodInstCode;
	String prodInstName;
	String prdtCode;
	String prdtName;
	String prcsStdCode;
	String prcsName;
	String manager;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm" ,timezone = "Asia/Seoul")
	Date prcsSdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm" ,timezone = "Asia/Seoul")
	Date prcsEdate;
	int prdtCnt;
	int errCnt;
	int passCnt;
	//오늘,한달,일주일 조건
	private String searchDate;
	String searchName;
}
