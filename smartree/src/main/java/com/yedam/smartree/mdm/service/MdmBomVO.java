package com.yedam.smartree.mdm.service;

import java.util.Date;

import lombok.Data;

@Data
public class MdmBomVO {
	private String bomCode;
	private String prdtCode;
	private Date bomDate;
	private String bomUse;
}
