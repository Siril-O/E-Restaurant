package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;

public interface DishOrderService {

	public void save(DishOrder order, List<OrderItem> orderItems);

	public List<DishOrder> findAll();

	public void remove(int id);
	
	public void updateStatus(int id, Status status);

}
