package com.aravind.textile.service;

import java.util.List;

import com.aravind.textile.model.Customer;

public interface CustomerService {

	public String addCustomer(Customer customer);

	public String updateCustomer(Customer customer);

	public String deleteCustomer(int customerId);

	public List<Customer> getAllCustomer();

	public Customer getCustomer(int customerId);

}
