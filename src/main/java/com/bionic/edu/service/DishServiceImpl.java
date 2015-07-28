package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.DishDao;
import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;

@Named
public class DishServiceImpl implements DishService {

	@Inject
	@Named("dishDaoImpl")
	private DishDao dishDao;

	@Override
	public List<Dish> findByCategory(DishCategory category) {
		return dishDao.findByCategory(category);
	}

	@Override
	@Transactional
	public void create(Dish dish) {
		dishDao.create(dish);
	}

	@Override
	public void update(int id, Dish newDish) {
		dishDao.update(id, newDish);
	}

	@Override
	public void remove(int id) {
		dishDao.remove(id);
	}

	@Override
	public List<Dish> findOrderedDishByType(boolean type) {
		return dishDao.findOrderedDishByType(type);
	}

	@Override
	public List<Dish> findAll() {
		return dishDao.findAll();
	}

	@Override
	public Dish findById(int id) {
		return dishDao.findById(id);
	}

}
