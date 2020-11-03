package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.ServiceInspectionDto;
import com.fa.inventory.dto.ServiceTrackerDto;
import com.fa.inventory.entity.ServiceTracker;

public interface ServiceTrackerService {
	

	ServiceTrackerDto mapServiceTrackerDtoById(ServiceTracker serviceTracker);

	List<?> getAllService(Principal principal);

	List<?> saveServiceDispatch(Principal principal);

	/** GET ALL ServiceInspection  */
	List<ServiceInspectionDto> getAllServiceInspection(Principal principal) throws Exception;

	ServiceTrackerDto findOne(Long id, Principal principal);
	
	List<?> getAllServiceDueDate(Principal principal);
	
	List<?> getAllServiceDueDateForAllRole(Principal principal);

	List<?> getAllUserServiceDueDate(Principal principal);
	
	List<?> getAllWareHouseServiceDueDate(Principal principal);
}
