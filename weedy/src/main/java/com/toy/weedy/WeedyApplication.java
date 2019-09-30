package com.toy.weedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan //@WebFilter annotation read
public class WeedyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeedyApplication.class, args);
	}
}
