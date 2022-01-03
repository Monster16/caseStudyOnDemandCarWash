package com.ondemandcarwash.model;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "orders")
public class Order {
	
	@Transient
    public static final String SEQUENCE_NAME = "order_sequence";

	
	private long orderId;

	private long wId;

	@Min(value = 1, message = "User ID Invalid")
	private long cId;

	private double amount;
	private String currency;
	private String intent;

	@Valid
	private String address;

	@Pattern(regexp = "^Pending|Requested|Washer Assigned|Completed|Cancelled", message = "Invalid Status")
	@NotBlank(message = "Order Status can't be blank")
	private String status;

	@Pattern(regexp = "^Cash|Card", message = "Invalid Payment Mode")
	@NotBlank(message = "Payment Mode is Must")
	private String paymentMode;


	private String serviceDate;


	@NotNull
	private String carName;

	@NotNull
	private String carModel;

	@NotNull
	private int washPackId;

	@NotNull
	private long phoneNo;

	
	


	/*
	 * Parameterized Constructor
	 * 
	 */
	public Order(long orderId, long wId, @Min(value = 1, message = "User ID Invalid") long cId, double amount,
			String currency, String intent, @Valid String address,
			@Pattern(regexp = "^Pending|Requested|Washer Assigned|Completed|Cancelled", message = "Invalid Status") @NotBlank(message = "Order Status can't be blank") String status,
			@Pattern(regexp = "^Cash|Card", message = "Invalid Payment Mode") @NotBlank(message = "Payment Mode is Must") String paymentMode,
			String serviceDate, @NotNull String carName, @NotNull String carModel, @NotNull int washPackId,
			@NotNull long phoneNo) {
		super();
		this.orderId = orderId;
		this.wId = wId;
		this.cId = cId;
		this.amount = amount;
		this.currency = currency;
		this.intent = intent;
		this.address = address;
		this.status = status;
		this.paymentMode = paymentMode;
		this.serviceDate = serviceDate;
		this.carName = carName;
		this.carModel = carModel;
		this.washPackId = washPackId;
		this.phoneNo = phoneNo;
	}
	

	/*
	 * Getters and Setters
	 * 
	 */

	public long getOrderId() {
		return orderId;
	}

	

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public long getwId() {
		return wId;
	}

	public void setwId(long wId) {
		this.wId = wId;
	}

	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getIntent() {
		return intent;
	}


	public void setIntent(String intent) {
		this.intent = intent;
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

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
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

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/*
	 * No parameter Constructor or default constructor
	 * 
	 */

	public Order() {

	}

}