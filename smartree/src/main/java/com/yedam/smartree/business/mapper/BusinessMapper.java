package com.yedam.smartree.business.mapper;

import java.util.List;


import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.business.service.ReqVO;


public interface BusinessMapper {

	public List<BusinessVO> selectOrderList();
	public List<BusinessVO> selectOrderDtList(BusinessVO businessVO);
	public List<BusinessVO> getOrder(BusinessVO businessVO);
	//public List<BusinessVO> clickOrder(BusinessVO businessVO);
	
	//주문 등록
	public void insertOrder(BusinessVO vo);
	//주문상세등록
	public void insertDtOrder(BusinessVO businessVO);
	
	//주문수정
	public void updateOrder(BusinessVO businessVO);
	
	//주문상세수정
	public void updateDtOrder(BusinessVO businessVO);
	
	//주문서삭제
	public void deleteOrder(BusinessVO businessVO);
	//주문서상세삭제(전체삭제)
	public void deleteAllDtOrder(BusinessVO businessVO);
	
	//업체목록
	public List<BpVO> selectBpList(BpVO bpVO);
	//제품목록
	public List<BpVO> selectPrdtList(BpVO bpVO);
	
	//주문상세수정및등록
	public void insertNewDtOrder(BusinessVO businessVO);
	//주문서상세삭제
	public void deleteDtOrder(BusinessVO businessVO);
	
	
}
