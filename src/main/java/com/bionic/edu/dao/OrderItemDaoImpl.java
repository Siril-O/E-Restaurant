package com.bionic.edu.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.extra.ReportByCategories;
import com.bionic.edu.extra.ReportByDays;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void updateStaus(int id, boolean status) {

		OrderItem dishOrdered = em.find(OrderItem.class, id);

		if (dishOrdered != null) {
			dishOrdered.setStatus(status);
		}
	}

	@Override
	public List<ReportByDays> getReportByDays(Date startDate, Date endDate) {

		String txt = "SELECT new com.bionic.edu.extra.ReportByDays(o.date, COUNT(o.id), SUM(d.PRICE))"
				+ "  FROM Order o, DishOrdered d WHERE  (o.date BETWEEN "
				+ ":startDate AND :endDate ) AND o.id = d.orderId   GROUP BY o.date";

		TypedQuery<ReportByDays> query = em.createQuery(txt, ReportByDays.class);
		query.setParameter("startDate", startDate);
		query.setParameter("startDate", startDate);

		return query.getResultList();

	}

	@Override
	public List<ReportByCategories> getReportByCategories(Date startDate, Date endDate) {
		String txt = "SELECT new com.bionic.edu.extra.ReportByCategories(c.category COUNT(o.id), SUM(do.PRICE))"
				+ "  FROM Order o, DishOrdered do , DISH d , DISHCATEGORY c WHERE  (o.date BETWEEN "
				+ ":startDate AND :endDate ) AND o.id = do.orderId AND do.dihsId = d.id"
				+ " AND d.id = c.id  GROUP BY c.category";

		TypedQuery<ReportByCategories> query = em.createQuery(txt, ReportByCategories.class);
		query.setParameter("startDate", startDate);
		query.setParameter("startDate", startDate);

		return query.getResultList();
	}

}
