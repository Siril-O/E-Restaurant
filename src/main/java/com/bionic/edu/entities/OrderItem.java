package com.bionic.edu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "orderId")
	private DishOrder dishOrder;
	@ManyToOne
	@JoinColumn(name = "dishId")
	private Dish dish;

	private boolean status;// done or not done
	private double price;

	public OrderItem() {
		super();
	}

	public OrderItem(int id, DishOrder dishOrder, Dish dish, boolean status,
			double price) {
		super();
		this.id = id;
		this.dishOrder = dishOrder;
		this.dish = dish;
		this.status = status;
		this.price = price;
	}

	public OrderItem(int id, DishOrder dishOrder, Dish dish) {
		super();
		this.id = id;
		this.dishOrder = dishOrder;
		this.dish = dish;
		this.status = false;
		this.price = dish.getPrice();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dishOrder
	 */
	public DishOrder getDishOrder() {
		return dishOrder;
	}

	/**
	 * @param dishOrder
	 *            the dishOrder to set
	 */
	public void setDishOrder(DishOrder dishOrder) {
		this.dishOrder = dishOrder;
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

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", dishOrder_ID = " + dishOrder.getId()
				+ ", dish=" + dish + ", status="
				+ (status ? "Order done" : "Order not done") + ", price="
				+ price + "]";
	}

}
