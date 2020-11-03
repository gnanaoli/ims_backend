package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.InventoryEntranceDto;

public interface DashBoardService {
	
	List<InventoryEntranceDto> getInventoryCountFromSpecificUserProject(Principal principal);
	
	List<InventoryEntranceDto> getInventoryCountForWareHouseAdministrator(Principal principal);
	
	
	List<InventoryEntranceDto> getInventoryCountForOfficeAdministratorFromStock(Principal principal);
	
	List<InventoryEntranceDto> getInventoryCountForOfficeAdministratorFromAssign(Principal principal);
	
	
}
