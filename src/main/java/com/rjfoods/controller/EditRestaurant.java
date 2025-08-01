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

@WebServlet("/EditRestaurant")
public class EditRestaurant extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid = Integer.parseInt(req.getParameter("restaurantId"));

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		Restaurant restaurant = restaurantDaoImpl.getRestaurant(rid);
		
		req.setAttribute("restaurant", restaurant);

		RequestDispatcher rd = req.getRequestDispatcher("edit_restaurant.jsp");
		rd.forward(req, resp);

	}

}
