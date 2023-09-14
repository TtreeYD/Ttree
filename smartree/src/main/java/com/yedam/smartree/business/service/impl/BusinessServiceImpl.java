package com.yedam.smartree.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.mapper.BusinessMapper;
import com.yedam.smartree.business.service.BusinessService;
import com.yedam.smartree.business.service.BusinessVO;

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

}
