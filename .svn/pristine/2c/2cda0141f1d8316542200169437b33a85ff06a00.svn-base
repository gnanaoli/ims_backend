package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.DeliveryChallanEntity;
import com.fa.inventory.entity.InventoryEntrance;

public interface DeliveryChallanEntityRepository extends JpaRepository<DeliveryChallanEntity, Long> {
	
	//@Query(value="select dc.* from dispatcher_log d,delivery_challan dc where  d.challan_no=:challanNo and d.id=dc.dispatchlog_id",nativeQuery=true)
	@Query(value="select * from dispatcher_log d where d.challan_no=:challanNo",nativeQuery=true)
	List<DeliveryChallanEntity> getDeliveryChallanEntityList(@Param("challanNo")String challanNo);

	 @Query(value="select from delivery_challan i,where dispatch_date between =:fromDate and =:toDate",nativeQuery=true)
	    List<InventoryEntrance> getInventoryReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate );
	 
	 
	 @Query(value="select * from delivery_challan where status='ITEM DISPATCHED'AND place_of_supply=:projectName AND sub_status='CHALLAN GENERATED' AND challan_no=:challanNo",nativeQuery=true)
		List<DeliveryChallanEntity> findDeliveryChallanEntityByChallanNo(@Param("projectName") String projectName,@Param("challanNo") String challanNo);
	 
	 
	 List<DeliveryChallanEntity> findByChallanNo(String challanNo);
	 
	 
	
}
