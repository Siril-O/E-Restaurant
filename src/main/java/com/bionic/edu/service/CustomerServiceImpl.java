package com.bionic.edu.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.CustomerDao;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.enums.Role;

@Named
public class CustomerServiceImpl implements CustomerService {

	@Inject
	@Named("customerDaoImpl")
	private CustomerDao userDao;

	private void create(Customer customer) {
		userDao.save(customer);
	}

	@Override
	public Customer findById(int id) {
		return userDao.find(id);
	}

	@Transactional
	@Override
	public void createCustomer(Customer customer, Role role) {
		customer.setRole(role);
		create(customer);
	}

	@Transactional
	@Override
	public Customer findByLoginAndPassword(String login, String password) {
		return userDao.findByLoginAndPassword(login, password);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return userDao.findAllCustomers();
	}

	@Override
	@Transactional
	public void remove(int id) {
		userDao.remove(id);		
	}

}
