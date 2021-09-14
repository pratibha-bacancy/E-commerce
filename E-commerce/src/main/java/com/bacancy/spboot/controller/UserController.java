package com.bacancy.spboot.controller;

import java.util.List;
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

	@GetMapping("/products/menu")
	public List<ProductsDto> getAllProducts() {
		return userService.getAllProducts();
	}

	@GetMapping("/orders/menu")
	public List<OrderDto> getAllOrders() {
		return userService.getAllOrders();
	}

	@PostMapping("/{id}/order")
	public ResponseEntity<Object> placeOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(userService.placeOrder(id, orderDto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}/orders")
	public List<OrderDto> getUserOrders(@PathVariable Long id) {
		return userService.getUserOrders(id);
	}

	@GetMapping("/order/{orderId}/status")
	public OrderStatusDto getUserOrderStatus(@PathVariable Long orderId) {
		return userService.getUserOrderStatus(orderId);
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
