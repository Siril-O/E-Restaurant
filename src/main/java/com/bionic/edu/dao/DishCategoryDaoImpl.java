package com.bionic.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.DishCategory;

@Repository
public class DishCategoryDaoImpl implements DishCategoryDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<DishCategory> findAll() {
		TypedQuery<DishCategory> query = em.createQuery(
				"SELECT c FROM DishCategory c", DishCategory.class);
		return query.getResultList();
	}

	@Override
	public void create(DishCategory category) {

		if (category != null) {
			em.persist(category);
		}
	}

	@Override
	public DishCategory find(int id) {
		return em.find(DishCategory.class, id);
	}

}
