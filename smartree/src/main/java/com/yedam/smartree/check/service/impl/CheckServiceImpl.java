package com.yedam.smartree.check.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.check.mapper.CheckMapper;
import com.yedam.smartree.check.service.CheckService;
import com.yedam.smartree.check.service.CheckVO;

@Service
public class CheckServiceImpl implements CheckService{


	  @Autowired CheckMapper checkmapper;

	@Override
	public List<BpVO> selectPrdtList(BpVO vo) {
		return checkmapper.selectPrdtList(vo);
		
	}

	@Override
	public List<CheckVO> selectPrdtStdList(CheckVO vo) {
		return checkmapper.selectPrdtStdList(vo);
	}

	@Override
	public int insertPrdtChkStd(CheckVO vo) {
		return checkmapper.insertPrdtChkStd(vo);
	}

	@Override
	public List<CheckVO> selectPrdtCheckList(CheckVO vo) {
		return checkmapper.selectPrdtCheckList(vo);
	}

	@Override
	public List<CheckVO> selectdtList(CheckVO vo) {
		return checkmapper.selectdtList(vo);
	}
	 
}
