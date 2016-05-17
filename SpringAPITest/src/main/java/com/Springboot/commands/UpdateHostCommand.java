package com.Springboot.commands;

import java.util.Date;



public class UpdateHostCommand {
	
	private String id;
    private String FirstName;
    private String LastName;  
    private String email;    
    private String streetNumberandAddress;	
    private String city;
	private String province;	
	private String country;	
        
    private double totalRating;	    
	private int ratingCount;	    
    public enum AccountStatus{Active, Terminated, Suspended,Approval_In_Progress};		
	private AccountStatus AccountStatus;	    
	public enum AccountType{Pro, HomeChef};		
	private AccountType AccountType;	    
    private String Password;	    
    private String mobilenumber;
    private Date modifiedTimestamp;
    private String language;
    private String postalCode;
	
	 	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
		public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
		public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public double getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(double totalRating) {
		this.totalRating = totalRating;
	}
	public int getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
	public AccountStatus getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		AccountStatus = accountStatus;
	}

	public AccountType getAccountType() {
		return AccountType;
	}
	public void setAccountType(AccountType accountType) {
		AccountType = accountType;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

		public Date getModifiedTimestamp() {
			return modifiedTimestamp;
		}
		public void setModifiedTimestamp(Date modifiedTimestamp) {
			this.modifiedTimestamp = modifiedTimestamp;
		}
		

}
