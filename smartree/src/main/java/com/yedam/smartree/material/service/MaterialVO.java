package com.yedam.smartree.material.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MaterialVO {
	// 발주목록
	private String mtlCode; // 자재코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mtlDate; // 자재발주일
	private String bpCode; // 거래처코드
	private String mtlName; // 자재이름
	private int mtlCnt; // 수량
	private String mtlUnit; // 단위
	private String mtlManager; // 담당자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mtlWishDate; // 납기요청일
	private String mtlWhere; // 상태
	
	// 자재목록
	private String mtlLotNum; // 자재 lot 번호
							  // 자재코드는 위에있다
	private int mtlInCnt; // 자재입고수량
	private Date mtlInDate; // 자재입고일
	private String mtlInManager; // 입고담당자
	private int mtlLotCnt; // 자재 재고수량
	private String mtlChkCode; // 자재검사코드
	
	// 출고목록
	private String mtlOutCode; // 자재 출고 코드
							   // 자재 lot 번호는 위에있다
							   // 자재코드도 위에있다
	private String mtlOutCnt;   // 자재출고수량
	private String prcsRsCode; // 공정실적코드
	
	// 발주관리
	
	// 입고관리
	
	// 홀딩관리
}
