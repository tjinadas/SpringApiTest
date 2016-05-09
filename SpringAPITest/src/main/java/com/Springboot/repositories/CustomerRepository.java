package com.Springboot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Springboot.domain.Customer;

@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long>  {
	
	   @Query("SELECT a FROM Customer a WHERE id=(?)")
	    Customer findByCustomerID(String id);

}
