package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu , Long> {
	
	@Query(value="select DISTINCT(m.page_name) from role r,user u,user_role ur,menu m where  m.page_name=:pageName and m.status='ACTIVE'  and u.user_name=:userName and m.role_id=r.id  and u.id=ur.user_fk_id and r.id=ur.role_fk_id",nativeQuery=true)
	String getMenuAccess(@Param("pageName")String pageName,@Param("userName")String userName);
	

}
