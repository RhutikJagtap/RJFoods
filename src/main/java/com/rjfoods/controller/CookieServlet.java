package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.model.User;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		// Check if the request is a POST or GET request
        String method = req.getMethod();

        // Check if the cookie exists
        Cookie[] cookies = req.getCookies();
        boolean hasCookie = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("rhutik".equals(cookie.getName()) && "rj".equals(cookie.getValue())) {
                    hasCookie = true;
                    break;
                }
            }
        }

        // If cookie is already set, redirect to main page
        if (hasCookie) {
            resp.sendRedirect("RestaurantServlet?cookieConsent=true");
        } else {
            if ("POST".equals(method)) {
                // Set the cookie when the user accepts
                Cookie cookie = new Cookie("rhutik", "rj");
                cookie.setMaxAge(60 * 60 * 24 * 30); // Set cookie expiry to 30 days
                resp.addCookie(cookie);

                // Redirect to main page after accepting the cookie
                resp.sendRedirect("RestaurantServlet?cookieConsent=true");
            } else {
                // Handle GET request and show consent box if no cookie
            	resp.sendRedirect("RestaurantServlet?cookieConsent=false");
            }
        }
		
		
	}

}
