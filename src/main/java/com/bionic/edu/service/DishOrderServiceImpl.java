package com.bionic.edu.service;

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
		
		boolean changeStatus = true;
		
		for (OrderItem item : dishOrder.getOrderItems()) {
			if (!item.isStatus()) {
				changeStatus = false;
				break;
			}
		}
		if(changeStatus){
			dishOrder.setStatus(Status.KITCHEN_DONE);
			orderDao.update(dishOrder);
		}
	}
}
