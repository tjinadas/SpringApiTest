package com.Springboot.commands;

import java.util.Date;

import com.Springboot.domain.Customer.AccountStatus;

public class UpdateAccountCommand {
	
	private String FirstName;
    private String LastName;
    private String email;
	private Date AccountCreationTimestamp;
	private Date modifiedTimestamp;
	private AccountStatus AccountStatus;
	private String id;
	private String password;
	
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
	public AccountStatus getAccountStatus() {
		return AccountStatus;
	}
	public void setApplicationStatus(AccountStatus AccountStatus) {
		this.AccountStatus = AccountStatus;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
