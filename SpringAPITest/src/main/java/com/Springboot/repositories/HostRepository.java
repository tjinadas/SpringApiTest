package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.Host;

public interface HostRepository extends CrudRepository<Host, String> {
	
	   Host findByEmail (String email);
	   Host findById (String id);
	   List<Host> findAll();

}
