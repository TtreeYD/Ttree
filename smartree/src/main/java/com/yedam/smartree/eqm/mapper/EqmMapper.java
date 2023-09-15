package com.yedam.smartree.eqm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.eqm.service.EqmVO;

@Mapper
public interface EqmMapper {
	public List<EqmVO> selectEqmList();
	public List<EqmVO> selectEqmUcheckList(String eqmUcheck);
	public List<EqmVO> searchEqm(String eqmName);
	public int insertEqm(EqmVO eqmVO);
}
