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

@WebServlet("/UpdateRestaurant")
public class UpdateRestaurant extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid = Integer.parseInt(req.getParameter("restaurantId"));
		
		String name = req.getParameter("restaurantname");
		double rating =Double.parseDouble(req.getParameter("rating"));
		String eta =req.getParameter("eta");
		String cuisineType = req.getParameter("cuisinetype");
		String address = req.getParameter("address");
		boolean isActive =Boolean.parseBoolean(req.getParameter("isActive"));
		String imagePath = "gdf.jpg";
		

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		Restaurant restaurant = restaurantDaoImpl.getRestaurant(rid);
		restaurant.setRestaurantId(rid);
		restaurant.setName(name);
		restaurant.setRatings(rating);
		restaurant.setEta(eta);
		restaurant.setCuisineType(cuisineType);
		restaurant.setAddress(address);
		restaurant.setActive(isActive);
		restaurant.setImagePath(imagePath);
		
		int res = restaurantDaoImpl.updateRestaurant(restaurant);
		
		Integer updated= res;
		
		req.setAttribute("updated", updated);

		
		if (res>0) {
			System.out.println("successfully Updated");
		}


		RequestDispatcher rd = req.getRequestDispatcher("AllRestaurant");
		rd.forward(req, resp);

	}

}
