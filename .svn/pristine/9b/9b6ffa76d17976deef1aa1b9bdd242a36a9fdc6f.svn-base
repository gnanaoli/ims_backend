package com.fa.inventory.service.impl;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.controller.InventoryController;
import com.fa.inventory.dto.ManufacturerDto;
import com.fa.inventory.entity.Manufacturer;
import com.fa.inventory.repository.ManufacturerRepository;
import com.fa.inventory.service.ManufacturerService;
@Service
public class ManufacturerServiceImpl implements ManufacturerService{
        protected final Logger logger = Logger.getLogger(InventoryController.class);

        @Resource
        ManufacturerRepository manufacturerRepository;
/* @Override
        public List<ManufacturerDto> getManufacturerDtoList(Principal principal) {
                List<ManufacturerDto> manufacturerDtoList = null;
                logger.info("<--ManufacturerServiceImpl-------------getManufacturerList--------------------started-->");
                try {
                        List<Manufacturer> manufacturerList=manufacturerRepository.findAll();
                        
                        if(manufacturerList!=null && !manufacturerList.isEmpty())
                        {
                                manufacturerDtoList=new ArrayList<>();
                                for(int i=0;i<manufacturerList.size();i++)
                                {
                                        Manufacturer manufacturer=manufacturerList.get(i);
                                        if(manufacturer!=null)
                                        {
                                                manufacturerDtoList.add(MapManufacturerDto(manufacturer,principal));
                                                
                                        }
                                }
                        }
                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
                logger.info("<--ManufacturerServiceImpl-------------getManufacturerList--------------------Ended-->");
                return manufacturerDtoList;
        }
        
        
        public ManufacturerDto MapManufacturerDto(Manufacturer manufacturer,Principal principal)
        {
                logger.info("<--ManufacturerServiceImpl-------------MapManufacturerDto--------------------started-->");
                ManufacturerDto manufacturerDto=new ManufacturerDto();
        
                manufacturerDto.setId(manufacturer.getId());
                manufacturerDto.setName(manufacturer.getName());
                manufacturerDto.setCode(manufacturer.getCode());
                manufacturerDto.setCountry(manufacturer.getCountry());
                manufacturerDto.setAddress1(manufacturer.getAddress1());
                manufacturerDto.setAddress2(manufacturer.getAddress2());
                manufacturerDto.setAddress3(manufacturer.getAddress3());
                manufacturerDto.setAreaLandmark(manufacturer.getAreaLandmark());
                manufacturerDto.setState(manufacturer.getState());
                manufacturerDto.setCity(manufacturer.getCity());
                manufacturerDto.setPincode(manufacturer.getPinCode());
                manufacturerDto.setContactPerson(manufacturer.getContactPerson());
                manufacturerDto.setTelephoneNumber(Integer.toString(manufacturer.getTelephoneNumber()));
                manufacturerDto.setMobileNumber(Long.toString(manufacturer.getMobileNumber()));
                manufacturerDto.setFax(Integer.toString(manufacturer.getFax()));
                manufacturerDto.setEmailId(manufacturer.getEmailId());
                manufacturerDto.setGstIn(manufacturer.getGstIn());
                manufacturerDto.setStatus(manufacturer.getStatus());
                manufacturerDto.setCreatedBy(manufacturer.getCreatedBy());
                
                
                logger.info("<--ManufacturerServiceImpl-------------MapManufacturerDto--------------------ended-->");
                return manufacturerDto;
        }
        
        @Override
        public String saveManufacturer(ManufacturerDto manufacturerDto,Principal principal)
        {
                Manufacturer manufacturer=null;
                logger.info("<--ManufacturerServiceImpl-------------saveManufacturer--------------------started-->");
                try {
                        if(manufacturerDto!=null && manufacturerDto.getId()!=null){
                                manufacturer=manufacturerRepository.findOne(manufacturerDto.getId());
                                
                                manufacturer.setId(manufacturerDto.getId());
                                manufacturer.setName(manufacturerDto.getName());
                                manufacturer.setCode(manufacturerDto.getCode());
                                manufacturer.setCountry(manufacturerDto.getCountry());
                                manufacturer.setAddress1(manufacturerDto.getAddress1());
                                manufacturer.setAddress2(manufacturerDto.getAddress2());
                                manufacturer.setAddress3(manufacturerDto.getAddress3());
                                manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                manufacturer.setState(manufacturerDto.getState());
                                manufacturer.setCity(manufacturerDto.getCity());
                                manufacturer.setPinCode(manufacturerDto.getPincode());
                                manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                manufacturer.setTelephoneNumber(Integer.parseInt(manufacturerDto.getTelephoneNumber()));
                                manufacturer.setMobileNumber(Long.parseLong(manufacturerDto.getMobileNumber()));
                                manufacturer.setFax(Integer.parseInt(manufacturerDto.getFax()));
                                manufacturer.setEmailId(manufacturerDto.getEmailId());
                                manufacturer.setGstIn(manufacturerDto.getGstIn());
                                manufacturer.setStatus(manufacturerDto.getStatus());
                                manufacturer.setCreatedBy(manufacturerDto.getCreatedBy());
                                manufacturer.setCreation_Date(MasterDateUtil.convertStringToTimeStampDate(manufacturerDto.getCreation_Date()));
                                manufacturer.setLastModifiedBy(principal.getName()); 
                                manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                        }
                        else{
                                manufacturer=new Manufacturer();
                                
                                manufacturer.setId(manufacturerDto.getId());
                                manufacturer.setName(manufacturerDto.getName());
                                manufacturer.setCode(manufacturerDto.getCode());
                                manufacturer.setCountry(manufacturerDto.getCountry());
                                manufacturer.setAddress1(manufacturerDto.getAddress1());
                                manufacturer.setAddress2(manufacturerDto.getAddress2());
                                //manufacturer.setAddress3(manufacturerDto.getAddress3());
                                //manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                manufacturer.setState(manufacturerDto.getState());
                                manufacturer.setCity(manufacturerDto.getCity());
                                manufacturer.setPinCode(manufacturerDto.getPincode());
                                manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                //manufacturer.setTelephoneNumber(Integer.parseInt(manufacturerDto.getTelephoneNumber()));
                                //manufacturer.setMobileNumber(Long.parseLong(manufacturerDto.getMobileNumber()));
                                //manufacturer.setFax(Integer.parseInt(manufacturerDto.getFax()));
                                manufacturer.setEmailId(manufacturerDto.getEmailId());
                                manufacturer.setGstIn(manufacturerDto.getGstIn());
                                manufacturer.setStatus(manufacturerDto.getStatus());
                                manufacturer.setCreatedBy(principal.getName());
                                manufacturer.setCreation_Date(new Timestamp(new Date().getTime()));
                                manufacturer.setLastModifiedBy(principal.getName()); 
                                manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                
                                
                        }
                        manufacturerRepository.save(manufacturer);                        
                } catch (Exception e) {
                        e.printStackTrace();
                }
                logger.info("<--ManufacturerServiceImpl-------------saveManufacturer--------------------ended-->");
                return "success";
        }
        
        @Override
        public ManufacturerDto getManufacturer(Long id) {
                
                Manufacturer manufacturer=manufacturerRepository.findOne(id);
                ManufacturerDto manufacturerDto=new ManufacturerDto();
                        
                manufacturerDto.setId(manufacturer.getId());
                manufacturerDto.setName(manufacturer.getName());
                manufacturerDto.setCode(manufacturer.getCode());
                manufacturerDto.setCountry(manufacturer.getCountry());
                manufacturerDto.setAddress1(manufacturer.getAddress1());
                manufacturerDto.setAddress2(manufacturer.getAddress2());
                //manufacturerDto.setAddress3(manufacturer.getAddress3());
                //manufacturerDto.setAreaLandmark(manufacturer.getAreaLandmark());
                manufacturerDto.setState(manufacturer.getState());
                manufacturerDto.setCity(manufacturer.getCity());
                //manufacturerDto.setPincode(Integer.toString(manufacturer.getPinCode()));
                manufacturerDto.setContactPerson(manufacturer.getContactPerson());
                //manufacturerDto.setTelephoneNumber(Integer.toString(manufacturer.getTelephoneNumber()));
                //manufacturerDto.setMobileNumber(Long.toString(manufacturer.getMobileNumber()));
                //manufacturerDto.setFax(Integer.toString(manufacturer.getFax()));
                manufacturerDto.setEmailId(manufacturer.getEmailId());
                manufacturerDto.setGstIn(manufacturer.getGstIn());
                manufacturerDto.setStatus(manufacturer.getStatus());
                //manufacturerDto.setCreatedBy(manufacturer.getCreatedBy());
                
                return manufacturerDto;
        }
*/
        /*FOR GET VALUE TO MANUFACTURER TABLE*/
        	@Override
                public List<ManufacturerDto> getManufacturerDtoList(Principal principal) {
                        List<ManufacturerDto> manufacturerDtoList = null;
                        logger.info("<--manufacturer Service impl-------------getManufacturerDtoList--------------------started-->");
                        try {
                                List<Manufacturer> manufacturerList=manufacturerRepository.findAll();
                                
                                if(manufacturerList!=null && !manufacturerList.isEmpty())
                                {
                                        manufacturerDtoList=new ArrayList<>();
                                        for(int i=0;i<manufacturerList.size();i++)
                                        {
                                                Manufacturer manufacturer=manufacturerList.get(i);
                                                if(manufacturer!=null)
                                                {
                                                        manufacturerDtoList.add(MapManufacturerDto(manufacturer,principal));
                                                        
                                                }
                                        }
                                }
                                
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                        logger.info("<--Manufacturer Service-------------getManufacturerDtoList--------------------Ended-->");
                        return manufacturerDtoList;
                }
                
                
                public ManufacturerDto MapManufacturerDto(Manufacturer manufacturer,Principal principal)
                {
                        logger.info("<--Manufacturer ServiceImpl-------------MapManufacturerDto--------------------started-->");
                        ManufacturerDto manufacturerDto=new ManufacturerDto();
                        try {
                        	manufacturerDto.setId(manufacturer.getId());
                            manufacturerDto.setName(manufacturer.getName());
                            manufacturerDto.setCode(manufacturer.getCode());
                            manufacturerDto.setCountry(manufacturer.getCountry());
                            manufacturerDto.setAddress1(manufacturer.getAddress1());
                            manufacturerDto.setAddress2(manufacturer.getAddress2());
                            manufacturerDto.setAddress3(manufacturer.getAddress3());
                            manufacturerDto.setAreaLandmark(manufacturer.getAreaLandmark());
                            manufacturerDto.setState(manufacturer.getState());
                            manufacturerDto.setCity(manufacturer.getCity());
                            manufacturerDto.setPincode(manufacturer.getPinCode());
                            manufacturerDto.setContactPerson(manufacturer.getContactPerson());
                            manufacturerDto.setIndiaOrOutside(manufacturer.getIndiaOrOutside());
                            if(manufacturer.getTelephoneNumber()!=null)
                            {
                                    manufacturerDto.setTelephoneNumber(Long.toString(manufacturer.getTelephoneNumber()));        
                            }
                            if(manufacturer.getFax()!=null)
                            {
                                    manufacturerDto.setFax(Long.toString(manufacturer.getFax()));        
                            }
                            
                            if(manufacturer.getMobileNumber()!=null)
                            {
                                    manufacturerDto.setMobileNumber(manufacturer.getMobileNumber());        
                            }
                            
                            manufacturerDto.setUrl(manufacturer.getUrl());
                            manufacturerDto.setEmailId(manufacturer.getEmailId());
                            manufacturerDto.setGstIn(manufacturer.getGstIn());
                            manufacturerDto.setStatus(manufacturer.getStatus());
                            manufacturerDto.setCreatedBy(manufacturer.getCreatedBy());
                            if(manufacturer.getCreationDate()!=null){
            manufacturerDto.setCreationDate(MasterDateUtil.convertDateToString(manufacturer.getCreationDate()));
            
                            }
                                
                                
                        } catch (Exception e) {
                                
                                e.printStackTrace();
                        }
                        logger.info("<--ManufacturerServiceImpl-------------manufacturerDto-------------------ended-->");
                        return manufacturerDto;
                }
                
 /*FOR SAVE THE MANUFACTURER*/
                
                @Override
                public String saveManufacturer(ManufacturerDto manufacturerDto,Principal principal)throws Exception  {
                        String status=InventoryConstant.FAILURE;
                
                                
                                logger.info("<--ManufacturerServiceImpl-------------saveManufacturer--------------------started-->");
                            
                                        Manufacturer manufacturer=null;
                                        if(manufacturerDto!=null && manufacturerDto.getId()!=null){
                                        	    manufacturer=new Manufacturer();
                                        	    manufacturer=manufacturerRepository.findOne(manufacturerDto.getId());
                                        	    if(manufacturer!=null){
                                        	    	if(manufacturer.getName().equals(manufacturerDto.getName())){
                                        	    		if(manufacturer.getCode().equals(manufacturerDto.getCode())){
                                        	    			manufacturer.setCountry(manufacturerDto.getCountry());
                                                            manufacturer.setAddress1(manufacturerDto.getAddress1());
                                                            manufacturer.setAddress2(manufacturerDto.getAddress2());
                                                            manufacturer.setAddress3(manufacturerDto.getAddress3());
                                                            manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                                            manufacturer.setState(manufacturerDto.getState());
                                                            manufacturer.setCity(manufacturerDto.getCity());
                                                            manufacturer.setUrl(manufacturerDto.getUrl());
                                                            manufacturer.setPinCode(manufacturerDto.getPincode());
                                                            manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                                            if(manufacturerDto.getTelephoneNumber()!=null && !manufacturerDto.getTelephoneNumber().isEmpty()){
                                                            manufacturer.setTelephoneNumber(Long.parseLong(manufacturerDto.getTelephoneNumber()));
                                                            }
                                                            if(manufacturerDto.getMobileNumber()!=null && !manufacturerDto.getMobileNumber().isEmpty()){
                                                            manufacturer.setMobileNumber(manufacturerDto.getMobileNumber());
                                                            }
                                                        
                                                            if(manufacturerDto.getFax()!=null && !manufacturerDto.getFax().isEmpty()){
                                                            manufacturer.setFax(Long.parseLong(manufacturerDto.getFax()));
                                                            }
                                                            manufacturer.setUrl(manufacturerDto.getUrl());
                                                            manufacturer.setIndiaOrOutside(manufacturerDto.getIndiaOrOutside());
                                                            manufacturer.setEmailId(manufacturerDto.getEmailId());
                                                            manufacturer.setGstIn(manufacturerDto.getGstIn());
                                                            manufacturer.setStatus(manufacturerDto.getStatus());
                                                            manufacturer.setLastModifiedBy(principal.getName());
                                                            manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                        	    			
                                        	    		}
                                        	    		else{
                                        	    			
                                        	    			manufacturer=manufacturerRepository.findByCode(manufacturerDto.getCode());
                                        	    			
                                        	    			if(manufacturer!=null){
                                                        		throw new Exception(InventoryConstant.THIS_MANUFACTURER_CODE_ALREADY_EXIST);
                                        	    			}
                                        	    			manufacturer=new Manufacturer();
                                    	    					manufacturer.setId(manufacturerDto.getId());
                                        	    				manufacturer.setName(manufacturerDto.getName());
                                        	    				manufacturer.setCode(manufacturerDto.getCode());
                                        	    				manufacturer.setCreatedBy(manufacturerDto.getCreatedBy());
                                        	    				if(manufacturerDto.getCreationDate()!=null){
                                        	    					
                                        	    				manufacturer.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(manufacturerDto.getCreationDate()));
                                        	    				}
                                                	    			manufacturer.setCountry(manufacturerDto.getCountry());
                                                                    manufacturer.setAddress1(manufacturerDto.getAddress1());
                                                                    manufacturer.setAddress2(manufacturerDto.getAddress2());
                                                                    manufacturer.setAddress3(manufacturerDto.getAddress3());
                                                                    manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                                                    manufacturer.setState(manufacturerDto.getState());
                                                                    manufacturer.setCity(manufacturerDto.getCity());
                                                                    manufacturer.setUrl(manufacturerDto.getUrl());
                                                                    manufacturer.setPinCode(manufacturerDto.getPincode());
                                                                    manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                                                    if(manufacturerDto.getTelephoneNumber()!=null &&  !manufacturerDto.getTelephoneNumber().isEmpty()){
                                                                    manufacturer.setTelephoneNumber(Long.parseLong(manufacturerDto.getTelephoneNumber()));
                                                                    }
                                                                    if(manufacturerDto.getMobileNumber()!=null && !manufacturerDto.getMobileNumber().isEmpty()){
                                                                    manufacturer.setMobileNumber(manufacturerDto.getMobileNumber());
                                                                    }
                                                                
                                                                    if(manufacturerDto.getFax()!=null && !manufacturerDto.getFax().isEmpty() ){
                                                                    manufacturer.setFax(Long.parseLong(manufacturerDto.getFax()));
                                                                    }
                                                                    manufacturer.setUrl(manufacturerDto.getUrl());
                                                                    manufacturer.setIndiaOrOutside(manufacturerDto.getIndiaOrOutside());
                                                                    manufacturer.setEmailId(manufacturerDto.getEmailId());
                                                                    manufacturer.setGstIn(manufacturerDto.getGstIn());
                                                                    manufacturer.setStatus(manufacturerDto.getStatus());
                                                                    manufacturer.setLastModifiedBy(principal.getName());
                                                                    manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                                	    			
                                                	    		}
                                                	    		
                                        	    			
                                        	    			
                                        	    		}
                                        	    	else{manufacturer=new Manufacturer();
                                        	    		manufacturer=manufacturerRepository.findByName(manufacturerDto.getName());
                                        	    		if(manufacturer==null){
                                        	    			/*manufacturer=new Manufacturer();
                                        	    			manufacturer.setName(manufacturerDto.getName());*/
                                        	    			//manufacturer=new Manufacturer();
                                        	    			manufacturer=manufacturerRepository.findByCode(manufacturerDto.getCode());
                                            	    		if(manufacturer!=null) {
                                            	    			
                                            	    		manufacturer.setName(manufacturerDto.getName());
                                            	    		manufacturer.setCode(manufacturerDto.getCode());
                                    	    				manufacturer.setCreatedBy(manufacturerDto.getCreatedBy());
                                    	    				if(manufacturerDto.getCreationDate()!=null){
                                    	    					
                                    	    				manufacturer.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(manufacturerDto.getCreationDate()));
                                    	    				}
                                            	    			manufacturer.setCountry(manufacturerDto.getCountry());
                                                                manufacturer.setAddress1(manufacturerDto.getAddress1());
                                                                manufacturer.setAddress2(manufacturerDto.getAddress2());
                                                                manufacturer.setAddress3(manufacturerDto.getAddress3());
                                                                manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                                                manufacturer.setState(manufacturerDto.getState());
                                                                manufacturer.setCity(manufacturerDto.getCity());
                                                                manufacturer.setUrl(manufacturerDto.getUrl());
                                                                manufacturer.setPinCode(manufacturerDto.getPincode());
                                                                manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                                                if(manufacturerDto.getTelephoneNumber()!=null &&  !manufacturerDto.getTelephoneNumber().isEmpty()){
                                                                manufacturer.setTelephoneNumber(Long.parseLong(manufacturerDto.getTelephoneNumber()));
                                                                }
                                                                if(manufacturerDto.getMobileNumber()!=null && !manufacturerDto.getMobileNumber().isEmpty()){
                                                                manufacturer.setMobileNumber(manufacturerDto.getMobileNumber());
                                                                }
                                                            
                                                                if(manufacturerDto.getFax()!=null && !manufacturerDto.getFax().isEmpty()){
                                                                manufacturer.setFax(Long.parseLong(manufacturerDto.getFax()));
                                                                }
                                                                manufacturer.setUrl(manufacturerDto.getUrl());
                                                                manufacturer.setIndiaOrOutside(manufacturerDto.getIndiaOrOutside());
                                                                manufacturer.setEmailId(manufacturerDto.getEmailId());
                                                                manufacturer.setGstIn(manufacturerDto.getGstIn());
                                                                manufacturer.setStatus(manufacturerDto.getStatus());
                                                                manufacturer.setLastModifiedBy(principal.getName());
                                                                manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                        	    		}else{
                                        	    			
                                        	    			manufacturer=new Manufacturer();
                                	    					manufacturer.setId(manufacturerDto.getId());
                                    	    				manufacturer.setName(manufacturerDto.getName());
                                    	    				manufacturer.setCode(manufacturerDto.getCode());
                                    	    				manufacturer.setCreatedBy(manufacturerDto.getCreatedBy());
                                    	    				if(manufacturerDto.getCreationDate()!=null){
                                    	    					
                                    	    				manufacturer.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(manufacturerDto.getCreationDate()));
                                    	    				}
                                            	    			manufacturer.setCountry(manufacturerDto.getCountry());
                                                                manufacturer.setAddress1(manufacturerDto.getAddress1());
                                                                manufacturer.setAddress2(manufacturerDto.getAddress2());
                                                                manufacturer.setAddress3(manufacturerDto.getAddress3());
                                                                manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                                                manufacturer.setState(manufacturerDto.getState());
                                                                manufacturer.setCity(manufacturerDto.getCity());
                                                                manufacturer.setUrl(manufacturerDto.getUrl());
                                                                manufacturer.setPinCode(manufacturerDto.getPincode());
                                                                manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                                                if(manufacturerDto.getTelephoneNumber()!=null && !manufacturerDto.getTelephoneNumber().isEmpty()){
                                                                manufacturer.setTelephoneNumber(Long.parseLong(manufacturerDto.getTelephoneNumber()));
                                                                }
                                                                if(manufacturerDto.getMobileNumber()!=null && !manufacturerDto.getMobileNumber().isEmpty()){
                                                                manufacturer.setMobileNumber(manufacturerDto.getMobileNumber());
                                                                }
                                                            
                                                                if(manufacturerDto.getFax()!=null && !manufacturerDto.getFax().isEmpty()){
                                                                manufacturer.setFax(Long.parseLong(manufacturerDto.getFax()));
                                                                }
                                                                manufacturer.setUrl(manufacturerDto.getUrl());
                                                                manufacturer.setIndiaOrOutside(manufacturerDto.getIndiaOrOutside());
                                                                manufacturer.setEmailId(manufacturerDto.getEmailId());
                                                                manufacturer.setGstIn(manufacturerDto.getGstIn());
                                                                manufacturer.setStatus(manufacturerDto.getStatus());
                                                                manufacturer.setLastModifiedBy(principal.getName());
                                                                manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                        	    		}
                                                        	
                                                            		
                                            	    			
                                            	    			
                                                        		
                                                        	}
                                        	    		else{
                                        	    			throw new Exception(InventoryConstant.THIS_MANUFACTURER_NAME_ALREADY_EXIST);
                                        	    		}
                                        	    	}
                                            	    		
                                        	    	}
                                        	    	
                                        }
                                        
                                        else{
                                        	
                                        	    manufacturer=manufacturerRepository.findByName(manufacturerDto.getName());
                                            	if(manufacturer!=null)
                                            	{
                                            		throw new Exception(InventoryConstant.THIS_MANUFACTURER_NAME_ALREADY_EXIST);
                                            	}
                                            	 manufacturer=manufacturerRepository.findByCode(manufacturerDto.getCode());
                                            	 if(manufacturer!=null){
                                            		throw new Exception(InventoryConstant.THIS_MANUFACTURER_CODE_ALREADY_EXIST);
                                            	}
                                            	 manufacturer=new Manufacturer();
                                            	 manufacturer.setName(manufacturerDto.getName());
                                            	 manufacturer.setCode(manufacturerDto.getCode());
                                            manufacturer.setCreationDate(new Timestamp(new Date().getTime()));
                                            manufacturer.setCreatedBy(principal.getName());;
                                           
                                            		manufacturer.setCountry(manufacturerDto.getCountry());
                                                    manufacturer.setAddress1(manufacturerDto.getAddress1());
                                                    manufacturer.setAddress2(manufacturerDto.getAddress2());
                                                    manufacturer.setAddress3(manufacturerDto.getAddress3());
                                                    manufacturer.setAreaLandmark(manufacturerDto.getAreaLandmark());
                                                    manufacturer.setState(manufacturerDto.getState());
                                                    manufacturer.setCity(manufacturerDto.getCity());
                                                    manufacturer.setUrl(manufacturerDto.getUrl());
                                                    manufacturer.setPinCode(manufacturerDto.getPincode());
                                                    manufacturer.setContactPerson(manufacturerDto.getContactPerson());
                                                    if(manufacturerDto.getTelephoneNumber()!=null && !manufacturerDto.getTelephoneNumber().isEmpty() ){
                                                    manufacturer.setTelephoneNumber(Long.parseLong(manufacturerDto.getTelephoneNumber()));
                                                    }
                                                    if(manufacturerDto.getMobileNumber()!=null && !manufacturerDto.getMobileNumber().isEmpty()){
                                                    manufacturer.setMobileNumber(manufacturerDto.getMobileNumber());
                                                    }
                                                
                                                    if(manufacturerDto.getFax()!=null && !manufacturerDto.getFax().isEmpty()){
                                                   // manufacturer.setFax(Integer.parseInt(manufacturerDto.getFax()));
                                                    manufacturer.setFax(Long.parseLong(manufacturerDto.getFax()));
                                                    }
                                                    manufacturer.setUrl(manufacturerDto.getUrl());
                                                    manufacturer.setIndiaOrOutside(manufacturerDto.getIndiaOrOutside());
                                                    manufacturer.setEmailId(manufacturerDto.getEmailId());
                                                    manufacturer.setGstIn(manufacturerDto.getGstIn());
                                                    manufacturer.setStatus("ACTIVE");
                                                    manufacturer.setLastModifiedBy(principal.getName());
                                                    manufacturer.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                            	}
                                           
                                      
                manufacturer=manufacturerRepository.save(manufacturer);
                if(manufacturer!=null){
                	status=InventoryConstant.SUCCESS;
                        
                       
                }
                return status;
                }
                /*FOR GET VALUE OF EDIT MANUFACTURER*/
                
                @Override
                public ManufacturerDto getManufacturer(Long id,Principal principal) {
                        ManufacturerDto manufacturerDto = null;
                        
                        try{
                        Manufacturer manufacturer = manufacturerRepository.findOne(id);                        
                                if (null != manufacturer) {
                                        manufacturerDto =new ManufacturerDto();
                                        manufacturerDto.setId(manufacturer.getId());
                                        manufacturerDto.setName(manufacturer.getName());
                                        manufacturerDto.setCode(manufacturer.getCode());
                                        manufacturerDto.setCountry(manufacturer.getCountry());
                                        manufacturerDto.setAddress1(manufacturer.getAddress1());
                                        manufacturerDto.setAddress2(manufacturer.getAddress2());
                                        manufacturerDto.setAddress3(manufacturer.getAddress3());
                                        manufacturerDto.setAreaLandmark(manufacturer.getAreaLandmark());
                                        manufacturerDto.setState(manufacturer.getState());
                                        manufacturerDto.setCity(manufacturer.getCity());
                                        manufacturerDto.setPincode(manufacturer.getPinCode());
                                        manufacturerDto.setContactPerson(manufacturer.getContactPerson());
                                        if(manufacturer.getTelephoneNumber()!=null)
                                        {
                                                manufacturerDto.setTelephoneNumber(Long.toString(manufacturer.getTelephoneNumber()));        
                                        }
                                        if(manufacturer.getFax()!=null)
                                        {
                                                manufacturerDto.setFax(Long.toString(manufacturer.getFax()));        
                                        }
                                        
                                        if(manufacturer.getMobileNumber()!=null)
                                        {
                                                manufacturerDto.setMobileNumber(manufacturer.getMobileNumber());        
                                        }
                                        
                                        manufacturerDto.setUrl(manufacturer.getUrl());
                                        manufacturerDto.setEmailId(manufacturer.getEmailId());
                                        manufacturerDto.setGstIn(manufacturer.getGstIn());
                                        manufacturerDto.setStatus(manufacturer.getStatus());
                                        manufacturerDto.setCreatedBy(manufacturer.getCreatedBy());
                                        if(manufacturer.getCreationDate()!=null){
                        manufacturerDto.setCreationDate(MasterDateUtil.convertDateToString(manufacturer.getCreationDate()));
                        
                                        }
                                }
                        
                }catch (Exception e) {
                        e.printStackTrace();
                }
                        return manufacturerDto;
                }

                
                /*FOR ACTIVE MANUFACTURER DROP DOWN*/
                
                @Override
                public List<ManufacturerDto> getAllActiveManuFacturer() {
                        List<ManufacturerDto> manufacturerDtoList=new ArrayList<>();
                        try {
                                List<Manufacturer> manufacturerList=manufacturerRepository.findByStatus(InventoryConstant.ACTIVE);
                                
                                for(int i=0;i<manufacturerList.size();i++)
                                {
                                        Manufacturer manufacturer=manufacturerList.get(i);
                                        if(manufacturer!=null)
                                        {
                                                ManufacturerDto manufacturerDto=new ManufacturerDto();
                                                manufacturerDto.setName(manufacturer.getName());
                                                manufacturerDtoList.add(manufacturerDto);
                                        }
                                }
                                
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                        return manufacturerDtoList;
                }


                

        
}
