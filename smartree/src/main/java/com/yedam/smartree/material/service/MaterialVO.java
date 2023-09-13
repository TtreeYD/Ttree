package com.yedam.smartree.material.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MaterialVO {
	// 발주목록
	private String mtlCode; // 자재코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mtlDate; // 자재발주일
	private String bpCode; // 거래처코드
	private String mtlName; // 자재이름
	private int mtlCnt; // 수량
	private String mtlUnit; // 단위
	private String mtlManager; // 담당자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mtlWishDate; // 납기요청일
	private String mtlWhere; // 상태
	
}
