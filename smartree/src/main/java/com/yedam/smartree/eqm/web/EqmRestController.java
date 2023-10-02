package com.yedam.smartree.eqm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.eqm.service.EqmInspService;
import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmNoperVO;
import com.yedam.smartree.eqm.service.EqmService;
import com.yedam.smartree.eqm.service.EqmVO;

@RestController
public class EqmRestController {
	@Autowired
	EqmService eqmservice;	
	
	 @Autowired 
	 EqmInspService eqminspservice;
	 
	// 설비 전체조회
	@GetMapping("/eqms")
	public List<EqmVO> getEqms() {
		return eqmservice.selectEqmList();
	}
	// 설비 사용여부 조회
	@GetMapping("/eqmUcheck")
	public List<EqmVO> getEqmUcheck(String eqmUcheck) {
		return eqmservice.selectEqmUcheckList(eqmUcheck);
	}
	// 설비 점검 전체조회
	@GetMapping("/eqmInsps")
	public List<EqmInspVO> getEqmInsps(){
		return eqminspservice.selectEqmInspList();
	}
	// 설비 점검 판단여부 조회
	@GetMapping("/eqmInspJudg")
	public List<EqmInspVO> getEqmInspJudg(String inspJudg){
		return eqminspservice.selectEqmInspInspJudgList(inspJudg);
	}
	// 설비 이름으로 조회
	@GetMapping("/eqmName")
	public List<EqmVO> getEqmName(String eqmName){
		return eqmservice.searchEqm(eqmName);
	}
	@GetMapping("/eqmInpsName")
	public List<EqmInspVO> getEqmInspName(String eqmName){
		return eqminspservice.searchEqmInsp(eqmName);
	}
	// 설비조회 모달창 더블 클릭시 단건조회
	@GetMapping("/selectEqm")
	public EqmVO getEqm(EqmVO eqmVO) {
		return eqmservice.selectEqm(eqmVO);
	}
	// 설비삭제
	@GetMapping("/deleteEqm")
	public int deleteEqm(EqmVO eqmVO) {
		return eqmservice.deleteEqm(eqmVO);
	}
	// 설비점검 단건조회
	@GetMapping("/selectEqmInsp")
	public EqmInspVO getEqmInsp(EqmInspVO eqmInspVO){
		return eqminspservice.selectEqmInsp(eqmInspVO);
	}
	// 설비구분으로 조회
	@GetMapping("/eqmDivision")
	public List<EqmVO> getEqmDivision(String eqmDivision){
		return eqmservice.searchEqmDivision(eqmDivision);
	}
	// 비가동조회
	@GetMapping("/eqmNopers")
	public List<EqmNoperVO> getEqmNopers(){
		return eqminspservice.selectEqmNoper();
	}
	@GetMapping("/eqmNoperName")
	public List<EqmNoperVO> getEqmNoperName(String eqmName){
		return eqminspservice.searchEqmNoper(eqmName);
	}
	// 비가동조회 모달창 더블 클릭시 단건조회
	@GetMapping("/selectEqmNoper")
	public EqmNoperVO getEqmNoper(EqmNoperVO eqmNoperVO) {
		return eqminspservice.selectEqmNoperCode(eqmNoperVO);
	}
	
}
