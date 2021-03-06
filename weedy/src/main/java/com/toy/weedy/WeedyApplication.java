package com.toy.weedy;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.toy.weedy.controller.SearchController;

@SpringBootApplication
@CrossOrigin(origins= {"http://localhost:7070", "http://localhost:8080"})
@ServletComponentScan //@WebFilter annotation 읽을 수 있도록 하는 어노테이션.
public class WeedyApplication extends WebSecurityConfigurerAdapter implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WeedyApplication.class, args);
	}
	
	//모든 url에 대해서 스프링 시큐리트를 거치지 않는다고 선언. 나중에 필요한 부분만 걸리도록 처리할 것.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("WeedyApplication configure method execute");
		
		//http.authorizeRequests().antMatchers("/", "/main", "/searchList", "/searchList/*").permitAll().anyRequest().authenticated().and().httpBasic();
		//http.authorizeRequests().antMatchers("/*").permitAll().anyRequest().authenticated().and().httpBasic();
		
		//csrf는 post기능 쓸때 에러나서 임시로 disable로 막아둔 건데, 추후 다른 보안막는 방법으로 처리해야함.
		http.authorizeRequests().antMatchers("/*", "/*/*").permitAll().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
		super.configure(http);
	}
		
	//CommandLineRunner을 통해 빈 생성시 즉시 실행될 수 있는 메서드로, DB접속정보 암호화/복호화 테스트용. 나중에는 지워야 함.
	@Override
	public void run(String... args) throws Exception {
	}
}
