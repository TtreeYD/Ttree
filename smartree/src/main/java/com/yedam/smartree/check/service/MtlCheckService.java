package com.yedam.smartree.check.service;

import java.util.List;

public interface MtlCheckService {

	public List<MtlCheckVO> Allselect();
	public List<MtlCheckVO> mtlselect(MtlCheckVO vo);
}
