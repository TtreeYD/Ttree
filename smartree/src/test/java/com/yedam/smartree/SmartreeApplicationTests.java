package com.yedam.smartree;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartreeApplicationTests {
	@Autowired
	StringEncryptor jasyptStringEncryptor;
	@Test
	void contextLoads() {
		String[] datas = {
				"oracle.jdbc.OracleDriver"
				,"jdbc:oracle:thin:@43.201.167.53/xe"
				,"ttree"
				,"ttree"
		};
		for(String data : datas) {
			String enyData = jasyptStringEncryptor.encrypt(data);
			System.out.println(enyData);
		}
	}

}
