package com.bionic.edu.entities;


import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bionic.edu.enums.Status;

@Entity
public class DishOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ORDERTIME")
	private Time ordertime;

	@Column(name = "DATE")
	@Temporal(value = TemporalType.DATE)
	private Date date;

	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "DELIVERYADDRESS")
	private String deliveryAddress;

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer user;

	@OneToMany(mappedBy = "dishOrder", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE })
	private Collection<OrderItem> orderItems;

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

	public DishOrder(int id, Time ordertime, Date date, String userName,
			String deliveryAddress, Status status, Customer user,
			Collection<OrderItem> orderItems) {
		super();
		this.id = id;
		this.ordertime = ordertime;
		this.date = date;
		this.userName = userName;
		this.deliveryAddress = deliveryAddress;
		this.status = status;
		this.user = user;
		this.orderItems = orderItems;
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
	 * @return the orderItems
	 */
	public Collection<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems
	 *            the orderItems to set
	 */
	public void setOrderItems(Collection<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "DishOrder [id=" + id + ", ordertime=" + ordertime + ", date="
				+ date + ", userName=" + userName + ", deliveryAddress="
				+ deliveryAddress + ", status=" + status + ", user=" + user
				+ ", dishOrdered=" + orderItems + "]";
	}

}
