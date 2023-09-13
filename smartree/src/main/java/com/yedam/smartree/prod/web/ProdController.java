package com.yedam.smartree.prod.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.smartree.prod.service.ProdService;



@Controller
public class ProdController {
	@Autowired
	ProdService service;
	
	@GetMapping("prodList")
	public String selectAllProd() {
		
		return "prod/prodList";
	}
	
	@GetMapping("prodMng")
	public String selectProdMng() {
		
		return "prod/prodMng";
	}
}
