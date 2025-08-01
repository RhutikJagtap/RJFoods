package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.Mail;
import com.rjfoods.model.Security;
import com.rjfoods.model.User;

@WebServlet("/SignUpUser")
public class SignUpServelet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("uname");
		String emailId = req.getParameter("emailId");
		String phoneNum = req.getParameter("phoneNum");
		String pwd = req.getParameter("pwd");

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User dbUser = userDaoImpl.getUser(username);

		if (dbUser != null && dbUser.getUserName().equals(username)) {
			String msg = "username already exits give different username";

			req.setAttribute("errorMessage", msg);
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);

		} else {
			String encryptedusername = Security.callEncryption(username);
			String encryptedpassword = Security.callEncryption(pwd);

			User user = new User(0, username, emailId, phoneNum, null, encryptedusername, encryptedpassword, null, null, null, false);

			userDaoImpl.addUser(user);

			Mail.successfullyRegister(username, emailId);

			String msg5 = "Congrats Succesfully Register ! Login Now";
			req.setAttribute("registermsg", msg5);

			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

	}

}
