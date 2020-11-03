package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{


        List<Category> findByStatus(String active);

		Category findByCategoryTypeAndStatus(String categoryType, String status);

		Category findByCategoryType(String categoryType);
		
		Category findByCategoryCode(String categoryCode);
		
		@Query(value="select i.* from category i where i.category_code=:category_code and i.id!=:id",nativeQuery=true)
		Category getCategoryCodeExceptNotInGivenId(@Param("id") Long id,@Param("category_code")String categoryCode);

}
