package com.yedam.smartree.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;

@RestController
public class EqmRestController {
	@Autowired
	EqmService eqmservice;	
	@Autowired
	EqmInspService eqminspservice;
	
	@GetMapping("/eqms")
	public List<EqmVO> getEqms() {
		return eqmservice.selectEqmList();
	}
	@GetMapping("/eqmUcheck")
	public List<EqmVO> getEqmUcheck(String eqmUcheck) {
		return eqmservice.selectEqmUcheckList(eqmUcheck);
	}
	@GetMapping("/eqmInsps")
	public List<EqmInspVO> getEqmInsps(){
		return eqminspservice.selectEqmInspList();
	}
	@GetMapping("/eqmInspJudg")
	public List<EqmInspVO> getEqmInspJudg(String inspJudg){
		return eqminspservice.selectEqmInspInspJudgList(inspJudg);
	}
	@GetMapping("/eqmName")
	public List<EqmVO> getEqmName(String eqmName){
		return eqmservice.searchEqm(eqmName);
	}
	@GetMapping("/eqmInpsName")
	public List<EqmInspVO> getEqmInspName(String eqmName){
		return eqminspservice.searchEqmInsp(eqmName);
	}
}
