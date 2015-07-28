package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Customer user) {
		if (user != null) {
			em.persist(user);
		}
	}

	@Override
	public Customer find(int id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer findByLoginAndPassword(String login, String password) {

		TypedQuery<Customer> query = em.createQuery(
				"SELECT u FROM User u WHERE u.login = " + login
						+ " AND u.password = " + password, Customer.class);
		return query.getSingleResult();
	}

}
