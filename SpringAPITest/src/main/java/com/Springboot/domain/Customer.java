package com.Springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class Customer {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    private long id;
    
    private String FirstName;
    
    private String LastName;
    
    private String email;
    
    public String getEmail() {
		return email;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
/*	 public Customer(String firstName, String lastName, String emailAddress) {
	        this.FirstName = firstName;
	        this.LastName = lastName;
	        this.email = emailAddress;

	    }
	
*/
	

}
