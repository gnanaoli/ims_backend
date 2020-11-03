package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.DispatcherLog;

public interface DispatchLogRepository extends JpaRepository<DispatcherLog, Long> {
	
	
	//@Query(value="select sum(available_quantity),i.requested_to from dispatcher_log i where i.requested_from=:requested_from and (status='PENDING' or status='PARTIALLY DISPATCHED')  group by i.requested_to order by i.requested_to",nativeQuery=true)
	@Query(value="select sum(available_quantity),i.requested_to,i.requested_from from dispatcher_log i where i.requested_from=:requested_from AND i.available_quantity != '0' group by i.requested_to order by i.requested_to",nativeQuery=true)
    List<Object> getAvailableQuantityCount(@Param("requested_from")String site);
	
	
	List<DispatcherLog>  findByRequestedToAndRequestedFrom(String requestedTo,String requestedFrom);
	
	List<DispatcherLog>  findByRequestedFrom(String requestedFrom);
	
	@Query(value="select d.* from dispatcher_log d,delivery_challan dc where  d.challan_no=:challanNo and d.id=dc.dispatchlog_id",nativeQuery=true)
	List<DispatcherLog> getDispatcherLogByChallanNo(@Param("challanNo")String challanNo);


	List<DispatcherLog> findBychallanNo(String challanNo);


	List<DispatcherLog> findByRequestedToAndStatusAndSubStatusAndChallanNo(String name, String itemDispatched,
			String challanGenerated,String challanNo);


	@Query(value="select * from dispatcher_log where (status='PARTIALLY DISPATCHED' OR status='ITEM DISPATCHED') AND requested_to=:projectName and sub_status='CHALLAN GENERATED' AND challan_no=:challanNo",nativeQuery=true)
	List<DispatcherLog> findDispatcherLogByChallanNo(@Param("projectName") String projectName,@Param("challanNo") String challanNo);
	
	


	List<DispatcherLog> findByInventoryNumberAndStatusAndRequestedTo(String inventoryNumber,String status,String requestedTo);
	
	
	
	
	/*List<DispatcherLog> findByRequestedFromAndStatus(String requestedFrom,String status);*/

}
