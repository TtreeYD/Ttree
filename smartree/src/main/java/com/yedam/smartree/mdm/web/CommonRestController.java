package com.yedam.smartree.mdm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.MdmService;

/*
	개발자 : 정현철
	개발일자 : 2023/09/14
	기준정보관리 데이터 조회
*/
@RestController
public class CommonRestController {

	@Autowired
	MdmService mdmService;

	// 코드분류조회
	@GetMapping("/selectCommonCodeType")
	public List<CommonCodeVO> selectCommonCodeType() {
		return mdmService.selectCommonCodeType();
	}

	// 코드상세조회
	@GetMapping("/selectCommonCode")
	public List<CommonCodeVO> selectCommonCode(String codeType) {
		return mdmService.selectCommonCodeList(codeType);
	}

	// 사원 조회
	@GetMapping("/selectEmpList")
	public List<EmpVO> selectEmpList(String empDept, String empName) {
		return mdmService.selectEmpList(empDept, empName);
	}

}
