package com.Springboot.commands;

import java.util.Date;

import com.Springboot.domain.Customer.AccountStatus;

public class UpdateAccountCommand {
	
	private String FirstName;
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
	private String LastName;
    private String email;
	private Date modifiedTimestamp;
	private AccountStatus AccountStatus;
	private String id;
	private String password;
	private String mobileNumber;
	private String language;
	private double totalRating=0;
	private int ratingCount=0;
	
    public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}
	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	public AccountStatus getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(AccountStatus AccountStatus) {
		this.AccountStatus = AccountStatus;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
