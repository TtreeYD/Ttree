package com.yedam.smartree.prod.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.prod.mapper.ProdMapper;
import com.yedam.smartree.prod.service.ProdService;
import com.yedam.smartree.prod.service.ProdVO;
import com.yedam.smartree.prod.service.RequestVO;

@Service
public class ProdServiceImpl implements ProdService {
	@Autowired
	ProdMapper prodMapper;
	
	@Override
	public List<ProdVO> selectProdList() {
		return prodMapper.selectProdList();
	}

	@Override
	public List<BusinessVO> selectOrderAndPrdt() {
		return prodMapper.selectAllOrderAndPrdt();
	}
//
//	@Override
//	public List<BusinessVO> selectOneOrderAndPrdt(BusinessVO vo) {
//		return prodMapper.selectOrderAndPrdt(vo);
//	}

	@Override
	public int insertProdPlan(RequestVO<ProdVO> vo) {
		int cnt = 0;
		// get Header
		prodMapper.insertProdPlan(vo.getVo());
		
		// 계획 상세 저장하는 for문
		for(int i = 0; i < vo.getList().size(); i++) {
			System.out.println(vo.getList().toString());
			prodMapper.insertDtProdPlan(vo.getList().get(i));
			cnt++;
		}
		return cnt;
	}

	@Override
	public List<ProdVO> searchProdList(ProdVO vo) {
		return prodMapper.searchProdPlan(vo);
	}

	
	
}
