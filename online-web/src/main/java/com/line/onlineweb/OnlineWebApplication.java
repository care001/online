package com.line.onlineweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.line.onlineweb.dao.mapper")
@SpringBootApplication
public class OnlineWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineWebApplication.class, args);
	}
}
