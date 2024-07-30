package com.aravind.textile.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aravind.textile.model.Customer;
import com.aravind.textile.repository.CustomerRepo;
import com.aravind.textile.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepo customerRepo;

	public CustomerServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@Override
	public String addCustomer(Customer customer) {
		return customerRepo.save(customer);

	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerRepo.findById(customerId);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAllCustomers();
	}

	@Override
	public String updateCustomer(Customer customer) {
		return customerRepo.update(customer);
		

	}

	@Override
	public String deleteCustomer(int customerId) {
		return customerRepo.delete(customerId);
		

	}

}
