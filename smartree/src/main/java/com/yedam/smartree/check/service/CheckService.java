package com.yedam.smartree.check.service;

import java.util.List;

import com.yedam.smartree.business.service.BpVO;

public interface CheckService {
	public List<BpVO> selectPrdtList(BpVO vo);
	public List<CheckVO> selectPrdtStdList(CheckVO vo);
	public int insertPrdtChkStd(CheckVO vo);
}
