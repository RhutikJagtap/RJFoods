package com.rjfoods.dao;

import java.util.List;

import com.rjfoods.model.OrderItem;

public interface OrderItemDao {

	void addOrderItem(OrderItem orderItem);

	OrderItem getOrderItem(int orderItemId);

	List<OrderItem> getAllOrderItems();

	List<OrderItem> getAllOrderItemsByUserId(int userid);

	void updateOrderItem(OrderItem orderItem);

	void deleteOrderItem(int orderItemId);

}
