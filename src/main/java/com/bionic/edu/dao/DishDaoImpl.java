package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.enums.Status;

@Repository
public class DishDaoImpl implements DishDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Dish> findByCategory(DishCategory category) {
		TypedQuery<Dish> query = em
				.createQuery("SELECT d FROM Dish d WHERE d.categoryId = "
						+ category.getId(), Dish.class);
		return query.getResultList();
	}

	@Override
	public void create(Dish dish) {
		if (dish != null) {
			em.persist(dish);
		}
	}

	@Override
	public void update(int id, Dish newDish) {
		Dish dish = em.find(Dish.class, id);
		if (dish != null) {
			String name = newDish.getName();
			if (name != null) {
				dish.setName(name);
			}
			double price = newDish.getPrice();
			if (price != 0) {
				dish.setPrice(price);
			}
			boolean dishtype = newDish.isDishtype();
			if (name != null) {
				dish.setDishtype(dishtype);
			}
			DishCategory category = newDish.getCategory();
			if (category != null) {
				dish.setCategory(category);
			}

		}
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
		TypedQuery<Dish> query = em.createQuery(
				"SELECT d FROM Dish d,Order o, DishOrdered c  WHERE d.type = "
						+ type + " AND o.id=c.orderId"
						+ " AND d.id=c.dishId AND o.statusId in"
						+ Status.COMPLETELY_NOT_DONE + " ORDER BY o.time ASC",
				Dish.class);
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
		TypedQuery<Dish> query = em.createQuery("SELECT d FROM Dish d",
				Dish.class);
		return query.getResultList();
	}

	@Override
	public Dish findById(int id) {
		return em.find(Dish.class, id);
	}

}
