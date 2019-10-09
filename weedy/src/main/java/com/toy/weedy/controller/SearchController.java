package com.toy.weedy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.weedy.entity.Apps;
import com.toy.weedy.repository.SearchRepository;

@RestController
public class SearchController {

	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	SearchRepository searchRepository;
	
	/*@RequestMapping("/searchList/{id}")
	public void searchList(@PathVariable("id") int id) {
		logger.info("SearchController /searchList path execute");
		logger.info("id: "+id);
		searchRepository.getOne(id);
	}*/
	
	@RequestMapping("/searchList")
	public void searchList() {
		logger.info("SearchController /searchList path execute");
	}
	
	@RequestMapping("/searchList/{id}")
	public Apps searchList(@PathVariable int id) {
		logger.info("SearchController /searchList/{id} path execute");
		logger.info("id: "+id);
		return searchRepository.getOne(id);
	}
}
