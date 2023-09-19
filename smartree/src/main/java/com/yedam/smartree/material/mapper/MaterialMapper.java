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
	// 입고관리 검사완료목록 출력
	public List<MaterialVO> selectChkMtl();
	
	// 입고관리 insert
	public int insertNeedMtl(MaterialVO vo);
	// 입고관리 update
	public int updateNeedMtl(MaterialVO vo);
	// 입고관리 delete
	public int deleteNeedMtl(MaterialVO vo);
	
	// 발주관리 insert
	public int insertInMtl(MaterialVO vo);
	// 발주관리 update
	public int updateInMtl(MaterialVO vo);
	// 발주관리 delete
	public int deleteInMtl(MaterialVO vo);
}
