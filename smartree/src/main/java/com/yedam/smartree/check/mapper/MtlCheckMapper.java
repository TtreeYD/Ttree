package com.yedam.smartree.check.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.check.service.MtlCheckVO;
@Mapper
public interface MtlCheckMapper {

	public List<MtlCheckVO> selectAll();
	public List<MtlCheckVO> selectMtl(MtlCheckVO vo);
	public List<MtlCheckVO> getMtl(MtlCheckVO vo);
	public int insertChkMtl(MtlCheckVO vo);
}
