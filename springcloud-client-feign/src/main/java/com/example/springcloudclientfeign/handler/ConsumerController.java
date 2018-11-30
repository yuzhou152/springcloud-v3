package com.example.springcloudclientfeign.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloudclientfeign.service.HelloNormalService;
import com.example.springcloudclientfeign.service.RefactorHelloService;


@RestController
public class ConsumerController {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private RefactorHelloService refactorHelloService;

	@Autowired
	private HelloNormalService helloNormalService;
	
	@RequestMapping(value = "/hello-get", method = RequestMethod.GET)
	public String indexGet() {
		String get = refactorHelloService.indexGet();
		String header = refactorHelloService.indexHeader("header data");
		String post = refactorHelloService.indexPost("post data");
		System.out.println(get);
		System.out.println(header);
		System.out.println(post);
		return "success";
	}
	
	@RequestMapping(value = "/hello-normal-get", method = RequestMethod.GET)
	public String indexNormalGet() {
		logger.info("======call trace-1=======");
		String get = helloNormalService.indexGet();
		String header = helloNormalService.indexHeader("header data");
		String post = helloNormalService.indexPost("post data");
		System.out.println(get);
		System.out.println(header);
		System.out.println(post);
		return "success";
	}
}
