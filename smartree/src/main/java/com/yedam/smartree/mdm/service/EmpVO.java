package com.yedam.smartree.mdm.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class EmpVO {
	private String empId;
	private String empName;
	private String empDept;
	private String empClass;
	private String empPw;
	private String empPhone;
	private String newPassword;
	String empUse;
	
	private String empAuth;
	
	public List<String> getAuthList(){
		List<String> list = new ArrayList<String>();
		list.add(empAuth);
		return list;
	};
}
