package com.bionic.edu.extra;

import java.sql.Date;

public class ReportByDays {

	private Date orderDate;
	private Long orderQuantity;
	private Double totalSumm;

	public ReportByDays() {
		super();
	}

	public ReportByDays(Date orderDate, Long orderQuantity, Double totalSumm) {
		super();
		this.orderDate = orderDate;
		this.orderQuantity = orderQuantity;
		this.totalSumm = totalSumm;
	}


	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderQuantity
	 */
	public Long getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * @param orderQuantity the orderQuantity to set
	 */
	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	/**
	 * @return the totalSumm
	 */
	public Double getTotalSumm() {
		return totalSumm;
	}

	/**
	 * @param totalSumm the totalSumm to set
	 */
	public void setTotalSumm(Double totalSumm) {
		this.totalSumm = totalSumm;
	}

	@Override
	public String toString() {
		return "ReportByDays [orderDate=" + orderDate + ", orderQuantity="
				+ orderQuantity + ", totalSumm=" + totalSumm + "]";
	}

}
