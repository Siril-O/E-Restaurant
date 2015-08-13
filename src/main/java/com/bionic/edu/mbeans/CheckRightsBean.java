package com.bionic.edu.mbeans;

import java.util.Date;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;
import com.bionic.edu.service.CustomerService;

@Named
@Scope("session")
public class CheckRightsBean {

	@Inject
	private CustomerService cutomerService;
	private Customer customer;
	private String login;
	private String password;
	private String previousPage;
	private Date date;

	public void viewRegisterForm() {
		if (customer == null) {
			customer = new Customer();
		}
	}

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

	public void signOut() {
		showMessage("Success", "Customer: " + customer.getName()
				+ " SignOut from the system with role:" + customer.getRole());
		customer = null;

	}

	public String signIn() {

		try {
			customer = cutomerService.findByLoginAndPassword(login, password);
		} catch (javax.persistence.NoResultException e) {
			showMessage("Error", "Such login and password dont found in system");
			return "login";
		}

		showMessage("Success", "Customer: " + customer.getName()
				+ " SignIn to system with role:" + customer.getRole());
		return previousPage == null ? "menuCategories" : previousPage;
	}

	public void isDelivery(ComponentSystemEvent event) {
		checkByRole(event, Role.DELIVERY);
	}

	public void isKitchenStuff(ComponentSystemEvent event) {
		checkByRole(event, Role.KITCHEN_SUFF);
	}

	public void isAdmin(ComponentSystemEvent event) {
		checkByRole(event, Role.ADMIN);
	}

	public void isPacker(ComponentSystemEvent event) {
		checkByRole(event, Role.PACKER);
	}

	public void isSuperUser(ComponentSystemEvent event) {
		checkByRole(event, Role.SUPER_USER);
	}

	private void checkByRole(ComponentSystemEvent event, Role... roles) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();

		nav.performNavigation(checkRights(event, fc, roles));
	}

	private String checkRights(ComponentSystemEvent event, FacesContext fc,
			Role... roles) {

		previousPage = fc.getViewRoot().getViewId();

		if (customer == null) {
			showMessage("Info", "SignIn to enter this page");
			return "login";
		}

		for (Role role : roles) {
			if (customer.getRole().equals(role)) {
				return previousPage;
			}
		}

		return "access-denied";
	}

	private void showMessage(String summary, String detail) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(summary, detail));
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the previousPage
	 */
	public String getPreviousPage() {
		return previousPage;
	}

	/**
	 * @param previousPage
	 *            the previousPage to set
	 */
	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
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
