package com.yedam.smartree.prod.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.mdm.service.MdmPrcsVO;
import com.yedam.smartree.prod.mapper.ProdMapper;
import com.yedam.smartree.prod.service.HoldingVO;
import com.yedam.smartree.prod.service.PrcsResultVO;
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
	public List<ProdVO> selectDtPlanList(ProdVO vo){
		return prodMapper.selectDtPlanList(vo);
	}

	@Override
	public List<BusinessVO> selectOrderAndPrdt() {
		return prodMapper.selectAllOrderAndPrdt();
	}
	
	@Override
	@Transactional
	public int insertProdPlan(RequestVO<ProdVO> vo) {
		int cnt = 0;
		// get Header
		prodMapper.insertProdPlan(vo.getVo());
		if(vo.getVo().getResult().equals("error")) {
			return 0 ;
		}
		String prodPlanCode = vo.getVo().getProdPlanCode();
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

	/*
	 * @Override public int updateProd(RequestVO<ProdVO> vo) { int cnt = 0;
	 * prodMapper.updateProd(vo.getVo());
	 * 
	 * for(ProdVO pvo : vo.getList()) { prodMapper.updateDtProd(pvo); cnt++; }
	 * return cnt; }
	 */

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
	public Map<String, Object> selectGetProdList(ProdVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		//prodMapper.selectGetProd(vo)
		map.put("list", prodMapper.selectGetProd(vo));
		map.put("mtlNeed", prodMapper.getMtlNeed(vo));
		return map;
	}
	//생산지시 등록
	@Override
	public int insertProdInst(RequestVO<ProdVO> vo) {
		int cnt = 0;
		// get Header
		prodMapper.insertProdInst(vo.getVo());
		String prodInstCode = vo.getVo().getProdInstCode();
		// 계획 상세 저장하는 for문
		for(ProdVO pvo : vo.getList()) {
			pvo.setProdInstCode(prodInstCode);
			prodMapper.insertDtProdInst(pvo);
		//	String dtInstCode = pvo.getDtProdInstCode();
		//	pvo.setDtProdInstCode(dtInstCode);
			cnt++;
			//완제품공정흐름도 등록
			System.out.println("11111111111111111"+pvo);
			prodMapper.insertProcess(pvo);
		}
		for(ProdVO hvo : vo.getHlist()) {
			hvo.setProdInstCode(prodInstCode);
			prodMapper.insertHolding(hvo);
		}
		
		return cnt;
	}

	@Override
	public List<ProdVO> selectProdInstList(ProdVO vo) {
		return prodMapper.selectProdInst(vo);
	}

	@Override
	public Map<String, Object> selectGetProdInstList(ProdVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		//prodMapper.selectGetProd(vo)
		map.put("list", prodMapper.selectGetProdInst(vo));
		map.put("mtlNeed", prodMapper.getMtlNeed(vo));
		return map;
	}

	@Override
	public int updateProdInst(RequestVO<ProdVO> vo) {
		int cnt = 0;
		String prodInstCode = vo.getVo().getProdInstCode();
		prodMapper.updateProdInst(vo.getVo());
		for(ProdVO pvo : vo.getList()) {
			prodMapper.updateDtProdInst(pvo);
			prodMapper.updateProcess(pvo);
			cnt++;
		}
		prodMapper.delHolding(prodInstCode);
		for(ProdVO hvo : vo.getHlist()) {
			hvo.setProdInstCode(prodInstCode);
			prodMapper.insertHolding(hvo);
		}
		return cnt;
	}

	@Override
	public int deleteProdInst(RequestVO<ProdVO> vo) {
		int cnt = 0;
		prodMapper.deleteProdInst(vo.getVo());
		String prodInstCode = vo.getVo().getProdInstCode();
		prodMapper.delHolding(prodInstCode);
		for(ProdVO pvo : vo.getList()) {
			prodMapper.deleteDtProdInst(pvo);
			prodMapper.delProcess(pvo);
			cnt++;
		}
		return cnt;
	}
	//생산지시조회
	@Override
	public List<ProdVO> selectGetDtInst(ProdVO vo) {
		return prodMapper.selectGetDtInst(vo);
	}
	//키오스크 :생산지시불러오기
	@Override
	public List<ProdVO> selectGetProcess(ProdVO vo) {
		return prodMapper.selectGetProcess(vo);
	}

	@Override

	public List<ProdVO> getProcess(ProdVO vo) {
		return prodMapper.getProcess(vo);
	}
	public List<PrcsResultVO> selectPrcsResult(PrcsResultVO vo) {
		System.out.println("@@@@@@@@@"+vo);
		return prodMapper.selectPrcsResult(vo);

	}

	@Override
	public List<MdmPrcsVO> selectPrcsCode(ProdVO vo) {
		return prodMapper.selectPrcsCode(vo);
	}
	//생산시작버튼클릭(공정실적관리 insert)
	@Override
	public int insertDtProgress(RequestVO<ProdVO> vo) {
		prodMapper.insertDtProgress(vo.getList().get(0));
		prodMapper.updateEqmState(vo.getVo());
		prodMapper.updateInst(vo.getVo());
		return 0;
	}

	@Override
	public List<HoldingVO> selectHolding(String prodInstCode) {
		return prodMapper.selectHolding(prodInstCode);
	}
	//생산종료List
	@Override
	public List<ProdVO> getProcessResult(ProdVO vo) {
		return prodMapper.getProcessResult(vo);
	}
	//생산종료Process
	@Override
	public int endProcessResult(List<ProdVO> vo) {
		prodMapper.updateProcessResult(vo.get(0));
		return prodMapper.updateEqm(vo.get(0));
	}

	@Override
	public int updateInstYn(String prodPlanCode) {
		return prodMapper.updateInstYn(prodPlanCode);
	}

	@Override
	public List<ProdVO> getChartData() {
		return prodMapper.getChartData();
	}

	@Override
	public List<ProdVO> selectDtInstList(ProdVO vo) {
		return prodMapper.selectDtInstList(vo);
	}


	
	
}
