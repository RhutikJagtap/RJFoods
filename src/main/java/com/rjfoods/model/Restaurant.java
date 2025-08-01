package com.rjfoods.model;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String imagePath;
	private double ratings;
	private String eta;
	private String cuisineType;
	private String address;
	private boolean isActive;
	private int restaurantOwnerId;

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, String name, String imagePath, double ratings, String eta, String cuisineType,
			String address, boolean isActive, int restaurantOwnerId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRestaurantOwnerId() {
		return restaurantOwnerId;
	}

	public void setRestaurantOwnerId(int restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	}

}
