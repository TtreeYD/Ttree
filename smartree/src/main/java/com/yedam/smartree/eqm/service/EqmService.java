package com.yedam.smartree.eqm.service;

import java.util.List;

public interface EqmService {
	public List<EqmVO> selectEqmList();
	public List<EqmVO> selectEqmUcheckList(String eqmUcheck);
	public List<EqmVO> searchEqm(String eqmName);
}
