package com.bionic.edu.service;

import java.sql.Date;
import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;

public interface OrderItemService {

	public List<OrderItem> findOrderItemsKitchenMadeDishesAndNotDoneOrders();

	public OrderItem findById(int id);

	public void update(OrderItem orderItem);

	public List<ReportByCategories> getReportByCategories(Date startDate,
			Date endDate);

	public List<ReportByDays> getReportByDays(Date startDate, Date endDate);
}
