package com.bionic.edu.mbeans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.service.DishOrderService;
import com.bionic.edu.service.OrderItemService;

@Named
@Scope("session")
public class KitchenPendingListBean {

	@Inject
	private OrderItemService orderItemService;
	@Inject
	private DishOrderService orderService;
	private List<OrderItem> orderedItems;

	public void refreshPendingList() {
		orderedItems = orderItemService
				.findOrderItemsKitchenMadeDishesAndNotDoneOrders();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void markDishAsDone(String itemId) {

		OrderItem orderItem = orderItemService.findById(Integer
				.parseInt(itemId));
		orderItem.setStatus(true);
		orderItemService.update(orderItem);
		orderService.changeOrderStatusIfAllDishesInOrderAreKitchenDone(orderItem.getDishOrder());
		refreshPendingList();
	}

	/**
	 * @return the orderedItems
	 */
	public List<OrderItem> getOrderedItems() {
		return orderedItems;
	}

	/**
	 * @param orderedItems
	 *            the orderedItems to set
	 */
	public void setOrderedItems(List<OrderItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

}
