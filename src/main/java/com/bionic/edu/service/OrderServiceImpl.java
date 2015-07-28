package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.DishOrderDao;
import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;

@Named
public class OrderServiceImpl implements OrderService {

	@Inject
	@Named("orderDaoImpl")
	private DishOrderDao orderDao;

	public OrderServiceImpl() {
		super();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(DishOrder order, List<OrderItem> dishesOrdered) {
		orderDao.save(order, dishesOrdered);
	}
}
