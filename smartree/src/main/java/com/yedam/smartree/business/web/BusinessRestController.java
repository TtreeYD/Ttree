package com.yedam.smartree.business.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;

@RestController
public class BusinessRestController {
	@Autowired
	BusinessService businessService;
	
	@GetMapping("/orders")
	public List<BusinessVO> getOrders(){
		return businessService.selectOrderList();
	}
	
	@GetMapping("/orderDtList")
	public List<BusinessVO> getDtOrders(BusinessVO businessVO){
		System.out.println(businessVO);
		System.out.println(businessService.selectOrderDtList(businessVO));
		return businessService.selectOrderDtList(businessVO);
	}
}
