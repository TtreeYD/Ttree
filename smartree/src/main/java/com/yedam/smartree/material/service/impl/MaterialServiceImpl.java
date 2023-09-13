package com.yedam.smartree.material.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.smartree.material.mapper.MaterialMapper;
import com.yedam.smartree.material.service.MaterialService;
import com.yedam.smartree.material.service.MaterialVO;

@Service
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialMapper materialMapper;
	
	@Override
	public List<MaterialVO> selectNeedList() {
		return materialMapper.selectNeedList();
	}

	@Override
	public List<MaterialVO> selectMtlList() {
		return materialMapper.selectMtlList();
	}

	@Override
	public List<MaterialVO> selectMtlOutList() {
		return materialMapper.selectMtlOutList();
	}

}
