package com.yedam.smartree.business.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;
/*
개발자:정호현
개발일자:23/09/14
영업관리
*/
@RestController
public class BusinessRestController {
	@Autowired
	BusinessService businessService;
	
	//리스트OrderAjax
	@GetMapping("/orders")
	public List<BusinessVO> getOrders(){
		return businessService.selectOrderList();
	}
	//리스트DtListAjax
	@GetMapping("/orderDtList")
	public List<BusinessVO> getDtOrders(BusinessVO businessVO){
		return businessService.selectOrderDtList(businessVO);
	}
	
	@PostMapping("/selectOrder")
	public List<BusinessVO> getOrderDt(BusinessVO businessVO) {
		return businessService.getOrder(businessVO);
	}
}
