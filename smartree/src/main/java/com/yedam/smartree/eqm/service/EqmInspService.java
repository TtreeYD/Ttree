package com.yedam.smartree.eqm.service;

import java.util.List;

public interface EqmInspService {
	// 설비점검
	public List<EqmInspVO> selectEqmInspList();
	public List<EqmInspVO> selectEqmInspInspJudgList(String inspJudg);
	public List<EqmInspVO> searchEqmInsp(String eqmName);
	public int insertEqmInsp(EqmInspVO eqmInspVO);
	public EqmInspVO selectEqmInsp(EqmInspVO eqmInspVO);
	
	// 비가동
	public int insertEqmNoper(EqmNoperVO eqmNoperVO);
	public List<EqmNoperVO> selectEqmNoper();
	public List<EqmNoperVO> searchEqmNoper(String eqmName);
	public EqmNoperVO selectEqmNoperCode(EqmNoperVO eqmNoperVO);
	public int updateEqmNoper(EqmNoperVO eqmNoperVO);
}
