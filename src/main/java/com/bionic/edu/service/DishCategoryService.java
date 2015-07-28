package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.DishCategory;

public interface DishCategoryService {

	public List<DishCategory> findAll();

	public void create(DishCategory category);

	public DishCategory find(int id);
}
