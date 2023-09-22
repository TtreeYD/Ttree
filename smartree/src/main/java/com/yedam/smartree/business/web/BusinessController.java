package com.yedam.smartree.business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;
/*
개발자:정호현
개발일자:23/09/14
영업관리
*/
@Controller
@RequestMapping("/business")
public class BusinessController {
	@Autowired
	BusinessService businessService;
	//주문서조회페이지이동
	@GetMapping("orderList")
	public String selectAllOrder() {
		
		return "business/orderList";
	}
	//주문서관리페이지이동
	@GetMapping("orderForm")
	public String selectOrderForm() {
		return "business/orderForm";
	}
	//완제품재고조회 페이지이동
	@GetMapping("finPrdt")
	public String selectFinPrdt(Model model) {
		model.addAttribute("finPrdt", businessService.selectFinPrdt());
		return "business/finPrdt";
	}
	
	//출고관리 페이지 이동
	@GetMapping("prdtOut")
	public String selectprdtOut() {
		return "business/prdtOut";
	}
	//출고조회 페이지이동
	@GetMapping("prdtOutCheck")
	public String prdtOutCheck() {
		return "business/prdtOutList";
	}
	//입고관리 페이지이동
	@GetMapping("prdtRecieve")
	public String prdtRecieve() {
		return "business/prdtRecieve";
	}
}
