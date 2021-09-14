package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.bacancy.spboot.model.OrderStatus;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {

	public OrderStatus findByUserId(Long id);

	public OrderStatus findByOrderId(Long id);

}
