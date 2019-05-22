package com.tnpy.common.config.cors;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName = "CorsFilter ")
public class CorsFilter implements Filter {
@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	HttpServletResponse response = (HttpServletResponse) res;
	
	HttpServletRequest reqs = (HttpServletRequest) req;
	//System.out.println("拦截器设置Filter！");
	// response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Origin","*");
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "Token, Origin, X-Requested-With, Content-Type, Accept");
	chain.doFilter(req, res);
}

@Override
public void init(FilterConfig filterConfig) {}

@Override
public void destroy() {}

}