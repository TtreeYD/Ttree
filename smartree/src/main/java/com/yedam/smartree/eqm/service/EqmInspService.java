package com.yedam.smartree.eqm.service;

import java.util.List;

public interface EqmInspService {
	public List<EqmInspVO> selectEqmInspList();
	public List<EqmInspVO> selectEqmInspInspJudgList(String inspJudg);
	public List<EqmInspVO> searchEqmInsp(String eqmName);
	public int insertEqmInsp(EqmInspVO eqmInspVO);
	public EqmInspVO selectEqmInsp(EqmInspVO eqmInspVO);
}
