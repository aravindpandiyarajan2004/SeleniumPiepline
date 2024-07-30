package com.aravind.textile.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aravind.textile.model.Customer;
import com.aravind.textile.repository.CustomerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpl implements CustomerRepo {

	EntityManager em;

	public CustomerRepoImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Customer customer) {
		if (customer != null) {
			em.merge(customer);
			return "Success";
		} else {
			return "Failure";
		}

	}

	@Override
	public List<Customer> findAllCustomers() {
		String hql = "from Customer";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public String update(Customer customer) {
		if(customer != null) {
			em.merge(customer);
			return "Success";
		}
		return "Failure";
		

	}

	@Override
	public Customer findById(int customerId) {
		return em.find(Customer.class, customerId);
	}

	@Override
	public String delete(int customerId) {
		Customer id = em.find(Customer.class, customerId);
		if(id != null) {
			em.remove(id);
			return "Success";
		}
		return "Failure";
		
	}

}
