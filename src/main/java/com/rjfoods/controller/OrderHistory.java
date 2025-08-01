package com.rjfoods.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjfoods.dao.MenuDao;
import com.rjfoods.daoimpl.MenuDaoImpl;
import com.rjfoods.daoimpl.OrderItemDaoImpl;
import com.rjfoods.daoimpl.UserDaoImpl;
import com.rjfoods.model.Menu;
import com.rjfoods.model.OrderItem;
import com.rjfoods.model.User;

@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userId"));
		
		
//		HttpSession session = req.getSession();
//		User user = (User) session.getAttribute("user");
		
		UserDaoImpl userDaoImpl= new UserDaoImpl();
		User user = userDaoImpl.getUser(userId);

//		System.out.println("User name" + user.getUserName());

		OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
		List<OrderItem> allOrderItems = orderItemDaoImpl.getAllOrderItemsByUserId(user.getUserId());

		System.out.println(allOrderItems.size());
		System.out.println("History of Items");

		int menuId=0;
		for (OrderItem o : allOrderItems) {
			System.out.println("Item name" + o.getItemName());
			menuId=o.getMenuId();
		}
		
		// Fetch Menu and ImagePath for each OrderItem
        MenuDao menuDao = new MenuDaoImpl();
        for (OrderItem orderItem : allOrderItems) {
            // Fetch menu by menuId for each OrderItem
            List<Menu> menuByMenuId = menuDao.getMenuByMenuId(orderItem.getMenuId());
            if (!menuByMenuId.isEmpty()) {
                Menu menu = menuByMenuId.get(0);  // Get the first menu item (assumes menuId is unique)
                orderItem.setImagePath(menu.getImagePath());  // Set the imagePath in OrderItem
                System.out.println("Image Path: " + menu.getImagePath());  // Debugging
            }
        }
		
		req.setAttribute("allOrderItems", allOrderItems);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("orderHistory.jsp");
		requestDispatcher.forward(req, resp);

	}

}
