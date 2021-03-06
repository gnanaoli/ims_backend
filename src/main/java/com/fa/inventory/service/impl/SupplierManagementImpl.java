package com.fa.inventory.service.impl;

import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.SupplierDto;
import com.fa.inventory.entity.Supplier;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.SupplierMasterRespository;
import com.fa.inventory.service.SupplierService;

@Service
public class SupplierManagementImpl implements SupplierService {

	private Logger logger = Logger.getLogger(getClass());

	@Resource
	SupplierMasterRespository supplierMasterRespository;

	@Resource
	InventoryStockRepository inventoryStockRepository;

	@Override
	public String AddSupplier(SupplierDto supplierDto, Principal principal) throws Exception {

		String status = InventoryConstant.FAILURE;
		Supplier supplier = new Supplier();

		List<Object> supplierList = null;

		if (supplierDto.getSupplierName() != null && supplierDto.getId() == null) {

			/*supplier = supplierMasterRespository.findByName(supplierDto.getSupplierName());

			if (supplier != null) {
				throw new Exception(InventoryConstant.THE_GIVEN_SUPPLIER_NAME_ALREADY_EXIST);
			}*/ if (supplier != null) {
				supplier = supplierMasterRespository.findByGstin(supplierDto.getGstIn());
				if (supplier != null) {
					throw new Exception(InventoryConstant.ALREADY_GST_ASSIGNED);
				}
			}

		}
		if (supplierDto.getId() != null) {

			supplierList = inventoryStockRepository.findBySupplierName(supplierDto.getSupplierName());

			if (supplierList.size() > 0) {
				throw new Exception(InventoryConstant.ALREADY_ASSIGNED);
			}

			supplier = supplierMasterRespository.findOne(Long.valueOf(supplierDto.getId()));

			if (!supplier.getGstin().equals(supplierDto.getGstIn())) {
				supplier = supplierMasterRespository.findByGstin(supplierDto.getGstIn());
				if (supplier != null) {
					throw new Exception(InventoryConstant.ALREADY_GST_ASSIGNED);
				} else {
					supplier = supplierMasterRespository.findOne(Long.valueOf(supplierDto.getId()));
				}
			}

			supplier.setCode(supplier.getCode());
			supplier.setStatus(supplierDto.getStatus());
			supplier.setCreation_Date(supplier.getCreation_Date());
			supplier.setCreatedBy(supplier.getCreatedBy());
			supplier.setName(supplier.getName());
		} else {
			supplier = new Supplier();
			supplier.setCode(InventoryConstant.SP + getSupplierSequence());
			supplier.setStatus(InventoryConstant.ACTIVE);
			supplier.setCreation_Date(new Date());
			supplier.setCreatedBy(principal.getName());
			supplier.setName(supplierDto.getSupplierName());
		}

		supplier.setCountry(supplierDto.getCountry());
		supplier.setAddress1(supplierDto.getAddress1());
		supplier.setAddress2(supplierDto.getAddress2());
		supplier.setAreaLandmark(supplierDto.getArea());
		supplier.setCity(supplierDto.getCity());
		supplier.setState(supplierDto.getState());
		supplier.setPinCode(MasterDateUtil.ConvertStringtoInteger(supplierDto.getPinCode()));
		supplier.setGodownCountry(supplierDto.getGodownCountry());
		supplier.setGodownAddress1(supplierDto.getGodownAddress1());
		supplier.setGodownAddress2(supplierDto.getGodownAddress2());
		// supplier.setGodownAddress3(supplierDto.getGodownAddress3());
		supplier.setGodownAreaLandmark(supplierDto.getGodownArea());
		supplier.setGodownCity(supplierDto.getGodownCity());
		supplier.setGodownState(supplierDto.getGodownState());
		supplier.setGodownPinCode(MasterDateUtil.ConvertStringtoInteger(supplierDto.getGodownPinCode()));
		supplier.setContactPerson(supplierDto.getContactPerson());
		supplier.setMobileNumber(MasterDateUtil.ConvertStringtoLong(supplierDto.getMobileNo()));
		//supplier.setTelephoneNumber(MasterDateUtil.ConvertStringtoLong(supplierDto.getTelePhoneNo()));
		//supplier.setFax(MasterDateUtil.ConvertStringtoLong(supplierDto.getFax()));
		supplier.setEmailId(supplierDto.getEmailId());
		supplier.setGstin(supplierDto.getGstIn());
		supplier.setLastModifiedBy(principal.getName());
		supplier.setLastModifiedDate(new Date());
		if (supplierDto.getFax() != null && !supplierDto.getFax().isEmpty()){
			supplier.setFax(supplierDto.getFax()+"-"+supplierDto.getFax1());
		}
		else{
			supplier.setFax(null);
		}
		if (supplierDto.getTelePhoneNo() != null && !supplierDto.getTelePhoneNo().isEmpty()){
			supplier.setTelephoneNumber(supplierDto.getStdCode()+"-"+supplierDto.getTelePhoneNo());
		}
		else{
			supplier.setTelephoneNumber(null);
		}
		
		supplier = supplierMasterRespository.save(supplier);
		if (supplier != null) {
			status = InventoryConstant.SUCCESS;
		}
		return status;
	}

	@Override
	public String getSupplierSequence() {
		logger.info("GetSupplierSequence-------started");
		String suppliercode = "";
		try {
			BigInteger supplierCodeValue = supplierMasterRespository.getSupplierSequence();
			if (supplierCodeValue != null)
				suppliercode = String.valueOf(supplierCodeValue);
			else
				logger.info("Code Generation Failed");
		} catch (PersistenceException pe) {
			logger.error("Supplier------getQuoteSequence-------Exception" + pe);
			logger.info("Code Generation Failed");
		}

		logger.info("getQuoteSequence-------Ended");
		return suppliercode;
	}

	@Override
	public List<SupplierDto> viewAllSuppliers() {

		List<SupplierDto> supplierDto = null;

		try {

			List<Supplier> supplier = supplierMasterRespository.findAll();

			if (null != supplier) {
				supplierDto = new ArrayList<>();
				for (Supplier supplierr : supplier) {
					SupplierDto dto = new SupplierDto();
					dto.setId(supplierr.getId());
					dto.setSupplierCode(supplierr.getCode());
					dto.setSupplierName(supplierr.getName());
					dto.setCountry(supplierr.getCountry());
					dto.setAddress1(supplierr.getAddress1());
					dto.setAddress2(supplierr.getAddress2());
					dto.setArea(supplierr.getAreaLandmark());
					dto.setCity(supplierr.getCity());
					dto.setState(supplierr.getState());
					dto.setPinCode(MasterDateUtil.ConvertIntegertoString(supplierr.getPinCode()));
					dto.setGodownCountry(supplierr.getGodownCountry());
					dto.setGodownAddress1(supplierr.getGodownAddress1());
					dto.setGodownAddress2(supplierr.getGodownAddress2());
					dto.setGodownArea(supplierr.getGodownAreaLandmark());
					dto.setGodownCity(supplierr.getGodownCity());
					dto.setGodownState(supplierr.getGodownState());
					dto.setGodownPinCode(MasterDateUtil.ConvertIntegertoString(supplierr.getGodownPinCode()));

					dto.setContactPerson(supplierr.getContactPerson());
					/*dto.setTelePhoneNo(MasterDateUtil.ConvertLongtoString(supplierr.getTelephoneNumber()));*/
					//dto.setTelePhoneNo(supplierr.getTelephoneNumber());
					dto.setMobileNo(MasterDateUtil.ConvertLongtoString(supplierr.getMobileNumber()));
					/*dto.setFax(MasterDateUtil.ConvertLongtoString(supplierr.getFax()));*/
					//dto.setFax(supplierr.getFax());
					
					 String fax= supplierr.getFax();
                     if (fax!= null  && !fax.isEmpty()) {
                                                     //manufacturerDto.setFax(Long.toString(manufacturer.getFax()));
                     /*String str = fax;
                     String[] temp;
                     String delimiter = "-";
                     temp = str.split(delimiter);  
                     String fax_0 = temp[0];  
                     String fax_1 = temp[1];
                     System.out.println(fax_0);
                     System.out.println(fax_1);
                     dto.setFax(fax_0);
                     dto.setFax1(fax_1);*/
                    	 
                    	 String[] test = fax.split("-");
                         
                         if(test.length>=2){
                        	
                        	 dto.setFax(test[0]);
                        	 dto.setFax1(test[1]);
                        	 System.out.println(test[0]);
                        	 System.out.println(test[1]);                      
                         }
                         else{
                        	 System.out.println("Correct");
                         }
                    	 
                    	 
                           }
					
                   
                     String telephone=supplierr.getTelephoneNumber();
                     
                     if(telephone!=null && !telephone.isEmpty() ){
                     String[] test = telephone.split("-");
                    
                     if(test.length>=2){
                    	
                    	 dto.setStdCode(test[0]);
                    	 dto.setTelePhoneNo(test[1]);
                    	 System.out.println(test[0]);
                    	 System.out.println(test[1]);                      
                     }
                     else{
                    	 System.out.println("Correct");
                     }
                    	 
                     
                   }
					
					dto.setEmailId(supplierr.getEmailId());
					dto.setGstIn(supplierr.getGstin());
					dto.setStatus(supplierr.getStatus());
					supplierDto.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return supplierDto;

	}

	@Override
	public List<SupplierDto> findById(Long i) {

		List<SupplierDto> supplierDto = null;

		try {

			List<Supplier> supplier = supplierMasterRespository.findById(i);

			if (null != supplier) {
				supplierDto = new ArrayList<>();
				for (Supplier supplierr : supplier) {
					SupplierDto dto = new SupplierDto();

					dto.setId(supplierr.getId());
					dto.setSupplierCode(supplierr.getCode());
					dto.setSupplierName(supplierr.getName());
					dto.setCountry(supplierr.getCountry());
					dto.setAddress1(supplierr.getAddress1());
					dto.setAddress2(supplierr.getAddress2());
					dto.setArea(supplierr.getAreaLandmark());
					dto.setCity(supplierr.getCity());
					dto.setState(supplierr.getState());
					dto.setPinCode(MasterDateUtil.ConvertIntegertoString(supplierr.getPinCode()));
					dto.setGodownCountry(supplierr.getGodownCountry());
					dto.setGodownAddress1(supplierr.getGodownAddress1());
					dto.setGodownAddress2(supplierr.getGodownAddress2());
					dto.setGodownArea(supplierr.getGodownAreaLandmark());
					dto.setGodownCity(supplierr.getGodownCity());
					dto.setGodownState(supplierr.getGodownState());
					dto.setGodownPinCode(MasterDateUtil.ConvertIntegertoString(supplierr.getGodownPinCode()));
					dto.setContactPerson(supplierr.getContactPerson());
				/*	dto.setTelePhoneNo(MasterDateUtil.ConvertLongtoString(supplierr.getTelephoneNumber()));*/
					//dto.setTelePhoneNo(supplierr.getTelephoneNumber());
					dto.setMobileNo(MasterDateUtil.ConvertLongtoString(supplierr.getMobileNumber()));
					/*dto.setFax(MasterDateUtil.ConvertLongtoString(supplierr.getFax()));*/
					//dto.setFax(supplierr.getFax());
					dto.setEmailId(supplierr.getEmailId());
					dto.setGstIn(supplierr.getGstin());
					dto.setStatus(supplierr.getStatus());
					
					 String fax= supplierr.getFax();
                     if (fax!= null  && !fax.isEmpty() ) {
                                                     //manufacturerDto.setFax(Long.toString(manufacturer.getFax()));
                    /* String str = fax;
                     String[] temp;
                     String delimiter = "-";
                     temp = str.split(delimiter);  
                     String fax_0 = temp[0];  
                     String fax_1 = temp[1];
                     System.out.println(fax_0);
                     System.out.println(fax_1);
                     dto.setFax(fax_0);
                     dto.setFax1(fax_1);*/
                           
                    	 
                    	 String[] test = fax.split("-");
                         
                         if(test.length>=2){
                        	
                        	 dto.setFax(test[0]);
                        	 dto.setFax1(test[1]);
                        	 System.out.println(test[0]);
                        	 System.out.println(test[1]);                      
                         }
                         else{
                        	 System.out.println("Correct");
                         }
                     }
					
                     String telephone=supplierr.getTelephoneNumber();
                     
                     if(telephone!=null && !telephone.isEmpty()){
                    
                    /* String str = telephone;
                     String[] temp;
                     String delimiter = "-";
                     temp = str.split(delimiter);  
                     String std_code = temp[0];  
                     String tele_phone = temp[1];
                     System.out.println(std_code);
                     System.out.println(tele_phone);
                     dto.setStdCode(std_code);
                     dto.setTelePhoneNo(tele_phone);*/
                    	 String[] test = telephone.split("-");
                         
                         if(test.length>=2){
                        	
                        	 dto.setStdCode(test[0]);
                        	 dto.setTelePhoneNo(test[1]);
                        	 System.out.println(test[0]);
                        	 System.out.println(test[1]);                      
                         }
                         else{
                        	 System.out.println("Correct");
                         }
                     
                     }
					
					supplierDto.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return supplierDto;
	}

}
