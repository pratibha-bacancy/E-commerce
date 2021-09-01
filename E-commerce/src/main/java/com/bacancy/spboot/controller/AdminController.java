package com.bacancy.spboot.controller;

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
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
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
	public ResponseEntity<Object> updateProduct(@PathVariable long id, @RequestBody ProductsDto productsDto) {
		adminService.updateProduct(id, productsDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/category/product/{id}")
	public ResponseEntity<Object> removeProduct(@PathVariable long id) {
		adminService.removeProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
		return new ResponseEntity<>(adminService.createOrder(orderDto), HttpStatus.CREATED);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<OrderDto> viewOrder(@PathVariable long id) {
		return new ResponseEntity<OrderDto>(adminService.viewOrder(id), HttpStatus.OK);
	}

	@PutMapping("/order/{id}")
	public ResponseEntity<Object> updateOrder(@PathVariable long id, @RequestBody OrderDto orderDto) {
		adminService.updateOrder(id, orderDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
