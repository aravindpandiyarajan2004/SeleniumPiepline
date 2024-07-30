package com.aravind.textile.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aravind.textile.model.Order;
import com.aravind.textile.repository.OrderRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OrderRepoImpl implements OrderRepo {

	EntityManager em;

	public OrderRepoImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public String save(Order order) {
		if (order != null) {
			em.persist(order);
			return "Success";
		} else {
			return "Failure";
		}
	}

	@Override
	public List<Order> findAllOrders() {
		String hql = "from Order";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public List<Integer> getIdList() {
		String hql = "select orderId from Order";
		Query q = em.createQuery(hql);
		return q.getResultList();
	}

	@Override
	public String update(Order order) {
		if(order != null) {
			em.merge(order);
			return "Success";
		}
		return "Failure";
		

	}

	@Override
	public void delete(int orderId) {
		Order id = em.find(Order.class, orderId);
		em.remove(id);

	}

	@Override
	public Order findById(int orderId) {
		return em.find(Order.class, orderId);
	}

}
