package com.yedam.smartree.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.mdm.mapper.MdmMapper;
import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.MdmService;

@Service
public class MdmServiceImpl implements MdmService {

	@Autowired
	MdmMapper mdmMapper;
	
	@Override
	public List<CommonCodeVO> selectCommonCodeType() {
		// TODO Auto-generated method stub
		return mdmMapper.selectCommonCodeType();
	}
	
	@Override
	public List<CommonCodeVO> selectCommonCodeList(String codeType) {
		return mdmMapper.selectCommonCodeList(codeType);
	}

	@Override
	public List<EmpVO> selectEmpList(String empDept, String empName) {
		return mdmMapper.selectEmpList(empDept,empName);
	}
}
