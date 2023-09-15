package com.yedam.smartree.business.service;

import java.util.List;

import com.yedam.smartree.business.web.ReqVO;

public interface BusinessService {
	//주문서목록
	public List<BusinessVO> selectOrderList();
	//주문서상세
	public List<BusinessVO> selectOrderDtList(BusinessVO businessVO);
	//주문서 검색
	public List<BusinessVO> getOrder(BusinessVO businessVO);

	//주문서등록
	public int insertOrder(ReqVO<BusinessVO> businessvo);

	//public List<BusinessVO> clickOrder(BusinessVO businessVO);
}
