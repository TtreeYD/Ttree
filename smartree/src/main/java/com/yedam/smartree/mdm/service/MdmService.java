package com.yedam.smartree.mdm.service;

import java.util.List;

public interface MdmService {
	// 공통코드관리
	public List<CommonCodeVO> selectCommonCode();
	public List<CommonCodeVO> selectCodeDetail(String codeType);
	public int insertCommonCode(CommonCodeVO commonCodeVO);
	public int insertCodeDetail(CommonCodeVO commonCodeVO);
	public int deleteCommonCode(CommonCodeVO commonCodeVO);
	public int deleteCodeDetail(CommonCodeVO commonCodeVO);
	
	// 사원관리
	public List<EmpVO> selectEmpList(String empDept, String empName);
	public int addEmp(EmpVO vo);
	
	// 제품관리
	List<PrdtVO> selectPrdtList();
	PrdtVO selectPrdt(String prdtCode);
	List<PrdtVO> searchPrdt(PrdtVO vo);
	int insertPrdt(PrdtVO vo);
	int updatePrdt(PrdtVO vo);
	int deletePrdt(String prdtCode);
}
