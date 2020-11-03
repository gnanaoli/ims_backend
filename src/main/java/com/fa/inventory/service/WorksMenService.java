package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.WorksMenCategoryDto;
import com.fa.inventory.dto.WorksMenDetailsDto;
import com.fa.inventory.entity.WorksMenDetails;

public interface WorksMenService {


	List<WorksMenDetailsDto> getAllWorksmenDetails(Principal principal);

	List<WorksMenCategoryDto> getAllWorksmenCategory(Principal principal);

	String saveWorksMenDetails(List<WorksMenDetailsDto> worksMenDetailsDtolist, Principal principal) throws Exception;

	String saveWorksMenCategory(WorksMenCategoryDto worksMenCategoryDto, Principal principal) throws Exception;

	WorksMenDetailsDto mapWorksMenDto(WorksMenDetails worksMenDetails);

}
