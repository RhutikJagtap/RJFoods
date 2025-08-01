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

import com.rjfoods.dao.MenuDao;
import com.rjfoods.dao.RestaurantDao;
import com.rjfoods.daoimpl.MenuDaoImpl;
import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.model.Menu;
import com.rjfoods.model.Restaurant;
import com.rjfoods.model.User;

@WebServlet("/SaveMenu")
public class SaveMenu  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get the restaurant Owner Id
		HttpSession session = req.getSession();
		  User user = (User)session.getAttribute("restaurantOwner");
		  
		  int userId = user.getUserId();
		  
		  RestaurantDao restaurantDao = new RestaurantDaoImpl();
		  List<Restaurant> list = restaurantDao.getRestaurantByOwnerId(userId);
		  
		  int restaurantId=0;
		  for(Restaurant restaurant:list)
		  {
			   restaurantId = restaurant.getRestaurantId();
		  }
		  
		int menuId=42;
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String description = req.getParameter("description");
		String imagePath = req.getParameter("imagePath");
		String value =req.getParameter("available");
		boolean available=false;
		if (value.equals("true")) {
			available=true;
		}
		double ratings = Double.parseDouble(req.getParameter("ratings"));
		
		//
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		menu.setName(name);
		menu.setPrice(price);
		menu.setDescription(description);
		menu.setImagePath(imagePath);
		menu.setAvailable(available);
		menu.setRestaurantId(restaurantId);
		menu.setRatings(ratings);
		
		//
		MenuDao menuDao = new MenuDaoImpl();
		int i = menuDao.addMenu(menu);
		
		RequestDispatcher rd = req.getRequestDispatcher("ViewMenu");
		rd.forward(req, resp);
		
		System.out.println(menu);
		System.out.println("Succesfully added menu "+i);
		
		
		
		
	}
}
