package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.DishCategory;

public interface DishCategoryDao {

	public List<DishCategory> findAll();
	
	public void save(DishCategory category);
	
	public DishCategory find(int id);
}
