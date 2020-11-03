package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.ELCPDto;
import com.fa.inventory.entity.ELCB;

public interface ELCBService {

	List<ELCPDto> getAllELCB(Principal principal);

	String saveELCB(ELCPDto elcpDto, Principal principal) throws Exception;

	ELCPDto mapELCBDto(ELCB eLCBList);
	
	List<ELCPDto> getLastOneMonthOfficeElcbStatus();
	
	List<ELCPDto> getLastOneMonthUserElcbStatus(Principal principal);

}
