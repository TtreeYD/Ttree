package com.yedam.smartree.material.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.smartree.material.service.MaterialService;

@Controller
public class MaterialController {
	@Autowired
	MaterialService materialService;
	
	@GetMapping("needList")
	public String selectNeedList() {
		
		return "material/needList";
	}
	
}
