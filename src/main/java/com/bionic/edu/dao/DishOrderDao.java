package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;

public interface DishOrderDao {

	public void update(DishOrder dishOrder);

	public void save(DishOrder order, List<OrderItem> dishesOrdered);
	
	public DishOrder findById(int id);

	public List<DishOrder> findAll();

	public List<DishOrder> findAllOrdersForDelivery();

	public List<DishOrder> findAllOrdersForDeliveryByStatus(Status status);

	public void remove(int id);

}
