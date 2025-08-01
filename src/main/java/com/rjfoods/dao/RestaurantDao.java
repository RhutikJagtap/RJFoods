package com.rjfoods.dao;

import java.util.List;

import com.rjfoods.model.Restaurant;

public interface RestaurantDao {
	int addRestaurant(Restaurant restaurant);

	Restaurant getRestaurant(int restaurantId);
	
	List<Restaurant> getRestaurantByOwnerId(int restaurantOwnerId);
//	Restaurant getRestaurantByUserId(int restaurantOwnerId);

	List<Restaurant> getAllRestaurants(); // return type list

	int updateRestaurant(Restaurant restaurant);

	int deleteRestaurant(int restaurantId);

	List<Restaurant> getTopRestaurant();

}
