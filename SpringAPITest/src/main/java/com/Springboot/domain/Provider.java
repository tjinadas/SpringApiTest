package com.Springboot.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Provider {
	
		@Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;
	    
	    private String FirstName;
	    
	    private String LastName;
	    
	    private String email;
	    
	    private String addressLine1;
	    
	    private String addressLine2;
	    
	    @OneToMany(mappedBy="providerID")
	    private Set<ProviderMenu> providerMenu;
	    
	    public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		private String postalCode;
	    
	    @Column(length = 2)
	    private String language;
	    

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		private double totalRating=0;
	    

		private int ratingCount=0;
	    
		public enum ProviderStatus{Active, Terminated, Suspended,Approval_In_Progress};
		
		private ProviderStatus ProviderStatus;
	    
		public enum AccountType{Pro, HomeChef};
		
		private AccountType AccountType;
	    
	    private String Password;
	    
	    private String mobilenumber;
	    
		private Date AccountCreationTimestamp;
	    
		private Date modifiedTimestamp;
	 
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

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
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
		
	    public ProviderStatus getProviderStatus() {
			return ProviderStatus;
		}

		public void setProviderStatus(ProviderStatus providerStatus) {
			ProviderStatus = providerStatus;
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


	        
	    

}
