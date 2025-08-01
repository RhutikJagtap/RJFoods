package com.rjfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.dao.UserDao;
import com.rjfoods.daoimpl.RestaurantDaoImpl;
import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.Restaurant;
import com.rjfoods.model.Security;
import com.rjfoods.model.User;

@WebServlet("/LoginUser")
public class LoginServlet extends HttpServlet {

	private static  int count = 3; // Maximum attempts for login

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");

		// Create cookies for username and password
		Cookie c1 = new Cookie("username", uname);
		Cookie c2 = new Cookie("pwd", pwd);
		resp.addCookie(c1);
		resp.addCookie(c2);

		String encryptedusername = Security.callEncryption(uname);
		String encryptedpassword = Security.callEncryption(pwd);

		// Retrieve user from database
		UserDao ud = new UserDaoImpl();

		// decrypted user
		User u = ud.getLoginDetails(encryptedusername);
		
		//if forgot password amin can decrpt it and see
//		String decryptedusername = Security.callDecryption(u.getUserName());
//		String decryptedpassword = Security.callDecryption(u.getPassword());
//		
//		System.out.println(decryptedusername);
//		System.out.println(decryptedpassword);

		HttpSession session = req.getSession();
//		String role = u.getRole();

		// Count total users (optional)
		List<User> allUser = ud.getAllUser();
		session.setAttribute("allUser", allUser);
		int usercount = allUser.size();

		// Count total restaurants (optional)
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRestaurants = restaurantDaoImpl.getAllRestaurants();
//		session.setAttribute("restaurantCount", allRestaurants.size());

		if (uname.equals("admin") && pwd.equals("admin")) {
			session.setAttribute("userCount", usercount);
			session.setAttribute("restaurantCount", allRestaurants.size());
			session.setAttribute("user", u); // Store the entire User object in the session

			RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
			rd.forward(req, resp);
		}

		if (u != null) {
			String databasePassword = u.getPassword();
			
			if (encryptedpassword.equals(databasePassword) && u.getRole().equals("RestaurantOwner"))
			{
				//tim 1234
				HttpSession session2 = req.getSession();
				session2.setAttribute("restaurantOwner", u);
				
				
				req.setAttribute("restaurantOwnerId", u.getUserId());
				RequestDispatcher rd = req.getRequestDispatcher("restaurantOwnerDashboard.jsp");
				rd.forward(req, resp);
			}
			
			//jagtaprj   rj123
			if (encryptedpassword.equals(databasePassword) && u.getRole().equals("DeliveryBoy"))
			{
				RequestDispatcher rd = req.getRequestDispatcher("deliveryBoyDashboard.jsp");
				rd.forward(req, resp);
			}
			

			// Check if password matches
			if (encryptedpassword.equals(databasePassword) && u.getRole().equals("Customer")) {
				// Successful login
				session.setAttribute("user", u); // Store the entire User object in session
				ud.UserIsLoggedIn(u.getUserId(), true); // Update login status in DB

				// update last login
				ud.updateLastLogin(u.getUserId());

				// Set success message and forward to restaurant page
				String msg2 = "Congratulations! Successfully logged in!";
				req.setAttribute("successmsg", msg2);

				session.setAttribute("user", u);

				RequestDispatcher rd = req.getRequestDispatcher("RestaurantServlet");
				rd.forward(req, resp);
			} else if (count > 0) {
				// Invalid password but remaining attempts
				String msg3 = "Invalid Password. " + count-- + " attempts left.";
				req.setAttribute("errorMessage", msg3);
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} else {
				// attempts over reset password
				String msg4 = "Attempts over ! You want to forgot password";
				req.setAttribute("errorMessage", msg4);
				RequestDispatcher rd = req.getRequestDispatcher("forgotpassword.jsp");
				rd.forward(req, resp);
			}
		} else if (count > 0) {
//			System.out.println(count);

			String msg = "Invalid Username " + count-- + " attempts left.";
			req.setAttribute("errorMessage", msg);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);

		} else {

			String msg5 = "User Name Not Found  Attempts Over! Please SignUp first";
			req.setAttribute("errorMessage", msg5);
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}

	}

	// to encrypt data
	private static String callEncryption(String text) {
		String encriptedValue = "";

		for (int i = 0; i < text.length(); i++) {
			char charvalue = text.charAt(i);

			int asciiValue = charvalue;

			int encryptingVaLue = asciiValue - 12878;

			char encrname = (char) encryptingVaLue;

			encriptedValue = encriptedValue + encrname;

		}
		return encriptedValue;

	}

}
