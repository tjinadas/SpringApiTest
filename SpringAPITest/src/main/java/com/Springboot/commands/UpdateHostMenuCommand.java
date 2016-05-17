package com.Springboot.commands;

import java.util.Date;

public class UpdateHostMenuCommand {
	

	public String getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
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
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	private String menuDescription;
	private Date modifiedDate; 
	private String locationID;
	private String menuStatus;
	private String menuTitle;


}
