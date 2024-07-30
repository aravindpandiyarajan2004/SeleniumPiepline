package com.aravind.textile.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.textile.model.Customer;
import com.aravind.textile.serviceimpl.CustomerServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {

	CustomerServiceImpl service;

	public CustomerController(CustomerServiceImpl service) {
		super();
		this.service = service;
	}

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertCustomer(@RequestBody Customer customer) {

		String msg = "";

		try {
			service.addCustomer(customer);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@GetMapping("{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") int id) {

		return service.getCustomer(id);
	}

	@GetMapping("/all")
	public List<Customer> getCustomers() {

		return service.getAllCustomer();
	}

	@PutMapping
	public String updateCustomer(@RequestBody Customer customer) {
		String msg = "";

		try {
			service.updateCustomer(customer);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;
	}

	@DeleteMapping("{customerId}")
	public String deleteCustomerById(@PathVariable("customerId") int id) {
		String msg = "";

		try {
			service.deleteCustomer(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}

		return msg;

	}

}
