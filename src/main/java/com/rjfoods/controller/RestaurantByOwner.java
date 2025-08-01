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

import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.model.Restaurant;

/**
 * Servlet implementation class RestaurantByOwner
 */
@WebServlet("/RestaurantByOwner")
public class RestaurantByOwner extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		int restaurantOwnerId=(int)req.getAttribute("restaurantOwnerId");
		
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRestaurants = restaurantDaoImpl.getRestaurantByOwnerId(restaurantOwnerId);

		HttpSession session = req.getSession();

		session.setAttribute("allrestaurant", allRestaurants);

		RequestDispatcher rd = req.getRequestDispatcher("restaurantdetails.jsp");
		rd.forward(req, resp);

	}

}
