package com.bionic.edu.service;

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
		userDao.create(customer);
	}

	@Override
	public Customer findById(int id) {
		return userDao.find(id);
	}

	@Transactional
	@Override
	public void createStuff(Customer customer) {
		customer.setRole(Role.STUFF);
		create(customer);
	}

	@Transactional
	@Override
	public void createCustomer(Customer customer) {
		customer.setRole(Role.USER);
		create(customer);
	}

	@Transactional
	@Override
	public Customer findByLoginAndPassword(String login, String password) {
		return userDao.findByLoginAndPassword(login, password);
	}

}
