package com.juliuskrah.cdi.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import com.juliuskrah.cdi.business.dto.CustomerBean;
import com.juliuskrah.cdi.business.mapper.CustomerMapper;
import com.juliuskrah.cdi.entity.Customer;
import com.juliuskrah.cdi.repository.CustomerRepository;

@Transactional
public class CustomerService {
	private CustomerRepository customerRepository;
	private CustomerMapper mapper;
	private Logger log;
	private Event<CustomerBean> customerEventSrc;
	private List<CustomerBean> customers;

	public CustomerService() {}
	
	public CustomerService(CustomerRepository customerRepository, CustomerMapper mapper) {
		this.customerRepository = customerRepository;
		this.mapper = mapper;
	}

	/**
	 * Creates a customer and fires an Event upon successful create
	 * 
	 * @param customer
	 * @return
	 */
	public CustomerBean createCustomer(CustomerBean customer) {
		Customer c = mapper.toEntity(customer);
		customerRepository.save(c);
		customer = mapper.toDTO(c);
		customerEventSrc.fire(customer);
		return customer;
	}

	// @Named provides access the return value via the EL variable name "customers"
	// in the UI (e.g.
	// Facelets or JSP view)
	@Named
	public List<CustomerBean> getCustomers() {
		return customers;
	}

	/**
	 * Initialize the customers list
	 */
	@PostConstruct
	public void fetchAllCustomers() {
		log.info("Listing all customers");
		this.customers = this.findAll();
	}

	/**
	 * Retrieve customers from the database
	 * 
	 * @return List of Customers
	 */
	public List<CustomerBean> findAll() {
		List<Customer> customers = customerRepository.findAll();
		return mapper.toDTO(customers);
	}

	/**
	 * Observe customer created events
	 * 
	 * @param customer
	 */
	public void onCustomerListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS, during = TransactionPhase.AFTER_COMPLETION) final CustomerBean customer) {
		customers.add(customer);
	}
}
