package com.bionic.edu.dao;

import java.util.List;

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
	public void save(Customer customer) {
		if (customer != null && customer.getId() == 0) {
			em.persist(customer);
		} else if (customer != null) {
			em.merge(customer);
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
		return query.setParameter("login", login)
				.setParameter("password", password).getSingleResult();
	}

	@Override
	public List<Customer> findAllCustomers() {
		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.findAllCustomers", Customer.class);
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
	}

	@Override
	public Customer findByLogin(String login) {
		TypedQuery<Customer> query = em.createNamedQuery(
				"Customer.findByLogin", Customer.class);
		return query.setParameter("login", login).getSingleResult();
	}

}
