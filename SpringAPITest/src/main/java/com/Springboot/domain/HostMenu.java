 package com.Springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class HostMenu {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String menuID;
	
	
	
	public String getMenuID() {
		return menuID;
	}

	public void setMenuID(String menuID) {
		this.menuID = menuID;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public String getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}

	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	

	private String menuStatus;
	
	private String menuDescription;
	
	private Date modifiedDate; 
	
	private String menuTitle;
	
	private String locationID;
	
	
}
