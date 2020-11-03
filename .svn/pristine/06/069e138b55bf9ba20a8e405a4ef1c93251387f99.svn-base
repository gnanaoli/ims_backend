package com.fa.inventory.service.impl;

import java.math.BigInteger;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ServiceTrackerDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.DispatcherLog;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.InventoryRequest;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.SubCategory;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.repository.CategoryRepository;
import com.fa.inventory.repository.DispatchLogRepository;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.SubCategoryRepository;
import com.fa.inventory.repository.ToolsRequestRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.SmsService;
import com.fa.inventory.service.ToolsRequestService;

@Service
public class ToolsRequestServiceImpl implements ToolsRequestService {

	private Logger logger = Logger.getLogger(getClass());
	@Resource
	ToolsRequestRepository toolsRequestRepository;
	@Resource
	InventoryStockRepository inventoryStockRepository;
	@Resource
	InventoryAssignRepository inventoryAssignRepository;

	@Resource
	SubCategoryRepository subCategoryRepository;

	@Resource
	CategoryRepository categoryRepository;
	@Resource
	UserRepository userRepository;
	
	@Resource
	DispatchLogRepository dispatchLogRepository;
	
	@Resource
	SmsService smsService;

	/* FOR SAVE THE NEW INVENTORY REQUEST */
	/*
	 * this method is used to send request to project as well as sms 
	 * **/
	@Override
	public String saveToolsRequest(InventoryRequestDto inventoryRequestDto, Principal principal) {
		String status = InventoryConstant.FAILURE;

		logger.info("<--Tools Request serviceImpl-------------save New InventoryRequest--------------------started-->");
		try {
			InventoryRequest inventoryRequest = new InventoryRequest();

			inventoryRequest.setReferenceNo(getRefNoSequence());

			inventoryRequest.setQuantity(inventoryRequestDto.getQuantity());
			inventoryRequest.setRequestedFrom(inventoryRequestDto.getRequestedFrom());

			inventoryRequest.setRequiredDays(inventoryRequestDto.getRequiredDays());
			if (inventoryRequestDto.getExpectedDateToReach() != null) {
				inventoryRequest.setExpectedDateToReach(
						MasterDateUtil.convertStringToTimeStampDate(inventoryRequestDto.getExpectedDateToReach()));
			}
			inventoryRequest.setStatus(InventoryConstant.REQUESTED);
			inventoryRequest.setSubStatus(InventoryConstant.REQUESTED);
			inventoryRequest.setNotificationLink("ToolsRequestView");
			inventoryRequest.setNotificationStatus(InventoryConstant.NEW);
			inventoryRequest.setRaisedBy(principal.getName());
			inventoryRequest.setRaisedDate(new Timestamp(new Date().getTime()));
			inventoryRequest.setActionBy(principal.getName());
			inventoryRequest.setActionDate(new Timestamp(new Date().getTime()));
			inventoryRequest.setLocation(inventoryRequestDto.getLocation());
			if (inventoryRequestDto.getId() != null) {

				if (inventoryRequestDto.getLocation() != null
						&& inventoryRequestDto.getLocation().equalsIgnoreCase(InventoryConstant.PROJECTSITE)) {

					InventoryAssign inventoryAssign1 = inventoryAssignRepository.findOne(inventoryRequestDto.getId());
					if (inventoryAssign1 != null) {
						inventoryRequest.setInventoryAssign(inventoryAssign1);
					}
					SubCategory subCategory = subCategoryRepository
							.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(), InventoryConstant.ACTIVE);
					if (subCategory != null) {
						inventoryRequest.setSubCategory(subCategory);
						inventoryRequest.setModelCode(subCategory.getModel());
					}
					Category category = categoryRepository.findByCategoryType(inventoryRequestDto.getCategory());
					if (category != null) {
						inventoryRequest.setCategory(category);
					}
					inventoryRequest.setModelCode(inventoryAssign1.getSubCategory().getModel());
					inventoryRequest.setRequestedTo(inventoryAssign1.getAssignedLocation());
					inventoryRequest.setLocation(InventoryConstant.PROJECTSITE);

				} else if (inventoryRequestDto.getLocation() != null
						&& inventoryRequestDto.getLocation().equalsIgnoreCase(InventoryConstant.WAREHOUSE)) {

					InventoryEntrance inventoryEntrance = inventoryStockRepository.findOne(inventoryRequestDto.getId());

					if (inventoryEntrance != null) {
						inventoryRequest.setInventoryEntrance(inventoryEntrance);
					}

					inventoryRequest.setCategory((inventoryEntrance.getCategory()));
					SubCategory subCategory = subCategoryRepository
							.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(), InventoryConstant.ACTIVE);
					if (subCategory != null) {
						inventoryRequest.setSubCategory(subCategory);
						inventoryRequest.setModelCode(subCategory.getModel());
					}
					Category category = categoryRepository.findByCategoryType(inventoryRequestDto.getCategory());
					if (category != null) {
						inventoryRequest.setCategory(category);
					}
					inventoryRequest.setRequestedTo(inventoryEntrance.getWareHouseSiteName());
					inventoryRequest.setLocation(InventoryConstant.WAREHOUSE);
				}
				inventoryRequest =toolsRequestRepository.save(inventoryRequest);
				if (inventoryRequest != null) {
					status = InventoryConstant.SUCCESS;
					smsService.sendSmsToWareHouseOrProjectUsers(inventoryRequest.getRequestedTo());
				}
			}
			
			logger.info(
					"<--Tools Request serviceImpl-------------save New InventoryRequest--------------------ended-->");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}
	/* FOR VIEW THE INVENTORY REQUEST BY ID */

	@Override
	public InventoryRequestDto getToolsRequestById(String id, Principal principal) {

		InventoryRequestDto inventoryRequestDto = null;
		logger.info("<--ToolsRequestServiceImpl-------------getToolsRequestById--------------------started-->");
		try {

			if (id != null) {
				InventoryRequest inventoryRequest = toolsRequestRepository.findOne(Long.valueOf(id));
				inventoryRequestDto = mapInventoryRequestDtoById(inventoryRequest);
				// inventoryEntranceDto.setProjectItemDto(getCurrentUserProjectDtoList(principal));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ToolsRequestServiceImpl-------------getToolsRequestById--------------------Ended-->");
		return inventoryRequestDto;
	}

	/* FOR SAVE (Accepted save)THE TOOLS REQUEST */

	@Override
	public String saveAcceptToolsRequest(InventoryRequestDto inventoryRequestDto, Principal principal)throws Exception {
		String status = InventoryConstant.FAILURE;

		logger.info("<--Tools Request serviceImpl-------------save Accepted request--------------------started-->");
	
			InventoryEntrance inventoryEntrance = new InventoryEntrance();
			InventoryAssign inventoryAssign = new InventoryAssign();
			InventoryRequest inventoryRequest = new InventoryRequest();
			Integer remaining = null;
			if (inventoryRequestDto.getStatus().equalsIgnoreCase(InventoryConstant.ACCEPTED)
					|| inventoryRequestDto.getStatus().equalsIgnoreCase(InventoryConstant.PARTIALLYACCEPTED)) {
				inventoryRequest = toolsRequestRepository.findOne(inventoryRequestDto.getId());
				if (inventoryRequest.getLocation().equalsIgnoreCase(InventoryConstant.WAREHOUSE)) {
					inventoryEntrance = inventoryRequest.getInventoryEntrance();
					//System.out.println("accepted quantity" + inventoryRequestDto.getQuantity());
					//System.out.println("entrance quantity" + inventoryEntrance.getQuantity());
					if (inventoryEntrance.getAvailableQuantity()>= inventoryRequestDto.getQuantity()) {
						remaining = inventoryEntrance.getAvailableQuantity() - inventoryRequestDto.getQuantity();
						inventoryEntrance.setAvailableQuantity(remaining);
						inventoryEntrance.setLastModifiedBy(principal.getName());
						inventoryEntrance.setLastModifiedDate(new Timestamp(new Date().getTime()));
						inventoryRequest = mapInventoryRequest( inventoryEntrance,inventoryAssign,inventoryRequest,inventoryRequestDto,principal);
						inventoryRequest.setInventoryEntrance(inventoryEntrance);
						inventoryRequest=toolsRequestRepository.saveAndFlush(inventoryRequest);
						/*if (inventoryRequest != null) {
							status = mapInventoryAssignEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
							if (status.equals(InventoryConstant.SUCCESS)) {
								status = InventoryConstant.SUCCESS;
							}
							
						}*/
						if (inventoryRequest != null) {
							status = saveDispatchLogEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
							if (status!=null) {
								status = InventoryConstant.SUCCESS;
							}
						}
					}
					else{
						throw new Exception(InventoryConstant.INSUFFICIENT_QUANTITY);
						/*status = InventoryConstant.INSUFFICIENT_QUANTITY;*/
					}
				} else if (inventoryRequest.getLocation().equalsIgnoreCase(InventoryConstant.PROJECTSITE)) {
					inventoryAssign=new InventoryAssign();
					inventoryAssign = inventoryRequest.getInventoryAssign();
					if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
						remaining = inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity();
						inventoryAssign.setAvailableQty(remaining);
						inventoryAssign.setLeftoverQty(remaining);
						inventoryAssign.setLastModifiedBy(principal.getName());
						inventoryAssign.setLastModifiedDate(new Timestamp(new Date().getTime()));
						inventoryRequest= mapInventoryRequest(inventoryEntrance,inventoryAssign,inventoryRequest,inventoryRequestDto,principal);
						inventoryRequest.setInventoryAssign(inventoryAssign);
						inventoryRequest = toolsRequestRepository.saveAndFlush(inventoryRequest);
						/*if (inventoryRequest != null) {
							status = mapInventoryAssignEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
							if (status.equals(InventoryConstant.SUCCESS)) {
								status = InventoryConstant.SUCCESS;
							}

						}*/
						
						if (inventoryRequest != null) {
							status = saveDispatchLogEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
							if (status !=null) {
								status = InventoryConstant.SUCCESS;
							}
						}
						}
					else {
						throw new Exception(InventoryConstant.INSUFFICIENT_QUANTITY);
					/*	status = InventoryConstant.INSUFFICIENT_QUANTITY;
						return status;*/
					}
				}else if(inventoryRequest.getLocation().equalsIgnoreCase(InventoryConstant.ALL)) {
					
					Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

					boolean hasUserRole = authentication.getAuthorities().stream()
					          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR));
					if(hasUserRole)
					{
					
					inventoryEntrance=inventoryStockRepository.getMaxQuantity(inventoryRequestDto.getSubCategory(),inventoryRequestDto.getRequestedTo());
					if(inventoryEntrance!=null){
					if (inventoryEntrance.getQuantity() >= inventoryRequestDto.getQuantity()) {
						remaining = inventoryEntrance.getQuantity() - inventoryRequestDto.getQuantity();
						inventoryEntrance.setQuantity(remaining);
						inventoryEntrance.setLastModifiedBy(principal.getName());
						inventoryEntrance.setLastModifiedDate(new Timestamp(new Date().getTime()));
						inventoryRequest = mapInventoryRequest( inventoryEntrance,inventoryAssign,inventoryRequest,inventoryRequestDto,principal);
						inventoryRequest.setInventoryEntrance(inventoryEntrance);
						inventoryRequest=toolsRequestRepository.saveAndFlush(inventoryRequest);
						/*if (inventoryRequest != null) {
							status = mapInventoryAssignEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
							if (status.equals(InventoryConstant.SUCCESS)) {
								status = InventoryConstant.SUCCESS;
							}
							
						}*/
						
						if (inventoryRequest != null) {
							status = saveDispatchLogEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
							if (status !=null) {
								status = InventoryConstant.SUCCESS;
							}
						}
					}
					else{
						throw new Exception(InventoryConstant.INSUFFICIENT_QUANTITY);
						/*status = InventoryConstant.INSUFFICIENT_QUANTITY;*/
					}
					
					}
					else{
						throw new Exception(InventoryConstant.GIVENTOOLDOESNOTEXIST);
						/*status = InventoryConstant.GIVENTOOLDOESNOTEXIST;*/
					}
					//Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
					}
					boolean hasUserRole1 = authentication.getAuthorities().stream()
					          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.USER));
					{
						if(hasUserRole1){
					//inventoryAssign = inventoryRequest.getInventoryAssign();
					inventoryAssign=inventoryAssignRepository.getMaxQuantity(inventoryRequestDto.getSubCategory(),inventoryRequestDto.getRequestedTo());
					if(inventoryAssign!=null){
					if (inventoryAssign!=null && inventoryAssign.getAvailableQty()!=null && inventoryRequestDto.getQuantity()!=null && inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
						remaining = inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity();
						inventoryAssign.setAvailableQty(remaining);
						inventoryAssign.setLeftoverQty(remaining);
						inventoryAssign.setLastModifiedBy(principal.getName());
						inventoryAssign.setLastModifiedDate(new Timestamp(new Date().getTime()));
						inventoryRequest = mapInventoryRequest( inventoryEntrance,inventoryAssign,inventoryRequest,inventoryRequestDto,principal);
						inventoryRequest.setInventoryAssign(inventoryAssign);
						inventoryRequest=toolsRequestRepository.saveAndFlush(inventoryRequest);
							/*if (inventoryRequest != null) {
								status = mapInventoryAssignEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
								if (status.equals(InventoryConstant.SUCCESS)) {
									status = InventoryConstant.SUCCESS;
								}
							}*/ 
							if (inventoryRequest != null) {
								status = saveDispatchLogEntity(inventoryAssign,inventoryEntrance, inventoryRequestDto, principal);
								if (status !=null) {
									status = InventoryConstant.SUCCESS;
								}
							}
					}
					else {
						throw new Exception(InventoryConstant.INSUFFICIENT_QUANTITY);
						/*status = InventoryConstant.INSUFFICIENT_QUANTITY;
						return status;*/
					}
					}
					
					else {
						throw new Exception(InventoryConstant.GIVENTOOLDOESNOTEXIST);
						/*status = InventoryConstant.GIVENTOOLDOESNOTEXIST;
						return status;*/
					}
					}
			
					}
				}
				}
			else if(inventoryRequestDto.getStatus().equalsIgnoreCase(InventoryConstant.REJECTED))
			{
				inventoryRequest = toolsRequestRepository.findOne(inventoryRequestDto.getId());	
				inventoryRequest.setStatus(InventoryConstant.REJECTED);
				inventoryRequest.setSubStatus(InventoryConstant.REJECTED +" " + "BY" +" "+ principal.getName());
				inventoryRequest.setComments(inventoryRequestDto.getComments());
				inventoryRequest.setNotificationStatus(InventoryConstant.OLD);
				inventoryRequest = toolsRequestRepository.save(inventoryRequest);
				status=InventoryConstant.REJECTED;
				/*throw new Exception(InventoryConstant.REJECTED);*/
				
			}
				
			
			
		logger.info("<--Tools Request serviceImpl-------------saveAcceptToolsRequest--------------------Ended-->");
		return status;
	}
	
	@Override
	public String getRefNoSequence() {
		logger.info("<--Tools Request serviceImpl-------------getRefNoSequence--------------------started-->");
		String refnum = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMddhhmm");
        String dateAsString = simpleDateFormat.format(new Date());
		try {
			BigInteger refnumvalue = toolsRequestRepository.getRefNoSequence();
			if (refnumvalue != null)
				refnum = dateAsString + String.valueOf(refnumvalue);
			else
				logger.info("getRefNoSequence Generation Failed");
		} catch (PersistenceException pe) {
			logger.error("RefNo------getRefNoSequence-------Exception" + pe);
			logger.info("getRefNoSequence Generation Failed");
		}

		logger.info("<--Tools Request serviceImpl-------------getRefNoSequence--------------------Ended-->");
		return refnum;
	}
/*FOR VIEW THE  (single and bulk)TOOLS REQUEST TO THAT USER */
	public List<InventoryRequestDto> getUserToolsRequest(Principal principal) {
		logger.info("<--Tools Request serviceImpl-------------getUserToolsRequest--------------------started-->");
		List<InventoryRequestDto> inventoryRequestDtoList = new ArrayList<>();

		List<ProjectDto> projectDtoList = null;
		List<Project> projectEntityList = null;
		List<WareHouseDto> wareHouseDtoList = null;
		List<WareHouse>wareHouseEntityList = null;
		if (principal.getName() != null) {
			User user = userRepository.findByUserName(principal.getName());
			if (user.getProjectItem() != null && !user.getProjectItem().isEmpty()) {
				projectEntityList = user.getProjectItem();
				if (projectEntityList != null) {
					projectDtoList = new ArrayList<>();
					for (int k = 0; k < projectEntityList.size(); k++) {
						Project project = user.getProjectItem().get(k);
						if (project != null) {
							List<InventoryRequest> inventoryRequestList = toolsRequestRepository.findByStatusAndRequestedTo(InventoryConstant.REQUESTED, project.getName());
							if (inventoryRequestList != null && !inventoryRequestList.isEmpty()) {
								
								for (int i = 0; i < inventoryRequestList.size(); i++) {
									InventoryRequest inventoryRequest = inventoryRequestList.get(i);
									if (inventoryRequest != null) {
										inventoryRequestDtoList.add(mapInventoryRequestDtoById(inventoryRequest));
									}
								}
							}
						}
					}
				}
				
			}
			if (user.getWareHouseItem() != null && !user.getWareHouseItem().isEmpty()) {
				wareHouseEntityList = user.getWareHouseItem();
				if (wareHouseEntityList != null) {
					wareHouseDtoList = new ArrayList<>();
					for (int k = 0; k < wareHouseEntityList.size(); k++) {
						WareHouse wareHouse = user.getWareHouseItem().get(k);
						if (wareHouse != null) {
							List<InventoryRequest> inventoryRequestList = toolsRequestRepository.findByStatusAndRequestedTo(InventoryConstant.REQUESTED, wareHouse.getWareHouseName());
							if (inventoryRequestList != null && !inventoryRequestList.isEmpty()) {
								
								for (int i = 0; i < inventoryRequestList.size(); i++) {
									InventoryRequest inventoryRequest = inventoryRequestList.get(i);
									if (inventoryRequest != null) {
										inventoryRequestDtoList.add(mapInventoryRequestDtoById(inventoryRequest));
									}
								}
							}
						}
					}
				}
			}
			List<InventoryRequest> inventoryRequestList = toolsRequestRepository.findByStatusAndLocation(InventoryConstant.BULK_REQUESTED,InventoryConstant.ALL);
			if (inventoryRequestList != null && !inventoryRequestList.isEmpty()) {
				//inventoryRequestDtoList = new ArrayList<>();
				for (int i = 0; i < inventoryRequestList.size(); i++) {
					InventoryRequest inventoryRequest = inventoryRequestList.get(i);
					if (inventoryRequest != null && !inventoryRequest.getRaisedBy().equalsIgnoreCase(principal.getName())) {
						inventoryRequestDtoList.add(mapInventoryRequestDtoById(inventoryRequest));
					}
				}
			}
			
			/*if (user.getWareHouseItem() != null && !user.getWareHouseItem().isEmpty()) {
				wareHouseEntityList = user.getWareHouseItem();
				if (wareHouseEntityList != null) {
					wareHouseDtoList = new ArrayList<>();
					List<InventoryRequest> inventoryRequestList = toolsRequestRepository.findByStatusAndLocation(InventoryConstant.BULK_REQUESTED,InventoryConstant.ALL);
					if (inventoryRequestList != null && !inventoryRequestList.isEmpty()) {
					
		List<InventoryRequest> inventoryRequestList = toolsRequestRepository.findByStatusAndLocation(InventoryConstant.BULK_REQUESTED,InventoryConstant.ALL);
		if (inventoryRequestList != null && !inventoryRequestList.isEmpty()) {
			//inventoryRequestDtoList = new ArrayList<>();
			for (int i = 0; i < inventoryRequestList.size(); i++) {
				InventoryRequest inventoryRequest = inventoryRequestList.get(i);
				if (wareHouseEntityList != null) {
					wareHouseDtoList = new ArrayList<>();
			for (int k = 0; k < wareHouseEntityList.size(); k++) {
				WareHouse wareHouse = user.getWareHouseItem().get(k);
				if (wareHouse != null) {
				if (inventoryRequest != null && !wareHouse.getWareHouseName().equalsIgnoreCase(inventoryRequest.getRequestedFrom()))
				{
					inventoryRequestDtoList.add(mapInventoryRequestDtoById(inventoryRequest));
				}
			}
		}
	}
	}
					}

			}
			
				if (user.getProjectItem() != null && !user.getProjectItem().isEmpty()) {
					projectEntityList = user.getProjectItem();
					if (projectEntityList != null ) {
						projectDtoList = new ArrayList<>();
						for (int k = 0; k < projectEntityList.size(); k++) {
							Project project = user.getProjectItem().get(k);
							if (project != null) {
			List<InventoryRequest> inventoryRequestList = toolsRequestRepository.findByStatusAndLocation(InventoryConstant.BULK_REQUESTED,InventoryConstant.ALL);
			if (inventoryRequestList != null && !inventoryRequestList.isEmpty()) {
				//inventoryRequestDtoList = new ArrayList<>();
				for (int i = 0; i < inventoryRequestList.size(); i++) {
					InventoryRequest inventoryRequest = inventoryRequestList.get(i);
					if (inventoryRequest != null && !project.getName().equalsIgnoreCase(inventoryRequest.getRequestedFrom()))
					{
						inventoryRequestDtoList.add(mapInventoryRequestDtoById(inventoryRequest));
					}
				}
			}
		}
		}
		}
				}	*/	
		}
		logger.info("<--Tools Request serviceImpl-------------getUserToolsRequest--------------------Ended-->");
		return inventoryRequestDtoList;
	}
	@Override
	public InventoryRequestDto mapInventoryRequestDtoById(InventoryRequest inventoryRequest) {
		InventoryRequestDto inventoryRequestDto = new InventoryRequestDto();
		try {
			logger.info("<--ToolsRequestServiceImpl-------------mapInventoryRequestDtoById--------------------started-->");
			inventoryRequestDto.setId(inventoryRequest.getId());
			inventoryRequestDto.setReferenceNo(inventoryRequest.getReferenceNo());
			Category category = inventoryRequest.getCategory();
			if (category != null) {
				inventoryRequestDto.setCategory(category.getCategoryType());
			}
			SubCategory subCategory = inventoryRequest.getSubCategory();
			if (subCategory != null) {
				inventoryRequestDto.setSubCategory(subCategory.getSubCategory());
				inventoryRequestDto.setModelCode(subCategory.getModel());
			}
			inventoryRequestDto.setQuantity(inventoryRequest.getQuantity());
			if(inventoryRequest.getRequestedTo()!=null){
				inventoryRequestDto.setRequestedTo(inventoryRequest.getRequestedTo());	
			}
			
			inventoryRequestDto.setRequestedFrom(inventoryRequest.getRequestedFrom());
			inventoryRequestDto.setLocation(inventoryRequest.getLocation());
			inventoryRequestDto.setStatus(inventoryRequest.getStatus());
			inventoryRequestDto.setRaisedBy(inventoryRequest.getRaisedBy());
			inventoryRequestDto.setActionBy(inventoryRequest.getActionBy());
			if (inventoryRequest.getExpectedDateToReach() != null) {
				inventoryRequestDto.setExpectedDateToReach(MasterDateUtil.convertDateToString(inventoryRequest.getExpectedDateToReach()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ToolsRequestServiceImpl-------------mapInventoryDtoById--------------------Ended-->");
		return inventoryRequestDto;
	}

	public String mapInventoryAssignEntity(InventoryAssign inventoryAssign,InventoryEntrance inventoryEntrance,InventoryRequestDto inventoryRequestDto, Principal principal) {
		logger.info("<--ToolsRequestServiceImpl-------------mapInventoryAssignEntity--------------------started-->");
		InventoryAssign inventoryAssign1=new InventoryAssign();
		String status=InventoryConstant.FAILURE;
		try{
			String inventoyNo=null;	
			Category category=null;
			SubCategory subcategory=null;
		inventoryAssign1.setAvailableQty(inventoryRequestDto.getQuantity());
		inventoryAssign1.setLeftoverQty(inventoryRequestDto.getQuantity());
		inventoryAssign1.setAssignedLocation(inventoryRequestDto.getRequestedFrom());
		inventoryAssign1.setSubCategoryName(inventoryRequestDto.getSubCategory());
		inventoryAssign1.setCreatedBy(principal.getName());
		inventoryAssign1.setCreationDate(new Date());
		inventoryAssign1.setInperson(principal.getName());
		inventoyNo=inventoryEntrance.getInventoryNumber();
		inventoryAssign1.setInventoryLocation(InventoryConstant.PROJECTSITE);
		if(inventoyNo!=null){
		inventoryAssign1.setInventoryNumber(inventoryEntrance.getInventoryNumber());
		}else{
			inventoyNo=inventoryAssign.getInventoryNumber();
			if(inventoyNo!=null){
				inventoryAssign1.setInventoryNumber(inventoryAssign.getInventoryNumber());
			}
		}
		category=inventoryEntrance.getCategory();
		if(category!=null){
			inventoryAssign1.setCategory(inventoryEntrance.getCategory());
			}else{
				category=inventoryAssign.getCategory();
				if(category!=null){
					inventoryAssign1.setCategory(inventoryAssign.getCategory());
				}
			}
		if(inventoryAssign.getInventoryEntrance()!=null)
		{
			InventoryEntrance inventoryEntrance2=inventoryStockRepository.findOne(inventoryAssign.getInventoryEntrance().getId());
			if(inventoryEntrance2!=null)
			{
				inventoryAssign1.setInventoryEntrance(inventoryEntrance2);
				
			}
		}
		else if(inventoryEntrance!=null)
		{
			InventoryEntrance inventoryEntrance2=inventoryStockRepository.findOne(inventoryEntrance.getId());
			if(inventoryEntrance2!=null)
			{
				inventoryAssign1.setInventoryEntrance(inventoryEntrance2);
			}
		}
		subcategory=inventoryEntrance.getSubCategory();
		if(subcategory!=null){
			inventoryAssign1.setSubCategory(inventoryEntrance.getSubCategory());
			}else{
				subcategory=inventoryAssign.getSubCategory();
				if(subcategory!=null){
					inventoryAssign1.setSubCategory(inventoryAssign.getSubCategory());
				}
			}
		inventoryAssign1.setLastModifiedBy(principal.getName());
		inventoryAssign1.setLastModifiedDate(new Date());
		inventoryAssign1.setAllocatedQty(inventoryRequestDto.getQuantity());
		inventoryAssign1.setModelCode(inventoryRequestDto.getModelCode());
		inventoryAssign1.setWareHouseSiteName(inventoryRequestDto.getRequestedTo());
		inventoryAssign1 = inventoryAssignRepository.saveAndFlush(inventoryAssign1);
		if(inventoryAssign1!=null)
		{
			status=InventoryConstant.SUCCESS;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--ToolsRequestServiceImpl-------------mapInventoryAssignEntity--------------------Ended-->");
		return status;
	}
	
	
	
	public String saveDispatchLogEntity(InventoryAssign inventoryAssign,InventoryEntrance inventoryEntrance,InventoryRequestDto inventoryRequestDto, Principal principal) {
		logger.info("<--ToolsRequestServiceImpl-------------saveDispatchLogEntity--------------------started-->");
		//InventoryAssign inventoryAssign1=new InventoryAssign();
		DispatcherLog dispatchLog=new DispatcherLog();
		String status=InventoryConstant.FAILURE;
		try{
			String inventoyNo=null;	
			String location=null;
			Category category=null;
			SubCategory subcategory=null;
			dispatchLog.setDispatchedQuantity(0);
			dispatchLog.setAvailableQuantity(inventoryRequestDto.getQuantity());
			dispatchLog.setRequestedTo(inventoryRequestDto.getRequestedFrom());
			dispatchLog.setRequestedFrom(inventoryRequestDto.getRequestedTo());
			//dispatchLog.setSubCategoryName(inventoryRequestDto.getSubCategory());
			if(inventoryRequestDto.getInventoryNumber()!=null){
			dispatchLog.setInventoryNumber(inventoryRequestDto.getInventoryNumber());
			}
			dispatchLog.setReferenceNo(inventoryRequestDto.getReferenceNo());
			dispatchLog.setQuantity(inventoryRequestDto.getQuantity());
			dispatchLog.setReferenceNo(inventoryRequestDto.getReferenceNo());
			dispatchLog.setRequiredDays(0);
			dispatchLog.setVehicleNumber("0");
			dispatchLog.setActionBy(principal.getName());
			dispatchLog.setActionDate(new Date());
			dispatchLog.setRaisedBy(principal.getName());
			dispatchLog.setRaisedDate(new Date());
			dispatchLog.setPurpose(InventoryConstant.ASSIGN_TO_PROJECT);
			dispatchLog.setReason(InventoryConstant.PROJECT);
			dispatchLog.setReferenceNo(inventoryRequestDto.getReferenceNo());
			dispatchLog.setStatus(InventoryConstant.PENDING);
			dispatchLog.setSubStatus(InventoryConstant.WAITING_FOR_ACCEPTANCE);
			//dispatchLog.setInperson(principal.getName());
		inventoyNo=inventoryEntrance.getInventoryNumber();
		location=inventoryEntrance.getLocation();
		if(location!=null){
			dispatchLog.setLocation(InventoryConstant.WAREHOUSE);	
		}
		location=inventoryAssign.getInventoryLocation();
		if(location!=null){
			dispatchLog.setLocation(InventoryConstant.PROJECTSITE);	
		}
		
		
		category=inventoryEntrance.getCategory();
		if(category!=null){
			dispatchLog.setCategory(inventoryEntrance.getCategory());
			}else{
				category=inventoryAssign.getCategory();
				if(category!=null){
					dispatchLog.setCategory(inventoryAssign.getCategory());
				}
			}
		if(inventoryAssign.getInventoryEntrance()!=null)
		{
			InventoryEntrance inventoryEntrance2=inventoryStockRepository.findOne(inventoryAssign.getInventoryEntrance().getId());
			if(inventoryEntrance2!=null)
			{
				dispatchLog.setInventoryEntrance(inventoryEntrance2);
				
			}
		}
		else if(inventoryEntrance!=null)
		{
			InventoryEntrance inventoryEntrance2=inventoryStockRepository.findOne(inventoryEntrance.getId());
			if(inventoryEntrance2!=null)
			{
				dispatchLog.setInventoryEntrance(inventoryEntrance2);
			}
		}
		subcategory=inventoryEntrance.getSubCategory();
		if(subcategory!=null){
			dispatchLog.setSubCategory(inventoryEntrance.getSubCategory());
			}else{
				subcategory=inventoryAssign.getSubCategory();
				if(subcategory!=null){
					dispatchLog.setSubCategory(inventoryAssign.getSubCategory());
				}
			}
		/*dispatchLog.setLastModifiedBy(principal.getName());
		dispatchLog.setLastModifiedDate(new Date());
		dispatchLog.setAllocatedQty(inventoryRequestDto.getQuantity());
		dispatchLog.setWareHouseSiteName(inventoryRequestDto.getRequestedTo());*/
		
		dispatchLog.setModelCode(inventoryRequestDto.getModelCode());
		
		dispatchLog = dispatchLogRepository.saveAndFlush(dispatchLog);
		if(dispatchLog!=null)
		{
			status=InventoryConstant.SUCCESS;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--ToolsRequestServiceImpl-------------saveDispatchLogEntity--------------------Ended-->");
		return status;
	}
	
	

	
	public InventoryRequest mapInventoryRequest(InventoryEntrance inventoryEntrance,InventoryAssign inventoryAssign, InventoryRequest inventoryRequest, InventoryRequestDto inventoryRequestDto, Principal principal) 
	{
		logger.info("<--ToolsRequestServiceImpl-------------mapInventoryRequest--------------------started-->");
		try{
		//inventoryRequest.setId(inventoryRequestDto.getId());
		inventoryRequest.setAcceptedQuantity(inventoryRequestDto.getQuantity());
		/*if (inventoryRequestDto.getDispatchDate() != null) {
			inventoryRequest.setDispatchDate(MasterDateUtil.convertStringToTimeStampDate(inventoryRequestDto.getDispatchDate()));

		}
		if(inventoryEntrance!=null){
		inventoryRequest.setInventoryEntrance(inventoryEntrance);	
		}
		if(inventoryAssign!=null){
			inventoryRequest.setInventoryAssign(inventoryAssign);
		}*/
		
		
		if(inventoryEntrance.getInventoryNumber()!=null){
		inventoryRequest.setInventoryNumber(inventoryEntrance.getInventoryNumber());	
		}
		if(inventoryAssign.getInventoryNumber()!=null){
			inventoryRequest.setInventoryNumber(inventoryAssign.getInventoryNumber());
		}
		inventoryRequest.setDispatchDate(new Date());
		inventoryRequest.setChallanStatus("NO");
		inventoryRequest.setComments("OK");
		inventoryRequest.setNotificationLink("ToolsRequestView");
		inventoryRequest.setNotificationStatus(InventoryConstant.OLD);
		inventoryRequest.setComments(inventoryRequestDto.getComments());
		inventoryRequest.setStatus(inventoryRequestDto.getStatus());
		inventoryRequest.setSubStatus(inventoryRequestDto.getSubStatus());
		
		inventoryRequest.setActionBy(principal.getName());
		inventoryRequest.setActionDate(new Timestamp(new Date().getTime()));
		logger.info("<--ToolsRequestServiceImpl-------------mapInventoryRequest--------------------Ended-->");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryRequest;
	}

	@Override
	public String saveMoveTools(ServiceTrackerDto serviceTrackerDto, Principal principal) throws Exception {
		String status = InventoryConstant.FAILURE;

		logger.info("<--Tools Request serviceImpl-------------save Move tool after service--------------------started-->");
	
			InventoryEntrance inventoryEntrance = new InventoryEntrance();
			InventoryAssign inventoryAssign = new InventoryAssign();
			InventoryRequest inventoryRequest = new InventoryRequest();
			DispatcherLog dispatcherLog= new DispatcherLog();
			Integer remaining = null;
			if (serviceTrackerDto.getNeedChallan().equalsIgnoreCase(InventoryConstant.YES))
			{
				dispatcherLog = new	DispatcherLog();
				dispatcherLog.setId(serviceTrackerDto.getId());
				dispatcherLog.getChallanNo();
				dispatcherLog.setComments(serviceTrackerDto.getComments());
				dispatcherLog.setQuantity(serviceTrackerDto.getQuantity());
				//dispatcherLog.setSubCategory(serviceTrackerDto.getSubCategory());
				dispatcherLog.setDispatchDate(new Date());
				dispatcherLog.setActionBy(principal.getName());
				/*if(serviceTrackerDto.get)
				dispatcherLog.setInventoryNumber();;
				dispatcherLog.set
				dispatcherLog.*/
							
			} else if (serviceTrackerDto.getNeedChallan().equalsIgnoreCase(InventoryConstant.NO))
			
			{
				if (serviceTrackerDto.getMoveBackTo().equalsIgnoreCase(InventoryConstant.WAREHOUSE))
				{
				
					
			}else if (serviceTrackerDto.getMoveBackTo().equalsIgnoreCase(InventoryConstant.PROJECTSITE))
			{

                    


	}

			}
			logger.info("<--Tools Request serviceImpl-------------save Move tool after service--------------------ended-->");
			return status;
	

	}

}
