package com.yedam.smartree.eqm.service;

import java.util.List;

public interface EqmService {
	public List<EqmVO> selectEqmList();
	public List<EqmVO> selectEqmUcheckList(String eqmUcheck);
	public List<EqmVO> searchEqm(String eqmName);
	public int insertEqm(EqmVO eqmVO);
	public EqmVO selectEqm(EqmVO eqmVO);
	public int deleteEqm(EqmVO eqmVO);
	public int updateEqm(EqmVO eqmVO);
}
