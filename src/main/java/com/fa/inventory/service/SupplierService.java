package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.SupplierDto;

public interface SupplierService {
	
	
	
	/** Add Supplier  */
	String AddSupplier(SupplierDto supplierDto,Principal principal) throws Exception; 
	
	/** Get Sequence for Supplier Code */	
	String getSupplierSequence();
	
	
    /** Get All Supplier By Id 
     * @param i */
	
	List<SupplierDto> findById(Long i);
	
	
    /** Get All Suppliers */
	
	List<SupplierDto> viewAllSuppliers();

}
