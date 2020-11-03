package com.fa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.inventory.entity.WareHouseBlocks;

public interface WareHouseBlockRepository extends JpaRepository<WareHouseBlocks, Long> {

	WareHouseBlocks findByBlocksNames(String blocksNames);

	WareHouseBlocks findByCode(String code);

}
