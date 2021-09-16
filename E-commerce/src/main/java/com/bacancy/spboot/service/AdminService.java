package com.bacancy.spboot.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bacancy.spboot.dto.CategoriesDto;
import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.OrderStatusDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.exception.DataFoundException;
import com.bacancy.spboot.exception.DataNotFoundException;
import com.bacancy.spboot.model.Categories;
import com.bacancy.spboot.model.Order;
import com.bacancy.spboot.model.OrderStatus;
import com.bacancy.spboot.model.Products;
import com.bacancy.spboot.model.User;
import com.bacancy.spboot.repository.CategoriesRepository;
import com.bacancy.spboot.repository.OrderRepository;
import com.bacancy.spboot.repository.OrderStatusRepository;
import com.bacancy.spboot.repository.ProductsRepository;
import com.bacancy.spboot.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderStatusRepository orderStatusRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CategoriesDto createCategory(CategoriesDto categoriesDto) {
		Optional<Categories> category = categoriesRepository.findByCategoryName(categoriesDto.getCategoryName());
		if (category.isPresent()) {
			throw new DataFoundException("Category Already Exist!");
		}
		Categories model = modelMapper.map(categoriesDto, Categories.class);
		categoriesRepository.save(model);
		return categoriesDto;
	}

	public ProductsDto addProduct(ProductsDto productsDto) {
		Optional<Products> product = productsRepository.findByProductName(productsDto.getProductName());
		if (product.isPresent()) {
			throw new DataFoundException("Product Already Exist!");
		}
		Products model = modelMapper.map(productsDto, Products.class);
		productsRepository.save(model);
		return productsDto;
	}

	public ProductsDto updateProduct(Long id, ProductsDto productsDto) {
		Optional<Products> product = productsRepository.findById(productsDto.getId());
		if (!product.isPresent())
			throw new DataNotFoundException("Product Not Found!");
		Products model = modelMapper.map(productsDto, Products.class);
		productsRepository.save(model);
		return productsDto;
	}

	public void removeProduct(Long id) {
		productsRepository.deleteById(id);
	}

	public OrderDto createOrder(OrderDto orderDto) {
		Optional<Order> order = orderRepository.findById(orderDto.getId());
		Order model = modelMapper.map(orderDto, Order.class);
		orderRepository.save(model);
		return orderDto;
	}

	public OrderDto viewOrder(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			throw new DataNotFoundException("Order does not exist");
		}
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		return orderDto;
	}
	
	public OrderDto updateOrder(Long id, OrderDto orderDto) {
		Optional<Order> order = orderRepository.findById(orderDto.getId());
		if (!order.isPresent())
			throw new DataNotFoundException("Order Not Found!");
		Order model = modelMapper.map(orderDto, Order.class);
		orderRepository.save(model);
		return orderDto;
	}

	public String confirmOrder(Long userId, Long orderId, OrderStatusDto orderStatusDto) {
		Optional<OrderStatus> orderStatus = Optional.of(orderStatusRepository.findByOrderId(orderId));
		if (orderStatus.get().getStatus().equals("Confirmed"))
			return "Order Delivered!";
		OrderStatus order = modelMapper.map(orderStatusDto, OrderStatus.class);
		Optional<User> userOptional = userRepository.findById(userId);
		User user = userOptional.get();
		order.setUser(user);
		orderStatusRepository.save(order);
		return "Order Confirmed!";
	}

	public String cancleOrder(Long orderId, OrderDto orderDto) {
		Optional<OrderStatus> orderStatus = Optional.of(orderStatusRepository.findByOrderId(orderId));
		if (orderStatus.get().getStatus().equals("Confirmed"))
			return "Order Already Confirmed!";
		orderStatusRepository.deleteById(orderId);
		orderRepository.deleteById(orderId);
		return "Order Cancle!";
	}

	public List<OrderDto> getAllOrderRangeOfDate(Date start, Date end) {
		List<Order> order = (List<Order>) orderRepository.findByOrderDateBetween(start, end);
		List<OrderDto> orderDto = order.stream().map(product -> modelMapper.map(product, OrderDto.class))
				.collect(Collectors.toList());
		return orderDto;
	}

	public OrderStatusDto trackOfTheOrder(Long id) {
		Optional<OrderStatus> orderStatus = orderStatusRepository.findById(id);
		if (!orderStatus.isPresent()) {
			throw new DataNotFoundException("Order does not exist");
		}
		OrderStatusDto orderstatusDto = modelMapper.map(orderStatus, OrderStatusDto.class);
		return orderstatusDto;
	}

	public long totalProductsSoldAmount(Date start, Date end) {
		long amount = 0;
		List<OrderStatus> orderStatus = (List<OrderStatus>) orderStatusRepository.findByOrderDateBetween(start, end);
		int size = orderStatus.size();
		for (int i = 0; i < size; i++) {
			if (orderStatus.get(i).getStatus().equals("Placed")) {
				amount = (long) (amount + (orderStatus.get(i).getOrder().getTotalPrice()));
			}
		}
		return amount;
	}

}
