package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.model.Restaurant;

@WebServlet("/AddRestaurant")
public class AddRestaurant extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String restaurantName = req.getParameter("restaurantName");
		String address = req.getParameter("address");
		String cuisineType = req.getParameter("cuisineType");
		String r = req.getParameter("rating");
		double rating = Double.parseDouble(r);
		
		String status = req.getParameter("status");
		
		String eta = req.getParameter("eta");
		String restaurantimage = req.getParameter("restaurantimage");
		
		Restaurant restaurant = new Restaurant();
		restaurant.setName(restaurantName);
		restaurant.setAddress(address);
		restaurant.setCuisineType(cuisineType);
		restaurant.setRatings(rating);
		restaurant.setEta(eta);
		restaurant.setImagePath(restaurantimage);
		restaurant.setActive(true);
		
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		int i = restaurantDaoImpl.addRestaurant(restaurant);
		
		req.setAttribute("added", i);
		
		RequestDispatcher rd = req.getRequestDispatcher("AllRestaurant");
		rd.forward(req, resp);

	}

}
