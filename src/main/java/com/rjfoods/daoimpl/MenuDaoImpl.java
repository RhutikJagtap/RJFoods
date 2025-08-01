package com.rjfoods.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rjfoods.dao.MenuDao;
import com.rjfoods.model.Menu;

public class MenuDaoImpl implements MenuDao {

	private Connection connection;

	final static String INSERT_QUERY = "INSERT into menu(menuId,name,price,description,imagePath,isAvailable,restaurantId,ratings) values(?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT *from menu where menuId=?";
	final static String SELECT_ALL_QUERY = "SELECT *from menu";
	final static String UPDATE_QUERY = "UPDATE menu set name=?,email=?,  phoneNo=?,  address=?,  userName=?,  password=? where userId=?";
	final static String DELETE_QUERY = "DELETE  from menu where menuId=?";

	final static String SELECT_BY_ID = "SELECT *from menu where restaurantId=?";

	final static String SEARCH_QUERY = "SELECT * FROM menu WHERE  restaurantId=? AND name LIKE ?";

	String SELECT_MENU_BY_MENUID="SELECT * FROM menu where menuId=?";
	
	// constructor
	public MenuDaoImpl() {
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
	public int addMenu(Menu menu) {
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, menu.getMenuId());
			pstmt.setString(2, menu.getName());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setString(4, menu.getDescription());
			pstmt.setString(5, menu.getImagePath());
			pstmt.setBoolean(6, menu.isAvailable());
			pstmt.setInt(7, menu.getRestaurantId());
			pstmt.setDouble(8, menu.getRatings());

			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Menu getMenu(int menuId) {
		PreparedStatement statement = null;
		ResultSet res = null;
		Menu menu = null;

		try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, menuId);
			res = statement.executeQuery();

			while (res.next()) {
				int menuItemId = res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailabel = res.getBoolean("isAvailable");
				int restaurantId = res.getInt("restaurantId");
				double ratings = res.getDouble("ratings");

				menu = new Menu(menuItemId, name, price, description, imagePath, isAvailabel, restaurantId, ratings);

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

		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		Statement createStatement = null;
		ResultSet res = null;
		Menu menu = null;

		ArrayList<Menu> menuList = new ArrayList<>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailabel = res.getBoolean("isAvailabel");
				int restaurantId = res.getInt("restaurantId");
				double ratings = res.getDouble("ratings");

				menu = new Menu(menuId, name, price, description, imagePath, isAvailabel, restaurantId, ratings);

				menuList.add(menu);

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

		return menuList;
	}

	@Override
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMenu(int menuId) {
		PreparedStatement pstmt = null;
		int i=0;

		try {
			pstmt = connection.prepareStatement(DELETE_QUERY);
			
			pstmt.setInt(1, menuId);
			
			 i = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public List<Menu> getMenuById(int restaurantId) {

		PreparedStatement psmt = null;
		ResultSet res = null;
		Menu menu = null;

		ArrayList<Menu> menuList = new ArrayList<>();
		try {
			psmt = connection.prepareStatement(SELECT_BY_ID);
			psmt.setInt(1, restaurantId);

			res = psmt.executeQuery();

			while (res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailable = res.getBoolean("isAvailable");
				double ratings = res.getDouble("ratings");

				menu = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);

				menuList.add(menu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuList;

	}

	public List<Menu> searchMenu(int rid, String query) {
		PreparedStatement statement = null;
		ResultSet res = null;
		Menu menu = null;

		ArrayList<Menu> menuList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(SEARCH_QUERY);

			// Set the parameters for the query (search terms with wildcards)
			statement.setInt(1, rid); // For menu starting with the query
			statement.setString(2, "%" + query + "%"); // For menu containing the query

			res = statement.executeQuery();

			while (res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				boolean isAvailabel = res.getBoolean("isAvailabel");
				int restaurantId = res.getInt("restaurantId");
				double ratings = res.getDouble("ratings");

				menu = new Menu(menuId, name, price, description, imagePath, isAvailabel, restaurantId, ratings);

				menuList.add(menu);

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

		return menuList;

	}

	@Override
	public List<Menu> getMenuByMenuId(int menuId) {
		
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		
		ArrayList<Menu> menuList = new ArrayList();
		try {
			pstmt= connection.prepareStatement(SELECT_MENU_BY_MENUID);
			pstmt.setInt(1, menuId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String imagePath = rs.getString("imagePath");
				
				Menu menu = new Menu();
				menu.setImagePath(imagePath);
				
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return menuList;
	}

}
