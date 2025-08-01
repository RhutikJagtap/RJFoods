package com.rjfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.dao.RestaurantDao;
import com.rjfoods.daoimpl.RestaurantDaoImpl;

@WebServlet("/DeleteRestaurant")
public class DeleteRestaurant extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String restaurantId = req.getParameter("restaurantId");
		
		int rid=Integer.parseInt(restaurantId);
		
		PrintWriter out=resp.getWriter();
		
		
		RestaurantDao restaurantDao = new RestaurantDaoImpl();
		int i = restaurantDao.deleteRestaurant(rid);
		
		System.out.println("Deleted Restaurant successfully");
		out.print("Successfully deleted Restaurant");
		
		req.setAttribute("deleted", i);
		
		RequestDispatcher rd = req.getRequestDispatcher("AllRestaurant");
		rd.forward(req, resp);
		
	}

}
