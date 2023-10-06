package com.yedam.smartree.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.material.service.MaterialService;
import com.yedam.smartree.material.service.MaterialVO;
/*
개발자   : 남태원
개발일자  : 2023/09/13
		 자재관리
*/
@RestController
public class MaterialRestController {
	
	@Autowired
	MaterialService materialService;
	
	// 조회기능 목록
	@GetMapping("/mtlNeeds")
	public List<MaterialVO> getMtlNeeds(){
		return materialService.selectNeedList();
	}
	// 재고조회 목록
	@GetMapping("/mtlExist")
	public List<MaterialVO> getMtlExist(){
		return materialService.selectMtlList();
	}
	// 출고조회 목록 오른쪽
	@PostMapping("/mtlEmpty")
	public List<MaterialVO> getMtlEmpty(MaterialVO vo){
		return materialService.selectMtlOutList(vo);
	}
	// 출고조회 목록 왼쪽
	@GetMapping("/mtlOut")
	public List<MaterialVO> getMtlOut(){
		return materialService.MtlOutList();
	}
	// 안전재고 미달 목록
	@GetMapping("/mtlMinus")
	public List<MaterialVO> getMtlMinus(){
		return materialService.selectMinusMtl();
	}
	// 검사완료 조회 목록
	@GetMapping("/mtlChecked")
	public List<MaterialVO> getMtlChecked(){
		return materialService.selectChkMtl();
	}
	
	// 발주관리 insert
	@PostMapping("/insertNeedMtl")
	public void insertNeedMtl(@RequestBody List<MaterialVO> materialList) {
		for(MaterialVO vo : materialList) {
			materialService.insertNeedMtl(vo);
		}
	}
	// 발주관리 update
	@PostMapping("/updateNeedMtl")
	public int updateNeedMtl(MaterialVO vo) {
		return materialService.updateNeedMtl(vo);
	}
	// 발주관리 delete
	@PostMapping("/deleteNeedMtl")
	public void deleteNeedMtl(@RequestBody List<MaterialVO> materialList) {
		for(MaterialVO vo : materialList) {
			materialService.deleteNeedMtl(vo);
		}
	}
	
	// 입고관리 insert
	@PostMapping("/insertInMtl")
	public void insertInMtl(@RequestBody List<MaterialVO> materialList) {
		for(MaterialVO vo : materialList) {
			materialService.insertInMtl(vo);
		}
	}
	// 입고관리 update
	@PostMapping("/updateInMtl")
	public int updateInMtl(MaterialVO vo) {
		return materialService.updateInMtl(vo);
	}
	// 입고관리 delete
	@PostMapping("/deleteInMtl")
	public int deleteInMtl(MaterialVO vo) {
		return materialService.deleteInMtl(vo);
	}
	
	// 발주관리 조건검색
	@PostMapping("/getNeedMtl")
	public List<MaterialVO> getNeedMtl(MaterialVO vo){
		return materialService.getNeedMtl(vo);
	}
	// 입고관리 조건검색
	@PostMapping("/getInMtl")
	public List<MaterialVO> getInMtl(MaterialVO vo){
		return materialService.getInMtl(vo);
	}
	
	// 자재재고 lot별 출력
	@PostMapping("/getLotMtl")
	public List<MaterialVO> getLotMtl(MaterialVO vo){
		return materialService.getLotMtl(vo);
	}
	// 발주목록 주문서별 출력
	@PostMapping("/getPaperMtl")
	public List<MaterialVO> getPaperMtl(MaterialVO vo){
		return materialService.getPaperMtl(vo);
	}
	// 발주조회 조건검색
	@PostMapping("/searchNeed")
	public List<MaterialVO> searchNeed(MaterialVO vo){
		return materialService.searchNeed(vo);
	}	
	// 재고조회 조건검색
	@PostMapping("/searchCont")
	public List<MaterialVO> searchCont(MaterialVO vo){
		return materialService.searchCont(vo);
	}	
}
