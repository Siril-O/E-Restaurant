package com.bionic.edu.mbeans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;
import com.bionic.edu.service.DishOrderService;

@Named
@Scope("session")
public class PackerPendingListBean {


	@Inject
	private DishOrderService orderService;
	private List<DishOrder> orders;

	public void refreshPendingList() {
		orders = orderService.findOrdersByStatus(Status.KITCHEN_DONE);
	}

	public void markOrderAsReadyForShipment(String orderId) {
		DishOrder order = orderService.findById(Integer.parseInt(orderId));
		order.setStatus(Status.READY_FOR_SHIPMENT);
		orderService.update(order);
		refreshPendingList();
	}

	/**
	 * @return the orders
	 */
	public List<DishOrder> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<DishOrder> orders) {
		this.orders = orders;
	}

}
