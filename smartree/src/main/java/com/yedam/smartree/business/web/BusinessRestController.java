package com.yedam.smartree.business.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	//리스트DtListAjax || 주문서관리-주문서검색후 더블클릭(위의 주문정보정보는 클릭했을때let searchModalData; 검색버튼 클릭 할때 그 result를 담아준다.
	//										그리고 해당 열 더블 클릭 할때 ev.rowKey값으로 해당열의 값 받아서 뿌려주고 상세페이지만 데이터가져오면되서 dtorder 가져오는리스트 같이사용)
	@GetMapping("/orderDtList")
	public List<BusinessVO> getDtOrders(BusinessVO businessVO){
		return businessService.selectOrderDtList(businessVO);
	}
	//주문서관리-주문서검색
	@PostMapping("/selectOrder")
	public List<BusinessVO> getOrderDt(BusinessVO businessVO) {
		return businessService.getOrder(businessVO);
	}
	
	//주문서관리-주문서검색후 더블클릭
//	@GetMapping("/orderDtList")
//	public List<BusinessVO>  selectOrder(BusinessVO businessVO) {
//		System.out.println(businessVO);
//		System.out.println(businessService.clickOrder(businessVO));
//		return businessService.selectOrderDtList(businessVO);
//	}
	
	@PostMapping("/insertOrder")
	public int insertOrder(@RequestBody ReqVO<BusinessVO> businessvo) {
		
		return businessService.insertOrder(businessvo);
	}
}
