package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.ProviderLocation;

public interface ProviderLocationRepository extends CrudRepository<ProviderLocation, Long> {
	

	 ProviderLocation findById (String id);
	   List<ProviderLocation> findAll();

}
