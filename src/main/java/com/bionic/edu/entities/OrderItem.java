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
	private DishOrder order;
	@ManyToOne
	@JoinColumn(name = "dishId")
	private Dish dish;

	private boolean status;// done or not done
	private double price;

	public OrderItem(int id, Dish dish, DishOrder order, boolean status,
			double price) {
		super();
		this.id = id;
		this.dish = dish;
		this.order = order;
		this.status = status;
		this.price = price;
	}

	public OrderItem() {
		super();
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
	 * @return the status
	 */
	public boolean getStatus() {
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

	
}
