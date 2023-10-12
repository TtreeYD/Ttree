package com.yedam.smartree.check.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.ReqVO;
import com.yedam.smartree.check.service.CheckService;
import com.yedam.smartree.check.service.CheckVO;
import com.yedam.smartree.check.service.MtlCheckService;
import com.yedam.smartree.check.service.MtlCheckVO;

/*
 * 자재관리
 개발일자 2023/09/14 
 개발자 안영진
 */

@RestController
public class CheckRestController {
	@Autowired
	MtlCheckService mtlcheckservice;
	
	@Autowired
	CheckService checkservice;
	
	//자재검사목록(모달)
	@GetMapping("/mtlcheck")
	public List<MtlCheckVO> getmtlcheck(MtlCheckVO vo){
		return mtlcheckservice.selectMtl(vo);
	}
	//자재검사목록
	@PostMapping("/mtlcheck")
	@ResponseBody
	public List<MtlCheckVO> mtlcheck(MtlCheckVO vo){

		System.out.println(mtlcheckservice.selectMtl(vo));
		return mtlcheckservice.selectMtl(vo);
	}
	
	//자재검사저장
	@ResponseBody
	@PostMapping("/mtlinsert")
	public int mtlinsert(@RequestBody List<MtlCheckVO> checkList) {
		int cnt = 0;
		System.out.println(checkList);
		for(MtlCheckVO vo : checkList) {
			int result = mtlcheckservice.insertChkMtl(vo);
			if(result>0) cnt++;
		}
		return cnt;
	}
	
	//자재코드검색
	@GetMapping("/mtlName")
	public List<MtlCheckVO> getMtlName(String mtlName){
		return mtlcheckservice.searchMtl(mtlName);
	}
	//자재검사자검색
	@GetMapping("/mtlManager")
	public List<MtlCheckVO> getMtlManager(String mtlManager){
		return mtlcheckservice.searchMtlManager(mtlManager);
	}
	//자재날짜검색
	@GetMapping("/mtlDate")
	public List<MtlCheckVO> getMtlDate(String mtlDate){
		return mtlcheckservice.searchMtlDate(mtlDate);
	}
	
	//검사된자재검색(자재검사)
	@GetMapping("/mtlallchk")
	public List<MtlCheckVO> getMtlAllChk(){
		return mtlcheckservice.selectChkAll();
	}
	//검사된자재검색(자재조회)
	@GetMapping("/chkAll")
	public List<MtlCheckVO> getchkAll(){
		return mtlcheckservice.chkAll();
	}
	//검사된자재수정
	@PostMapping("/updatemtlchk")
	public int mtlupdate(MtlCheckVO vo) {
		return mtlcheckservice.updateChkMtl(vo);
	}
	//완제품목록
	@GetMapping("/selectprdt")
	public List<BpVO> getPrdtList(BpVO vo){
		return checkservice.selectPrdtList(vo);
	}
	//제품기준목록
	@GetMapping("/prdtStdList")
	public List<CheckVO> getPrdtStdList(CheckVO vo){
		return checkservice.selectPrdtStdList(vo);
	}
	
	//제품기준
	@GetMapping("/prdtStd")
	public List<CheckVO> getPrdtStd(CheckVO vo){
		return checkservice.selectPrdtStd(vo);
	}
	
	//제품기준저장
	@PostMapping("/insertPrdtChkList")
	public List<Integer> insertPrdtChkList(@RequestBody List<CheckVO> vo) {
		List<Integer> results = new ArrayList<>();
		String prdtCode = vo.get(0).getPrdtCode();
		checkservice.delChkStd(prdtCode);
		for(CheckVO checkvo : vo) {
			int result = checkservice.insertPrdtChkStd(checkvo);
			results.add(result);
		}
		return results;

	}
	
	// 제품검사끝난 목록조회
	@GetMapping("/prdtCheckList")
	public List<CheckVO> selectPrdtCheckList(CheckVO vo){
		return checkservice.selectPrdtCheckList(vo);
	}
	
	// 제품검사끝난 상세목록조회
	@GetMapping("/dtList")
	public List<CheckVO> selectDtList(CheckVO vo){
		return checkservice.selectdtList(vo);
	}
	
	// 완제품검사할목록조회
	@GetMapping("/prodCheckList")
	public List<CheckVO> selectProdCheckList(CheckVO vo){
		System.out.println("@@@@@@@@@@@@@@@@@@@" + vo);
		return checkservice.selectProdCheckList(vo);		
	}
	
	// 완제품검사할 상세목록조회
	@GetMapping("/prodDtList")
	public List<CheckVO> selectProdDtList(CheckVO vo){
		return checkservice.selectProdDtList(vo);
	}
	
	//완제품 검사저장(수정)
	@PostMapping("/updateProdChk")
	public int updateProdChk(@RequestBody ReqVO<CheckVO> vo) {
		return checkservice.updateProdChk(vo);
	}
	
	//완제품 합격조회
	@GetMapping("/prdtFinChkList")
	public List<CheckVO> selectprdtFin(CheckVO vo){
		return checkservice.selectPrdtFin(vo);
	}
	
}
