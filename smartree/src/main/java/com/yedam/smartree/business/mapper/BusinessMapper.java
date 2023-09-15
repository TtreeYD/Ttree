package com.yedam.smartree.business.mapper;

import java.util.List;


import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessVO;


public interface BusinessMapper {

	public List<BusinessVO> selectOrderList();
	public List<BusinessVO> selectOrderDtList(BusinessVO businessVO);
	public List<BusinessVO> getOrder(BusinessVO businessVO);
	//public List<BusinessVO> clickOrder(BusinessVO businessVO);
	
	//주문 등록
	public void insertOrder(BusinessVO vo);
	//주문상세등록
	public void insertDtOrder(BusinessVO businessVO);
	//업체목록
	public List<BpVO> selectBpList(BpVO bpVO);
	//제품목록
	public List<BpVO> selectPrdtList(BpVO bpVO);
	
	
}
