package com.Springboot.commands;

import java.util.Date;

public class UpdateProviderMenuCommand {
	
	private String menuStatus;
	private String menuTitle;
	private String providerID;
	public String getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	public String getMenuTitle() {
		return menuTitle;
	}
	public String getProviderID() {
		return providerID;
	}
	public void setProviderID(String providerID) {
		this.providerID = providerID;
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
	public Date getMenustartTime() {
		return menustartTime;
	}
	public void setMenustartTime(Date menustartTime) {
		this.menustartTime = menustartTime;
	}
	public Date getMenuendTime() {
		return menuendTime;
	}
	public void setMenuendTime(Date menuendTime) {
		this.menuendTime = menuendTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isSitIn() {
		return sitIn;
	}
	public void setSitIn(boolean sitIn) {
		this.sitIn = sitIn;
	}
	public int getMaxguestSize() {
		return maxguestSize;
	}
	public void setMaxguestSize(int maxguestSize) {
		this.maxguestSize = maxguestSize;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	private String menuDescription;
	private Date menustartTime;
	private Date menuendTime;
	private double price;
	private boolean sitIn; 
	private int maxguestSize;
	private Date modifiedDate; 

}
