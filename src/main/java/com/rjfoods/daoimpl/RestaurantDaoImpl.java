package com.rjfoods.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rjfoods.dao.RestaurantDao;
import com.rjfoods.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {

	private Connection connection;

	final static String INSERT_QUERY = "INSERT into restaurant(restaurantId,name,imagePath,  ratings,  eta,  cuisineType,  address,isActive) values(?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT *from restaurant where restaurantId=?";
	final static String SELECT_ALL_QUERY = "SELECT *from restaurant";
	final static String UPDATE_QUERY = "UPDATE restaurant set name=?,imagePath=?,  ratings=?,  eta=?,  cuisineType=?,  address=?,isActive=? where restaurantId=?";
	final static String DELETE_QUERY = "DELETE  from restaurant where restaurantId=?";
	private static final String SELECT_QUERY_TOP_RESTAURANT = "SELECT * FROM restaurant WHERE ratings = 5";

	static final String SEARCH_QUERY = "SELECT * FROM restaurant WHERE name LIKE ? OR name LIKE ?";
	static final String SELECT_RESTAURANT_BY_OWNER_ID_QUERY="SELECT *from restaurant where restaurantOwnerId=?";
	// constructor
	public RestaurantDaoImpl() {
		String url = "jdbc:mysql://localhost:3306/rjfoods";
		String username = "root";
		String password = "rj@5588";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int addRestaurant(Restaurant restaurant) {
		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, restaurant.getRestaurantId());
			pstmt.setString(2, restaurant.getName());
			pstmt.setString(3, restaurant.getImagePath());
			pstmt.setDouble(4, restaurant.getRatings());
			pstmt.setString(5, restaurant.getEta());
			pstmt.setString(6, restaurant.getCuisineType());
			pstmt.setString(7, restaurant.getAddress());
			pstmt.setBoolean(8, restaurant.isActive());
			rs = pstmt.executeUpdate();

			if (rs > 0) {
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement statement = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, restaurantId);
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getInt("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				Boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(id, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);
				return restaurant;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		Statement createStatement = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		ArrayList<Restaurant> restaurantsList = new ArrayList<>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getInt("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				Boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(id, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);

				restaurantsList.add(restaurant);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (createStatement != null)
					createStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return restaurantsList;
	}

	@Override
	public int updateRestaurant(Restaurant restaurant) {
		PreparedStatement pstmt =null;
		int res=0;
		
		try {
			pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getImagePath());
			pstmt.setDouble(3, restaurant.getRatings());
			pstmt.setString(4, restaurant.getEta());
			pstmt.setString(5, restaurant.getCuisineType());
			pstmt.setString(6, restaurant.getAddress());
			pstmt.setBoolean(7, restaurant.isActive());
			pstmt.setInt(8, restaurant.getRestaurantId());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deleteRestaurant(int restaurantId) {
		
		PreparedStatement statement=null;
		int i=0;
		
		try {
			statement=connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, restaurantId);
			
			i = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<Restaurant> getTopRestaurant() {

		Statement createStatement = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		ArrayList<Restaurant> restaurantsList = new ArrayList<>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_QUERY_TOP_RESTAURANT);

			while (res.next()) {
				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getInt("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				Boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(id, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);

				restaurantsList.add(restaurant);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (createStatement != null)
					createStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return restaurantsList;
	}

	public List<Restaurant> searchRestaurant(String query) {

		PreparedStatement statement = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		ArrayList<Restaurant> restaurantsList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(SEARCH_QUERY);

			// Set the parameters for the query (search terms with wildcards)
			statement.setString(1, query + "%"); // For restaurants starting with the query
			statement.setString(2, "%" + query + "%"); // For restaurants containing the query

			res = statement.executeQuery();

			while (res.next()) {
				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getInt("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				Boolean isActive = res.getBoolean("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(id, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);

				restaurantsList.add(restaurant);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return restaurantsList;

	}

	public List<Restaurant> getRestaurantByOwnerId(int restaurantOwnerId) {
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		ArrayList<Restaurant> restaurantsList = new ArrayList<>();
		try {
			pstmt = connection.prepareStatement(SELECT_RESTAURANT_BY_OWNER_ID_QUERY);

			// Set the parameters for the query (search terms with wildcards)
			pstmt.setInt(1, restaurantOwnerId); // For restaurants starting with the query

			res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getInt("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				Boolean isActive = res.getBoolean("isActive");
				int rOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(id, name, imagePath, ratings, eta, cuisineType, address, isActive,
						rOwnerId);

				restaurantsList.add(restaurant);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return restaurantsList;
	}

//	@Override
//	public Restaurant getRestaurantByUserId(int restaurantOwnerId) {
//		
//  	connection.prepareStatement(SELECT_RESTAURANT_BY_OWNER_ID_QUERY);
//		
//		return null;
//	}

}
