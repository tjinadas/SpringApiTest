package com.Springboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.domain.ProviderMenu;



public interface ProviderMenuRepository extends CrudRepository<ProviderMenu, Long> {
	
	ProviderMenu findBymenuID (String menuID);
	
	List<ProviderMenu> findAll();


}
