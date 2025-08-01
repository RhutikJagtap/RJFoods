package com.rjfoods.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.Mail;
import com.rjfoods.model.User;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		System.out.println("UIfetched emailId=" + email);

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		User userByemail = userDaoImpl.getUserByemail(email);

		HttpSession session = req.getSession();

//		System.out.println(userByemail.getEmail());

		if (userByemail != null && userByemail.getEmail().equals(email)) {

			System.out.println("Email match");
			// forgot email send
			Random rand = new Random();
			int max = 99999, min = 10000;
			int otp = rand.nextInt(max - min + 1) + min;

			System.out.println("Random otp = " + otp);

			session.setAttribute("otp", String.valueOf(otp));
			session.setAttribute("email", email);

			// send otp
			Mail.forgotPassword(userByemail.getEmail(), otp);

			req.setAttribute("errorMessage", "new password send on your email Id");

//			go to reset password
			RequestDispatcher rd = req.getRequestDispatcher("resetpassword.jsp");
			rd.forward(req, resp);

		} else {
			System.out.println("wrong email id");
			// email not matched
			String errorMessage = "Enter the correct email Id";
			req.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(req, resp);

		}

	}

}
