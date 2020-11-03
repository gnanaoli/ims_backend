package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long>{

	Department findByName(String name);

	

	
	
}
