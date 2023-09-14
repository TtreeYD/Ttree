package com.yedam.smartree.prod.service;

import java.util.List;

import com.yedam.smartree.business.service.BusinessVO;

public interface ProdService {
	public List<ProdVO> selectProdList();
	public List<BusinessVO> selectOrderAndPrdt();
//	public List<BusinessVO> selectOneOrderAndPrdt(BusinessVO vo);
	public int insertProdPlan(RequestVO<ProdVO> vo);
}
