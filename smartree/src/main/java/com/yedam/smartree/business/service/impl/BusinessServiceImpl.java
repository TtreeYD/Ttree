package com.yedam.smartree.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.mapper.BusinessMapper;
import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.business.web.ReqVO;

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
	
	@Override
	public int insertOrder(ReqVO<BusinessVO> businessvo) {
		int cnt = 0;
		businessmapper.insertOrder(businessvo.getOrderList().get(0));
		
		for(int i = 0 ; i< businessvo.getOrderDtList().size();i++) {
			businessmapper.insertDtOrder(businessvo.getOrderDtList().get(i));
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

}
