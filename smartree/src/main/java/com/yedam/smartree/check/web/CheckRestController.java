package com.yedam.smartree.check.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BpVO;
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
	
	@GetMapping("/mtlcheck")
	public List<MtlCheckVO> getmtlcheck(MtlCheckVO vo){
		return mtlcheckservice.selectMtl(vo);
	}
	
	@PostMapping("/mtlcheck")
	@ResponseBody
	public List<MtlCheckVO> mtlcheck(MtlCheckVO vo){

		System.out.println(mtlcheckservice.selectMtl(vo));
		return mtlcheckservice.selectMtl(vo);
	}
	
	
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
	
	@GetMapping("/mtlName")
	public List<MtlCheckVO> getMtlName(String mtlName){
		return mtlcheckservice.searchMtl(mtlName);
	}
	@GetMapping("/mtlDate")
	public List<MtlCheckVO> getMtlDate(String mtlDate){
		return mtlcheckservice.searchMtlDate(mtlDate);
	}
	
	@GetMapping("/mtlallchk")
	public List<MtlCheckVO> getMtlAllChk(){
		return mtlcheckservice.selectChkAll();
	}
	
	@PostMapping("/updatemtlchk")
	public int mtlupdate(MtlCheckVO vo) {
		return mtlcheckservice.updateChkMtl(vo);
	}
	
	@GetMapping("/selectprdt")
	public List<BpVO> getPrdtList(BpVO vo){
		return checkservice.selectPrdtList(vo);
	}
	
	@GetMapping("/prdtStdList")
	public List<CheckVO> getPrdtStdList(CheckVO vo){
		return checkservice.selectPrdtStdList(vo);
	}
	
	@PostMapping("/insertPrdtChkList")
	public int insertPrdtChkList(CheckVO vo) {
		return checkservice.insertPrdtChkStd(vo);
	}
}
