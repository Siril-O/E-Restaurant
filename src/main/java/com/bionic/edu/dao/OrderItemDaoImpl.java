package com.bionic.edu.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.enums.Status;
import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void update(OrderItem orderItem) {
		if (orderItem != null && orderItem.getId() != 0) {
			em.merge(orderItem);
		}

	}

	@Override
	public List<ReportByDays> getReportByDays(Date startDate, Date endDate) {
		TypedQuery<ReportByDays> query = em.createNamedQuery(
				"OrderItem.getReportByDays", ReportByDays.class);
		return query.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.setParameter("status", Status.DELIVERED).getResultList();
	}

	@Override
	public List<ReportByCategories> getReportByCategories(Date startDate,
			Date endDate) {
		TypedQuery<ReportByCategories> query = em.createNamedQuery(
				"OrderItem.getReportByCategories", ReportByCategories.class);
		return query.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.setParameter("status", Status.DELIVERED).getResultList();
	}

	@Override
	public List<OrderItem> findOrderItemsByOrderStatusAndDishType(
			Status status, boolean type) {
		TypedQuery<OrderItem> query = em.createNamedQuery(
				"OrderItem.findOrderItemsByOrderStatusAndDishType",
				OrderItem.class);
		query.setParameter("status", status).setParameter("type", type)
				.setParameter("itemStatus", false);
		return query.getResultList();
	}

	@Override
	public OrderItem findById(int id) {
		return em.find(OrderItem.class, id);
	}

}
