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
	
	@GetMapping("/mtlNeeds")
	public List<MaterialVO> getneeds(){
		return materialService.selectNeedList();
	}
}
