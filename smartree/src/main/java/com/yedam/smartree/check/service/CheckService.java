package com.yedam.smartree.check.service;

import java.util.List;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.business.service.ReqVO;

public interface CheckService {
	public List<BpVO> selectPrdtList(BpVO vo);
	public List<CheckVO> selectPrdtStdList(CheckVO vo);
	public int insertPrdtChkStd(CheckVO vo);
	
	//완제품 검사목록
	public List<CheckVO> selectProdCheckList(CheckVO vo);
	public List<CheckVO> selectProdDtList(CheckVO vo);
	public int insertProdChk(ReqVO<CheckVO> vo);
	
	//완제품 검사조회목록
	public List<CheckVO> selectPrdtCheckList(CheckVO vo);
	public List<CheckVO> selectdtList(CheckVO vo);
}
