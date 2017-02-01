package ca.on.lsuc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ca.on.lsuc.jpa.dao.OrderRepository;
import ca.on.lsuc.jpa.entity.Order;
import ca.on.lsuc.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderRepository orderRepository;
	
	@Override
	public Order findOrder(Long id) {
		return orderRepository.findOne(id);
	}
	
	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	@Override
	public List<Order> saveOrders(List<Order> orders) {
		return orderRepository.save(orders);
	}
	
	@Override
	public void deleteOrder(Long id) {
		orderRepository.delete(id);
	}
	
	@Override
	public void deleteOrder(Order order) {
		orderRepository.delete(order);
	}
	
	@Override
	public void deleteOrders(List<Order> orders) {
		orderRepository.deleteInBatch(orders);
	}
}
