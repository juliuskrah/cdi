package com.juliuskrah.cdi.web;

import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.logging.Logger;

import com.juliuskrah.cdi.business.CustomerService;
import com.juliuskrah.cdi.business.dto.CustomerBean;

@Path("/")
@Controller
public class IndexController {
	@Inject
	private CustomerService customerService;
	@Inject
	private Logger log;

	@POST
	public String submit(@Valid @BeanParam CustomerBean customer) {
		log.infov("Form param :- {0}", customer);
		customerService.createCustomer(customer);
		return "redirect:/";
	}

	@GET
	public String welcome() {
		log.info("Rendering welcome page");
		return "index.xhtml";
	}
}