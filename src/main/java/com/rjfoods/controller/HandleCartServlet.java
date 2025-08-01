package com.rjfoods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.model.CartMap;

@WebServlet("/handleCart")
public class HandleCartServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Access menu Id from URL which is present inside request object
		int itemId = Integer.parseInt(req.getParameter("itemId"));

		System.out.println(itemId);

		String action = req.getParameter("action");

		// Get or create the session and retrieve the cart
		HttpSession session = req.getSession();

		// Retrieve the cart map from the session or create a new one
		CartMap cartMap = (CartMap) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new CartMap();
			session.setAttribute("cart", cartMap);
		}

		// Handle increment, decrement, and remove actions
		if (action != null) {
//							int quantity = cart.getOrDefault(itemId, 0);
			switch (action) {
			case "increment":
				cartMap.incrementQuantity(itemId);
				break;
			case "decrement":
				cartMap.decrementQuantity(itemId);
				break;
			case "remove":
				cartMap.deleteCartItem(itemId);
				break;
			}

			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);
		}

	}

}