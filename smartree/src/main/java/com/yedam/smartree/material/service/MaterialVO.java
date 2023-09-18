package com.yedam.smartree.material.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MaterialVO {
	
	// 발주목록
	private String mtlCode; 						// 자재코드ㅇ
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mtlDate; 							// 자재발주일ㅇ
	private String bpName; 							// 거래처이름ㅇ FK
	private String mtlType; 						// 자재분류ㅇ FK
	private String mtlName; 						// 자재이름ㅇ FK
	private int mtlCnt; 							// 수량ㅇ
	private String mtlUnit; 						// 단위ㅇ 
	private String mtlManager; 						// 담당자ㅇ
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mtlWishDate; 						// 납기요청일ㅇ
	private String mtlWhereNm; 						// 상태 ㅇ
	
	
	// 자재목록
	private String mtlLotNum; 						// 자재 lot 번호
							  						// 자재코드는 위에있다
	private int mtlInCnt; 							// 자재입고수량
	private Date mtlInDate; 						// 자재입고일
	private String mtlInManager; 					// 입고담당자
	private int mtlLotCnt; 							// 자재 재고수량
	private String mtlChkCode; 						// 자재검사코드
	
	
	// 출고목록
	private String mtlOutCode; 						// 자재 출고 코드
							   						// 자재 lot 번호는 위에있다
							   						// 자재코드도 위에있다
	private String mtlOutCnt;   					// 자재출고수량
	private String prcsRsCode; 						// 공정실적코드
	
	
	// 발주관리
													// 거래처이름
													// 자재분류
													// 자재코드
													// 자재이름
													// 자재발주일
													// 납기요청일
													// 수량
													// 단위
													// 담당자
	
	
	// 입고관리
													// 자재lot
													// 자재분류
													// 자재코드
													// 자재이름
	private Date mtlChkDate;   						// 검사완료일 FK
	private int mtlPassCnt;	   						// 입고수량 FK
	private String mtlChkManager;					// 입고 검수 담당자
	private String mtlStatusNm;						// 입고 검사결과
													// 검사코드 FK
													// 입고일
	
	
	// 홀딩관리
													// 자재이름
													// lot 번호
	private String dtProdInstCode;					// 생산지시상세코드
	private int holdingCnt;							// 자재수량
	
	// 발주관리-안전재고 미달목록
	private int mtlSs;								// 자재 안전재고
	private int mtlNow;							// 자재 수량차
	
	// 입고관리 - 검사완료 목록
}
