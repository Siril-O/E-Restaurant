package com.bionic.edu.extra;

import com.bionic.edu.entities.DishCategory;

public class ReportByCategories {

	private DishCategory category;
	private Long orderQuantity;
	private Double totalSumm;

	public ReportByCategories(DishCategory category, Long orderQuantity,

	Double totalSumm) {
		super();
		this.category = category;
		this.orderQuantity = orderQuantity;
		this.totalSumm = totalSumm;
	}

	public ReportByCategories() {
		super();
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
	 * @return the orderQuantity
	 */
	public Long getOrderQuantity() {
		return orderQuantity;
	}

	/**
	 * @param orderQuantity
	 *            the orderQuantity to set
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
	 * @param totalSumm
	 *            the totalSumm to set
	 */
	public void setTotalSumm(Double totalSumm) {
		this.totalSumm = totalSumm;
	}

}
