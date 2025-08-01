package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOutUser")
public class LogOutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// also destroy the session object
		HttpSession session = req.getSession();
		session.invalidate();

		// redirecting to resturant jsp file
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
		requestDispatcher.forward(req, resp);

	}

}
