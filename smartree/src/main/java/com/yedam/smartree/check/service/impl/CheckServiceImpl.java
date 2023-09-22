package com.yedam.smartree.check.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.business.service.ReqVO;
import com.yedam.smartree.check.mapper.CheckMapper;
import com.yedam.smartree.check.service.CheckService;
import com.yedam.smartree.check.service.CheckVO;

@Service
public class CheckServiceImpl implements CheckService{


	  @Autowired CheckMapper checkmapper;

	@Override
	public List<BpVO> selectPrdtList(BpVO vo) {
		return checkmapper.selectPrdtList(vo);
		
	}

	@Override
	public List<CheckVO> selectPrdtStdList(CheckVO vo) {
		return checkmapper.selectPrdtStdList(vo);
	}

	@Override
	public int insertPrdtChkStd(CheckVO vo) {
		return checkmapper.insertPrdtChkStd(vo);
	}

	@Override
	public List<CheckVO> selectPrdtCheckList(CheckVO vo) {
		return checkmapper.selectPrdtCheckList(vo);
	}

	@Override
	public List<CheckVO> selectdtList(CheckVO vo) {
		return checkmapper.selectdtList(vo);
	}

	@Override
	public List<CheckVO> selectProdCheckList(CheckVO vo) {
		return checkmapper.selectProdCheckList(vo);
	}

	@Override
	public List<CheckVO> selectProdDtList(CheckVO vo) {
		return checkmapper.selectProdDtList(vo);
	}

	@Override
	public int updateProdChk(ReqVO<CheckVO> vo) {
		boolean check = true;
		int cnt=0;
		checkmapper.updateProdChk(vo.getChkData().get(0));
		String prdtChkCode = vo.getChkData().get(0).getPrdtChkCode();
		String prdtCode = vo.getChkData().get(0).getPrdtCode();
		for(int i =0; i<vo.getChkDtData().size(); i++) {
			vo.getChkDtData().get(i).setPrdtChkCode(prdtChkCode);
			vo.getChkDtData().get(i).setPrdtCode(prdtCode);
			checkmapper.insertDtProdChk(vo.getChkDtData().get(i));
			cnt++;
			if(vo.getChkDtData().get(i).getPrdtChkFit().equals("부적합")) {
				check=false;
			}
			
		}
		if(!check) {
			checkmapper.updatePrdtChk(vo.getChkData().get(0));
		}	
		return cnt;
	}

	@Override
	public List<CheckVO> selectPrdtFin(CheckVO vo) {
		return checkmapper.selectPrdtFin(vo);
	}

	 
}
