package com.yedam.smartree.material.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.material.service.MaterialService;

@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	MaterialService materialService;
	
	// 조회기능 목록
	@GetMapping("/needList")
	public String selectNeedList() {
		
		return "material/needList";
	}
	
	@GetMapping("/mtlList")
	public String selectMtlList() {
		
		return "material/mtlList";
	}
	
	@GetMapping("/mtlOutList")
	public String selectMtlOutList() {
		
		return "material/mtlOutList";
	}
}
