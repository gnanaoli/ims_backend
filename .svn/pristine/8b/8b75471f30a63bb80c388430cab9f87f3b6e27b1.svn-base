package com.fa.inventory.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.inventory.entity.InventoryRequest;

public interface ToolsRequestRepository extends JpaRepository<InventoryRequest,Long>{

	@Query(value = "call referenceno_seq()", nativeQuery = true)
	BigInteger getRefNoSequence();

	InventoryRequest findByRequestedTo(String name);

	List<InventoryRequest> findByStatusAndRequestedTo(String requested, String requestedTo);

	List<InventoryRequest> findByStatusAndLocation(String requested, String string);
	
//	@Query(value="select e.* from elcb e,where updated_time between e.updated_time=:fromDate and e.updated_time=:toDate",nativeQuery=true)
//	List<ELCB> getElcpReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate );

}
