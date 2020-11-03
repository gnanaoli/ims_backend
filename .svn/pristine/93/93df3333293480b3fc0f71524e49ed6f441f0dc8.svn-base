
package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.InventoryAssign;

public interface InventoryAssignRepository extends JpaRepository<InventoryAssign, Long>{

	List<InventoryAssign> findBySubCategoryName(String subCategoryName);
	
	List<InventoryAssign> findByWareHouseSiteName(String name);

	@Query(value="select i.* from inventory_assign i,subcategory s where s.sub_category=:subCategory and i.subcategory_id=s.id  and i.assigned_location=:requested_to order by i.available_qty desc  limit 1",nativeQuery=true)
	InventoryAssign getMaxQuantity(@Param("subCategory") String subcategory,@Param("requested_to")String requestedTo);
	
	
	@Query(value="select sum(available_qty) from inventory_assign i where i.warehouse_or_sitename=:warehouse_or_sitename",nativeQuery=true)
    Integer getInventoryCount(@Param("warehouse_or_sitename")String warehouse_or_sitename);
	
	
	@Query(value="select i.assigned_location,sum(i.available_qty) from inventory_assign i group by i.assigned_location;",nativeQuery=true)
	List<Object> getInventoryCountFromAllProject();

	InventoryAssign findByWareHouseSiteNameAndInventoryNumber(String site,String inventoryNumber);

	List<InventoryAssign> findByAssignedLocation(String assignedLocation);

	List<InventoryAssign> findByInventoryLocation(String inventoryLocation);

	@Query(value="select i.assigned_location,sum(i.available_qty) from inventory_assign i where i.assigned_location=:assigned_location group by i.assigned_location",nativeQuery=true)
	Object getInventoryCountFromSpecificUserProject(@Param("assigned_location")String assignedLocation);

	List<InventoryAssign> findByCategory(Long id);

	

}
