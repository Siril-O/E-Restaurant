package com.bionic.edu.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bionic.edu.enums.Status;

@Entity
public class DishOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Time ordertime;
	private Date date;
	private String userName;
	private String deliveryAddress;
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	private Collection<OrderItem> dishOrdered;

	public DishOrder() {
		super();
	}

	public DishOrder(int id, Time ordertime, Date date, String userName,
			String deliveryAddress, Status status, Customer user) {
		super();
		this.id = id;
		this.ordertime = ordertime;
		this.date = date;
		this.userName = userName;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.user = user;
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
	 * @return the ordertime
	 */
	public Time getOrdertime() {
		return ordertime;
	}

	/**
	 * @param ordertime
	 *            the ordertime to set
	 */
	public void setOrdertime(Time ordertime) {
		this.ordertime = ordertime;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress
	 *            the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the user
	 */
	public Customer getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(Customer user) {
		this.user = user;
	}

	/**
	 * @return the dishOrdered
	 */
	public Collection<OrderItem> getDishOrdered() {
		return dishOrdered;
	}

	/**
	 * @param dishOrdered
	 *            the dishOrdered to set
	 */
	public void setDishOrdered(Collection<OrderItem> dishOrdered) {
		this.dishOrdered = dishOrdered;
	}

}
