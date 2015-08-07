package com.bionic.edu;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.dao.DishOrderDao;
import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;
import com.bionic.edu.enums.Status;
import com.bionic.edu.service.DishCategoryService;
import com.bionic.edu.service.DishOrderService;
import com.bionic.edu.service.DishService;
import com.bionic.edu.service.CustomerService;
import com.bionic.edu.service.DishServiceImpl;

public class Main {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/beans.xml");

		DishService dishService = context.getBean(DishService.class);
		DishCategoryService dishCategoryService = context
				.getBean(DishCategoryService.class);

		List<DishOrder> orders = showAllOrders(context);
		for (DishOrder order : orders) {
			deleteOrder(context, order.getId());
		}
		orders = showAllOrders(context);

		// Dish dish = dishService.findById(1);
		// dishService.update(dish.getId(), dish.getName(), dish.getPrice(),
		// dish.getCategory(), dish.isDishtype(), !dish.isMenuitem());
		// System.out.println(dish = dishService.findById(1));

		// dishService.create(new Dish(0, "Loaded Potato Soup", 154.2,
		// dishCategoryService.find(2), true, true));

		// findAllDishByCategory(context);

		// System.out.println(Arrays.toString(dishService.findOrderedDishByType(
		// false).toArray()));

		// for(Dish dish:dishService.findOrderedDishByType(false)){
		// System.out.println(dish);
		// }

		// System.out.println(Arrays.toString(dishService.findDishAndOrdersByOrderStatusAndDishType(Status.COMPLETELY_NOT_DONE,
		// false).toArray()));

		// System.out.println(Arrays.toString(dishService.findAll().toArray()));
		// System.out.println(Arrays.toString(dishService.findAll().toArray()));

		// findCustomerByLoginAndPassword(context);

		// addCustomer(context);

		// findCustomer(context);

		// placeOrder(context, findCustomer(context,1));
		// deleteOrder(context, 701);

		// showAlDishes(context);
		// orderService.save(order, dishesOrdered);
		// showCategoriesList(context);
		// showCategoriesList(context);
		// showCustomer(context,1);
	}

	private static void findAllDishByCategory(ApplicationContext context) {
		DishService dishService = context.getBean(DishService.class);
		DishCategoryService dishCategoryService = context
				.getBean(DishCategoryService.class);

		System.out.println("All Dishes from " + dishCategoryService.find(1)
				+ " category");
		for (Dish dish : dishService.findByCategoryInMenu(dishCategoryService
				.find(1))) {
			System.out.println(dish);
		}
	}

	private static void findCustomerByLoginAndPassword(
			ApplicationContext context) {
		CustomerService customerService = context
				.getBean(CustomerService.class);

		System.out.println(customerService.findByLoginAndPassword(
				"dude@gmail.com", "12345"));
	}

	private static Customer findCustomer(ApplicationContext context, int id) {
		CustomerService customerService = context
				.getBean(CustomerService.class);
		Customer customer = customerService.findById(id);
		System.out.println(customer);
		return customer;
	}

	private static void deleteOrder(ApplicationContext context, int id) {
		DishOrderService ordrerService = context
				.getBean(DishOrderService.class);

		ordrerService.remove(id);
	}

	private static List<DishOrder> showAllOrders(ApplicationContext context) {
		DishOrderService ordrerService = context
				.getBean(DishOrderService.class);

		StringBuilder sb = new StringBuilder();

		List<DishOrder> orders = ordrerService.findAll();

		for (DishOrder dishOrder : orders) {
			sb.append("\n").append(dishOrder)
					.append("\n********** Ordered Items *************\n");
			for (OrderItem orderItem : dishOrder.getOrderItems()) {
				sb.append(orderItem).append("\n");

			}
			System.out.println(sb.toString());
		}
		return orders;
	}

	private static void placeOrder(ApplicationContext context, Customer customer) {
		DishOrderService orderService = context.getBean(DishOrderService.class);
		DishService dishService = context.getBean(DishService.class);

		DishOrder order = new DishOrder((customer != null ? customer.getName()
				: "Kirill"), "Hnata Uri 16 ");

		List<OrderItem> orderItems = Arrays.asList(
				new OrderItem(dishService.findById(1), 1), new OrderItem(
						dishService.findById(2), 1));
		orderService.save(order, orderItems);
		System.out.println("Order id = " + order.getId() + " placed");
	}

	private static DishService showAlDishes(ApplicationContext context) {
		DishService dishService = context.getBean(DishService.class);

		for (Dish dish : dishService.findAll()) {
			System.out.println(dish);
		}
		return dishService;
	}

	private static void addCustomer(ApplicationContext context) {
		CustomerService userService = context.getBean(CustomerService.class);
		Date date = Date.valueOf(LocalDate.of(1993, 07, 25));
		Customer user = new Customer(0, "Kiril", "Kyiv Hnata Uri",
				"dude@gmail.com", date, null, "12345");

		userService.createCustomer(user);

		System.out.println(userService.findById(user.getId()));
	}

	private static void showCustomer(ApplicationContext context, int id) {
		CustomerService userService = context.getBean(CustomerService.class);
		System.out.println(userService.findById(id));
	}

	private static void showCategoriesList(ApplicationContext context) {
		DishCategoryService dishCatService = context
				.getBean(DishCategoryService.class);
		List<DishCategory> categories = dishCatService.findAll();

		for (DishCategory cat : categories) {
			System.out.println(cat);
		}
	}

}
