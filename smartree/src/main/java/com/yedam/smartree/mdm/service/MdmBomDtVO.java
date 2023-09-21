package com.yedam.smartree.mdm.service;

import lombok.Data;

@Data
public class MdmBomDtVO {
	private int prcsOrder;
	private String bomCode;
	private String prcsStdCode;
	private String mtlCode;
	private String mtlCount;
}
