package com.yedam.smartree.eqm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.eqm.mapper.EqmInspMapper;
import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmVO;

@Service
public class EqmInspServiceImpl implements EqmInspService{

	@Autowired
	EqmInspMapper eqminspmapper;
	
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


}
