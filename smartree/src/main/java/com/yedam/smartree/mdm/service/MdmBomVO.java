package com.yedam.smartree.mdm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MdmBomVO {
	private String bomCode;
	private String prdtCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date bomDate;
	private String bomUse;
	
	// 상세항목
	private int prcsOrder;
	private String prcsStdCode;
	private String prcsName;
	private String mtlCode;
	private String mtlName;
	private String mtlCnt;
	private String mtlUnit;
}
