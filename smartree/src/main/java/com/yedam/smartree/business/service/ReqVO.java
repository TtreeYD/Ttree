package com.yedam.smartree.business.service;

import java.util.List;

import lombok.Data;

@Data
public class ReqVO<T> {
	T vo;
	List<T> orderList;
	List<T> orderDtList;
	List<T> list;
}
