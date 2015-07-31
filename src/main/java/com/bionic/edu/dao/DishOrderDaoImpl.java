package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;

@Repository
public class DishOrderDaoImpl implements DishOrderDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(DishOrder dishOrder, List<OrderItem> orderItems) {

		dishOrder.setOrderItems(orderItems);

		for (OrderItem dish : orderItems) {
			dish.setDishOrder(dishOrder);
		}
		em.persist(dishOrder);

	}

	@Override
	public List<DishOrder> findAllOrdersForDelivery() {

		TypedQuery<DishOrder> query = em.createQuery(
				"SELECT o FROM Order o WHERE o.statusId <> ("
						+ Status.DELIVERED + " OR "
						+ Status.COMPLETELY_NOT_DONE + ")", DishOrder.class);
		return query.getResultList();
	}

	@Override
	public void updateStatus(int id, Status status) {
		DishOrder order = em.find(DishOrder.class, id);
		if (order != null) {
			order.setStatus(status);
		}

	}

	@Override
	public List<DishOrder> findAllOrdersForDeliveryByStatus(Status status) {

		// TypedQuery<Order> query = em.createQuery(
		// "SELECT o FROM Order o WHERE o.statusId <> ("
		// + Status.DELIVERED + " OR "
		// + Status.COMPLETELY_NOT_DONE + ") AND o.statusId =" + status.getId()
		// , Order.class);
		// return query.getResultList();
		return null;
	}

	@Override
	public List<DishOrder> findAll() {
		TypedQuery<DishOrder> query = em.createQuery(
				"SELECT o FROM DishOrder o", DishOrder.class);
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		DishOrder order = em.find(DishOrder.class, id);
		if (order != null) {
			em.remove(order);
		}
	}
}
