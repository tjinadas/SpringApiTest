package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.commands.AccountLoginCommand;
import com.Springboot.commands.UpdateAccountCommand;
import com.Springboot.domain.Customer;
import com.Springboot.domain.Customer.AccountStatus;
import com.Springboot.repositories.CustomerRepository;
import com.Springboot.utilities.RandomPasswordGenerator;

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
		
		if(exsistingCustomer != null){
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "Email account already exsists, Please sign in");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
         //String randomPassword = new RandomPasswordGenerator(8).nextString();
				
	
		Date dateCreated = new Date();
        String formattedDate = new SimpleDateFormat("yyyy/MM/dd").format(dateCreated);
        String formattedTime = new SimpleDateFormat("HH:mm").format(dateCreated);
		
        customer.setFirstName(command.getFirstName());
        customer.setLastName(command.getLastName());
        customer.setEmail(command.getEmail());
        customer.setPassword(encoder.encode(command.getPassword()));
		customer.setAccountCreationTimestamp(dateCreated);
		customer.setModifiedTimestamp(dateCreated);
		customer.setAccountStatus(AccountStatus.Approval_In_Progress);

		customerRepository.save(customer);

		HashMap<String, String> Successmessage = new HashMap<String, String>();
		Successmessage.put("message", "Account created!, Please check your email for the confirmation email");
		return new ResponseEntity(Successmessage, HttpStatus.OK);
		
	}
	
	//Login API Call 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity userlogin( @RequestBody AccountLoginCommand command) throws Exception{

		Customer exsistingCustomer = customerRepository.findByEmail(command.getUserName());
		
		if(exsistingCustomer == null){
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "Wrong email or password");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		else{
			String password = exsistingCustomer.getPassword();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			if(encoder.matches(command.getPassword(), password)){
				HashMap<String, String> success = new HashMap<String, String>();
	            success.put("message", "user authenticated");
	            return new ResponseEntity(success, HttpStatus.OK);
			}
			else{
				HashMap<String, String> error = new HashMap<String, String>();
	            error.put("message", "Wrong email or password");
	            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
				
			}
		}
	}
}
