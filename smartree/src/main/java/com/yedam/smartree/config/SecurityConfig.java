package com.yedam.smartree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			      .authorizeHttpRequests((requests) -> requests	
				//.antMatchers("/", "/login/**","/common/**","/font/**","/startbootstrap/**").permitAll()
				//.anyRequest().authenticated()
					.anyRequest().permitAll()
			)
			.formLogin((form) -> form
				.loginPage("/")
				.loginProcessingUrl("/login")
				.successHandler(customLoginSuccessHandler())
				.permitAll()
			)
			.logout((logout) -> logout.permitAll())
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

