package com.yedam.smartree.check.service;

import java.util.List;

public interface MtlCheckService {

	public List<MtlCheckVO> selectAll();
	public List<MtlCheckVO> selectMtl(MtlCheckVO vo);
	public int insertChkMtl(MtlCheckVO vo);
}