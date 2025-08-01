package com.rjfoods.model;

public class Order {
	private int orderId;

	private int restaurantId;

	private int userId;

	private int totalAmount;

	private String modeOfPayment;

	private String status;

	private String address;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	 // Constructor without orderId
    public Order(int restaurantId, int userId, int totalAmount, 
                 String modeOfPayment, String status, String address) {
        this.restaurantId = restaurantId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.modeOfPayment = modeOfPayment;
        this.status = status;
        this.address = address;
    }

	public Order(int orderId, int restaurantId, int userId, int totalAmount, String modeOfPayment, String status,
			String address) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.address = address;
	}
	
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
