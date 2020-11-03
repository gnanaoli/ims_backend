package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.inventory.entity.Scrap;

public interface ScarpMasterRespository extends JpaRepository<Scrap, Long>{

	
	@Query(value = "SELECT s.* FROM scrap s,category c,subcategory sc where s.category_id = c.id and c.id = sc.category_id", nativeQuery = true)
	List<Scrap> GetAllScarp();

	List<Scrap> findByWarehouseSiteName(String wareHouseName);

	List<Scrap> findByFromLocation(String name);

	/*@Query(value = "SELECT s.* FROM scrap s,category c,subcategory sc,inventory_stock is where s.category_id =? and s.category_id = c.id and c.id = sc.category_id", nativeQuery = true)
	Scrap findScrapById(String parameter);*/
	
	

}
