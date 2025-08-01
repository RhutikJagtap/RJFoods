package com.rjfoods.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rjfoods.dao.OrderDao;
import com.rjfoods.model.Order;

public class OrderDaoImpl implements OrderDao {

	private static Connection connection = null;
	// Sql queries
	static final String INSERT_QUERY = "INSERT INTO `orders`(`restaurantId`, `userId`, `totalAmount`, `modeOfPayment`, `status`,`address`)VALUES (?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `orders` WHERE `orderId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * from `orders`";
	static final String SELECT_ORDER_BY_RESTAURANTID="SELECT *from `orders` where restaurantId=?";
	static final String UPDATE_QUERY = "UPDATE `orders` SET  `restaurantId`=?,`userId`=?,`totalAmount`=?,`modeOfPayment`=?,`status`=? WHERE `orderId`=?";
	static final String DELETE_QUERY = "DELETE FROM `orders` WHERE `orderId`=?";

	public OrderDaoImpl() {

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
	public void addOrder(Order order) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			prepareStatement.setInt(1, order.getRestaurantId());
			prepareStatement.setInt(2, order.getUserId());
			prepareStatement.setInt(3, order.getTotalAmount());
			prepareStatement.setString(4, order.getModeOfPayment());
			prepareStatement.setString(5, order.getStatus());
			prepareStatement.setString(6, order.getAddress());

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
	public Order getOrder(int orderId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Order order = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);

			prepareStatement.setInt(1, orderId);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				int totalAmount = res.getInt("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				String address = res.getString("address");

				order = new Order(orderId, restaurantId, userId, totalAmount, modeOfPayment, status, address);

			}
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

		return order;
	}

	@Override
	public List<Order> getOrderByRestaurantId(int restaurantId) {
	    PreparedStatement pstmt = null; 
	    ResultSet rs = null;
	    List<Order> orderList = new ArrayList<>();

	    try {
	        pstmt = connection.prepareStatement(SELECT_ORDER_BY_RESTAURANTID);
	        pstmt.setInt(1, restaurantId);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            int orderId = rs.getInt("orderId"); // ✅ include this
	            int restaurant_Id = rs.getInt("restaurantId");
	            int userId = rs.getInt("userId");
	            int totalAmount = rs.getInt("totalAmount");
	            String modeOfPayment = rs.getString("modeOfPayment");
	            String status = rs.getString("status");
	            String address = rs.getString("address");

	            Order order = new Order(orderId, restaurant_Id, userId, totalAmount, modeOfPayment, status, address);
	            orderList.add(order);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return orderList;
	}

}
