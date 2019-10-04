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

//필터로 Cors 에러 처리
@WebFilter(urlPatterns = "/*", description = "CORS")
public class CorsFilter implements Filter{

    private Logger logger = LoggerFactory.getLogger(CorsFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	logger.info("Cors Filter init method execute");
        Filter.super.init(filterConfig);
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	logger.info("Cors Filter doFilter method execute");
    	
        HttpServletResponse res = (HttpServletResponse) response;
        
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        res.setHeader("Access-Control-Allow-Origin", "*");
        
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
    	logger.info("Cors Filter destroy method execute");
    	
        Filter.super.destroy();
    }
}
