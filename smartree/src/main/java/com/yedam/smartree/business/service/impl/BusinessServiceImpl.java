package com.yedam.smartree.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.mapper.BusinessMapper;
import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.business.service.FinPrdtVO;
import com.yedam.smartree.business.service.ReqVO;

@Service
public class BusinessServiceImpl implements BusinessService{
	@Autowired
	BusinessMapper businessmapper;
	@Override
	public List<BusinessVO> selectOrderList(BusinessVO businessVO) {
		return businessmapper.selectOrderList(businessVO);
	}
	@Override
	public List<BusinessVO> selectOrderDtList(BusinessVO businessVO) {
		return businessmapper.selectOrderDtList(businessVO);
		
	}
	@Override
	public List<BusinessVO> getOrder(BusinessVO businessVO) {
		return businessmapper.getOrder(businessVO);
	}
//	@Override
//	public List<BusinessVO> clickOrder(BusinessVO businessVO) {
//		return businessmapper.clickOrder(businessVO);
//	}
	
	//주문등록
	@Override
	public int insertOrder(ReqVO<BusinessVO> businessvo) {
		businessmapper.insertOrder(businessvo.getOrderList().get(0));
		int cnt = 0;
		String orderCode = businessvo.getOrderList().get(0).getOrderCode();
			for(int i = 0 ; i<businessvo.getOrderDtList().size();i++) {
				businessvo.getOrderDtList().get(i).setOrderCode(orderCode);
				businessmapper.insertDtOrder(businessvo.getOrderDtList().get(i));
				cnt++;
			}
		return cnt;
	}
	//주문수정
//	@Override
//	public int updateOrder(ReqVO<BusinessVO> businessvo) {
//		int cnt=0;
//		businessmapper.updateOrder(businessvo.getOrderList().get(0));
//		
//		for(int i = 0 ; i<businessvo.getOrderDtList().size();i++) {
//			businessmapper.updateDtOrder(businessvo.getOrderDtList().get(i));
//			cnt++;
//		}
//		return cnt;
//	}
	
	//주문서추가등록
		@Override
		public int plusDtOrder(ReqVO<BusinessVO> businessvo) {
			int cnt=0;
			businessmapper.updateOrder(businessvo.getOrderList().get(0));
			String orderCode = businessvo.getOrderList().get(0).getOrderCode();
			businessmapper.deleteAllDtOrder(businessvo.getOrderList().get(0));
			for(int i = 0 ; i<businessvo.getOrderDtList().size();i++) {
				businessvo.getOrderDtList().get(i).setOrderCode(orderCode);
				businessmapper.insertDtOrder(businessvo.getOrderDtList().get(i));
				cnt++;
			}
			return cnt;
		}
	
	//주문서삭제
	@Override
	public int deleteOrder(ReqVO<BusinessVO> businessvo) {
		businessmapper.deleteOrder(businessvo.getOrderList().get(0));
		String orderCode = businessvo.getOrderList().get(0).getOrderCode();
				businessvo.getOrderList().get(0).setOrderCode(orderCode);
				businessmapper.deleteAllDtOrder(businessvo.getOrderList().get(0));
		return	1; 
	}
	//주문서상세삭제
//	@Override
//	public int deleteDtOrder(ReqVO<BusinessVO> businessvo) {
//		int cnt =0;
//		for(int i =0;i<businessvo.getOrderDtList().size();i++) {
//			businessmapper.deleteDtOrder(businessvo.getOrderDtList().get(i));
//			cnt++;
//		}
//		return cnt;
//	}
	
	//업체목록
	@Override
	public List<BpVO> selectBpList(BpVO bpVO) {
		
		System.out.println(bpVO.getBpCode());
		return businessmapper.selectBpList(bpVO);
		
	}
	
	//제품목록
	@Override
	public List<BpVO> selectPrdtList(BpVO bpVO) {
		return businessmapper.selectPrdtList(bpVO);
	}
	//완제품재고조회
	@Override
	public List<FinPrdtVO> selectFinPrdt() {
		return businessmapper.selectFinPrdt();
	}
	//Lot별 재고조회
	@Override
	public List<FinPrdtVO> selectFinLotPrdt(FinPrdtVO fpvo) {
		return businessmapper.selectFinLotPrdt(fpvo);
	}
	//Lot별 재고조회(출고시 수량0인것들 안보이게)
	@Override
	public List<FinPrdtVO> selectFinLotOutPrdt(FinPrdtVO fpvo) {
		return businessmapper.selectFinLotOutPrdt(fpvo);
	}
	//완제품조건검색
	@Override
	public List<FinPrdtVO> prdtSearchList(FinPrdtVO fpvo) {
		return businessmapper.prdtSearchList(fpvo);
	}
	//제품출고
	@Override
	public int prdtOutProcess(ReqVO<FinPrdtVO> finPrdtVO) {
		int cnt=0;
		//주문출고테이블insert
		businessmapper.insertPrdtOut(finPrdtVO.getVo());
		String dtcode = finPrdtVO.getVo().getOrderDtCode();
		String outcod= finPrdtVO.getVo().getPrdtOutCode();
		//주문상세출고테이블insert
		for(int i =0; i<finPrdtVO.getList().size();i++) {
			finPrdtVO.getList().get(i).setOrderDtCode(dtcode);
			finPrdtVO.getList().get(i).setPrdtOutCode(outcod);
			businessmapper.insertPrdtDtOut(finPrdtVO.getList().get(i));
			cnt++;
			//재고수량 update
			businessmapper.updatePrdtOut(finPrdtVO.getList().get(i));
		}
		return cnt;
	}
	//제품출고완료update
	@Override
	public int prdtFinOut(BusinessVO businessvo) {
		return businessmapper.prdtFinOut(businessvo);
	}
	@Override
	public List<BusinessVO> selectOrderBfOutList(BusinessVO businessVO) {
		return businessmapper.selectOrderBfOutList(businessVO);
	}
	//출고조회
	@Override
	public List<FinPrdtVO> prdtOutList(FinPrdtVO fpv) {
		return businessmapper.prdtOutList(fpv);
	}
	//출고상세조회
	@Override
	public List<FinPrdtVO> prdtOutDtList(FinPrdtVO fpv) {
		return businessmapper.prdtOutDtList(fpv);
	}
	//입고처리
	@Override
	public int recievePrdt(ReqVO<FinPrdtVO> fpv) {
		int cnt=0;
		for(int i = 0 ; i<fpv.getList().size();i++) {
			int grc = fpv.getList().get(i).getPrdtRecieveCnt();
			fpv.getList().get(i).setPrdtCnt(grc);
			businessmapper.recievePrdt(fpv.getList().get(i));
			cnt++;
			if(cnt>0) {
			businessmapper.updatePrdt(fpv.getList().get(i).getPrdtChkCode());
			}
		}
		return cnt;
	}
	//출고끝난 주문서검색
	@Override
	public List<FinPrdtVO> searchFinOrder() {
		return businessmapper.searchFinOrder();
	}
	//출고취소처리
	@Override
	public int cancleOutPrdt(List<BusinessVO> businessVO) {
		int cnt=0;
		for(int i = 0 ; i<businessVO.size();i++) {
			System.out.println(businessVO.get(i).getOrderDtCode());
			businessmapper.cancleOutPrdt(businessVO.get(i));
			cnt++;
		}
		return cnt;//
	}
	//입고리스트
	@Override
	public List<FinPrdtVO> prdtRecieveList(FinPrdtVO fpv) {
		return businessmapper.prdtRecieveList(fpv);
	}
	//입고취소처리
	@Override
	public int cancleRecivePrdt(List<FinPrdtVO> fpv) {
		int cnt=0;

		for(int i =0; i<fpv.size();i++) {
			businessmapper.cancleRecivePrdt(fpv.get(i));
			cnt++;
			businessmapper.updateChkState(fpv.get(i));
		}

		return cnt;
	}
	// 제품별출고 데이터 가져오기
	@Override
	public List<BusinessVO> getPrdtOutChartData() {
		return businessmapper.getPrdtOutChartData();
	}

}
