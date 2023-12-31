package com.yedam.smartree.business.service;

import java.util.List;

import com.yedam.smartree.check.service.CheckVO;

public interface BusinessService {
	//주문서목록
	public List<BusinessVO> selectOrderList(BusinessVO businessVO);
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
	//public int deleteDtOrder(ReqVO<BusinessVO> businessvo);
	
	//주문서수정
	//public int updateOrder(ReqVO<BusinessVO> businessvo);
	
	//업체목록
	public List<BpVO> selectBpList(BpVO bpVO);
	
	//제품목록
	public List<BpVO> selectPrdtList(BpVO bpVO);
	//완제품 제품별 조회
	public List<FinPrdtVO> selectFinPrdt();
	//Lot별 수량
	public List<FinPrdtVO> selectFinLotPrdt(FinPrdtVO fpvo);
	//lot별 수량(출고시 수량0인것들 안보이게)
	public List<FinPrdtVO> selectFinLotOutPrdt(FinPrdtVO fpvo);
	//완제품조건조회
	public List<FinPrdtVO> prdtSearchList(FinPrdtVO fpvo);
	//완제품출고관리
	public int prdtOutProcess(ReqVO<FinPrdtVO> finPrdtVO);
	//출고완료시 update
	public int prdtFinOut(BusinessVO businessvo);
	//출고전 orderList
	public List<BusinessVO> selectOrderBfOutList(BusinessVO businessVO);
	
	//출고조회
	public List<FinPrdtVO> prdtOutList(FinPrdtVO fpv);
	//출고상세조회
	public List<FinPrdtVO> prdtOutDtList(FinPrdtVO fpv);
	
	//입고처리
	public int recievePrdt(ReqVO<FinPrdtVO> fpv);
	//기출고 주문서조회
	public List<FinPrdtVO> searchFinOrder();
	//출고취소처리
	public int cancleOutPrdt(List<BusinessVO> businessVO);
	//입고조회
	public List<FinPrdtVO> prdtRecieveList(FinPrdtVO fpv);
	//입고취소처리
	public int cancleRecivePrdt(List<FinPrdtVO> fpv);
	// 제품별출고 데이터 가져오기
	public List<BusinessVO> getPrdtOutChartData();
	
	//메인페이지 업무현황 전부가져오기
	public ChartDataVO getAllChartData();
	//메인 제품별 주문
	public List<BusinessVO> getOrderChartData();
	//메인 제품이름 가져오기
	public List<BusinessVO> getPrdtNameChartData();
	//검사끝난 입고대기품목
	public List<CheckVO> prdtFinAfterChkList();
	//제품별 재고현황
	public List<FinPrdtVO> getPrdtChartData();
	//모니터링
	public String monitoring();
	//습도 현황 모니터링
	public String monitoringHumidity();
	
	
	
	

}
