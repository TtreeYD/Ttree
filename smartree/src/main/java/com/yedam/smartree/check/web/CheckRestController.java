package com.yedam.smartree.check.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/check")
	public List<MtlCheckVO> getcheck(){
		return mtlcheckservice.selectAll();
	}
	
	
	@PostMapping("/mtlcheck")
	@ResponseBody
	public List<MtlCheckVO> mtlcheck(MtlCheckVO vo){

		System.out.println(mtlcheckservice.selectMtl(vo));
		return mtlcheckservice.selectMtl(vo);
	}
	
	@GetMapping("/mtlget")
	public List<MtlCheckVO> mtlgetcheck(MtlCheckVO vo){
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
	
	//다건 삭제
	//   @PostMapping("empDelete")
	 //  public List<String> empsDelete(@RequestBody List<EmpVO> empList){
	   //   List<String> delList = new ArrayList<>();
	     // 
	     // for(EmpVO empVO : empList) {
	      //   int result = empMapper.deleteEmpInfo(empVO);
	       //  if(result > 0) {
	        //    delList.add(empVO.getEmployeeId());
	      //   }
	     // }
	      
	    //  return delList;
	  // }
}
