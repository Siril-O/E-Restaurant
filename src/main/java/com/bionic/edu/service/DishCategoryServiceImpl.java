package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.DishCategoryDao;
import com.bionic.edu.entities.DishCategory;

@Named
public class DishCategoryServiceImpl implements DishCategoryService {

	@Inject
	@Named("dishCategoryDaoImpl")
	private DishCategoryDao dishCategoryDao;

	@Override
	public List<DishCategory> findAll() {

		return dishCategoryDao.findAll();
	}

	@Override
	@Transactional
	public void create(DishCategory category) {
		dishCategoryDao.create(category);
	}

	@Override
	public DishCategory find(int id) {
		return dishCategoryDao.find(id);
	}

}
