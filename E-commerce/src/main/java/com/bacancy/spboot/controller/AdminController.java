package com.bacancy.spboot.controller;

import java.sql.Date;
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
import com.bacancy.spboot.dto.CategoryDto;
import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.OrderStatusDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.service.AdminService;

@RestController
@RequestMapping("/e-commerce/admin/")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/category")
	public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<>(adminService.createCategory(categoryDto), HttpStatus.CREATED);
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
		return new ResponseEntity<>(HttpStatus.CREATED);
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
	public ResponseEntity<List<OrderDto>> getAllOrderRangeOfDates(@PathVariable Date start, @PathVariable Date end) {
		return new ResponseEntity<List<OrderDto>>(adminService.getAllOrderRangeOfDate(start, end), HttpStatus.OK);
	}

	@GetMapping("/order/track/{id}")
	public ResponseEntity<OrderStatusDto> trackOfTheOrder(@PathVariable Long id) {
		return new ResponseEntity<OrderStatusDto>(adminService.trackOfTheOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("/product/sold/{start}/{end}")
	public ResponseEntity<Long> totalProductsSold(@PathVariable Date start, @PathVariable Date end) {
		return new ResponseEntity<Long>(adminService.totalProductsSoldAmount(start, end), HttpStatus.OK);
	}
}
