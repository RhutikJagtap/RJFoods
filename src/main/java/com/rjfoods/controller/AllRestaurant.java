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

@WebServlet("/AllRestaurant")
public class AllRestaurant extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRestaurants = restaurantDaoImpl.getAllRestaurants();

		HttpSession session = req.getSession();

		session.setAttribute("allrestaurant", allRestaurants);
		
		Integer added=null;
		Integer deleted=null;
		
		 added = (Integer)req.getAttribute("added");
		 deleted =(Integer)req.getAttribute("deleted");
		req.setAttribute("added", added);
		req.setAttribute("deleted", deleted);
		
		RequestDispatcher rd = req.getRequestDispatcher("restaurantdetails.jsp");
		rd.forward(req, resp);

	}

}
