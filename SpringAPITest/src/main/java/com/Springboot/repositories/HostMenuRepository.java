package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.HostMenu;



public interface HostMenuRepository extends CrudRepository<HostMenu, Long> {
	
	HostMenu findBymenuID (String menuID);
	
	List<HostMenu> findAll();


}
