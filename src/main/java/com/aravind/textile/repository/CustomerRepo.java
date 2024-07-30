package com.aravind.textile.repository;

import java.util.List;

import com.aravind.textile.model.Customer;

public interface CustomerRepo {
	public String save(Customer customer);

	public String update(Customer customer);

	public String delete(int customerId);

	public List<Customer> findAllCustomers();

	public Customer findById(int customerId);

}
