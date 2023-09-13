package com.yedam.smartree.business.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.smartree.business.service.BusinessVO;

@Mapper
public interface BusinessMapper {

	public List<BusinessVO> selectOrderList();
	public List<BusinessVO> selectOrderDtList();
}
