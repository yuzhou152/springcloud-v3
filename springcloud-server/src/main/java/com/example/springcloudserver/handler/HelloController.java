package com.example.springcloudserver.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloudserviceapi.feignservice.HelloService;

@RestController
public class HelloController implements HelloService{

	@Autowired
	private DiscoveryClient client;
	
	@Override
	public String indexGet() {
		return "Hello World Get";
	}

	@Override
	public String indexPost(@RequestBody String data) {
		return "Hello World Post, data : " + data;
	}

	@Override
	public String indexHeader(@RequestHeader("data") String data) {
		return "Hello World Header, data : " + data;
	}

}
