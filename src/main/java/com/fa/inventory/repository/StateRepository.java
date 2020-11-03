package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{

	State findByName(String stateName);

	State findByCode(String stateCode);

}
