package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public List<DishOrder> findOrdersByStatus(Status status) {

		TypedQuery<DishOrder> query = em.createNamedQuery(
				"DishOrder.findOrdersByStatus",
				DishOrder.class);
		return query.setParameter("status", status).getResultList();
	}
	
	@Override
	public List<DishOrder> findOrdersByStatuses(Status status1, Status status2) {
		TypedQuery<DishOrder> query = em.createNamedQuery(
				"DishOrder.findOrdersByStatuses",
				DishOrder.class);
		return query.setParameter("status1", status1).setParameter("status2", status2).getResultList();
	}

	@Override
	public void update(DishOrder dishOrder) {
		if (dishOrder != null && dishOrder.getId() != 0) {
			em.merge(dishOrder);
		}
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

	@Override
	public DishOrder findById(int id) {
		return em.find(DishOrder.class, id);
	}

}
