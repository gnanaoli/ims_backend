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
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.DispatcherLog;
import com.fa.inventory.entity.InventoryAssign;
import com.fa.inventory.entity.InventoryRequest;
import com.fa.inventory.entity.Scrap;
import com.fa.inventory.entity.ServiceTracker;
import com.fa.inventory.repository.DispatchLogRepository;
import com.fa.inventory.repository.InventoryAssignRepository;
import com.fa.inventory.repository.InventoryRequestRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.ScrapRepository;
import com.fa.inventory.repository.ServiceTrackerRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.InventoryRequestService;
import com.fa.inventory.service.SmsService;
import com.fa.inventory.service.UserManagementService;

@Service
public class InventoryRequestImpl implements InventoryRequestService {

	protected final Logger logger = Logger.getLogger(InventoryRequestImpl.class);

	@Resource
	InventoryRequestRepository inventoryRequestRepository;

	@Resource
	InventoryAssignRepository inventoryAssignRepository;
	
	@Resource
	DispatchLogRepository dispatchLogRepository;
	
	@Resource
	ScrapRepository scrapRepository;
	
	@Resource
	ServiceTrackerRepository serviceTrackerRepository;
	
	@Resource
	InventoryManagementService inventoryManagementService;
	
	@Resource
	UserManagementService userManagementService;
	
	@Resource
	SmsService smsService;
	
	@Resource
	ProjectRepository projectRepository;
	
	@Resource
	WareHouseRepository wareHouseRepository;
	
	@Override
	public List<InventoryRequestDto> getAllInspectionDetails(Principal principal) throws Exception {

		logger.info("<--InventoryRequestServiceImpl-------------getAllInspectionDetails--------------------started-->");
		List<InventoryRequestDto> inventoryRequestDtoList = null;
		try {

			List<InventoryRequest> inventoryRequestEntityList = inventoryRequestRepository.findAll();

			if (inventoryRequestEntityList != null) {
				inventoryRequestDtoList = new ArrayList<>();

				for (int i = 0; i < inventoryRequestEntityList.size(); i++) {

					InventoryRequest inventoryRequestEntity = inventoryRequestEntityList.get(i);

					if (inventoryRequestEntity != null) {

						if ((inventoryRequestEntity.getStatus().equals(InventoryConstant.MOVETOSCRAPREQUESTED)
								|| inventoryRequestEntity.getStatus()
										.equals(InventoryConstant.MOVETOSERVICEREQUESTED)))
								{
											InventoryRequestDto inventoryRequestDto = new InventoryRequestDto();

											inventoryRequestDto.setId(inventoryRequestEntity.getId());
											inventoryRequestDto.setAcceptedQuantity(inventoryRequestEntity.getAcceptedQuantity());
											inventoryRequestDto.setActionBy(inventoryRequestEntity.getActionBy());
											inventoryRequestDto.setActionDate(
													MasterDateUtil.convertDateToString(inventoryRequestEntity.getActionDate()));
											inventoryRequestDto.setComments(inventoryRequestEntity.getComments());
											inventoryRequestDto.setDispatchDate(
													MasterDateUtil.convertDateToString(inventoryRequestEntity.getDispatchDate()));
											inventoryRequestDto.setExpectedDateToReach(MasterDateUtil
													.convertDateToString(inventoryRequestEntity.getExpectedDateToReach()));
											inventoryRequestDto.setLocation(inventoryRequestEntity.getLocation());
											inventoryRequestDto.setModelCode(inventoryRequestEntity.getModelCode());
											inventoryRequestDto.setQuantity(inventoryRequestEntity.getQuantity());
											inventoryRequestDto.setRaisedBy(inventoryRequestEntity.getRaisedBy());
											inventoryRequestDto.setRaisedDate(
													MasterDateUtil.convertDateToString(inventoryRequestEntity.getRaisedDate()));
											inventoryRequestDto.setReferenceNo(inventoryRequestEntity.getReferenceNo());
											inventoryRequestDto.setRequestedTo(inventoryRequestEntity.getRequestedTo());
											inventoryRequestDto.setRequiredDays(inventoryRequestEntity.getRequiredDays());
											inventoryRequestDto.setStatus(inventoryRequestEntity.getStatus());
											inventoryRequestDto.setSubStatus(inventoryRequestEntity.getSubStatus());
											inventoryRequestDto.setRequestedFrom(inventoryRequestEntity.getRequestedFrom());

											inventoryRequestDto.setCategoryType(inventoryRequestEntity.getCategory().getCategoryType());
											inventoryRequestDto
													.setSubCategory(inventoryRequestEntity.getSubCategory().getSubCategory());
											inventoryRequestDtoList.add(inventoryRequestDto);
											
								} 
							
						}
					}
					
				}
			

		} catch (Exception e) {

			e.printStackTrace();

		}

		logger.info("<--InventoryRequestServiceImpl-------------getAllInspectionDetails--------------------started-->");
		return inventoryRequestDtoList;
	}

	@Override
	public String approveInspection(InventoryRequestDto requestDto, Principal principal) throws Exception {

		String status = null;
		InventoryRequest inventoryRequest=new InventoryRequest();
		logger.info("<--InventoryRequestServiceImpl-------------approveInspection--------------------Ended-->");
		try {

			if (requestDto != null && requestDto.getId() != null) {
				inventoryRequest = inventoryRequestRepository.findOne(requestDto.getId());

				if (inventoryRequest != null && requestDto.getSubStatus().equals(InventoryConstant.QC_APPROVED)) {
					if(inventoryRequest.getChallanStatus().equals(InventoryConstant.YES))
					{
						DispatcherLog dispatcherLog=dispatchLogRepository.save(mapDispatchLogEntity(requestDto, principal, inventoryRequest));
						if(dispatcherLog!=null)
						{
							inventoryRequest.setSubStatus(requestDto.getSubStatus());
							inventoryRequest.setComments(requestDto.getComments());
							inventoryRequest.setActionBy(principal.getName());

							inventoryRequest = inventoryRequestRepository.save(inventoryRequest);
							
							if (inventoryRequest != null) {
								status = InventoryConstant.SUCCESS;
							}
						}
					}
					else if(inventoryRequest.getChallanStatus().equals(InventoryConstant.NO))
					{
						if(inventoryRequest.getStatus().equals(InventoryConstant.MOVETOSCRAPREQUESTED))
						{
							mapScrapEntity(inventoryRequest,principal);
						}
						else if(inventoryRequest.getStatus().equals(InventoryConstant.MOVETOSERVICEREQUESTED))
						{
						serviceTrackerRepository.saveAndFlush(mapServiceTrackerEntity(requestDto, principal, inventoryRequest));
						}
						inventoryRequest.setSubStatus(requestDto.getSubStatus());
						inventoryRequest.setComments(requestDto.getComments());
						inventoryRequest.setActionBy(principal.getName());
						inventoryRequest = inventoryRequestRepository.save(inventoryRequest);
						if (inventoryRequest != null) {
							status = InventoryConstant.SUCCESS;
						}
					}
				}
				else
				{
					inventoryRequest.setSubStatus(requestDto.getSubStatus());
					inventoryRequest.setComments(requestDto.getComments());
					inventoryRequest.setActionBy(principal.getName());
					if (inventoryRequest.getInventoryAssign()!= null) {
						InventoryAssign inventoryAssign=inventoryRequest.getInventoryAssign();
						inventoryAssign.setAvailableQty(inventoryAssign.getAvailableQty() + inventoryRequest.getQuantity());
						inventoryRequest.setInventoryAssign(inventoryAssign);
					
					
					}
					inventoryRequest = inventoryRequestRepository.save(inventoryRequest);
					if (inventoryRequest != null) {
						status = InventoryConstant.SUCCESS;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--InventoryRequestServiceImpl-------------approveInspection--------------------Ended-->");
		return status;
	}

	@Override
	public String verifyInspection(InventoryRequestDto requestDto, Principal principal) throws Exception {

		String status = null;

		InventoryRequest inventoryRequest=new InventoryRequest();
		logger.info("<--InventoryRequestServiceImpl-------------approveInspection--------------------Ended-->");
		try {
			if (requestDto != null && requestDto.getId() != null) {
				inventoryRequest = inventoryRequestRepository.findOne(requestDto.getId());
				if (inventoryRequest != null && requestDto.getSubStatus().equals(InventoryConstant.QC_VERIFIED)) {
					inventoryRequest.setSubStatus(requestDto.getSubStatus());
					inventoryRequest.setComments(requestDto.getComments());
					inventoryRequest.setActionBy(principal.getName());
					inventoryRequest = inventoryRequestRepository.save(inventoryRequest);
					if (inventoryRequest != null) {
						status = InventoryConstant.SUCCESS;
					}
				}
				else
				{
					inventoryRequest.setSubStatus(requestDto.getSubStatus());
					inventoryRequest.setComments(requestDto.getComments());
					inventoryRequest.setActionBy(principal.getName());
					if (inventoryRequest.getInventoryAssign()!= null) {
						InventoryAssign inventoryAssign=inventoryRequest.getInventoryAssign();
						inventoryAssign
								.setAvailableQty(inventoryAssign.getAvailableQty() + inventoryRequest.getQuantity());
						inventoryRequest.setInventoryAssign(inventoryAssign);
					}
					inventoryRequest = inventoryRequestRepository.save(inventoryRequest);
					if(inventoryRequest != null)
					{
						status = InventoryConstant.SUCCESS;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryRequestServiceImpl-------------approveInspection--------------------Ended-->");
		return status;
	}
	

	public Scrap mapScrapEntity(InventoryRequest inventoryRequest,Principal principal)
	{
		logger.info("<--InventoryRequestServiceImpl-------------approveInspection--------------------started-->");
		Scrap scrap = new Scrap();
		scrap.setFromLocation(inventoryRequest.getRequestedFrom());
		scrap.setLastModifiedBy(principal.getName());
		scrap.setLastModifiedDate(new Date());
		scrap.setQuantity(inventoryRequest.getQuantity());
		scrap.setRaisedBy(principal.getName());
		scrap.setRaisedDate(new Date());
		scrap.setLevel1Approver(InventoryConstant.QC_APPROVED);
		scrap.setLevel2Approver(InventoryConstant.QC_APPROVED);
		scrap.setStatus(InventoryConstant.ACTIVE);
		scrap.setWarehouseSiteName(inventoryRequest.getRequestedFrom());
		scrap.setCategory(inventoryRequest.getCategory());
		scrap.setSubCategory(inventoryRequest.getSubCategory());
		scrap.setInventoryAssign(inventoryRequest.getInventoryAssign());
		scrap = scrapRepository.save(scrap);		
		logger.info("<--InventoryRequestServiceImpl-------------approveInspection--------------------Ended-->");
		return scrap;
		
	}

	public ServiceTracker mapServiceTrackerEntity(InventoryRequestDto requestDto,Principal principal,InventoryRequest inventoryRequest)
	{
		logger.info("<--InventoryRequestServiceImpl-------------mapServiceTrackerEntity--------------------started-->");
		ServiceTracker serviceTracker = new ServiceTracker();
		serviceTracker.setComments(requestDto.getComments());
		serviceTracker.setCreatedBy(principal.getName());
		serviceTracker.setCreationDate(new Date());
		serviceTracker.setFromDate(new Date());
		serviceTracker.setLastModifiedBy(principal.getName());
		serviceTracker.setLastModifiedDate(new Date());
		serviceTracker.setQuantity(inventoryRequest.getQuantity());
		serviceTracker.setStatus(InventoryConstant.ACTIVE);
		serviceTracker.setToDate(new Date());
		serviceTracker.setCreatedBy(principal.getName());
		serviceTracker.setCreationDate(new Date());
		serviceTracker.setFromDate(new Date());
		serviceTracker.setSerialNumber("0");
		serviceTracker.setType("");
		serviceTracker.setWorkingCondtion("");
		serviceTracker.setCategory(inventoryRequest.getCategory());
		serviceTracker.setSubCategory(inventoryRequest.getSubCategory());
		serviceTracker.setInventoryAssign(inventoryRequest.getInventoryAssign());
		logger.info("<--InventoryRequestServiceImpl-------------mapServiceTrackerEntity--------------------started-->");
		return serviceTracker;
	}

	public DispatcherLog mapDispatchLogEntity(InventoryRequestDto requestDto,Principal principal,InventoryRequest inventoryRequest)
	{
		logger.info("<--InventoryRequestServiceImpl-------------mapDispatchLogEntity--------------------started-->");
		DispatcherLog dispatcherLog = new DispatcherLog();
		dispatcherLog.setComments(requestDto.getComments());
		dispatcherLog.setLocation(inventoryRequest.getLocation());
		dispatcherLog.setModelCode(inventoryRequest.getModelCode());
		dispatcherLog.setQuantity(inventoryRequest.getQuantity());
		dispatcherLog.setRaisedBy(principal.getName());
		dispatcherLog.setActionBy(principal.getName());
		dispatcherLog.setActionDate(new Date());
		dispatcherLog.setAvailableQuantity(inventoryRequest.getQuantity());
		dispatcherLog.setAcceptedQuantity(inventoryRequest.getQuantity());
		dispatcherLog.setRequiredDays(0);
		dispatcherLog.setRaisedDate(new Date());
		dispatcherLog.setReferenceNo(inventoryRequest.getReferenceNo());
		dispatcherLog.setRequestedFrom(inventoryRequest.getRequestedFrom());
		dispatcherLog.setRequestedTo(inventoryRequest.getRequestedTo());
		dispatcherLog.setStatus(inventoryRequest.getStatus());
		dispatcherLog.setSubStatus(requestDto.getSubStatus());
		dispatcherLog.setCategory(inventoryRequest.getCategory());
		dispatcherLog.setSubCategory(inventoryRequest.getSubCategory());
		dispatcherLog.setInventoryAssign(inventoryRequest.getInventoryAssign());
		logger.info("<--InventoryRequestServiceImpl-------------mapDispatchLogEntity--------------------started-->");
		return dispatcherLog;
	}

	@Override
	public List<InventoryRequestDto> getNotificationData(Principal principal) {
		logger.info("<--InventoryRequestServiceImpl-------------getNotificationData--------------------started-->");
		List<InventoryRequestDto> inventoryRequestResponseDtoList=new ArrayList<>();
		List<ProjectDto> projectDtoList=inventoryManagementService.getCurrentUserProjectDtoList(principal);
		if(projectDtoList!=null && !projectDtoList.isEmpty())
		{
			for(int i=0;i<projectDtoList.size();i++)
			{
				ProjectDto projectDto=projectDtoList.get(i);
				if(projectDto!=null)
				{
					List<InventoryRequest> inventoryRequestEntityList=inventoryRequestRepository.findByRequestedToAndNotificationStatus(projectDto.getName(),InventoryConstant.NEW);
					if(inventoryRequestEntityList!=null)
					{
						for(int j=0;j<inventoryRequestEntityList.size();j++)
						{
							inventoryRequestResponseDtoList.add(mapInventoryRequestEntityToDto(inventoryRequestEntityList.get(j)));
						}
					}
				}
			}
		}
		else 
		{
			List<WareHouseDto> wareHouseDtosList=userManagementService.getCurrentUserWareHouseDtoList(principal);
			if(wareHouseDtosList!=null)
			{
				for(int i=0;i<wareHouseDtosList.size();i++)
				{
					WareHouseDto wareHouseDto=wareHouseDtosList.get(i);
					if(wareHouseDto!=null)
					{
						List<InventoryRequest> inventoryRequestEntityList=inventoryRequestRepository.findByRequestedToAndNotificationStatus(wareHouseDto.getWareHouseName(),InventoryConstant.NEW);
						if(inventoryRequestEntityList!=null)
						{
							for(int j=0;j<inventoryRequestEntityList.size();j++)
							{
								inventoryRequestResponseDtoList.add(mapInventoryRequestEntityToDto(inventoryRequestEntityList.get(j)));
							}
						}
					}
				}
			}
		}
		logger.info("<--InventoryRequestServiceImpl-------------getNotificationData--------------------Ended-->");
		return inventoryRequestResponseDtoList;
	}

	
	public InventoryRequestDto mapInventoryRequestEntityToDto(InventoryRequest inventoryRequestEntity)
	{
		logger.info("<--InventoryRequestServiceImpl-------------mapInventoryRequestEntityToDto--------------------started-->");
		InventoryRequestDto inventoryRequestDto=null;
		try {
		inventoryRequestDto=new InventoryRequestDto();
		inventoryRequestDto.setId(inventoryRequestEntity.getId());
		inventoryRequestDto.setAcceptedQuantity(inventoryRequestEntity.getAcceptedQuantity());
		inventoryRequestDto.setActionBy(inventoryRequestEntity.getActionBy());
		inventoryRequestDto.setActionDate(
				MasterDateUtil.convertDateToString(inventoryRequestEntity.getActionDate()));
		inventoryRequestDto.setComments(inventoryRequestEntity.getComments());
		inventoryRequestDto.setDispatchDate(
				MasterDateUtil.convertDateToString(inventoryRequestEntity.getDispatchDate()));
		inventoryRequestDto.setExpectedDateToReach(MasterDateUtil
				.convertDateToString(inventoryRequestEntity.getExpectedDateToReach()));
		inventoryRequestDto.setLocation(inventoryRequestEntity.getLocation());
		inventoryRequestDto.setModelCode(inventoryRequestEntity.getModelCode());
		inventoryRequestDto.setQuantity(inventoryRequestEntity.getQuantity());
		inventoryRequestDto.setRaisedBy(inventoryRequestEntity.getRaisedBy());
		inventoryRequestDto.setRaisedDate(
				MasterDateUtil.convertDateToString(inventoryRequestEntity.getRaisedDate()));
		inventoryRequestDto.setReferenceNo(inventoryRequestEntity.getReferenceNo());
		inventoryRequestDto.setRequestedTo(inventoryRequestEntity.getRequestedTo());
		inventoryRequestDto.setRequiredDays(inventoryRequestEntity.getRequiredDays());
		inventoryRequestDto.setStatus(inventoryRequestEntity.getStatus());
		inventoryRequestDto.setSubStatus(inventoryRequestEntity.getSubStatus());
		inventoryRequestDto.setRequestedFrom(inventoryRequestEntity.getRequestedFrom());
		
		inventoryRequestDto.setNotificationMessage(InventoryConstant.TOOLS_REQUEST_FROM+inventoryRequestEntity.getRequestedFrom());
		inventoryRequestDto.setNotificationLink(inventoryRequestEntity.getNotificationLink());
		inventoryRequestDto.setNotificationStatus(inventoryRequestEntity.getNotificationStatus());
		inventoryRequestDto.setCategoryType(inventoryRequestEntity.getCategory().getCategoryType());
		inventoryRequestDto
				.setSubCategory(inventoryRequestEntity.getSubCategory().getSubCategory());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--InventoryRequestServiceImpl-------------mapInventoryRequestEntityToDto--------------------Ended-->");
		return inventoryRequestDto;
	}

	@Override
	public ResponseDto updateNotificationStatus(InventoryRequestDto inventoryRequestDto, Principal principal) {
		logger.info("<--InventoryRequestServiceImpl-------------updateNotificationStatus--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		if(inventoryRequestDto!=null)
		{
			InventoryRequest inventoryRequest=inventoryRequestRepository.findOne(inventoryRequestDto.getId());
			if(inventoryRequest!=null)
			{
				inventoryRequest.setNotificationStatus(InventoryConstant.OLD);
				inventoryRequest=inventoryRequestRepository.save(inventoryRequest);
				if(inventoryRequest!=null)
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
			}
		}
		logger.info("<--InventoryRequestServiceImpl-------------updateNotificationStatus--------------------Ended-->");
		return responseDto;
	}
	
	}

