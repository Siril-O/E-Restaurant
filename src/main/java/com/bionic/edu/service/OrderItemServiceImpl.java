package com.bionic.edu.service;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.OrderItemDao;
import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.enums.Status;
import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;

@Named
public class OrderItemServiceImpl implements OrderItemService {

	@Inject
	OrderItemDao orderItemDao;

	@Override
	public List<OrderItem> findOrderItemsKitchenMadeDishesAndNotDoneOrders() {
		return orderItemDao.findOrderItemsByOrderStatusAndDishType(
				Status.COMPLETELY_NOT_DONE, true);
	}

	@Override
	public OrderItem findById(int id) {
		return orderItemDao.findById(id);
	}

	@Override
	@Transactional
	public void update(OrderItem orderItem) {
		orderItemDao.update(orderItem);
	}

	@Override
	public List<ReportByCategories> getReportByCategories(Date startDate,
			Date endDate) {
		return orderItemDao.getReportByCategories(startDate, endDate);
	}

	@Override
	public List<ReportByDays> getReportByDays(Date startDate, Date endDate) {
		return orderItemDao.getReportByDays(startDate, endDate);
	}

}
