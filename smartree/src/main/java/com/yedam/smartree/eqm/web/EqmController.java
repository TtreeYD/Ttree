package com.yedam.smartree.eqm.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.yedam.smartree.eqm.service.EqmService;


@Controller

public class EqmController {
	
	@Autowired
	EqmService eqmservice;	
	

	
	@GetMapping("eqmList")
	public String selectAllEqm() {
		
		return "eqm/eqmList";
	}
}
