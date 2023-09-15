package com.yedam.smartree.eqm.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmService;

/*
  개발자  : 이승준
  개발일자 : 2023/09/14
           설비조회,설비점검조회 
  */



@Controller
@RequestMapping("/eqm")
public class EqmController {
	
	@Autowired
	EqmService eqmservice;	
	@Autowired
	EqmInspService 	eqminspservice;
	
	@GetMapping("/eqmList")
	public String selectAllEqm() {
		
		return "eqm/eqmList";
	}
	
	@GetMapping("/eqmInspList")
	public String selectAllEqmInsp() {
		return "eqm/eqmInspList";
	}
	@GetMapping("/eqmForm")
	public String registerEqmForm() {
		return "eqm/eqmForm";
	}
}
