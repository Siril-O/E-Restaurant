package com.bionic.edu.mbeans;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.service.DishCategoryService;
import com.bionic.edu.service.DishService;
import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;

@Named
@Scope("session")
public class MenuListBean {

	@Inject
	@Named(value = "dishServiceImpl")
	private DishService dishService;

	@Inject
	private DishCategoryService categoryService;

	private Map<Dish, Integer> dishes;
	private List<DishCategory> categories;
	private DishCategory category;

	public MenuListBean() {
		super();
	}

	public String refreshDishesByCategoryList(String id) {
		category = categoryService.find(Integer.valueOf(id));
		List<Dish> dishesList = dishService.findByCategoryInMenu(category);

		dishes = new LinkedHashMap<>();

		for (Dish d : dishesList) {
			dishes.put(d, 1);
		}
		return "menu";
	}

	public void refreshCategoryList() {
		categories = categoryService.findAll();
		System.out.println(Arrays.toString(categories.toArray()));
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

	/**
	 * @return the category
	 */
	public DishCategory getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(DishCategory category) {
		this.category = category;
	}

	/**
	 * @return the dishes
	 */
	public Map<Dish, Integer> getDishes() {
		return dishes;
	}

	/**
	 * @param dishes
	 *            the dishes to set
	 */
	public void setDishes(Map<Dish, Integer> dishes) {
		this.dishes = dishes;
	}

}
