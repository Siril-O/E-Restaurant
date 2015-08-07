package com.bionic.edu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
		@NamedQuery(name = "Dish.findByCategoryInMenu", query = "SELECT d FROM Dish d WHERE d.category=:category AND d.menuitem=true"),
		@NamedQuery(name = "Dish.findByCategory", query = "SELECT d FROM Dish d WHERE d.category=:category"),
		@NamedQuery(name = "Dish.FindAll", query = "SELECT d FROM Dish d")})
@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;

	@OneToOne
	@JoinColumn(name = "CATEGORYID")
	private DishCategory category;
	private boolean dishtype;
	private boolean menuitem;

	public Dish() {
		super();
	}

	public Dish(int id, String name, double price, DishCategory category,
			boolean dishtype, boolean menuitem) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.dishtype = dishtype;
		this.menuitem = menuitem;
	}

	/**
	 * @return the menuitem
	 */
	public boolean isMenuitem() {
		return menuitem;
	}

	/**
	 * @param menuitem
	 *            the menuitem to set
	 */
	public void setMenuitem(boolean menuitem) {
		this.menuitem = menuitem;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the dishtype
	 */
	public boolean isDishtype() {
		return dishtype;
	}

	/**
	 * @param dishtype
	 *            the dishtype to set
	 */
	public void setDishtype(boolean dishtype) {
		this.dishtype = dishtype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", dishtype ="
				+ (dishtype ? "Kitchen_Made" : "Non_KitchenMade")
				+ ", menuitem="
				+ (menuitem ? " In the menu" : "Not in the menu") + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + (dishtype ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (menuitem ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Dish other = (Dish) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dishtype != other.dishtype)
			return false;
		if (id != other.id)
			return false;
		if (menuitem != other.menuitem)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
