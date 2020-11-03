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
import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.CommonResponseDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ScrapDto;
import com.fa.inventory.dto.ScrapInspectionDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.Scrap;
import com.fa.inventory.entity.ScrapInspection;
import com.fa.inventory.entity.SubCategory;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.repository.CategoryRepository;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.ScarpMasterRespository;
import com.fa.inventory.repository.ScrapInspectionRepository;
import com.fa.inventory.repository.SubCategoryRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.ScrapService;

@Service
public class ScrapServiceImpl implements ScrapService {

	protected final Logger logger = Logger.getLogger(ScrapServiceImpl.class);

	@Resource
	ScarpMasterRespository scarpMasterRespository;

	@Resource
	InventoryStockRepository inventoryStockRepository;

	@Resource
	UserRepository userRepository;

	@Resource
	InventoryAssignRepository inventoryAssignRepository;

	@Resource
	CategoryRepository categoryRepository;

	@Resource
	SubCategoryRepository subCategoryRepository;

	@Resource
	InventoryManagementService inventoryManagementService;
	
	@Resource
	ScrapInspectionRepository scrapInspectionRepository;
	
	@Resource
	WareHouseRepository wareHouseRepository;
	
	@Resource
	ProjectRepository projectRepository;

	private SubCategoryDto mapSubCategoryDto(SubCategory subCategory) {

		SubCategoryDto subCategoryDto = new SubCategoryDto();
		subCategoryDto.setSubCategory(subCategory.getSubCategory());
		subCategoryDto.setModel(subCategory.getModel());
		return subCategoryDto;
	}

	private CategoryDto mapCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryType(category.getCategoryType());
		categoryDto.setCategoryCode(category.getCategoryCode());
		categoryDto.setAssetTracking(category.getAssetTracking());
		return categoryDto;
	}

	private InventoryEntranceDto mapInventoryDto(InventoryEntrance inventoryEntrance) {
		InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
		try {
			inventoryEntranceDto.setSupplierName(inventoryEntrance.getSupplierName());
			inventoryEntranceDto.setPurchaseCost(String.valueOf(inventoryEntrance.getPurchaseTotalCost()));
			inventoryEntranceDto
					.setPurchaseDate(MasterDateUtil.convertDateToString(inventoryEntrance.getPurchaseDate()));
			inventoryEntranceDto
					.setWarrantyPeriod(MasterDateUtil.convertDateToString(inventoryEntrance.getWarrantyExpiryDate()));
			inventoryEntranceDto.setIsWarrantyPeriodApplicable(inventoryEntrance.getIsWarrantyApplicable());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryEntranceDto;
	}

	@Override
	public ScrapDto mapScrapDto(Scrap scrap) {
		ScrapDto scrapDto = new ScrapDto();
		try {
			scrapDto.setId(scrap.getId());
			scrapDto.setStatus(scrap.getStatus());
			scrapDto.setQuantity(scrap.getQuantity());
			scrapDto.setWarehouseSiteName(scrap.getWarehouseSiteName());
			scrapDto.setRaisedDate(scrap.getRaisedDate());
			scrapDto.setRaised_by(scrap.getRaisedBy());
			scrapDto.setComments(scrap.getComments());
			scrapDto.setLastModifiedDate(MasterDateUtil.convertDateToString(scrap.getLastModifiedDate()));
			scrapDto.setFromLocation(scrap.getFromLocation());
			scrapDto.setInventoryNumber(scrap.getInventoryNumber());
			scrapDto.setInventoryEntrance(mapInventoryDto(scrap.getInventoryEntrance()));
			scrapDto.setCategory(mapCategoryDto(scrap.getCategory()));
			scrapDto.setSubCategory(mapSubCategoryDto(scrap.getSubCategory()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scrapDto;
	}
	
	
	public ScrapDto mapScrapDto1(Scrap scrap) {
		ScrapDto scrapDto = new ScrapDto();
		try {
			scrapDto.setId(scrap.getId());
			scrapDto.setStatus(scrap.getStatus());
			scrapDto.setQuantity(scrap.getQuantity());
			scrapDto.setWarehouseSiteName(scrap.getWarehouseSiteName());
			scrapDto.setRaisedDate(scrap.getRaisedDate());
			scrapDto.setRaised_by(scrap.getRaisedBy());
			scrapDto.setComments(scrap.getComments());
			scrapDto.setLastModifiedDate(MasterDateUtil.convertDateToString(scrap.getLastModifiedDate()));
			scrapDto.setFromLocation(scrap.getFromLocation());
			scrapDto.setCategory(mapCategoryDto(scrap.getCategory()));
			scrapDto.setSubCategory(mapSubCategoryDto(scrap.getSubCategory()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scrapDto;
	}

	@Override
	public ScrapDto findScrapById(String parameter) {
		ScrapDto scrapDto = null;
		try {

			Scrap scrapEntity = scarpMasterRespository.findOne(Long.valueOf(parameter));

			if (null != scrapEntity) {
				scrapDto = mapScrapDto(scrapEntity);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scrapDto;
	}

	@Override
	public List<ScrapDto> viewAllScrap(Principal principal) {

		List<ScrapDto> scrapDtoList = null;
		List<Project> projectEntityList =null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.ENQUIRY));
		
		if(hasUserRole)
		{
			try {

				List<Scrap> scrapList = scarpMasterRespository.findAll();

				if (null != scrapList && !scrapList.isEmpty()) {
					scrapDtoList = new ArrayList<>();
					for (int i = 0; i < scrapList.size(); i++) {
						ScrapDto scrapDto = new ScrapDto();

						Scrap scrap = scrapList.get(i);
						scrapDto.setId(scrap.getId());
						scrapDto.setRaisedDate(scrap.getRaisedDate());
						scrapDto.setStatus(scrap.getStatus());
						scrapDto.setQuantity(scrap.getQuantity());
						scrapDto.setWarehouseSiteName(scrap.getWarehouseSiteName());
						scrapDto.setFromLocation(scrap.getFromLocation());

						Category category = scrap.getCategory();

						if (category != null) {
							scrapDto.setCategory(mapCategoryDto(category));
						}

						SubCategory subCategory = scrap.getSubCategory();
						if (subCategory != null) {
							scrapDto.setSubCategory(mapSubCategoryDto(subCategory));
						}

						scrapDtoList.add(scrapDto);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				
				User user = userRepository.findByUserName(principal.getName());
					if (user.getProjectItem() != null) {
						projectEntityList = user.getProjectItem();
						if (projectEntityList != null) {
							for (int k = 0; k < projectEntityList.size(); k++) {
								Project project = user.getProjectItem().get(k);
								if (project != null) {
									List<Scrap> scrapList = scarpMasterRespository.findByFromLocation(project.getName());

									if (null != scrapList && !scrapList.isEmpty()) {
										scrapDtoList = new ArrayList<>();
										for (int i = 0; i < scrapList.size(); i++) {
											Scrap scrap = scrapList.get(i);
											ScrapDto scrapDto = mapScrapDto1(scrap);
											scrapDtoList.add(scrapDto);
										}

									}
								}
							}
						}
					}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return scrapDtoList;

	}
	
	
	@Override
	public List<ScrapDto> viewAllWareHouseScrap(Principal principal) {

		List<ScrapDto> scrapDtoList = null;
		List<WareHouse> wareHouseEntityList=null;
		
		try {
			
			User user = userRepository.findByUserName(principal.getName());
				if (user.getWareHouseItem() != null) {
					wareHouseEntityList = user.getWareHouseItem();
					if (wareHouseEntityList != null) {
						for (int k = 0; k < wareHouseEntityList.size(); k++) {
							WareHouse wareHouse = user.getWareHouseItem().get(k);
							if (wareHouse != null) {
								List<Scrap> scrapList = scarpMasterRespository.findByWarehouseSiteName(wareHouse.getWareHouseName());

								if (null != scrapList && !scrapList.isEmpty()) {
									scrapDtoList = new ArrayList<>();
									for (int i = 0; i < scrapList.size(); i++) {
										Scrap scrap = scrapList.get(i);
										ScrapDto scrapDto = mapScrapDto1(scrap);
										scrapDtoList.add(scrapDto);
									}

								}
							}
						}
					}
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return scrapDtoList;
	}
	
	
	
	@Override
	public List<ScrapDto> viewAllUserScrap(Principal principal) {

		List<ScrapDto> scrapDtoList = null;
		List<Project> projectEntityList =null;

		try {
			
			User user = userRepository.findByUserName(principal.getName());
				if (user.getProjectItem() != null) {
					projectEntityList = user.getProjectItem();
					if (projectEntityList != null) {
						for (int k = 0; k < projectEntityList.size(); k++) {
							Project project = user.getProjectItem().get(k);
							if (project != null) {
								List<Scrap> scrapList = scarpMasterRespository.findByFromLocation(project.getName());

								if (null != scrapList && !scrapList.isEmpty()) {
									scrapDtoList = new ArrayList<>();
									for (int i = 0; i < scrapList.size(); i++) {
										Scrap scrap = scrapList.get(i);
										ScrapDto scrapDto = mapScrapDto1(scrap);
										scrapDtoList.add(scrapDto);
									}

								}
							}
						}
					}
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return scrapDtoList;
	}
	

	@Override
	public CommonResponseDto saveScrap(ScrapDto scrapDto, Principal principal) {
		CommonResponseDto commonResponseDto = new CommonResponseDto();

		try {
			InventoryRequestDto inventoryRequestDto = convertScrapDtoToInventoryRequestDto(scrapDto);
			inventoryManagementService.moveInventory(inventoryRequestDto, principal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return commonResponseDto;
	}

	private InventoryRequestDto convertScrapDtoToInventoryRequestDto(ScrapDto scrapDto) {

		/*
		 * InventoryRequestDto inventoryRequest=new InventoryRequestDto();
		 * inventoryRequest.setWareHouseSiteName(scrapDto.getWareHouseSiteName()
		 * ); inventoryRequest.setLocation(InventoryConstant.PROJECTSITE);
		 * inventoryRequest.setSubStatus(inventoryRequest.getSubStatus());
		 * inventoryRequest.setLocation(scrapDto.getLocation());
		 * inventoryRequest.setModelCode(scrapDto.getModelCode());
		 * inventoryRequest.setQuantity(scrapDto.getQuantity());
		 * inventoryRequest.setRequestedLocation(scrapDto.getRequestedLocation()
		 * );
		 */
		return null;
	}

	@Override
	public BulkRequestResponseDto FindAllToolsforScrap(Principal principal) {

		List<ProjectDto> projectDtoList = null;
		List<Project> projectEntityList = new ArrayList<>();

		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();
		
		List<InventoryEntrance> inventoryEntranceEntityList = null;

		BulkRequestResponseDto bulkRequestResponseDto = new BulkRequestResponseDto();
		try {

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
						bulkRequestResponseDto.setProjectItemDto(projectDtoList);
					}
				}
			}

			if (projectDtoList != null) {
				for (int j = 0; j < projectDtoList.size(); j++) {
					ProjectDto projectDto = projectDtoList.get(j);

					inventoryEntranceEntityList = inventoryStockRepository
							.findByWareHouseSiteName(projectDto.getName());

					if (inventoryEntranceEntityList != null) {
						for (int k = 0; k < inventoryEntranceEntityList.size(); k++) {
							InventoryEntrance inventoryEntrance = inventoryEntranceEntityList.get(k);
							if (inventoryEntrance != null) {
								if (inventoryEntrance.getLocation().equals(InventoryConstant.PROJECTSITE)) {
									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									List<InventoryAssign> inventoryAssignEntityList = inventoryAssignRepository
											.findByAssignedLocation(projectDto.getName());
									if (inventoryAssignEntityList != null && !inventoryAssignEntityList.isEmpty()) {
										for (int m = 0; m < inventoryAssignEntityList.size(); m++) {
											InventoryAssign inventoryAssign = inventoryAssignEntityList.get(m);
											if (inventoryAssign != null) {
												inventoryEntranceDto.setCategoryType(
														inventoryAssign.getCategory().getCategoryType());
												inventoryEntranceDto.setSubCategory(
														inventoryAssign.getSubCategory().getSubCategory());
												inventoryEntranceDto
														.setModelCode(inventoryAssign.getSubCategory().getModel());
												inventoryEntranceDto.setLocation(inventoryAssign.getAssignedLocation());
												inventoryEntranceDto.setSite(inventoryAssign.getWareHouseSiteName());
												inventoryEntranceDto.setQuantity(inventoryAssign.getAllocatedQty());
												inventoryEntranceDtoList.add(inventoryEntranceDto);
											}
										}
									}

								}
								if (inventoryEntrance.getLocation().equals(InventoryConstant.WAREHOUSE)) {
									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									inventoryEntranceDto
											.setCategoryType(inventoryEntrance.getCategory().getCategoryType());
									inventoryEntranceDto
											.setSubCategory(inventoryEntrance.getSubCategory().getSubCategory());
									inventoryEntranceDto.setModelCode(inventoryEntrance.getSubCategory().getModel());
									inventoryEntranceDto.setLocation(inventoryEntrance.getLocation());
									inventoryEntranceDto.setSite(inventoryEntrance.getWareHouseSiteName());
									inventoryEntranceDto.setQuantity(inventoryEntrance.getQuantity());
									inventoryEntranceDtoList.add(inventoryEntranceDto);
								}

							}
						}
					}
				}
				bulkRequestResponseDto.setInventoryEntranceItemDto(inventoryEntranceDtoList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bulkRequestResponseDto;
	}

	@Override
	public List<ScrapInspectionDto> getAllScrapInspection(Principal principal) throws Exception {

		logger.info("<--ScrapServiceImpl-------------getAllScrapInspection--------------------started-->");
		List<ScrapInspectionDto> scrapInspectionDtoList = null;
		try {

			List<ScrapInspection> scrapInspectionsEntityList = scrapInspectionRepository.findAll();

			if (scrapInspectionsEntityList != null) {
				scrapInspectionDtoList = new ArrayList<>();

				for (int i = 0; i < scrapInspectionsEntityList.size(); i++) {

					ScrapInspection scrapInspectionEntity = scrapInspectionsEntityList.get(i);

					if (scrapInspectionEntity != null) {

						if ((scrapInspectionEntity.getStatus().equals(InventoryConstant.MOVETOSCRAPREQUESTED)
								|| scrapInspectionEntity.getStatus()
										.equals(InventoryConstant.MOVETOSERVICEREQUESTED))) {
							ScrapInspectionDto scrapInspectionDto = new ScrapInspectionDto();

							scrapInspectionDto.setId(scrapInspectionEntity.getId());
							scrapInspectionDto.setAcceptedQuantity(scrapInspectionEntity.getAcceptedQuantity());
							scrapInspectionDto.setActionBy(scrapInspectionEntity.getActionBy());
							scrapInspectionDto.setActionDate(
									MasterDateUtil.convertDateToString(scrapInspectionEntity.getActionDate()));
							scrapInspectionDto.setComments(scrapInspectionEntity.getComments());
							scrapInspectionDto.setDispatchDate(
									MasterDateUtil.convertDateToString(scrapInspectionEntity.getDispatchDate()));
							scrapInspectionDto.setExpectedDateToReach(MasterDateUtil
									.convertDateToString(scrapInspectionEntity.getExpectedDateToReach()));
							scrapInspectionDto.setLocation(scrapInspectionEntity.getLocation());
							scrapInspectionDto.setModelCode(scrapInspectionEntity.getModelCode());
							scrapInspectionDto.setQuantity(scrapInspectionEntity.getQuantity());
							scrapInspectionDto.setRaisedBy(scrapInspectionEntity.getRaisedBy());
							scrapInspectionDto.setRaisedDate(
									MasterDateUtil.convertDateToString(scrapInspectionEntity.getRaisedDate()));
							scrapInspectionDto.setReferenceNo(scrapInspectionEntity.getReferenceNo());
							scrapInspectionDto.setRequestedTo(scrapInspectionEntity.getRequestedTo());
							scrapInspectionDto.setRequiredDays(scrapInspectionEntity.getRequiredDays());
							scrapInspectionDto.setStatus(scrapInspectionEntity.getStatus());
							scrapInspectionDto.setSubStatus(scrapInspectionEntity.getSubStatus());
							scrapInspectionDto.setRequestedFrom(scrapInspectionEntity.getRequestedFrom());

							scrapInspectionDto.setCategoryType(scrapInspectionEntity.getCategory().getCategoryType());
							scrapInspectionDto
									.setSubCategory(scrapInspectionEntity.getSubCategory().getSubCategory());
							scrapInspectionDtoList.add(scrapInspectionDto);

						}

					}
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		logger.info("<--ScrapServiceImpl-------------getAllScrapInspection--------------------Ended-->");
		return scrapInspectionDtoList;
	}

}
