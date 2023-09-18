package com.yedam.smartree.mdm.service;

import java.util.List;

public interface MdmService {
	// 공통코드관리
	public List<CommonCodeVO> selectCommonCode();
	public List<CommonCodeVO> selectCodeDetail(String codeType);
	public List<EmpVO> selectEmpList(String empDept, String empName);
	public int insertCommonCode(CommonCodeVO commonCodeVO);
	public int insertCodeDetail(CommonCodeVO commonCodeVO);
	public int deleteCommonCode(CommonCodeVO commonCodeVO);
	public int deleteCodeDetail(CommonCodeVO commonCodeVO);
	
	// 사원관리
	public int addEmp(EmpVO vo);
}
