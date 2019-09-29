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

//��� ��û�� ���� ���͸� �˻縦 �����ϰڴ�.
@WebFilter(urlPatterns = "/*", description = "CORS ����")
public class CorsFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(CorsFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("CoreFilter init �޼��� ����");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.info("CORS doFilter ����.");
		logger.debug("������?");
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		//post, get, options, delete, put ��û�� ���� �Ͽ�
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		//�ѹ� ��û������ 1�ð�(3600) ���� ĳ�õǾ� ���ûx
		res.setHeader("Access-Control-Max-Age", "3600");
		//ajax�� ���� ��û�� ���� ���
		res.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		//��� �����ο� ���� ��� � ������Ʈ�� �� ������ ���� ����. ������ �����Ϸ��� Ư�� �����θ� ���ǵ��� ������ ��.
		res.setHeader("Access-Control-Allow-Origin", "*");
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		logger.info("CoreFilter destroy �޼��� ����");
		Filter.super.destroy();
	}
}
