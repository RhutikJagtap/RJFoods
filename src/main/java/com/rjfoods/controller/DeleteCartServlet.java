package com.rjfoods.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.daoimpl.MenuDaoImpl;
import com.rjfoods.model.CartItem;
import com.rjfoods.model.CartMap;
import com.rjfoods.model.Menu;

@WebServlet("/DeleteCart")
public class DeleteCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int itemId = Integer.parseInt(req.getParameter("itemId"));

		MenuDaoImpl menu = new MenuDaoImpl();
		Menu menuItem = menu.getMenu(itemId);

		// Get or create the session and retrieve the cart
		HttpSession session = req.getSession();

		// Retrieve the cart map from the session or create a new one
		CartMap cartMap = (CartMap) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new CartMap();
			session.setAttribute("cart", cartMap);
		}
		
	
		// update the cart item to the cart
		cartMap.deleteCartItem(itemId);

		// Set the quantity and menu item attributes for the JSP
		req.setAttribute("menu", menuItem);

		int quantity = 1;
		// Get all items in the cart and set the cart list in the session
		Map<Integer, CartItem> allItems = cartMap.getAllCartItem();
		session.setAttribute("cartList", allItems);

		// Set the quantity and menu item attributes for the JSP
		req.setAttribute("inputboxquantity", quantity);
		req.setAttribute("menu", menuItem);
		
		//countCartItems
		int countCartItems = cartMap.countCartItems();
		req.setAttribute("countCartItems", countCartItems);


		// Forward the request to cart.jsp
		RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
		rd.forward(req, resp);

	}
}