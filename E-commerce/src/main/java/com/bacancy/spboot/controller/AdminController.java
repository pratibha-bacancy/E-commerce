package com.bacancy.spboot.controller;

import java.sql.Date;
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
import com.bacancy.spboot.dto.CategoriesDto;
import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.OrderStatusDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.service.AdminService;

@RestController
@RequestMapping("/e-commerce/admin/")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/category")
	public ResponseEntity<Object> createCategory(@RequestBody CategoriesDto categoriesDto) {
		return new ResponseEntity<>(adminService.createCategory(categoriesDto), HttpStatus.CREATED);
	}

	@PostMapping("/category/product")
	public ResponseEntity<Object> addProduct(@RequestBody ProductsDto productsDto) {
		return new ResponseEntity<>(adminService.addProduct(productsDto), HttpStatus.CREATED);
	}

	@PutMapping("/category/product/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductsDto productsDto) {
		adminService.updateProduct(id, productsDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/category/product/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable Long id) {
		adminService.removeProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(adminService.createOrder(orderDto), HttpStatus.CREATED);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDto> viewOrder(@PathVariable Long id) {
		return new ResponseEntity<OrderDto>(adminService.viewOrder(id), HttpStatus.OK);
	}

	@PutMapping("/order/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
		adminService.updateOrder(id, orderDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("{userId}/order/{orderId}")
	public ResponseEntity<Object> confirmOrder(@PathVariable Long userId, @PathVariable Long orderId,
			@RequestBody OrderStatusDto orderStatusDto) {
		return new ResponseEntity<>(adminService.confirmOrder(userId, orderId, orderStatusDto), HttpStatus.CREATED);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Object> cancleOrder(@PathVariable Long orderId, @RequestBody OrderDto orderDto) {
		adminService.cancleOrder(orderId, orderDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/order/{start}/{end}")
	public List<OrderDto> getAllOrderRangeOfDates(@PathVariable Date start, @PathVariable Date end) {
		return adminService.getAllOrderRangeOfDate(start, end);
	}

	@GetMapping("/order/track/{id}")
	public OrderStatusDto trackOfTheOrder(@PathVariable Long id) {
		return adminService.trackOfTheOrder(id);
	}
	
	@GetMapping("/product/sold/{start}/{end}")
	public long totalProductsSold(@PathVariable Date start, @PathVariable Date end) {
		return adminService.totalProductsSoldAmount(start, end);
	}
}
