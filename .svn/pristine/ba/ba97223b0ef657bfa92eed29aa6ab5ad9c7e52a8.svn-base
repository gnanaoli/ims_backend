package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ServiceTrackerDto;
import com.fa.inventory.entity.InventoryRequest;

public interface ToolsRequestService {

	//String saveToolsRequest(InventoryEntranceDto inventoryEntranceDto, Principal principal);

	//String saveToolsRequest(InventoryRequestDto InventoryRequestDto, Principal principal);

	String saveToolsRequest(InventoryRequestDto inventoryRequestDto, Principal principal);

	/** Get Sequence for Reference no */	
	String getRefNoSequence();
	

	//List<?> getUserToolsRequest(Principal principal);
	//List<InventoryRequestDto> InventoryRequestDtoList(Principal principal);
	//List<ResponseDto> getUserToolsRequest(Principal principal);

List<?> getUserToolsRequest(Principal principal);

InventoryRequestDto getToolsRequestById(String id, Principal principal);

String saveAcceptToolsRequest(InventoryRequestDto inventoryRequestDto, Principal principal)throws Exception;

//String saveMoveTools(InventoryRequestDto inventoryRequestDto, Principal principal)throws Exception;

//String saveAcceptToolsRequest(InventoryRequestDto inventoryRequestDto, Principal principal,Authentication authentication);

InventoryRequestDto mapInventoryRequestDtoById(InventoryRequest inventoryRequest);

String saveMoveTools(ServiceTrackerDto serviceTrackerDto, Principal principal) throws Exception;
	
}
