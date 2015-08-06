package com.bionic.edu.dao;

import java.sql.Date;
import java.util.List;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.enums.Status;
import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;

public interface OrderItemDao {

	public void update(OrderItem orderItem);

	public List<ReportByDays> getReportByDays(Date startDate, Date endDate);

	public List<ReportByCategories> getReportByCategories(Date startDate,
			Date endDate);

	List<OrderItem> findOrderItemsByOrderStatusAndDishType(Status status,
			boolean type);

	public OrderItem findById(int id);
}
