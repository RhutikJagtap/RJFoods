package com.rjfoods.dao;

import java.util.List;

import com.rjfoods.model.Menu;

public interface MenuDao {
	int addMenu(Menu menu);

	Menu getMenu(int menuId);

	List<Menu> getAllMenu(); // return type list

	int updateMenu(Menu menu);

	int deleteMenu(int menuId);

	List<Menu> getMenuById(int restaurantId);

	List<Menu> getMenuByMenuId(int menuId);

}
