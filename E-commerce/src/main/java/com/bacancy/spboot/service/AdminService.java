package com.bacancy.spboot.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bacancy.spboot.dto.CategoriesDto;
import com.bacancy.spboot.dto.OrderDto;
import com.bacancy.spboot.dto.ProductsDto;
import com.bacancy.spboot.exception.DataFoundException;
import com.bacancy.spboot.exception.DataNotFoundException;
import com.bacancy.spboot.model.Categories;
import com.bacancy.spboot.model.Order;
import com.bacancy.spboot.model.Products;
import com.bacancy.spboot.repository.CategoriesRepository;
import com.bacancy.spboot.repository.OrderRepository;
import com.bacancy.spboot.repository.ProductsRepository;

@Service
public class AdminService {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private OrderRepository orderRepository;

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

	public ProductsDto updateProduct(long id, ProductsDto productsDto) {
		Optional<Products> product = productsRepository.findById(productsDto.getId());
		if (!product.isPresent())
			throw new DataNotFoundException("Product Not Found!");
		Products model = modelMapper.map(productsDto, Products.class);
		productsRepository.save(model);
		return productsDto;
	}

	public void removeProduct(long id) {
		productsRepository.deleteById(id);
	}

	public OrderDto createOrder(OrderDto orderDto) {
		Optional<Order> order = orderRepository.findById(orderDto.getId());
		Order model = modelMapper.map(orderDto, Order.class);
		orderRepository.save(model);
		return orderDto;
	}

	public OrderDto viewOrder(long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (!order.isPresent()) {
			throw new DataNotFoundException("Order does not exist");
		}
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		return orderDto;
	}

	public OrderDto updateOrder(long id, OrderDto orderDto) {
		Optional<Order> order = orderRepository.findById(orderDto.getId());
		if (!order.isPresent())
			throw new DataNotFoundException("Order Not Found!");
		Order model = modelMapper.map(orderDto, Order.class);
		orderRepository.save(model);
		return orderDto;
	}

}
