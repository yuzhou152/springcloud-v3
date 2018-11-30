package com.example.springcloudclientfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

@EnableDiscoveryClient	//让该应用注册为Eureka客户端的应用，以获得服务发现的能力
@SpringBootApplication
@EnableFeignClients		//打开feign
public class SpringcloudClientFeignApplication {

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.NONE;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudClientFeignApplication.class, args);
	}
}
