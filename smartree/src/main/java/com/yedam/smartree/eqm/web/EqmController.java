package com.yedam.smartree.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;

//@Controller
@RestController
public class EqmController {
	
	@Autowired
	EqmService eqmservice;	
	
	@GetMapping("eqmList")
	public List<EqmVO> selectAllEqm() {
		return eqmservice.selectEqmList();
	}
	
//	@GetMapping("eqmList")
//	public String selectAllEqm(Model model) {
//		model.addAttribute("eqmList", eqmservice.selectEqmList());
//		return "eqm/eqmList";
//	}
}
