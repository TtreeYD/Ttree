package com.yedam.smartree.eqm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.eqm.service.EqmInspVO;
import com.yedam.smartree.eqm.service.EqmNoperVO;


@Mapper
public interface EqmInspMapper {
	// 설비점검
	public List<EqmInspVO> selectEqmInspList();
	public List<EqmInspVO> selectEqmInspInspJudgList(String inspJudg);
	public List<EqmInspVO> searchEqmInsp(EqmInspVO eqmInspVO);
	public int insertEqmInsp(EqmInspVO eqmInspVO);
	public EqmInspVO selectEqmInsp(EqmInspVO eqmInspVO);	
	
	// 비가동
	public int insertEqmNoper(EqmNoperVO eqmNoperVO);
	public List<EqmNoperVO> selectEqmNoper();
	public List<EqmNoperVO> searchEqmNoper(String eqmName);
	public EqmNoperVO selectEqmNoperCode(EqmNoperVO eqmNoperVO);
	public int updateEqmNoper(EqmNoperVO eqmNoperVO);
	
}
