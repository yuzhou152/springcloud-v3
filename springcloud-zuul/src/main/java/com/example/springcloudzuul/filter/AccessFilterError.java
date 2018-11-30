package com.example.springcloudzuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilterError extends ZuulFilter{
	
	private static Logger logger = LoggerFactory.getLogger(AccessFilterError.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		Throwable throwable = ctx.getThrowable();
		ctx.set("error.status_code", ctx.getResponse().getStatus());
		ctx.set("error.exception", throwable.getCause());
		logger.info("user logined in and error");
		return new Object();
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * pre:请求前
	 * routing:请求时
	 * post:在所有调用（包括error）结束时
	 * error:发生错误时
	 */
	@Override
	public String filterType() {
		return "error";
	}

}
