package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;

public interface DishOrderService {

	public void save(DishOrder order, List<OrderItem> orderItems);

	public List<DishOrder> findAll();

	public void remove(int id);
	
	public DishOrder findById(int id);
	
	public void update(DishOrder dishOrder);
	
	public void changeOrderStatusIfAllDishesInOrderAreKitchenDone(DishOrder dishOrder);
}
