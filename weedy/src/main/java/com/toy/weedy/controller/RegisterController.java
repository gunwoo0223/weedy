package com.toy.weedy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.weedy.entity.Boards;
import com.toy.weedy.repository.RegisterRepository;

@RestController
public class RegisterController {

	private Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegisterRepository registerRepository;
	
//	@RequestMapping("/")
//	public void test() throws Exception {
//		logger.info("RegisterController / path execute");
//	}
	
//	@RequestMapping("/registerAdmin")
//	public List<Boards> boardList() throws Exception {
//		logger.info("RegisterController /main path execute");
//		return registerRepository.findAll();
//	}
}
