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
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.SubCategory;
import com.fa.inventory.repository.CategoryRepository;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.service.CategoryService;
import com.fa.inventory.service.SubCategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
        protected final Logger logger = Logger.getLogger(ProjectServiceImpl.class);        
                        @Resource
                        CategoryRepository categoryRepository;
                        
                        @Resource
                        SubCategoryService subCategoryService;
                        @Resource
                        InventoryAssignRepository inventoryAssignRepository;
                        
                        
                        /*FOR GET VALUE TO CATEGORY TABLE*/
                         @Override
                        public List<CategoryDto> getCategoryList(Principal principal) {
                                List<CategoryDto> categoryDtoList = null;
                                logger.info("<--Category Service impl-------------getCategoryList--------------------started-->");
                                try {
                                        List<Category> categorylist=categoryRepository.findAll();
                                        
                                        if(categorylist!=null && !categorylist.isEmpty())
                                        {
                                                categoryDtoList=new ArrayList<>();
                                                for(int i=0;i<categorylist.size();i++)
                                                {
                                                        Category category=categorylist.get(i);
                                                        if(category!=null)
                                                        {
                                                                categoryDtoList.add(MapCategoryDto(category,principal));
                                                                
                                                        }
                                                }
                                        }
                                        
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                                logger.info("<--CategoryServiceImpl-------------getCategoryList--------------------Ended-->");
                                return categoryDtoList;
                        }
                        
                        
                        public CategoryDto MapCategoryDto(Category category,Principal principal)
                        {
                                logger.info("<--CategoryServiceImpl-------------MapCategoryDto--------------------started-->");
                                CategoryDto categoryDto=new CategoryDto();
                                try {
                                        
                                        /*categoryDto.setId(category.getId());
                                        categoryDto.setCategoryType(category.getCategoryType());
                                        categoryDto.setCategoryCode(category.getCategoryCode());
                                        categoryDto.setAssetTracking(category.getAssetTracking());
                                        categoryDto.setStatus(category.getStatus());*/
                                        categoryDto.setId(category.getId());
                                        categoryDto.setCategoryType(category.getCategoryType());
                                        categoryDto.setCategoryCode(category.getCategoryCode());
                                        categoryDto.setAssetTracking(category.getAssetTracking());
                                        categoryDto.setStatus(category.getStatus());
                                        categoryDto.setCreatedBy(category.getCreatedBy());
                                        categoryDto.setCreationDate(MasterDateUtil.convertDateToString(category.getCreationDate()));
                        
                                        
                                } catch (Exception e) {
                                       
                                        e.printStackTrace();
                                }
                                logger.info("<--CategoryServiceImpl-------------MapCategoryDto--------------------ended-->");
                                return categoryDto;
                        }
                        
/*FOR SAVE THE CATEGORY*/
                        
                        @Override
                        public String saveCategory(CategoryDto categoryDto,Principal principal) throws Exception {
                                String status=InventoryConstant.FAILURE;
                        
                                        
                                        logger.info("<--CategoryeServiceImpl-------------saveCategory--------------------started-->");
                                        
                                                Category category=new Category();
                                                if(categoryDto!=null && categoryDto.getId()!=null){
                                                 category=categoryRepository.findOne(categoryDto.getId());
                                                 if(category.getInventoryStock().size()>0)
                                               		
                                        		 {
                                        			 throw new Exception(InventoryConstant.THIS_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
                                        		 }
                                                 if(category.getCategoryType().equalsIgnoreCase(categoryDto.getCategoryType()))
                                                 {
                                                	 if(category.getCategoryCode().equalsIgnoreCase(categoryDto.getCategoryCode()))
                                                	 {	
                                                		 category.setId(categoryDto.getId());
                                                		 category.setCreatedBy(categoryDto.getCreatedBy());
                                                         category.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(categoryDto.getCreationDate()));
                                                         
                                                         category.setCategoryType(categoryDto.getCategoryType());
                                                         category.setCategoryCode(categoryDto.getCategoryCode());
                                                         category.setAssetTracking(categoryDto.getAssetTracking());
                                                         
                                                            //category.setStatus(InventoryConstant.ACTIVE); 
                                                         category.setStatus(categoryDto.getStatus());    
                                                         category.setLastModifiedBy(principal.getName());
                                                             category.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                                             //category.setStatus(categoryDto.status);
                                                		 
                                                	 }else{
                                                		 
                                                		 /*List<InventoryAssign> inventoryAssignList=category.getInventoryAssign();
                                                		 if(inventoryAssignList.size()>0)
                                                		 {
                                                			 throw new Exception(InventoryConstant.THIS_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
                                                		 }
                                                		 if(category.getInventoryAssign().size()>0)
                                                      		
                                                		 {
                                                			 throw new Exception(InventoryConstant.THIS_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
                                                		 }*/
                                                		 
                                                		 Category category1=new Category();
                                                		 category1=categoryRepository.findByCategoryCode(categoryDto.getCategoryCode());
                                                		 if(category1!=null){
                                                			 throw new Exception(InventoryConstant.THIS_CATEGORY_CODE_ALREADY_EXIST);
                                                		 } else{
                                                			// category=new Category();
                                                			category.setId(categoryDto.getId());
                                                			 category.setCreatedBy(categoryDto.getCreatedBy());
                                                             category.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(categoryDto.getCreationDate()));
                                                             
                                                             category.setCategoryType(categoryDto.getCategoryType());
                                                             category.setCategoryCode(categoryDto.getCategoryCode());
                                                            category.setAssetTracking(categoryDto.getAssetTracking());
                                                            category.setStatus(InventoryConstant.ACTIVE); 
                                                                 category.setLastModifiedBy(principal.getName());
                                                                 category.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                                			 
                                                			 
                                                          		 }
                                                	 }
                                                    }
                                                
                                                 else{
                                                	 List<InventoryAssign> inventoryAssignList=category.getInventoryAssign();
                                            		// if(inventoryAssignList!=null)
                                                	 if(inventoryAssignList.size()>0)
                                            		 {
                                            			 throw new Exception(InventoryConstant.THIS_CATEGORY_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT); 
                                            		 }
                                                	 Category category1=new Category();
                                                	 category1=categoryRepository.findByCategoryType(categoryDto.getCategoryType());
                                                	 if(category1!=null){
                                            			 throw new Exception(InventoryConstant.THIS_CATEGORY_ALREADY_EXIST);
                                            		 }		
                                                	 category1=new Category();
                                                	 category1=categoryRepository.getCategoryCodeExceptNotInGivenId(categoryDto.getId(),categoryDto.getCategoryCode());
                                            			 //category=categoryRepository.findByCategoryCode(categoryDto.getCategoryCode());
                                                		 if(category1!=null){
                                                			 throw new Exception(InventoryConstant.THIS_CATEGORY_CODE_ALREADY_EXIST);
                                                		 } else{
                                                			 //category=new Category();
                                                			 
                                                			 category.setId(categoryDto.getId());
                                                			 category.setCreatedBy(categoryDto.getCreatedBy());
                                                             category.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(categoryDto.getCreationDate()));
                                                             
                                                             category.setCategoryType(categoryDto.getCategoryType());
                                                             category.setCategoryCode(categoryDto.getCategoryCode());
                                                             category.setAssetTracking(categoryDto.getAssetTracking());
                                                             category.setStatus(InventoryConstant.ACTIVE); 
                                                                 category.setLastModifiedBy(principal.getName());
                                                                 category.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                                		 }
                                            			 
                                            		
                                              
                                                 }
                                                }
                                                else {
                                                	 Category category1=new Category();
                                                	category1=categoryRepository.findByCategoryType(categoryDto.getCategoryType());
                                               	 if(category1!=null){
                                           			 throw new Exception(InventoryConstant.THIS_CATEGORY_ALREADY_EXIST);
                                           		 }
                                               	 
                                               	category1=categoryRepository.findByCategoryCode(categoryDto.getCategoryCode());
                                       		 if(category1!=null){
                                       			 throw new Exception(InventoryConstant.THIS_CATEGORY_CODE_ALREADY_EXIST);
                                   		 }			category=new Category();
                                                	 category.setCreationDate(new Timestamp(new Date().getTime()));
                                                     category.setCreatedBy(principal.getName());
                                                     category.setCategoryType(categoryDto.getCategoryType());
                                                     category.setCategoryCode(categoryDto.getCategoryCode());
                                                     category.setAssetTracking(categoryDto.getAssetTracking());
                                                     category.setStatus(InventoryConstant.ACTIVE);  
                                                     category.setLastModifiedBy(principal.getName());
                                                     category.setLastModifiedDate(new Timestamp(new Date().getTime()));
                                   		
                                                	
                                                }
                                                 category=categoryRepository.save(category);
                                                 if(category!=null){
                                                status=InventoryConstant.SUCCESS;
                                        }
                                        
                               
                                        logger.info("<--CategoryeServiceImpl-------------saveCategory--------------------ended-->");
                                return status;
                        }
                        /*FOR GET VALUE OF EDIT CATEGORY*/
                        
                        @Override
                        public CategoryDto getCategory(String id,Principal principal) {
                                CategoryDto categoryDto = null;
                                logger.info("<--CategoryServiceImpl-------------getCategory--------------------started-->"); 
                                try{
                                Category category = categoryRepository.findOne(Long.valueOf(id));                        
                                        if (null != category) {
                                                categoryDto=new CategoryDto();
                                                categoryDto.setId(category.getId());
                                                categoryDto.setCategoryType(category.getCategoryType());
                                                categoryDto.setCategoryCode(category.getCategoryCode());
                                                categoryDto.setAssetTracking(category.getAssetTracking());
                                                categoryDto.setStatus(category.getStatus());
                                                categoryDto.setCreatedBy(category.getCreatedBy());
                                                categoryDto.setCreationDate(MasterDateUtil.convertDateToString(category.getCreationDate()));
                                
                                        }
                                
                        }catch (Exception e) {
                                e.printStackTrace();
                        }logger.info("<--CategoryServiceImpl-------------getCategory--------------------Ended-->");
                                return categoryDto;
                        }

                        /*FOR CATEGORY DROPDOWN*/
                        
                        @Override
                        public List<CategoryDto> getAllActiveCategoryList(Principal principal) {
                                List<CategoryDto> categoryDtoList = null;
                                logger.info("<--CategoryServiceImpl-------------getcategoryList--------------------started-->");
                                try {
                                        List<Category> categoryList=categoryRepository.findByStatus(InventoryConstant.ACTIVE);
                                        
                                        if(categoryList!=null && !categoryList.isEmpty())
                                        {
                                                categoryDtoList=new ArrayList<>();
                                                for(int i=0;i<categoryList.size();i++)
                                                {
                                                        Category category=categoryList.get(i);
                                                        if(category!=null)
                                                        {
                                                                categoryDtoList.add(MapCategoryDto(category,principal));
                                                                
                                                        }
                                                }
                                        }
                                        
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                                logger.info("<--CategoryServiceImpl-------------getcategoryList--------------------Ended-->");
                                return categoryDtoList;
                        }
                        
                        @Override
                    	public List<SubCategoryDto> getSubCategoryByCategoryList(String categoryType) {
                        	logger.info("<--CategoryServiceImpl-------------getSubCategoryByCategoryList--------------------started-->");
                    		List<SubCategoryDto> subCategoryDtoList=new ArrayList<>();
                    		List<SubCategory> subCategoryList=null;
                    		try {
                    			Category category=categoryRepository.findByCategoryTypeAndStatus(categoryType,InventoryConstant.ACTIVE);
                    			
                    			if(category!=null)
                    			{
                    				subCategoryList=category.getSubCategory();
                    				if(subCategoryList!=null && !subCategoryList.isEmpty())
                    				{
                    					for(int i=0;i<subCategoryList.size();i++)
                        				{
                    						SubCategory subCategory=subCategoryList.get(i);
                    						if(subCategory!=null)
                    						{
                    							subCategoryDtoList.add(subCategoryService.mapSubCategoryDto(subCategory));
                    						}
                        				}
                    				}
                    				
                    				
                    			}
                    			
                    			
                    		} catch (Exception e) {
                    			e.printStackTrace();
                    		}
                    		logger.info("<--CategoryServiceImpl-------------getSubCategoryByCategoryList--------------------ended-->");
                    		return subCategoryDtoList;
                    	}



}
