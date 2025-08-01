package com.rjfoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.model.Restaurant;

@WebServlet("/SearchRestaurant2")
public class SearchRestaurant2 extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getParameter("query");

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> searchRestaurant = restaurantDaoImpl.searchRestaurant(query);
		List<Restaurant> list = restaurantDaoImpl.getAllRestaurants();

		req.setAttribute("searchRestaurant", searchRestaurant);
		req.setAttribute("restaurant", list);

		// Forward the request to the JSP
		RequestDispatcher rd = req.getRequestDispatcher("searchrestaurant2.jsp");
		rd.forward(req, resp);

	}

}
