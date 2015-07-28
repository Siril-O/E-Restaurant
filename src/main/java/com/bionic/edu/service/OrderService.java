package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;

public interface OrderService {

	public void save(DishOrder order, List<OrderItem> dishesOrdered);
}
