package com.rjfoods.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rjfoods.dao.OrderItemDao;
import com.rjfoods.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {
	private static Connection connection = null;

	static final String INSERT_QUERY = "INSERT INTO `orderitems`(`orderItemId`,`userId`, `menuId`,`name`,`quantity`,`ratings`,`price`)VALUES (?,?,?,?,?,?,?)";

	static final String SELECT_ALL_QUERY_BY_USERID = "SELECT * FROM `orderitems` Where `userId`=?";

	
	public OrderItemDaoImpl() {

		// when we call constructor or create object these things will happen
		String url = "jdbc:mysql://localhost:3306/rjfoods";
		String username = "root";
		String password = "rj@5588";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			prepareStatement.setInt(1, orderItem.getOrderItemId());
			prepareStatement.setInt(2, orderItem.getUserId());
			prepareStatement.setInt(3, orderItem.getMenuId());
			prepareStatement.setString(4, orderItem.getItemName());
			prepareStatement.setInt(5, orderItem.getQuantity());
			prepareStatement.setDouble(6, orderItem.getRating());
			prepareStatement.setDouble(7, orderItem.getPrice());

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepareStatement != null)
					prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItemsByUserId(int userid) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		OrderItem orderItem = null;
		ArrayList<OrderItem> OrderItemsList = new ArrayList<OrderItem>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_ALL_QUERY_BY_USERID);
			prepareStatement.setInt(1, userid);

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int orderItemId = res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName = res.getString("name");
				double rating = res.getDouble("ratings");
				int quantity = res.getInt("quantity");
				double price = res.getDouble("price");

				
				orderItem=new OrderItem( userId,  menuId,itemName, quantity, rating, price);
				OrderItemsList.add(orderItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null)
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return OrderItemsList;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub

	}

}
