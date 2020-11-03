package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.City;

public interface CityRepository extends JpaRepository<City, Long>{

	City findByName(String cityName);

	City findByCode(String cityCode);

}
