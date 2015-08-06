package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.OrderItem;

public interface OrderItemService {

	public List<OrderItem> findOrderItemsKitchenMadeDishesAndNotDoneOrders();

	public OrderItem findById(int id);

	public void update(OrderItem orderItem);
}
