package com.bionic.edu.service;

import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;

public interface CustomerService {

	public void createCustomer(Customer customer, Role role);

	public Customer findById(int id);

	public Customer findByLoginAndPassword(String login, String password);

}
