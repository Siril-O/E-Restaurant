package com.bionic.edu;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.edu.entities.Dish;
import com.bionic.edu.entities.DishCategory;
import com.bionic.edu.entities.OrderItem;
import com.bionic.edu.entities.DishOrder;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;
import com.bionic.edu.enums.Status;
import com.bionic.edu.service.DishCategoryService;
import com.bionic.edu.service.DishService;
import com.bionic.edu.service.OrderService;
import com.bionic.edu.service.OrderServiceImpl;
import com.bionic.edu.service.CustomerService;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");

		// showCategoriesList(context);
		/*
		 * DishService dishService = context.getBean(DishService.class);
		 * 
		 * OrderService orderService = context.getBean(OrderService.class);
		 * 
		 * Time time = Time.valueOf(LocalTime.now()); Date date =
		 * Date.valueOf(LocalDate.now()); Order order = new Order(0, time, date,
		 * "Dude", "Order Address", Status.COMPLETELY_NOT_DONE, null);
		 * List<DishOrdered> dishesOrdered = new LinkedList<>(); Dish dish1 =
		 * dishService.findById(1); Dish dish2 = dishService.findById(2);
		 * 
		 * dishesOrdered.add(new DishOrdered(0, dish1, null, false, dish1
		 * .getPrice())); dishesOrdered.add(new DishOrdered(0, dish2, null,
		 * false, dish1 .getPrice()));
		 * 
		 * orderService.save(order, dishesOrdered);
		 */

		showCustomer(context,1);
	}

	private static void addCustomer(ApplicationContext context) {
		CustomerService userService = context.getBean(CustomerService.class);
		Date date = Date.valueOf(LocalDate.of(1993, 07, 25));
		Customer user = new Customer(0, "Kiril", "Kyiv Hnata Uri", "dude@gmail.com",
				date, Role.USER, "12345");

		userService.create(user);
		
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
