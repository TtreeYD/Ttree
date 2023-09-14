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

/*
 * 자재관리
 개발일자 2023/09/14 
 개발자 안영진
 */

@RestController
public class CheckRestController {
	@Autowired
	MtlCheckService mtlcheckservice;
	
	@GetMapping("/check")
	public List<MtlCheckVO> getcheck(){
		return mtlcheckservice.selectAll();
	}
	
	@GetMapping("/mtlcheck")
	public List<MtlCheckVO> mtlgetcheck(MtlCheckVO vo){
		return mtlcheckservice.selectMtl(vo);
	}
	
	@PostMapping("/mtlcheck")
	@ResponseBody
	public List<MtlCheckVO> mtlcheck(MtlCheckVO vo){

		System.out.println(mtlcheckservice.selectMtl(vo));
		return mtlcheckservice.selectMtl(vo);
	}
	
	@ResponseBody
	@PostMapping("/mtlinsert")
	public int mtlinsert(MtlCheckVO vo) {
		
		System.out.println(mtlcheckservice.insertChkMtl(vo));
		return mtlcheckservice.insertChkMtl(vo);
	}
}
