package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.entity.Category;
import com.fa.inventory.entity.InventoryRequest;
import com.fa.inventory.entity.SubCategory;
import com.fa.inventory.repository.CategoryRepository;
import com.fa.inventory.repository.InventoryRequestRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.SubCategoryRepository;
import com.fa.inventory.service.BulkToolsService;
import com.fa.inventory.service.ToolsRequestService;

@Service
public class BulkToolsServiceImpl implements BulkToolsService {
	
	@Resource
	InventoryRequestRepository inventoryRequestRepository;
	
	@Resource
	CategoryRepository categoryRepository;
	
	@Resource
	SubCategoryRepository subCategoryRepository;

	@Resource
	InventoryStockRepository inventoryStockRepository;
	
	@Resource
	ToolsRequestService toolsRequestService;
	
	@Override
	public ResponseDto saveBulkRequest(List<CategoryDto> categoryDtoList,Principal principal) {
		ResponseDto responseDto=new ResponseDto();
		try {
			String refNo = toolsRequestService.getRefNoSequence();
			responseDto.setNumber(refNo);
			if(categoryDtoList!=null)
			{
				for(int i=0;i<categoryDtoList.size();i++)
				{
				
					CategoryDto categoryDto=categoryDtoList.get(i);
					if(categoryDto!=null)
					{
						System.out.println("QUANTITY"+categoryDto.getQuantity());
						
						InventoryRequest inventoryRequest = new InventoryRequest();
						if(categoryDto.getId()!=null)
						{
							Category category=categoryRepository.findOne(categoryDto.getId());
							if(category!=null)
							{
								if(categoryDto.getQuantity()!=null)
								{
//									inventoryRequest.setAcceptedQuantity(Integer.valueOf(categoryDto.getQuantity()));
									inventoryRequest.setActionBy(principal.getName());
									inventoryRequest.setActionDate(new Date());
									inventoryRequest.setComments("");
									inventoryRequest.setExpectedDateToReach(new Date());
									inventoryRequest.setQuantity(Integer.valueOf(categoryDto.getQuantity()));
									inventoryRequest.setRaisedBy(principal.getName());
									inventoryRequest.setRaisedDate(new Date());
									inventoryRequest.setExpectedDateToReach(MasterDateUtil.convertStringToDateWithoutTime(categoryDto.getExceptDate()));
									inventoryRequest.setReferenceNo(refNo);
									inventoryRequest.setRequestedFrom(categoryDto.getProjectName());									
									inventoryRequest.setStatus(InventoryConstant.BULK_REQUESTED);
									inventoryRequest.setSubStatus(InventoryConstant.NEW_TOOLS_REQUEST);
									inventoryRequest.setRequestedTo(InventoryConstant.EVERYONE);
									inventoryRequest.setLocation(InventoryConstant.ALL);
									inventoryRequest.setNotificationLink(InventoryConstant.TOOLSREQUESTVIEW);
									inventoryRequest.setNotificationStatus(InventoryConstant.NEW);
								}
								inventoryRequest.setCategory(category);
							}
							
						}
						if(categoryDto.getSubCategoryitem()!=null)
						{
							for(int j=0;j<categoryDto.getSubCategoryitem().size();j++)
							{
								SubCategoryDto subCategoryDto=categoryDto.getSubCategoryitem().get(j);
								
								if(subCategoryDto!=null)
								{
									SubCategory subCategory=subCategoryRepository.findOne(subCategoryDto.getId());
									if(subCategory!=null)
									{
										inventoryRequest.setSubCategory(subCategory);
										inventoryRequest.setModelCode(subCategory.getModel());
									}
									if(subCategoryDto.getModel()!=null)
									{
//										InventoryEntrance inventoryEntrance=inventoryStockRepository.findByModelcode(subCategoryDto.getModel());
//										if(inventoryEntrance!=null)
//										{
//											inventoryRequest.setInventoryEntrance(inventoryEntrance);
//										}
									}
									
								}
								   
								
							}
							
						}
						inventoryRequest=inventoryRequestRepository.save(inventoryRequest);
					}
					
				}
				responseDto.setStatus(InventoryConstant.SUCCESS);
			}
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return responseDto;
	}



}
