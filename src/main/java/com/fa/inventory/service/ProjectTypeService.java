package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.ProjectDto;

public interface ProjectTypeService {

	List<ProjectDto> getAllProjectType(Principal principal);

	String saveProjectType(ProjectDto projectDto, Principal principal) throws Exception;

}
