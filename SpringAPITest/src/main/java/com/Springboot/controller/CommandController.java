package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.commands.UpdateAccountCommand;
import com.Springboot.domain.Customer;
import com.Springboot.domain.Customer.AccountStatus;
import com.Springboot.repositories.CustomerRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
	public @ResponseBody ResponseEntity accountcreation( @RequestBody UpdateAccountCommand command) throws Exception{
		logger.info("accountcreation api is called");
		

		
		
	    Customer customer = new Customer();
	    
	    
	        
		Customer exsistingCustomer = customerRepository.findByEmail(command.getEmail());
		
		
		logger.info("I am here");
		if(exsistingCustomer != null){
			logger.info("duplicate account");
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "Email account already exsists, Please sign in");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
			 //throw new Exception("User Progress cannot be found! Consents cannot be processed!");
		}
				
	

		Date dateCreated = new Date();
        String formattedDate = new SimpleDateFormat("yyyy/MM/dd").format(dateCreated);
        String formattedTime = new SimpleDateFormat("HH:mm").format(dateCreated);
		
		//Customer customer = new Customer(command.getFirstName(), command.getLastName(),command.getEmail());
        customer.setFirstName(command.getFirstName());
        customer.setLastName(command.getLastName());
        customer.setEmail(command.getEmail());
		customer.setAccountCreationTimestamp(dateCreated);
		customer.setModifiedTimestamp(dateCreated);
		customer.setAccountStatus(AccountStatus.Approval_In_Progress);
		

		customerRepository.save(customer);

		HashMap<String, String> Successmessage = new HashMap<String, String>();
		Successmessage.put("message", "Account created!, Please check your email for the confirmation email");
		return new ResponseEntity(Successmessage, HttpStatus.BAD_REQUEST);
		
	}
	

}
