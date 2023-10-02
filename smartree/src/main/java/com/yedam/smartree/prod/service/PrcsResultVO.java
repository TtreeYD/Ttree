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
	String prcsStdCode;
	String prcsName;
	String manager;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	Date prcsSdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	Date prcsEdate;
	int prodCnt;
	int errCnt;
	int passCnt;
}
