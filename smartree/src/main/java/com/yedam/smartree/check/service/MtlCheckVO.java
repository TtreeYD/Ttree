package com.yedam.smartree.check.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class MtlCheckVO {

	private String mtlChkCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date mtlDate;
	private String bpCode;
	private String bpName;
	private String mtlCode;
	private String mtlName;
	private int mtlChkCnt;
	private int mtlErrorCnt;
	private int mtlPassCnt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date mtlChkDate;
	private String mtlChkManager;
	private String mtlManager;
	private String mtlChkStatus;
	private String mtlWhere;
	
	//자재
	private int mtlCnt;
	
	private String result;
}
