package com.yedam.smartree.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.material.mapper.MaterialMapper;
import com.yedam.smartree.material.service.MaterialService;
import com.yedam.smartree.material.service.MaterialVO;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialMapper materialMapper;
	
	//발주목록 전체조회
	@Override
	public List<MaterialVO> selectNeedList() {
		return materialMapper.selectNeedList();
	}
	// 재고목록 전체조회
	@Override
	public List<MaterialVO> selectMtlList() {
		return materialMapper.selectMtlList();
	}
	// 출고목록 전체조회
	@Override
	public List<MaterialVO> selectMtlOutList() {
		return materialMapper.selectMtlOutList();
	}
	// 발주관리 전체출력
	@Override
	public List<MaterialVO> controlNeedList() {
		return materialMapper.controlNeedList();
	}
	// 입고관리 전체출력
	@Override
	public List<MaterialVO> controlInList() {
		return materialMapper.controlInList();
	}
	// 안전재고 미달목록
	@Override
	public List<MaterialVO> selectMinusMtl() {
		return materialMapper.selectMinusMtl();
	}
	@Override
	public List<MaterialVO> selectChkMtl() {
		return materialMapper.selectChkMtl();
	}

}
