package com.aravind.textile.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aravind.textile.model.Order;
import com.aravind.textile.repository.OrderRepo;
import com.aravind.textile.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	OrderRepo orderRepo;

	public OrderServiceImpl(OrderRepo orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@Override
	public String addOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepo.findAllOrders();
	}

	@Override
	public List<Integer> getIdList() {
		return orderRepo.getIdList();

	}

	@Override
	public String updateOrder(Order order) {
		return orderRepo.update(order);
		

	}

	@Override
	public String deleteOrder(int orderId) {
		orderRepo.delete(orderId);
		return SUCCESS;

	}

	@Override
	public Order getOrder(int orderId) {
		return orderRepo.findById(orderId);
	}

}
