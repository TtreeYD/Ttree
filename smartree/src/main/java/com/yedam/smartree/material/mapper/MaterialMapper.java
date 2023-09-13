package com.yedam.smartree.material.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.material.service.MaterialVO;

@Mapper
public interface MaterialMapper {
	public List<MaterialVO> selectNeedList();
	public List<MaterialVO> selectMtlList();
	public List<MaterialVO> selectMtlOutList();
}
