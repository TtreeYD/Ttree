package com.yedam.smartree.mdm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 	개발자 : 정현철
  	개발일자 : 2023/09/14
  	기준정보관리 페이지 조회
*/

@Controller
@RequestMapping("/mdm")
public class CommonContorller {
	
	// 공통코드관리 페이지
	@GetMapping("/commonCode")
	public String commonCodeManage() {
		return "mdm/commonCode";
	}
	
	// 사원관리 페이지
	@GetMapping("/emp")
	public String empList() {
		return "mdm/emp";
	}
	
	// 자재관리 페이지
	@GetMapping("/mtl")
	public String mtlManage() {
		return "mdm/mtl";
	}
	
	// 제품관리 페이지
	@GetMapping("/prdt")
	public String prodManage() {
		return "mdm/prdt";
	}
	
	// 공정기준 페이지
	@GetMapping("/prcs")
	public String prcsManage() {
		return "mdm/prcs";
	}
	
	// 거래처 관리 페이지
	@GetMapping("/bp")
	public String bpManage() {
		return "mdm/bp";
	}
	
	// bom관리 페이지
	@GetMapping("/bom")
	public String bomManage() {
		return "mdm/bom";
	}
	
	// 품질기준관리 페이지
	@GetMapping("/chkStd")
	public String chkStdManage() {
		return "mdm/chkStd";
	}
	
}
