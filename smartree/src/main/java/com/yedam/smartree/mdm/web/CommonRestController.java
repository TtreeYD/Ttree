package com.yedam.smartree.mdm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.mdm.service.CommonCodeVO;
import com.yedam.smartree.mdm.service.EmpVO;
import com.yedam.smartree.mdm.service.MdmService;

@RestController
public class CommonRestController {
	
	@Autowired
	MdmService mdmService;
		
	@GetMapping("/selectCommonCode")
	public List<CommonCodeVO> selectCommonCode(int codeType){
		return mdmService.selectCommonCodeList(codeType);
	}
	
	@GetMapping("/selectEmpList")
	public List<EmpVO> selectEmpList(String empDept){
		return mdmService.selectEmpList(empDept);
	}
	
}
