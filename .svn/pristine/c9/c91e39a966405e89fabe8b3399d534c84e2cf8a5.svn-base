
package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.entity.ProjectType;
import com.fa.inventory.repository.ProjectTypeRepository;
import com.fa.inventory.service.ProjectTypeService;
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService  {
	
	protected final Logger logger = Logger.getLogger(ProjectServiceImpl.class);
	
	@Resource
	ProjectTypeRepository projectTypeRepository;
	
	

	@Override
	public List<ProjectDto> getAllProjectType(Principal principal) {
		List<ProjectDto> projectDtoList = null;
	logger.info("<--ProjectService-------------getProjectList--------------------started-->");
	try {
		List<ProjectType> projectTypeList=projectTypeRepository.findAll();
		
		if(projectTypeList!=null && !projectTypeList.isEmpty())
		{
			projectDtoList=new ArrayList<>();
			for(int i=0;i<projectTypeList.size();i++)
			{
				ProjectType projectType=projectTypeList.get(i);
				if(projectType!=null)
				{
					ProjectDto projectDto=new ProjectDto();
					//projectDtoList.add(MapProjectDto(project,principal));
					projectDto.setId(projectType.getId());
				projectDto.setProjectType(projectType.getType());
				projectDto.setStatus(projectType.getStatus());
					
				
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

	
	
	@Override
	public String saveProjectType(ProjectDto projectDto, Principal principal) throws Exception{
		String status=InventoryConstant.FAILURE;
		ProjectType	projectType=new ProjectType();
		logger.info("<--ProjectServiceImpl-------------saveProject--------------------started-->");
		
		
			if(projectDto!=null && projectDto.getId()!=null){
				projectType=new ProjectType();
				projectType=projectTypeRepository.findOne(projectDto.getId());
				if(projectType.getType().equals(projectDto.getProjectType())){
					projectType.setId(projectDto.getId());
					projectType.setType(projectDto.getProjectType());
					projectType.setStatus(projectDto.getStatus());
					}
				else{
					
					projectType=projectTypeRepository.findByType(projectDto.getProjectType());
					if(projectType!=null){
						throw new Exception(InventoryConstant.THIS_PROJECT_TYPE_ALREADY_EXIST);
					}else{
						projectType=new ProjectType();
						projectType.setId(projectDto.getId());
						projectType.setType(projectDto.getProjectType());
						projectType.setStatus(projectDto.getStatus());
						
					}
				}
				
				   
			} else{
				
					
				projectType=projectTypeRepository.findByType(projectDto.getProjectType());
				if(projectType!=null){
					throw new Exception(InventoryConstant.THIS_PROJECT_TYPE_ALREADY_EXIST);
				}else{
					projectType=new ProjectType();
				projectType.setType(projectDto.getProjectType());
				projectType.setStatus(InventoryConstant.ACTIVE);
			}
			}	
				   
				 
		
		    projectType=projectTypeRepository.save(projectType);
		    if(projectType!=null){
			status=InventoryConstant.SUCCESS;
		    }
		
		
	
	
    logger.info("<--ProjectService-------------saveProject--------------------Ended-->");
	return status;
}

}
