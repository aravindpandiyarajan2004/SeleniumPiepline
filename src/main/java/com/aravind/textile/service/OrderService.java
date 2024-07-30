package com.aravind.textile.service;

import java.util.List;

import com.aravind.textile.model.Order;

public interface OrderService {

	public String addOrder(Order order);

	public String updateOrder(Order order);

	public String deleteOrder(int orderId);

	public List<Order> getAllOrder();

	public List<Integer> getIdList();

	public Order getOrder(int orderId);

}
