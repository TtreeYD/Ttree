package com.yedam.smartree.prod.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.prod.service.ProdService;



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
}
