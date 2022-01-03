package com.ondemandcarwash.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
	
	
	private String cName;
	private String cPhone;
	private String cEmail;
	private String cPassword;
	
	//to String
	@Override
	public String toString() {
		return "Customer [ cName=" + cName + ", cPhone=" + cPhone + ", cEmail=" + cEmail + 
			", cPassword=" + cPassword + "]";
	}
	
	//default constructor or no parameter constructor
	public Customer() {
		
	}
	
	//parameterised constructor
	public Customer( String cName, String cPhone, String cEmail, String cPassword) {
		super();
		
		this.cName = cName;
		this.cPhone = cPhone;
		this.cEmail = cEmail;
		this.cPassword = cPassword;
	}
	
	//getters and setters
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	

}
