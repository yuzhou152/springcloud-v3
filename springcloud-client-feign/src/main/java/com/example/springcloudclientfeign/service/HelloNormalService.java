package com.example.springcloudclientfeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springcloudclientfeign.service.fallback.RefactorHelloServiceFallback;


/**
 * Feign
 */
@FeignClient(value = "consumerserver", fallback = RefactorHelloServiceFallback.class)
public interface HelloNormalService {
	
	@RequestMapping(value = "/normal/hello-get", method = RequestMethod.GET)
	public String indexGet();

	@RequestMapping(value = "/normal/hello-post", method = RequestMethod.POST)
	public String indexPost(@RequestBody String data);

	@RequestMapping(value = "/normal/hello-header", method = RequestMethod.GET)
	public String indexHeader(@RequestHeader("data") String data);
	
}
