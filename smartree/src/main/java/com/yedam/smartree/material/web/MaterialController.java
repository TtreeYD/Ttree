package com.yedam.smartree.material.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.material.service.MaterialService;
/*
	개발자   : 남태원
	개발일자  : 2023/09/13
			 자재관리
*/
@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	
	// 발주목록 전체조회
	@GetMapping("/mtlNeedList")
	public String selectNeedList() {
		return "material/mtlNeedList";
	}
	// 재고목록 전체조회
	@GetMapping("/mtlList")
	public String selectMtlList() {
		
		return "material/mtlList";
	}
	// 출고목록 전체조회
	@GetMapping("/mtlOutList")
	public String selectMtlOutList() {
		
		return "material/mtlOutList";
	}
	// 발주관리 
	@GetMapping("/mtlNeedControl")
	public String controlNeedList() {
		return "material/mtlNeedControl";
	}
	// 입고관리
	@GetMapping("/mtlInControl")
	public String controlInList() {
		return "material/mtlInControl";
	}
	
}
