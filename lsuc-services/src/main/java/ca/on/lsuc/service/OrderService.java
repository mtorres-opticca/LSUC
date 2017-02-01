package ca.on.lsuc.service;

import java.util.List;

import ca.on.lsuc.jpa.entity.Order;

public interface OrderService {

	Order findOrder(Long id);

	List<Order> findAll();

	Order saveOrder(Order order);

	List<Order> saveOrders(List<Order> orders);

	void deleteOrder(Long id);

	void deleteOrder(Order order);

	void deleteOrders(List<Order> orders);	
}
