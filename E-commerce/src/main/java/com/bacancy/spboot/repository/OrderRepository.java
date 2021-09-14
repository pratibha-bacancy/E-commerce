package com.bacancy.spboot.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	public List<Order> findAllByUserId(Long id);

	public Order findByUserId(Long userId);

	public List<Order> findByOrderDateBetween(Date start, Date end);

}
