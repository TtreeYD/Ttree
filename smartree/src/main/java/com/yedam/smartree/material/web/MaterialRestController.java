package com.yedam.smartree.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.material.service.MaterialService;
import com.yedam.smartree.material.service.MaterialVO;

@RestController
public class MaterialRestController {
	
	@Autowired
	MaterialService materialService;
	
	// 조회기능 목록
	@GetMapping("/mtlNeeds")
	public List<MaterialVO> getMtlNeeds(){
		return materialService.selectNeedList();
	}
	
	@GetMapping("/mtlExist")
	public List<MaterialVO> getMtlExist(){
		return materialService.selectMtlList();
	}
	
	@GetMapping("/mtlEmpty")
	public List<MaterialVO> getMtlEmpty(){
		return materialService.selectMtlOutList();
	}
}
