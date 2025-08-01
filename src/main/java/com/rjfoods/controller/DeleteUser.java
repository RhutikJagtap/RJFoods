package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.daoimpl.UserDaoImpl;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userId"));

		System.out.println(userId);

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.deleteUser(userId);

		resp.sendRedirect("AllUser");

	}
}
