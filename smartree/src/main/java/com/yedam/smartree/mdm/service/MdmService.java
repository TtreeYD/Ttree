package com.yedam.smartree.mdm.service;

import java.util.List;

public interface MdmService {
	public List<CommonCodeVO> selectCommonCodeList(int codeType);
	public List<EmpVO> selectEmpList(String empDept);
}
