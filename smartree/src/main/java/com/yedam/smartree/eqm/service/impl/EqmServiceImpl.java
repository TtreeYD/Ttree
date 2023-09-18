package com.yedam.smartree.eqm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.eqm.mapper.EqmMapper;
import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;
@Service
public class EqmServiceImpl implements EqmService {

	@Autowired
	EqmMapper eqmmapper;
	
	@Override
	public List<EqmVO> selectEqmList() {
		
		return eqmmapper.selectEqmList();
	}

	@Override
	public List<EqmVO> selectEqmUcheckList(String eqmUcheck) {
		
		return eqmmapper.selectEqmUcheckList(eqmUcheck);
	}

	@Override
	public List<EqmVO> searchEqm(String eqmName) {
		
		return eqmmapper.searchEqm(eqmName);
	}

	@Override
	public int insertEqm(EqmVO eqmVO) {
		return eqmmapper.insertEqm(eqmVO);
	}

	@Override
	public EqmVO selectEqm(EqmVO eqmVO) {
		return eqmmapper.selectEqm(eqmVO);
	}

	@Override
	public int deleteEqm(EqmVO eqmVO) {
		String eqmCode = eqmVO.getEqmCode();
		eqmVO.setEqmCode(eqmCode);
		eqmmapper.deleteEqm(eqmVO);
		return 1;
	}

}
