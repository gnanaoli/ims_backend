package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.InventoryRequest;

public interface InventoryRequestRepository extends JpaRepository<InventoryRequest, Long> {
	
	
    @Query(value = "select i.* from inventory_request i where i.status=:status and i.location=:location and i.model_code=:model and i.warehouse_sitename=:site", nativeQuery = true)
    InventoryRequest isInventoryRequested(@Param("status")String status,@Param("location")String location,@Param("model")String model,@Param("site")String site);

    @Query(value = "select i.* from inventory_request i where (i.status='MOVETOWAREHOUSE REQUESTED' AND i.sub_status='QC VERIFIED')", nativeQuery = true)
	List<InventoryRequest> getMoveRequestNotifications();
    
    
    

    @Query(value = "select SUM(i.quantity) from inventory_request i where i.status=:status and i.requested_from=:requestedFrom AND i.model_code=:model and i.requested_to=:requestedTo", nativeQuery = true)
    Integer getSumOfQuantity(@Param("status")String status,@Param("requestedFrom")String requestedFrom,@Param("model")String model,@Param("requestedTo")String requestedTo);
    
   // @Query(value="select category_id,subcategory_id,quantity,reference_no,requested_from,requested_to,status,sub_status FROM inventory_request ir  WHERE ir.requested_from =:requestedFrom  UNION ALL select  category_id,subcategory_id,quantity,reference_no,requested_from,requested_to,status,sub_status FROM service_inspection sri WHERE sri.requested_from =:requestedFrom UNION ALL select  category_id,subcategory_id,quantity,reference_no,requested_from,requested_to,status,sub_status FROM scrap_inspection si WHERE si.requested_from =:requestedFrom",nativeQuery = true)
    @Query(value="select category_type,sub_category,model,quantity,reference_no,requested_from,requested_to,ir.status,sub_status FROM inventory_request ir JOIN category c ON  c.id=ir.category_id  JOIN subcategory s ON s.id=ir.subcategory_id  WHERE ir.requested_from =:requestedFrom UNION ALL select  category_type,sub_category,model,quantity,reference_no,requested_from,requested_to,sri.status,sub_status FROM service_inspection sri JOIN category c ON  c.id=sri.category_id JOIN subcategory s ON s.id=sri.subcategory_id  WHERE sri.requested_from =:requestedFrom UNION ALL select  category_type,sub_category,model,quantity,reference_no,requested_from,requested_to,si.status,sub_status FROM scrap_inspection si  JOIN category c ON  c.id=si.category_id JOIN subcategory s ON s.id=si.subcategory_id WHERE si.requested_from =:requestedFrom",nativeQuery = true)
	List<Object> findMyrequest(@Param("requestedFrom")String name);

	List<InventoryRequest> findByReferenceNo(String referenceNo);

	List<InventoryRequest> findByRequestedFrom(String projectName);

	List<InventoryRequest> findByRequestedToAndNotificationStatus(String name, String notificationStatus);

	
//    @Query(value="select * from inventory_request i,where raised_date between :fromDate and :toDate",nativeQuery=true)
//	List<InventoryRequest> getRequestReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate );
	
}
