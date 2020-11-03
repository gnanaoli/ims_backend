package com.fa.inventory.service.impl;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.ELCPDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.entity.ELCB;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.User;
import com.fa.inventory.repository.ELCBRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.ELCBService;

@Service
public class ELCBServiceImpl implements ELCBService {
	
	protected final Logger logger = Logger.getLogger(ProjectServiceImpl.class);	
	
	
	@Resource
	ELCBRepository elcbRepository; 
	
	
	@Resource
	ProjectRepository projectRepository; 
	
	
	@Resource
	UserRepository userRepository;

	@Override
	public List<ELCPDto> getAllELCB(Principal principal) {

		
		
		List<ELCPDto> elcbDtoList = null;
		
		
		logger.info("<--ELCBServiceImpl-------------getAllELCB--------------------started-->");
		try {
			List<ELCB> elcbEntityList = elcbRepository.findAll();

			if (elcbEntityList != null && !elcbEntityList.isEmpty()) {
				elcbDtoList = new ArrayList<>();
				for (int i = 0; i < elcbEntityList.size(); i++) {
					
					ELCB elcb = elcbEntityList.get(i);

					if (elcb != null) {						
						
						ELCPDto elcbDto = new ELCPDto();
						
						ProjectDto projectDto = new ProjectDto();
						
						UserDto userDto = new UserDto();
						
						projectDto.setName(elcb.getProjectName());
						
						userDto.setUserName(elcb.getUser().getUserName());
						elcbDto=mapELCBDto(elcb);
						/*
						elcbDto.setProjectName(elcbEntity.getProjectName());
						
						elcbDto.setComments(elcbEntity.getComments());
						
						elcbDto.setSafetyStatus(elcbEntity.getSafetyStatus());					
						
						
						elcbDto.setDate(MasterDateUtil.convertDateToString(elcbEntity.getDate()));
						
						elcbDto.setId(elcbEntity.getId());
						
						elcbDto.setProjectDto(projectDto);
						
						elcbDto.setUserDto(userDto);*/
						
						elcbDto.setProjectDto(projectDto);
						
						elcbDto.setUserDto(userDto);
						elcbDtoList.add(elcbDto);
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--ELCBServiceImpl-------------getAllELCB--------------------Ended-->");
		
		
		return elcbDtoList;
		
		
		
	}
	
	

	@Override
	public ELCPDto mapELCBDto(ELCB elcb) {
		ELCPDto elcbDto= new ELCPDto();
		try{
			elcbDto.setProjectName(elcb.getProjectName());
			
			elcbDto.setComments(elcb.getComments());
			
			elcbDto.setSafetyStatus(elcb.getSafetyStatus());					
			
			elcbDto.setWorkingStatus(elcb.getWorkingStatus());
			
			elcbDto.setDate(MasterDateUtil.convertDateToString(elcb.getDate()));
			
			elcbDto.setId(elcb.getId());
			elcbDto.setUpDatedBy(elcb.getUpdatedBy());
			elcbDto.setUpDatedTime(MasterDateUtil.convertDateToString((elcb.getUpdatedTime())));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return elcbDto;
	}


	@Override
	public String saveELCB(ELCPDto elcpDto, Principal principal) throws Exception {
		
		
		String status = null;
		
		Project project = new Project();
		
		User user  = new User();
		
		ELCB elcb = new ELCB();
		
		if(elcpDto != null && elcpDto.getId() != null)
		{
			elcb = elcbRepository.findOne(elcpDto.getId());
			
			if(elcb != null)
			{
				project = projectRepository.findByName(elcpDto.getProjectDto().getName());
				
				if(project != null)
				{
					user = userRepository.findByUserName(principal.getName());
					
					elcb.setId(elcpDto.getId());
					
					elcb.setProjectName(elcpDto.getProjectDto().getName());
					
					elcb.setComments(elcpDto.getComments());
					
//					elcb.setSafetyStatus(elcpDto.getSafetyStatus());
					
//					if(elcpDto.getSafetyStatus().equals(InventoryConstant.CHECKED))
//					{
//						elcb.setWorkingStatus(elcpDto.getWorkingStatus());
//					}
//					else
//					{
//						elcb.setWorkingStatus("");
//					}
					
					
					elcb.setUpdatedBy(principal.getName());
					
					elcb.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
					
					elcb.setDate(MasterDateUtil.convertStringToDateWithoutTime(elcpDto.getDate()));
					
					elcb.setUser(user);
					
					elcb.setProject(project);
					
					elcb = elcbRepository.save(elcb);
					
					if(elcb != null)
					{
						status = InventoryConstant.SUCCESS;
					}
									
				}
			}
			
		}
		else
		{
			project = projectRepository.findByName(elcpDto.getProjectDto().getName());
			
			if(project != null)
			{
				user = userRepository.findByUserName(principal.getName());
				
				elcb.setProjectName(elcpDto.getProjectDto().getName());
				
				elcb.setComments(elcpDto.getComments());
				
//				elcb.setSafetyStatus(elcpDto.getSafetyStatus());
				
				elcb.setUpdatedBy(principal.getName());
				
				elcb.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
				
				elcb.setDate(MasterDateUtil.convertStringToDateWithoutTime(elcpDto.getDate()));
				
				elcb.setWorkingStatus(elcpDto.getWorkingStatus());
				
				elcb.setUser(user);
				
				elcb.setProject(project);
				
				elcb = elcbRepository.save(elcb);
				
				if(elcb != null)
				{
					status = InventoryConstant.SUCCESS;
				}
								
			}
			
		}
		return status;
		
	}



	@Override
	public List<ELCPDto> getLastOneMonthOfficeElcbStatus() {
		
		List<ELCPDto> elcpDtosList = new ArrayList<>();
		
		List<Object> uncheckedEntityList = elcbRepository.getLastOneMonthOfficceElcbStatus();
		
		
		if (uncheckedEntityList != null && !uncheckedEntityList.isEmpty()) {
			for (int j = 0; j < uncheckedEntityList.size(); j++) {
				Object object = uncheckedEntityList.get(j);
				if (object != null) {
					Object[] objectArray = (Object[]) object;
					ELCPDto elcpDto = new ELCPDto();
					elcpDto.setDate(objectArray[0].toString());
					elcpDto.setSafetyStatus(objectArray[1].toString());
					elcpDto.setProjectName(objectArray[2].toString());
					elcpDto.setUpDatedTime(objectArray[3].toString());
					elcpDtosList.add(elcpDto);
				}
			}
		}
		
		return elcpDtosList;
	}
	
	@Override
	public List<ELCPDto> getLastOneMonthUserElcbStatus(Principal principal) {
		
		List<ELCPDto> elcpDtosList = new ArrayList<>();
		
		List<Object> elcbEntityList = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		boolean hasUserRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals(InventoryConstant.SAFETY_ENGINEER));
		
		
		if(hasUserRole)
		{
			User user = userRepository.findByUserName(principal.getName());
			elcbEntityList = elcbRepository.getLastOneMonthUserElcbStatus(String.valueOf(user.getId()));
		}
		else
		{
			elcbEntityList = elcbRepository.getLastOneMonthOfficceElcbStatus();
		}
			
			if (elcbEntityList != null && !elcbEntityList.isEmpty()) {
				for (int j = 0; j < elcbEntityList.size(); j++) {
					Object object = elcbEntityList.get(j);
					if (object != null) {
						Object[] objectArray = (Object[]) object;
						
						ELCPDto elcpDto = new ELCPDto();
						elcpDto.setDate(objectArray[0].toString());
						elcpDto.setSafetyStatus(objectArray[1].toString());
						elcpDto.setProjectName(objectArray[2].toString());
						elcpDtosList.add(elcpDto);
					}
				}
			}
		
		return elcpDtosList;
	}

}
