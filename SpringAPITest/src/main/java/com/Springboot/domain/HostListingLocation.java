package com.Springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;

@Entity
public class HostListingLocation {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	
	private String hostID;
		
	private String streetNumberandAddress;
	
	private String city;
	
	private String province;
	
	private String country;
	
	private String postalCode;
	
	private boolean defaultAddress;
	
	private Date creationTimestamp;
	
	private Date modifiedTimestamp;
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHostID() {
		return hostID;
	}

	public void setHostID(String hostID) {
		this.hostID = hostID;
	}

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

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}


	
	
}
