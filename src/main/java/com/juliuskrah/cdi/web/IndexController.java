package com.juliuskrah.cdi.web;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.validation.Valid;

import org.jboss.logging.Logger;

import com.juliuskrah.cdi.business.CustomerService;
import com.juliuskrah.cdi.business.dto.CustomerBean;

@Model
public class IndexController {
	@Inject
	private CustomerService customerService;
	@Inject
	private Logger log;

	public String submit(@Valid CustomerBean customer) {
		log.infov("Form param :- {0}", customer);
		customerService.createCustomer(customer);
		return "index??faces-redirect=true";
	}
}