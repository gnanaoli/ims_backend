package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.CountryDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ProjectsTasksDto;

public interface ProjectService {
String saveProject(ProjectDto projectDto,Principal principal) throws Exception;
	
	
	List<ProjectDto> getprojectList(Principal principal);

	List<ProjectDto> getAllProjectDtoList();

	ProjectDto getProject(Long id, Principal principal);


	List<CountryDto> getAllCountryAndStatesAndProject();
	
	List<ProjectDto> getAllActiveProjectStatus();
	
	List<ProjectDto> getAllActiveProjectTypes();


	


	String saveProjectStatus(ProjectDto projectDto, Principal principal) throws Exception;


	


	List<ProjectDto> getAllProjectStatus(Principal principal);


	String saveProjectTasks(ProjectDto projectDto, Principal principal) throws Exception;


	List<?> viewProjectTaskList(ProjectDto projectDto);


	String getTaskIdSequence();


	List<?> getallhistoryoftask(ProjectsTasksDto projectsTaskDto, Principal principal);

}
