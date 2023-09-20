package com.yedam.smartree.eqm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.eqm.service.EqmInspVO;

@Mapper
public interface EqmInspMapper {
	public List<EqmInspVO> selectEqmInspList();
	public List<EqmInspVO> selectEqmInspInspJudgList(String inspJudg);
	public List<EqmInspVO> searchEqmInsp(String eqmName);
	public int insertEqmInsp(EqmInspVO eqmInspVO);
}
