package com.yedam.smartree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@SpringBootApplication()
@MapperScan(basePackages = "com.yedam.smartree.**.mapper")
public class SmartreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartreeApplication.class, args);
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
