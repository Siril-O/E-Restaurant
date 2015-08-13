package com.bionic.edu.mbeans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.enums.Status;
import com.bionic.edu.service.DishOrderService;

@Named
@Scope("session")
public class DeliveryPendingListBean {

	@Inject
	private DishOrderService orderService;
	private Map<DishOrder, String> orders = new LinkedHashMap<>();
	private static final String DELIVERING_LABEL = "Order Delivering";
	private static final String DELIVERED_LABEL = "Order Delivered";

	public void refreshPendingList() {
		List<DishOrder> orderList = orderService.findOrdersByStatuses(
				Status.READY_FOR_SHIPMENT, Status.DELIVERING);
		orders.clear();
		for (DishOrder order : orderList) {
			orders.put(	order, (order.getStatus() == Status.READY_FOR_SHIPMENT ? DELIVERING_LABEL
							: DELIVERED_LABEL));
		}
	}

	public void changeOrderStatus(String orderId) {
		DishOrder order = orderService.findById(Integer.parseInt(orderId));
		order.setStatus(order.getStatus() == Status.READY_FOR_SHIPMENT ? Status.DELIVERING
				: Status.DELIVERED);
		orderService.update(order);
		refreshPendingList();
	}

	/**
	 * @return the orders
	 */
	public Map<DishOrder, String> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(Map<DishOrder, String> orders) {
		this.orders = orders;
	}

}
