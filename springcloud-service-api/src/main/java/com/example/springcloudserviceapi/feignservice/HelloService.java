package com.example.springcloudserviceapi.feignservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("refactor-feign")
public interface HelloService {
	
	@RequestMapping(value = "/hello-get", method = RequestMethod.GET)
	public String indexGet();

	@RequestMapping(value = "/hello-post", method = RequestMethod.POST)
	public String indexPost(@RequestBody String data);

	@RequestMapping(value = "/hello-header", method = RequestMethod.GET)
	public String indexHeader(@RequestHeader("data") String data);
	
}
