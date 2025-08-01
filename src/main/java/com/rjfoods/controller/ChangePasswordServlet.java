package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.Mail;
import com.rjfoods.model.Security;

@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String emailId = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmpassword");

		HttpSession session = req.getSession();
		String otp = (String) session.getAttribute("otp");
		String email = (String) session.getAttribute("email");

		// Check if OTP and email match
		if (otp == null || email == null) {
			req.setAttribute("errorMessage", "Session expired. Please try again.");
			RequestDispatcher rd = req.getRequestDispatcher("resetpassword.jsp");
			rd.forward(req, resp);
			return;
		}

		if (email.equals(emailId)) {
			// Check if OTP and password match and passwords are confirmed
			if (otp.equals(password) && password.equals(confirmPassword)) {
				
				// Call change password method
	            UserDaoImpl userDaoImpl = new UserDaoImpl(); 
	            
//	            encrypt the new otp
				String encryptedOtp = Security.callEncryption(otp);
				
				//update in database by emailid
	            userDaoImpl.updatePasswordByEmail(email,encryptedOtp);
	            
				Mail.passwordChange(email, otp);

	            System.out.println("Password updated successfully");

				req.setAttribute("errorMessage", "Password successfully changed Now login");

				// Redirect to login page
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				return;
			} else if (!password.equals(confirmPassword)) {
				req.setAttribute("errorMessage", "Password and confirm password do not match.");
				RequestDispatcher rd = req.getRequestDispatcher("resetpassword.jsp");
				rd.forward(req, resp);
				return;
			} else {
				req.setAttribute("errorMessage", "Invalid OTP.");
				RequestDispatcher rd = req.getRequestDispatcher("resetpassword.jsp");
				rd.forward(req, resp);
				return;
			}
		} else {
			req.setAttribute("errorMessage", "Enter the correct email.");
			RequestDispatcher rd = req.getRequestDispatcher("resetpassword.jsp");
			rd.forward(req, resp);
			return;
		}
	}
}