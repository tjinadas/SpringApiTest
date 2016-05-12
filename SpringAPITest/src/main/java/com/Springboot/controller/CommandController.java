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
import com.Springboot.commands.UpdateProviderCommand;
import com.Springboot.commands.UpdateProviderMenuCommand;
import com.Springboot.domain.Customer;
import com.Springboot.domain.Customer.AccountStatus;
import com.Springboot.domain.Provider;
import com.Springboot.domain.Provider.AccountType;
import com.Springboot.domain.Provider.ProviderStatus;
import com.Springboot.domain.ProviderMenu;
import com.Springboot.repositories.CustomerRepository;
import com.Springboot.repositories.ProviderMenuRepository;
import com.Springboot.repositories.ProviderRepository;
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
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	ProviderMenuRepository providermenuRepository;
	

	
	@RequestMapping("/hello")
	public @ResponseBody String greeting(){
		logger.info("hello api is called");
		return "Hello";
	}
	
	// Registering a customer
	
	@RequestMapping(value = "/accountcreationCustomer", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity accountcreationCustomer( @RequestBody UpdateAccountCommand command) throws Exception{
		logger.info("accountcreation api is called");

	    Customer customer = new Customer();
	            
		Customer exsistingCustomer = customerRepository.findByEmail(command.getEmail());
		
		if(exsistingCustomer != null){
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "Email account already exsists, Please sign in");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
		Date dateCreated = new Date();
		
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
	
	// Registering a Provider
	
	@RequestMapping(value = "/accountcreationProvider", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity accountcreationProvider( @RequestBody UpdateProviderCommand command) throws Exception{
		logger.info("accountcreation api is called");

	    Provider provider = new Provider();
	            
	    Provider exsistingProvider = providerRepository.findByEmail(command.getEmail());
		
		if(exsistingProvider != null){
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "Email account already exsists, Please sign in");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			
	
		Date dateCreated = new Date();

		
        provider.setFirstName(command.getFirstName());
        provider.setLastName(command.getLastName());
        provider.setEmail(command.getEmail());
        provider.setPassword(encoder.encode(command.getPassword()));
        provider.setAccountCreationTimestamp(dateCreated);
        provider.setModifiedTimestamp(dateCreated);
        provider.setProviderStatus(ProviderStatus.Approval_In_Progress);
        provider.setAddressLine1(command.getAddressLine1());
        provider.setAddressLine2(command.getAddressLine2());
        
        //provider.setAccountType(command.getAccountType());

        providerRepository.save(provider);

		HashMap<String, String> Successmessage = new HashMap<String, String>();
		Successmessage.put("message", "Account created!, Please check your email for the confirmation email");
		return new ResponseEntity(Successmessage, HttpStatus.OK);
		
	}
	
	//Customer Login
	
	@RequestMapping(value = "/customerlogin", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity customerlogin( @RequestBody AccountLoginCommand command) throws Exception{

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
	
	//Provider Login
	
	@RequestMapping(value = "/providerlogin", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity providerlogin( @RequestBody AccountLoginCommand command) throws Exception{

		Provider exsistingProvider = providerRepository.findByEmail(command.getUserName());
		
		if(exsistingProvider == null){
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "Wrong email or password");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		else{
			String password = exsistingProvider.getPassword();
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
	
	
	// Add menu API 
	
	@RequestMapping(value = "/addmenu", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity addmenu( @RequestBody UpdateProviderMenuCommand command) throws Exception{
		
		Provider exsistingProvider = providerRepository.findById(command.getProviderID());
		
	
		
		ProviderMenu providerMenu = new ProviderMenu();
		  
		
		if(exsistingProvider == null){
			HashMap<String, String> error = new HashMap<String, String>();
            error.put("message", "user ID doesn't exsist");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		}
		
		else{
			
			providerMenu.setProviderID(exsistingProvider.getId());
			providerMenu.setMenuTitle(command.getMenuTitle());
			providermenuRepository.save(providerMenu);
			
		}

		HashMap<String, String> success = new HashMap<String, String>();
        success.put("message", "user menu submitted");
        return new ResponseEntity(success, HttpStatus.OK);
	}
	
	
	
	
}
