package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.WareHouse;

public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

	List<WareHouse> findByStatus(String active);

	WareHouse findByWareHouseName(String wareHouseName);

	WareHouse findByCode(String code);

	
	
	@Query(value="select i.* from warehouse i where i.code=:code and i.id!=:id",nativeQuery=true)
	WareHouse getWareHouseNameExceptInGivenId(@Param("id")Long id,@Param("code")String code);
	

}
