package com.bacancy.spboot.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bacancy.spboot.model.OrderStatus;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

	public OrderStatus findByUserId(Long id);

	public OrderStatus findByOrderId(Long id);

	public List<OrderStatus> findByOrderDateBetween(Date start, Date end);

}
