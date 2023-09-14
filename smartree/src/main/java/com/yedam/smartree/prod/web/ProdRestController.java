package com.yedam.smartree.prod.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.prod.service.ProdService;
import com.yedam.smartree.prod.service.ProdVO;
import com.yedam.smartree.prod.service.RequestVO;

@RestController
public class ProdRestController {
	@Autowired
	ProdService service;
	
	@GetMapping("/prodPlanList")
	public List<ProdVO> getProdList(){
		return service.selectProdList();
	}
	
	@GetMapping("/orderAndPrdt")
	public List<BusinessVO> getOrderAndPrdt(){
		return service.selectOrderAndPrdt();
	}
//	
//	@GetMapping("/OneOrderAndPrdt")
//	public List<BusinessVO> getOneOrderAndPrdt(BusinessVO vo){
//		System.out.println(vo.toString());
//		return service.selectOneOrderAndPrdt(vo);
//	}
//	
//	@PostMapping("/OneOrderAndPrdt")
//	@ResponseBody
//	public List<BusinessVO> getOneOrderAndPrdtResp(BusinessVO vo){
////		System.out.println(vo.toString());
//		return service.selectOneOrderAndPrdt(vo);
//	}
	
	@PostMapping("/insertProdPlan")
	@ResponseBody
	public int insertProdPlan(@RequestBody RequestVO<ProdVO> vo) {
		 return service.insertProdPlan(vo);
		 
	}
}
