package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.HostListingLocation;

public interface HostListingLocationRepository extends CrudRepository<HostListingLocation, String> {
	

	 HostListingLocation findById (String id);
	 HostListingLocation findByhostID (String hostID);
	   List<HostListingLocation> findAll();

}
