package com.bionic.edu.enums;

public enum Status {

	KITCHEN_DONE("kitchen_done"), NO_KITCHEN_DONE("no_kitchen_done"), READY_FOR_SHIPMENT(
			"redy_for_shipment"), DELIVERING("delivering"), DELIVERED(
			"delivered"), COMPLETELY_NOT_DONE("completely_not_done");

	private String status;

	Status(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
