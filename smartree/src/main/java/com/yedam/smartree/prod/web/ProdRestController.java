package com.yedam.smartree.prod.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.prod.service.PrdtProdVO;
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
	@GetMapping("/selectProdPlan")
	public List<ProdVO> getProdPlan(ProdVO vo){
		return service.selectProd(vo);
	}
	@GetMapping("/selectProdListView")
	public List<ProdVO> getProdPlanListView(ProdVO vo){
		return service.selectProdListView(vo);
	}
	@PostMapping("/insertProdPlan")
	@ResponseBody
	public int insertProdPlan(@RequestBody RequestVO<ProdVO> vo) {
		 return service.insertProdPlan(vo);
	}
	@PostMapping("/updateProdPlan")
	public int updateProdPlan(@RequestBody RequestVO<ProdVO> vo) {
		return service.updateProd(vo);
	}
	@PostMapping("/deleteProdPlan")
	public int deleteProdPlan(@RequestBody RequestVO<ProdVO> vo) {
		return service.deleteProd(vo);
	}
	@PostMapping("/insertAndUpdate")
	public int insertAndUpdate(@RequestBody RequestVO<ProdVO> vo) {
		return service.insertAndUpdateDtProdPlan(vo);
	}
	@PostMapping("/searchProd")
	public List<ProdVO> searchProdList(ProdVO vo){
		return service.searchProdList(vo);
	}
	@GetMapping("/selectPrdt")
	public List<PrdtProdVO> selectPrdtList(PrdtProdVO vo){
		return service.selectPrdt(vo);
	}
	@GetMapping("/selectGetProdPlan")
	public List<ProdVO> selectGetProdPlan(ProdVO vo){
		return service.selectGetProdList(vo);
	}
	@PostMapping("/insertProdInst")
	@ResponseBody
	public int insertProdInst(@RequestBody RequestVO<ProdVO> vo) {
		 return service.insertProdInst(vo);
	}
	
}
