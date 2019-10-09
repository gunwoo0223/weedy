package com.toy.weedy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.weedy.entity.Apps;
import com.toy.weedy.repository.MainRepository;

@RestController
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	MainRepository mainRepository;
	
	@RequestMapping("/")
	public void test() throws Exception {
		logger.info("MainConroller / path execute");
	}
	
	@RequestMapping("/main")
	public List<Apps> appNames() throws Exception {
		logger.info("MainConroller /main path execute");
		return mainRepository.findAll();
	}
}
