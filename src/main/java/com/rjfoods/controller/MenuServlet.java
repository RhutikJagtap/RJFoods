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

import com.rjfoods.daoimpl.MenuDaoImpl;
import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.model.Menu;
import com.rjfoods.model.Restaurant;

@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid = Integer.parseInt(req.getParameter("restaurantId"));

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		Restaurant restaurant = restaurantDaoImpl.getRestaurant(rid);

		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> menulist = menuDaoImpl.getMenuById(rid);

		// print here menu
		for (Menu menu : menulist) {
			System.out.println(menu.getMenuId());
			System.out.println(menu.getName());
		}

		// pass restaurant name to menu page
		// String name = restaurant.getName();
		// System.out.print("Restaurant Name :"+name);

		HttpSession session = req.getSession();
		session.setAttribute("restaurant", restaurant);
		session.setAttribute("menulist", menulist);

		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);

	}

}
