package com.juliuskrah.cdi.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.juliuskrah.cdi.entity.Customer;

@SessionScoped
public class CustomerRepository implements Serializable {
	private static final long serialVersionUID = 4797319546157041457L;
	private EntityManager em;

	public CustomerRepository() {}

	@Inject
	public CustomerRepository(EntityManager em) {
		this.em = em;
	}

	public Customer save(Customer customer) {
		this.em.persist(customer);
		return customer;
	}

	public Optional<Customer> findOne(UUID id) {
		Customer customer = this.em.find(Customer.class, id);
		return Optional.ofNullable(customer);
	}

	public List<Customer> findAll() {
		List<Customer> customers = this.em.createQuery("FROM Customer", Customer.class).getResultList();
		return customers;
	}

	public Customer update(Customer customer) {
		customer = this.em.merge(customer);
		return customer;
	}

	public void delete(Customer customer) {
		if (this.em.contains(customer))
			this.em.remove(customer);
	}
}