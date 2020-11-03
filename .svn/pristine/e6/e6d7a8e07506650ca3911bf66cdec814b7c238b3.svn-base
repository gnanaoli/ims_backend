package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.SubCategory;
import com.fa.inventory.entity.User;
import com.fa.inventory.repository.CategoryRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.SubCategoryRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.SubCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	protected final Logger logger = Logger.getLogger(SubCategoryServiceImpl.class);

	@Resource
	SubCategoryRepository subCategoryRepository;

	@Resource
	CategoryRepository categoryRepository;

	@Resource
	UserRepository userRepository;
	
	@Resource
	InventoryStockRepository inventoryStockRepository;

	@Override
	public List<SubCategoryDto> getAllSubCategoryDtoList() {

		List<SubCategoryDto> subCategoryDtoList = null;
		List<SubCategory> subCategoryList = null;
		try {
			logger.info("<--InventoryManagementServiceImpl-------------getAllSubCategoryDtoList--------------------started-->");
			subCategoryList = subCategoryRepository.findByStatus(InventoryConstant.ACTIVE);
			if (subCategoryList != null && !subCategoryList.isEmpty()) {
				subCategoryDtoList = new ArrayList<>();
				for (int i = 0; i < subCategoryList.size(); i++) {
					SubCategory subCategory = subCategoryList.get(i);
					if (subCategory != null) {
						subCategoryDtoList.add(mapSubCategoryDto(subCategory));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------getAllSubCategoryDtoList--------------------started-->");
		return subCategoryDtoList;
	}

	@Override
	public SubCategoryDto mapSubCategoryDto(SubCategory subCategory) {
		SubCategoryDto subCategoryDto = new SubCategoryDto();
		subCategoryDto.setSubCategory(subCategory.getSubCategory());
		subCategoryDto.setModel(subCategory.getModel());
		subCategoryDto.setHsnCode(subCategory.getHsnCode());
		subCategoryDto.setId(subCategory.getId());
		subCategoryDto.setStatus(subCategory.getStatus());

		CategoryDto categoryDto = new CategoryDto();

		categoryDto.setCategoryType(subCategory.getCategory().getCategoryType());

		subCategoryDto.setCategoryDto(categoryDto);

		return subCategoryDto;

	}

	@Override
	public BulkRequestResponseDto findAllTools(Principal principal) {
		BulkRequestResponseDto bulkRequestResponseDto = new BulkRequestResponseDto();
		List<Category> categoryList = null;
		List<ProjectDto> projectDtoList = new ArrayList<>();
		List<Project> projectEntityList = new ArrayList<>();
		List<CategoryDto> categoryDtosList = new ArrayList<>();
		try {
			logger.info("<--InventoryManagementServiceImpl-------------findAllTools--------------------started-->");
			categoryList = categoryRepository.findAll();
			if (categoryList != null && !categoryList.isEmpty()) {
				for (int i = 0; i < categoryList.size(); i++) {
					Category category = categoryList.get(i);
					if (category != null) {
						CategoryDto categoryDto = mapCategoryAndSubCategory(category, principal);
						categoryDtosList.add(categoryDto);
					}
				}
				bulkRequestResponseDto.setCategoryDtoItemDto(categoryDtosList);
			}
			if (principal.getName() != null) {
				User user = userRepository.findByUserName(principal.getName());
				if (user.getProjectItem() != null) {
					projectEntityList = user.getProjectItem();
					for (int k = 0; k < projectEntityList.size(); k++) {
						Project project = user.getProjectItem().get(k);
						if (project != null) {
							ProjectDto projectDto = new ProjectDto();
							projectDto.setName(project.getName());
							projectDtoList.add(projectDto);
						}
					}
				}
				bulkRequestResponseDto.setProjectItemDto(projectDtoList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryManagementServiceImpl-------------findAllTools--------------------started-->");
		return bulkRequestResponseDto;
	}

	private CategoryDto mapCategoryAndSubCategory(Category category, Principal principal) {
		CategoryDto categoryDto = new CategoryDto();
		List<SubCategoryDto> subCategoryDtoList = new ArrayList<>();
		categoryDto.setCategoryType(category.getCategoryType());
		categoryDto.setId(category.getId());
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapCategoryAndSubCategory--------------------started-->");
		if (category.getSubCategory() != null) {
			List<SubCategory> subCategoriesEnityList = category.getSubCategory();
			if (subCategoriesEnityList != null) {
				for (int i = 0; i < subCategoriesEnityList.size(); i++) {
					SubCategory subCategory = subCategoriesEnityList.get(i);
					if (subCategory != null) {
						SubCategoryDto subCategoryDto = new SubCategoryDto();

						subCategoryDto.setSubCategory(subCategory.getSubCategory());
						subCategoryDto.setId(subCategory.getId());
						subCategoryDto.setModel(subCategory.getModel());
						subCategoryDtoList.add(subCategoryDto);
					}
				}
			}
			categoryDto.setSubCategoryitem(subCategoryDtoList);
		}
		logger.info(
				"<--InventoryManagementServiceImpl-------------mapCategoryAndSubCategory--------------------started-->");
		return categoryDto;
	}

	@Override
	public List<SubCategoryDto> getSubCategoryList(Principal principal) {
		List<SubCategoryDto> subCategoryDtoList = null;
		logger.info("<-- Sub Category Service impl-------------getSubCategoryList--------------------started-->");
		try {
			List<SubCategory> subCategorylist = subCategoryRepository.findAll();

			if (subCategorylist != null && !subCategorylist.isEmpty()) {
				subCategoryDtoList = new ArrayList<>();
				for (int i = 0; i < subCategorylist.size(); i++) {
					SubCategory subCategory = subCategorylist.get(i);
					if (subCategory != null) {
						subCategoryDtoList.add(MapSubCategoryDto(subCategory, principal));

					}
				}
			}
			System.out.println("subCategoryDtoList==>" + new ObjectMapper().writeValueAsString(subCategoryDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--SubCategoryServiceImpl-------------getSubCategoryList--------------------Ended-->");

		return subCategoryDtoList;
	}

	public SubCategoryDto MapSubCategoryDto(SubCategory subcategory, Principal principal) {
		logger.info("<--SubCategoryServiceImpl-------------MapSubCategoryDto--------------------started-->");
		SubCategoryDto subCategoryDto = new SubCategoryDto();

		try {

			subCategoryDto.setId(subcategory.getId());
			if (subcategory.getCategory() != null) {
				subCategoryDto.setCategoryDto(mapCategoryDto(subcategory.getCategory()));
			}
			subCategoryDto.setCreatedBy(subcategory.getCreatedBy());
			subCategoryDto.setCreationDate(MasterDateUtil.convertDateToString(subcategory.getCreationDate()));
			subCategoryDto.setSubCategory(subcategory.getSubCategory());
			subCategoryDto.setModel(subcategory.getModel());
			subCategoryDto.setHsnCode(subcategory.getHsnCode());
			subCategoryDto.setStatus(subcategory.getStatus());

		} catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("<--SubCategoryServiceImpl-------------MapSubCategoryDto--------------------ended-->");
		return subCategoryDto;
	}

	private CategoryDto mapCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		logger.info("<--SubCategoryServiceImpl-------------mapSubCategoryDto--------------------started-->");
		if (category != null) {
			categoryDto.setId(category.getId());
			categoryDto.setCategoryType(category.getCategoryType());
			categoryDto.setCategoryCode(category.getCategoryCode());
			categoryDto.setAssetTracking(category.getAssetTracking());
			categoryDto.setStatus(category.getStatus());
		}
		logger.info("<--SubCategoryServiceImpl-------------mapSubCategoryDto--------------------started-->");
		return categoryDto;
	}

	@Override
	public String saveSubCategory(SubCategoryDto subCategoryDto, Principal principal) throws Exception {

		String status = (InventoryConstant.FAILURE);

		SubCategory subcategory = new SubCategory();

		Category category = new Category();

		if (subCategoryDto != null && subCategoryDto.getId() != null) {
			subcategory = subCategoryRepository.findOne(subCategoryDto.getId());
			InventoryEntrance inventoryEntrance =new InventoryEntrance();
			List<InventoryEntrance> inventoryEntrancelist= inventoryStockRepository.findBySubCategoryName(subCategoryDto.getSubCategory());
			if (inventoryEntrancelist.size()>0)
			{
				throw new Exception(InventoryConstant.THIS_SUB_CATEGORY_IN_STOCK_CAN_NOT_BE_EDIT);	
			}
			if (subcategory != null) {
				if (subCategoryDto.getSubCategory().equals(subcategory.getSubCategory())) {
					if (subCategoryDto.getModel().equals(subcategory.getModel())) {
						if (subCategoryDto.getHsnCode().equals(subcategory.getHsnCode())) {
							subcategory.setLastModifiedBy(principal.getName());
							subcategory.setLastModifiedDate(new Date());
							subcategory.setModel(subCategoryDto.getModel());
							subcategory.setHsnCode(subCategoryDto.getHsnCode());
							subcategory.setStatus(subCategoryDto.getStatus());
							subcategory.setSubCategory(subCategoryDto.getSubCategory());
							category = categoryRepository.findByCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

							category.setCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

							subcategory.setCategory(category);
						} else {
							/*List<InventoryAssign> inventoryAssignList=subcategory.getInventoryAssign();
			           		 if(inventoryAssignList.size() > 0)
			           		 {
			           			 throw new Exception(InventoryConstant.THIS_SUB_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
			           		 }*/
							subcategory = subCategoryRepository.findByHsnCode(subCategoryDto.getHsnCode());
							if (subcategory != null) {
								throw new Exception(InventoryConstant.HSN_CODE_ALREADY_EXISTS);
							} else {
								subcategory = new SubCategory();
								subcategory.setId(subCategoryDto.getId());
								subcategory.setCreatedBy(subCategoryDto.getCreatedBy());
								subcategory.setCreationDate(
										MasterDateUtil.convertDateToString(subCategoryDto.getCreationDate()));
								subcategory.setLastModifiedBy(principal.getName());
								subcategory.setLastModifiedDate(new Date());
								subcategory.setModel(subCategoryDto.getModel());
								subcategory.setHsnCode(subCategoryDto.getHsnCode());
								subcategory.setStatus(subCategoryDto.getStatus());
								subcategory.setSubCategory(subCategoryDto.getSubCategory());
								category = categoryRepository.findByCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

								category.setCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

								subcategory.setCategory(category);
							}
						}
					} else {
						/*List<InventoryAssign> inventoryAssignList=subcategory.getInventoryAssign();
		           		 if(inventoryAssignList.size() > 0)
		           		 {
		           			 throw new Exception(InventoryConstant.THIS_SUB_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
		           		 }*/
						subcategory = new SubCategory();
						subcategory = subCategoryRepository.getModelAndfindByIdNotIn(subCategoryDto.getModel(),
								subCategoryDto.getId());
						if (subcategory != null) {
							throw new Exception(InventoryConstant.MODEL_ALREADY_EXISTS);
						} else {

							subcategory = subCategoryRepository.getHsnCodeAndfindByIdNotIn(subCategoryDto.getHsnCode(),
									subCategoryDto.getId());
							if (subcategory != null) {
								throw new Exception(InventoryConstant.HSN_CODE_ALREADY_EXISTS);
							} else {
								subcategory = new SubCategory();
								subcategory.setId(subCategoryDto.getId());
								subcategory.setCreatedBy(subCategoryDto.getCreatedBy());
								subcategory.setCreationDate(
										MasterDateUtil.convertDateToString(subCategoryDto.getCreationDate()));
								subcategory.setLastModifiedBy(principal.getName());
								subcategory.setLastModifiedDate(new Date());
								subcategory.setModel(subCategoryDto.getModel());
								subcategory.setHsnCode(subCategoryDto.getHsnCode());
								subcategory.setStatus(subCategoryDto.getStatus());
								subcategory.setSubCategory(subCategoryDto.getSubCategory());
								category = categoryRepository.findByCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

								category.setCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

								subcategory.setCategory(category);
							}
						}
					}
				} else {
					
				/*	List<InventoryAssign> inventoryAssignList=subcategory.getInventoryAssign();
           		 if(inventoryAssignList.size() > 0)
           		 {
           			 throw new Exception(InventoryConstant.THIS_SUB_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
           		 }*/
					subcategory = new SubCategory();
					subcategory = subCategoryRepository.getSubCategoryAndfindByIdNotIn(subCategoryDto.getSubCategory(),
							subCategoryDto.getId());
					if (subcategory != null) {
						throw new Exception(InventoryConstant.SUB_CATEGORY_EXISTS);
					} else {
						subcategory = subCategoryRepository.getModelAndfindByIdNotIn(subCategoryDto.getModel(),subCategoryDto.getId());
						if (subcategory != null) {
							throw new Exception(InventoryConstant.MODEL_ALREADY_EXISTS);
						} else {
							subcategory = subCategoryRepository.getHsnCodeAndfindByIdNotIn(subCategoryDto.getHsnCode(),
									subCategoryDto.getId());
							if (subcategory != null) {
								throw new Exception(InventoryConstant.HSN_CODE_ALREADY_EXISTS);
							} else {
								subcategory = new SubCategory();
								subcategory.setId(subCategoryDto.getId());
								subcategory.setCreatedBy(subCategoryDto.getCreatedBy());
								subcategory.setCreationDate(
										MasterDateUtil.convertDateToString(subCategoryDto.getCreationDate()));
								subcategory.setLastModifiedBy(principal.getName());
								subcategory.setLastModifiedDate(new Date());
								subcategory.setModel(subCategoryDto.getModel());
								subcategory.setHsnCode(subCategoryDto.getHsnCode());
								subcategory.setStatus(subCategoryDto.getStatus());
								subcategory.setSubCategory(subCategoryDto.getSubCategory());
								category = categoryRepository.findByCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

								category.setCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

								subcategory.setCategory(category);
							}
						}
					}
				}
			}
		}

		else {
			subcategory = subCategoryRepository.findBySubCategory(subCategoryDto.getSubCategory());
			if (subcategory != null) {
				throw new Exception(InventoryConstant.SUB_CATEGORY_EXISTS);
			}

			subcategory = subCategoryRepository.findByModel(subCategoryDto.getModel());
			if (subcategory != null) {
				throw new Exception(InventoryConstant.MODEL_ALREADY_EXISTS);
			}

			subcategory = subCategoryRepository.findByHsnCode(subCategoryDto.getHsnCode());
			if (subcategory != null) {
				throw new Exception(InventoryConstant.HSN_CODE_ALREADY_EXISTS);
			}
			subcategory = new SubCategory();
			subcategory.setId(subCategoryDto.getId());
			subcategory.setCreatedBy(principal.getName());
			subcategory.setCreationDate(new Date());
			subcategory.setLastModifiedBy(principal.getName());
			subcategory.setLastModifiedDate(new Date());
			subcategory.setModel(subCategoryDto.getModel());
			subcategory.setHsnCode(subCategoryDto.getHsnCode());
			subcategory.setStatus(InventoryConstant.ACTIVE);
			subcategory.setSubCategory(subCategoryDto.getSubCategory());

			category = categoryRepository.findByCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

			category.setCategoryType(subCategoryDto.getCategoryDto().getCategoryType());

			subcategory.setCategory(category);

			subcategory = subCategoryRepository.save(subcategory);

			if (subcategory != null) {
				status = InventoryConstant.SUCCESS;
			}
		}

		subcategory = subCategoryRepository.save(subcategory);

		if (subcategory != null) {
			status = InventoryConstant.SUCCESS;
		}

		return status;
	}

}
