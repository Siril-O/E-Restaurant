package com.bionic.edu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "OrderItem.findOrderItemsByOrderStatusAndDishType",
			query = "SELECT i FROM OrderItem i WHERE  i.dishOrder.status = :status AND"
					+ " i.dish.dishtype = :type AND i.status=:itemStatus ORDER BY i.dishOrder.ordertime ASC"),
	@NamedQuery(name = "OrderItem.getReportByDays",
			query = "SELECT new com.bionic.edu.extra.ReportByDays(i.dishOrder.date, COUNT(DISTINCT  i.dishOrder.id),"
					+ " SUM(i.price * i.quantity))  FROM OrderItem i WHERE i.dishOrder.date BETWEEN "
					+ ":startDate AND :endDate AND i.dishOrder.status = :status GROUP BY i.dishOrder.date"),
	@NamedQuery(name = "OrderItem.getReportByCategories",
			query = "SELECT new com.bionic.edu.extra.ReportByCategories(i.dish.category , COUNT(DISTINCT  i.dishOrder.id),"
							+ " SUM(i.price * i.quantity))  FROM OrderItem i WHERE i.dishOrder.date BETWEEN "
							+ ":startDate AND :endDate AND i.dishOrder.status = :status GROUP BY i.dish.category")})
			
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
	private int quantity;

	public OrderItem() {
		super();
	}

	public OrderItem(int id, DishOrder dishOrder, Dish dish, boolean status,
			double price, int quantity) {
		super();
		this.id = id;
		this.dishOrder = dishOrder;
		this.dish = dish;
		this.status = status;
		this.price = price;
		this.quantity = quantity;
	}

	public OrderItem(int id, DishOrder dishOrder, Dish dish, int quantity) {
		super();
		this.id = id;
		this.dishOrder = dishOrder;
		this.dish = dish;
		this.status = false;
		this.price = dish.getPrice();
		this.quantity = quantity;
	}

	public OrderItem(Dish dish, int quantity) {
		super();
		this.id = 0;
		this.dishOrder = null;
		this.dish = dish;
		this.status = false;
		this.price = dish.getPrice();
		this.quantity = quantity;
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

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dish == null) ? 0 : dish.hashCode());
		result = prime * result
				+ ((dishOrder == null) ? 0 : dishOrder.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantity;
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (dish == null) {
			if (other.dish != null)
				return false;
		} else if (!dish.equals(other.dish))
			return false;
		if (dishOrder == null) {
			if (other.dishOrder != null)
				return false;
		} else if (!dishOrder.equals(other.dishOrder))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", dishOrder=" + dishOrder.getId() + ", dish="
				+ dish + ", status=" + status + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}


}
