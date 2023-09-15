package com.yedam.smartree.mdm.service;

import java.util.List;

public interface MdmService {
	public List<CommonCodeVO> selectCommonCodeType();
	public List<CommonCodeVO> selectCommonCodeList(String codeType);
	public List<EmpVO> selectEmpList(String empDept, String empName);
	public int insertCommonCode(CommonCodeVO commonCodeVO);
}
