package com.yedam.smartree.mdm.service;

import lombok.Data;

@Data
public class MdmBomDtVO {
	private int prcsOrder;
	private String bomCode;
	private String prcsStdCode;
	private String prcsName;
	private String mtlCode;
	private String mtlName;
	private String mtlCnt;
	private String mtlUnit;
}
