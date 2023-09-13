package com.yedam.smartree.check.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.check.mapper.MtlCheckMapper;
import com.yedam.smartree.check.service.MtlCheckService;
import com.yedam.smartree.check.service.MtlCheckVO;

@Service
public class MtlCheckServiceImpl implements MtlCheckService{

	@Autowired
	MtlCheckMapper mtlcheckmapper;
	
	@Override
	public List<MtlCheckVO> Allselect() {
		return mtlcheckmapper.Allselect();
	}

}
