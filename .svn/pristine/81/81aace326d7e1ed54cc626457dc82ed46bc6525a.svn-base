package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.ELCB;

public interface ELCBRepository extends JpaRepository<ELCB, Long>{

	
	@Query(value = "call elcb_office_unchecked()", nativeQuery = true)
	List<Object> getLastOneMonthOfficceElcbStatus();
	
	@Query(value = "call elcb_safetyengineer_status(?1)", nativeQuery = true)
	List<Object> getLastOneMonthUserElcbStatus(String userid);

	
//	@Query(value="select e.* from elcb e,where updated_time between e.updated_time=:fromDate and e.updated_time=:toDate",nativeQuery=true)
//	List<ELCB> getElcpReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate );

}
