package com.fa.inventory.service.impl;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.FindToolsDto;
import com.fa.inventory.dto.InventoryAssignDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.dto.WareHouseBlocksDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.DeliveryChallanEntity;
import com.fa.inventory.entity.DispatcherLog;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.InventoryRequest;
import com.fa.inventory.entity.Manufacturer;
import com.fa.inventory.entity.Notifications;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.Scrap;
import com.fa.inventory.entity.ScrapInspection;
import com.fa.inventory.entity.ServiceInspection;
import com.fa.inventory.entity.SubCategory;
import com.fa.inventory.entity.Supplier;
import com.fa.inventory.entity.Type;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.entity.WareHouseBlocks;
import com.fa.inventory.repository.CategoryRepository;
import com.fa.inventory.repository.DeliveryChallanEntityRepository;
import com.fa.inventory.repository.DispatchLogRepository;
import com.fa.inventory.repository.EmployeeRepository;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.repository.InventoryRequestRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.ManufacturerRepository;
import com.fa.inventory.repository.NotificationsRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.ScrapInspectionRepository;
import com.fa.inventory.repository.ScrapRepository;
import com.fa.inventory.repository.ServiceInspectionRepository;
import com.fa.inventory.repository.SubCategoryRepository;
import com.fa.inventory.repository.SupplierMasterRespository;
import com.fa.inventory.repository.ToolsRequestRepository;
import com.fa.inventory.repository.TypeRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.repository.WareHouseBlockRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.DispatchLogService;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.ToolsRequestService;
import com.fa.inventory.service.UserManagementService;

@Service
public class InventoryManagementServiceImpl implements InventoryManagementService {

	protected final Logger logger = Logger.getLogger(InventoryManagementServiceImpl.class);

	@Resource
	DispatchLogRepository dispatchLogRepository;

	@Resource
	InventoryStockRepository inventoryStockRepository;

	@Resource
	EmployeeRepository employeeRepository;

	@Resource
	CategoryRepository categoryRepository;

	@Resource
	TypeRepository typeRepository;

	@Resource
	UserRepository userRepository;

	@Resource(name = "Inventory")
	JdbcTemplate jdbcTemplate;

	@Resource
	WareHouseBlockRepository wareHouseBlockRepository;

	@Resource
	SubCategoryRepository subCategoryRepository;

	@Resource
	ManufacturerRepository manufacturerRepository;

	@Resource
	SupplierMasterRespository supplierMasterRespository;

	@Resource
	InventoryAssignRepository inventoryAssignRepository;

	@Resource
	ProjectRepository projectRepository;

	@Resource
	ToolsRequestService toolsRequestService;

	@Resource
	ToolsRequestRepository toolsRequestRepository;

	@Resource
	InventoryRequestRepository inventoryRequestRepository;

	@Resource
	ScrapRepository scrapRepository;

	@Resource
	WareHouseRepository wareHouseRepository;

	@Resource
	DispatchLogService dispatchLogService;

	@Resource
	UserManagementService UserManagementService;

	@Resource
	DeliveryChallanEntityRepository deliveryChallanEntityRepository;

	@Resource
	ScrapInspectionRepository scrapInspectionRepository;

	@Resource
	ServiceInspectionRepository serviceInspectionRepository;

	@Resource
	NotificationsRepository notificationsRepository;

	@Resource
	InventoryManagementService inventoryManagementService;

	@Resource
	UserManagementService userManagementService;

	@Override
	public List<InventoryEntranceDto> getAllInventoryManagementList(Principal principal) {
		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		List<WareHouseDto> wareHouseDtoList = null;
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------getAllInventoryManagementList--------------------started-->");

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			boolean hasWarehouseRole = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR));

			boolean hasOfficeRole = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals(InventoryConstant.OFFICE_ADMINISTRATOR));

			if (hasWarehouseRole) {
				wareHouseDtoList = userManagementService.getCurrentUserWareHouseDtoList(principal);

				List<InventoryEntrance> inventoryEntranceList = inventoryStockRepository.findAll();

				for (int i = 0; i < inventoryEntranceList.size(); i++) {

					InventoryEntrance inventoryEntrance = inventoryEntranceList.get(i);
					for (int j = 0; j < wareHouseDtoList.size(); j++) {
						WareHouseDto wareHouse = wareHouseDtoList.get(j);
						if (wareHouse.getWareHouseName().equals(inventoryEntrance.getWareHouseSiteName())) {

							if (inventoryEntrance.getAvailableQuantity() > 0
									&& inventoryEntrance.getLocation().equals(InventoryConstant.WAREHOUSE)) {

								inventoryEntranceDtoList.add(mapInventoryDto(inventoryEntrance));
							}

						}

					}
				}
			}

			/* THIS IS FOR GET ALL THE VALUES FROM PROJECTANDWAREHOUSE */

			if (hasOfficeRole) {
				/*
				 * List<?> inventoryEntranceList =
				 * inventoryStockRepository.findAllInventory(); if
				 * (inventoryEntranceList != null &&
				 * inventoryEntranceList.size() > 0) { for (Object object :
				 * inventoryEntranceList) { Object[] ob = (Object[]) object;
				 * InventoryEntranceDto inventoryEntranceDto = new
				 * InventoryEntranceDto(); if (ob[10].equals("WAREHOUSE")) {
				 * inventoryEntranceDto.setCategoryType(String.valueOf(ob[0]));
				 * inventoryEntranceDto.setCategoryCode(String.valueOf(ob[1]));
				 * inventoryEntranceDto.setAssetTracking(String.valueOf(ob[2]));
				 * inventoryEntranceDto.setSubCategory(String.valueOf(ob[3]));
				 * inventoryEntranceDto.setAvailableQuantity((Integer) ob[4]);
				 * inventoryEntranceDto.setModelCode(String.valueOf(ob[5]));
				 * inventoryEntranceDto.setInventoryNumber(String.valueOf(ob[6])
				 * ); inventoryEntranceDto.setSite(String.valueOf(ob[7]));
				 * inventoryEntranceDto.setQuantity((Integer) ob[8]);
				 * inventoryEntranceDto.setCreationDate(String.valueOf(ob[9]));
				 * // inventoryEntrance.setModelcode(String.valueOf(ob[2]));
				 * inventoryEntranceDto.setButton(InventoryConstant.VIEW_BUTTON)
				 * ; inventoryEntranceDto.setButton(InventoryConstant.EDIT);
				 * inventoryEntranceDtoList.add(inventoryEntranceDto); } else {
				 * inventoryEntranceDto.setCategoryType(String.valueOf(ob[0]));
				 * inventoryEntranceDto.setCategoryCode(String.valueOf(ob[1]));
				 * inventoryEntranceDto.setAssetTracking(String.valueOf(ob[2]));
				 * inventoryEntranceDto.setSubCategory(String.valueOf(ob[3]));
				 * inventoryEntranceDto.setAvailableQuantity((Integer) ob[4]);
				 * inventoryEntranceDto.setModelCode(String.valueOf(ob[5]));
				 * inventoryEntranceDto.setInventoryNumber(String.valueOf(ob[6])
				 * ); inventoryEntranceDto.setSite(String.valueOf(ob[7]));
				 * inventoryEntranceDto.setQuantity((Integer) ob[8]);
				 * inventoryEntranceDto.setCreationDate(String.valueOf(ob[9]));
				 * // inventoryEntrance.setModelcode(String.valueOf(ob[2]));
				 * inventoryEntranceDto.setButton(InventoryConstant.VIEW_BUTTON)
				 * ;
				 * 
				 * inventoryEntranceDtoList.add(inventoryEntranceDto); } }
				 * 
				 * }
				 */

				Long str = System.currentTimeMillis();

				Date st = new Date();

				List<InventoryEntrance> inventoryEntranceList = inventoryStockRepository.findAll();
				List<InventoryAssign> inventoryAssignList = inventoryAssignRepository.findAll();
				if (inventoryEntranceList != null) {
					for (int i = 0; i < inventoryEntranceList.size(); i++) {
						InventoryEntrance inventoryEntrance = inventoryEntranceList.get(i);
						if (inventoryEntrance != null) {
							if (inventoryEntrance.getAvailableQuantity() > 0
									&& inventoryEntrance.getLocation().equals(InventoryConstant.WAREHOUSE)

							) {
								inventoryEntranceDtoList.add(mapInventoryDto(inventoryEntrance));
							}

						}
					}
				}
				if (inventoryAssignList != null) {
					for (int i = 0; i < inventoryAssignList.size(); i++) {
						InventoryAssign inventoryAssign = inventoryAssignList.get(i);
						InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
						if (inventoryAssign != null) {
							if (inventoryAssign.getAvailableQty() >= 0
									&& inventoryAssign.getInventoryLocation().equals(InventoryConstant.PROJECTSITE)

							) {

								inventoryEntranceDto.setAvailableQuantity(inventoryAssign.getAvailableQty());
								inventoryEntranceDto.setQuantity(inventoryAssign.getAllocatedQty());
								inventoryEntranceDto.setInventoryNumber(inventoryAssign.getInventoryNumber());
								inventoryEntranceDto.setModelCode(inventoryAssign.getModelCode());
								// inventoryEntranceDto.setSite(inventoryAssign.setWareHouseSiteName());
								inventoryEntranceDto.setSite(inventoryAssign.getAssignedLocation());
								inventoryEntranceDto.setCategoryCode(inventoryAssign.getCategory().getCategoryCode());
								inventoryEntranceDto.setCategoryType(inventoryAssign.getCategory().getCategoryType());
								inventoryEntranceDto.setAssetTracking(inventoryAssign.getCategory().getAssetTracking());
								inventoryEntranceDto.setSubCategory(inventoryAssign.getSubCategoryName());
								inventoryEntranceDto.setCreationDate(MasterDateUtil
										.convertDateToStringWithTime((inventoryAssign.getCreationDate())));
								inventoryEntranceDto.setButton(InventoryConstant.VIEW_BUTTON);
								inventoryEntranceDtoList.add(inventoryEntranceDto);
							}

						}
					}

					Long fin = System.currentTimeMillis();

					Date lt = new Date();

					System.out.println("Timeee " + (fin - str) + " " + st + " " + lt);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		logger.info(
				"<--InventoryManagementServiceImpl-------------getAllInventoryManagementList--------------------started-->");
		return inventoryEntranceDtoList;
	}

	/*
	 * private InventoryEntranceDto mapInventoryDto(InventoryEntranceDto
	 * inventoryEntranceDto) { inv = new InventoryEntranceDto(); Category
	 * category = inventoryEntrance.getCategory(); List<InventoryAssignDto>
	 * inventoryassignDtoList = new ArrayList<>();
	 * 
	 * }
	 */

	@Override
	public List<InventoryEntranceDto> getAllInventoryManagementFromStockForAssign(Principal principal) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------getAllInventoryManagementList--------------------started-->");
		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------getAllInventoryManagementList--------------------started-->");
			List<InventoryEntrance> inventoryEntranceList = inventoryStockRepository.findAll();
			for (int i = 0; i < inventoryEntranceList.size(); i++) {
				InventoryEntrance inventoryEntrance = inventoryEntranceList.get(i);
				if (inventoryEntrance != null) {
					if (inventoryEntrance.getAvailableQuantity() > 0
							&& inventoryEntrance.getLocation().equals(InventoryConstant.WAREHOUSE)) {
						inventoryEntranceDtoList.add(mapInventoryDto(inventoryEntrance));
					}
				}
			}
			/*
			 * List<WareHouseDto> wareHouseDtoList=UserManagementService.
			 * getCurrentUserWareHouseDtoList(principal);
			 * if(wareHouseDtoList!=null && !wareHouseDtoList.isEmpty()) {
			 * for(int i=0;i<wareHouseDtoList.size();i++) { WareHouseDto
			 * wareHouseDto=wareHouseDtoList.get(i); if(wareHouseDto!=null) {
			 * List<InventoryEntrance>
			 * inventoryEntranceEntityList=inventoryStockRepository.
			 * findByWareHouseSiteName(wareHouseDto.getWareHouseName());
			 * if(inventoryEntranceEntityList!=null) { for(int
			 * j=0;j<inventoryEntranceEntityList.size();j++) { InventoryEntrance
			 * inventoryEntrance=inventoryEntranceEntityList.get(j);
			 * if(inventoryEntrance!=null) {
			 * if(inventoryEntrance.getAvailableQuantity()>0 &&
			 * inventoryEntrance.getLocation().equals(InventoryConstant.
			 * WAREHOUSE)) {
			 * inventoryEntranceDtoList.add(mapInventoryDto(inventoryEntrance));
			 * } } } } } } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info(
				"<--InventoryManagementServiceImpl-------------getAllInventoryManagementList--------------------Ended-->");
		return inventoryEntranceDtoList;
	}

	// check this method here bug coming--sathish kumar
	@Override
	public InventoryEntranceDto mapInventoryDto(InventoryEntrance inventoryEntrance) {
		InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
		Category category = inventoryEntrance.getCategory();
		List<InventoryAssignDto> inventoryassignDtoList = new ArrayList<>();

		logger.info("<--InventoryManagementServiceImpl-------------mapInventoryDto--------------------started-->");
		try {

			if (category != null) {
				Category categoryEntity = categoryRepository.findOne(category.getId());
				inventoryEntranceDto.setCategoryCode(categoryEntity.getCategoryCode());
				inventoryEntranceDto.setCategoryType(categoryEntity.getCategoryType());
				inventoryEntranceDto.setAssetTracking(categoryEntity.getAssetTracking());
				inventoryEntranceDto.setId(inventoryEntrance.getId());
				inventoryEntranceDto.setInventoryNumber(inventoryEntrance.getInventoryNumber());

				inventoryEntranceDto.setQuantity(inventoryEntrance.getQuantity());
				inventoryEntranceDto.setAvailableQuantity(inventoryEntrance.getAvailableQuantity());
				inventoryEntranceDto.setManufacturerName(inventoryEntrance.getManufacturerName());
				inventoryEntranceDto.setSupplierName(inventoryEntrance.getSupplierName());
				inventoryEntranceDto.setIsWarrantyPeriodApplicable(inventoryEntrance.getIsWarrantyApplicable());
				inventoryEntranceDto.setLocation(inventoryEntrance.getLocation());
				inventoryEntranceDto.setMakeName(inventoryEntrance.getMakeName());
				inventoryEntranceDto.setModelName(inventoryEntrance.getModelName());
				inventoryEntranceDto.setVehicleNumber(inventoryEntrance.getVehicleNumber());
				inventoryEntranceDto.setYear(inventoryEntrance.getYear());
				inventoryEntranceDto.setMonth(inventoryEntrance.getMonth());

				if (inventoryEntrance.getCreationDate() != null) {

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

					// inventoryEntranceDto.setCreationDate(
					// MasterDateUtil.convertDateToStringWithTime(inventoryEntrance.getCreationDate()));

					inventoryEntranceDto.setCreationDate(dateFormat.format(inventoryEntrance.getCreationDate()));

				}

				/*
				 * if(inventoryEntrance.getInventoryAssignItem()!=null){
				 * inventoryEntranceDto.setCreationDate(MasterDateUtil.
				 * convertDateToStringWithTime(inventoryEntrance.
				 * getInventoryAssignItem().get(0).getCreationDate())); }
				 */

				inventoryEntranceDto.setIsServicePeriodApplicable(inventoryEntrance.getIsServiceApplicable());
				if (inventoryEntrance.getServiceDueMonth() != null) {
					inventoryEntranceDto.setServiceDueDate(inventoryEntrance.getServiceDueMonth());
				}

				if (inventoryEntrance.getWareHouseBlock() != null) {
					inventoryEntranceDto.setWareHouseBlockName(inventoryEntrance.getWareHouseBlock().getBlocksNames());
				}
				if (inventoryEntrance.getWarrantyExpiryDate() != null) {
					inventoryEntranceDto.setWarrantyPeriod(
							MasterDateUtil.convertDateToString(inventoryEntrance.getWarrantyExpiryDate()));
				}
				if (inventoryEntrance.getPurchaseDate() != null) {
					inventoryEntranceDto
							.setPurchaseDate(MasterDateUtil.convertDateToString(inventoryEntrance.getPurchaseDate()));
				}
				if (inventoryEntrance.getPurchaseTotalCost() != null) {
					inventoryEntranceDto.setPurchaseCost(String.valueOf(inventoryEntrance.getPurchaseTotalCost()));
				}
				if (inventoryEntrance.getInventoryAssignItem().size() > 0) {

					for (InventoryAssign inventoryAssign : inventoryEntrance.getInventoryAssignItem()) {

						InventoryAssignDto assignDto = new InventoryAssignDto();
						assignDto.setAssignedLocation(inventoryAssign.getAssignedLocation());
						assignDto.setAvailableQty(inventoryAssign.getAvailableQty());
						inventoryassignDtoList.add(assignDto);
					}
					inventoryEntranceDto.setInventoryassignDtoList(inventoryassignDtoList);
					inventoryEntranceDto.setButton(InventoryConstant.VIEW_BUTTON);
				} else {
					inventoryEntranceDto.setButton(InventoryConstant.EDIT);
				}
				inventoryEntranceDto.setSite(inventoryEntrance.getWareHouseSiteName());
				SubCategory subCategory = inventoryEntrance.getSubCategory();
				if (subCategory != null) {
					inventoryEntranceDto.setModelCode(subCategory.getModel());
					inventoryEntranceDto.setSubCategory(subCategory.getSubCategory());
				}
				Type type = inventoryEntrance.getType();
				if (type != null) {
					inventoryEntranceDto.setType(type.getType());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------mapInventoryDto--------------------Ended-->");
		return inventoryEntranceDto;
	}

	@Override
	public String saveInventoryManagement(InventoryEntranceDto inventoryEntranceDto, Principal principal)
			throws Exception {
		String status = InventoryConstant.FAILURE;

		logger.info(
				"<--InventoryManagementServiceImpl-------------saveInventoryManagement--------------------started-->");
		if (inventoryEntranceDto != null) {
			InventoryEntrance inventoryEntrance = null;
			
			Category category = categoryRepository.findByCategoryType(inventoryEntranceDto.getCategoryType());
			if (category.getAssetTracking().equals(InventoryConstant.INDIVIDUAL_TRACKING)) {

				Notifications notifications = new Notifications();
				
				for (int i = 0; i < inventoryEntranceDto.getQuantity(); i++) {
					inventoryEntrance = new InventoryEntrance();
					if (category != null) {
						inventoryEntrance.setCategory(category);
					}

					Type type = typeRepository.findByType(inventoryEntranceDto.getType());
					if (type != null) {
						inventoryEntrance.setType(type);
					} else {
						throw new Exception(InventoryConstant.THIS_TYPE_DOESNOT_EXISTS);
					}

					SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(
							inventoryEntranceDto.getSubCategory(), InventoryConstant.ACTIVE);
					if (subCategory != null) {
						inventoryEntrance.setSubCategory(subCategory);
						inventoryEntrance.setSubCategoryName(subCategory.getSubCategory());
						inventoryEntrance.setModelcode(subCategory.getModel());
					}
					Manufacturer manufacturer = manufacturerRepository
							.findByName(inventoryEntranceDto.getManufacturerName());
					if (manufacturer != null) {
						inventoryEntrance.setManufacturerName(inventoryEntranceDto.getManufacturerName());
						inventoryEntrance.setManufacturer(manufacturer);
					}
					Supplier supplier = supplierMasterRespository
							.findOne(Long.parseLong(inventoryEntranceDto.getSupplierName()));
					if (supplier != null) {
						inventoryEntrance.setSupplierName(inventoryEntranceDto.getSupplierName());
						inventoryEntrance.setSupplier(supplier);

					}
					if (inventoryEntranceDto.getWareHouseBlockName() != null) {
						WareHouseBlocks wareHouseBlocks = wareHouseBlockRepository
								.findByBlocksNames(inventoryEntranceDto.getWareHouseBlockName());
						if (wareHouseBlocks != null) {
							inventoryEntrance.setWareHouseBlock(wareHouseBlocks);
						} else {
							throw new Exception(InventoryConstant.THIS_WAREHOUSE_BLOCK_NAME_DOESNOT_EXISTS);
						}
					}

					inventoryEntrance.setAssetTracking(InventoryConstant.INDIVIDUAL_TRACKING);
					inventoryEntrance.setIsWarrantyApplicable(inventoryEntranceDto.getIsWarrantyPeriodApplicable());
					inventoryEntrance.setCreated_By(principal.getName());
					inventoryEntrance.setCreationDate(new Date());
					inventoryEntrance.setInventoryNumber(getInventoryNumber());
					inventoryEntrance.setLastModifiedBy(principal.getName());
					inventoryEntrance.setLastModifiedDate(new Date());
					inventoryEntrance.setLocation(InventoryConstant.WAREHOUSE);
					inventoryEntrance.setQuantity(1);
					inventoryEntrance.setAvailableQuantity(1);
					inventoryEntrance.setSupplierName(inventoryEntranceDto.getSupplierName());
					// inventoryEntrance.setPurchaseQuantity();
					// inventoryEntrance.setWarrantyExpiryDate(MasterDateUtil.convertDateToString(inventoryEntranceDto.getWarrantyPeriod()));
					inventoryEntrance.setPurchaseDate(
							MasterDateUtil.convertDateToString(inventoryEntranceDto.getPurchaseDate()));
					inventoryEntrance.setManufacturerName(inventoryEntranceDto.getManufacturerName());
					inventoryEntrance.setYear(inventoryEntranceDto.getYear());
					inventoryEntrance.setMonth(inventoryEntranceDto.getMonth());
					inventoryEntrance.setIsServiceApplicable(inventoryEntranceDto.getIsServicePeriodApplicable());
					inventoryEntrance.setServiceDueMonth(inventoryEntranceDto.getServiceDueDate());
					if (inventoryEntranceDto.getPurchaseCost() != null) {
						inventoryEntrance.setPurchaseTotalCost(Double.valueOf(inventoryEntranceDto.getPurchaseCost()));
					}
					WareHouse wareHouse = wareHouseRepository.findByWareHouseName(inventoryEntranceDto.getSite());
					if (wareHouse != null) {
						inventoryEntrance.setWareHouseSiteName(inventoryEntranceDto.getSite());
					} else {
						throw new Exception(InventoryConstant.THIS_WAREHOUSE_NAME_DOESNOT_EXISTS);
					}

					if (inventoryEntranceDto.getYear() != null && inventoryEntranceDto.getMonth() != null) {
						inventoryEntrance.setWarrantyExpiryDate(MasterDateUtil.convertCalendarToDate(MasterDateUtil
								.caculateWarranty(inventoryEntranceDto.getYear(), inventoryEntranceDto.getMonth())));
					}
					inventoryEntrance.setMakeName(inventoryEntranceDto.getMakeName());
					inventoryEntrance.setModelName(inventoryEntranceDto.getModelName());
					inventoryEntrance.setVehicleNumber(inventoryEntranceDto.getVehicleNumber());
					inventoryEntrance.setServiceDueMonth(inventoryEntranceDto.getServiceDueDate());
					if (inventoryEntranceDto.getServiceDueDate() != null
							&& inventoryEntranceDto.getPurchaseDate() != null) {
						// inventoryEntrance.setServiceDueDate(MasterDateUtil.convertDateToString(inventoryEntranceDto.getServiceDueDate()));
						inventoryEntrance.setServiceDueDate(
								MasterDateUtil.convertCalendarToDate(MasterDateUtil.caculateServiceDueDate(
										MasterDateUtil.convertFromStringToDate(inventoryEntranceDto.getPurchaseDate()),
										(MasterDateUtil
												.ConvertStringtoInteger(inventoryEntranceDto.getServiceDueDate())))));
					}
					inventoryEntrance = inventoryStockRepository.save(inventoryEntrance);
					if (inventoryEntrance != null) {
						status = InventoryConstant.SUCCESS;
					}
				}

				notifications.setQuantity(inventoryEntranceDto.getQuantity());
				notifications.setRequestedFrom(principal.getName());
				notifications.setRequestedTo(inventoryEntranceDto.getSite());
				notifications.setNotificationStatus(InventoryConstant.NEW);
				notifications.setCreationDate(new Date());
				notifications.setNotificationLink(InventoryConstant.INVENTORYMANAGEMENT);
				notifications.setCategory(category);
				notifications.setStatus(InventoryConstant.RECEIVED);
				notifications.setUserName(InventoryConstant.WAREHOUSE);
				
				notificationsRepository.save(notifications);

			} else {
				if (category != null) {
					inventoryEntrance = new InventoryEntrance();
					inventoryEntrance.setCategory(category);
				}
				SubCategory subCategory = subCategoryRepository
						.findBySubCategoryAndStatus(inventoryEntranceDto.getSubCategory(), InventoryConstant.ACTIVE);
				if (subCategory != null) {
					inventoryEntrance.setSubCategory(subCategory);
					inventoryEntrance.setSubCategoryName(subCategory.getSubCategory());
					inventoryEntrance.setModelcode(subCategory.getModel());
				}
				Manufacturer manufacturer = manufacturerRepository
						.findByName(inventoryEntranceDto.getManufacturerName());
				if (manufacturer != null) {
					inventoryEntrance.setManufacturerName(inventoryEntranceDto.getManufacturerName());
					inventoryEntrance.setManufacturer(manufacturer);
				}
				Supplier supplier = supplierMasterRespository
						.findOne(Long.parseLong((inventoryEntranceDto.getSupplierName())));
				if (supplier != null) {
					inventoryEntrance.setSupplierName(inventoryEntranceDto.getSupplierName());
					inventoryEntrance.setSupplier(supplier);

				}
				if (inventoryEntranceDto.getWareHouseBlockName() != null) {
					WareHouseBlocks wareHouseBlocks = wareHouseBlockRepository
							.findByBlocksNames(inventoryEntranceDto.getWareHouseBlockName());
					if (wareHouseBlocks != null) {
						inventoryEntrance.setWareHouseBlock(wareHouseBlocks);
					} else {
						throw new Exception(InventoryConstant.THIS_WAREHOUSE_BLOCK_NAME_DOESNOT_EXISTS);
					}

				}
				if (inventoryEntranceDto.getType() != null) {
					Type type = typeRepository.findByType(inventoryEntranceDto.getType());
					if (type != null) {
						inventoryEntrance.setType(type);
					} else {
						throw new Exception(InventoryConstant.THIS_TYPE_DOESNOT_EXISTS);
					}
				}
				inventoryEntrance.setAssetTracking(InventoryConstant.QTY_TRACKING);
				inventoryEntrance.setIsWarrantyApplicable(inventoryEntranceDto.getIsWarrantyPeriodApplicable());
				inventoryEntrance.setCreated_By(principal.getName());
				inventoryEntrance.setCreationDate(new Date());
				inventoryEntrance.setInventoryNumber(getInventoryNumber());
				inventoryEntrance.setLastModifiedBy(principal.getName());
				inventoryEntrance.setLastModifiedDate(new Date());
				inventoryEntrance.setLocation(InventoryConstant.WAREHOUSE);
				inventoryEntrance.setQuantity(inventoryEntranceDto.getQuantity());
				inventoryEntrance.setAvailableQuantity(inventoryEntranceDto.getQuantity());
				inventoryEntrance.setPurchaseQuantity(inventoryEntranceDto.getQuantity());
				inventoryEntrance.setSupplierName(inventoryEntranceDto.getSupplierName());
				// inventoryEntrance.setWarrantyExpiryDate(MasterDateUtil.convertDateToString(inventoryEntranceDto.getWarrantyPeriod()));
				inventoryEntrance
						.setPurchaseDate(MasterDateUtil.convertDateToString(inventoryEntranceDto.getPurchaseDate()));
				inventoryEntrance.setManufacturerName(inventoryEntranceDto.getManufacturerName());
				inventoryEntrance.setYear(inventoryEntranceDto.getYear());
				inventoryEntrance.setMonth(inventoryEntranceDto.getMonth());
				if (inventoryEntranceDto.getPurchaseCost() != null) {
					inventoryEntrance.setPurchaseTotalCost(Double.valueOf(inventoryEntranceDto.getPurchaseCost()));
				}
				WareHouse wareHouse = wareHouseRepository.findByWareHouseName(inventoryEntranceDto.getSite());
				if (wareHouse != null) {
					inventoryEntrance.setWareHouseSiteName(inventoryEntranceDto.getSite());
				} else {
					throw new Exception(InventoryConstant.THIS_WAREHOUSE_NAME_DOESNOT_EXISTS);
				}
				if (inventoryEntranceDto.getYear() != null && inventoryEntranceDto.getMonth() != null) {
					inventoryEntrance.setWarrantyExpiryDate(MasterDateUtil.convertCalendarToDate(MasterDateUtil
							.caculateWarranty(inventoryEntranceDto.getYear(), inventoryEntranceDto.getMonth())));
				}
				inventoryEntrance.setMakeName(inventoryEntranceDto.getMakeName());
				inventoryEntrance.setModelName(inventoryEntranceDto.getModelName());
				inventoryEntrance.setVehicleNumber(inventoryEntranceDto.getVehicleNumber());
				inventoryEntrance.setIsServiceApplicable(inventoryEntranceDto.getIsServicePeriodApplicable());
				inventoryEntrance.setServiceDueMonth(inventoryEntranceDto.getServiceDueDate());
				/*
				 * if(inventoryEntranceDto.getServiceDueDate()!=null) {
				 * inventoryEntrance.setServiceDueDate(MasterDateUtil.
				 * convertDateToString(inventoryEntranceDto.getServiceDueDate())
				 * ); }
				 */
				if (inventoryEntranceDto.getServiceDueDate() != null
						&& inventoryEntranceDto.getPurchaseDate() != null) {
					inventoryEntrance.setServiceDueDate(
							MasterDateUtil.convertCalendarToDate(MasterDateUtil.caculateServiceDueDate(
									MasterDateUtil.convertFromStringToDate(inventoryEntranceDto.getPurchaseDate()),
									(MasterDateUtil
											.ConvertStringtoInteger(inventoryEntranceDto.getServiceDueDate())))));
				}
				inventoryEntrance = inventoryStockRepository.save(inventoryEntrance);
				if (inventoryEntrance != null) {
					status = InventoryConstant.SUCCESS;
				}
			}
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------saveInventoryManagement--------------------Ended-->");
		return status;
	}

	/*
	 * @Override public String
	 * assignInventoryStockToProject(InventoryEntranceDto
	 * inventoryEntranceDto,Principal principal) { String
	 * status=InventoryConstant.FAILURE; try { logger.info(
	 * "<--InventoryManagementServiceImpl-------------assignInventoryStockToProject--------------------started-->"
	 * );
	 * 
	 * if(inventoryEntranceDto.getId()!=null) { InventoryEntrance
	 * inventoryEntrance=inventoryStockRepository.findOne(inventoryEntranceDto.
	 * getId());
	 * 
	 * if(inventoryEntrance!=null &&
	 * inventoryEntranceDto.getLocation().equals(InventoryConstant.PROJECTSITE))
	 * { Integer remaining=inventoryEntrance.getQuantity()-inventoryEntranceDto.
	 * getAllocatableQuantity(); inventoryEntrance.setQuantity(remaining);
	 * inventoryEntrance=inventoryStockRepository.save(inventoryEntrance);
	 * if(inventoryEntrance!=null) { InventoryAssign inventoryAssign=new
	 * InventoryAssign();
	 * 
	 * inventoryAssign.setAllocatedQty(inventoryEntranceDto.
	 * getAllocatableQuantity());
	 * inventoryAssign.setAssignedLocation(inventoryEntranceDto.
	 * getProjectItemDto().get(0).getName()); Category
	 * category=categoryRepository.findByCategoryTypeAndStatus(
	 * inventoryEntranceDto.getCategoryType(), InventoryConstant.ACTIVE);
	 * if(category!=null) { inventoryAssign.setCategory(category); } SubCategory
	 * subCategory=subCategoryRepository.findBySubCategoryAndStatus(
	 * inventoryEntranceDto.getSubCategory(), InventoryConstant.ACTIVE);
	 * if(subCategory!=null) { inventoryAssign.setSubCategory(subCategory); }
	 * inventoryAssign.setCreatedBy(principal.getName());
	 * inventoryAssign.setCreationDate(new Date());
	 * inventoryAssign.setInperson(principal.getName());
	 * inventoryAssign.setInventoryEntrance(inventoryEntrance);
	 * inventoryAssign.setInventoryLocation(inventoryEntranceDto.getLocation());
	 * inventoryAssign.setInventoryNumber(inventoryEntrance.getInventoryNumber()
	 * ); inventoryAssign.setLastModifiedBy(principal.getName());
	 * inventoryAssign.setLastModifiedDate(new Date());
	 * inventoryAssign.setLeftoverQty(inventoryEntranceDto.
	 * getAllocatableQuantity());
	 * inventoryAssign.setModelCode(inventoryEntranceDto.getModelCode());
	 * inventoryAssign.setAvailableQty(inventoryEntranceDto.
	 * getAllocatableQuantity());
	 * inventoryAssign.setSubCategoryName(inventoryEntranceDto.getSubCategory())
	 * ; inventoryAssign.setWareHouseSiteName(inventoryEntranceDto.getSite());
	 * inventoryAssign=inventoryAssignRepository.save(inventoryAssign);
	 * if(inventoryAssign!=null) { status=InventoryConstant.SUCCESS; } } } else
	 * if(inventoryEntrance!=null &&
	 * inventoryEntranceDto.getLocation().equals(InventoryConstant.WAREHOUSE)) {
	 * Integer remaining=inventoryEntrance.getQuantity()-inventoryEntranceDto.
	 * getAllocatableQuantity(); inventoryEntrance.setQuantity(remaining);
	 * inventoryEntrance=inventoryStockRepository.save(inventoryEntrance);
	 * if(inventoryEntrance!=null) { InventoryAssign inventoryAssign=new
	 * InventoryAssign();
	 * inventoryAssign.setAssignedLocation(inventoryEntranceDto.getWareHouseDto(
	 * ).get(0).getWareHouseName());
	 * inventoryAssign.setAllocatedQty(inventoryEntranceDto.
	 * getAllocatableQuantity()); Category
	 * category=categoryRepository.findByCategoryTypeAndStatus(
	 * inventoryEntranceDto.getCategoryType(), InventoryConstant.ACTIVE);
	 * if(category!=null) { inventoryAssign.setCategory(category); } SubCategory
	 * subCategory=subCategoryRepository.findBySubCategoryAndStatus(
	 * inventoryEntranceDto.getSubCategory(), InventoryConstant.ACTIVE);
	 * if(subCategory!=null) { inventoryAssign.setSubCategory(subCategory); }
	 * inventoryAssign.setCreatedBy(principal.getName());
	 * inventoryAssign.setCreationDate(new Date());
	 * inventoryAssign.setInperson(principal.getName());
	 * inventoryAssign.setInventoryEntrance(inventoryEntrance);
	 * inventoryAssign.setInventoryLocation(inventoryEntranceDto.getLocation());
	 * inventoryAssign.setInventoryNumber(inventoryEntrance.getInventoryNumber()
	 * ); inventoryAssign.setLastModifiedBy(principal.getName());
	 * inventoryAssign.setLastModifiedDate(new Date());
	 * inventoryAssign.setLeftoverQty(inventoryEntranceDto.
	 * getAllocatableQuantity());
	 * inventoryAssign.setModelCode(inventoryEntranceDto.getModelCode());
	 * inventoryAssign.setAvailableQty(inventoryEntranceDto.
	 * getAllocatableQuantity());
	 * inventoryAssign.setSubCategoryName(inventoryEntranceDto.getSubCategory())
	 * ; inventoryAssign.setWareHouseSiteName(inventoryEntranceDto.getSite());
	 * inventoryAssign=inventoryAssignRepository.save(inventoryAssign);
	 * if(inventoryAssign!=null) { status=InventoryConstant.SUCCESS; } } }
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } logger.info(
	 * "<--InventoryManagementServiceImpl-------------assignInventoryStockToProject--------------------started-->"
	 * ); return status; }
	 */

	@Override
	public String assignInventoryStockToProject(InventoryEntranceDto inventoryEntranceDto, Principal principal) {
		String status = InventoryConstant.FAILURE;
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------assignInventoryStockToProject--------------------started-->");

			if (inventoryEntranceDto.getId() != null) {
				InventoryEntrance inventoryEntrance = inventoryStockRepository.findOne(inventoryEntranceDto.getId());
				if (inventoryEntrance != null
						&& inventoryEntranceDto.getLocation().equals(InventoryConstant.WAREHOUSE)) {
					Integer remaining = inventoryEntrance.getQuantity() - inventoryEntranceDto.getAllocatableQuantity();
					inventoryEntrance.setQuantity(remaining);
					inventoryEntrance = inventoryStockRepository.save(inventoryEntrance);
					if (inventoryEntrance != null) {
						InventoryAssign inventoryAssign = new InventoryAssign();
						inventoryAssign.setAssignedLocation(inventoryEntranceDto.getProjectItemDto().get(0).getName());
						inventoryAssign.setAllocatedQty(inventoryEntranceDto.getAllocatableQuantity());
						Category category = categoryRepository.findByCategoryTypeAndStatus(
								inventoryEntranceDto.getCategoryType(), InventoryConstant.ACTIVE);
						if (category != null) {
							inventoryAssign.setCategory(category);
						}
						SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(
								inventoryEntranceDto.getSubCategory(), InventoryConstant.ACTIVE);
						if (subCategory != null) {
							inventoryAssign.setSubCategory(subCategory);
						}
						inventoryAssign.setCreatedBy(principal.getName());
						inventoryAssign.setCreationDate(new Date());
						inventoryAssign.setInperson(principal.getName());
						inventoryAssign.setInventoryEntrance(inventoryEntrance);
						inventoryAssign.setInventoryLocation(InventoryConstant.PROJECTSITE);
						inventoryAssign.setInventoryNumber(inventoryEntrance.getInventoryNumber());
						inventoryAssign.setLastModifiedBy(principal.getName());
						inventoryAssign.setLastModifiedDate(new Date());
						inventoryAssign.setLeftoverQty(inventoryEntranceDto.getAllocatableQuantity());
						inventoryAssign.setModelCode(inventoryEntranceDto.getModelCode());
						inventoryAssign.setAvailableQty(inventoryEntranceDto.getAllocatableQuantity());
						inventoryAssign.setSubCategoryName(inventoryEntranceDto.getSubCategory());
						inventoryAssign.setWareHouseSiteName(inventoryEntranceDto.getSite());
						inventoryAssign = inventoryAssignRepository.save(inventoryAssign);
						if (inventoryAssign != null) {
							status = InventoryConstant.SUCCESS;
						}
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------assignInventoryStockToProject--------------------started-->");
		return status;
	}

	@Override
	public String getInventoryNumber() {
		String inventoryNo = null;
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryNumber--------------------started-->");
		inventoryNo = jdbcTemplate.queryForObject("call inventory_number_seq()", String.class);
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryNumber--------------------ended-->");
		return inventoryNo;
	}

	@Override
	public InventoryEntranceDto getInventoryById(String id, Principal principal) {

		InventoryEntranceDto inventoryEntranceDto = null;
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryById--------------------started-->");
		try {

			if (id != null) {
				InventoryEntrance inventoryEntrance = inventoryStockRepository.findOne(Long.valueOf(id));
				inventoryEntranceDto = mapInventoryDtoById(inventoryEntrance);
				inventoryEntranceDto.setProjectItemDto(getCurrentUserProjectDtoList(principal));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryById--------------------Ended-->");
		return inventoryEntranceDto;
	}

	@Override
	public InventoryEntranceDto getInventoryFromAssignById(String id, Principal principal) {

		InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryById--------------------started-->");
		try {
			if (id != null) {
				InventoryAssign inventoryAssign = inventoryAssignRepository.findOne(Long.valueOf(id));
				inventoryEntranceDto = mapInventoryAssignDtoForRequestTools(inventoryAssign);
			}
			inventoryEntranceDto.setProjectItemDto(getCurrentUserProjectDtoList(principal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryById--------------------Ended-->");
		return inventoryEntranceDto;
	}

	@Override
	public InventoryEntranceDto mapInventoryDtoById(InventoryEntrance inventoryEntrance) {
		InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------mapInventoryDtoById--------------------started-->");
			inventoryEntranceDto.setId(inventoryEntrance.getId());
			Category category = inventoryEntrance.getCategory();
			if (category != null) {
				inventoryEntranceDto.setCategoryType(category.getCategoryType());
			}
			SubCategory subCategory = inventoryEntrance.getSubCategory();
			if (subCategory != null) {
				inventoryEntranceDto.setSubCategory(subCategory.getSubCategory());
				inventoryEntranceDto.setModelCode(subCategory.getModel());
			}
			inventoryEntranceDto.setSupplierName(inventoryEntrance.getSupplierName());
			inventoryEntranceDto.setManufacturerName(inventoryEntrance.getManufacturerName());
			inventoryEntranceDto.setQuantity(inventoryEntrance.getAvailableQuantity());
			inventoryEntranceDto.setInventoryNumber(inventoryEntrance.getInventoryNumber());
			if (inventoryEntrance.getPurchaseTotalCost() != null) {
				inventoryEntranceDto.setPurchaseCost(String.valueOf((inventoryEntrance.getPurchaseTotalCost())));
			}
			if (inventoryEntrance.getPurchaseDate() != null) {
				inventoryEntranceDto
						.setPurchaseDate(MasterDateUtil.convertDateToString(inventoryEntrance.getPurchaseDate()));
			}
			if (inventoryEntrance.getWarrantyExpiryDate() != null) {
				inventoryEntranceDto.setWarrantyPeriod(
						MasterDateUtil.convertDateToString(inventoryEntrance.getWarrantyExpiryDate()));
			}
			inventoryEntranceDto.setLocation(inventoryEntrance.getLocation());
			inventoryEntranceDto.setIsWarrantyPeriodApplicable(inventoryEntrance.getIsWarrantyApplicable());
			inventoryEntranceDto.setSite(inventoryEntrance.getWareHouseSiteName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------mapInventoryDtoById--------------------Ended-->");
		return inventoryEntranceDto;
	}

	@Override
	public List<InventoryEntranceDto> findtools(FindToolsDto findToolsDto, Principal principal) {

		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			boolean hasUserRole1 = authentication.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals(InventoryConstant.USER)
							|| r.getAuthority().equals(InventoryConstant.SUPER_USER));
			{
				if (hasUserRole1) {

					List<Project> projectEntityList = null;
					List<ProjectDto> projectDtoList = null;
					List<String> projectName = new ArrayList<>();

					if (principal.getName() != null) {
						User user = userRepository.findByUserName(principal.getName());
						if (user.getProjectItem() != null && !user.getProjectItem().isEmpty()) {
							projectEntityList = user.getProjectItem();
							if (projectEntityList != null) {
								projectDtoList = new ArrayList<>();

								for (int k = 0; k < projectEntityList.size(); k++) {
									Project project = user.getProjectItem().get(k);
									if (project != null) {
										/*
										 * projectName+="'"+project.getName()+
										 * "'"+",";
										 */
										projectName.add(project.getName());
									}
								}
								/*
								 * projectName = projectName.replaceAll(",$",
								 * "");
								 */

								System.out.println(projectName);

								List<Object> inventoryEntrancesList = inventoryStockRepository
										.findtools(findToolsDto.getSearchKeyword(), projectName);
								System.out.println(inventoryEntrancesList);
								if (inventoryEntrancesList != null && !inventoryEntrancesList.isEmpty()) {
									inventoryEntranceDtoList = new ArrayList<>();

									for (int i = 0; i < inventoryEntrancesList.size(); i++) {

										Object object = inventoryEntrancesList.get(i);

										if (object != null) {
											Object[] objectArray = (Object[]) object;
											Integer value = (Integer) objectArray[4];
											if (value > 0) {

												InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
												inventoryEntranceDto.setId(Long.valueOf(objectArray[0].toString()));
												inventoryEntranceDto.setCategoryType(objectArray[1].toString());
												inventoryEntranceDto.setSubCategory(objectArray[2].toString());
												inventoryEntranceDto.setModelCode(objectArray[3].toString());
												inventoryEntranceDto
														.setQuantity(Integer.valueOf(objectArray[4].toString()));
												inventoryEntranceDto.setLocation(objectArray[5].toString());
												inventoryEntranceDto.setSite(objectArray[6].toString());
												inventoryEntranceDtoList.add(inventoryEntranceDto);
											}

										}
									}
								}
							}
						}
					}

				}

			}

			Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
			boolean hasUserRole2 = authentication1.getAuthorities().stream()
					.anyMatch(r -> r.getAuthority().equals(InventoryConstant.OFFICE_ADMINISTRATOR));
			{
				if (hasUserRole2) {
					List<Object> inventoryEntrancesList = inventoryStockRepository
							.findtools(findToolsDto.getSearchKeyword());
					System.out.println(inventoryEntrancesList);
					if (inventoryEntrancesList != null && !inventoryEntrancesList.isEmpty()) {
						inventoryEntranceDtoList = new ArrayList<>();

						for (int i = 0; i < inventoryEntrancesList.size(); i++) {
							Object object = inventoryEntrancesList.get(i);
							if (object != null) {
								Object[] objectArray = (Object[]) object;
								Integer value = (Integer) objectArray[4];
								if (value > 0) {

									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									inventoryEntranceDto.setId(Long.valueOf(objectArray[0].toString()));
									inventoryEntranceDto.setCategoryType(objectArray[1].toString());
									inventoryEntranceDto.setSubCategory(objectArray[2].toString());
									inventoryEntranceDto.setModelCode(objectArray[3].toString());
									inventoryEntranceDto.setQuantity(Integer.valueOf(objectArray[4].toString()));
									inventoryEntranceDto.setLocation(objectArray[5].toString());
									inventoryEntranceDto.setSite(objectArray[6].toString());
									inventoryEntranceDtoList.add(inventoryEntranceDto);
								}

							}
						}
					}
				}

				logger.info(
						"<--InventoryManagementServiceImpl-------------getInventoryCountForOfficeAdministratorFromStock--------------------started-->");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryEntranceDtoList;
	}

	private InventoryEntranceDto mapInventoryAssignDtoForRequestTools(InventoryAssign inventoryAssign) {

		InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------mapInventoryAssignDto--------------------started-->");
			inventoryEntranceDto.setId(inventoryAssign.getId());
			inventoryEntranceDto.setCategoryType(inventoryAssign.getCategory().getCategoryType());
			inventoryEntranceDto.setSubCategory(inventoryAssign.getSubCategory().getSubCategory());
			inventoryEntranceDto.setModelCode(inventoryAssign.getSubCategory().getModel());
			inventoryEntranceDto.setQuantity(inventoryAssign.getAvailableQty());
			inventoryEntranceDto.setInventoryNumber(inventoryAssign.getInventoryEntrance().getInventoryNumber());
			inventoryEntranceDto.setLocation(inventoryAssign.getInventoryLocation());
			inventoryEntranceDto.setSite(inventoryAssign.getAssignedLocation());

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------mapInventoryAssignDto--------------------Ended-->");
		return inventoryEntranceDto;
	}

	@Override
	public InventoryAssignDto getInventoryAssignById(String id, Principal principal) {
		InventoryAssignDto inventoryAssignDto = null;
		logger.info(
				"<--InventoryManagementServiceImpl-------------getInventoryAssignById--------------------started-->");
		try {

			if (id != null) {
				InventoryAssign inventoryAssign = inventoryAssignRepository.findOne(Long.valueOf(id));
				if (inventoryAssign != null) {
					inventoryAssignDto = mapInventoryAssignDtoById(inventoryAssign);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryAssignById--------------------Ended-->");
		return inventoryAssignDto;
	}

	private InventoryAssignDto mapInventoryAssignDtoById(InventoryAssign inventoryAssign) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapInventoryAssignDtoById--------------------Ended-->");
		InventoryAssignDto inventoryAssignDto = new InventoryAssignDto();
		inventoryAssignDto.setId(inventoryAssign.getId());
		SubCategory subCategory = inventoryAssign.getSubCategory();
		if (subCategory != null) {
			inventoryAssignDto.setSubCategory(subCategory.getSubCategory());
		}
		Category category = inventoryAssign.getCategory();
		if (category != null) {
			inventoryAssignDto.setCategory(category.getCategoryType());
		}
		inventoryAssignDto.setAvailableQty(inventoryAssign.getAvailableQty());
		inventoryAssignDto.setModelCode(inventoryAssign.getModelCode());
		inventoryAssignDto.setWarehouseOrSitename(inventoryAssign.getWareHouseSiteName());
		inventoryAssignDto.setAssignedLocation(inventoryAssign.getAssignedLocation());
		inventoryAssignDto.setInventoryLocation(inventoryAssign.getInventoryLocation());
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapInventoryAssignDtoById--------------------Ended-->");
		return inventoryAssignDto;
	}

	@Override
	public List<ProjectDto> getCurrentUserProjectDtoList(Principal principal) {
		List<ProjectDto> projectDtoList = null;
		List<Project> projectEntityList = null;
		if (principal.getName() != null) {
			User user = userRepository.findByUserName(principal.getName());
			if (user.getProjectItem() != null) {
				projectEntityList = user.getProjectItem();
				if (projectEntityList != null) {
					projectDtoList = new ArrayList<>();
					for (int k = 0; k < projectEntityList.size(); k++) {
						Project project = user.getProjectItem().get(k);
						if (project != null) {
							ProjectDto projectDto = new ProjectDto();
							projectDto.setName(project.getName());
							projectDtoList.add(projectDto);
						}
					}
				}
			}
		}
		return projectDtoList;
	}

	@Override
	public List<ProjectDto> getCurrentUserNonClosedProjectDtoList(Principal principal) {
		List<ProjectDto> projectDtoList = null;
		List<Project> projectEntityList = null;
		if (principal.getName() != null) {
			User user = userRepository.findByUserName(principal.getName());
			if (user.getProjectItem() != null) {
				projectEntityList = user.getProjectItem();
				if (projectEntityList != null) {
					projectDtoList = new ArrayList<>();
					for (int k = 0; k < projectEntityList.size(); k++) {
						Project project = user.getProjectItem().get(k);
						if (project.getStatus() != null && !project.getStatus().equalsIgnoreCase("CLOSED")) {
							ProjectDto projectDto = new ProjectDto();

							projectDto.setName(project.getName());

							projectDtoList.add(projectDto);

						}
					}
				}
			}
		}
		return projectDtoList;
	}

	@Override
	public List<UserDto> getAssignedUsersListForTheProject(InventoryRequestDto inventoryRequestDto,
			Principal principal) {
		List<UserDto> userDtoList = null;
		List<User> userEntityList = null;
		if (inventoryRequestDto.getRequestedFrom() != null) {
			Project project = projectRepository.findByName(inventoryRequestDto.getRequestedFrom());
			if (project.getUser() != null) {
				userEntityList = project.getUser();
				if (userEntityList != null) {
					userDtoList = new ArrayList<>();
					for (int k = 0; k < userEntityList.size(); k++) {
						User user = project.getUser().get(k);
						if (user != null) {
							UserDto userDto = new UserDto();
							userDto.setName(user.getName());

							userDto.setMobileNumber(String.valueOf(user.getEmployee().getMobileNumber()));
							userDtoList.add(userDto);
						}
					}
				}
			}
		}

		return userDtoList;
	}

	@Override
	public List<InventoryAssign> saveInventoryAssignManagement(InventoryEntrance inventoryEntrance,
			InventoryEntranceDto inventoryEntranceDto, Principal principal) {
		List<InventoryAssign> inventoryAssignList = new ArrayList<>();
		InventoryAssign inventoryAssign = null;
		logger.info(
				"<--InventoryManagementServiceImpl-------------saveInventoryAssignManagement--------------------started-->");
		try {
			inventoryAssign = new InventoryAssign();
			inventoryAssign = mapInventoryAssignEntity(inventoryAssign, inventoryEntranceDto, principal);
			Category category = categoryRepository.findByCategoryTypeAndStatus(inventoryEntranceDto.getCategoryType(),
					InventoryConstant.ACTIVE);
			if (category != null) {
				inventoryAssign.setCategory(category);
			}
			SubCategory subCategory = subCategoryRepository
					.findBySubCategoryAndStatus(inventoryEntranceDto.getSubCategory(), InventoryConstant.ACTIVE);// unique
																													// result
																													// problem
																													// may
			if (subCategory != null) {
				inventoryAssign.setSubCategoryName(subCategory.getSubCategory());
				inventoryAssign.setSubCategory(subCategory);

			}
			inventoryAssign.setInventoryNumber(inventoryEntrance.getInventoryNumber());
			inventoryAssign.setAssignedLocation(inventoryEntrance.getWareHouseSiteName());
			inventoryEntrance.setQuantity(inventoryAssign.getAvailableQty());
			inventoryAssign.setWareHouseSiteName(inventoryAssign.getWareHouseSiteName());
			inventoryAssign.setInventoryLocation(inventoryEntrance.getLocation());
			inventoryAssignList.add(inventoryAssign);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------saveInventoryAssignManagement--------------------Ended-->");
		return inventoryAssignList;
	}

	public InventoryAssign mapInventoryAssignEntity(InventoryAssign inventoryAssign,
			InventoryEntranceDto inventoryEntranceDto, Principal principal) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapInventoryAssignEntity--------------------started-->");
		inventoryAssign.setAvailableQty(inventoryEntranceDto.getQuantity());
		inventoryAssign.setLeftoverQty(inventoryEntranceDto.getQuantity());
		inventoryAssign.setAssignedLocation(inventoryEntranceDto.getLocation());
		inventoryAssign.setCreatedBy(principal.getName());
		inventoryAssign.setCreationDate(new Date());
		inventoryAssign.setInperson(principal.getName());
		inventoryAssign.setLastModifiedBy(principal.getName());
		inventoryAssign.setLastModifiedDate(new Date());
		inventoryAssign.setAllocatedQty(inventoryEntranceDto.getQuantity());
		inventoryAssign.setModelCode(inventoryEntranceDto.getModelCode());
		inventoryAssign.setWareHouseSiteName(inventoryEntranceDto.getSite());
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapInventoryAssignEntity--------------------Ended-->");
		return inventoryAssign;
	}

	@Override
	public List<InventoryEntranceDto> getCurrentUserInventoryAssign(Principal principal) {
		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		;
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------getCurrentUserInventoryAssign--------------------started-->");
			List<ProjectDto> projectDtoList = getCurrentUserProjectDtoList(principal);

			if (projectDtoList != null && !projectDtoList.isEmpty()) {
				for (int i = 0; i < projectDtoList.size(); i++) {
					ProjectDto projectDto = projectDtoList.get(i);
					if (projectDto != null) {
						List<InventoryAssign> inventoryAssignEntityList = inventoryAssignRepository
								.findByAssignedLocation(projectDto.getName());
						if (inventoryAssignEntityList != null && !inventoryAssignEntityList.isEmpty()) {
							for (int j = 0; j < inventoryAssignEntityList.size(); j++) {
								InventoryAssign inventoryAssign = inventoryAssignEntityList.get(j);
								if (inventoryAssign != null && inventoryAssign.getAvailableQty() > 0) {
									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									inventoryEntranceDto.setId(inventoryAssign.getId());
									SubCategory subCategory = inventoryAssign.getSubCategory();
									if (subCategory != null) {
										Category categoryEntity = inventoryAssign.getCategory();
										if (categoryEntity != null) {
											inventoryEntranceDto.setCategoryCode(categoryEntity.getCategoryCode());
											inventoryEntranceDto.setCategoryType(categoryEntity.getCategoryType());
											inventoryEntranceDto.setAssetTracking(categoryEntity.getAssetTracking());
										}
										inventoryEntranceDto.setModelCode(subCategory.getModel());
										inventoryEntranceDto.setSubCategory(subCategory.getSubCategory());
									}
									inventoryEntranceDto.setLocation(inventoryAssign.getAssignedLocation());
									inventoryEntranceDto.setSite(inventoryAssign.getAssignedLocation());
									inventoryEntranceDto.setQuantity(inventoryAssign.getAllocatedQty());
									inventoryEntranceDto.setAvailableQuantity(inventoryAssign.getAvailableQty());
									inventoryEntranceDto.setInventoryNumber(inventoryAssign.getInventoryNumber());
									inventoryEntranceDto.setAssignedLocation(inventoryAssign.getAssignedLocation());
									inventoryEntranceDto.setInventoryLocation(inventoryAssign.getInventoryLocation());
									inventoryEntranceDto.setWarehouseOrSitename(inventoryAssign.getWareHouseSiteName());

									SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

									// inventoryEntranceDto.setCreationDate(MasterDateUtil
									// .convertDateToStringWithTime(inventoryAssign.getCreationDate()));

									inventoryEntranceDto
											.setCreationDate(dateFormat.format(inventoryAssign.getCreationDate()));

									inventoryEntranceDtoList.add(inventoryEntranceDto);
								}
							}
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------getCurrentUserInventoryAssign--------------------Ended-->");
		return inventoryEntranceDtoList;
	}

	@Override
	public ResponseDto moveRequestAsUserSpecified(InventoryRequestDto inventoryRequestDto, Principal principal,
			String constant) throws Exception {
		logger.info(
				"<--InventoryManagementServiceImpl-------------moveRequestAsUserSpecified--------------------Ended-->");
		ResponseDto responseDto = null;
		if (inventoryRequestDto.getInventoryLocation().equals(InventoryConstant.PROJECTSITE)) {

			InventoryAssign inventoryAssign = inventoryAssignRepository.findOne(inventoryRequestDto.getId());

			if (inventoryAssign != null && inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOWAREHOUSE)) {
				if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
					responseDto = saveRequestToInventoryRequest(inventoryRequestDto, inventoryAssign, constant,
							principal);

					if (responseDto.getStatus().equals(InventoryConstant.SUCCESS)) {
						if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
							inventoryAssign.setAvailableQty(
									inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity());
							inventoryAssign.setLeftoverQty(
									inventoryAssign.getLeftoverQty() - inventoryRequestDto.getQuantity());
							inventoryAssign = inventoryAssignRepository.save(inventoryAssign);
							if (inventoryAssign != null) {
								responseDto = dispatchLogService.addInventoryInDispatchForWareHouse(
										mapBulkRequestDto(inventoryRequestDto, inventoryAssign, principal),
										InventoryConstant.MOVETOWAREHOUSE, responseDto.getNumber(), principal);
							}
						}

					}

				}
			} else if (inventoryAssign != null
					&& inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSCRAP)) {
				if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
					responseDto = mapScrapInspectionEntity(inventoryRequestDto, inventoryAssign, constant, principal);

					if (responseDto.getStatus().equals(InventoryConstant.SUCCESS)) {
						if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
							inventoryAssign.setAvailableQty(
									inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity());
							inventoryAssign = inventoryAssignRepository.save(inventoryAssign);
						}
					}

				}
			} else if (inventoryAssign != null
					&& inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSERVICE)) {
				if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
					responseDto = mapServiceInspectionEntity(inventoryRequestDto, inventoryAssign, constant, principal);

					if (responseDto.getStatus().equals(InventoryConstant.SUCCESS)) {
						if (inventoryAssign.getAvailableQty() >= inventoryRequestDto.getQuantity()) {
							inventoryAssign.setAvailableQty(
									inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity());
							inventoryAssign = inventoryAssignRepository.save(inventoryAssign);
						}
					}

				}
			}
		}

		logger.info(
				"<--InventoryManagementServiceImpl-------------moveRequestAsUserSpecified--------------------Ended-->");
		return responseDto;
	}

	/**
	 * this method is used to move the request to specified location as per site
	 * engineer requested
	 * 
	 */
	@Override
	public ResponseDto moveInventory(InventoryRequestDto inventoryRequestDto, Principal principal) throws Exception {
		ResponseDto responseDto = null;
		logger.info("<--InventoryManagementServiceImpl-------------moveInventory--------------------started-->");
		if (inventoryRequestDto != null) {
			if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOWAREHOUSE)) {
				responseDto = moveRequestAsUserSpecified(inventoryRequestDto, principal,
						InventoryConstant.MOVETOWAREHOUSEREQUESTED);
			} else if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSCRAP)) {
				responseDto = moveRequestAsUserSpecified(inventoryRequestDto, principal,
						InventoryConstant.MOVETOSCRAPREQUESTED);
			} else if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSERVICE)) {
				responseDto = moveRequestAsUserSpecified(inventoryRequestDto, principal,
						InventoryConstant.MOVETOSERVICEREQUESTED);
			}
		}
		logger.info("<--InventoryManagementServiceImpl-------------moveInventory--------------------Ended-->");
		return responseDto;
	}

	@Override
	public String confirmMoveInventory(InventoryRequestDto inventoryRequestDto, Principal principal) throws Exception {
		String status = null;
		logger.info("<--InventoryManagementServiceImpl-------------confirmMoveInventory--------------------started-->");
		if (inventoryRequestDto != null) {
			if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOWAREHOUSEREQUESTED)) {
				status = confirmMoveRequestedInventory(inventoryRequestDto, principal);
			} else if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSCRAPREQUESTED)) {
				status = confirmMoveRequestedInventory(inventoryRequestDto, principal);
			} else if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSERVICEREQUESTED)) {
				status = confirmMoveRequestedInventory(inventoryRequestDto, principal);
			}
		}
		logger.info("<--InventoryManagementServiceImpl-------------confirmMoveInventory--------------------Ended-->");
		return status;
	}

	@Override
	public List<InventoryRequestDto> getMoveRequestNotifications(Principal principal) {
		List<InventoryRequestDto> inventoryRequestDtoList = null;
		try {

			User user = userRepository.findByUserName(principal.getName());
			if (user != null) {

				List<WareHouse> wareHouseEntityList = user.getWareHouseItem();
				if (wareHouseEntityList != null && !wareHouseEntityList.isEmpty()) {

					for (int i = 0; i < wareHouseEntityList.size(); i++) {

						WareHouse wareHouse = wareHouseEntityList.get(i);
						if (wareHouse != null) {
							List<InventoryRequest> inventoryRequestEntityList = inventoryRequestRepository
									.getMoveRequestNotifications();
							if (inventoryRequestEntityList != null && !inventoryRequestEntityList.isEmpty()) {
								inventoryRequestDtoList = new ArrayList<>();
								for (int j = 0; j < inventoryRequestEntityList.size(); j++) {
									InventoryRequest inventoryRequest = inventoryRequestEntityList.get(j);
									if (inventoryRequest != null) {
										if (wareHouse.getWareHouseName().equals(inventoryRequest.getRequestedTo())) {
											inventoryRequestDtoList.add(
													mapInventoryRequestDtoForMoveRequestNotification(inventoryRequest));
										}
									}
								}
							}
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryRequestDtoList;
	}

	private InventoryRequestDto mapInventoryRequestDto(InventoryRequest inventoryRequest) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapInventoryRequestDto--------------------started-->");
		InventoryRequestDto inventoryRequestDto = new InventoryRequestDto();
		inventoryRequestDto.setId(inventoryRequest.getId());
		inventoryRequestDto.setRequestedTo(inventoryRequest.getRequestedTo());
		inventoryRequestDto.setModelCode(inventoryRequest.getModelCode());
		inventoryRequestDto.setQuantity(inventoryRequest.getQuantity());
		inventoryRequestDto.setReferenceNo(inventoryRequest.getReferenceNo());
		inventoryRequestDto.setStatus(inventoryRequest.getStatus());
		inventoryRequestDto.setRequestedFrom(inventoryRequest.getRequestedFrom());
		Category category = inventoryRequest.getCategory();
		if (category != null) {
			inventoryRequestDto.setCategory(category.getCategoryType());
		}
		SubCategory subCategory = inventoryRequest.getSubCategory();
		if (subCategory != null) {
			inventoryRequestDto.setSubCategory(subCategory.getSubCategory());
		}
		logger.info("<--InventoryManagementServiceImpl-------------mapInventoryRequestDto--------------------Ended-->");
		return inventoryRequestDto;
	}

	private InventoryRequestDto mapInventoryRequestDtoForMoveRequestNotification(InventoryRequest inventoryRequest) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapInventoryRequestDto--------------------started-->");
		InventoryRequestDto inventoryRequestDto = new InventoryRequestDto();
		inventoryRequestDto.setId(inventoryRequest.getId());
		inventoryRequestDto.setRequestedTo(inventoryRequest.getRequestedTo());
		inventoryRequestDto.setModelCode(inventoryRequest.getModelCode());
		inventoryRequestDto.setQuantity(inventoryRequest.getQuantity());
		inventoryRequestDto.setReferenceNo(inventoryRequest.getReferenceNo());
		inventoryRequestDto.setStatus(inventoryRequest.getStatus());
		inventoryRequestDto.setRequestedFrom(inventoryRequest.getRequestedFrom());
		Category category = inventoryRequest.getCategory();
		if (category != null) {
			inventoryRequestDto.setCategory(category.getCategoryType());
		}
		SubCategory subCategory = inventoryRequest.getSubCategory();
		if (subCategory != null) {
			inventoryRequestDto.setSubCategory(subCategory.getSubCategory());
		}
		logger.info("<--InventoryManagementServiceImpl-------------mapInventoryRequestDto--------------------Ended-->");
		return inventoryRequestDto;
	}

	@Override
	public InventoryRequestDto getInventoryRequestById(String id, Principal principal) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------getInventoryRequestById--------------------started-->");
		InventoryRequestDto inventoryRequestDto = null;
		if (id != null) {
			InventoryRequest inventoryRequest = inventoryRequestRepository.findOne(Long.valueOf(id));
			if (inventoryRequest != null) {
				inventoryRequestDto = new InventoryRequestDto();
				inventoryRequestDto = mapInventoryRequestDto(inventoryRequest);
			}
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------getInventoryRequestById--------------------Ended-->");
		return inventoryRequestDto;
	}

	@Override
	public String confirmMoveRequestedInventory(InventoryRequestDto inventoryRequestDto, Principal principal) {
		String status = InventoryConstant.FAILURE;
		Integer remainingQuantity = null;
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------confirmMoveRequestedInventory--------------------started-->");
			if (inventoryRequestDto != null && inventoryRequestDto.getId() != null) {
				InventoryRequest inventoryRequest = inventoryRequestRepository.findOne(inventoryRequestDto.getId());
				if (inventoryRequest != null) {
					if (InventoryConstant.MOVETOWAREHOUSEREQUESTED.equals(inventoryRequest.getStatus())) {
						InventoryAssign inventoryAssign = inventoryRequest.getInventoryAssign();
						if (inventoryAssign != null) {
							remainingQuantity = inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity();
							inventoryAssign.setAvailableQty(remainingQuantity);
							inventoryRequest.setInventoryAssign(inventoryAssign);
							if (inventoryAssign != null) {
								InventoryEntrance inventoryEntrance = inventoryAssign.getInventoryEntrance();
								if (inventoryEntrance != null) {
									inventoryEntrance.setAvailableQuantity(inventoryEntrance.getAvailableQuantity()
											+ inventoryRequestDto.getQuantity());
									inventoryEntrance.setLocation(InventoryConstant.WAREHOUSE);
									inventoryEntrance.setWareHouseSiteName(inventoryRequest.getRequestedTo());
									inventoryRequest.setInventoryEntrance(inventoryEntrance);
									inventoryRequest.setComments(inventoryRequestDto.getComments());
									inventoryRequest.setStatus(InventoryConstant.WAREHOUSE_MOVE_REQUEST_CONFIRMED);
									inventoryRequest = inventoryRequestRepository.saveAndFlush(inventoryRequest);
									if (inventoryRequest != null) {
										status = InventoryConstant.SUCCESS;
									}

								}
							}
						}

					} else if (InventoryConstant.MOVETOSCRAPREQUESTED.equals(inventoryRequest.getStatus())) {
						InventoryAssign inventoryAssign = inventoryRequest.getInventoryAssign();
						if (inventoryAssign != null) {
							remainingQuantity = inventoryAssign.getAvailableQty() - inventoryRequestDto.getQuantity();
							inventoryAssign.setAvailableQty(remainingQuantity);
							inventoryRequest.setInventoryAssign(inventoryAssign);
							if (inventoryAssign != null) {
								Scrap scrap = new Scrap();
								scrap.setFromLocation(inventoryAssign.getWareHouseSiteName());
								scrap.setQuantity(inventoryRequestDto.getQuantity());
								scrap.setRaisedBy(principal.getName());
								scrap.setRaisedDate(new Date());
								scrap.setComments(inventoryRequestDto.getComments());
								scrap.setStatus(InventoryConstant.ACTIVE);
								scrap.setWarehouseSiteName(inventoryAssign.getWareHouseSiteName());
								scrap.setLastModifiedBy(principal.getName());
								scrap.setLastModifiedDate(new Date());
								scrap = scrapRepository.save(scrap);
								if (scrap != null) {
									inventoryRequest.setStatus(InventoryConstant.SCRAP_MOVE_REQUEST_CONFIRMED);
									inventoryRequest = inventoryRequestRepository.save(inventoryRequest);
									if (inventoryRequest != null) {
										status = InventoryConstant.SUCCESS;
									}
								}
							}
						}
					} else if (InventoryConstant.MOVETOSERVICEREQUESTED.equals(inventoryRequest.getStatus())) {

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------confirmMoveRequestedInventory--------------------started-->");
		return status;
	}

	public ResponseDto saveRequestToInventoryRequest(InventoryRequestDto inventoryRequestDto,
			InventoryAssign inventoryAssign, String constant, Principal principal) {

		ResponseDto responseDto = new ResponseDto();
		String referenceNo = toolsRequestService.getRefNoSequence();
		InventoryRequest inventoryRequest = new InventoryRequest();
		inventoryRequest.setRequestedTo(inventoryRequestDto.getRequestedTo());
		inventoryRequest.setLocation(InventoryConstant.PROJECTSITE);
		inventoryRequest.setReferenceNo(referenceNo);
		inventoryRequest.setStatus(constant);
		inventoryRequest.setActionBy(principal.getName());
		inventoryRequest.setActionDate(new Date());
		inventoryRequest.setDispatchDate(new Date());
		inventoryRequest.setRaisedBy(principal.getName());
		inventoryRequest.setRaisedDate(new Date());
		inventoryRequest.setModelCode(inventoryRequestDto.getModelCode());
		inventoryRequest.setQuantity(inventoryRequestDto.getQuantity());
		inventoryRequest.setAcceptedQuantity(inventoryRequestDto.getQuantity());
		inventoryRequest.setComments(inventoryRequestDto.getComments());
		inventoryRequest.setExpectedDateToReach(new Date());
		inventoryRequest.setSubStatus(constant);
		inventoryRequest.setChallanStatus(InventoryConstant.CHALLAN_NOT_GENERATED);
		inventoryRequest.setRequestedFrom(inventoryRequestDto.getRequestedFrom());
		inventoryRequest.setRequiredDays(0);
		inventoryRequest.setInventoryNumber(inventoryAssign.getInventoryNumber());
		inventoryRequest.setChallanStatus(inventoryRequestDto.getChallanStatus());
		Category category = categoryRepository.findByCategoryTypeAndStatus(inventoryRequestDto.getCategory(),
				InventoryConstant.ACTIVE);
		if (category != null) {
			inventoryRequest.setCategory(category);
		}
		SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(),
				InventoryConstant.ACTIVE); // unique result problem may
		if (subCategory != null) {
			inventoryRequest.setSubCategory(subCategory);
		}
		inventoryRequest.setInventoryAssign(inventoryAssign);
		inventoryRequest = inventoryRequestRepository.saveAndFlush(inventoryRequest);
		if (inventoryRequest != null) {
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setNumber(referenceNo);
		} else {
			responseDto.setStatus(InventoryConstant.FAILURE);
		}
		return responseDto;
	}

	@Override
	public String editInventoryManagement(InventoryEntranceDto inventoryEntranceDto, Principal principal) {
		String status = InventoryConstant.FAILURE;
		try {
			logger.info(
					"<--InventoryManagementServiceImpl-------------editInventoryManagement--------------------started-->");

			InventoryEntrance inventoryEntrance = inventoryStockRepository.findOne(inventoryEntranceDto.getId());
			if (inventoryEntrance != null) {
				inventoryEntrance.setIsWarrantyApplicable(inventoryEntranceDto.getIsWarrantyPeriodApplicable());
				if (inventoryEntranceDto.getIsWarrantyPeriodApplicable().equals(InventoryConstant.YES)) {

					inventoryEntrance.setWarrantyExpiryDate(MasterDateUtil.convertCalendarToDate(MasterDateUtil
							.caculateWarranty(inventoryEntranceDto.getYear(), inventoryEntranceDto.getMonth())));
				}
				inventoryEntrance.setYear(inventoryEntranceDto.getYear());
				inventoryEntrance.setMonth(inventoryEntranceDto.getMonth());
				inventoryEntrance.setCreated_By(principal.getName());
				inventoryEntrance.setCreationDate(new Date());
				inventoryEntrance.setLastModifiedBy(principal.getName());
				inventoryEntrance.setLastModifiedDate(new Date());
				inventoryEntrance.setLocation(InventoryConstant.WAREHOUSE);
				inventoryEntrance.setQuantity(inventoryEntranceDto.getQuantity());
				inventoryEntrance.setAvailableQuantity(inventoryEntranceDto.getQuantity());
				inventoryEntrance.setSupplierName(inventoryEntranceDto.getSupplierName());
				inventoryEntrance.setWarrantyExpiryDate(
						MasterDateUtil.convertDateToString(inventoryEntranceDto.getWarrantyPeriod()));
				// inventoryEntrance.setPurchaseDate(MasterDateUtil.convertDateToString(inventoryEntranceDto.getPurchaseDate()));
				inventoryEntrance.setPurchaseTotalCost(Double.valueOf(inventoryEntranceDto.getPurchaseCost()));
				inventoryEntrance.setManufacturerName(inventoryEntranceDto.getManufacturerName());
				// inventoryEntrance.setPurchaseTotalCost(Double.valueOf(inventoryEntranceDto.getPurchaseCost()));
				inventoryEntrance.setIsServiceApplicable(inventoryEntranceDto.getIsServicePeriodApplicable());
				// inventoryEntrance.setServiceDueMonth(inventoryEntranceDto.getServiceDueDate());
				inventoryEntrance.setWareHouseSiteName(inventoryEntranceDto.getSite());
				if (inventoryEntranceDto.getServiceDueDate() != null
						&& inventoryEntranceDto.getPurchaseDate() != null) {
					inventoryEntrance.setServiceDueMonth(inventoryEntranceDto.getServiceDueDate());
					inventoryEntrance.setPurchaseDate(
							MasterDateUtil.convertDateToString(inventoryEntranceDto.getPurchaseDate()));
					// inventoryEntrance.setServiceDueDate(MasterDateUtil.convertDateToString(inventoryEntranceDto.getServiceDueDate()));
					inventoryEntrance.setServiceDueDate(
							MasterDateUtil.convertCalendarToDate(MasterDateUtil.caculateServiceDueDate(
									MasterDateUtil.convertFromStringToDate(inventoryEntranceDto.getPurchaseDate()),
									(MasterDateUtil
											.ConvertStringtoInteger(inventoryEntranceDto.getServiceDueDate())))));
				}

				inventoryEntrance = inventoryStockRepository.saveAndFlush(inventoryEntrance);
				if (inventoryEntrance != null) {
					status = InventoryConstant.SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------editInventoryManagement--------------------Ended-->");
		return status;
	}

	public List<WareHouseBlocksDto> getAllWareHouseBlocksNamesByWareHouseName(String wareHouseName) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------getAllWareHouseBlocksNamesByWareHouseName--------------------started-->");

		List<WareHouseBlocksDto> wareHouseBlocksDtosList = new ArrayList<>();
		WareHouse wareHouse = wareHouseRepository.findByWareHouseName(wareHouseName);
		if (wareHouse != null) {
			List<WareHouseBlocks> wareHouseBlocksList = wareHouse.getWareHouseBlocksList();
			if (wareHouseBlocksList != null && !wareHouseBlocksList.isEmpty()) {
				for (int i = 0; i < wareHouseBlocksList.size(); i++) {
					WareHouseBlocks wareHouseBlocks = wareHouseBlocksList.get(i);
					if (wareHouseBlocks != null) {
						WareHouseBlocksDto wareHouseBlocksDto = new WareHouseBlocksDto();
						wareHouseBlocksDto.setId(wareHouseBlocks.getId());
						wareHouseBlocksDto.setBlocksNames(wareHouseBlocks.getBlocksNames());
						wareHouseBlocksDtosList.add(wareHouseBlocksDto);
					}
				}
			}
		}

		logger.info(
				"<--InventoryManagementServiceImpl-------------getAllWareHouseBlocksNamesByWareHouseName--------------------Ended-->");
		return wareHouseBlocksDtosList;
	}

	/*
	 * @Override public List<InventoryRequestDto> getAllMyRequest(Principal
	 * principal) { logger.info(
	 * "<--InventoryManagementServiceImpl-------------getAllMyRequest--------------------started-->"
	 * ); List<InventoryRequestDto> inventoryRequestDtoList=new ArrayList<>();
	 * try { List<ProjectDto>
	 * projectDtoList=getCurrentUserProjectDtoList(principal);
	 * 
	 * if(projectDtoList!=null && !projectDtoList.isEmpty()) { for(int
	 * i=0;i<projectDtoList.size();i++) { ProjectDto
	 * projectDto=projectDtoList.get(i); if(projectDto!=null) {
	 * List<InventoryRequest>
	 * inventoryRequestEntityList=inventoryRequestRepository.findByRequestedFrom
	 * (projectDto.getName()); if(inventoryRequestEntityList!=null &&
	 * !inventoryRequestEntityList.isEmpty()) { for(int
	 * j=0;j<inventoryRequestEntityList.size();j++) { InventoryRequest
	 * inventoryRequest= inventoryRequestEntityList.get(j);
	 * if(inventoryRequest!=null) { InventoryRequestDto inventoryRequestDto=new
	 * InventoryRequestDto();
	 * inventoryRequestDto.setCategoryType(inventoryRequest.getCategory().
	 * getCategoryType());
	 * inventoryRequestDto.setSubCategory(inventoryRequest.getSubCategory().
	 * getSubCategory());
	 * inventoryRequestDto.setQuantity(inventoryRequest.getQuantity());
	 * inventoryRequestDto.setRequestedTo(inventoryRequest.getRequestedTo());
	 * inventoryRequestDto.setReferenceNo(inventoryRequest.getReferenceNo());
	 * inventoryRequestDto.setComments(inventoryRequest.getComments());
	 * inventoryRequestDto.setModelCode(inventoryRequest.getModelCode());
	 * inventoryRequestDto.setStatus(inventoryRequest.getStatus());
	 * inventoryRequestDto.setSubStatus(inventoryRequest.getSubStatus());
	 * inventoryRequestDto.setRequestedFrom(inventoryRequest.getRequestedFrom())
	 * ; inventoryRequestDtoList.add(inventoryRequestDto); } } } } } }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } logger.info(
	 * "<--InventoryManagementServiceImpl-------------getAllMyRequest--------------------started-->"
	 * ); return inventoryRequestDtoList; }
	 */
	@Override
	public List<InventoryRequestDto> getAllMyRequest(Principal principal) {
		logger.info("<--InventoryManagementServiceImpl-------------getAllMyRequest--------------------started-->");
		List<InventoryRequestDto> inventoryRequestDtoList = new ArrayList<>();
		InventoryRequest inventoryRequest = new InventoryRequest();
		try {
			List<ProjectDto> projectDtoList = getCurrentUserProjectDtoList(principal);

			if (projectDtoList != null && !projectDtoList.isEmpty()) {
				for (int i = 0; i < projectDtoList.size(); i++) {
					ProjectDto projectDto = projectDtoList.get(i);
					if (projectDto != null) {
						List<Object> inventoryRequestEntityList = inventoryRequestRepository
								.findMyrequest(projectDto.getName());
						if (inventoryRequestEntityList != null && !inventoryRequestEntityList.isEmpty()) {
							for (int j = 0; j < inventoryRequestEntityList.size(); j++) {
								Object object = inventoryRequestEntityList.get(j);
								if (object != null) {
									Object[] objectArray = (Object[]) object;

									InventoryRequestDto inventoryRequestDto = new InventoryRequestDto();
									if (objectArray[0] != null) {
										inventoryRequestDto.setCategoryType(objectArray[0].toString());
									}
									if (objectArray[1] != null) {
										inventoryRequestDto.setSubCategory(objectArray[1].toString());
									}
									if (objectArray[2] != null) {
										inventoryRequestDto.setModelCode(objectArray[2].toString());
									}
									if (objectArray[3] != null) {
										inventoryRequestDto.setQuantity((Integer) objectArray[3]);
									}
									if (objectArray[4] != null) {
										inventoryRequestDto.setReferenceNo(objectArray[4].toString());
									}
									if (objectArray[5] != null) {
										inventoryRequestDto.setRequestedFrom(objectArray[5].toString());
									}
									if (objectArray[6] != null) {
										inventoryRequestDto.setRequestedTo(objectArray[6].toString());
									}
									if (objectArray[7] != null) {
										inventoryRequestDto.setStatus(objectArray[7].toString());
									}
									if (objectArray[8] != null) {
										inventoryRequestDto.setSubStatus(objectArray[8].toString());
									}

									if (objectArray[9] != null) {

										Object test1 = objectArray[9];
										// System.out.println(test1);
										SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
										String test = dateFormat.format(test1);
										// System.out.println(test);
										inventoryRequestDto.setActionDate(test);
									}
									// inventoryRequestDto.setComments(inventoryRequest.getComments());

									inventoryRequestDtoList.add(inventoryRequestDto);

								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------getAllMyRequest--------------------started-->");
		return inventoryRequestDtoList;
	}

	@Override
	public List<InventoryEntranceDto> getInventoryAssignByChallanNo(String challanNo, Principal principal) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------getInventoryAssignByChallanNo--------------------started-->");
		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();

		String placeofSupply;

		try {
			if (challanNo != null) {

				// DeliveryChallanEntity challandetails = new
				// DeliveryChallanEntity();
				//
				// challandetails =
				// deliveryChallanEntityRepository.findOne(Long.valueOf(challanNo));
				//
				// if (challandetails != null) {
				// placeofSupply = challandetails.getPlaceOfSupply();
				// }

				List<ProjectDto> projectDtoList = getCurrentUserProjectDtoList(principal);

				if (projectDtoList != null && !projectDtoList.isEmpty()) {
					for (int i = 0; i < projectDtoList.size(); i++) {
						List<DeliveryChallanEntity> deliveryChallanEntityList = new ArrayList<>();
						ProjectDto projectDto = projectDtoList.get(i);
						if (projectDto != null) {
							/*
							 * deliveryChallanEntityList =
							 * deliveryChallanEntityRepository
							 * .findDeliveryChallanEntityByChallanNo(projectDto.
							 * getName(), challanNo);
							 */
							deliveryChallanEntityList = deliveryChallanEntityRepository
									.findDeliveryChallanEntityByChallanNo(challanNo, projectDto.getName());

							for (int j = 0; j < deliveryChallanEntityList.size(); j++) {

								DispatcherLog dispatcherLog = deliveryChallanEntityList.get(j).getDispatcherLog();
								if (dispatcherLog != null) {

									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									inventoryEntranceDto.setId(dispatcherLog.getId());
									DeliveryChallanEntity deliveryChallanEntity = deliveryChallanEntityList.get(j);
									if (deliveryChallanEntity != null) {
										if (deliveryChallanEntity.getChallanNo() != null
												&& deliveryChallanEntity.getChallanNo().equals(challanNo)) {
											inventoryEntranceDto.setQuantity(deliveryChallanEntity.getQuantity());
										}
									}
									Category category = dispatcherLog.getCategory();
									if (category != null) {
										inventoryEntranceDto.setCategoryType(category.getCategoryType());
										inventoryEntranceDto.setAssetTracking(category.getAssetTracking());
									}
									SubCategory subCategory = dispatcherLog.getSubCategory();
									if (subCategory != null) {
										inventoryEntranceDto.setSubCategory(subCategory.getSubCategory());
									}
									inventoryEntranceDto.setSite(dispatcherLog.getRequestedFrom());
									inventoryEntranceDto.setRequestedFrom(dispatcherLog.getRequestedFrom());
									inventoryEntranceDto.setRequestedTo(dispatcherLog.getRequestedTo());
									inventoryEntranceDto.setModelCode(dispatcherLog.getModelCode());
									inventoryEntranceDto.setReferenceNo(dispatcherLog.getReferenceNo());
									inventoryEntranceDto.setPurpose(deliveryChallanEntity.getPurpose());
									if (dispatcherLog.getInventoryAssign() != null) {
										inventoryEntranceDto.setInventoryNumber(
												dispatcherLog.getInventoryAssign().getInventoryNumber());
									} else if (dispatcherLog.getInventoryEntrance().getInventoryNumber() != null) {
										inventoryEntranceDto.setInventoryNumber(
												dispatcherLog.getInventoryEntrance().getInventoryNumber());
									}
									inventoryEntranceDto.setReason(deliveryChallanEntity.getReason());

									inventoryEntranceDtoList.add(inventoryEntranceDto);
								}

							}
						}
					}
				} else {
					List<WareHouseDto> wareHouseDtoList = UserManagementService
							.getCurrentUserWareHouseDtoList(principal);
					if (wareHouseDtoList != null) {

						for (int i = 0; i < wareHouseDtoList.size(); i++) {
							WareHouseDto warehouseDto = wareHouseDtoList.get(i);
							/*
							 * List<DeliveryChallanEntity>
							 * deliveryChallanEntityList =
							 * deliveryChallanEntityRepository
							 * .findDeliveryChallanEntityByChallanNo(
							 * warehouseDto.getWareHouseName(), challanNo);
							 */

							List<DeliveryChallanEntity> deliveryChallanEntityList = deliveryChallanEntityRepository
									.findDeliveryChallanEntityByChallanNo(challanNo, warehouseDto.getWareHouseName());
							for (int j = 0; j < deliveryChallanEntityList.size(); j++) {

								DispatcherLog dispatcherLog = deliveryChallanEntityList.get(j).getDispatcherLog();
								if (dispatcherLog != null) {

									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									inventoryEntranceDto.setId(dispatcherLog.getId());
									// inventoryEntranceDto.setQuantity(dispatcherLog.getDispatchedQuantity());
									DeliveryChallanEntity deliveryChallanEntity = deliveryChallanEntityList.get(j);
									if (deliveryChallanEntity != null) {
										if (deliveryChallanEntity.getChallanNo() != null
												&& deliveryChallanEntity.getChallanNo().equals(challanNo)) {
											inventoryEntranceDto.setQuantity(deliveryChallanEntity.getQuantity());
										}
									}
									Category category = dispatcherLog.getCategory();
									if (category != null) {
										inventoryEntranceDto.setCategoryType(category.getCategoryType());
										inventoryEntranceDto.setAssetTracking(category.getAssetTracking());
									}
									SubCategory subCategory = dispatcherLog.getSubCategory();
									if (subCategory != null) {
										inventoryEntranceDto.setSubCategory(subCategory.getSubCategory());
									}
									inventoryEntranceDto.setSite(dispatcherLog.getRequestedFrom());
									inventoryEntranceDto.setRequestedTo(dispatcherLog.getRequestedTo());
									inventoryEntranceDto.setRequestedFrom(dispatcherLog.getRequestedFrom());
									inventoryEntranceDto.setModelCode(dispatcherLog.getModelCode());
									inventoryEntranceDto.setReferenceNo(dispatcherLog.getReferenceNo());
									inventoryEntranceDto.setPurpose(dispatcherLog.getPurpose());
									inventoryEntranceDto.setReason(dispatcherLog.getReason());
									inventoryEntranceDto.setInventoryNumber(dispatcherLog.getInventoryNumber());
									inventoryEntranceDtoList.add(inventoryEntranceDto);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------getInventoryAssignByChallanNo--------------------Ended-->");
		return inventoryEntranceDtoList;
	}

	public String checkInventoryMoved(String projectName, Long inventoryAssignId) {
		logger.info("<--InventoryManagementServiceImpl-------------checkInventoryMoved--------------------started-->");

		String status = InventoryConstant.SUCCESS;

		List<InventoryRequest> inventoryRequestEntityList = inventoryRequestRepository.findByRequestedFrom(projectName);

		if (inventoryRequestEntityList != null) {
			for (int i = 0; i < inventoryRequestEntityList.size(); i++) {
				InventoryRequest inventoryRequest = inventoryRequestEntityList.get(i);
				if (inventoryRequest != null) {
					if (inventoryRequest.getInventoryAssign() != null
							&& inventoryRequest.getInventoryAssign().getId().equals(inventoryAssignId)) {
						status = InventoryConstant.ALREADY_REQUESTED;
						break;
					}
				}
			}
		}
		logger.info("<--InventoryManagementServiceImpl-------------checkInventoryMoved--------------------Ended-->");
		return status;
	}

	public BulkRequestResponseDto mapBulkRequestDto(InventoryRequestDto inventoryRequestDto,
			InventoryAssign inventoryAssign, Principal principal) {
		logger.info("<--InventoryManagementServiceImpl-------------mapBulkRequestDto--------------------started-->");
		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		BulkRequestResponseDto bulkRequestResponseDto = new BulkRequestResponseDto();
		bulkRequestResponseDto.setProjectName(inventoryRequestDto.getRequestedTo());
		InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
		inventoryEntranceDto.setId(inventoryAssign.getId());
		inventoryEntranceDto.setAllocatableQuantity(inventoryRequestDto.getQuantity());
		inventoryEntranceDto.setModelCode(inventoryRequestDto.getModelCode());
		inventoryEntranceDto.setSite(inventoryRequestDto.getRequestedFrom());
		inventoryEntranceDto.setCategoryCode(inventoryAssign.getCategory().getCategoryCode());
		inventoryEntranceDto.setSubCategory(inventoryAssign.getSubCategory().getSubCategory());
		inventoryEntranceDto.setSelected(true);
		inventoryEntranceDto.setInventoryNumber(inventoryAssign.getInventoryNumber());
		inventoryEntranceDto.setAllocatableQuantity(inventoryRequestDto.getQuantity());
		inventoryEntranceDtoList.add(inventoryEntranceDto);
		bulkRequestResponseDto.setInventoryEntranceItemDto(inventoryEntranceDtoList);
		logger.info("<--InventoryManagementServiceImpl-------------mapBulkRequestDto--------------------Ended-->");
		return bulkRequestResponseDto;
	}

	public ResponseDto mapScrapInspectionEntity(InventoryRequestDto inventoryRequestDto,
			InventoryAssign inventoryAssign, String constant, Principal principal) {
		ResponseDto responseDto = new ResponseDto();
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapScrapInspectionEntity--------------------started-->");
		String referenceNo = toolsRequestService.getRefNoSequence();
		ScrapInspection scrapInspection = new ScrapInspection();
		if (inventoryRequestDto.getRequestedTo() != null) {
			scrapInspection.setRequestedTo(inventoryRequestDto.getRequestedTo());
		} else {
			scrapInspection.setRequestedTo(InventoryConstant.SHOP);
		}
		scrapInspection.setLocation(InventoryConstant.PROJECTSITE);
		scrapInspection.setReferenceNo(referenceNo);
		scrapInspection.setStatus(InventoryConstant.MOVETOSCRAPREQUESTED);
		scrapInspection.setActionBy(principal.getName());
		scrapInspection.setActionDate(new Date());
		scrapInspection.setDispatchDate(new Date());
		scrapInspection.setRaisedBy(principal.getName());
		scrapInspection.setRaisedDate(new Date());
		scrapInspection.setModelCode(inventoryRequestDto.getModelCode());
		scrapInspection.setQuantity(inventoryRequestDto.getQuantity());
		scrapInspection.setScrapMoveTo(inventoryRequestDto.getScrapMoveTo());
		scrapInspection.setAcceptedQuantity(inventoryRequestDto.getQuantity());
		scrapInspection.setComments(inventoryRequestDto.getComments());
		scrapInspection.setExpectedDateToReach(new Date());
		scrapInspection.setSubStatus(InventoryConstant.QC_VERIFIED);
		scrapInspection.setChallanStatus(InventoryConstant.CHALLAN_NOT_GENERATED);
		scrapInspection.setRequestedFrom(inventoryRequestDto.getRequestedFrom());
		scrapInspection.setRequiredDays(0);
		scrapInspection.setInventoryNumber(inventoryAssign.getInventoryNumber());
		scrapInspection.setChallanStatus(inventoryRequestDto.getChallanStatus());
		Category category = categoryRepository.findByCategoryTypeAndStatus(inventoryRequestDto.getCategory(),
				InventoryConstant.ACTIVE);
		if (category != null) {
			scrapInspection.setCategory(category);
		}
		SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(),
				InventoryConstant.ACTIVE); // unique result problem may
		if (subCategory != null) {
			scrapInspection.setSubCategory(subCategory);
		}
		scrapInspection.setInventoryAssign(inventoryAssign);
		scrapInspection = scrapInspectionRepository.saveAndFlush(scrapInspection);
		if (scrapInspection != null) {
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setNumber(referenceNo);
		} else {
			responseDto.setStatus(InventoryConstant.FAILURE);
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapScrapInspectionEntity--------------------Ended-->");
		return responseDto;

	}

	public ResponseDto mapServiceInspectionEntity(InventoryRequestDto inventoryRequestDto,
			InventoryAssign inventoryAssign, String constant, Principal principal) {
		ResponseDto responseDto = new ResponseDto();
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapServiceInspectionEntity--------------------started-->");
		String referenceNo = toolsRequestService.getRefNoSequence();
		ServiceInspection serviceInspection = new ServiceInspection();
		serviceInspection.setRequestedTo(inventoryRequestDto.getRequestedTo());
		serviceInspection.setLocation(InventoryConstant.PROJECTSITE);
		serviceInspection.setReferenceNo(referenceNo);
		serviceInspection.setStatus(InventoryConstant.MOVETOSERVICEREQUESTED);
		serviceInspection.setActionBy(principal.getName());
		serviceInspection.setActionDate(new Date());
		serviceInspection.setDispatchDate(new Date());
		serviceInspection.setRaisedBy(principal.getName());
		serviceInspection.setRaisedDate(new Date());
		serviceInspection.setModelCode(inventoryRequestDto.getModelCode());
		serviceInspection.setQuantity(inventoryRequestDto.getQuantity());
		serviceInspection.setAcceptedQuantity(inventoryRequestDto.getQuantity());
		serviceInspection.setComments(inventoryRequestDto.getComments());
		serviceInspection.setExpectedDateToReach(new Date());
		serviceInspection.setSubStatus(InventoryConstant.QC_VERIFIED);
		serviceInspection.setChallanStatus(InventoryConstant.CHALLAN_NOT_GENERATED);
		serviceInspection.setRequestedFrom(inventoryRequestDto.getRequestedFrom());
		serviceInspection.setRequiredDays(0);
		serviceInspection.setInventoryNumber(inventoryAssign.getInventoryNumber());
		serviceInspection.setChallanStatus(inventoryRequestDto.getChallanStatus());
		serviceInspection.setWorkingCondtion(inventoryRequestDto.getWorkingCondition());
		Category category = categoryRepository.findByCategoryTypeAndStatus(inventoryRequestDto.getCategory(),
				InventoryConstant.ACTIVE);
		if (category != null) {
			serviceInspection.setCategory(category);
		}
		SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(),
				InventoryConstant.ACTIVE); // unique result problem may
		if (subCategory != null) {
			serviceInspection.setSubCategory(subCategory);
		}
		serviceInspection.setInventoryAssign(inventoryAssign);
		serviceInspection = serviceInspectionRepository.saveAndFlush(serviceInspection);
		if (serviceInspection != null) {
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setNumber(referenceNo);
		} else {
			responseDto.setStatus(InventoryConstant.FAILURE);
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapServiceInspectionEntity--------------------Ended-->");
		return responseDto;

	}

	@Override
	public ResponseDto moveInventoryByWarehouseAdmin(InventoryRequestDto inventoryRequestDto, Principal principal)
			throws Exception {

		logger.info(
				"<--InventoryManagementServiceImpl-------------moveInventoryByWarehouseAdmin--------------------started-->");
		ResponseDto responseDto = new ResponseDto();
		if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSCRAP)) {
			responseDto = moveRequestAsWareHouseAdminSpecified(inventoryRequestDto, principal,
					InventoryConstant.MOVETOSCRAPREQUESTED);
		} else if (inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSERVICE)) {
			responseDto = moveRequestAsWareHouseAdminSpecified(inventoryRequestDto, principal,
					InventoryConstant.MOVETOSERVICEREQUESTED);
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------moveInventoryByWarehouseAdmin--------------------Ended-->");
		return responseDto;
	}

	private ResponseDto moveRequestAsWareHouseAdminSpecified(InventoryRequestDto inventoryRequestDto,
			Principal principal, String movetoscraprequested) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------moveRequestAsWareHouseAdminSpecified--------------------started-->");
		ResponseDto responseDto = new ResponseDto();
		InventoryEntrance inventoryEntrance = inventoryStockRepository.findOne(inventoryRequestDto.getId());
		if (inventoryEntrance != null && inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSCRAP)) {
			if (inventoryEntrance.getAvailableQuantity() >= inventoryRequestDto.getQuantity()) {
				responseDto = mapScrapInspectionEntity(inventoryRequestDto, inventoryEntrance, movetoscraprequested,
						principal);

				if (responseDto.getStatus().equals(InventoryConstant.SUCCESS)) {
					if (inventoryEntrance.getAvailableQuantity() >= inventoryRequestDto.getQuantity()) {
						inventoryEntrance.setAvailableQuantity(
								inventoryEntrance.getAvailableQuantity() - inventoryRequestDto.getQuantity());
						// inventoryEntrance.setQuantity(inventoryEntrance.getAvailableQuantity()
						// - inventoryRequestDto.getQuantity());
						inventoryEntrance = inventoryStockRepository.save(inventoryEntrance);
					}
				}

			}
		} else if (inventoryEntrance != null
				&& inventoryRequestDto.getAction().equals(InventoryConstant.MOVETOSERVICE)) {
			if (inventoryEntrance.getAvailableQuantity() >= inventoryRequestDto.getQuantity()) {
				responseDto = mapServiceInspectionEntity(inventoryRequestDto, inventoryEntrance, movetoscraprequested,
						principal);

				if (responseDto.getStatus().equals(InventoryConstant.SUCCESS)) {
					if (inventoryEntrance.getAvailableQuantity() >= inventoryRequestDto.getQuantity()) {
						inventoryEntrance.setAvailableQuantity(
								inventoryEntrance.getAvailableQuantity() - inventoryRequestDto.getQuantity());
						inventoryEntrance = inventoryStockRepository.save(inventoryEntrance);
					}
				}

			}
		}

		logger.info(
				"<--InventoryManagementServiceImpl-------------moveRequestAsWareHouseAdminSpecified--------------------Ended-->");
		return responseDto;
	}

	private ResponseDto mapScrapInspectionEntity(InventoryRequestDto inventoryRequestDto,
			InventoryEntrance inventoryEntrance, String constant, Principal principal) {

		ResponseDto responseDto = new ResponseDto();
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapScrapInspectionEntity--------------------started-->");
		String referenceNo = toolsRequestService.getRefNoSequence();
		ScrapInspection scrapInspection = new ScrapInspection();
		scrapInspection.setRequestedTo(inventoryRequestDto.getRequestedTo());
		scrapInspection.setLocation(InventoryConstant.WAREHOUSE);
		scrapInspection.setReferenceNo(referenceNo);
		scrapInspection.setStatus(constant);
		scrapInspection.setActionBy(principal.getName());
		scrapInspection.setActionDate(new Date());
		scrapInspection.setDispatchDate(new Date());
		scrapInspection.setRaisedBy(principal.getName());
		scrapInspection.setRaisedDate(new Date());
		scrapInspection.setModelCode(inventoryRequestDto.getModelCode());
		scrapInspection.setQuantity(inventoryRequestDto.getQuantity());
		scrapInspection.setAcceptedQuantity(inventoryRequestDto.getQuantity());
		scrapInspection.setComments(inventoryRequestDto.getComments());
		scrapInspection.setScrapMoveTo(inventoryRequestDto.getScrapMoveTo());
		scrapInspection.setExpectedDateToReach(new Date());
		scrapInspection.setSubStatus(InventoryConstant.QC_VERIFIED);
		scrapInspection.setChallanStatus(InventoryConstant.NO);
		scrapInspection.setRequestedFrom(inventoryRequestDto.getRequestedFrom());
		scrapInspection.setRequiredDays(0);
		scrapInspection.setInventoryNumber(inventoryEntrance.getInventoryNumber());
		Category category = categoryRepository.findByCategoryTypeAndStatus(inventoryRequestDto.getCategory(),
				InventoryConstant.ACTIVE);
		if (category != null) {
			scrapInspection.setCategory(category);
		}
		SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(),
				InventoryConstant.ACTIVE); // unique result problem may
		if (subCategory != null) {
			scrapInspection.setSubCategory(subCategory);
		}
		scrapInspection.setInventoryEntrance(inventoryEntrance);
		scrapInspection = scrapInspectionRepository.saveAndFlush(scrapInspection);
		if (scrapInspection != null) {
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setNumber(referenceNo);
		} else {
			responseDto.setStatus(InventoryConstant.FAILURE);
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapScrapInspectionEntity--------------------Ended-->");
		return responseDto;
	}

	private ResponseDto mapServiceInspectionEntity(InventoryRequestDto inventoryRequestDto,
			InventoryEntrance inventoryEntrance, String constant, Principal principal) {
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapServiceInspectionEntity--------------------Started-->");

		ResponseDto responseDto = new ResponseDto();
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapServiceInspectionEntity--------------------started-->");
		String referenceNo = toolsRequestService.getRefNoSequence();
		ServiceInspection serviceInspection = new ServiceInspection();
		serviceInspection.setRequestedTo(inventoryRequestDto.getRequestedTo());
		serviceInspection.setLocation(InventoryConstant.WAREHOUSE);
		serviceInspection.setReferenceNo(referenceNo);
		serviceInspection.setStatus(constant);
		serviceInspection.setActionBy(principal.getName());
		serviceInspection.setActionDate(new Date());
		serviceInspection.setDispatchDate(new Date());
		serviceInspection.setRaisedBy(principal.getName());
		serviceInspection.setRaisedDate(new Date());
		serviceInspection.setModelCode(inventoryRequestDto.getModelCode());
		serviceInspection.setQuantity(inventoryRequestDto.getQuantity());
		serviceInspection.setAcceptedQuantity(inventoryRequestDto.getQuantity());
		serviceInspection.setComments(inventoryRequestDto.getComments());
		serviceInspection.setExpectedDateToReach(new Date());
		serviceInspection.setSubStatus(InventoryConstant.QC_VERIFIED);
		serviceInspection.setChallanStatus(InventoryConstant.NO);
		serviceInspection.setRequestedFrom(inventoryRequestDto.getRequestedFrom());
		serviceInspection.setRequiredDays(0);
		serviceInspection.setInventoryNumber(inventoryEntrance.getInventoryNumber());
		serviceInspection.setWorkingCondtion(inventoryRequestDto.getWorkingCondition());
		Category category = categoryRepository.findByCategoryTypeAndStatus(inventoryRequestDto.getCategory(),
				InventoryConstant.ACTIVE);
		if (category != null) {
			serviceInspection.setCategory(category);
		}
		SubCategory subCategory = subCategoryRepository.findBySubCategoryAndStatus(inventoryRequestDto.getSubCategory(),
				InventoryConstant.ACTIVE); // unique result problem may
		if (subCategory != null) {
			serviceInspection.setSubCategory(subCategory);
		}
		serviceInspection.setInventoryEntrance(inventoryEntrance);
		serviceInspection = serviceInspectionRepository.saveAndFlush(serviceInspection);
		if (serviceInspection != null) {
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setNumber(referenceNo);
		} else {
			responseDto.setStatus(InventoryConstant.FAILURE);
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapServiceInspectionEntity--------------------Ended-->");
		return responseDto;
	}

	/*
	 * @Override public List<InventoryAssignDto>
	 * getAllInventoryAssignList(Principal principal) { List<ProjectDto>
	 * projectsDtoList = null; List<InventoryAssignDto> inventoryAssignDtoList =
	 * new ArrayList<>(); Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); boolean
	 * hasUserRole = authentication.getAuthorities().stream() .anyMatch(r ->
	 * r.getAuthority().equals(InventoryConstant.SUPER_USER) ||
	 * r.getAuthority().equals(InventoryConstant.USER));
	 * 
	 * if (hasUserRole) { projectsDtoList =
	 * inventoryManagementService.getCurrentUserProjectDtoList(principal);
	 * 
	 * List<InventoryAssign> inventoryAssignsList =
	 * inventoryAssignRepository.findAll();
	 * 
	 * for (int i = 0; i < inventoryAssignsList.size(); i++) {
	 * 
	 * InventoryAssign inventoryAssign = inventoryAssignsList.get(i); for (int j
	 * = 0; j < projectsDtoList.size(); j++) { ProjectDto project =
	 * projectsDtoList.get(j); if
	 * (project.getName().equals(inventoryAssign.getAssignedLocation())) { if
	 * (inventoryAssign != null) { if (inventoryAssign.getAllocatedQty() > 0) {
	 * inventoryAssignDtoList.add(mapInventoryDto(inventoryAssign)); } } }
	 * 
	 * }
	 * 
	 * } } return inventoryAssignDtoList;
	 * 
	 * }
	 */

	/*
	 * private InventoryAssignDto mapInventoryDto(InventoryAssign
	 * inventoryAssign) { InventoryAssignDto inventoryAssignDto = new
	 * InventoryAssignDto();
	 * 
	 * logger.info(
	 * "<--InventoryManagementServiceImpl-------------mapInventoryDto--------------------started-->"
	 * ); try {
	 * 
	 * inventoryAssignDto.setAvailableQty(inventoryAssign.getAvailableQty()); }
	 * catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * return inventoryAssignDto; }
	 */

}