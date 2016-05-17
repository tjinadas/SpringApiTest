package com.Springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.commands.AccountLoginCommand;
import com.Springboot.commands.UpdateAccountCommand;
import com.Springboot.commands.UpdateHostCommand;
import com.Springboot.commands.UpdateHostListingLocationCommand;
import com.Springboot.commands.UpdateHostMenuCommand;
import com.Springboot.domain.Customer;
import com.Springboot.domain.Customer.AccountStatus;
import com.Springboot.domain.Host;
import com.Springboot.domain.Host.AccountType;
import com.Springboot.domain.Host.ProviderStatus;
import com.Springboot.domain.HostListingLocation;
import com.Springboot.domain.HostMenu;
import com.Springboot.repositories.CustomerRepository;
import com.Springboot.repositories.HostListingLocationRepository;
import com.Springboot.repositories.HostMenuRepository;
import com.Springboot.repositories.HostRepository;
import com.Springboot.utilities.JwtUtility;
import com.Springboot.utilities.RandomPasswordGenerator;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jose4j.json.internal.json_simple.JSONArray;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.jose4j.jws.JsonWebSignature;

@RestController
@RequestMapping("api/")
public class CommandController {
	
	Logger logger = Logger.getLogger(CommandController.class);
	
	@Value("${environment}")
	private String environment;
	
	@Value("${jwt.pk}")
    private String privateKey;
	
	@Value("${jwt.expiry}")
	private long jwtexpiary;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	HostRepository hostRepository;
	
	@Autowired
	HostListingLocationRepository hostlocationlistingRepository;
	
	@Autowired
	HostMenuRepository providermenuRepository;
	
	@Autowired
	HostListingLocationRepository providerlocationRepository;
	

	
	
	///************************************** Customer Backend APIS*************************************************///
	///*************************************************************************************************************///	
	

	// Registering a customer
	
	@RequestMapping(value = "/accountcreationCustomer", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<JSONObject> accountcreationCustomer( @RequestBody UpdateAccountCommand command) throws Exception{
		logger.info("accountcreation api is called");
		
		JSONObject jsonReponse = new JSONObject();

	    Customer customer = new Customer();
	           
		Customer exsistingCustomer = customerRepository.findByEmail(command.getEmail());
		
		if(exsistingCustomer != null){
			
			jsonReponse.put("message", "Email account already exsists, Please sign in");
			return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);

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
		
		String jwt = this.generateJwt(customer.toMap());
		
		jsonReponse.put("message", "Account created!, Please login with your account credentials");
		jsonReponse.put("jwttoken", jwt);
		
		return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);

		
	}
	
	//Customer Login
	
		@RequestMapping(value = "/customerlogin", method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody ResponseEntity<JSONObject> customerlogin( @RequestBody AccountLoginCommand command) throws Exception{

			Customer exsistingCustomer = customerRepository.findByEmail(command.getUserName());
			
			JSONObject jsonReponse = new JSONObject();
			
			if(exsistingCustomer == null){
				
				jsonReponse.put("message", "Wrong email or password");
				String jwt = "-1";
				jsonReponse.put("token", jwt);
				return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.FORBIDDEN);

			}
			
			else{
				String password = exsistingCustomer.getPassword();
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
				if(encoder.matches(command.getPassword(), password)){
					jsonReponse.put("message", "user authenticated");
					String jwt = this.generateJwt(exsistingCustomer.toMap());
					jsonReponse.put("token", jwt);
					
					return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);
				}
				else{
					String jwt = "-1";
					jsonReponse.put("message", "Wrong email or password");
					jsonReponse.put("token", jwt);
					return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.FORBIDDEN);
					
				}
			}
		}
		
		// Get all the serving locations to feed it into the in app map 
		
		@RequestMapping(value = "/getlocations", method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody ResponseEntity<JSONObject> getservinglocation ( @RequestBody UpdateHostCommand command , @RequestHeader("auth") String token) throws Exception{
					
			JSONObject jsonReponse = new JSONObject();
		    JSONArray jsonArray = new JSONArray();
			
				logger.info("Customer found");
				List <HostListingLocation> alllocations = providerlocationRepository.findAll();
				
				jsonReponse.put("Menus", alllocations);
				
				return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);

		}
		
    ///***************************** Provider Backend APIS***********************************************************///
	///*************************************************************************************************************///	
	
	// Registering a Provider
	
	@RequestMapping(value = "/accountcreationProvider", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<JSONObject> accountcreationProvider( @RequestBody UpdateHostCommand command) throws Exception{
		logger.info("accountcreation api is called");

	    Host host = new Host();
	    
	    JSONObject jsonReponse = new JSONObject();
	            
	    Host exsistingProvider = hostRepository.findByEmail(command.getEmail());
		
		if(exsistingProvider != null){
			jsonReponse.put("message", "Email account already exsists, Please sign in");
			String jwt = "-1";
			jsonReponse.put("token", jwt);
			return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.FORBIDDEN);

		}
		
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			
	
		Date dateCreated = new Date();

		
        host.setFirstName(command.getFirstName());
        host.setLastName(command.getLastName());
        host.setEmail(command.getEmail());
        host.setPassword(encoder.encode(command.getPassword()));
        host.setAccountCreationTimestamp(dateCreated);
        host.setModifiedTimestamp(dateCreated);
        host.setProviderStatus(ProviderStatus.Approval_In_Progress);
        host.setStreetNumberandAddress(command.getStreetNumberandAddress());
        host.setCity(command.getCity());
        host.setProvince(command.getProvince());
        host.setCountry(command.getCountry());
        
        hostRepository.save(host);
        
        String jwt = this.generateJwt(host.toMap());
        
        jsonReponse.put("message", "Account created!, Please check your email for the confirmation email");
		jsonReponse.put("token", jwt);
		return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);
		
	}
	
	
	
	//Provider Login
	
	@RequestMapping(value = "/providerlogin", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<JSONObject> providerlogin( @RequestBody AccountLoginCommand command) throws Exception{

		
		
		Host exsistingProvider = hostRepository.findByEmail(command.getUserName());
		
		JSONObject jsonReponse = new JSONObject();
		
		if(exsistingProvider == null){
			
			jsonReponse.put("message", "Wrong email or password");
			String jwt = "-1";
			jsonReponse.put("token", jwt);
			return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.BAD_REQUEST);

		}
		
		else{
			String password = exsistingProvider.getPassword();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
			if(encoder.matches(command.getPassword(), password)){
				
				jsonReponse.put("message", "user authenticated");
				String jwt = this.generateJwt(exsistingProvider.toMap());
				jsonReponse.put("token", jwt);
				return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);

			}
			else{
				
				String jwt = "-1";
				jsonReponse.put("message", "Wrong email or password");
				jsonReponse.put("token", jwt);
				return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.FORBIDDEN);

				
			}
		}
	}
	
	
	// Add menu API 
	
	@RequestMapping(value = "/addmenu", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<JSONObject> addmenu( @RequestBody UpdateHostMenuCommand command , @RequestHeader("auth") String token) throws Exception{
		
		Host exsistingHost =  hostRepository.findOne(JwtUtility.getUserId(token, privateKey));
		
		JSONObject jsonReponse = new JSONObject();
		
		
		HostMenu hostMenu = new HostMenu();

		Date dateCreated = new Date();
		  
		
		if(exsistingHost == null){
			
			jsonReponse.put("message", "user ID doesn't exsist");
			String jwt = "-1";
			jsonReponse.put("token", jwt);
			return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.BAD_REQUEST);

		}
		
		
		
		else{
			HostListingLocation hostlistingLocation = hostlocationlistingRepository.findByhostID(exsistingHost.getId());
			hostMenu.setLocationID(hostlistingLocation.getId());
			hostMenu.setMenuTitle(command.getMenuTitle());
			hostMenu.setMenuDescription(command.getMenuDescription());
			hostMenu.setModifiedDate(dateCreated);
			hostMenu.setMenuStatus("Inactive");
			
			providermenuRepository.save(hostMenu);
			
		}
		
		jsonReponse.put("message", "Menu added, please as review your menu items and mark it as active");
		String jwt = this.generateJwt(exsistingHost.toMap());
		jsonReponse.put("token", jwt);
		return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);

	}
	
	//// Add location 
	
	@RequestMapping(value = "/addservinglocation", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<JSONObject> addservinglocation( @RequestBody UpdateHostListingLocationCommand command , @RequestHeader("auth") String token) throws Exception{
		
		//String hostID = command.getMenuID();
		Date dateCreated = new Date();
		String providerID =   JwtUtility.getUserId(token, privateKey);
		
		Host exsistingHost =  hostRepository.findOne(providerID);
		
		JSONObject jsonReponse = new JSONObject();
		
		
		if(exsistingHost == null){
			
			jsonReponse.put("message", "unauthorized request");
			String jwt = "-1";
			jsonReponse.put("token", jwt);
			return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.BAD_REQUEST);
		}
		
			
			HostListingLocation hostListingLocation = new HostListingLocation();
			
			hostListingLocation.setHostID(exsistingHost.getId());;
			hostListingLocation.setStreetNumberandAddress(command.getStreetNumberandAddress());
			hostListingLocation.setCity(command.getCity());
			hostListingLocation.setProvince(command.getProvince());
			hostListingLocation.setCountry(command.getCountry());
			hostListingLocation.setPostalCode(command.getPostalCode());
			hostListingLocation.setCreationTimestamp(dateCreated);
			hostListingLocation.setModifiedTimestamp(dateCreated);
			
			providerlocationRepository.save(hostListingLocation);
		
			jsonReponse.put("message", "Menu serving location added!");
			String jwt = this.generateJwt(exsistingHost.toMap());
			jsonReponse.put("token", jwt);
			return new ResponseEntity<JSONObject>(jsonReponse, HttpStatus.OK);	
			
		
	}
	
	/// UpdateAccountAPI
	
	///UpdateMenuAPI
	
	///Update
	
	///Generating JWT 
	
	 private String generateJwt(Map<String, Object> json) {
		 
		 
	        logger.info("Generating JWT");
	        long nowMillis = System.currentTimeMillis();
	        Date now = new Date(nowMillis);
	        
	        
	        Map<String, Object> signature = new HashMap<>();
	        signature.put("alg", "HS256");
	        signature.put("typ", "JWT");

	        JsonWebSignature jws = new JsonWebSignature();
	        
	        // The payload of the JWS is JSON content of the JWT Claims
	        jws.setPayload(json.toString());
	        jws.setContentTypeHeaderValue("jwt");
	        
	        JwtBuilder builder = Jwts.builder().setClaims(json)
					  .setHeader(signature)
					  .signWith(SignatureAlgorithm.HS256, privateKey);
	        
	        if(jwtexpiary >=0){
	        	
	        	long expMillis = nowMillis + jwtexpiary;
	        	Date exp = new Date(expMillis);
	        	builder.setExpiration(exp);
	        }
	        
	        builder.setIssuedAt(now);

	        return builder.compact();
	 }
	

	
	}
