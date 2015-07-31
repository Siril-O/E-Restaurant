package com.bionic.edu.dao;

import com.bionic.edu.entities.Customer;

public interface CustomerDao {

	public void create(Customer customer);

	public Customer find(int id);

	public Customer findByLoginAndPassword(String login, String password);
}
