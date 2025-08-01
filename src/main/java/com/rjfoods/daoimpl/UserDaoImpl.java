package com.rjfoods.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.rjfoods.dao.UserDao;
import com.rjfoods.model.Security;
import com.rjfoods.model.User;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	final static String INSERT_QUERY = "INSERT into user(userId,name,email,  phoneNo,  address,  userName,  password,role,createdDate,lastLogin,status) values(?,?,?,?,?,?,?,?,?,?,?)";
	final static String SELECT_QUERY = "SELECT *from user where userId=?";
	final static String SELECT_ALL_QUERY = "SELECT *from user";
	final static String UPDATE_QUERY = "UPDATE user set name=?,email=?,  phoneNo=?,  address=?,  userName=?,  password=? where userId=?";
	final static String DELETE_QUERY = "DELETE from user where userId=?";

	final static String SELECT_BY_USERNAME = "SELECT *from user where userName=?";

	static final String UPDATE_PASSWORD = "UPDATE `user` SET  `password`=? WHERE `email`=? ";

	
	final static String updateStatusQuery = "UPDATE user SET status = ? WHERE userId = ?";

	final static String UPDATE_LAST_LOGIN_QUERY = "UPDATE user SET lastLogin = ? WHERE userId = ?";

	final static String SELECT_USER_BY_EMAIL="SELECT *from user where email=? ";
	
	static final String SELECT_LOGINDEDTAILS= "SELECT * FROM `user` WHERE `userName`=?";

	 static final String UPDATE_USER_ADDRESS = "UPDATE user SET address=? where userId=?";

	
	// constructor
	public UserDaoImpl() {
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
	public int addUser(User user) {

		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			pstmt = connection.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhoneNo());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getUserName());
			pstmt.setString(7, user.getPassword());
			pstmt.setString(8, user.getRole());

//			        pstmt.setDate(9, Date.valueOf(LocalDate.now())); // current date without time
//			        pstmt.setDate(10, Date.valueOf(LocalDate.now()));
//			        
			pstmt.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now())); // Set current date and time for createdDate
			pstmt.setTimestamp(10, Timestamp.valueOf(LocalDateTime.now())); // Set current date and time for lastLogin
			pstmt.setBoolean(11, user.isStatus());

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
	public User getUser(int userId) {
		PreparedStatement statement = null;
		ResultSet res = null;
		User user = null;

		try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, userId);
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String username = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
//				LocalDateTime lastLogin = res.("lastLogin");
				Date lastLogin = res.getDate("lastLogin");
				boolean status = res.getBoolean("status");

				user = new User(id, name, email, phoneNo, address, username, password, role, createdDate, lastLogin,
						status);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		Statement createStatement = null;
		ResultSet res = null;
		User user = null;

		ArrayList<User> userList = new ArrayList<>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String username = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
//				LocalDateTime lastLogin = res.("lastLogin");
				Date lastLogin = res.getDate("lastLogin");
				boolean status = res.getBoolean("status");

				user = new User(id, name, email, phoneNo, address, username, password, role, createdDate, lastLogin,
						status);

				userList.add(user);

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

		return userList;

	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public int updatePasswordByEmail(String email, String password) {
		PreparedStatement pstmt=null;
		
		int rs=0;
		
		 try {
			pstmt = connection.prepareStatement(UPDATE_PASSWORD);
			
			pstmt.setString(1,password );
			pstmt.setString(2, email);

			
			 rs = pstmt.executeUpdate();

			 if (rs>0) {
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public int deleteUser(int userId) {

		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			pstmt = connection.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, userId);
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
	public User getUser(String username) {
		PreparedStatement statement = null;
		ResultSet res = null;
		User user = null;

		try {
			statement = connection.prepareStatement(SELECT_BY_USERNAME);
			statement.setString(1, username);
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String uname = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
//				LocalDateTime lastLogin = res.("lastLogin");
				Date lastLogin = res.getDate("lastLogin");
				boolean status = res.getBoolean("status");

				user = new User(id, name, email, phoneNo, address, username, password, role, createdDate, lastLogin,
						status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int UserIsLoggedIn(int userId, boolean status) {

		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			pstmt = connection.prepareStatement(updateStatusQuery);

			pstmt.setBoolean(1, status);
			pstmt.setInt(2, userId);

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
	public int updateLastLogin(int userId) {

		PreparedStatement pstmt = null;
		int rs = 0;

		try {
			pstmt = connection.prepareStatement(UPDATE_LAST_LOGIN_QUERY);

			// Set the current timestamp for lastLogin
			pstmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now())); // Current date and time

			// Set the userId to identify the user
			pstmt.setInt(2, userId);

			rs = pstmt.executeUpdate();

			if (rs > 0) {
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public User getUserByemail(String emailId) {
		
		PreparedStatement statement = null;
		ResultSet res = null;
		User user = null;

		try {
			statement = connection.prepareStatement(SELECT_USER_BY_EMAIL);
			statement.setString(1, emailId);
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String uname = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
//				LocalDateTime lastLogin = res.("lastLogin");
				Date lastLogin = res.getDate("lastLogin");
				boolean status = res.getBoolean("status");

				user = new User(id, name, email, phoneNo, address, uname, password, role, createdDate, lastLogin,
						status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	

	@Override
	public User getLoginDetails(String userName) {
		
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		User user = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_LOGINDEDTAILS);
			prepareStatement.setString(1, userName);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				String phoneNo = res.getString("phoneNo");
				String address = res.getString("address");
				String uname = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
//				LocalDateTime lastLogin = res.("lastLogin");
				Date lastLogin = res.getDate("lastLogin");
				boolean status = res.getBoolean("status");

				String decryptedUsername=Security.callDecryption(res.getString("userName"));
				user = new User(id, name, email, phoneNo, address, uname, password, role, createdDate, lastLogin,
						status);
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

		return user;
		
	}

	@Override
	public int updateUserAddress(int userId, String address) {
		PreparedStatement pstmt =null;	
		
		 try {
			pstmt = connection.prepareStatement(UPDATE_USER_ADDRESS);
			
			pstmt.setString(1, address);
			pstmt.setInt(2, userId);
			
			int i = pstmt.executeUpdate();
			
			if (i>0) {
				return i;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	
}
