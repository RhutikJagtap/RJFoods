package com.rjfoods.dao;

import java.util.List;

import com.rjfoods.model.Order;

public interface OrderDao {

	void addOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrderByRestaurantId(int restaurantId);

}
