package com.yedam.smartree.mdm.service;

import lombok.Data;

@Data
public class MdmPrcsVO {
	private String prcsStdCode;
	private String prcsName;
	private String prcsType;
	private String prcsNote;
	private String prcsDetail;

	
	private String eqmCode;
	private String eqmName;
	private String eqmState;
}
