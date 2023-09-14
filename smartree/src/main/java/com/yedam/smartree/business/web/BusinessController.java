package com.yedam.smartree.business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.business.service.BusinessService;

@Controller
@RequestMapping("/business")
public class BusinessController {
	@Autowired
	BusinessService businessService;
	
	@GetMapping("orderList")
	public String selectAllOrder() {
		
		return "business/orderList";
	}
	@GetMapping("orderForm")
	public String selectOrderForm() {
		return "business/orderForm";
	}
}
