package com.yedam.smartree.prod.service;

import java.util.List;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.material.service.MaterialVO;

public interface ProdService {
	public List<ProdVO> selectProdList();
	public List<BusinessVO> selectOrderAndPrdt();
	public List<ProdVO> selectProd(ProdVO vo);
	public List<ProdVO> selectProdInstList(ProdVO vo);
	public List<ProdVO> searchProdList(ProdVO vo);
	public List<ProdVO> selectProdListView(ProdVO vo);
	public List<PrdtProdVO> selectPrdt(PrdtProdVO vo);
	public List<ProdVO> selectGetProdList(ProdVO vo);
	public List<ProdVO> selectGetProdInstList(ProdVO vo);
	public int insertProdPlan(RequestVO<ProdVO> vo);
	public int deleteProd(RequestVO<ProdVO> vo);
	public int insertAndUpdateDtProdPlan(RequestVO<ProdVO> vo);
	
	public int insertProdInst(RequestVO<ProdVO> vo);

	public int updateProdInst(RequestVO<ProdVO> vo);
	
	public int deleteProdInst(RequestVO<ProdVO> vo);
	//생산지시조회
	public List<ProdVO> selectGetDtInst(ProdVO vo);
	////키오스크 :생산지시불러오기
	public List<ProdVO> selectGetProcess(ProdVO vo);
	
	//public int updateProd(RequestVO<ProdVO> vo);
}
