package com.shiqi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiqi.mapper")
public class SpringbootRabbitmqProducterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqProducterApplication.class, args);
	}
}
