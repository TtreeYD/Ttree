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
	public List<BusinessVO> selectOrderList() {
		return businessmapper.selectOrderList();
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
	@Override
	public int updateOrder(ReqVO<BusinessVO> businessvo) {
		int cnt=0;
		businessmapper.updateOrder(businessvo.getOrderList().get(0));
		
		for(int i = 0 ; i<businessvo.getOrderDtList().size();i++) {
			businessmapper.updateDtOrder(businessvo.getOrderDtList().get(i));
			cnt++;
		}
		return cnt;
	}
	
	//주문서추가등록
		@Override
		public int plusDtOrder(ReqVO<BusinessVO> businessvo) {
			int cnt=0;
			String orderCode = businessvo.getOrderList().get(0).getOrderCode();
			for(int i = 0 ; i<businessvo.getOrderDtList().size();i++) {
				businessvo.getOrderDtList().get(i).setOrderCode(orderCode);
				businessmapper.insertNewDtOrder(businessvo.getOrderDtList().get(i));
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
	@Override
	public int deleteDtOrder(ReqVO<BusinessVO> businessvo) {
		int cnt =0;
		for(int i =0;i<businessvo.getOrderDtList().size();i++) {
			businessmapper.deleteDtOrder(businessvo.getOrderDtList().get(i));
			cnt++;
		}
		return cnt;
	}
	
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
	//완제품조건검색
	@Override
	public List<FinPrdtVO> prdtSearchList(FinPrdtVO fpvo) {
		return businessmapper.prdtSearchList(fpvo);
	}
	//제품출고
	@Override
	public int prdtOutProcess(ReqVO<FinPrdtVO> finPrdtVO) {
		int cnt=0;
		businessmapper.insertPrdtOut(finPrdtVO.getVo());
		String dtcode = finPrdtVO.getVo().getOrderDtCode();
		String outcod= finPrdtVO.getVo().getPrdtOutCode();
		System.out.println("33333333333333333"+outcod);
		for(int i =0; i<finPrdtVO.getList().size();i++) {
			finPrdtVO.getList().get(i).setOrderDtCode(dtcode);
			finPrdtVO.getList().get(i).setPrdtOutCode(outcod);
			businessmapper.insertPrdtDtOut(finPrdtVO.getList().get(i));
			cnt++;
		}
		return cnt;
	}
	

	
	

}
