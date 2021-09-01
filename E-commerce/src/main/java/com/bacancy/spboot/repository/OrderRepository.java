package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
