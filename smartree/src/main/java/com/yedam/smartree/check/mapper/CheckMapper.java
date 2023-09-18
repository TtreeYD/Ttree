package com.yedam.smartree.check.mapper;

import java.util.List;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.check.service.CheckVO;


public interface CheckMapper {
	public List<BpVO> selectPrdtList(BpVO vo);
	public List<CheckVO> selectPrdtStdList(CheckVO vo);
	public int insertPrdtChkStd(CheckVO vo);
}
