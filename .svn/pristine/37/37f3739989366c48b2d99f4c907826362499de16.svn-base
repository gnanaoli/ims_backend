package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.InventoryEntrance;

public interface InventoryStockRepository extends JpaRepository<InventoryEntrance, Long> {
	
	List<InventoryEntrance> findByWareHouseSiteName(String name);

	InventoryEntrance findByModelcode(String modelCode);
	
//	List<InventoryEntrance> findBySubCategoryName(String subCategory);
	
	
		
	
	/*@Query(value="select ins.id, category_type,sub_category,model,quantity,location,warehouse_sitename FROM inventory_stock ins JOIN category c ON ins.category_id = c.id JOIN subcategory s ON ins.subcategory_id=s.id  WHERE (c.category_type LIKE %:searchKeyword% OR s.sub_category LIKE %:searchKeyword% OR s.model LIKE %:searchKeyword%)  UNION ALL (select ia.id, category_type,sub_category,model,ia.leftover_qty,ia.inventory_location,ia.assigned_location FROM inventory_assign ia JOIN category c ON  ia.category_id = c.id JOIN subcategory s ON ia.subcategory_id =s.id WHERE c.category_type LIKE %:searchKeyword% OR s.sub_category LIKE %:searchKeyword% OR s.model LIKE %:searchKeyword%)",nativeQuery=true)*/
	
	@Query(value="select ins.id, category_type,sub_category,model,available_quantity,location,warehouse_sitename FROM inventory_stock ins JOIN category c ON ins.category_id = c.id JOIN subcategory s ON ins.subcategory_id=s.id  WHERE (c.category_type LIKE %:searchKeyword% OR s.sub_category LIKE %:searchKeyword% OR s.model LIKE %:searchKeyword%)  UNION ALL (select ia.id, category_type,sub_category,model,ia.available_qty,ia.inventory_location,ia.assigned_location FROM inventory_assign ia JOIN category c ON  ia.category_id = c.id JOIN subcategory s ON ia.subcategory_id =s.id WHERE c.category_type LIKE %:searchKeyword% OR s.sub_category LIKE %:searchKeyword% OR s.model LIKE %:searchKeyword%)",nativeQuery=true)
	
	List<Object> findtools(@Param("searchKeyword") String subCategory);	
	
	@Query(value="select i.* from inventory_stock i,subcategory s where i.sub_category_name=:subCategory and i.subcategory_id=s.id  and i.warehouse_sitename=:warehouse_sitename order by i.quantity desc  limit 1",nativeQuery=true)
	InventoryEntrance getMaxQuantity(@Param("subCategory") String subcategory,@Param("warehouse_sitename")String wareHouseOrSiteName);

	InventoryEntrance findByInventoryNumberAndWareHouseSiteName(String inventoryNumber, String site);
	
	@Query(value="select i.warehouse_sitename,sum(i.available_quantity) from inventory_stock i where i.warehouse_sitename=:warehouse_sitename group by i.warehouse_sitename",nativeQuery=true)
	Object getInventoryCountForSpecificWareHouseAdministrator(@Param("warehouse_sitename")String wareHouseName);
	
	
	@Query(value="select i.warehouse_sitename,sum(i.available_quantity) from inventory_stock i group by i.warehouse_sitename",nativeQuery=true)
	List<Object> getAllInventoryCountFromAllWareHouse();
	
	

    @Query(value="select from inventory_stock i,where last_modified_date between =:fromDate and =:toDate",nativeQuery=true)
    List<InventoryEntrance> getInventoryReport(@Param("fromDate")String fromDate,@Param("toDate")String toDate );

	List<InventoryEntrance> findBySubCategoryName(String subCategory);

	InventoryEntrance findByInventoryNumber(String inventoryNumber);
	//InventoryEntrance findone(String subCategory);
	
	@Query(value="	select ins.id, category_type,sub_category,model,available_quantity,location,warehouse_sitename FROM inventory_stock ins JOIN category c ON ins.category_id = c.id JOIN subcategory s ON ins.subcategory_id=s.id WHERE  ins.warehouse_sitename NOT IN(:projectName) and  (c.category_type LIKE %:searchKeyword% OR s.sub_category LIKE %:searchKeyword% OR s.model LIKE %:searchKeyword%)  UNION ALL select ia.id, category_type,sub_category,model,ia.available_qty,ia.inventory_location,ia.assigned_location  FROM inventory_assign ia JOIN category c ON  ia.category_id = c.id JOIN subcategory s ON ia.subcategory_id =s.id WHERE  (ia.assigned_location NOT IN(:projectName)) and( c.category_type LIKE %:searchKeyword% OR s.sub_category LIKE %:searchKeyword% OR s.model LIKE %:searchKeyword%)",nativeQuery=true)
	List<Object> findtools(@Param("searchKeyword") String searchKeyword,@Param("projectName")List<String> projectName);

}

