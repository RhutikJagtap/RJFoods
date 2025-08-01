package com.rjfoods.dao;

import java.util.List;

import com.rjfoods.model.User;

public interface UserDao {
	int addUser(User user);

	User getUser(int userId);

	List<User> getAllUser(); // return type list

	int updateUser(User user);

	int deleteUser(int userId);

	User getUser(String username);

	int UserIsLoggedIn(int userId, boolean b);

	int updateLastLogin(int userId);
	
	User getUserByemail(String email);

	User getLoginDetails(String userName);
	
	int updatePasswordByEmail(String email,String password);
	
	
	int updateUserAddress(int userId,String address);

}
