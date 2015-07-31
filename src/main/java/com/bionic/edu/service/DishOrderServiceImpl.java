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
public class DishOrderServiceImpl implements DishOrderService {

	@Inject
	@Named("dishOrderDaoImpl")
	private DishOrderDao orderDao;

	public DishOrderServiceImpl() {
		super();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(DishOrder order, List<OrderItem> orderItems) {
		orderDao.save(order, orderItems);
	}

	@Override
	public List<DishOrder> findAll() {
		return orderDao.findAll();
	}

	@Override
	@Transactional
	public void remove(int id) {
		orderDao.remove(id);
	}
}
