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
	public  int insertOrder(ReqVO<BusinessVO> businessvo);
	
	//주문서추가등록
	public int plusDtOrder(ReqVO<BusinessVO> businessvo);
	
	//주문서삭제
	public int deleteOrder(ReqVO<BusinessVO> businessvo);
	
	//주문서상세삭제
	public int deleteDtOrder(ReqVO<BusinessVO> businessvo);
	
	//주문서수정
	public int updateOrder(ReqVO<BusinessVO> businessvo);
	
	//업체목록
	public List<BpVO> selectBpList(BpVO bpVO);
	
	//제품목록
	public List<BpVO> selectPrdtList(BpVO bpVO);
	//완제품 제품별 조회
	public List<FinPrdtVO> selectFinPrdt();
	//Lot별 수량
	public List<FinPrdtVO> selectFinLotPrdt(FinPrdtVO fpvo);

	

}
