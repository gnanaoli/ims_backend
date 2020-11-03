package com.fa.inventory.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.inventory.entity.Supplier;

public interface SupplierMasterRespository extends JpaRepository<Supplier, Long> {

	@Query(value = "call supplier_seq()", nativeQuery = true)
	public BigInteger getSupplierSequence();

	public List<Supplier> findById(Long i);

	public Supplier findByName(String name);
	
	
}
