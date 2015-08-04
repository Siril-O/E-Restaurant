package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.enums.Status;
import com.bionic.edu.extra.KitchenPeningListItem;

@Repository
public class DishDaoImpl implements DishDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Dish> findByCategoryInMenu(DishCategory category) {
		TypedQuery<Dish> query = em.createNamedQuery(
				"Dish.findByCategoryInMenu", Dish.class);
		query.setParameter("category", category);
		return query.getResultList();
	}

	@Override
	public void create(Dish dish) {
		if (dish != null) {
			em.persist(dish);
		}
	}

	@Override
	public void update(Dish dish) {
		em.merge(dish);
	}

	@Override
	public void remove(int id) {
		Dish dish = em.find(Dish.class, id);
		if (dish != null) {
			em.remove(dish);
		}
	}

	@Override
	public List<Dish> findOrderedDishByType(boolean type) { // kitchen made,
															// none kitchen-made
		TypedQuery<Dish> query = em
				.createQuery(
						"SELECT i.dish FROM OrderItem i WHERE  i.dishOrder.status = :status AND i.dish.dishtype = :type ",
						Dish.class);

		query.setParameter("status", Status.COMPLETELY_NOT_DONE).setParameter(
				"type", type);

		return query.getResultList();
	}

	@Override
	public void changeMenuAccessory(int id) {
		Dish dish = em.find(Dish.class, id);
		if (dish != null) {
			dish.setMenuitem(!dish.isMenuitem());
		}

	}

	@Override
	public List<Dish> findAll() {
		TypedQuery<Dish> query = em
				.createNamedQuery("Dish.FindAll", Dish.class);
		return query.getResultList();
	}

	@Override
	public Dish findById(int id) {
		return em.find(Dish.class, id);
	}

	@Override
	public List<KitchenPeningListItem> findDishAndOrdersByOrderStatusAndDishType(
			Status status, boolean type) {
		TypedQuery<KitchenPeningListItem> query = em.createNamedQuery(
				"Dish.findDishAndOrdersByOrderStatusAndDishType",
				KitchenPeningListItem.class);
		query.setParameter("status", status).setParameter("type", type);

		return query.getResultList();
	}

}
