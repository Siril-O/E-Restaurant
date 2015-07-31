package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;

public interface DishOrderDao {

	public void updateStatus(int id, Status status);

	public void save(DishOrder order, List<OrderItem> dishesOrdered);

	public List<DishOrder> findAll();

	public List<DishOrder> findAllOrdersForDelivery();

	public List<DishOrder> findAllOrdersForDeliveryByStatus(Status status);

	public void remove(int id);

}
