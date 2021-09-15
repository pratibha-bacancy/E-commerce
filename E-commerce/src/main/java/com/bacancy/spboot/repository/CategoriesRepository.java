package com.bacancy.spboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bacancy.spboot.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

	public Optional<Categories> findByCategoryName(String categoryName);

}
