package com.bionic.edu.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;
import com.bionic.edu.service.CustomerService;

@Named
@Scope("session")
public class CustomerManageBean {

	@Inject
	CustomerService customerService;

	private Customer customer;
	private Date date;
	private List<Customer> customers;
	private Role[] roles = Role.values();

	@PostConstruct
	public void init() {
		customer = new Customer();
	}

	public void refreshCustomerList() {
		customers = customerService.findAllCustomers();
	}

	public String viewAddCustomerPage() {
		customer = new Customer();
		return "createCustomer";
	}

	
	public String removeCustomer(String id){
		customerService.remove(Integer.parseInt(id));
		return "manageCustomers";
	}
	public void saveUser() {
		customer.setBirthDate(new java.sql.Date(date.getTime()));
		customerService.createCustomer(customer, customer.getRole());
	}

	public String editCustomer(String id) {
		customer = customerService.findById(Integer.parseInt(id));
		date = new Date(customer.getBirthDate().getTime());
		return "createCustomer";
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	 * @return the roles
	 */
	public Role[] getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}

	/**
	 * @param customers
	 *            the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
