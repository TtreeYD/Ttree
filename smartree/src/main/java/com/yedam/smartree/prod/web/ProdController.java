package com.yedam.smartree.prod.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.smartree.prod.service.ProdService;

/*
 * 
   23.09.26 권민석
   생산계획, 생산지시
 * 
 */

@Controller
@RequestMapping("/prod")
public class ProdController {
	@Autowired
	ProdService service;
	
	@GetMapping("/prodPlanList")
	public String selectAllProd() {
		return "prod/prodPlanList";
	}
	@GetMapping("/prodPlanMng")
	public String selectProdMng() {
		return "prod/prodPlanMng";
	}
	@GetMapping("/prodInstMng")
	public String selectProdInstMng() {
		return "prod/prodInstMng";
	}
	@GetMapping("/prodInstList")
	public String selectProdInstList() {
		return "prod/prodInstList";
	}
	
	@GetMapping("/prcrKiosk")
	public String prcrKiosk() {
		return "prod/prcrKiosk";
				
	}
	//키오스크생산진행페이지이동
	@GetMapping("/prodProgress")
	public String prodProgress() {
		return "prod/prodProgress";
	}
	//키오스크생산현황페이지이동
	@GetMapping("/prodSituation")
	public String prodSituation() {
		return "prod/prodSituation";
	}

	@GetMapping("/prcrDtProgress")
	public String prcrDtProgress(Model model,@RequestParam("data") String data) {
		model.addAttribute("data" , data);
		
		return "prod/prcrDtProgress";
	}
	@GetMapping("/prodPrcsResult")
	public String prodPrcsResult() {
		return "prod/prodPrcsResult";

	}
	@GetMapping("/prcrDtSituation")
	public String prcrDtSituation(Model model,@RequestParam("data") String data) {
		model.addAttribute("data" , data);
		
		return "prod/prodDtSituation";
	}
	@GetMapping("/prodCondition")
	public String prodCondition() {
		return "prod/prodCondition";

	}
}
