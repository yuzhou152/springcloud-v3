package com.example.springcloudzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilterPre extends ZuulFilter{
	
	private static Logger logger = LoggerFactory.getLogger(AccessFilterPre.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		
		Object accessToken = request.getParameter("token");
		if (accessToken != null) {
			logger.warn("access token != null");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		logger.info("user logined in");
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
		return "pre";
	}

}
