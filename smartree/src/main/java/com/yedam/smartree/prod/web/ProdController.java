package com.yedam.smartree.prod.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.smartree.business.service.BusinessService;
@Controller
public class ProdController {
	@Autowired
	
	@GetMapping("prodList")
	public String selectAllProd() {
		return "prod/prodList";
	}
	
	@GetMapping("prodMng")
	public String selectAllOrder() {
		
		return "prod/prodMng";
	}
}
