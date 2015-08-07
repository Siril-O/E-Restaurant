package com.bionic.edu.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.sql.Date;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.bionic.edu.enums.Status;

@NamedQueries({ @NamedQuery(name = "DishOrder.findOrdersByStatus",
						query = "SELECT o FROM DishOrder o WHERE o.status=:status ORDER BY o.ordertime ASC"),
				@NamedQuery(name = "DishOrder.findOrdersByStatuses",
						query = "SELECT o FROM DishOrder o WHERE o.status IN (:status1 , :status2) ORDER BY o.ordertime ASC"),})

@Entity
public class DishOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ORDERTIME")
	private Time ordertime;

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

	public DishOrder(String userName, String deliveryAddress) {
		super();
		this.id = 0;
		this.ordertime = Time.valueOf(LocalTime.now());
		this.date = Date.valueOf(LocalDate.now());
		this.userName = userName;
		this.deliveryAddress = deliveryAddress;
		this.status = Status.COMPLETELY_NOT_DONE;
		this.user = null;
	}

	public DishOrder(String deliveryAddress, Customer user) {
		super();
		this.id = 0;
		this.ordertime = Time.valueOf(LocalTime.now());
		this.date = Date.valueOf(LocalDate.now());
		this.userName = user.getName();
		this.deliveryAddress = deliveryAddress;
		this.status = Status.COMPLETELY_NOT_DONE;
		this.user = user;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((deliveryAddress == null) ? 0 : deliveryAddress.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((ordertime == null) ? 0 : ordertime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		DishOrder other = (DishOrder) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deliveryAddress == null) {
			if (other.deliveryAddress != null)
				return false;
		} else if (!deliveryAddress.equals(other.deliveryAddress))
			return false;
		if (id != other.id)
			return false;
		if (ordertime == null) {
			if (other.ordertime != null)
				return false;
		} else if (!ordertime.equals(other.ordertime))
			return false;
		if (status != other.status)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
