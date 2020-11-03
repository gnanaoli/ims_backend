package com.fa.inventory.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.inventory.entity.ProjectTasks;

public interface ProjectTasksRepository extends JpaRepository<ProjectTasks, Long>{

	ProjectTasks findByProjectId(Long id);

	
	@Query(value = "call task_id_seq()", nativeQuery = true)
	BigInteger getTaskIdSequence();


	

	List<ProjectTasks> findByTaskId(String taskId);



}
