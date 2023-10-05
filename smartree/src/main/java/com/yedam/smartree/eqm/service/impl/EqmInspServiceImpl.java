package com.yedam.smartree.eqm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.eqm.mapper.EqmInspMapper;
import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmNoperVO;

@Service
public class EqmInspServiceImpl implements EqmInspService{

	@Autowired
	EqmInspMapper eqminspmapper;
	
	
	// 설비점검
	@Override
	public List<EqmInspVO> selectEqmInspList() {		
		return eqminspmapper.selectEqmInspList();
	}

	@Override
	public List<EqmInspVO> selectEqmInspInspJudgList(String inspJudg) {		
		return eqminspmapper.selectEqmInspInspJudgList(inspJudg);
	}

	@Override
	public List<EqmInspVO> searchEqmInsp(String eqmName) {
		return eqminspmapper.searchEqmInsp(eqmName);
	}

	@Override
	public int insertEqmInsp(EqmInspVO eqmInspVO) {
		return eqminspmapper.insertEqmInsp(eqmInspVO);
	}

	@Override
	public EqmInspVO selectEqmInsp(EqmInspVO eqmInspVO) {
		return eqminspmapper.selectEqmInsp(eqmInspVO);
	}

	
	//비가동
	
	@Override
	public int insertEqmNoper(EqmNoperVO eqmNoperVO) {
		return eqminspmapper.insertEqmNoper(eqmNoperVO);
	}

	@Override
	public List<EqmNoperVO> selectEqmNoper() {
	
		return eqminspmapper.selectEqmNoper();
	}

	@Override
	public List<EqmNoperVO> searchEqmNoper(String eqmName) {		
		return eqminspmapper.searchEqmNoper(eqmName);
	}

	@Override
	public EqmNoperVO selectEqmNoperCode(EqmNoperVO eqmNoperVO) {
	
		return eqminspmapper.selectEqmNoperCode(eqmNoperVO);
	}

	@Override
	public int updateEqmNoper(EqmNoperVO eqmNoperVO) {
		return eqminspmapper.updateEqmNoper(eqmNoperVO);
	}

	
	




}
