package com.example.springcloudzuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilterPost extends ZuulFilter{
	
	private static Logger logger = LoggerFactory.getLogger(AccessFilterPost.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletResponse response = ctx.getResponse();
		int status = response.getStatus();
		if (status != 200) {
//			ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			ctx.set("error.status_code", status);
		}
		logger.info("user logined in and post");
		return null;
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
		return "post";
	}

}
