package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;

public interface DishService {

	public void save(Dish dish);

	public void update(Dish dish);

	public void remove(int id);

	public List<Dish> findByCategoryInMenu(DishCategory category);
	
	public List<Dish> findByCategory(DishCategory category);
	
	public List<Dish> findAll();

	public Dish findById(int id);
	
	public void changeInMenuStatus(Dish dish);
}
