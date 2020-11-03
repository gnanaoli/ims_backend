package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.SafetyStatusDto;

public interface SafetyService {

	List<SafetyStatusDto> getAllSafetyStatus(Principal principal);

	String saveSafetyStatus(SafetyStatusDto safetyStatusDto, Principal principal) throws Exception;

}
