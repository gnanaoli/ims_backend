package com.fa.inventory.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	User findByUserName(String userName);
	
	@Query(value="select distinct (m.page_name),m.menu_icon,m.menu_category,m.menu_name from user u,user_role ur,menu m where u.user_name=:userName and ur.user_fk_id=u.id and  m.role_id=ur.role_fk_id and m.status=:status  group by m.page_name  order by m.order_no asc",nativeQuery=true)
	List<String[]> getCurrentPages(@Param("userName")String userName,@Param("status")String status);

	User findByEmpid(String empid);

	@Query(value = "call emp_id_seq()", nativeQuery = true)
	BigInteger getEmpSequence();
	
	@Query(value = "call emp_offroll_id_seq()", nativeQuery = true)
	BigInteger getEmpOffRollSequence();

}
