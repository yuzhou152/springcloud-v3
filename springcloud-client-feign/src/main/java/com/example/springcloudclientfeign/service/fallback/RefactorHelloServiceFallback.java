package com.example.springcloudclientfeign.service.fallback;

import org.springframework.stereotype.Component;

import com.example.springcloudclientfeign.service.HelloNormalService;
@Component
public class RefactorHelloServiceFallback implements HelloNormalService{

	@Override
	public String indexGet() {
		return "error";
	}

	@Override
	public String indexPost(String data) {
		return "error";
	}

	@Override
	public String indexHeader(String data) {
		return "error";
	}
}
