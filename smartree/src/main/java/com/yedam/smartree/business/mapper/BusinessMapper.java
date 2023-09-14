package com.yedam.smartree.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	
}
