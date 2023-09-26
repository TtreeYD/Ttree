package com.yedam.smartree.mdm.service;

import java.util.List;

import lombok.Data;

@Data
public class MdmReqVO<T> {
	T vo;
	List<T> inList;
	List<T> upList;
	List<T> delList;
}
