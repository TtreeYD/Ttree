package com.yedam.smartree.eqm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmVO;

@Mapper
public interface EqmMapper {
	// 설비
	public List<EqmVO> selectEqmList();
	public List<EqmVO> selectEqmUcheckList(String eqmUcheck);
	public List<EqmVO> searchEqm(String eqmName);
	public int insertEqm(EqmVO eqmVO);
	public EqmVO selectEqm(EqmVO eqmVO);
	public int deleteEqm(EqmVO eqmVO);
	public int updateEqm(EqmVO eqmVO);

}
