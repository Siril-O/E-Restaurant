package com.bionic.edu.dao;

import java.util.List;

import com.bionic.edu.entities.Customer;

public interface CustomerDao {

	public void save(Customer customer);
	
	public void remove(int id);

	public Customer find(int id);

	public Customer findByLoginAndPassword(String login, String password);
	
	public List<Customer> findAllCustomers();
}
