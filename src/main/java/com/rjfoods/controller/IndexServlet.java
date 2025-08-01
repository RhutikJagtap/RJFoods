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

@WebServlet("")
public class IndexServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> list = restaurantDaoImpl.getAllRestaurants();

		for (Restaurant restaurant : list) {
			System.out.println(restaurant.getName());
		}

		List<Restaurant> topRestaurantList = restaurantDaoImpl.getTopRestaurant();

		req.setAttribute("toprestaurant", topRestaurantList);
		req.setAttribute("restaurant", list);

		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}

}
