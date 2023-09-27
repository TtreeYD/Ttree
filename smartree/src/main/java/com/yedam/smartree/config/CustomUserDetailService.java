package com.yedam.smartree.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.smartree.mdm.mapper.MdmMapper;
import com.yedam.smartree.mdm.service.EmpVO;


public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	MdmMapper mdmmapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmpVO vo = mdmmapper.selectEmp(username);
		return vo == null ? null : new CustomUser(vo);
	}
	
	
}
