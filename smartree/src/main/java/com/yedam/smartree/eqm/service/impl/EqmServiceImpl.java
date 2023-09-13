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

}
