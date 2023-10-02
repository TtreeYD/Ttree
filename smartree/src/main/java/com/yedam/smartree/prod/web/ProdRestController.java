package com.yedam.smartree.prod.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BusinessVO;

import com.yedam.smartree.prod.service.PrcsResultVO;

import com.yedam.smartree.prod.service.ProdService;
import com.yedam.smartree.prod.service.ProdVO;
import com.yedam.smartree.prod.service.RequestVO;
/*
 * 
   23.09.26 권민석
   생산계획, 생산지시
 * 
 */
@RestController
public class ProdRestController {
	
	@Autowired
	ProdService service;
	
	//생산계획리스트
	@GetMapping("/prodPlanList")
	public List<ProdVO> getProdList(){
		return service.selectProdList();
	}
	
	//주문서조회
	@GetMapping("/orderAndPrdt")
	public List<BusinessVO> getOrderAndPrdt(){
		return service.selectOrderAndPrdt();
	}
	
	//생산계획미계획건조회
	@GetMapping("/selectProdPlan")
	public List<ProdVO> getProdPlan(ProdVO vo){
		return service.selectProd(vo);
	}
	//생산미완료지시건조회
	@GetMapping("/selectProdInst")
	public List<ProdVO> getProdInst(ProdVO vo){
		return service.selectProdInstList(vo);
	}
	//생산계획건을 선택해서 상세를 가져오는 것
	@GetMapping("/selectProdListView")
	public List<ProdVO> getProdPlanListView(ProdVO vo){
		return service.selectProdListView(vo);
	}
	//생산계획 저장
	@PostMapping("/insertProdPlan")
	public int insertProdPlan(@RequestBody RequestVO<ProdVO> vo) {
		 return service.insertProdPlan(vo);
	}
	
	//생산계획 수정
	/*
	 * @PostMapping("/updateProdPlan") public int updateProdPlan(@RequestBody
	 * RequestVO<ProdVO> vo) { return service.updateProd(vo); }
	 */
	
	@PostMapping("/updateProdInst") 
	public int updateProdInst(@RequestBody RequestVO<ProdVO> vo) { 
		System.out.println("@@@@@@@@@@@@@@" + vo);
		return service.updateProdInst(vo); 
	}
	
	//생산계획 삭제
	@PostMapping("/deleteProdPlan")
	public int deleteProdPlan(@RequestBody RequestVO<ProdVO> vo) {
		return service.deleteProd(vo);
	}
	
	//생산계획 저장및 수정
	@PostMapping("/insertAndUpdate")
	public int insertAndUpdate(@RequestBody RequestVO<ProdVO> vo) {
		return service.insertAndUpdateDtProdPlan(vo);
	}
	
	//생산계획 리스트에서 검색조건
	@PostMapping("/searchProd")
	public List<ProdVO> searchProdList(ProdVO vo){
		return service.searchProdList(vo);
	}
	
	
	// 새계획누르고 나오는거에서 제품누르면 나오는 모달
	/*
	 * @GetMapping("/selectPrdt") public List<PrdtProdVO> selectPrdtList(PrdtProdVO
	 * vo){ return service.selectPrdt(vo); }
	 */
	
	// 생산지시에 미지시생산계획
	@GetMapping("/selectGetProdPlan")
	public Map<String, Object> selectGetProdPlan(ProdVO vo){
		return service.selectGetProdList(vo);
	}
	
	// 생산지시에 상세조회
	@GetMapping("/selectGetProdInst")
	public List<ProdVO> selectGetProdInst(ProdVO vo){
		return service.selectGetProdInstList(vo);
	}
	// 생산지시 저장
	@PostMapping("/insertProdInst")
	public int insertProdInst(@RequestBody RequestVO<ProdVO> vo) {
		 return service.insertProdInst(vo);
	}
	//생산지시 삭제
	@PostMapping("/deleteProdInst")
	public int deleteProdInst(@RequestBody RequestVO<ProdVO> vo) {
		return service.deleteProdInst(vo);
	}
	//생산지시조회
	@GetMapping("/selectGetDtInst")
	public List<ProdVO> selectGetDtInst(ProdVO vo){
		return service.selectGetDtInst(vo);
	}
	//키오스크 :생산지시불러오기
	@GetMapping("/selectGetProcess")
	public List<ProdVO> selectGetProcess(ProdVO vo){
		return service.selectGetProcess(vo);
	}
	//공정흐름상세보기
	@GetMapping("/getProcess")
	public List<ProdVO> getProcess(ProdVO vo) {
		return service.getProcess(vo);
	}
	
	// 실적조회
	@GetMapping("/selectPrcsResult")
	public List<PrcsResultVO> selectPrcsResult(){
		return service.selectPrcsResult();
	}
}
