package com.rjfoods.model;

public class Menu {

	private int menuId;
	private String name;
	private double price;
	private String description;
	private String imagePath;
	private boolean isAvailable;
	private int restaurantId;
	private double ratings;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(int menuId, String name, double price, String description, String imagePath, boolean isAvailable,
			int restaurantId, double ratings) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.ratings = ratings;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

}
