package com.Springboot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.Customer;


public interface CustomerRepository extends CrudRepository<Customer, String>  {
	
	   @Query("SELECT a FROM Customer a WHERE id=(?)")
	    Customer findByCustomerID(String id);

}
