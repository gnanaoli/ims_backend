package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.ProjectType;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findByStatus(String active);

	List<Project> findByCountryName(String countryName);

	List<Project> findByState(String state);

	List<Project> findByCity(String city);

	Project findByName(String projectName);

	ProjectType findByProjectType(String projectType);
	
	@Query(value="select i.* from project i where i.name=:name and i.id!=:id",nativeQuery=true)
	Project findByNameExceptThisId(@Param("id")Long id,@Param("name")String name);

}
