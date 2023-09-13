package com.yedam.smartree.check.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.check.service.MtlCheckService;
import com.yedam.smartree.check.service.MtlCheckVO;

@RestController
public class CheckRestController {
	@Autowired
	MtlCheckService mtlcheckservice;
	
	@GetMapping("/check")
	public List<MtlCheckVO> getcheck(){
		return mtlcheckservice.Allselect();
	}
}
