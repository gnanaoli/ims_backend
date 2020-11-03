package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ServiceInspectionDto;
import com.fa.inventory.dto.ServiceTrackerDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.ServiceInspection;
import com.fa.inventory.entity.ServiceTracker;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.repository.ServiceInspectionRepository;
import com.fa.inventory.repository.ServiceTrackerRepository;
import com.fa.inventory.repository.SubCategoryRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.ProjectService;
import com.fa.inventory.service.ServiceTrackerService;

@Service
public class ServiceTrackerServiceImpl implements ServiceTrackerService {

	protected final Logger logger = Logger.getLogger(ServiceTrackerServiceImpl.class);

	@Resource
	ServiceTrackerRepository serviceTrackerRepository;

	@Resource
	ServiceInspectionRepository serviceInspectionRepository;

	@Resource
	SubCategoryRepository subCategoryRepository;
	
	@Resource
	UserRepository userRepository;
	
	@Resource
	ProjectService projectservice;

	/* ss */

	@Override
	public ServiceTrackerDto mapServiceTrackerDtoById(ServiceTracker serviceTracker) {
		// serviceTrackerRepository.deleteAll()
		logger.info("<--ServiceTrackerServiceImpl-------------mapServiceTrackerDtoById--------------------started-->");
		ServiceTrackerDto serviceTrackerDto = new ServiceTrackerDto();
		try {
			serviceTrackerDto.setId(serviceTracker.getId());
			serviceTrackerDto.setComments(serviceTracker.getComments());
			serviceTrackerDto.setCreatedBy(serviceTracker.getCreatedBy());
			serviceTrackerDto.setLastModified(serviceTracker.getLastModifiedBy());
			serviceTrackerDto.setFromLocation(serviceTracker.getFromLocation());
			serviceTrackerDto.setInventoryNumber(serviceTracker.getInventoryNumber());
			if (serviceTracker.getCategory().getCategoryType() != null) {
				serviceTrackerDto.setCategory(serviceTracker.getCategory().getCategoryType());
			}
			if (serviceTracker.getSubCategory().getSubCategory() != null) {
				serviceTrackerDto.setSubCategory(serviceTracker.getSubCategory().getSubCategory());
				serviceTrackerDto.setModelCode(serviceTracker.getSubCategory().getModel());
			}

			if (serviceTracker.getCreationDate() != null) {
				serviceTrackerDto.setCreationDate(MasterDateUtil.convertDateToString(serviceTracker.getCreationDate()));
			}
			if (serviceTracker.getLastModifiedDate() != null) {
				serviceTrackerDto.setLastModifiedDate(MasterDateUtil.convertDateToString(serviceTracker.getLastModifiedDate()));
			}

			serviceTrackerDto.setInventoryNumber(serviceTracker.getInventoryNumber());
			serviceTrackerDto.setQuantity(serviceTracker.getQuantity());
			serviceTrackerDto.setSerialNumber(serviceTracker.getSerialNumber());
			serviceTrackerDto.setStatus(serviceTracker.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ServiceTrackerServiceImpl-------------mapServiceTrackerDtoById--------------------Ended-->");
		return serviceTrackerDto;
	}

	public List<?> getAllService(Principal principal) {
		List<ServiceTrackerDto> serviceTrackerDtoList = null;

		logger.info("<--ServiceTrackerServiceImpl-------------getAllService--------------------started-->");
		try {
			List<ServiceTracker> serviceTrackerEntities = serviceTrackerRepository.findAll();

			if (serviceTrackerEntities != null && !serviceTrackerEntities.isEmpty()) {

				serviceTrackerDtoList = new ArrayList<>();

				for (int i = 0; i < serviceTrackerEntities.size(); i++) {

					ServiceTracker serviceTracker = serviceTrackerEntities.get(i);

					if (serviceTracker != null) {

						ServiceTrackerDto serviceTrackerDto = new ServiceTrackerDto();

						serviceTrackerDto.setId(serviceTracker.getId());
						serviceTrackerDto.setCreatedBy(serviceTracker.getCreatedBy());
						serviceTrackerDto
								.setCreationDate(MasterDateUtil.convertDateToString(serviceTracker.getCreationDate()));
						serviceTrackerDto.setInventoryNumber(serviceTracker.getInventoryNumber());
						serviceTrackerDto.setQuantity(serviceTracker.getQuantity());
						serviceTrackerDto.setSerialNumber(serviceTracker.getSerialNumber());
						serviceTrackerDto.setStatus(serviceTracker.getStatus());
						serviceTrackerDto.setFromLocation(serviceTracker.getFromLocation());
						serviceTrackerDto.setWarehouseSiteName(serviceTracker.getWarehouseSiteName());
					
						
						CategoryDto categorydto = new CategoryDto();
						categorydto.setCategoryType(serviceTracker.getCategory().getCategoryType());
						serviceTrackerDto.setCategory1(categorydto);
						
						
						SubCategoryDto subCategoryDto = new SubCategoryDto();
						subCategoryDto.setSubCategory(serviceTracker.getSubCategory().getSubCategory());
                        subCategoryDto.setSubCategory(serviceTracker.getSubCategory().getModel()); 
                        serviceTrackerDto.setSubCategory1(subCategoryDto);
						serviceTrackerDtoList.add(serviceTrackerDto);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ServiceTrackerServiceImpl-------------getAllService--------------------Ended-->");

		return serviceTrackerDtoList;
	}

	@Override
	public List<ServiceInspectionDto> getAllServiceInspection(Principal principal) throws Exception {

		logger.info("<--ServiceTrackerImpl-------------getAllServiceInspection--------------------started-->");
		List<ServiceInspectionDto> serviceInspectionDtoList = null;
		try {

			List<ServiceInspection> serviceInspectionsEntityList = serviceInspectionRepository.findAll();

			if (serviceInspectionsEntityList != null) {
				serviceInspectionDtoList = new ArrayList<>();

				for (int i = 0; i < serviceInspectionsEntityList.size(); i++) {

					ServiceInspection serviceInspectionEntity = serviceInspectionsEntityList.get(i);

					if (serviceInspectionEntity != null) {

						if ((serviceInspectionEntity.getStatus().equals(InventoryConstant.MOVETOSCRAPREQUESTED)
								|| serviceInspectionEntity.getStatus()
										.equals(InventoryConstant.MOVETOSERVICEREQUESTED))) {
							ServiceInspectionDto serviceInspectionDto = new ServiceInspectionDto();

							serviceInspectionDto.setId(serviceInspectionEntity.getId());
							serviceInspectionDto.setAcceptedQuantity(serviceInspectionEntity.getAcceptedQuantity());
							serviceInspectionDto.setActionBy(serviceInspectionEntity.getActionBy());
							serviceInspectionDto.setActionDate(
									MasterDateUtil.convertDateToString(serviceInspectionEntity.getActionDate()));
							serviceInspectionDto.setComments(serviceInspectionEntity.getComments());
							serviceInspectionDto.setDispatchDate(
									MasterDateUtil.convertDateToString(serviceInspectionEntity.getDispatchDate()));
							serviceInspectionDto.setExpectedDateToReach(MasterDateUtil
									.convertDateToString(serviceInspectionEntity.getExpectedDateToReach()));
							serviceInspectionDto.setLocation(serviceInspectionEntity.getLocation());
							serviceInspectionDto.setModelCode(serviceInspectionEntity.getModelCode());
							serviceInspectionDto.setQuantity(serviceInspectionEntity.getQuantity());
							serviceInspectionDto.setRaisedBy(serviceInspectionEntity.getRaisedBy());
							serviceInspectionDto.setRaisedDate(
									MasterDateUtil.convertDateToString(serviceInspectionEntity.getRaisedDate()));
							serviceInspectionDto.setReferenceNo(serviceInspectionEntity.getReferenceNo());
							serviceInspectionDto.setRequestedTo(serviceInspectionEntity.getRequestedTo());
							serviceInspectionDto.setRequiredDays(serviceInspectionEntity.getRequiredDays());
							serviceInspectionDto.setStatus(serviceInspectionEntity.getStatus());
							serviceInspectionDto.setSubStatus(serviceInspectionEntity.getSubStatus());
							serviceInspectionDto.setRequestedFrom(serviceInspectionEntity.getRequestedFrom());

							serviceInspectionDto
									.setCategoryType(serviceInspectionEntity.getCategory().getCategoryType());
							serviceInspectionDto
									.setSubCategory(serviceInspectionEntity.getSubCategory().getSubCategory());
							serviceInspectionDtoList.add(serviceInspectionDto);

						}

					}
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		logger.info("<--ServiceTrackerImpl-------------getAllServiceInspection--------------------Ended-->");
		return serviceInspectionDtoList;
	}

	@Override
	public List<?> saveServiceDispatch(Principal principal) {
		List<ServiceTrackerDto> serviceTrackerDtoList = null;

		logger.info("<--ServiceTrackerServiceImpl-------------saveServiceDispatch--------------------started-->");
		try {
			List<ServiceTracker> serviceTrackerEntities = serviceTrackerRepository.findAll();

			if (serviceTrackerEntities != null && !serviceTrackerEntities.isEmpty()) {

				serviceTrackerDtoList = new ArrayList<>();

				for (int i = 0; i < serviceTrackerEntities.size(); i++) {

					ServiceTracker serviceTracker = serviceTrackerEntities.get(i);

					if (serviceTracker != null) {

						ServiceTrackerDto serviceTrackerDto = new ServiceTrackerDto();

						serviceTrackerDto.setId(serviceTracker.getId());
						serviceTrackerDto.setCreatedBy(serviceTracker.getCreatedBy());
						serviceTrackerDto
								.setCreationDate(MasterDateUtil.convertDateToString(serviceTracker.getCreationDate()));
						serviceTrackerDto.setQuantity(serviceTracker.getQuantity());
						serviceTrackerDto.setSerialNumber(serviceTracker.getSerialNumber());
						serviceTrackerDto.setStatus(serviceTracker.getStatus());
						serviceTrackerDtoList.add(serviceTrackerDto);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ServiceTrackerServiceISSmpl-------------saveServiceDispatch--------------------Ended-->");

		return serviceTrackerDtoList;
	}

	@Override
	public ServiceTrackerDto findOne(Long id, Principal principal) {
		ServiceTrackerDto serviceTrackerDto = null;

		try {
			ServiceTracker serviceTracker = serviceTrackerRepository.findOne(id);
			if (null != serviceTracker) {
				serviceTrackerDto = new ServiceTrackerDto();
				serviceTrackerDto.setId(serviceTracker.getId());
				serviceTrackerDto.setComments(serviceTracker.getComments());
				serviceTrackerDto.setQuantity(serviceTracker.getQuantity());
				serviceTrackerDto.setCreatedBy(serviceTracker.getCreatedBy());
				serviceTrackerDto.setCreationDate(MasterDateUtil.convertDateToString(serviceTracker.getCreationDate()));
				serviceTrackerDto.setFromDate(MasterDateUtil.convertDateToString(serviceTracker.getFromDate()));
				serviceTrackerDto.setSerialNumber(serviceTracker.getSerialNumber());
				serviceTrackerDto.setStatus(serviceTracker.getStatus());
				serviceTrackerDto.setToDate(MasterDateUtil.convertDateToString(serviceTracker.getToDate()));
				serviceTrackerDto.setType(serviceTracker.getType());
				serviceTrackerDto.setWorkingNonWorking(serviceTracker.getWorkingCondtion());
				serviceTrackerDto.setSubCategory(serviceTracker.getSubCategory().getSubCategory());
				// inventoryRequestDto.setInventoryNumber(serviceTracker.getInventoryNumber());
				serviceTrackerDto.setInventoryNumber(serviceTracker.getInventoryNumber());

				serviceTrackerDto.setSubCategory(serviceTracker.getSubCategory().getSubCategory());
				serviceTrackerDto.setModelCode(serviceTracker.getSubCategory().getModel());

				/*
				 * if(serviceTracker.get()!=null) {
				 * serviceTrackerDto.setTelephoneNumber(Long.toString(
				 * serviceTracker.getTelephoneNumber())); }
				 * if(serviceTracker.getFax()!=null) {
				 * serviceTrackerDto.setFax(Long.toString(serviceTracker.getFax(
				 * ))); }
				 * 
				 * if(serviceTracker.getMobileNumber()!=null) {
				 * serviceTrackerDto.setMobileNumber(Long.toString(
				 * serviceTracker.getMobileNumber())); }
				 */

				if (serviceTracker.getCreationDate() != null) {
					serviceTrackerDto
							.setCreationDate(MasterDateUtil.convertDateToString(serviceTracker.getCreationDate()));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return serviceTrackerDto;
	}
	
	
	@Override
	public List<?> getAllServiceDueDateForAllRole(Principal principal) {
		
		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllServiceDueDate1--------------------Started-->");

		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		
		List<Object> inventoryServiceDueDateEntityList = null;
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean hasOfficeRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.OFFICE_ADMINISTRATOR));
		
		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.USER) ||  r.getAuthority().equals(InventoryConstant.SUPER_USER) ||  r.getAuthority().equals(InventoryConstant.ENQUIRY) ||  r.getAuthority().equals(InventoryConstant.SAFETY_ENGINEER));
		
		boolean hasWareHouseRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR));
		
		if(hasOfficeRole)
		{
			inventoryServiceDueDateEntityList = serviceTrackerRepository.getAllServiceDueDate();
		}
		
		if(hasUserRole)
		{
			
			List<Project> projectEntityList = null;
			List<ProjectDto> projectDtoList = null;
			List<String> projectList = new ArrayList<>();
			
	        User user = userRepository.findByUserName(principal.getName());
	        if (user.getProjectItem() != null && !user.getProjectItem().isEmpty()) {
	                projectEntityList = user.getProjectItem();
	                if (projectEntityList != null) {
	                        projectDtoList = new ArrayList<>();
	                        
	                        for (int k = 0; k < projectEntityList.size(); k++) {
	                                Project project = user.getProjectItem().get(k);
	                                if (project !=null)
	                                {
	                                	projectList.add(project.getName());
	                                }
	                        }
	                }
	        }
	        
			if(projectDtoList != null && !projectList.isEmpty())
			{
				inventoryServiceDueDateEntityList = serviceTrackerRepository.getAllUserServiceDueDate(projectList);
			}
	        
		}
		
		if(hasWareHouseRole)
		{
			
			List<WareHouse> warehouseEntityList = null;
			List<WareHouseDto> warehouseDtoList = null;
			List<String> warehouseList = new ArrayList<>();
			
	        User user = userRepository.findByUserName(principal.getName());
	        if (user.getWareHouseItem() != null && !user.getWareHouseItem().isEmpty()) {
	        	warehouseEntityList = user.getWareHouseItem();
	                if (warehouseEntityList != null) {
	                	warehouseDtoList = new ArrayList<>();
	                        
	                        for (int k = 0; k < warehouseEntityList.size(); k++) {
	                        		WareHouse wareHouse = user.getWareHouseItem().get(k);
	                                if (wareHouse !=null)
	                                {
	                                	warehouseList.add(wareHouse.getWareHouseName());
	                                }
	                        }
	                }
	        }
	        
			if(warehouseList != null && !warehouseList.isEmpty())
			{
				inventoryServiceDueDateEntityList = serviceTrackerRepository.getAllWareHouseServiceDueDate(warehouseList);
			}
	        
		}

		

		if (inventoryServiceDueDateEntityList != null && !inventoryServiceDueDateEntityList.isEmpty()) {
			for (int j = 0; j < inventoryServiceDueDateEntityList.size(); j++) {
				Object object = inventoryServiceDueDateEntityList.get(j);
				if (object != null) {
					Object[] objectArray = (Object[]) object;
					
					InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
					
					inventoryEntranceDto.setServiceDueDate(objectArray[0].toString());
					inventoryEntranceDto.setWarehouseOrSitename(objectArray[1].toString());
					inventoryEntranceDto.setCategoryType(objectArray[2].toString());
					inventoryEntranceDto.setSubCategory(objectArray[3].toString());
					inventoryEntranceDto.setDue_month(objectArray[4].toString());
					inventoryEntranceDtoList.add(inventoryEntranceDto);

				}
			}
		}

		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllServiceDueDate1--------------------Ended-->");
		return inventoryEntranceDtoList;
	}
	

	@Override
	public List<?> getAllServiceDueDate(Principal principal) {
		
		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllServiceDueDate--------------------Started-->");

		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();

		List<Object> inventoryServiceDueDateEntityList = serviceTrackerRepository.getAllServiceDueDate();

		if (inventoryServiceDueDateEntityList != null && !inventoryServiceDueDateEntityList.isEmpty()) {
			for (int j = 0; j < inventoryServiceDueDateEntityList.size(); j++) {
				Object object = inventoryServiceDueDateEntityList.get(j);
				if (object != null) {
					Object[] objectArray = (Object[]) object;
					
					InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
					
					inventoryEntranceDto.setServiceDueDate(objectArray[0].toString());
					inventoryEntranceDto.setWarehouseOrSitename(objectArray[1].toString());
					inventoryEntranceDto.setCategoryType(objectArray[2].toString());
					inventoryEntranceDto.setSubCategory(objectArray[3].toString());
					inventoryEntranceDto.setDue_month(objectArray[4].toString());
					inventoryEntranceDtoList.add(inventoryEntranceDto);

				}
			}
		}

		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllServiceDueDate--------------------Ended-->");
		return inventoryEntranceDtoList;
	}
	
	
	@Override
	public List<?> getAllUserServiceDueDate(Principal principal) {
		
		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllUserServiceDueDate--------------------Started-->");
		
		List<Project> projectEntityList = null;
		List<ProjectDto> projectDtoList = null;
		List<String> projectList = new ArrayList<>();
		
        User user = userRepository.findByUserName(principal.getName());
        if (user.getProjectItem() != null && !user.getProjectItem().isEmpty()) {
                projectEntityList = user.getProjectItem();
                if (projectEntityList != null) {
                        projectDtoList = new ArrayList<>();
                        
                        for (int k = 0; k < projectEntityList.size(); k++) {
                                Project project = user.getProjectItem().get(k);
                                if (project !=null)
                                {
                                	projectList.add(project.getName());
                                }
                        }
                }
        }

		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		
		if(projectDtoList != null)
		{
			List<Object> inventoryServiceDueDateEntityList = serviceTrackerRepository.getAllUserServiceDueDate(projectList);
			
			if (inventoryServiceDueDateEntityList != null && !inventoryServiceDueDateEntityList.isEmpty()) {
				for (int j = 0; j < inventoryServiceDueDateEntityList.size(); j++) {
					Object object = inventoryServiceDueDateEntityList.get(j);
					if (object != null) {
						Object[] objectArray = (Object[]) object;
						
						InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
						
						inventoryEntranceDto.setServiceDueDate(objectArray[0].toString());
						inventoryEntranceDto.setWarehouseOrSitename(objectArray[1].toString());
						inventoryEntranceDto.setCategoryType(objectArray[2].toString());
						inventoryEntranceDto.setSubCategory(objectArray[3].toString());
						inventoryEntranceDto.setDue_month(objectArray[4].toString());
						inventoryEntranceDtoList.add(inventoryEntranceDto);

					}
				}
			}
		}

		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllUserServiceDueDate--------------------Ended-->");

		return inventoryEntranceDtoList;
	}
	
	
	@Override
	public List<?> getAllWareHouseServiceDueDate(Principal principal) {
		
		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllWareHouseServiceDueDate--------------------Started-->");
		
		List<WareHouse> warehouseEntityList = null;
		List<WareHouseDto> warehouseDtoList = null;
		List<String> warehouseList = new ArrayList<>();
		
        User user = userRepository.findByUserName(principal.getName());
        if (user.getWareHouseItem() != null && !user.getWareHouseItem().isEmpty()) {
        	warehouseEntityList = user.getWareHouseItem();
                if (warehouseEntityList != null) {
                	warehouseDtoList = new ArrayList<>();
                        
                        for (int k = 0; k < warehouseEntityList.size(); k++) {
                        		WareHouse wareHouse = user.getWareHouseItem().get(k);
                                if (wareHouse !=null)
                                {
                                	warehouseList.add(wareHouse.getWareHouseName());
                                }
                        }
                }
        }

		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		
		if(warehouseList != null)
		{
			List<Object> inventoryServiceDueDateEntityList = serviceTrackerRepository.getAllWareHouseServiceDueDate(warehouseList);

			if (inventoryServiceDueDateEntityList != null && !inventoryServiceDueDateEntityList.isEmpty()) {
				for (int j = 0; j < inventoryServiceDueDateEntityList.size(); j++) {
					Object object = inventoryServiceDueDateEntityList.get(j);
					if (object != null) {
						Object[] objectArray = (Object[]) object;
						
						InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
						
						inventoryEntranceDto.setServiceDueDate(objectArray[0].toString());
						inventoryEntranceDto.setWarehouseOrSitename(objectArray[1].toString());
						inventoryEntranceDto.setCategoryType(objectArray[2].toString());
						inventoryEntranceDto.setSubCategory(objectArray[3].toString());
						inventoryEntranceDto.setDue_month(objectArray[4].toString());
						inventoryEntranceDtoList.add(inventoryEntranceDto);

					}
				}
			}
		}
		
		logger.info("<--ServiceTrackerServiceISSmpl-------------getAllWareHouseServiceDueDate--------------------Ended-->");

		return inventoryEntranceDtoList;
	}
	
	
}