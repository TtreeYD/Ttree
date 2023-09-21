package com.yedam.smartree.business.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class FinPrdtVO {

	private String prdtLotNo;//lot번호
	private String prdtCode;//제품코드
	private String prdtName; // 제품이름
	
	
	//완제품재고관련
	private int prdtSaveCnt; // 안전재고
	private int prdtCnt; // 재고수량
	private int prdtSum; // 합계
	
	//입고관련
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date prdtRecieveDate; // 입고날짜
	private String recieveManager; // 입고담당자
	private int prdtRecieveCnt; // 입고수량
	private String prdtChkCode; // 완제품검사코드
	
	
	
	//출고관련
	private String prdtOutCode;//출고코드
	private String prdtDtOutCode;//출고상세코드
	private String orderDtCode;//상세주문코드
	private int prdtOutCnt;//출고수량
	private int prdtLeftCnt;//잔여수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date prdtOutDate;//출고날짜
	private String prdtOutManager;//출고담당자
}
