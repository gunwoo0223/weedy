package com.toy.weedy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//모든 요청에 대해 필터링 검사를 진행하겠다.
@WebFilter(urlPatterns = "/*", description = "CORS 필터")
public class CorsFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(CorsFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("CoreFilter init 메서드 실행");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.info("CORS doFilter 들어옴.");
		logger.debug("들어오나?");
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		//post, get, options, delete, put 요청에 대한 하용
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		//한번 요청했으면 1시간(3600) 동안 캐시되어 재요청x
		res.setHeader("Access-Control-Max-Age", "3600");
		//ajax로 들어온 요청에 대한 허용
		res.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		//모든 도메인에 대해 허용 어떤 웹사이트라도 이 서버에 접근 가능. 보안을 적용하려먼 특정 도메인만 허용되도록 설정할 것.
		res.setHeader("Access-Control-Allow-Origin", "*");
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		logger.info("CoreFilter destroy 메서드 실행");
		Filter.super.destroy();
	}
}
