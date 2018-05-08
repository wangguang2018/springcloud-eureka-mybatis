package com.wgs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = {"com.wgs.mapper"})
public class EurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}
}
