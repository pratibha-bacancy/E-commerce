package com.bacancy.spboot.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bacancy.spboot.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findAllByUserId(Long id);

	public Order findByUserId(Long userId);

	public List<Order> findByOrderDateBetween(Date start, Date end);

}
