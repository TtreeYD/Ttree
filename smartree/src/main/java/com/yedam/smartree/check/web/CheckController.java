package com.yedam.smartree.check.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.check.service.CheckService;
import com.yedam.smartree.check.service.MtlCheckService;



 /* 자재관리
 개발일자 2023/09/14 
 개발자 안영진
 */

@RequestMapping("/check")
@Controller
public class CheckController {

	@Autowired
	MtlCheckService mtlcheckservice;
	
	@Autowired
	CheckService checkservice;
	
	@GetMapping("/check")
	public String selectMtlAllCheck() {
		return "check/check";
	}
	
	@GetMapping("mtlCheck")
	public String selectAllCheck() {
		
		return "check/mtlCheck";
	}
	
	@GetMapping("/prdtStd")
	public String selectPrdtStd() {
		return "check/prdtStd";
	}
	
	@GetMapping("/prdtCheck")
	public String selectPrdtCheck() {
		return "check/prdtCheck";
	}
	
	@GetMapping("/prdtCheckList")
	public String selectPrdtCheckList() {
		return "check/prdtCheckList";
	}


}
