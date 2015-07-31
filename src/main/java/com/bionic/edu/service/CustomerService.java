package com.bionic.edu.service;

import com.bionic.edu.entities.Customer;

public interface CustomerService {

	public void createStuff(Customer customer);
	
	public void createCustomer(Customer customer);

	public Customer findById(int id);
	
	public Customer findByLoginAndPassword(String login, String password);

}
