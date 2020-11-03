package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.FindToolsDto;
import com.fa.inventory.dto.InventoryAssignDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.dto.WareHouseBlocksDto;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.InventoryEntrance;

public interface InventoryManagementService {

	List<InventoryEntranceDto> getAllInventoryManagementList(Principal principal);

	String saveInventoryManagement(InventoryEntranceDto inventoryEntranceDto,Principal principal) throws Exception;

	InventoryEntranceDto getInventoryById(String id, Principal principal);

	List<InventoryEntranceDto> findtools(FindToolsDto findToolsDto, Principal principal);

	InventoryEntranceDto getInventoryFromAssignById(String id, Principal principal);
	
	List<ProjectDto> getCurrentUserProjectDtoList(Principal principal);

	InventoryAssignDto getInventoryAssignById(String id, Principal principal);
	
	InventoryEntranceDto mapInventoryDtoById(InventoryEntrance inventoryEntrance);
	
	List<InventoryAssign> saveInventoryAssignManagement(InventoryEntrance inventoryEntrance,InventoryEntranceDto inventoryEntranceDto, Principal principal);
	
	InventoryAssign mapInventoryAssignEntity(InventoryAssign inventoryAssign,InventoryEntranceDto inventoryEntranceDto,Principal principal);
	
	List<InventoryEntranceDto> getCurrentUserInventoryAssign(Principal principal);

	ResponseDto moveRequestAsUserSpecified(InventoryRequestDto inventoryRequestDto, Principal principal,String constant) throws Exception;

	ResponseDto moveInventory(InventoryRequestDto inventoryRequestDto, Principal principal)throws Exception;

	List<InventoryRequestDto> getMoveRequestNotifications(Principal principal);

	InventoryRequestDto getInventoryRequestById(String id, Principal principal);

	String confirmMoveRequestedInventory(InventoryRequestDto inventoryRequestDto, Principal principal);
	
	String confirmMoveInventory(InventoryRequestDto inventoryRequestDto, Principal principal) throws Exception;

	String editInventoryManagement(InventoryEntranceDto inventoryEntranceDto, Principal principal);
	
	String assignInventoryStockToProject(InventoryEntranceDto inventoryEntranceDto,Principal principal);

	List<InventoryEntranceDto> getAllInventoryManagementFromStockForAssign(Principal principal);
	
	List<WareHouseBlocksDto> getAllWareHouseBlocksNamesByWareHouseName(String wareHouseName);
	
	
	InventoryEntranceDto mapInventoryDto(InventoryEntrance inventoryEntrance);

	List<InventoryRequestDto> getAllMyRequest(Principal principal);
	
	List<InventoryEntranceDto> getInventoryAssignByChallanNo(String challanNo,Principal principal);
	
	String getInventoryNumber();

	//List<UserDto> getAssignedUsersListForTheProject(Principal principal);

	List<UserDto> getAssignedUsersListForTheProject(InventoryRequestDto inventoryRequestDto,Principal principal);

	ResponseDto moveInventoryByWarehouseAdmin(InventoryRequestDto inventoryRequestDto, Principal principal) throws Exception;

	List<?> getCurrentUserNonClosedProjectDtoList(Principal principal);

	

	

}
