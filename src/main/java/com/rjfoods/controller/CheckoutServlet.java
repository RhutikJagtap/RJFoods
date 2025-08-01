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

import com.rjfoods.daoimpl.OrderItemDaoImpl;
import com.rjfoods.model.CartItem;
import com.rjfoods.model.OrderItem;
import com.rjfoods.model.User;

@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String menuId = req.getParameter("menuId");
//		String  restaurantId = req.getParameter("restaurantId");
//		

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

//		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();

		if (user == null) {

			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

		if (user != null) {
			int totalAmount = 0;

			// Retrieve the cart list from the session
			Map<Integer, CartItem> cartList = (Map<Integer, CartItem>) session.getAttribute("cartList");

			// Check if the cart list is not null and contains items
			if (cartList != null && !cartList.isEmpty()) {
				// Iterate over the map entries
				for (Map.Entry<Integer, CartItem> entry : cartList.entrySet()) {
					Integer itemId = entry.getKey();
					CartItem cartItem = entry.getValue();

					int userId = user.getUserId();
					int menuId = cartItem.getItemId();
					String name = cartItem.getName();
					int quantity = cartItem.getQuantity();
					double price = cartItem.getPrice();

					double totalCostOfItems = price * quantity;
					totalAmount = (int) (totalAmount + totalCostOfItems);

					OrderItem orderItem = new OrderItem(userId, menuId, name, quantity, 0.0, price);
					orderItemDaoImpl.addOrderItem(orderItem);
				}

				RequestDispatcher rd = req.getRequestDispatcher("checkOut.jsp");
				rd.forward(req, resp);
			}
		}

	}
}
//go to checkout.jsp
