package com.yedam.smartree.check.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.check.mapper.MtlCheckMapper;
import com.yedam.smartree.check.service.MtlCheckService;
import com.yedam.smartree.check.service.MtlCheckVO;

@Service
public class MtlCheckServiceImpl implements MtlCheckService{

	@Autowired
	MtlCheckMapper mtlcheckmapper;
	

	@Override
	public List<MtlCheckVO> selectMtl(MtlCheckVO vo) {
		return mtlcheckmapper.selectMtl(vo);
	}

	@Override
	public int insertChkMtl(MtlCheckVO vo) {
		return mtlcheckmapper.insertChkMtl(vo);
	}

	@Override
	public List<MtlCheckVO> getMtl(MtlCheckVO vo) {
		return mtlcheckmapper.getMtl(vo);
	}

	@Override
	public List<MtlCheckVO> searchMtl(String mtlName) {
		return mtlcheckmapper.searchMtl(mtlName);
	}

	@Override
	public List<MtlCheckVO> searchMtlManager(String mtlManager) {
		return mtlcheckmapper.searchMtlManager(mtlManager);
	}
	
	@Override
	public List<MtlCheckVO> searchMtlDate(String mtlDate) {
		return mtlcheckmapper.searchMtlDate(mtlDate);
	}
	
	@Override
	public List<MtlCheckVO> selectChkAll() {
		return mtlcheckmapper.selectChkAll();
	}

	@Override
	public int updateChkMtl(MtlCheckVO vo) {
		return mtlcheckmapper.updateChkMtl(vo);
	}

	@Override
	public List<MtlCheckVO> chkAll() {
		return mtlcheckmapper.chkAll();
	}



}
