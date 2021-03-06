package com.ad.springboot.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("filter initialized");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("do filter");
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("filter destroy");
	}
}
