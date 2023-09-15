package com.yedam.smartree.business.service;

import java.util.List;

public interface BusinessService {
	//주문서목록
	public List<BusinessVO> selectOrderList();
	//주문서상세
	public List<BusinessVO> selectOrderDtList(BusinessVO businessVO);
	//주문서 검색
	public List<BusinessVO> getOrder(BusinessVO businessVO);

	//주문서등록
	public int insertOrder(ReqVO<BusinessVO> businessvo);
	
	
	//업체목록
	public List<BpVO> selectBpList(BpVO bpVO);
	
	//제품목록
	public List<BpVO> selectPrdtList(BpVO bpVO);

}
