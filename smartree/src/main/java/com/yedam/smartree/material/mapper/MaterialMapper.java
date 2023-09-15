package com.yedam.smartree.material.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.material.service.MaterialVO;

@Mapper
public interface MaterialMapper {
	// 발주목록 전체조회
	public List<MaterialVO> selectNeedList();
	// 재고목록 전체조회
	public List<MaterialVO> selectMtlList();
	// 출고목록 전체조회
	public List<MaterialVO> selectMtlOutList();
	// 발주관리 전체출력
	public List<MaterialVO> controlNeedList();
	// 안전재고 미달목록 출력
	public List<MaterialVO> selectMinusMtl();
	// 입고관리 전체출력
	public List<MaterialVO> controlInList();
}
