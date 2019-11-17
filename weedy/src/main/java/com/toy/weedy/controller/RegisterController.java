package com.toy.weedy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toy.weedy.entity.Apps;
import com.toy.weedy.repository.RegisterRepository;

@RestController
public class RegisterController {

	private Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	RegisterRepository registerRepository;
	
	@RequestMapping(value="/postRegisterUser", method=RequestMethod.POST)
	public void postRegisterUser(@RequestBody Apps app) throws Exception {
		logger.info("postRegisterUser IN..");
		registerRepository.save(app);
	}
}
