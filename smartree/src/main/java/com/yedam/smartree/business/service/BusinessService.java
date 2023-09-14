package com.yedam.smartree.business.service;

import java.util.List;

public interface BusinessService {

	public List<BusinessVO> selectOrderList();
	
	public List<BusinessVO> selectOrderDtList(BusinessVO businessVO);

	public List<BusinessVO> getOrder(BusinessVO businessVO);
}
