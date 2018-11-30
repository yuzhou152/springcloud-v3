package com.example.springcloudserver.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "normal")
public class HelloNormalController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/hello-get", method = RequestMethod.GET)
	public String indexGet(HttpServletRequest request) {
		logger.info("======call trace-2, TraceId -> {}, SpanId -> {}=======",
				new Object[]{request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId")});
		return "Hello World Get";
	}

	@RequestMapping(value = "/hello-post", method = RequestMethod.POST)
	public String indexPost(@RequestBody String data) {
		return "Hello World Post, data : " + data;
	}

	@RequestMapping(value = "/hello-header", method = RequestMethod.GET)
	public String indexHeader(@RequestHeader("data") String data) {
		return "Hello World Header, data : " + data;
	}

}
