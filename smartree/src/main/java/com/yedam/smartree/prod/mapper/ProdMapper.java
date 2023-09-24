package com.yedam.smartree.prod.mapper;

import java.util.List;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.prod.service.PrdtProdVO;
import com.yedam.smartree.prod.service.ProdVO;

public interface ProdMapper {
	
	public List<ProdVO> selectProdList();

	public List<BusinessVO> selectAllOrderAndPrdt();
	
	public List<ProdVO> selectProd(ProdVO vo);
	
	public int insertProdPlan(ProdVO vo);
	
	public int insertDtProdPlan(ProdVO vo);
	
	public List<ProdVO> searchProdPlan(ProdVO vo);
	
	public List<ProdVO> selectProdListView(ProdVO vo);
	
	public int updateProd(ProdVO vo);
	
	public int updateDtProd(ProdVO vo);
	
	public int deleteProd(ProdVO vo);
	
	public int deleteDtProd(ProdVO vo);
	
	public void insertAndUpdateDtProd(ProdVO vo);
	
	public List<PrdtProdVO> selectPrdt(PrdtProdVO vo);
	
	public List<ProdVO> selectGetProd(ProdVO vo);
	
	public int insertProdInst(ProdVO vo);
	
	public int insertDtProdInst(ProdVO vo);
}
