package com.yedam.smartree.mdm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mdm")
public class CommonContorller {
	
	@GetMapping("/emp")
	public String empList() {
		return "mdm/emp";
	}
	
}
