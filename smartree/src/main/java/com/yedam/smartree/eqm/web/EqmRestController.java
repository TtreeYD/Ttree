package com.yedam.smartree.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;

@RestController
public class EqmRestController {
	@Autowired
	EqmService eqmservice;	
	
	@GetMapping("/eqms")
	public List<EqmVO> getEqms() {
		return eqmservice.selectEqmList();
	}
}
