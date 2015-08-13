package com.bionic.edu.service;

import java.util.List;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;

public interface CustomerService {

	public void createCustomer(Customer customer, Role role);

	public Customer findById(int id);

	public Customer findByLoginAndPassword(String login, String password);
	
	public List<Customer> findAllCustomers ();
	
	public void remove(int id);
	
	public Customer findByLogin(String login);

}
