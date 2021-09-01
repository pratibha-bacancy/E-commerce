package com.bacancy.spboot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.model.Categories;

public interface CategoriesRepository extends CrudRepository<Categories, Long> {

	public Optional<Categories> findByCategoryName(String categoryName);

}
