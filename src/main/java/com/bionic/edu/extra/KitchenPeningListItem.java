package com.bionic.edu.extra;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishOrder;

public class KitchenPeningListItem {

	private DishOrder order;
	private Dish dish;

	public KitchenPeningListItem() {
		super();
	}

	public KitchenPeningListItem(DishOrder order, Dish dish) {
		super();
		this.order = order;
		this.dish = dish;
	}

	/**
	 * @return the order
	 */
	public DishOrder getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(DishOrder order) {
		this.order = order;
	}

	/**
	 * @return the dish
	 */
	public Dish getDish() {
		return dish;
	}

	/**
	 * @param dish
	 *            the dish to set
	 */
	public void setDish(Dish dish) {
		this.dish = dish;
	}

	@Override
	public String toString() {
		return "KitchenPeningListItem [orderId : " + order.getId() + " Time : " + order.getOrdertime() + ", dish=" + dish.getName() + "]";
	}

}
