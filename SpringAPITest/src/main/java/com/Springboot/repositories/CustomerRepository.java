package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Springboot.domain.Customer;




public interface CustomerRepository extends CrudRepository<Customer, Long>  {
	
	   Customer findByEmail (String email);
	   Customer findById (String id);
	   List<Customer> findAll();


}
