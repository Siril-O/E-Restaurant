package com.bionic.edu.mbeans;

import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;
import com.bionic.edu.service.CustomerService;

@Named
@Scope("request")
public class RegisterCustomerBean extends AbstractManageBean {

	@Inject
	private CustomerService cutomerService;
	private Customer customer = new Customer();
	private Date date;


	public String registerCustomer() {
		try {
			cutomerService.findByLogin(customer.getEmail());
		} catch (javax.persistence.NoResultException e) {
			customer.setBirthDate(new java.sql.Date(date.getTime()));
			cutomerService.createCustomer(customer, Role.USER);
			showMessage("Success", "Customer: " + customer.getName()
					+ " registered in system");
			return "menuCategories";
		}
		showMessage("Info", "Customer: with login:" + customer.getEmail()
				+ " Already exsist");
		return "login";
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

}
