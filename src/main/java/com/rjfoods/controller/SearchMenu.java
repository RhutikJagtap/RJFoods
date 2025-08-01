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
import com.rjfoods.model.Menu;

@WebServlet("/SearchMenu")
public class SearchMenu extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String query = req.getParameter("query");
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));

		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> searchMenu = menuDaoImpl.searchMenu(restaurantId, query);
//		List<Restaurant> list = menuDaoImpl.getAllMenu();

		System.out.println("search Query:" + query + " Restaurant Id " + restaurantId);

		System.out.println("Search Menu");
		for (Menu menu : searchMenu) {
			System.out.println(menu.getName());
		}

		HttpSession session = req.getSession();

		session.setAttribute("searchMenu", searchMenu);
//		req.setAttribute("menu", list);

		// Forward the request to the JSP
		RequestDispatcher rd = req.getRequestDispatcher("search_menu.jsp");
		rd.forward(req, resp);

	}

}
