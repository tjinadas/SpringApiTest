package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.commands.UpdateAccountCommand;
import com.Springboot.domain.Customer;
import com.Springboot.repositories.CustomerRepository;


import org.apache.log4j.Logger;




@RestController
@RequestMapping("api/")
public class CommandController {
	
	Logger logger = Logger.getLogger(CommandController.class);
	
	@Value("${environment}")
	private String environment;
	
	@Autowired
	CustomerRepository customerRepository;

	
	@RequestMapping("/hello")
	public @ResponseBody String greeting(){
		logger.info("hello api is called");
		return "Hello";
	}
	
	@RequestMapping(value = "/accountcreation", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String accountcreation( @RequestBody UpdateAccountCommand command){
		logger.info("accountcreation api is called");
		String userId =  command.getId();
		//command.setId(userId);
		Customer customer = customerRepository.findByCustomerID(userId);
		customer.setFirstName(command.getFirstName());
		customer.setLastName(command.getLastName());
		customer.setAccountStatus(command.getAccountStatus());
		customer.setEmailAddress(command.getEmailAddress());
		customerRepository.save(customer);

		return "Account succesfully created";
	}

}
