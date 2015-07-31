package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.entities.Dish;

public interface DishDao {

	public void create(Dish dish);

	public void update(int id, String name, double price, DishCategory category,
			boolean dishtype, boolean menuitem);

	public void remove(int id);
	
	public void changeMenuAccessory(int id);
	
	public List<Dish> findByCategoryInMenu(DishCategory category);

	public List<Dish> findOrderedDishByType(boolean type);
	
	public List<Dish> findAll();
	
	public Dish findById(int id);

}
