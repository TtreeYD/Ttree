package com.yedam.smartree.check.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.check.service.MtlCheckVO;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.mode_return;

public interface MtlCheckMapper {

	public List<MtlCheckVO> selectMtl(MtlCheckVO vo);
	public List<MtlCheckVO> getMtl(MtlCheckVO vo);
	public int insertChkMtl(MtlCheckVO vo);
	public List<MtlCheckVO> searchMtl(String mtlName);
	public List<MtlCheckVO> searchMtlDate(String mtlDate);
	public List<MtlCheckVO> selectChkAll();
	public int updateChkMtl(MtlCheckVO vo);
	public List<MtlCheckVO> chkAll();
}
