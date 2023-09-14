package com.yedam.smartree;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.smartree.**.mapper")
public class SmartreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartreeApplication.class, args);
	}

}
