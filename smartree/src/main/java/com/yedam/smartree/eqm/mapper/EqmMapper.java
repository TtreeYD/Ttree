package com.yedam.smartree.eqm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.eqm.service.EqmVO;

@Mapper
public interface EqmMapper {
	public List<EqmVO> selectEqmList();
}
