package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.ServiceTracker;

public interface ServiceTrackerRepository extends JpaRepository<ServiceTracker, Long> {

	@Query(value="select  stock.service_due_date,stock.warehouse_sitename ,(select c.category_type from  category c where c.id=stock.category_id ) as category_type,stock.sub_category_name,'LAST MONTH' as due_month from inventory_stock stock where MONTH(stock.service_due_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) UNION select  stock.service_due_date,stock.warehouse_sitename ,(select c.category_type from  category c where c.id=stock.category_id ) as category_name,stock.sub_category_name,'CURRENT MONTH' as due_month from inventory_stock stock where MONTH(stock.service_due_date) = MONTH(CURRENT_DATE ) UNION select stock.service_due_date,stock.warehouse_sitename,(select c.category_type from  category c where c.id=stock.category_id) as category_name, stock.sub_category_name,'NEXT MONTH' as due_month from inventory_stock stock where  MONTH(stock.service_due_date) = MONTH(CURRENT_DATE + INTERVAL 1 MONTH)",nativeQuery = true)
	List<Object> getAllServiceDueDate();

	@Query(value="select stock.service_due_date,stock.warehouse_sitename,(select c.category_type from  category c where c.id=stock.category_id) as category_type,stock.sub_category_name,'LAST MONTH' as due_month from inventory_stock stock where stock.id in(select ia.inventory_stock_id from inventory_assign ia where ia.assigned_location IN (:projectName) and MONTH(stock.service_due_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)) UNION select  stock.service_due_date,stock.warehouse_sitename,(select c.category_type from  category c where c.id=stock.category_id) as category_type,stock.sub_category_name,'CURRENT MONTH' as due_month from inventory_stock stock where stock.id in(select ia.inventory_stock_id from inventory_assign ia where ia.assigned_location IN (:projectName) and MONTH(stock.service_due_date) = MONTH(CURRENT_DATE)) UNION select stock.service_due_date,stock.warehouse_sitename,(select c.category_type from  category c where c.id=stock.category_id) as category_name,stock.sub_category_name,'NEXT MONTH' as due_month from inventory_stock stock where stock.id in(select ia.inventory_stock_id from inventory_assign ia where ia.assigned_location IN (:projectName) and MONTH(stock.service_due_date) = MONTH(CURRENT_DATE + INTERVAL 1 MONTH))",nativeQuery=true)
	List<Object> getAllUserServiceDueDate(@Param("projectName") List<String> projectList);

	@Query(value="select  stock.service_due_date,stock.warehouse_sitename ,(select c.category_type from  category c where c.id=stock.category_id ) as category_name,stock.sub_category_name,'LAST MONTH' as due_month from inventory_stock stock where stock.warehouse_sitename IN (:wareHouseName) and MONTH(stock.service_due_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) UNION select stock.service_due_date,stock.warehouse_sitename ,(select c.category_type from  category c where c.id=stock.category_id ) as category_name,stock.sub_category_name,'CURRENT MONTH' as due_month from inventory_stock stock where stock.warehouse_sitename IN (:wareHouseName) and MONTH(stock.service_due_date) = MONTH(CURRENT_DATE ) UNION select stock.service_due_date,stock.warehouse_sitename,(select c.category_type from category c where c.id=stock.category_id ) as category_name,stock.sub_category_name,'NEXT MONTH' as due_month from inventory_stock stock where stock.warehouse_sitename IN (:wareHouseName) and MONTH(stock.service_due_date) = MONTH(CURRENT_DATE + INTERVAL 1 MONTH)",nativeQuery=true)
	List<Object> getAllWareHouseServiceDueDate(@Param("wareHouseName") List<String> warehouseList);

	
}
