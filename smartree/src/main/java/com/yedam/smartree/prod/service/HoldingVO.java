package com.yedam.smartree.prod.service;

import lombok.Data;

@Data
public class HoldingVO {
	String holdingCode;
	String prodInstCode;
	String mtlLotNum;
	int holdingCnt;
	String mtlCode;
}
