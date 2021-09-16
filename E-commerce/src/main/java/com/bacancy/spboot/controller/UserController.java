package com.bacancy.spboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.OrderStatusDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.service.UserService;

@RestController
@RequestMapping("/e-commerce/user/")
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);

	@GetMapping("/products/menu")
	public ResponseEntity<List<ProductsDto>> getAllProducts() {
		return new ResponseEntity<List<ProductsDto>>(userService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/orders/menu")
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		return new ResponseEntity<List<OrderDto>>(userService.getAllOrders(), HttpStatus.OK);
	}

	@PostMapping("/{id}/order")
	public ResponseEntity<Object> placeOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(userService.placeOrder(id, orderDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}/orders")
	public ResponseEntity<List<OrderDto>> getUserOrders(@PathVariable Long id) {
		return new ResponseEntity<List<OrderDto>>(userService.getUserOrders(id), HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}/status")
	public ResponseEntity<OrderStatusDto> getUserOrderStatus(@PathVariable Long orderId) {
		return new ResponseEntity<OrderStatusDto>(userService.getUserOrderStatus(orderId), HttpStatus.OK);
	}

	@PutMapping("{userId}/order/{orderId}")
	public ResponseEntity<Object> modifyOrder(@PathVariable Long userId, @PathVariable Long orderId,
			@RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(userService.modifyOrder(userId, orderId, orderDto), HttpStatus.CREATED);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Object> cancleOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
		userService.cancleOrder(orderId, orderDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/order/summary/{id}")
	public ResponseEntity<OrderDto> orderSummary(@PathVariable Long id) {
		return new ResponseEntity<OrderDto>(userService.orderSummary(id), HttpStatus.OK);
	}
}
