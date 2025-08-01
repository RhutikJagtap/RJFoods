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

@WebServlet("/ViewMenu")
public class ViewMenuServlet extends HttpServlet{
	
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
				  
				  MenuDao menuDao = new MenuDaoImpl();
				  List<Menu> menuList = menuDao.getMenuById(restaurantId);
				  
				  for(Menu menu:menuList)
				  {
					  System.out.println(menu.getMenuId());
					  System.out.println(menu.getName());
					  System.out.println(menu.getPrice());
				  }
				  
				  req.setAttribute("menuList", menuList);
				  
				  RequestDispatcher rd = req.getRequestDispatcher("menu_details.jsp");
				  rd.forward(req, resp);
				  
		
	}

}
