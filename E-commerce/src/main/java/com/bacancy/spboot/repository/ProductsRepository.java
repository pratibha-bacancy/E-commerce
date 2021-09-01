package com.bacancy.spboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.model.Products;

public interface ProductsRepository extends CrudRepository<Products, Long> {

	public Optional<Products> findByProductName(String productName);

}
