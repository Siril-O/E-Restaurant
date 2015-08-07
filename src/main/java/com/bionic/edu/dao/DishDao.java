package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.entities.Dish;

public interface DishDao {

	public void save(Dish dish);

	public void update(Dish dish);

	public void remove(int id);

	public List<Dish> findByCategory(DishCategory category);

	public List<Dish> findByCategoryInMenu(DishCategory category);

	public List<Dish> findAll();

	public Dish findById(int id);

}
