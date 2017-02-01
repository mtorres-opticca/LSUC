package ca.on.lsuc.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.on.lsuc.jpa.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
