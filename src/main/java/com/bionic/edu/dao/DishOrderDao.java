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

	public List<DishOrder> findOrdersByStatus(Status status);
	
	public List<DishOrder> findOrdersByStatuses(Status status1, Status status2);

	public void remove(int id);

}
