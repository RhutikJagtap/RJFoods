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

import com.rjfoods.daoimpl.OrderDaoImpl;
import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.CartItem;
import com.rjfoods.model.Order;
import com.rjfoods.model.User;

@WebServlet("/OrderConfirm")
public class PaymentConfirmServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String address = req.getParameter("address");
		String modeOfPayment = req.getParameter("payment_mode");
		

		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.updateUserAddress(user.getUserId(),address);
		
		
		Order order = null;
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
				int restaurantId = cartItem.getRestaurantId();
				int menuId = cartItem.getItemId();
				String name = cartItem.getName();
				int quantity = cartItem.getQuantity();
				double price = cartItem.getPrice();

				int totalCostOfItems = (int) (price * quantity);
				totalAmount = totalAmount + totalCostOfItems;
				order = new Order(restaurantId, userId, totalAmount, modeOfPayment, "Delivered", address);

			}
			orderDaoImpl.addOrder(order);

		}

		RequestDispatcher rd = req.getRequestDispatcher("orderConfirmation.jsp");
		rd.forward(req, resp);
	}

}

//when payment confirm in db order items table sit 
//order payment   when con