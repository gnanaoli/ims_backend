package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.ProjectStatus;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Long>{

	List<ProjectStatus> findByStatus(String status);

	ProjectStatus findByStatusType(String projectstatus);

}
