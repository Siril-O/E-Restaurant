package com.bionic.edu.mbeans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.service.DishCategoryService;
import com.bionic.edu.service.DishService;
import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;

@Named
@Scope("request")
public class MenuListBean {

	@Inject
	@Named(value = "dishServiceImpl")
	private DishService dishService;

	@Inject
	private DishCategoryService categoryService;

	private List<Dish> dishes;
	private List<DishCategory> categories;

	public MenuListBean() {
		super();
	}

	public void refreshList() {
		dishes = dishService.findAll();
	}

	public void refreshCategoryList() {
		categories = categoryService.findAll();
	}

	/**
	 * @return the dishes
	 */
	public List<Dish> getDishes() {
		return dishes;
	}

	/**
	 * @param dishes
	 *            the dishes to set
	 */
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
		dishes.add(dishService.findById(1));
	}

	/**
	 * @return the categories
	 */
	public List<DishCategory> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(List<DishCategory> categories) {
		this.categories = categories;
	}

}
