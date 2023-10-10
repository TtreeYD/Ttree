package com.yedam.smartree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	 private final AuthenticationFailureHandler customAuthFailureHandler;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			 .authorizeHttpRequests((requests) -> requests	
		     .antMatchers("/", "/login/**","/common/**","/font/**","/startbootstrap/**").permitAll()
		     .anyRequest().authenticated()                    // .authenticated 인증된 사용자의 접근을 허용
			 //.anyRequest().permitAll()
			)	
			.formLogin((form) -> form
				.loginPage("/")
				.loginProcessingUrl("/login")
				.successHandler(customLoginSuccessHandler())
				.permitAll()
			)
			.logout(logout -> logout
                    // 로그아웃 요청을 처리할 URL 설정
                    .logoutUrl("/logout")
                    // 로그아웃 성공 시 리다이렉트할 URL 설정
                    .logoutSuccessUrl("/")
                    // 로그아웃 성공 핸들러 추가 (리다이렉션 처리)
                    .logoutSuccessHandler((request, response, authentication) ->{
                    		request.getSession().invalidate();
                            response.sendRedirect("/");
                            })
            )
			.csrf().disable()
			.userDetailsService(userService());

		return http.build();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); 
		
	}
	
	@Bean
	public UserDetailsService userService() {
		return new CustomUserDetailService();
	}
	
	@Bean
	public AuthenticationSuccessHandler customLoginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
}

