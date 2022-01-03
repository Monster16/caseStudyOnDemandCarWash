package com.ondemandcarwash.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "washers")
public class Washer {
	
	
	private String wName;
	private String wEmail;
	private String wPhone;
	private String wAddress;
	private String wPassword;
	
	
	//No parameter Constructor or default constructor
	public Washer() {
		
	}
	
	
	
	//parameterised constructor
	public Washer( String wName, String wEmail, String wPhone, String wAddress, String wPassword) {
		super();
		
		this.wName = wName;
		this.wEmail = wEmail;
		this.wPhone = wPhone;
		this.wAddress = wAddress;
		this.wPassword = wPassword;
	}
	
	//getters and setters
	
	
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	public String getwEmail() {
		return wEmail;
	}
	public void setwEmail(String wEmail) {
		this.wEmail = wEmail;
	}
	public String getwPhone() {
		return wPhone;
	}
	public void setwPhone(String wPhone) {
		this.wPhone = wPhone;
	}
	public String getwAddress() {
		return wAddress;
	}
	public void setwAddress(String wAddress) {
		this.wAddress = wAddress;
	}
	public String getwPassword() {
		return wPassword;
	}
	public void setwPassword(String wPassword) {
		this.wPassword = wPassword;
	}
	
	
	
	

}
