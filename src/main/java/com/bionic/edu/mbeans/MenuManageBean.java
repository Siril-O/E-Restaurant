package com.bionic.edu.mbeans;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.service.DishCategoryService;
import com.bionic.edu.service.DishService;

@Named
@Scope("session")
public class MenuManageBean {

	@Inject
	private DishCategoryService categoryService;
	@Inject
	private DishService dishService;

	private List<DishCategory> categories;
	private List<Dish> dishes;
	private DishCategory category;
	private Dish dish;
	private int categoryId;

	public void refreshCategoryList() {
		categories = categoryService.findAll();
		System.out.println(Arrays.toString(categories.toArray()));
	}

	public String refreshDishesByCategoryList(String categoryId) {

		category = categoryService.find(Integer.parseInt(categoryId));
		dishes = dishService.findByCategory(category);
		return "administerMenu";
	}

	public String editCategory(String categoryId) {
		category = categoryService.find(Integer.parseInt(categoryId));
		return "createDishCategory";
	}

	public String editDish(String dishId) {
		dish = dishService.findById(Integer.parseInt(dishId));
		return "createDish";
	}

	public String viewAddCategoryForm() {
		category = new DishCategory();
		return "createDishCategory";
	}

	public String viewAddDishForm() {
		dish = new Dish();
		return "createDish";
	}

	public String addCategory() {
		categoryService.save(category);
		return "administerMenuCategories";
	}

	public String addDish() {
		dish.setCategory(categoryService.find(categoryId));
		dishService.save(dish);
		return "administerMenuCategories";
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
	}

	public DishCategory getCategory() {
		return category;
	}

	public void setCategory(DishCategory category) {
		this.category = category;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
