package com.yedam.smartree.check.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.check.service.MtlCheckService;

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
