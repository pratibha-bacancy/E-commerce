package com.bacancy.spboot.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.model.Order;
import com.bacancy.spboot.model.Products;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.repository.OrderRepository;
import com.bacancy.spboot.repository.ProductsRepository;
import com.bacancy.spboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProductsDto> getAllProducts() {
		List<Products> products = (List<Products>) productsRepository.findAll();
		List<ProductsDto> productsDto = products.stream().map(product -> modelMapper.map(product, ProductsDto.class))
				.collect(Collectors.toList());
		return productsDto;
	}

	public List<OrderDto> getUserOrders(@PathVariable Long userId) {
		Optional<User> users = userRepository.findById(userId);
		List<Order> orders = users.get().getOrder();
		List<OrderDto> orderDto = orders.stream().map(order -> modelMapper.map(order, OrderDto.class))
				.collect(Collectors.toList());
		return orderDto;
	}

}
