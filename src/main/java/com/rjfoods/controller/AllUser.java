package com.rjfoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.dao.UserDao;
import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.User;

@WebServlet("/AllUser")
public class AllUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// from database
		UserDao ud = new UserDaoImpl();
		List<User> allUser = ud.getAllUser();

		System.out.println("All User Servlet Calling");

		for (User user : allUser) {
			System.out.println(user.getName());
			System.out.println(user.getEmail());
		}

		RequestDispatcher rd = req.getRequestDispatcher("userdetails.jsp");
		rd.forward(req, resp);

	}
}
