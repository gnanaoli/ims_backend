package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.WorksMenCategoryDto;
import com.fa.inventory.dto.WorksMenDetailsDto;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.WorksMenCategory;
import com.fa.inventory.entity.WorksMenDetails;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.WorksMenCategoryRepository;
import com.fa.inventory.repository.WorksMenDetailsRepository;
import com.fa.inventory.service.WorksMenService;

@Service
public class WorksMenServiceImpl implements WorksMenService{
	
	
	protected final Logger logger = Logger.getLogger(WorksMenServiceImpl.class);	
	
	
	@Resource
	WorksMenDetailsRepository worksMenDetailsRepository;
	
	@Resource
	WorksMenCategoryRepository worksMenCategoryRepository;
	
	@Resource
	ProjectRepository projectRepository;	

	

	@Override
	public List<WorksMenDetailsDto> getAllWorksmenDetails(Principal principal) {
		
		
		List<WorksMenDetailsDto> worksMenDetailsDtoList = null;
		
		
		logger.info("<--WorksMenServiceImpl-------------getAllWorksmenDetails--------------------started-->");
		try {
			List<WorksMenDetails> worksMenDetailsEntityList = worksMenDetailsRepository.findAll();

			if (worksMenDetailsEntityList != null && !worksMenDetailsEntityList.isEmpty()) {
				worksMenDetailsDtoList = new ArrayList<>();
				
				List<ProjectDto> projectDtoList = null;					
				List<WorksMenCategoryDto> worksMenCategoryDtoList = null;	
				
				
				for (int i = 0; i < worksMenDetailsEntityList.size(); i++) {
					
					WorksMenDetails worksMenDetailsBlocksEntity = worksMenDetailsEntityList.get(i);

					if (worksMenDetailsBlocksEntity != null) {
						
						WorksMenDetailsDto worksMenDetailsDto = new WorksMenDetailsDto();
						
	
						
						worksMenDetailsDto.setComments(worksMenDetailsBlocksEntity.getComments());
						worksMenDetailsDto.setCreatedBy(principal.getName());
						worksMenDetailsDto.setCreationDate(String.valueOf(worksMenDetailsBlocksEntity.getCreationDate()));
						worksMenDetailsDto.setResourceCount(String.valueOf(worksMenDetailsBlocksEntity.getResourceCount()));
						
						worksMenDetailsDto.setId(worksMenDetailsBlocksEntity.getId());
						
						worksMenDetailsDto.setDate(MasterDateUtil.convertDateToString(worksMenDetailsBlocksEntity.getDate()));
						
						
						if(worksMenDetailsBlocksEntity.getProject() != null)
						{
							Project project=worksMenDetailsBlocksEntity.getProject();
								ProjectDto projectDto=new ProjectDto();
								projectDto.setName(project.getName());
								worksMenDetailsDto.setProjectDto1(projectDto);
						}
						
						
						if(worksMenDetailsBlocksEntity.getWorksMenCategory() != null)
						{
							WorksMenCategory worksMenCategory = worksMenDetailsBlocksEntity.getWorksMenCategory();
								WorksMenCategoryDto worksMenCategoryDto = new WorksMenCategoryDto();
								worksMenCategoryDto.setCategory(worksMenCategory.getCategory());
								worksMenDetailsDto.setWorksMenCategoryDto1(worksMenCategoryDto);
						}
						
						worksMenDetailsDto.setProjectDto(projectDtoList);
						
						worksMenDetailsDto.setWorksMenCategoryDto(worksMenCategoryDtoList);		

						
						worksMenDetailsDtoList.add(worksMenDetailsDto);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--WorksMenServiceImpl-------------getAllWorksmenDetails--------------------Ended-->");
		
		
		return worksMenDetailsDtoList;
	}


	@Override
	public List<WorksMenCategoryDto> getAllWorksmenCategory(Principal principal) {
		
		List<WorksMenCategoryDto> worksMenCategoryDtoList = null;
		
		
		logger.info("<--WorksMenServiceImpl-------------getAllWorksmenCategory--------------------started-->");
		try {
			List<WorksMenCategory> worksMenCategoryEntityList = worksMenCategoryRepository.findAll();

			if (worksMenCategoryEntityList != null && !worksMenCategoryEntityList.isEmpty()) {
				worksMenCategoryDtoList = new ArrayList<>();
				for (int i = 0; i < worksMenCategoryEntityList.size(); i++) {
					
					WorksMenCategory worksMenCategoryEntity = worksMenCategoryEntityList.get(i);

					if (worksMenCategoryEntity != null) {
						
						
						WorksMenCategoryDto worksMenCategoryDto = new WorksMenCategoryDto();
						
						worksMenCategoryDto.setCategory(worksMenCategoryEntity.getCategory());
						worksMenCategoryDto.setStatus(worksMenCategoryEntity.getStatus());
						worksMenCategoryDto.setId(worksMenCategoryEntity.getId());												
						
						worksMenCategoryDtoList.add(worksMenCategoryDto);
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--WorksMenServiceImpl-------------getAllWorksmenCategory--------------------Ended-->");
		
		
		return worksMenCategoryDtoList;
	}


	@Override
	public String saveWorksMenDetails(List<WorksMenDetailsDto> worksMenDetailsDtolist, Principal principal) throws Exception{
		
		String status = null;
		
		Project project = new Project();
		
		WorksMenCategoryDto worksMenCategoryDto = null;
		
		ProjectDto projectDto = null;
		
		WorksMenCategory worksMenCategory = new WorksMenCategory();
		
		
		
		
			if(worksMenDetailsDtolist != null)
			{
				for(int i=0;i<worksMenDetailsDtolist.size();i++)
				{
					
					WorksMenDetails worksMenDetails = new WorksMenDetails();
					
					WorksMenDetailsDto worksMenDetailsDto = worksMenDetailsDtolist.get(i);
					
					
					if(worksMenDetailsDto.getId() != null)
					{
						worksMenDetails.setId(worksMenDetailsDto.getId());
					}
					
					worksMenDetails.setComments(worksMenDetailsDto.getComments());
					
					worksMenDetails.setCreatedBy(principal.getName());
					
					worksMenDetails.setResourceCount(Integer.valueOf(worksMenDetailsDto.getResourceCount()));
					
					worksMenDetails.setCreationDate(new Date());
					
					worksMenDetails.setDate(MasterDateUtil.convertStringToDateWithoutTime(worksMenDetailsDto.getDate()));
					
					worksMenDetails.setLastModifiedBy(principal.getName());
					
					worksMenDetails.setLastModifiedDate(new Date());
					
					
					if(worksMenDetailsDto.getProjectDto() != null)
					{
						for(int j=0;j<worksMenDetailsDto.getProjectDto().size();j++)
						{
							projectDto = worksMenDetailsDto.getProjectDto().get(j);
							if(projectDto != null)
							{
								project = projectRepository.findByName(projectDto.getName());
								if(project != null)
								{
									worksMenDetails.setProjectName(projectDto.getName());
									worksMenDetails.setProject(project);
								}
							}
						}
					}
					if(worksMenDetailsDto.getWorksMenCategoryDto() != null)
					{
						for(int k=0;k<worksMenDetailsDto.getWorksMenCategoryDto().size();k++)
						{
							worksMenCategoryDto = worksMenDetailsDto.getWorksMenCategoryDto().get(k);
							if(worksMenCategoryDto != null)
							{
								worksMenCategory = worksMenCategoryRepository.findByCategory(worksMenCategoryDto.getCategory());
								if(worksMenCategory != null)
								{
									worksMenDetails.setCategory(worksMenCategory.getCategory());
									worksMenDetails.setWorksMenCategory(worksMenCategory);
								}
							}
						}
					}
					
					worksMenDetails = worksMenDetailsRepository.save(worksMenDetails);
					
				}
				
				status = InventoryConstant.SUCCESS;
			}
				
		
		return status;
	}


	@Override
	public String saveWorksMenCategory(WorksMenCategoryDto worksMenCategoryDto, Principal principal) throws Exception {
		
		
		String status = null;
		
		WorksMenCategory worksMenCategory = new WorksMenCategory();
		
		if(worksMenCategoryDto != null && worksMenCategoryDto.getId() != null)
		{		
			worksMenCategory = worksMenCategoryRepository.findOne(worksMenCategoryDto.getId());
			
			if(worksMenCategory.getId() == worksMenCategoryDto.getId() && worksMenCategory.getCategory().equals(worksMenCategoryDto.getCategory()))
			{
				worksMenCategory.setId(worksMenCategoryDto.getId());
				worksMenCategory.setCategory(worksMenCategoryDto.getCategory());
				worksMenCategory.setStatus(worksMenCategoryDto.getStatus());
				
				worksMenCategory = worksMenCategoryRepository.save(worksMenCategory);
				
				if(worksMenCategory != null)
				{
					status = InventoryConstant.SUCCESS;
				}
			}
			else if(worksMenCategory.getId() == worksMenCategoryDto.getId() && !worksMenCategory.getCategory().equals(worksMenCategoryDto.getCategory()))
			{
				worksMenCategory = worksMenCategoryRepository.findByCategory(worksMenCategoryDto.getCategory());
				
				if(worksMenCategory != null)
				{
					throw new Exception(InventoryConstant.WORKSMEN_CATEGORY_ALREADY_EXISTS);
				}
				else
				{
					worksMenCategory = worksMenCategoryRepository.findOne(worksMenCategoryDto.getId());
					
					worksMenCategory.setId(worksMenCategoryDto.getId());
					worksMenCategory.setCategory(worksMenCategoryDto.getCategory());
					worksMenCategory.setStatus(worksMenCategoryDto.getStatus());
					
					worksMenCategory = worksMenCategoryRepository.save(worksMenCategory);
					
					if(worksMenCategory != null)
					{
						status = InventoryConstant.SUCCESS;
					}
				}
			}
		}
		else
		{
			
			worksMenCategory = worksMenCategoryRepository.findByCategory(worksMenCategoryDto.getCategory());
			
			if(worksMenCategory != null)
			{
				throw new Exception(InventoryConstant.WORKSMEN_CATEGORY_ALREADY_EXISTS);
			}
			else
			{
				worksMenCategory = new WorksMenCategory();
				
				worksMenCategory.setCategory(worksMenCategoryDto.getCategory());
				worksMenCategory.setStatus(InventoryConstant.ACTIVE);
				
				worksMenCategory = worksMenCategoryRepository.save(worksMenCategory);
				
				if(worksMenCategory != null)
				{
					status = InventoryConstant.SUCCESS;
				}
			}
			
		}
		
		
		return status;
	}
	
	
	@Override
	public WorksMenDetailsDto mapWorksMenDto(WorksMenDetails worksMenDetails) {
		WorksMenDetailsDto worksMenDetailsDto= new WorksMenDetailsDto();
		try{
			worksMenDetailsDto.setComments(worksMenDetails.getComments());
			worksMenDetailsDto.setCreatedBy(worksMenDetails.getCreatedBy());
			worksMenDetailsDto.setCreationDate(String.valueOf(worksMenDetails.getCreationDate()));
			worksMenDetailsDto.setResourceCount(String.valueOf(worksMenDetails.getResourceCount()));
			
			worksMenDetailsDto.setId(worksMenDetails.getId());
			
			worksMenDetailsDto.setDate(MasterDateUtil.convertDateToString(worksMenDetails.getDate()));
			//worksMenDetailsDto.setProjectDto(projectDto);
			Project project=worksMenDetails.getProject();
			worksMenDetailsDto.setProjectName(project.getName());
			WorksMenCategory worksMenCategory=worksMenDetails.getWorksMenCategory();
			worksMenDetailsDto.setWorksMenCategory(worksMenCategory.getCategory());
			/*worksMenDetailsDto.setProjectDto(projectDto);
			
			worksMenDetailsDto.setWorksMenCategoryDto(worksMenCategoryDto);
			*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return worksMenDetailsDto;
	}

}
