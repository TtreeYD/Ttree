package com.yedam.smartree.prod.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.prod.service.ProdVO;

@Mapper
public interface ProdMapper {
	
	public List<ProdVO> selectProdList();
}
