package com.bionic.edu.service;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.DishOrderDao;
import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;

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

		for (OrderItem item : orderItems) {
			if (!item.getDish().isDishtype()) {
				item.setStatus(true);
			}
		}
		if (checkIfDishesInOrderAreKitchenDone(order, orderItems)) {
			order.setStatus(Status.KITCHEN_DONE);
		}
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

	@Override
	public DishOrder findById(int id) {
		return orderDao.findById(id);
	}

	@Override
	@Transactional
	public void update(DishOrder dishOrder) {
		orderDao.update(dishOrder);
	}

	@Override
	public void changeOrderStatusIfAllDishesInOrderAreKitchenDone(
			DishOrder dishOrder) {

		if (checkIfDishesInOrderAreKitchenDone(dishOrder,
				dishOrder.getOrderItems())) {
			dishOrder.setStatus(Status.KITCHEN_DONE);
			orderDao.update(dishOrder);
		}
	}

	private boolean checkIfDishesInOrderAreKitchenDone(DishOrder dishOrder,
			Collection<OrderItem> orderItems) {

		for (OrderItem item : orderItems) {
			if (!item.isStatus()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<DishOrder> findOrdersByStatus(Status status) {
		return orderDao.findOrdersByStatus(status);

	}

	@Override
	public List<DishOrder> findOrdersByStatuses(Status status1, Status status2) {
		return orderDao.findOrdersByStatuses(status1, status2);
	}
}
