package com.line.onlineweb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@MapperScan("com.line.onlineweb.dao.mapper")
@SpringBootApplication
@ImportResource(locations = {"classpath:weixin-bean.xml"})
public class OnlineWebApplication {



	public static void main(String[] args) {
		SpringApplication.run(OnlineWebApplication.class, args);
	}
}
