package com.yedam.smartree.eqm.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;

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
	// 설비 전체 조회
	@GetMapping("/eqmList")
	public String selectAllEqm() {
		
		return "eqm/eqmList";
	}
	// 설비 점검 전체 조회
	@GetMapping("/eqmInspList")
	public String selectAllEqmInsp() {
		return "eqm/eqmInspList";
	}
	// 설비 등록 - 페이지
	@GetMapping("/eqmForm")
	public String registerEqmForm(Model model) {
		model.addAttribute("eqmVO", new EqmVO());
		return "eqm/eqmForm";
	}
	// 설비 등록 - 처리
	@PostMapping("/eqmForm")
	public String registerEqmProcess(EqmVO eqmVO) {
		eqmservice.insertEqm(eqmVO);
		return "redirect:eqmForm";
	}
}
