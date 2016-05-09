package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Springboot.repositories.CustomerRepository;


import org.apache.log4j.Logger;




@Controller
public class CommandController {
	
	Logger logger = Logger.getLogger(CommandController.class);
	
	@Autowired
	CustomerRepository customerRepository;

	
	@RequestMapping("/hello")
	public @ResponseBody String greeting(){
		logger.info("hello api is called");
		return "Hello";
	}
	
	@RequestMapping("/accountcreation")
	public @ResponseBody String accountcreation(){
		logger.info("accountcreation api is called");
		return "Account created";
	}

}
