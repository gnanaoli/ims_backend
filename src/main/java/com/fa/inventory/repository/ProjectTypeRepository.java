package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

	List<ProjectType> findByStatus(String active);

	ProjectType findByType(String projectType); 
		

}
