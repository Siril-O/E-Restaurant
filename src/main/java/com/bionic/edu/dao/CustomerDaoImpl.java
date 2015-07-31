package com.bionic.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.entities.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Customer customer) {
		if (customer != null) {
			em.persist(customer);
		}
	}

	@Override
	public Customer find(int id) {
		return em.find(Customer.class, id);
	}

	@Override
	public Customer findByLoginAndPassword(String login, String password) {

		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.findByLoginAndPassword", Customer.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		return query.getSingleResult();
	}

}
