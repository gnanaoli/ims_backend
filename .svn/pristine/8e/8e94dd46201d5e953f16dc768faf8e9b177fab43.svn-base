package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

	List<SubCategory> findByStatus(String active);

	SubCategory findBySubCategoryAndStatus(String subCategory,String status);

	SubCategory findBySubCategory(String subCategory);

	SubCategory findByModel(String model);

	SubCategory findByHsnCode(String hsnCode);
	@Query(value="SELECT * FROM subcategory s WHERE s.hsn_Code=:hsnCode and id !=:id", nativeQuery=true)
	SubCategory getHsnCodeAndfindByIdNotIn(@Param("hsnCode")String hsnCode,@Param("id")Long id );
	
	@Query(value="SELECT * FROM subcategory s WHERE s.model=:model and id !=:id", nativeQuery=true)
	SubCategory getModelAndfindByIdNotIn(@Param("model")String model,@Param("id")Long id );

	@Query(value="SELECT * FROM subcategory s WHERE s.sub_category=:subCategory and id !=:id", nativeQuery=true)
	SubCategory getSubCategoryAndfindByIdNotIn(@Param("subCategory")String subCategory,@Param("id")Long id );
	//SubCategory findByIdNotInAndfindByHsnCode(Long id, String hsnCode);

	//SubCategory findByIdNotInAndfindByModel(Long id, String model);


}
