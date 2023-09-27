package com.yedam.smartree.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.yedam.smartree.mdm.service.EmpVO;

import lombok.Data;

public class CustomUser extends User{
	
	private EmpVO empvo;
	
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomUser(EmpVO empvo) {
		super(empvo.getEmpId(),empvo.getEmpPw(),empvo.getAuthList().stream()
										.map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList()));
		this.empvo = empvo;
	}

	public EmpVO getEmpvo() {
		return empvo;
	}

	public void setEmpvo(EmpVO empvo) {
		this.empvo = empvo;
	}
    
	
	
}
