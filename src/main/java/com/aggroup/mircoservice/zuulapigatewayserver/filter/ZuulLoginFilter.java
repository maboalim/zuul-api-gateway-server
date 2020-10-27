package com.aggroup.mircoservice.zuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * This class is the zuul login filter for the microservice test project
 * 
 * @author Mina
 *
 */
@Component
public class ZuulLoginFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * This method used to determine which cases the filter should be applied
	 */
	@Override
	public boolean shouldFilter() {

		return true;
	}

	/**
	 * Filter business
	 */
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} uri -> {}", request, request.getRequestURI());
		return null;
	}

	/**
	 * When we should apply the filter (before the request, after it, filter only
	 * error request [pre, post, error])
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
