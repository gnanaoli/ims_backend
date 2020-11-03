package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.ServiceInspectionDto;
import com.fa.inventory.dto.ServiceTrackerDto;

public interface ServiceInpectionService {

	/** GET ALL ServiceInspection */
	List<ServiceInspectionDto> getAllServiceInspection(Principal principal) throws Exception;

	String VerifyandApproveServiceInspection(ServiceInspectionDto serviceInspectionDto, Principal principal);

	ResponseDto receiveServiceTools(ServiceTrackerDto serviceTrackerDto, Principal principal, HttpSession session)
			throws Exception;

}
