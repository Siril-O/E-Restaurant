package com.bionic.edu.service;

import com.bionic.edu.entities.Customer;

public interface CustomerService {

	public void create(Customer user);

	public Customer findById(int id);

}
