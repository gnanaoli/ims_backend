package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.Type;

public interface TypeRepository  extends JpaRepository<Type, Long>{

	Type findByType(String type);

}
