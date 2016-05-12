package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
	
	   Provider findByEmail (String email);
	   Provider findById (String id);
	   List<Provider> findAll();

}
