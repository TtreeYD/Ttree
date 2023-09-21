package com.yedam.smartree.check.mapper;

import java.util.List;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.check.service.CheckVO;

public interface CheckMapper {
	public List<BpVO> selectPrdtList(BpVO vo);
	public List<CheckVO> selectPrdtStdList(CheckVO vo);
	public int insertPrdtChkStd(CheckVO vo);
	
	//완제품 검사목록
	public List<CheckVO> selectProdCheckList(CheckVO vo);
	public List<CheckVO> selectProdDtList(CheckVO vo);
	//제품 검사등록
	public void insertProdChk(CheckVO vo);
	//제품 검사 상세등록
	public void insertDtProdChk(CheckVO vo);
	
	//완제품 검사목록조회
	public List<CheckVO> selectPrdtCheckList(CheckVO vo);
	public List<CheckVO> selectdtList(CheckVO vo);
	
	//완제품 합격조회
	public List<CheckVO> selectPrdtFin(CheckVO vo);
	
	//적합 업데이트
	public int updatePrdtChk(CheckVO vo);
	
	//검사완료 업데이트
	public int updateFinChk(CheckVO vo);
}
