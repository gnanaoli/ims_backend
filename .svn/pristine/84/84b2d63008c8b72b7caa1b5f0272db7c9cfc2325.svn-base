package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

	Manufacturer findByName(String name);

	List<Manufacturer> findByStatus(String active);

	Manufacturer findByCode(String code);

}
