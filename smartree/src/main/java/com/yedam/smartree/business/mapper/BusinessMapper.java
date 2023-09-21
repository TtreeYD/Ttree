package com.yedam.smartree.business.mapper;

import java.util.List;


import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.business.service.FinPrdtVO;
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
	
	//완제품재고조회 , 제품별 수량 조회 
	public List<FinPrdtVO> selectFinPrdt();
	//Lot별 완제품 재고조회
	public List<FinPrdtVO> selectFinLotPrdt(FinPrdtVO fpvo);
	//lot별 완제품 조회(출고 수량0안보이게)
	public List<FinPrdtVO> selectFinLotOutPrdt(FinPrdtVO fpvo);
	//완제품조건검색
	public List<FinPrdtVO> prdtSearchList(FinPrdtVO fpvo);
	
	//제품출고
	public int insertPrdtOut(FinPrdtVO vo);
	//제품상세출고
	public void insertPrdtDtOut(FinPrdtVO finPrdtVO);
	//제품출고시 재고update
	public void updatePrdtOut(FinPrdtVO finPrdtVO);
	//제품출고완료update
	public int prdtFinOut(BusinessVO businessvo);
	
	//납기전 orderList
	public List<BusinessVO> selectOrderBfOutList(BusinessVO businessVO);
	//출고조회
	public List<FinPrdtVO> prdtOutList(FinPrdtVO fpv);
	//출고상세조회
	public List<FinPrdtVO> prdtOutDtList(FinPrdtVO fpv);
	//입고처리
	public int recievePrdt(FinPrdtVO fpv);
	//입고처리된 완제품 상태변경
	public int updatePrdt(String prdtChkCode);
	
	
	
}
