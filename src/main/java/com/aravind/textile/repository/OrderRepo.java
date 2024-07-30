package com.aravind.textile.repository;

import java.util.List;

import com.aravind.textile.model.Order;

public interface OrderRepo {

	public String save(Order order);

	public String update(Order order);

	public void delete(int orderId);

	public List<Order> findAllOrders();

	public List<Integer> getIdList();

	public Order findById(int orderId);


	

}
