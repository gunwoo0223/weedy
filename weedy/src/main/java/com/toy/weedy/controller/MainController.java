package com.toy.weedy.controller;

import java.util.List;

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

	@Autowired
	MainRepository mainRepository;
	
	//'/'�� ���� url�� ���ؼ��� Security ����x.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().httpBasic();
		super.configure(http);
	}
	
	@RequestMapping("/")
	public @ResponseBody List<Apps> appNames() throws Exception {
		return mainRepository.findAll();
	}
}
