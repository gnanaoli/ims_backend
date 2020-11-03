package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.NotificationDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.Notifications;
import com.fa.inventory.repository.InventoryRequestRepository;
import com.fa.inventory.repository.NotificationsRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.NotificationService;
import com.fa.inventory.service.UserManagementService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Resource
	InventoryManagementService inventoryManagementService;

	@Resource
	NotificationsRepository notificationsRepository;

	@Resource
	UserManagementService userManagementService;

	@Resource
	ProjectRepository projectRepository;

	@Resource
	WareHouseRepository wareHouseRepository;

	@Resource
	InventoryRequestRepository inventoryRequestRepository;

	protected final Logger logger = Logger.getLogger(NotificationServiceImpl.class);

	@Override
	public List<NotificationDto> getNotificationData(Principal principal) throws Exception {
		List<NotificationDto> notificationDtoList = new ArrayList<>();
		List<ProjectDto> projectDtoList = inventoryManagementService.getCurrentUserProjectDtoList(principal);
		if (projectDtoList != null && !projectDtoList.isEmpty()) {
			for (int i = 0; i < projectDtoList.size(); i++) {
				ProjectDto projectDto = projectDtoList.get(i);
				if (projectDto != null) {
					List<Notifications> notificationList = notificationsRepository.getCountNotifications(projectDto.getName());
					if (notificationList != null ) {
						for (int j = 0; j < notificationList.size(); j++) {
							Notifications notifications = notificationList.get(j);
							NotificationDto notificationDto = null;
							notificationDto = new NotificationDto();
							if (!notifications.getRequestedTo().equals(InventoryConstant.EVERYONE)) {
								if (!notifications.getStatus().equals(InventoryConstant.PENDING)) {
									notificationDto.setId(notifications.getId());
									notificationDto.setQuantity(notifications.getQuantity());
									notificationDto.setRequestedFrom(notifications.getRequestedFrom());
									notificationDto.setNotificationLink(notifications.getNotificationLink());
									notificationDto.setNotificationStatus(notifications.getNotificationStatus());
									notificationDto.setRequestedTo(notifications.getRequestedTo());
									notificationDto.setCreationDate(MasterDateUtil
											.convertDateToStringWithTime(notifications.getCreationDate()));
									notificationDto.setStatus(notifications.getStatus());
									if (notifications.getStatus().equals("Requested")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_RECEIVED_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());
									}

									if (notifications.getStatus().equals("Received")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_RECEIVED_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());
									} else if (notifications.getStatus().equals("ITEM RECEIVED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_ACCEPTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());
									}

									else if (notifications.getStatus().equals("QC APPROVED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_ACCEPTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}

									else if (notifications.getStatus().equals("QC VERIFIED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_REQUEST_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}

									else if (notifications.getStatus().equals("REJECTED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_REJECTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}
									
									else if (notifications.getStatus().equals("ITEM DISPATCHED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_RECEIVED_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}
									
									else if (notifications.getStatus().equals("Service Dispatched")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_ACCEPTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}
									
									notificationDto.setCategoryType(notifications.getCategory().getCategoryType());
									notificationDtoList.add(notificationDto);
								}

							}

						}
					}
				}
			}
		}
		List<WareHouseDto> wareHouseDtosList = userManagementService.getCurrentUserWareHouseDtoList(principal);
		if (wareHouseDtosList != null) {
			for (int i = 0; i < wareHouseDtosList.size(); i++) {
				WareHouseDto wareHouseDto = wareHouseDtosList.get(i);
				if (wareHouseDto != null) {
					List<Notifications> notificationList = notificationsRepository.getCountNotifications(wareHouseDto.getWareHouseName());
					if (notificationList != null) {
						for (int j = 0; j < notificationList.size(); j++) {
							Notifications notifications = notificationList.get(j);
							NotificationDto notificationDto = null;
							notificationDto = new NotificationDto();
							/*if (notifications.getRequestedTo().equals(InventoryConstant.EVERYONE)) {
								notificationDto.setId(notifications.getId());
								notificationDto.setQuantity(notifications.getQuantity());
								notificationDto.setRequestedFrom(notifications.getRequestedFrom());
								notificationDto.setNotificationLink(notifications.getNotificationLink());
								notificationDto.setNotificationStatus(notifications.getNotificationStatus());
								notificationDto.setRequestedTo(notifications.getRequestedTo());
								notificationDto.setCreationDate(
										MasterDateUtil.convertDateToStringWithTime(notifications.getCreationDate()));
								notificationDto.setStatus(notifications.getStatus());
								notificationDto.setNotificationMessage(InventoryConstant.TOOLS_REQUEST_FROM + " "
										+ notifications.getRequestedFrom().toUpperCase());
								notificationDto.setCategoryType(notifications.getCategory().getCategoryType());
								notificationDtoList.add(notificationDto);

							}*/

							if (!notifications.getRequestedTo().equals(InventoryConstant.EVERYONE)) {
								if (!notifications.getStatus().equals(InventoryConstant.PENDING)) {
									notificationDto.setId(notifications.getId());
									notificationDto.setQuantity(notifications.getQuantity());
									notificationDto.setRequestedFrom(notifications.getRequestedFrom());
									notificationDto.setNotificationLink(notifications.getNotificationLink());
									notificationDto.setNotificationStatus(notifications.getNotificationStatus());
									notificationDto.setRequestedTo(notifications.getRequestedTo());
									notificationDto.setCreationDate(MasterDateUtil
											.convertDateToStringWithTime(notifications.getCreationDate()));
									notificationDto.setStatus(notifications.getStatus());
									if (notifications.getStatus().equals("Requested")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_REQUEST_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());
									}

									if (notifications.getStatus().equals("Received")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_RECEIVED_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());
									} else if (notifications.getStatus().equals("ITEM RECEIVED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_ACCEPTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());
									}


									else if (notifications.getStatus().equals("ITEM DISPATCHED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_RECEIVED_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}
									
									
									else if (notifications.getStatus().equals("QC APPROVED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_ACCEPTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}

									else if (notifications.getStatus().equals("QC VERIFIED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_REQUEST_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}

									else if (notifications.getStatus().equals("REJECTED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_REJECTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}
									else if (notifications.getStatus().equals("Service Dispatched")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_ACCEPTED_BY + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}
									
									else if (notifications.getStatus().equals("MOVE TO SCRAP REQUESTED")) {
										notificationDto.setNotificationMessage(

												InventoryConstant.TOOLS_RECEIVED_FROM + " "
														+ notifications.getRequestedFrom().toUpperCase());

									}

									
									
									
									
									notificationDto.setCategoryType(notifications.getCategory().getCategoryType());
									notificationDtoList.add(notificationDto);
								}

							}
						}
					}
				}

			}
		}
		Authentication authentication =
				  SecurityContextHolder.getContext().getAuthentication();
		boolean hasOfficeRole = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals(InventoryConstant.OFFICE_ADMINISTRATOR));
		if (hasOfficeRole) {
			List<Notifications> notificationList3 = notificationsRepository.findAllByOrderByIdDesc();
			if (notificationList3 != null) {
				for (int j = 0; j < notificationList3.size(); j++) {
					notificationDtoList.add(mapNotificationListtoDtoForOffice(notificationList3.get(j), principal));

				}

			}
		}
		boolean hasUSERWARERole = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR) || r.getAuthority().equals(InventoryConstant.USER) || r.getAuthority().equals(InventoryConstant.SUPER_USER) );
		if (hasUSERWARERole) {
			List<Notifications> notificationList3 = notificationsRepository.findAllByOrderByIdDesc();
			if (notificationList3 != null) {
		for (int j = 0; j < notificationList3.size(); j++) {
			Notifications notifications = notificationList3.get(j);
			NotificationDto notificationDto = new NotificationDto();
			if(!principal.getName().equals(notifications.getUserName()) && (notifications.getRequestedTo().equals(InventoryConstant.EVERYONE) && notifications.getNotificationStatus().equals(InventoryConstant.NEW))){
					notificationDto.setId(notifications.getId());
					notificationDto.setQuantity(notifications.getQuantity());
					notificationDto.setRequestedFrom(notifications.getRequestedFrom());
					notificationDto.setNotificationLink(notifications.getNotificationLink());
					notificationDto.setNotificationStatus(notifications.getNotificationStatus());
					notificationDto.setRequestedTo(notifications.getRequestedTo());
					notificationDto.setCreationDate(
							MasterDateUtil.convertDateToStringWithTime(notifications.getCreationDate()));
					notificationDto.setStatus(notifications.getStatus());
					notificationDto.setNotificationMessage(InventoryConstant.TOOLS_REQUEST_FROM + " "
							+ notifications.getRequestedFrom().toUpperCase());
					notificationDto.setCategoryType(notifications.getCategory().getCategoryType());
					notificationDtoList.add(notificationDto);

						}
			else{
				System.out.println("dsd");
			}
		}

			}

		}
		return notificationDtoList;
	}
	
	/*
	 * public List<NotificationDto> getNotificationData(Principal principal) {
	 * 
	 * logger.info(
	 * "<--NotificationServiceImpl-------------getNotificationData--------------------started-->"
	 * );
	 * 
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * List<NotificationDto> notificationDtoList = new ArrayList<>();
	 * List<Notifications> notificationList =
	 * notificationsRepository.getCountNotifications(principal.getName());
	 * Notifications notifications1=null; boolean hasUserRole =
	 * authentication.getAuthorities().stream() .anyMatch(r ->
	 * r.getAuthority().equals(InventoryConstant.USER));
	 * 
	 * if (hasUserRole) { List<ProjectDto> projectDtoList =
	 * inventoryManagementService.getCurrentUserProjectDtoList(principal); if
	 * (projectDtoList != null && !projectDtoList.isEmpty()) { for (int i = 0; i
	 * < projectDtoList.size(); i++) { ProjectDto projectDto =
	 * projectDtoList.get(i); if (projectDto != null) {
	 * 
	 * if (notificationList != null) { for (int j = 0; j <
	 * notificationList.size(); j++) { Notifications notifications =
	 * notificationList.get(j); if
	 * (notifications.getStatus().equals("ITEM DISPATCHED") ||
	 * !notifications.getStatus().equals("PARTIALLY DISPATCHED") &&
	 * !notifications.getStatus().equals("ITEM RECEIVED") ||
	 * notifications.getStatus().equals("REJECTED")) { notificationDtoList
	 * .add(mapNotificationListtoDto(notificationList.get(j), principal));
	 * 
	 * } } }
	 * 
	 * List<Notifications> notificationList1 = notificationsRepository
	 * .findByRequestedToAndNotificationStatus(projectDto.getName(),
	 * InventoryConstant.NEW); if (notificationList1 != null) { for (int j = 0;
	 * j < notificationList1.size(); j++) { Notifications notifications =
	 * notificationList1.get(j); if
	 * (notifications.getStatus().equals("ITEM DISPATCHED") ||
	 * notifications.getStatus().equals("PARTIALLY DISPATCHED") ||
	 * !notifications.getStatus().equals("ITEM RECEIVED") ||
	 * notifications.getStatus().equals("QC APPROVED") ||
	 * notifications.getStatus().equals("REJECTED")) { notificationDtoList
	 * .add(mapNotificationListtoDto(notificationList1.get(j), principal));
	 * 
	 * } } }
	 * 
	 * } } } } boolean hasWarehouseRole =
	 * authentication.getAuthorities().stream() .anyMatch(r ->
	 * r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR)); if
	 * (hasWarehouseRole) { List<WareHouseDto> wareHouseDtosList =
	 * userManagementService.getCurrentUserWareHouseDtoList(principal); if
	 * (wareHouseDtosList != null) { for (int i = 0; i <
	 * wareHouseDtosList.size(); i++) { WareHouseDto wareHouseDto =
	 * wareHouseDtosList.get(i); if (wareHouseDto != null) { List<Notifications>
	 * notificationList1 =
	 * notificationsRepository.getCountNotifications(notifications1.
	 * getRequestedTo()); if (notificationList1 != null) { for (int j = 0; j <
	 * notificationList1.size(); j++) {
	 * 
	 * Notifications notifications = notificationList1.get(j);
	 * if(notifications.getNotificationStatus().equals("NEW")){ if
	 * (!notifications.getStatus().equals("QC VERIFIED") &&
	 * !notifications.getStatus().equals("ITEM DISPATCHED") &&
	 * notifications.getStatus().equals("ITEM RECEIVED") &&
	 * notifications.getNotificationStatus().equals("NEW") ||
	 * notifications.getStatus().equals("Requested") ||
	 * (notifications.getStatus().equals("Received") &&
	 * !notifications.getNotificationStatus().equals("OLD")) ||
	 * notifications.getStatus().equals("QC APPROVED")) {
	 * 
	 * notificationDtoList
	 * .add(mapNotificationListtoDto(notificationList1.get(j), principal)); }
	 * 
	 * } } } } } }
	 * 
	 * } boolean hasOfficeRole = authentication.getAuthorities().stream()
	 * .anyMatch(r ->
	 * r.getAuthority().equals(InventoryConstant.OFFICE_ADMINISTRATOR));
	 * 
	 * if (hasOfficeRole) {
	 * 
	 * List<Notifications> notificationList3 =
	 * notificationsRepository.findAll(); if (notificationList3 != null) { for
	 * (int j = 0; j < notificationList3.size(); j++) {
	 * notificationDtoList.add(mapNotificationListtoDtoForOffice(
	 * notificationList3.get(j), principal));
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * THIS IS FOR EVERYONE
	 * 
	 * 
	 * boolean hasUserRole = authentication.getAuthorities().stream()
	 * .anyMatch(r -> r.getAuthority().equals(InventoryConstant.SUPER_USER) ||
	 * r.getAuthority().equals(InventoryConstant.USER));
	 * 
	 * List<Notifications> notificationList = null;
	 * 
	 * notificationList =
	 * notificationsRepository.findByRequestedToAndNotificationStatus(
	 * InventoryConstant.EVERYONE, InventoryConstant.NEW);
	 * 
	 * if (hasUserRole) {
	 * 
	 * if (notificationList != null) { for (int j = 0; j <
	 * notificationList.size(); j++) {
	 * 
	 * projectDtoList =
	 * inventoryManagementService.getCurrentUserProjectDtoList(principal); if
	 * (projectDtoList != null && !projectDtoList.isEmpty()) { for (int i = 0; i
	 * < projectDtoList.size(); i++) { ProjectDto projectDto =
	 * projectDtoList.get(i); if (projectDto != null) {
	 * 
	 * if (!notificationList.get(j).getRequestedFrom().equals(projectDto.
	 * getName())) { notificationDtoList
	 * .add(mapNotificationListtoDto(notificationList.get(j), principal)); }
	 * 
	 * } } } } }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * logger.info(
	 * "<--InventoryRequestServiceImpl-------------getNotificationData--------------------Ended-->"
	 * ); return notificationDtoList; }
	 */

	/*
	 * private NotificationDto mapNotificationListtoDto(Notifications
	 * notifications, Principal principal) { logger.info(
	 * "<--InventoryRequestServiceImpl-------------mapInventoryRequestEntityToDto--------------------started-->"
	 * ); NotificationDto notificationDto = null; try {
	 * 
	 * notificationDto = new NotificationDto();
	 * 
	 * if (notifications.getRequestedTo().equals(InventoryConstant.EVERYONE)) {
	 * 
	 * notificationDto.setId(notifications.getId());
	 * notificationDto.setQuantity(notifications.getQuantity());
	 * notificationDto.setRequestedFrom(notifications.getRequestedFrom());
	 * notificationDto.setNotificationLink(notifications.getNotificationLink());
	 * notificationDto.setNotificationStatus(notifications.getNotificationStatus
	 * ()); notificationDto.setRequestedTo(notifications.getRequestedTo());
	 * notificationDto
	 * .setCreationDate(MasterDateUtil.convertDateToStringWithTime(notifications
	 * .getCreationDate()));
	 * notificationDto.setStatus(notifications.getStatus());
	 * notificationDto.setNotificationMessage(
	 * InventoryConstant.TOOLS_REQUEST_FROM + " " +
	 * notifications.getRequestedFrom().toUpperCase());
	 * notificationDto.setCategoryType(notifications.getCategory().
	 * getCategoryType()); }
	 * 
	 * if (!notifications.getRequestedTo().equals(InventoryConstant.EVERYONE)) {
	 * WareHouse wareHouse =
	 * wareHouseRepository.findByWareHouseName(notifications.getRequestedTo());
	 * 
	 * if (wareHouse != null) { notificationDto.setId(notifications.getId());
	 * notificationDto.setQuantity(notifications.getQuantity());
	 * notificationDto.setRequestedFrom(notifications.getRequestedFrom());
	 * notificationDto.setNotificationLink(notifications.getNotificationLink());
	 * notificationDto.setNotificationStatus(notifications.getNotificationStatus
	 * ()); notificationDto.setRequestedTo(notifications.getRequestedTo());
	 * notificationDto.setCreationDate(
	 * MasterDateUtil.convertDateToStringWithTime(notifications.getCreationDate(
	 * ))); notificationDto.setStatus(notifications.getStatus()); if
	 * (notifications.getStatus().equals("Requested")) {
	 * notificationDto.setNotificationMessage(
	 * 
	 * InventoryConstant.TOOLS_RECEIVED_FROM + " " +
	 * notifications.getRequestedFrom().toUpperCase()); }
	 * 
	 * if (notifications.getStatus().equals("Received")) {
	 * notificationDto.setNotificationMessage(
	 * 
	 * InventoryConstant.TOOLS_RECEIVED_FROM + " " +
	 * notifications.getRequestedFrom().toUpperCase()); } else if
	 * (notifications.getStatus().equals("ITEM RECEIVED")) {
	 * notificationDto.setNotificationMessage(
	 * 
	 * InventoryConstant.TOOLS_ACCEPTED_BY + " " +
	 * notifications.getRequestedFrom().toUpperCase()); }
	 * 
	 * else if (notifications.getStatus().equals("QC APPROVED")) {
	 * notificationDto.setNotificationMessage(
	 * 
	 * InventoryConstant.TOOLS_ACCEPTED_BY + " " +
	 * notifications.getRequestedFrom().toUpperCase());
	 * 
	 * }
	 * 
	 * notificationDto.setCategoryType(notifications.getCategory().
	 * getCategoryType());
	 * 
	 * }
	 * 
	 * else { Project project =
	 * projectRepository.findByName(notifications.getRequestedTo());
	 * if(notifications.getNotificationStatus().equals("NEW")){ if (project !=
	 * null) { notificationDto.setId(notifications.getId());
	 * notificationDto.setQuantity(notifications.getQuantity());
	 * notificationDto.setRequestedFrom(notifications.getRequestedFrom());
	 * notificationDto.setNotificationLink(notifications.getNotificationLink());
	 * notificationDto.setRequestedTo(notifications.getRequestedTo());
	 * notificationDto.setCreationDate(
	 * MasterDateUtil.convertDateToStringWithTime(notifications.getCreationDate(
	 * )));
	 * notificationDto.setNotificationStatus(notifications.getNotificationStatus
	 * ()); notificationDto.setStatus(notifications.getStatus()); if
	 * (notifications.getStatus().equals("ITEM DISPATCHED") ||
	 * notifications.getStatus().equals("PARTIALLY DISPATCHED")) {
	 * notificationDto.setNotificationMessage(InventoryConstant.
	 * TOOLS_RECEIVED_FROM + " " +
	 * notifications.getRequestedFrom().toUpperCase()); } else if
	 * (notifications.getStatus().equals("ITEM RECEIVED")) {
	 * 
	 * notificationDto.setNotificationMessage(InventoryConstant.
	 * TOOLS_ACCEPTED_BY + " " + notifications.getRequestedTo().toUpperCase());
	 * } else if (notifications.getStatus().equals("PENDING")) {
	 * 
	 * notificationDto.setNotificationMessage(InventoryConstant.
	 * TOOLS_RECEIVED_FROM + " " +
	 * notifications.getRequestedFrom().toUpperCase()); }
	 * 
	 * notificationDto.setCategoryType(notifications.getCategory().
	 * getCategoryType()); } }
	 * 
	 * 
	 * }
	 * 
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); boolean
	 * hasUserWarehouseRole = authentication.getAuthorities().stream()
	 * .anyMatch(r ->
	 * r.getAuthority().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR) ||
	 * r.getAuthority().equals(InventoryConstant.USER)); if
	 * (hasUserWarehouseRole) { if
	 * ((notifications.getRequestedTo().equals("OFFICE"))) {
	 * notificationDto.setId(notifications.getId());
	 * notificationDto.setQuantity(notifications.getQuantity());
	 * notificationDto.setRequestedFrom(notifications.getRequestedFrom());
	 * notificationDto.setNotificationLink(notifications.getNotificationLink());
	 * notificationDto.setNotificationStatus(notifications.getNotificationStatus
	 * ()); notificationDto.setCreationDate(
	 * MasterDateUtil.convertDateToStringWithTime(notifications.getCreationDate(
	 * ))); notificationDto.setRequestedTo(notifications.getRequestedTo());
	 * notificationDto.setStatus(notifications.getStatus()); if
	 * (notifications.getStatus().equals("QC APPROVED")) { notificationDto
	 * .setNotificationMessage(InventoryConstant.TOOLS_ACCEPTED_BY + " " +
	 * "OFFICE"); } else if (notifications.getStatus().equals("REJECTED")) {
	 * notificationDto
	 * .setNotificationMessage(InventoryConstant.TOOLS_REJECTED_BY + " " +
	 * "OFFICE");
	 * 
	 * } notificationDto.setCategoryType(notifications.getCategory().
	 * getCategoryType());
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } logger.info(
	 * "<--InventoryRequestServiceImpl-------------mapInventoryRequestEntityToDto--------------------Ended-->"
	 * ); return notificationDto; }
	 */

	@Override
	public ResponseDto updateNotificationStatus(NotificationDto notificationDto, Principal principal) {
		logger.info(
				"<--InventoryRequestServiceImpl-------------updateNotificationStatus--------------------started-->");
		ResponseDto responseDto = new ResponseDto();
		if (notificationDto != null) {
			Notifications notifications = notificationsRepository.findOne(notificationDto.getId());
			if (notifications != null) {
				notifications.setNotificationStatus(InventoryConstant.OLD);
				notificationsRepository.save(notifications);
				if (notifications != null) {
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
			}
		}
		logger.info("<--InventoryRequestServiceImpl-------------updateNotificationStatus--------------------Ended-->");
		return responseDto;
	}

	
	private NotificationDto mapNotificationListtoDtoForOffice(Notifications notifications, Principal principal) {
		NotificationDto notificationDto = null;
		try {
			notificationDto = new NotificationDto();
				notificationDto.setId(notifications.getId());
				notificationDto.setQuantity(notifications.getQuantity());
				notificationDto.setRequestedFrom(notifications.getRequestedFrom());
				notificationDto.setNotificationLink(notifications.getNotificationLink());
				notificationDto.setCreationDate(
						MasterDateUtil.convertDateToStringWithTime(notifications.getCreationDate()));
				notificationDto.setNotificationStatus(notifications.getNotificationStatus());
				notificationDto.setRequestedTo(notifications.getRequestedTo());
				notificationDto.setStatus(notifications.getStatus());
				notificationDto.setCategoryType(notifications.getCategory().getCategoryType());
				if (notifications.getRequestedTo().equals("OFFICE")) {
			    if(notifications.getUserName().equals("SCRAP")){
				notificationDto.setNotificationMessage(InventoryConstant.TOOLS_RECEIVED_FROM + " "
						+ notifications.getRequestedFrom().toUpperCase() + " " + notifications.getUserName());
			}
			 else if(notifications.getUserName().equals("SERVICE")){
				notificationDto.setNotificationMessage(InventoryConstant.TOOLS_RECEIVED_FROM + " "
							+ notifications.getRequestedFrom().toUpperCase() + " " + notifications.getUserName());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notificationDto;
	}

}


