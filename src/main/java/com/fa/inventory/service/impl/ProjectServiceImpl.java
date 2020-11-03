package com.fa.inventory.service.impl;

import java.math.BigInteger;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.CityDto;
import com.fa.inventory.dto.CountryDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ProjectsTasksDto;
import com.fa.inventory.dto.StateDto;
import com.fa.inventory.entity.City;
import com.fa.inventory.entity.Country;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.ProjectStatus;
import com.fa.inventory.entity.ProjectTasks;
import com.fa.inventory.entity.ProjectType;
import com.fa.inventory.entity.State;
import com.fa.inventory.repository.CountryRepository;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.ProjectStatusRepository;
import com.fa.inventory.repository.ProjectTasksRepository;
import com.fa.inventory.repository.ProjectTypeRepository;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	protected final Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Resource
	ProjectRepository projectRepository;

	@Resource
	CountryRepository countryRepository;

	@Resource
	ProjectStatusRepository projectStatusRepository;

	@Resource
	ProjectTypeRepository projectTypeRepository;
	@Resource
	InventoryAssignRepository inventoryAssignRepository;

	@Resource
	ProjectTasksRepository projectTasksRepository;
	@Resource
	InventoryManagementService inventoryManagementService;

	@Override
	public List<ProjectDto> getprojectList(Principal principal) {
		List<ProjectDto> projectDtoList = null;
		logger.info("<--ProjectService-------------getProjectList--------------------started-->");
		try {
			List<Project> projectList = projectRepository.findAll();

			if (projectList != null && !projectList.isEmpty()) {
				projectDtoList = new ArrayList<>();
				for (int i = 0; i < projectList.size(); i++) {
					Project project = projectList.get(i);
					if (project != null) {

						Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
						boolean hasUserRole = authentication1.getAuthorities().stream()
								.anyMatch(r -> r.getAuthority().equals(InventoryConstant.USER) || r.getAuthority().equals(InventoryConstant.SUPER_USER) || r.getAuthority().equals(InventoryConstant.ENQUIRY));
						if (hasUserRole) {

							List<ProjectDto> projectDtoList1 = inventoryManagementService
									.getCurrentUserProjectDtoList(principal);

							if (projectDtoList1 != null && !projectDtoList1.isEmpty()) {
								for (int j = 0; j < projectDtoList1.size(); j++) {
									ProjectDto projectDto = projectDtoList1.get(j);
									if (projectDto != null
											&& projectDto.getName().equalsIgnoreCase(project.getName())) {
										projectDtoList.add(MapProjectDto(project, principal));
									}
								}

							}

						}
						Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
						boolean hasUserRole1 = authentication1.getAuthorities().stream()
								.anyMatch(r -> r.getAuthority().equals(InventoryConstant.OFFICE_ADMINISTRATOR)|| r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR));
						if (hasUserRole1) {

							projectDtoList.add(MapProjectDto(project, principal));
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ProjectService-------------getProjectList--------------------Ended-->");
		return projectDtoList;
	}

	public ProjectDto MapProjectDto(Project project, Principal principal) {
		logger.info("<--projectServiceImpl-------------MapProjectDto--------------------started-->");
		ProjectDto projectDto = new ProjectDto();
		try {
			projectDto.setId(project.getId());
			projectDto.setCustomerType(project.getCustomerType());
			projectDto.setName(project.getName());
			projectDto.setProjectInCharge(project.getProjectInCharge());
			projectDto.setProjectType(project.getProjectType());

			projectDto.setStartDate(MasterDateUtil.convertDateToString(project.getStartDate()));

			projectDto.setEndDate(MasterDateUtil.convertDateToString(project.getEndDate()));

			projectDto.setStatus(project.getStatus());
			projectDto.setAddress1(project.getAddress1());
			projectDto.setAddress2(project.getAddress2());
			projectDto.setAddress3(project.getAddress3());
			projectDto.setAreaLandmark(project.getAreaLandmark());
			projectDto.setCountryName(project.getCountryName());
			projectDto.setState(project.getState());
			projectDto.setCity(project.getCity());
			projectDto.setPinCode(Integer.toString(project.getPinCode()));
			projectDto.setCreatedBy(project.getCreatedBy());

			projectDto.setCreationDate(MasterDateUtil.convertDateToString(project.getCreationDate()));
			List<ProjectsTasksDto> projectsTaskDtoList = null;
			try {
				List<ProjectTasks> taskList = project.getProjectTaskList();

				if (taskList != null && !taskList.isEmpty()) {
					projectsTaskDtoList = new ArrayList<>();
					for (int i = 0; i < taskList.size(); i++) {
						ProjectTasks projectTask = taskList.get(i);
						if (projectTask != null && projectTask.getIsActive().equals(InventoryConstant.YES)) {

							projectsTaskDtoList.add(MapProjectTaskDto(projectTask,principal));

						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			projectDto.setProjectTasksDtoList(projectsTaskDtoList);

			// projectDto.setLastModifiedBy(principal.getName());
			// projectDto.setLastModifiedDate(project.getLastModifiedDate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("<--ProjectServiceImpl-------------MapProjectDto--------------------ended-->");
		return projectDto;
	}

	public ProjectsTasksDto MapProjectTaskDto(ProjectTasks projectTask, Principal principal) {
		ProjectsTasksDto projectsTasksDto = new ProjectsTasksDto();
		try {

			projectsTasksDto.setId(projectTask.getId());
			projectsTasksDto.setIsActive(projectTask.getIsActive());
			projectsTasksDto.setTaskName(projectTask.getTaskName());
			projectsTasksDto.setStartDate(MasterDateUtil.convertDateToString(projectTask.getStartDate()));
			projectsTasksDto.setEndDate(MasterDateUtil.convertDateToString(projectTask.getEndDate()));
			//projectsTasksDto.setAssignedTo(projectTask.getAssignedTo());
			projectsTasksDto.setResourceCount(Integer.toString(projectTask.getResourceCount()));
			projectsTasksDto.setComments(projectTask.getComments());
			projectsTasksDto.setDuration(Integer.toString(projectTask.getDuration()));
			projectsTasksDto.setStatus(projectTask.getStatus());
			;
			projectsTasksDto.setIsNew(projectTask.getIsNew());
			projectsTasksDto.setTaskId(projectTask.getTaskId());
		
			 
			   
			   Date date = java.sql.Date.valueOf(LocalDate.now());
			   //System.out.println(date);
			  // System.out.println(sdf.format(date));  
			   Date test= new Date();
			   	  test  = projectTask.getEndDate();
			  //System.out.println(test);
			  
			  
			  if(date.before(test)){
				  projectsTasksDto.setDaysRemaing(
						  Integer.toString((MasterDateUtil.getDifferenceDays(new Date(), projectTask.getEndDate()))));
				  
			  }
			  else{
				  projectsTasksDto.setDaysRemaing("0");
			  }
			
			projectsTasksDto.setCreatedBy(projectTask.getCreatedBy());
			projectsTasksDto.setCreationDate(MasterDateUtil.convertDateToStringWithTime(projectTask.getCreationDate()));
			projectsTasksDto.setLastModifiedBy(projectTask.getLastModifiedBy());
			projectsTasksDto
					.setLastModifiedDate(MasterDateUtil.convertDateToStringWithTime(projectTask.getLastModifiedDate()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectsTasksDto;
	}
	/*
	 * @Override public String saveProject(ProjectDto projectDto,Principal
	 * principal) { String status=InventoryConstant.FAILURE; logger.info(
	 * "<--ProjectServiceImpl-------------saveProject--------------------started-->"
	 * ); try { Project project=new Project(); if(projectDto!=null &&
	 * projectDto.getId()!=null){
	 * project=projectRepository.findOne(projectDto.getId());
	 * project.setCreatedBy(projectDto.getCreatedBy()); }
	 * project.setCustomerType(projectDto.getCustomerType());
	 * project.setName(projectDto.getName());
	 * project.setProjectType(projectDto.getProjectType());
	 * project.setStartDate(MasterDateUtil.convertStringToTimeStampDate(
	 * projectDto.getStartDate()));
	 * project.setEndDate(MasterDateUtil.convertStringToTimeStampDate(projectDto
	 * .getEndDate())); project.setStatus(projectDto.getStatus());
	 * project.setAddress1(projectDto.getAddress1());
	 * project.setAddress2(projectDto.getAddress2());
	 * project.setAddress3(projectDto.getAddress3());
	 * project.setAreaLandmark(projectDto.getAreaLandmark());
	 * project.setState(projectDto.getState());
	 * project.setCountryName(projectDto.getCountryName());
	 * project.setCity(projectDto.getCity());
	 * project.setPinCode(Integer.valueOf(projectDto.getPinCode()));
	 * project.setCreatedBy(principal.getName());
	 * project.setProjectInCharge(projectDto.getProjectInCharge());
	 * if(projectDto.getCreationDate()!=null){
	 * project.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(
	 * projectDto.getCreationDate())); }else { project.setCreationDate(new
	 * Timestamp(new Date().getTime())); }
	 * 
	 * project.setLastModifiedBy(principal.getName());
	 * project.setCountryName(projectDto.getCountryName());
	 * project.setLastModifiedDate(new Timestamp(new Date().getTime()));
	 * if(project!=null) { project=projectRepository.save(project);
	 * status=InventoryConstant.SUCCESS; }
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } logger.info(
	 * "<--ProjectService-------------saveProject--------------------Ended-->");
	 * return status; }
	 */

	@Override
	public String saveProject(ProjectDto projectDto, Principal principal) throws Exception {
		String status = InventoryConstant.FAILURE;
		Project project = new Project();
		logger.info("<--ProjectServiceImpl-------------saveProjectStatus--------------------started-->");

		if (projectDto != null && projectDto.getId() != null) {
			project = new Project();
			project = projectRepository.findOne(projectDto.getId());
			if (project.getName().equalsIgnoreCase(projectDto.getName())) {
				project.setId(projectDto.getId());
				project.setCreatedBy(projectDto.getCreatedBy());
				project.setCustomerType(projectDto.getCustomerType());
				project.setName(projectDto.getName());
				project.setProjectType(projectDto.getProjectType());
				project.setStartDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getStartDate()));
				project.setEndDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getEndDate()));
				project.setStatus(projectDto.getStatus());
				project.setAddress1(projectDto.getAddress1());
				project.setAddress2(projectDto.getAddress2());
				project.setAddress3(projectDto.getAddress3());
				project.setAreaLandmark(projectDto.getAreaLandmark());
				project.setState(projectDto.getState());
				project.setCountryName(projectDto.getCountryName());
				project.setCity(projectDto.getCity());
				project.setPinCode(Integer.valueOf(projectDto.getPinCode()));
				project.setCreatedBy(principal.getName());
				project.setProjectInCharge(projectDto.getProjectInCharge());
				project.setCustomerType("");
				if (projectDto.getCreationDate() != null) {
					project.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getCreationDate()));
				} else {
					project.setCreationDate(new Timestamp(new Date().getTime()));
				}

				project.setLastModifiedBy(principal.getName());
				project.setCountryName(projectDto.getCountryName());
				project.setLastModifiedDate(new Timestamp(new Date().getTime()));
				// project.setProjectTaskList(projectDto.getProjectTasksDtoList());

				List<ProjectTasks> projectTasksList = new ArrayList<>();
			

				List<ProjectsTasksDto> projectTaskDtoList = projectDto.getProjectTasksDtoList();
				if (projectTaskDtoList != null) {

					for (int i = 0; i < projectTaskDtoList.size(); i++) {
						ProjectsTasksDto projectsTasksDto = projectTaskDtoList.get(i);
						if (projectsTasksDto != null) {
							projectTasksList.add(MapProjectTasks(project, projectsTasksDto, principal));
						}
					}
					project.setProjectTaskList(projectTasksList);
				}
			} else {

				List<InventoryAssign> inventoryAssignList = inventoryAssignRepository
						.findByAssignedLocation(project.getName());
				if (inventoryAssignList.size() > 0) {
					throw new Exception(InventoryConstant.TOOLS_ASSIGN_TO_THE_PROJECT_CAN_NOT_BE_EDIT);
				}
				project = projectRepository.findByNameExceptThisId(projectDto.getId(), projectDto.getName());
				if (project != null) {
					throw new Exception(InventoryConstant.THIS_PROJECT_NAME_ALREADY_EXIST);
				} else {
					project = new Project();
					project.setId(projectDto.getId());
					project.setCreatedBy(projectDto.getCreatedBy());
					project.setCustomerType(projectDto.getCustomerType());
					project.setName(projectDto.getName());
					project.setProjectType(projectDto.getProjectType());
					project.setStartDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getStartDate()));
					project.setEndDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getEndDate()));
					project.setStatus(projectDto.getStatus());
					project.setAddress1(projectDto.getAddress1());
					project.setAddress2(projectDto.getAddress2());
					project.setAddress3(projectDto.getAddress3());
					project.setAreaLandmark(projectDto.getAreaLandmark());
					project.setState(projectDto.getState());
					project.setCountryName(projectDto.getCountryName());
					project.setCity(projectDto.getCity());
					project.setPinCode(Integer.valueOf(projectDto.getPinCode()));
					project.setCreatedBy(principal.getName());
					project.setProjectInCharge(projectDto.getProjectInCharge());
					project.setCustomerType("");
					if (projectDto.getCreationDate() != null) {
						project.setCreationDate(
								MasterDateUtil.convertStringToTimeStampDate(projectDto.getCreationDate()));
					} else {
						project.setCreationDate(new Timestamp(new Date().getTime()));
					}

					project.setLastModifiedBy(principal.getName());
					project.setCountryName(projectDto.getCountryName());
					project.setLastModifiedDate(new Timestamp(new Date().getTime()));

					List<ProjectTasks> projectTasksList = new ArrayList<>();
					List<ProjectsTasksDto> projectTaskDtoList = projectDto.getProjectTasksDtoList();
					if (!projectTaskDtoList.isEmpty() && projectTaskDtoList !=null) {

						for (int i = 0; i < projectTaskDtoList.size(); i++) {
							ProjectsTasksDto projectsTasksDto = projectTaskDtoList.get(i);
							if (projectsTasksDto != null) {
								projectTasksList.add(MapProjectTasks(project, projectsTasksDto, principal));
							}
						}
						project.setProjectTaskList(projectTasksList);
					}
					
					project.setProjectTaskList(projectTasksList);

				}
			}

		} else {

			project = projectRepository.findByName(projectDto.getName());
			if (project != null) {
				throw new Exception(InventoryConstant.THIS_PROJECT_NAME_ALREADY_EXIST);
			} else {
				project = new Project();

				project.setCustomerType(projectDto.getCustomerType());
				project.setName(projectDto.getName());
				project.setProjectType(projectDto.getProjectType());
				project.setStartDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getStartDate()));
				project.setEndDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getEndDate()));
				project.setStatus(projectDto.getStatus());
				project.setAddress1(projectDto.getAddress1());
				project.setAddress2(projectDto.getAddress2());
				project.setAddress3(projectDto.getAddress3());
				project.setAreaLandmark(projectDto.getAreaLandmark());
				project.setState(projectDto.getState());
				project.setCountryName(projectDto.getCountryName());
				project.setCity(projectDto.getCity());
				project.setPinCode(Integer.valueOf(projectDto.getPinCode()));
				project.setCreatedBy(principal.getName());
				project.setProjectInCharge(projectDto.getProjectInCharge());
				project.setCreatedBy(principal.getName());
				project.setCreationDate(new Timestamp(new Date().getTime()));

				project.setLastModifiedBy(principal.getName());
				project.setCountryName(projectDto.getCountryName());
				project.setLastModifiedDate(new Timestamp(new Date().getTime()));
				if (projectDto.getProjectTasksDtoList()!=null) {
					List<ProjectTasks> projectTasksList = new ArrayList<>();
					List<ProjectsTasksDto> projectTaskDtoList = projectDto.getProjectTasksDtoList();
					for (int i = 0; i < projectTaskDtoList.size(); i++) {
						ProjectsTasksDto projectsTasksDto = projectTaskDtoList.get(i);
						if (projectsTasksDto != null) {
							projectTasksList.add(MapProjectTasks(project, projectsTasksDto, principal));
						}
					}
					project.setProjectTaskList(projectTasksList);
				}
			}
		}
		
		System.out.println("::"+project.getProjectTaskList());

		project = projectRepository.save(project);
		if (project != null) {
			status = InventoryConstant.SUCCESS;
		}

		logger.info("<--ProjectService-------------saveProjectStatus--------------------Ended-->");
		return status;
	}

	
	
	public ProjectTasks MapProjectTasks(Project project, ProjectsTasksDto projectsTasksDto, Principal principal) {
		ProjectTasks projectTasks = new ProjectTasks();
		try {

			if (projectsTasksDto.getId() != null) {
				projectTasks.setId(projectsTasksDto.getId());
				projectTasks.setCreatedBy(projectsTasksDto.getCreatedBy());
				projectTasks.setCreationDate(
						MasterDateUtil.convertStringToTimeStampDate(projectsTasksDto.getCreationDate()));
			} else {
				projectTasks.setCreatedBy(principal.getName());
				projectTasks.setCreationDate((new Timestamp(new Date().getTime())));
			}

			projectTasks.setIsActive(projectsTasksDto.getIsActive());
			projectTasks.setTaskName(projectsTasksDto.getTaskName());
			projectTasks.setStartDate(MasterDateUtil.convertStringToDateWithoutTime(projectsTasksDto.getStartDate()));
			projectTasks.setEndDate(MasterDateUtil.convertStringToDateWithoutTime(projectsTasksDto.getEndDate()));
			//projectTasks.setAssignedTo(projectsTasksDto.getAssignedTo());
			projectTasks.setResourceCount(Integer.valueOf(projectsTasksDto.getResourceCount()));
			projectTasks.setComments(projectsTasksDto.getComments());
			projectTasks.setDuration(MasterDateUtil.getDifferenceDays(
					MasterDateUtil.convertStringToDateWithoutTime(projectsTasksDto.getStartDate()),
					(MasterDateUtil.convertStringToDateWithoutTime(projectsTasksDto.getEndDate()))));
			projectTasks.setStatus(projectsTasksDto.getStatus());
			;
			projectTasks.setLastModifiedBy(principal.getName());
			projectTasks.setLastModifiedDate((new Timestamp(new Date().getTime())));
			// projectTasks.setDaysRemaing(Integer.toString((MasterDateUtil.getDifferenceDays(projectTask.getEndDate(),new
			// Date()))));
			if (projectsTasksDto.getTaskId() == null) {
				projectTasks.setTaskId(InventoryConstant.TASK_ID_PREFIX + getTaskIdSequence());
			} else {
				projectTasks.setTaskId(projectsTasksDto.getTaskId());
			}

			projectTasks.setIsNew(projectsTasksDto.getIsNew());
			projectTasks.setProject(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectTasks;

	}

	@Override
	public ProjectDto getProject(Long id, Principal principal) {
		ProjectDto projectDto = null;
		logger.info("<--ProjectService-------------getProject--------------------Ended-->");
		try {
			Project project = projectRepository.findOne(id);
			if (null != project) {
				projectDto = new ProjectDto();
				projectDto.setId(project.getId());
				projectDto.setCustomerType(project.getCustomerType());
				projectDto.setName(project.getName());
				projectDto.setProjectType(project.getProjectType());
				projectDto.setStartDate(MasterDateUtil.convertDateToString(project.getStartDate()));
				projectDto.setEndDate(MasterDateUtil.convertDateToString(project.getEndDate()));
				projectDto.setStatus(project.getStatus());
				projectDto.setAddress1(project.getAddress1());
				projectDto.setAddress2(project.getAddress2());
				projectDto.setAddress3(project.getAddress3());
				projectDto.setAreaLandmark(project.getAreaLandmark());
				projectDto.setState(project.getState());
				projectDto.setCity(project.getCity());
				projectDto.setCountryName(project.getCountryName());
				projectDto.setPinCode(String.valueOf(project.getPinCode()));
				projectDto.setCreatedBy(project.getCreatedBy());
				projectDto.setCreationDate(MasterDateUtil.convertDateToString(project.getCreationDate()));
				projectDto.setProjectInCharge(project.getProjectInCharge());

				// projectDto.setLastModifiedBy(principal.getName());
				// projectDto.setLastModifiedDate(MasterDateUtil.convertDateToString(project.getLastModifiedDate()));
			}
			// return projectDto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ProjectService-------------getProject--------------------Ended-->");
		return projectDto;
	}

	@Override
	public List<ProjectDto> getAllProjectDtoList() {
		List<ProjectDto> projectDtoList = new ArrayList<>();
		logger.info("<--ProjectService-------------getAllProjectDtoList--------------------Ended-->");
		try {
			List<Project> projectList = projectRepository.findByStatus(InventoryConstant.ACTIVE);

			for (int i = 0; i < projectList.size(); i++) {
				Project project = projectList.get(i);
				if (project != null) {
					ProjectDto projectdto = new ProjectDto();
					projectdto.setName(project.getName());
					projectDtoList.add(projectdto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ProjectService-------------getAllProjectDtoList--------------------Ended-->");
		return projectDtoList;
	}

	@Override
	public List<CountryDto> getAllCountryAndStatesAndProject() {
		logger.info("<--ProjectService-------------getAllCountryAndStatesAndProject--------------------Ended-->");
		List<CountryDto> countryDtoList = new ArrayList<>();

		List<State> stateEntityList = new ArrayList<>();
		List<StateDto> stateDtoList = null;
		List<CityDto> cityDtoList = null;
		CountryDto countryDto = null;
		try {

			List<Country> countryEntityList = countryRepository.findAll();
			for (int i = 0; i < countryEntityList.size(); i++) {
				Country country = countryEntityList.get(i);
				if (country != null) {
					countryDto = new CountryDto();
					countryDto.setCountryName(country.getName());
					stateEntityList = country.getStateItem();
					if (stateEntityList != null) {
						stateDtoList = new ArrayList<>();
						for (int j = 0; j < stateEntityList.size(); j++) {
							State state = stateEntityList.get(j);
							if (state != null) {
								StateDto stateDto = new StateDto();
								stateDto.setId(state.getId());
								stateDto.setStateName(state.getName());
								stateDto.setStateCode(state.getCode());
								stateDto.setStatus(state.getStatus());
								stateDtoList.add(stateDto);
								List<City> cityEntityList = state.getCities();
								if (cityEntityList != null) {
									cityDtoList = new ArrayList<>();
									for (int k = 0; k < cityEntityList.size(); k++) {
										City city = cityEntityList.get(k);
										if (city != null) {
											CityDto cityDto = new CityDto();
											cityDto.setId(city.getId());
											cityDto.setCityName(city.getName());
											cityDto.setCityCode(city.getCode());
											cityDto.setStatus(city.getStatus());
											cityDtoList.add(cityDto);
										}
									}
									stateDto.setCityItem(cityDtoList);
								}
							}
						}
					}
					countryDto.setStateItem(stateDtoList);
					countryDtoList.add(countryDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ProjectService-------------getAllCountryAndStatesAndProject--------------------Ended-->");
		return countryDtoList;
	}

	/* FOR ACTIVE PROJECT STATUS DROP DOWN */
	@Override
	public List<ProjectDto> getAllActiveProjectStatus() {
		List<ProjectDto> projectStatusDtoList = new ArrayList<>();
		try {
			List<ProjectStatus> projectStatusList = projectStatusRepository.findByStatus(InventoryConstant.ACTIVE);

			for (int i = 0; i < projectStatusList.size(); i++) {
				ProjectStatus projectStatus = projectStatusList.get(i);
				if (projectStatus != null) {
					ProjectDto projectDto = new ProjectDto();
					projectDto.setStatus(projectStatus.getStatusType());
					projectStatusDtoList.add(projectDto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectStatusDtoList;
	}

	/* FOR ACTIVE PROJECT TYPE DROP DOWN */
	@Override
	public List<ProjectDto> getAllActiveProjectTypes() {
		List<ProjectDto> projectTypeDtoList = new ArrayList<>();
		try {
			List<ProjectType> projectTypeList = projectTypeRepository.findByStatus(InventoryConstant.ACTIVE);

			for (int i = 0; i < projectTypeList.size(); i++) {
				ProjectType projectType = projectTypeList.get(i);
				if (projectType != null) {
					ProjectDto projectDto = new ProjectDto();
					projectDto.setProjectType(projectType.getType());
					projectTypeDtoList.add(projectDto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectTypeDtoList;
	}

	/* FOR PROJECT STATUS */
	/* GET ALL PROJECT STATUS FOR TABLE */
	@Override
	public List<ProjectDto> getAllProjectStatus(Principal principal) {
		List<ProjectDto> projectDtoList = null;
		logger.info("<--ProjectService-------------getProjectList--------------------started-->");
		try {
			List<ProjectStatus> projectStatusList = projectStatusRepository.findAll();

			if (projectStatusList != null && !projectStatusList.isEmpty()) {
				projectDtoList = new ArrayList<>();
				for (int i = 0; i < projectStatusList.size(); i++) {
					ProjectStatus projectStatus = projectStatusList.get(i);
					if (projectStatus != null) {
						ProjectDto projectDto = new ProjectDto();
						// projectDtoList.add(MapProjectDto(project,principal));
						projectDto.setId(projectStatus.getId());
						projectDto.setProjectstatus(projectStatus.getStatusType());
						projectDto.setStatus(projectStatus.getStatus());

						projectDtoList.add(projectDto);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ProjectService-------------getProjectList--------------------Ended-->");
		return projectDtoList;
	}

	/* SAVE PROJECT STATUS */

	@Override
	public String saveProjectStatus(ProjectDto projectDto, Principal principal) throws Exception {
		String status = InventoryConstant.FAILURE;
		ProjectStatus projectStatus = new ProjectStatus();
		
		List<Project> project = null;
		
		logger.info("<--ProjectServiceImpl-------------saveProjectStatus--------------------started-->");

		if (projectDto != null && projectDto.getId() != null) {
			projectStatus = new ProjectStatus();
			projectStatus = projectStatusRepository.findOne(projectDto.getId());
			
			project = projectRepository.findByStatus(projectDto.getProjectstatus());
			

			if(project.size() > 0){
				throw new Exception(InventoryConstant.ALREADY_ASSIGNED);
			}
			
			if (projectStatus.getStatusType().equals(projectDto.getProjectstatus())) {
				projectStatus.setId(projectDto.getId());
				projectStatus.setStatusType(projectDto.getProjectstatus());
				projectStatus.setStatus(projectDto.getStatus());
			} else {

				projectStatus = projectStatusRepository.findByStatusType(projectDto.getProjectstatus());
				
				if (projectStatus != null) {
					throw new Exception(InventoryConstant.THIS_PROJECT_STATUS_ALREADY_EXIST);
				}else {
					projectStatus = new ProjectStatus();
					projectStatus.setId(projectDto.getId());
					projectStatus.setStatusType(projectDto.getProjectstatus());
					projectStatus.setStatus(projectDto.getStatus());

				}
			}

		} else {

			projectStatus = projectStatusRepository.findByStatusType(projectDto.getProjectstatus());
			if (projectStatus != null) {
				throw new Exception(InventoryConstant.THIS_PROJECT_STATUS_ALREADY_EXIST);
			} else {
				projectStatus = new ProjectStatus();
				projectStatus.setStatusType(projectDto.getProjectstatus());
				projectStatus.setStatus(InventoryConstant.ACTIVE);
			}
		}

		projectStatus = projectStatusRepository.save(projectStatus);
		if (projectStatus != null) {
			status = InventoryConstant.SUCCESS;
		}

		logger.info("<--ProjectService-------------saveProjectStatus--------------------Ended-->");
		return status;
	}
	/*
	 * GET ALL PROJECT SERVICE
	 * 
	 * @Override public List<ProjectStatusDto> getAllProjectStatus(Principal
	 * principal) { List<ProjectDto> projectDtoList = null; logger.info(
	 * "<--ProjectService-------------getAllProjectStatus--------------------started-->"
	 * ); try { List<ProjectStatus>
	 * projectStausList=projectStatusRepository.findAll();
	 * 
	 * if(projectStausList!=null && !projectStausList.isEmpty()) {
	 * projectDtoList=new ArrayList<>(); for(int
	 * i=0;i<projectStausList.size();i++) { ProjectStatus
	 * projectStatus=projectStausList.get(i); if(projectStatus!=null) {
	 * ProjectDto projectDto=new ProjectDto();
	 * //projectDtoList.add(MapProjectDto(project,principal));
	 * projectDto.setId(projectStatus.getId());
	 * projectDto.setProjectType(projectStatus.getStatusType());
	 * projectDto.setStatus(projectStatus.getStatus());
	 * 
	 * 
	 * projectDtoList.add(projectDto); } } }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } logger.info(
	 * "<--ProjectService-------------getProjectList--------------------Ended-->"
	 * ); return projectDtoList; }
	 */

	/* FOR PROJECT TASKS */
	/* for save the project tasks */

	@Override
	public String saveProjectTasks(ProjectDto projectDto, Principal principal) throws Exception {
		String status = InventoryConstant.FAILURE;
		ProjectTasks projectTasks = new ProjectTasks();
		logger.info("<--ProjectServiceImpl-------------saveProjectTasks--------------------started-->");

		if (projectDto != null && projectDto.getId() != null) {
			projectTasks = new ProjectTasks();
			projectTasks = projectTasksRepository.findOne(projectDto.getId());
			if (projectTasks != null) {
				// if(project.getName().equalsIgnoreCase(projectDto.getName())){
				projectTasks.setId(projectDto.getId());
			}

			projectTasks.setStartDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getStartDate()));
			projectTasks.setEndDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getEndDate()));
			projectTasks.setDuration(Integer.valueOf(projectDto.getPinCode()));
			projectTasks.setAssignedTo(projectDto.getProjectInCharge());
			projectTasks.setResourceCount(Integer.valueOf(projectDto.getResourceCount()));
			projectTasks.setComments(projectDto.getComments());
			// projectTasks .setStatus(projectDto.getStatus());

			if (projectDto.getCreatedBy() != null) {
				projectTasks.setCreatedBy(projectDto.getCreatedBy());
			} else {
				projectTasks.setCreatedBy(principal.getName());
			}

			if (projectDto.getCreationDate() != null) {
				projectTasks.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(projectDto.getCreationDate()));
			} else {
				projectTasks.setCreationDate(new Timestamp(new Date().getTime()));
			}

			projectTasks.setLastModifiedBy(principal.getName());
			projectTasks.setLastModifiedDate(new Timestamp(new Date().getTime()));
		}

		projectTasks = projectTasksRepository.save(projectTasks);
		if (projectTasks != null) {
			status = InventoryConstant.SUCCESS;
		}

		logger.info("<--ProjectService-------------saveProjectStatus--------------------Ended-->");
		return status;
	}

	@Override
	public List<?> viewProjectTaskList(ProjectDto projectDto) {

		return null;
	}

	@Override
	public String getTaskIdSequence() {
		logger.info("GetemployeeSequence-------started");
		String taskid = "";
		try {
			BigInteger taskidseq = projectTasksRepository.getTaskIdSequence();
			if (taskidseq != null)
				taskid = String.valueOf(taskidseq);
			else
				logger.info("Code Generation Failed");
		} catch (PersistenceException pe) {
			logger.error("Employee------getEmployeeSequence-------Exception" + pe);
			logger.info("Code Generation Failed");
		}

		logger.info("GetemployeeSequence-------Ended");
		return taskid;
	}

	/* GET ALL PROJECT STATUS FOR TABLE */
	@Override
	public List<ProjectsTasksDto> getallhistoryoftask(ProjectsTasksDto projectsTaskDto, Principal principal) {
		List<ProjectsTasksDto> projectsTasksDtoList = null;
		logger.info("<--ProjectService-------------getallhistoryoftask--------------------started-->");
		try {
			List<ProjectTasks> projectTasksList = projectTasksRepository.findByTaskId(projectsTaskDto.getTaskId());

			if (projectTasksList != null && !projectTasksList.isEmpty()) {
				// projectDtoList=new ArrayList<>();
				projectsTasksDtoList = new ArrayList<>();
				for (int i = 0; i < projectTasksList.size(); i++) {
					ProjectTasks projectTasks = projectTasksList.get(i);
					if (projectTasks != null) {

						projectsTasksDtoList.add(MapProjectTaskDto(projectTasks, principal));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ProjectService-------------getProjectList--------------------Ended-->");
		return projectsTasksDtoList;
	}

}
