package com.bionic.edu.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.edu.dao.CustomerDao;
import com.bionic.edu.entities.Customer;

@Named
public class CustomerServiceImpl implements CustomerService {

	@Inject
	@Named("customerDaoImpl")
	private CustomerDao userDao;

	@Override
	@Transactional
	public void create(Customer user) {
		userDao.create(user);
	}

	@Override
	public Customer findById(int id) {
		return userDao.find(id);
	}

}
