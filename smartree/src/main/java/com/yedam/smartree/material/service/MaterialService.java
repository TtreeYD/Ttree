package com.yedam.smartree.material.service;

import java.util.List;

public interface MaterialService {
	public List<MaterialVO> selectNeedList();
	public List<MaterialVO> selectMtlList();
	public List<MaterialVO> selectMtlOutList();
}
