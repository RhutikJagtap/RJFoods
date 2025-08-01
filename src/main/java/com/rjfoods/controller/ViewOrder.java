package com.rjfoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.dao.OrderDao;
import com.rjfoods.dao.RestaurantDao;
import com.rjfoods.daoimpl.OrderDaoImpl;
import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.model.Order;
import com.rjfoods.model.Restaurant;
import com.rjfoods.model.User;

@WebServlet("/ViewOrder")
public class ViewOrder extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User user=(User)session.getAttribute("restaurantOwner");
		
		int restaurantOwnerId=user.getUserId();
		
//		System.out.println(restaurantOwnerId);
		
		RestaurantDao restaurantDao= new RestaurantDaoImpl();
		List<Restaurant> restaurantByOwnerId = restaurantDao.getRestaurantByOwnerId(restaurantOwnerId);
		
		
		int restaurantId=0;
		for(Restaurant restaurant:restaurantByOwnerId)
		{
			restaurantId=restaurant.getRestaurantId();
		}
		
		System.out.println(restaurantId);
		
		OrderDao orderDao = new OrderDaoImpl();
		List<Order> orderLists = orderDao.getOrderByRestaurantId(restaurantId);
		
		for(Order order:orderLists)
		{
			System.out.println(order.getOrderId());
			System.out.println(order.getTotalAmount());
			System.out.println(order.getUserId());
		}
		
		req.setAttribute("orderlist", orderLists);
		
		RequestDispatcher rd = req.getRequestDispatcher("order_details.jsp");
		rd.forward(req, resp);
	}
}
