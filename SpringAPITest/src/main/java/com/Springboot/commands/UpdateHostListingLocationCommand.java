package com.Springboot.commands;

import java.util.Date;

public class UpdateHostListingLocationCommand {
	
	public String getStreetNumberandAddress() {
		return streetNumberandAddress;
	}
	public void setStreetNumberandAddress(String streetNumberandAddress) {
		this.streetNumberandAddress = streetNumberandAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}
	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	private String hostID;
	public String getHostID() {
		return hostID;
	}
	public void setHostID(String hostID) {
		this.hostID = hostID;
	}

	private String streetNumberandAddress;	
	private String city;
	private String province;	
	private String country;	
	private boolean defaultAddress;	
	private Date modifiedTimestamp;
	private String postalCode;
	

}
