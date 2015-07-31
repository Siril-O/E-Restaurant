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
	public List<Dish> findByCategoryInMenu(DishCategory category) {
		return dishDao.findByCategoryInMenu(category);
	}

	@Override
	@Transactional
	public void create(Dish dish) {
		dishDao.create(dish);
	}

	@Override
	@Transactional
	public void update(int id, String name, double price,
			DishCategory category, boolean dishtype, boolean menuitem) {
		dishDao.update(id, name, price, category, dishtype, menuitem);
	}

	@Override
	@Transactional
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
