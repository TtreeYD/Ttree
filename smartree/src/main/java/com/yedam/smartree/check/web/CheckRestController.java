package com.yedam.smartree.check.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/mtlcheck")
	@ResponseBody
	public List<MtlCheckVO> mtlcheck(MtlCheckVO vo){
		
	
		System.out.println(vo);
		System.out.println(mtlcheckservice.mtlselect(vo));
		return mtlcheckservice.mtlselect(vo);
	}
	
}
