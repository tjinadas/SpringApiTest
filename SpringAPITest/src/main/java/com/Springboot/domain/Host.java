package com.Springboot.domain;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Host {
	
		@Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;
	    
	    private String FirstName;
	    
	    private String LastName;
	    
	    private String email;
	    
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

		private String streetNumberandAddress;	
	    
	    private String city;
	    
		private String province;	
		
		private String country;	
	    
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
		
		  public Map<String, Object> toMap(){
		        Map map = new TreeMap<>();
		        map.put("id", id);
		        return map;
		    }


	        
	    

}
