package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.ServiceInspection;

public interface ServiceInspectionRepository extends JpaRepository<ServiceInspection, Long> {

	List<ServiceInspection> findByRequestedFrom(String name);

}
