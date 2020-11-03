package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.service.DashBoardService;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.UserManagementService;

@Service
public class DashBoardServiceImpl implements DashBoardService {
	
	@Resource
	InventoryManagementService inventoryManagementService;
	
	@Resource
	InventoryAssignRepository inventoryAssignRepository;
	
	@Resource
	InventoryStockRepository inventoryStockRepository;
	
	@Resource
	UserManagementService userManagementService;

	protected final Logger logger = Logger.getLogger(DashBoardServiceImpl.class);
	
	
	
	/**
	 * 
	 * this method is used for dashboard to fetch inventory count for role type USER
	 * 
	 * **/
	@Override
	public List<InventoryEntranceDto> getInventoryCountFromSpecificUserProject(Principal principal) {
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountFromAllProject--------------------started-->");
		List<InventoryEntranceDto> inventoryEntranceDtosList=new ArrayList<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.USER) || r.getAuthority().equals(InventoryConstant.SUPER_USER) || r.getAuthority().equals(InventoryConstant.ENQUIRY));
		
		if(hasUserRole)
		{
			List<ProjectDto> projectDtoList=inventoryManagementService.getCurrentUserProjectDtoList(principal);
			
			if(projectDtoList!=null && !projectDtoList.isEmpty())
			{
				for(int i=0;i<projectDtoList.size();i++)
				{
				ProjectDto projectDto=projectDtoList.get(i);
				
				if(projectDto!=null)
				{
						Object inventoryCountList=inventoryAssignRepository.getInventoryCountFromSpecificUserProject(projectDto.getName());
						if(inventoryCountList!=null)
						{
								if(inventoryCountList!=null)
								{
									Object[] objectArray=(Object[]) inventoryCountList;
									InventoryEntranceDto inventoryEntranceDto=new InventoryEntranceDto();
									inventoryEntranceDto.setSite(objectArray[0].toString());
									inventoryEntranceDto.setQuantity(Integer.valueOf(objectArray[1].toString()));
									inventoryEntranceDtosList.add(inventoryEntranceDto);
								}
						}
					}
				}
			}
		}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountFromAllProject--------------------started-->");
		return inventoryEntranceDtosList;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * this method is used for dashboard to fetch inventory count for role type WAREHOUSE ADMIN
	 * 
	 * **/
	@Override
	public List<InventoryEntranceDto> getInventoryCountForWareHouseAdministrator(Principal principal) {
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountForWareHouseAdministrator--------------------started-->");
		List<InventoryEntranceDto> inventoryEntranceDtosList=new ArrayList<>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR));
		
		if(hasUserRole)
		{
			 List<WareHouseDto> wareHouseDtoList=userManagementService.getCurrentUserWareHouseDtoList(principal);
			
			if(wareHouseDtoList!=null && !wareHouseDtoList.isEmpty())
			{
				for(int i=0;i<wareHouseDtoList.size();i++)
				{
				WareHouseDto wareHouseDto=wareHouseDtoList.get(i);
				
				if(wareHouseDto!=null)
				{
						Object inventoryCountList=inventoryStockRepository.getInventoryCountForSpecificWareHouseAdministrator(wareHouseDto.getWareHouseName());
						if(inventoryCountList!=null)
						{
								if(inventoryCountList!=null)
								{
									Object[] objectArray=(Object[]) inventoryCountList;
									InventoryEntranceDto inventoryEntranceDto=new InventoryEntranceDto();
									inventoryEntranceDto.setSite(objectArray[0].toString());
									inventoryEntranceDto.setQuantity(Integer.valueOf(objectArray[1].toString()));
									inventoryEntranceDtosList.add(inventoryEntranceDto);
								}
						}
					}
				}
			}
		}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountForWareHouseAdministrator--------------------started-->");
		return inventoryEntranceDtosList;
	}






	/**
	 * 
	 * this method is used for dashboard to fetch inventory count for role type OFFICE ADMINISTRATOR
	 * 
	 * This method will fetch from stock
	 * 
	 * **/
	@Override
	public List<InventoryEntranceDto> getInventoryCountForOfficeAdministratorFromStock(Principal principal) {
		
		List<InventoryEntranceDto> inventoryEntranceDtosList=new ArrayList<>();
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountForOfficeAdministratorFromStock--------------------started-->");
						List<Object> inventoryCountList=inventoryStockRepository.getAllInventoryCountFromAllWareHouse();
						for(int i=0;i<inventoryCountList.size();i++)
						{
							
							Object object=inventoryCountList.get(i);
								if(object!=null)
								{
									Object[] objectArray=(Object[]) object;
									InventoryEntranceDto inventoryEntranceDto=new InventoryEntranceDto();
									inventoryEntranceDto.setSite(objectArray[0].toString());
									inventoryEntranceDto.setQuantity(Integer.valueOf(objectArray[1].toString()));
									inventoryEntranceDtosList.add(inventoryEntranceDto);
								}
						}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountForOfficeAdministratorFromStock--------------------started-->");
		return inventoryEntranceDtosList;
	}
	
	
	/**
	 * 
	 * this method is used for dashboard to fetch inventory count for role type OFFICE ADMINISTRATOR
	 * 
	 * This method will fetch from Assign
	 * 
	 * **/
	@Override
	public List<InventoryEntranceDto> getInventoryCountForOfficeAdministratorFromAssign(Principal principal) {
		
		List<InventoryEntranceDto> inventoryEntranceDtosList=new ArrayList<>();
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountForOfficeAdministratorFromAssign--------------------started-->");
						List<Object> inventoryCountList=inventoryAssignRepository.getInventoryCountFromAllProject();
						for(int i=0;i<inventoryCountList.size();i++)
						{
							
							Object object=inventoryCountList.get(i);
								if(object!=null)
								{
									Object[] objectArray=(Object[]) object;
									InventoryEntranceDto inventoryEntranceDto=new InventoryEntranceDto();
									inventoryEntranceDto.setSite(objectArray[0].toString());
									inventoryEntranceDto.setQuantity(Integer.valueOf(objectArray[1].toString()));
									inventoryEntranceDtosList.add(inventoryEntranceDto);
								}
						}
		logger.info("<--InventoryManagementServiceImpl-------------getInventoryCountForOfficeAdministratorFromAssign--------------------started-->");
		return inventoryEntranceDtosList;
	}
	
	
	
}
