package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;

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
	public List<Dish> findByCategory(DishCategory category) {
		TypedQuery<Dish> query = em.createNamedQuery("Dish.findByCategory",
				Dish.class);
		query.setParameter("category", category);
		return query.getResultList();
	}

	@Override
	public void save(Dish dish) {

		if (dish != null && dish.getId() == 0) {
			em.persist(dish);
		} else if (dish != null) {
			em.merge(dish);
		}
	}

	@Override
	@Transactional
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
	public List<Dish> findAll() {
		TypedQuery<Dish> query = em
				.createNamedQuery("Dish.FindAll", Dish.class);
		return query.getResultList();
	}

	@Override
	public Dish findById(int id) {
		return em.find(Dish.class, id);
	}


}
