package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditMenu")
public class EditMenu extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int menuId =Integer.parseInt(req.getParameter("menuId"));
		
		RequestDispatcher rd = req.getRequestDispatcher("ViewMenu");
		rd.forward(req, resp);
	}

}
