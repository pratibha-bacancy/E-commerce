package com.bacancy.spboot.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.stream.Collectors;
import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.OrderStatusDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.exception.DataNotFoundException;
import com.bacancy.spboot.model.Order;
import com.bacancy.spboot.model.OrderStatus;
import com.bacancy.spboot.model.Products;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.repository.OrderRepository;
import com.bacancy.spboot.repository.OrderStatusRepository;
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
	private OrderStatusRepository orderStatusRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProductsDto> getAllProducts() {
		List<Products> products = (List<Products>) productsRepository.findAll();
		List<ProductsDto> productsDto = products.stream().map(product -> modelMapper.map(product, ProductsDto.class))
				.collect(Collectors.toList());
		return productsDto;
	}

	public List<OrderDto> getAllOrders() {
		List<Order> order = (List<Order>) orderRepository.findAll();
		List<OrderDto> orderDto = order.stream().map(product -> modelMapper.map(product, OrderDto.class))
				.collect(Collectors.toList());
		return orderDto;
	}

	public ResponseEntity<Object> placeOrder(Long id, OrderDto orderDto) {
		Order order = modelMapper.map(orderDto, Order.class);
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new DataNotFoundException("id: " + id);
		}
		User user = userOptional.get();
		order.setUser(user);
		orderRepository.save(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	public List<OrderDto> getUserOrders(Long id) {
		List<Order> order = (List<Order>) orderRepository.findAllByUserId(id);
		List<OrderDto> orderDto = order.stream().map(user -> modelMapper.map(user, OrderDto.class))
				.collect(Collectors.toList());
		return orderDto;
	}

	public OrderStatusDto getUserOrderStatus(Long id) {
		OrderStatus orderStatus = orderStatusRepository.findByOrderId(id);
		OrderStatusDto orderStatusDto = modelMapper.map(orderStatus, OrderStatusDto.class);
		return orderStatusDto;
	}

	public String modifyOrder(Long userId, Long orderId, OrderDto orderDto) {
		Optional<OrderStatus> orderStatus = Optional.of(orderStatusRepository.findByOrderId(orderId));
		if (orderStatus.get().getStatus().equals("Confirmed"))
			return "Order Already Confirmed!";
		Order order = modelMapper.map(orderDto, Order.class);
		Optional<User> userOptional = userRepository.findById(userId);
		User user = userOptional.get();
		order.setUser(user);
		orderRepository.save(order);
		return "Order Modified!";
	}

	public String cancleOrder(Long orderId, OrderDto orderDto) {
		Optional<OrderStatus> orderStatus = Optional.of(orderStatusRepository.findByOrderId(orderId));
		if (orderStatus.get().getStatus().equals("Confirmed"))
			return "Order Already Confirmed!";
		orderStatusRepository.deleteById(orderId);
		orderRepository.deleteById(orderId);
		return "Order Deleted!";
	}

	public OrderDto orderSummary(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			throw new DataNotFoundException("order does not exist!");
		}
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		return orderDto;
	}

}