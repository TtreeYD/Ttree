package com.yedam.smartree.check.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.service.BpVO;
import com.yedam.smartree.check.mapper.CheckMapper;
import com.yedam.smartree.check.service.CheckService;

@Service
public class CheckServiceImpl implements CheckService{


	  @Autowired CheckMapper checkmapper;

	@Override
	public List<BpVO> selectPrdtList(BpVO vo) {
		return checkmapper.selectPrdtList(vo);
	}
	 
}
