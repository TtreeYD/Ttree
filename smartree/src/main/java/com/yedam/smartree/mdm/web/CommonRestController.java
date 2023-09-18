package com.yedam.smartree.mdm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/selectCommonCode")
	public List<CommonCodeVO> selectCommonCode() {
		return mdmService.selectCommonCode();
	}

	// 코드상세조회
	@GetMapping("/selectCodeDetail")
	public List<CommonCodeVO> selectCodeDetail(String codeType) {
		return mdmService.selectCodeDetail(codeType);
	}

	// 공통코드입력
	@PostMapping("/insertCommonCode")
	public void insertCommonCode(@RequestBody List<CommonCodeVO> commonCodeList) {
		for(CommonCodeVO commonCode : commonCodeList) {
			mdmService.insertCommonCode(commonCode);
		}
	}

	// 상세코드입력
	@PostMapping("/insertCodeDetail")
	public void insertCodeDetail(@RequestBody List<CommonCodeVO> codeDetailList) {
		for(CommonCodeVO codeDetail : codeDetailList) {
			mdmService.insertCodeDetail(codeDetail);
		}
	}

	// 공통코드삭제
	@PostMapping("/deleteCommonCode")
	public int deleteCommonCode(@RequestBody List<CommonCodeVO> delList) {
		for(CommonCodeVO delData : delList) {
			String codeType = delData.getCodeType();
			if(mdmService.selectCodeDetail(codeType).isEmpty()) { // 상세목록이 비어있는지 확인
				mdmService.deleteCommonCode(delData);
			}
		}
		return 0;
	}
	
	// 상세코드삭제
	@PostMapping("/deleteCodeDetail")
	public int deleteCodeDetail(@RequestBody List<CommonCodeVO> delList) {
		int cnt=0;
		for(CommonCodeVO delData : delList) {
			cnt += mdmService.deleteCodeDetail(delData);
		}
		return cnt;
	}
	
	
	// 사원관리
		
	// 사원 조회
	@GetMapping("/selectEmpList")
	public List<EmpVO> selectEmpList(String empDept, String empName) {
		return mdmService.selectEmpList(empDept, empName);
	}

	//	사원 등록
	@PostMapping("/insertEmp")
	public String addEmp(@RequestBody EmpVO empInfo) {
		String msg = "";
		if(mdmService.addEmp(empInfo)>0) {
			msg = "등록성공";
		} else {
			msg = "등록실패";
		}
		return msg;
	}

}
