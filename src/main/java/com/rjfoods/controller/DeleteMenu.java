package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.dao.MenuDao;
import com.rjfoods.daoimpl.MenuDaoImpl;

@WebServlet("/DeleteMenu")
public class DeleteMenu extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		
		MenuDao menuDao = new MenuDaoImpl();
		int i = menuDao.deleteMenu(menuId);
		
		if (i>0) {
			System.out.println("Menu Deleted Succssfully");			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("ViewMenu");
		rd.forward(req, resp);
	}
}
