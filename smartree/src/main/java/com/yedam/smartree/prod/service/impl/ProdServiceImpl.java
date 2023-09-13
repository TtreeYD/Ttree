package com.yedam.smartree.prod.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.business.service.BusinessVO;
import com.yedam.smartree.prod.mapper.ProdMapper;
import com.yedam.smartree.prod.service.ProdService;
import com.yedam.smartree.prod.service.ProdVO;

@Service
public class ProdServiceImpl implements ProdService {
	@Autowired
	ProdMapper prodMapper;
	
	@Override
	public List<ProdVO> selectProdList() {
		return prodMapper.selectProdList();
	}
	
}
