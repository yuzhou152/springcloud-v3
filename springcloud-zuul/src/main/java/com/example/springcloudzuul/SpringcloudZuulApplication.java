package com.example.springcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;


@EnableZuulServer
@EnableZuulProxy
@SpringCloudApplication
public class SpringcloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZuulApplication.class, args);
	}
	
}
