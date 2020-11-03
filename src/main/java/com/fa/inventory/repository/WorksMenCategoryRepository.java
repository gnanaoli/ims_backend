package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.WorksMenCategory;

public interface WorksMenCategoryRepository extends JpaRepository<WorksMenCategory, Long> {

	WorksMenCategory findByCategory(String category);

}
