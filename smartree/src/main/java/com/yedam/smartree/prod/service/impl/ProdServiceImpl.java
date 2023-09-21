package com.yedam.smartree.prod.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.prod.mapper.ProdMapper;
import com.yedam.smartree.prod.service.PrdtProdVO;
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
	
	@Override
	public int insertProdPlan(RequestVO<ProdVO> vo) {
		int cnt = 0;
		// get Header
		prodMapper.insertProdPlan(vo.getVo());
		String prodPlanCode = vo.getVo().getProdPlanCode();
		System.out.println();
		// 계획 상세 저장하는 for문
		for(ProdVO pvo : vo.getList()) {
			pvo.setProdPlanCode(prodPlanCode);
			
			prodMapper.insertDtProdPlan(pvo);
			cnt++;
		}
		return cnt;
	}

	@Override
	public List<ProdVO> searchProdList(ProdVO vo) {
		return prodMapper.searchProdPlan(vo);
	}

	@Override
	public List<ProdVO> selectProd(ProdVO vo) {
		return prodMapper.selectProd(vo);
	}

	@Override
	public List<ProdVO> selectProdListView(ProdVO vo) {
		return prodMapper.selectProdListView(vo);
	}

	@Override
	public int updateProd(RequestVO<ProdVO> vo) {
		int cnt = 0;
		prodMapper.updateProd(vo.getVo());
		
		for(ProdVO pvo : vo.getList()) {
			prodMapper.updateDtProd(pvo);
			cnt++;
		}
		return cnt;
	}

	@Override
	public int deleteProd(RequestVO<ProdVO> vo) {
		int cnt = 0;
		prodMapper.deleteProd(vo.getVo());
		
		for(ProdVO pvo : vo.getList()) {
			
			prodMapper.deleteDtProd(pvo);
			cnt++;
			
		}
		return cnt;
	}

	@Override
	public int insertAndUpdateDtProdPlan(RequestVO<ProdVO> vo) {
		int cnt = 0;
		prodMapper.updateProd(vo.getVo());
		for(ProdVO pvo : vo.getList()) {
			prodMapper.insertAndUpdateDtProd(pvo);
			cnt++;
		}
		return cnt;
	}

	@Override
	public List<PrdtProdVO> selectPrdt(PrdtProdVO vo) {
		return prodMapper.selectPrdt(vo);
	}

	@Override
	public List<ProdVO> selectGetProdList(ProdVO vo) {
		return prodMapper.selectGetProd(vo);
	}

	
	
}
