package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.enums.Status;
import com.bionic.edu.extra.KitchenPeningListItem;

public interface DishService {

	public void create(Dish dish);

	public void update(Dish dish);

	public void remove(int id);

	public List<Dish> findByCategoryInMenu(DishCategory category);

	public List<Dish> findOrderedDishByType(boolean type);
	
	public List<KitchenPeningListItem> findDishAndOrdersByOrderStatusAndDishType(Status status,boolean type);

	public List<Dish> findAll();

	public Dish findById(int id);
	
	public void changeInMenuStatus(Dish dish);
}
