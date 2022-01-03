package com.ondemandcarwash.models;

import java.util.Date;



import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "orders")
public class Order {
	

	private long cId;

	private String address;

	
	private String status;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date serviceDate;


	
	private String carName;

	private String carModel;

	private int washPackId;
	private int price;
	
	/*
	 * Parameterized Constructor
	 * 
	 */

	
	public Order(long cId, String address, String status, Date serviceDate, String carName, String carModel,
			int washPackId,int price) {
		super();
		this.cId = cId;
		this.address = address;
		this.status = status;
		this.serviceDate = serviceDate;
		this.carName = carName;
		this.carModel = carModel;
		this.washPackId = washPackId;
		this.price = price;
	}
	

	/*
	 * Getters and Setters
	 * 
	 */

	
	

	public long getcId() {
		return cId;
	}

	


	public void setcId(long cId) {
		this.cId = cId;
	}

	
	

	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}

	


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getWashPackId() {
		return washPackId;
	}

	public void setWashPackId(int washPackId) {
		this.washPackId = washPackId;
	}

	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}


	/*
	 * No parameter Constructor or default constructor
	 * 
	 */

	public Order() {

	}

}