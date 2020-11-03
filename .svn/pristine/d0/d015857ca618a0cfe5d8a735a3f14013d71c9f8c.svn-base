package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ResponseDto;

public interface InventoryRequestService {

	List<InventoryRequestDto> getAllInspectionDetails(Principal principal) throws Exception;

	String approveInspection(InventoryRequestDto requestDto, Principal principal) throws Exception;

	String verifyInspection(InventoryRequestDto requestDto, Principal principal) throws Exception;
	
	
	List<InventoryRequestDto> getNotificationData(Principal principal);

	ResponseDto updateNotificationStatus(InventoryRequestDto inventoryRequestDto, Principal principal);
	
  

}
