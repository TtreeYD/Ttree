package com.yedam.smartree.check.mapper;

import java.util.List;

import com.yedam.smartree.business.service.BpVO;


public interface CheckMapper {
	public List<BpVO> selectPrdtList(BpVO vo);
}
