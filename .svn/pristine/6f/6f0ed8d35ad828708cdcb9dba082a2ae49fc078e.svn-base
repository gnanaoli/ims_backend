package com.fa.inventory.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.InventoryRequest;

public interface ToolsRequestRepository extends JpaRepository<InventoryRequest,Long>{

	@Query(value = "call referenceno_seq()", nativeQuery = true)
	BigInteger getRefNoSequence();

	InventoryRequest findByRequestedTo(String name);

	List<InventoryRequest> findByStatusAndRequestedTo(String requested, String requestedTo);

	List<InventoryRequest> findByStatusAndLocation(String requested, String string);
	
//	@Query(value="select e.* from elcb e,where updated_time between e.updated_time=:fromDate and e.updated_time=:toDate",nativeQuery=true)
//	List<ELCB> getElcpReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate );


	@Transactional
	@Modifying
	@Query(value="update inventory_stock ir set ir.available_quantity=?1 where ir.id=?2",nativeQuery=true)
	Integer getAllQuantity(Integer availableQuantity,Long id);

	
	
	@Transactional
	@Modifying
	@Query(value="update inventory_assign ir set ir.available_qty=?1 where ir.id=?2",nativeQuery=true)
	Integer getAllQuantity1(Integer availableQty,Long id);
	

	@Transactional
	@Modifying
	@Query(value="update inventory_request ir set ir.accepted_quantity=?1,ir.status=?2 where ir.id=?3",nativeQuery=true)
	Integer updateAcceptedQty(Integer acceptedQuantity,String status,Long id);
	
	

	//InventoryRequest saveAndFlush(InventoryEntrance inventoryEntrance);
	
}
