package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;

public interface DishService {

	public void create(Dish dish);

	public void update(int id, Dish newDish);

	public void remove(int id);

	public List<Dish> findByCategory(DishCategory category);

	public List<Dish> findOrderedDishByType(boolean type);

	public List<Dish> findAll();

	public Dish findById(int id);
}
