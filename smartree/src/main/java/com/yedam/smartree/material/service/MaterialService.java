package com.yedam.smartree.material.service;

import java.util.List;

public interface MaterialService {
	// 발주목록 전체조회
	public List<MaterialVO> selectNeedList();
	// 재고목록 전체조회
	public List<MaterialVO> selectMtlList();
	// 출고목록 전체조회
	public List<MaterialVO> selectMtlOutList();
}
