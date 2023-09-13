package com.yedam.smartree.prod.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.prod.service.ProdService;
import com.yedam.smartree.prod.service.ProdVO;

@RestController
public class ProdRestController {
	@Autowired
	ProdService service;
	
	@GetMapping("/prodPlanList")
	public List<ProdVO> getProdList(){
		return service.selectProdList();
	}
}
