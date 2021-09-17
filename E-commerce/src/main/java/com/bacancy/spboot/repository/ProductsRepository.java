package com.bacancy.spboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bacancy.spboot.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

	public Optional<Products> findByProductName(String productName);

}
