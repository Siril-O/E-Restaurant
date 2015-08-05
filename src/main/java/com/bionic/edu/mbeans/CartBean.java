package com.bionic.edu.mbeans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.service.DishService;

@Named
@Scope("session")
public class CartBean {

	@Inject
	private DishService dishService;

	private List<OrderItem> orderItems = new LinkedList<>();
	private double totalPrice;

	public CartBean() {
		super();
		totalPrice = 0;
	}

	public void addOrderItem(String dishId, String quantity) {

		Dish dish = dishService.findById(Integer.parseInt(dishId));
		int dishQuantity = Integer.parseInt(quantity);

		OrderItem item = new OrderItem(dish, dishQuantity);

		if (orderItems.contains(item)) {
			int i = orderItems.indexOf(item);
			int q = orderItems.get(i).getQuantity() + dishQuantity;
			orderItems.get(i).setQuantity(q);
		} else {
			orderItems.add(item);
		}

		calculateTotalPrice();
	}

	public void removeItem(String dishId) {

		Dish dish = dishService.findById(Integer.parseInt(dishId));
		for (OrderItem item : orderItems) {
			if (item.getDish().equals(dish)) {
				orderItems.remove(item);
			}
		}
	}

	private void calculateTotalPrice() {
		double sum = 0;
		for (OrderItem item : orderItems) {
			sum += item.getPrice() * item.getQuantity();
		}
		totalPrice = new BigDecimal(sum).setScale(2, RoundingMode.CEILING)
				.doubleValue();
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems
	 *            the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
