package com.toy.weedy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.weedy.entity.Apps;
import com.toy.weedy.repository.MainRepository;

@RestController
public class MainController extends WebSecurityConfigurerAdapter{

    private Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	MainRepository mainRepository;
	
	//모든 url에 대해서 스프링 시큐리트를 거치지 않는다고 선언. 나중에 필요한 부분만 걸리도록 처리할 것.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("MainConroller configure method execute");
		
        http.authorizeRequests().antMatchers("/*").permitAll().anyRequest().authenticated().and().httpBasic();
		super.configure(http);
	}
	
	@RequestMapping("/")
	public void test() throws Exception {
		logger.info("MainConroller / path execute");
	}
	
	@RequestMapping("/main")
	public @ResponseBody List<Apps> appNames() throws Exception {
		logger.info("MainConroller /main path execute");
		return mainRepository.findAll();
	}
}
