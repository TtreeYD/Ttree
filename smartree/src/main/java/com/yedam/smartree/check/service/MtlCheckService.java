package com.yedam.smartree.check.service;

import java.util.List;

public interface MtlCheckService {

	public List<MtlCheckVO> selectAll();
	public List<MtlCheckVO> selectMtl(MtlCheckVO vo);
	public List<MtlCheckVO> getMtl(MtlCheckVO vo);
	public int insertChkMtl(MtlCheckVO vo);
	public List<MtlCheckVO> searchMtl(String mtlName);
	public List<MtlCheckVO> searchMtlDate(String mtlDate);
	public List<MtlCheckVO> selectChkAll();
}
