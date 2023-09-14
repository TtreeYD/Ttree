package com.yedam.smartree.check.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.check.service.MtlCheckService;

/*
 개발자:정호현
 개발일자:23/09/14
 영업관리
 */
@RequestMapping("/check")
@Controller
public class CheckController {

	@Autowired
	MtlCheckService mtlcheckservice;
	
	@GetMapping("mtlCheck")
	public String selectAllCheck() {
		
		return "check/mtlCheck";
	}
}
