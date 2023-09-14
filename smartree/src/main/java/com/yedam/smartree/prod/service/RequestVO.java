package com.yedam.smartree.prod.service;

import java.util.List;

import lombok.Data;
@Data
public class RequestVO<T> {
	T vo;
	List<T> list;
}
