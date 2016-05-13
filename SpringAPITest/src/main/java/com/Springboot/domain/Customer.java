package com.Springboot.domain;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Customer {
	
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String FirstName;
    
    private String LastName;
    
    private String email;
    
    private String Password;
    
    private String mobileNumber;
    
    private double totalRating=0;
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

	private int ratingCount=0;
    
    @Column(length = 2)
    private String language;
    
    public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEmail() {
		return email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Date AccountCreationTimestamp;
    
	private Date modifiedTimestamp;
	
	public enum AccountStatus{Active, Terminated, Suspended,Approval_In_Progress};
	
	private AccountStatus AccountStatus;
    
    
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

	public Date getAccountCreationTimestamp() {
		return AccountCreationTimestamp;
	}

	public void setAccountCreationTimestamp(Date accountCreationTimestamp) {
		AccountCreationTimestamp = accountCreationTimestamp;
	}

	public Date getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(Date modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}
	
	  public Map<String, Object> toMap(){
	        Map map = new TreeMap<>();
	        map.put("id", id);
	        return map;
	    }
	

}
