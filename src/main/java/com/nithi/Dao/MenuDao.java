package com.nithi.Dao;

import java.util.List;

import com.nithi.entity.Menu;

public interface MenuDao {
	
	public List<Menu> getMenuItem();
	
	public void saveMenuItems(Menu menu);
	
	public void deleteItem(int id);

	public Menu getMenuById(int id);
	
	public List<Menu> searchItem(String itemName);

}
