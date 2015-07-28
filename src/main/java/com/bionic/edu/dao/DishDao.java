package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.entities.Dish;

public interface DishDao {

	public void create(Dish dish);

	public void update(int id, Dish newDish);

	public void remove(int id);
	
	public void changeMenuAccessory(int id);
	
	public List<Dish> findByCategory(DishCategory category);

	public List<Dish> findOrderedDishByType(boolean type);
	
	public List<Dish> findAll();
	
	public Dish findById(int id);

}
