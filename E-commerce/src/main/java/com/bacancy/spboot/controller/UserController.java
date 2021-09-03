package com.bacancy.spboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/products/menu")
	public List<ProductsDto> getAllProducts() {
		return userService.getAllProducts();
	}
	
	@GetMapping("/orders")
	public List<OrderDto> getUserOrders(@PathVariable long userId) {
		return userService.getUserOrders(userId);
	}
	
}
