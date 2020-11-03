package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.DispatcherLogDto;
import com.fa.inventory.dto.ELCPDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ScrapDto;
import com.fa.inventory.dto.ServiceTrackerDto;
import com.fa.inventory.dto.WorksMenDetailsDto;
import com.fa.inventory.entity.DispatcherLog;
import com.fa.inventory.entity.ELCB;
import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.InventoryRequest;
import com.fa.inventory.entity.Scrap;
import com.fa.inventory.entity.ServiceTracker;
import com.fa.inventory.entity.WorksMenDetails;
import com.fa.inventory.repository.ELCBRepository;
import com.fa.inventory.repository.InventoryRequestRepository;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.ScrapRepository;
import com.fa.inventory.repository.ServiceTrackerRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.DispatchLogService;
import com.fa.inventory.service.ELCBService;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.ReportService;
import com.fa.inventory.service.ScrapService;
import com.fa.inventory.service.ServiceTrackerService;
import com.fa.inventory.service.ToolsRequestService;
import com.fa.inventory.service.WorksMenService;

@Service
public class ReportServiceImpl implements ReportService {
	private Logger logger = Logger.getLogger(getClass());
	@Resource
	UserRepository userRepository;
	@Resource
	InventoryStockRepository inventoryStockRepository;

	@Resource
	InventoryManagementService inventoryManagementService;
	@Resource
	ScrapRepository scrapRepository;
	@Resource
	InventoryRequestRepository inventoryRequestRepository;
	@Resource
	ToolsRequestService toolsRequestService;
	@Resource
	ELCBRepository eLCBRepository;
	@Resource
	ELCBService eLCBService;
	@Resource
	ServiceTrackerRepository serviceTrackerRepository;
	@Resource
	ServiceTrackerService serviceTrackerService;
	@Resource
	WorksMenService worksMenService;
	@Resource
	ScrapService scrapService;
	@Resource
	DispatchLogService dispatchLogService;

	@PersistenceContext
	@Resource
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryEntranceDto> inventoryReport(InventoryEntranceDto reportsDto,
			List<String> projectAndWareHouseName, Principal principal) {

		logger.info("<--Report serviceImpl-------------inventoryReport--------------------started-->");

		List<InventoryEntrance> inventoryEntranceList = new ArrayList<>();
		List<InventoryEntranceDto> inventoryEntranceDtoList = new ArrayList<>();

		// List<Object> ss =null;
		// inventoryEntranceList=inventoryStockRepository.getInventoryReport(reportsDto.getFromDate(),reportsDto.getToDate());
		/*
		 * .setParameter("startDate",MasterDateUtil.convertStringToTimeStampDate
		 * (reportsDto.getFromDate())
		 * .setParameter("endDate",MasterDateUtil.convertStringToTimeStampDate(
		 * reportsDto.getToDate()) .getResultList()));
		 */
		/*
		 * Query query = entityManager.
		 * createQuery("SELECT e FROM InventoryEntrance e WHERE e.creationDate BETWEEN :startDate AND :endDate"
		 * );
		 * 
		 * query.setParameter("startDate",
		 * MasterDateUtil.converTimeStamp(reportsDto.getFromDate()+" 00:00:00"))
		 * ; query.setParameter("endDate",
		 * MasterDateUtil.converTimeStamp(reportsDto.getToDate()+" 23:59:59"));
		 * inventoryEntranceList= query.getResultList();
		 */
		if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
			Query query = entityManager.createNativeQuery(
					"select (SELECT C.category_type FROM category C WHERE ID=category_id) AS CategoryType,(SELECT S.sub_category FROM subcategory S WHERE ID=subcategory_id) AS sub_category,available_quantity,model_code,inventory_number,warehouse_sitename from inventory_stock  where creation_date BETWEEN :startDate AND :endDate AND warehouse_sitename IN(:projectAndWareHouseName)  union SELECT (SELECT C.category_type FROM category C WHERE ID=ia.category_id) AS CategoryType ,(SELECT S.sub_category FROM subcategory S WHERE ID=ia.subcategory_id) AS sub_category,ia.available_qty,ia.model_code,inventory_number,ia.assigned_location FROM inventory_assign ia  where ia.creation_date BETWEEN :startDate AND :endDate AND ia.assigned_location IN(:projectAndWareHouseName)");

			query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
			query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
			query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
			inventoryEntranceList = query.getResultList();
			
        
			if (inventoryEntranceList != null && !inventoryEntranceList.isEmpty()) {
				for (int j = 0; j < inventoryEntranceList.size(); j++) {
				/*InventoryEntrance inventoryEntrance=inventoryEntranceList.get(j);
					if(inventoryEntrance!=null)
					{
						if(inventoryEntrance.getAvailableQuantity()>0 )
						{*/
								Object object = inventoryEntranceList.get(j);
								if (object != null) {
									Object[] objRow = (Object[]) object;
									InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
									inventoryEntranceDto.setAvailableQuantity(Integer.valueOf((objRow[2].toString())));
									if(inventoryEntranceDto.getAvailableQuantity()>0 )
										{
										inventoryEntranceDto.setCategoryType(objRow[0].toString());
										inventoryEntranceDto.setSubCategory(objRow[1].toString());
												
										inventoryEntranceDto.setModelCode(objRow[3].toString());
										inventoryEntranceDto.setInventoryNumber(objRow[4].toString());
										inventoryEntranceDto.setAssignedLocation(objRow[5].toString());
										inventoryEntranceDtoList.add(inventoryEntranceDto);
									}
									
								}
							}
					
				
			}
		}
					 
		else  if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {
			// Query query = entityManager.createQuery("SELECT e FROM
			// InventoryEntrance e WHERE e.wareHouseSiteName
			// IN(:projectAndWareHouseName)");

			Query query1 = entityManager.createNativeQuery(
					"select (SELECT C.category_type FROM category C WHERE ID=category_id) AS CategoryType,(SELECT S.sub_category FROM subcategory S WHERE ID=subcategory_id) AS sub_category,available_quantity,model_code,inventory_number,warehouse_sitename from inventory_stock  where warehouse_sitename IN(:projectAndWareHouseName)  union SELECT (SELECT C.category_type FROM category C WHERE ID=ia.category_id) AS CategoryType ,(SELECT S.sub_category FROM subcategory S WHERE ID=ia.subcategory_id) AS sub_category,ia.available_qty,ia.model_code,inventory_number,ia.assigned_location FROM inventory_assign ia  where ia.assigned_location IN(:projectAndWareHouseName)");

			query1.setParameter("projectAndWareHouseName", projectAndWareHouseName);
			// inventoryEntranceList= query.getResultList();
			List resultList = query1.getResultList();

			
			
			if (resultList != null && !resultList.isEmpty()) {
				for (int j = 0; j < resultList.size(); j++) {
					/*InventoryEntrance inventoryEntrance=inventoryEntranceList.get(j);
					if(inventoryEntrance!=null)
					{
						if(inventoryEntrance.getAvailableQuantity()>0 )
						{*/
					Object object = resultList.get(j);
					if (object != null) {
						Object[] objRow = (Object[]) object;
						InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
						inventoryEntranceDto.setAvailableQuantity(Integer.valueOf((objRow[2].toString())));
						if(inventoryEntranceDto.getAvailableQuantity()>0 )
						{
							inventoryEntranceDto.setCategoryType(objRow[0].toString());
							inventoryEntranceDto.setSubCategory(objRow[1].toString());
							inventoryEntranceDto.setModelCode(objRow[3].toString());
							inventoryEntranceDto.setInventoryNumber(objRow[4].toString());
							inventoryEntranceDto.setAssignedLocation(objRow[5].toString());
							inventoryEntranceDtoList.add(inventoryEntranceDto);
							
						}
					}
					
				
			}
			}
//			Object collect = resultList.stream().map(ie -> {
//				Object[] objRow = (Object[]) ie;
//				InventoryEntranceDto inventoryEntranceDto = new InventoryEntranceDto();
//				if (objRow != null && objRow.length > 0) {
//					inventoryEntranceDto.setCategoryType(objRow[0].toString());
//					inventoryEntranceDto.setSubCategory(objRow[1].toString());
//					inventoryEntranceDto.setAvailableQuantity(Integer.valueOf((objRow[2].toString())));
//					inventoryEntranceDto.setModelCode(objRow[3].toString());
//					inventoryEntranceDto.setInventoryNumber(objRow[4].toString());
//					inventoryEntranceDto.setAssignedLocation(objRow[5].toString());
//					/*
//					 * inventoryEntranceDto.setModelName(inventoryEntrance.
//					 * getModelName());
//					 * inventoryEntranceDto.setSupplierName(inventoryEntrance.
//					 * getSupplierName());
//					 */
//				}
//				return inventoryEntranceDto;
//			}).collect(Collectors.toList());

			
			/* inventoryEntranceDtoList =
			  inventoryEntranceList.stream().filter(ie ->
			  ie.getAvailableQuantity() > 0).map(ie -> { return
			  inventoryManagementService.mapInventoryDto(ie);
			  }).collect(Collectors.toList());*/
			 

			//System.out.println(!inventoryEntranceDtoList.isEmpty() ? inventoryEntranceDtoList.size() : 0);

		}

		
		 
		  
		 /* InventoryEntrance inventoryEntrance = inventoryEntranceList.get(i);
		  InventoryEntrance inventoryEntrance = new InventoryEntrance();
		 inventoryEntranceList.forEach(x->{ InventoryEntrance
		 inventoryEntrance = new InventoryEntrance();
		  BeanUtils.copyProperties(x, inventoryEntrance);
		  */
		  
		 

		logger.info("<--Report serviceImpl-------------inventoryReport--------------------ended-->");

		return inventoryEntranceDtoList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScrapDto> scrapReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,
			Principal principal) {
		logger.info("<--Report serviceImpl-------------scrapReport--------------------started-->");

		List<Scrap> scarpList = new ArrayList<>();
		List<ScrapDto> scrapDtoList = new ArrayList<>();
		try {
			// scarpList=scrapRepository.getScrapReport(reportsDto.getFromDate(),reportsDto.getToDate());

			/*
			 * Query query = entityManager.createQuery(
			 * "SELECT e FROM Scrap e WHERE e.lastModifiedDate BETWEEN :startDate AND :endDate"
			 * );
			 * 
			 * query.setParameter("startDate",
			 * MasterDateUtil.converTimeStamp(reportsDto.getFromDate()
			 * +" 00:00:00")); query.setParameter("endDate",
			 * MasterDateUtil.converTimeStamp(reportsDto.getToDate()+" 23:59:59"
			 * )); scarpList= query.getResultList();
			 */

			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM Scrap e WHERE e.lastModifiedDate BETWEEN :startDate AND :endDate AND (e.warehouseSiteName IN(:projectAndWareHouseName) OR e.fromLocation IN(:projectAndWareHouseName))");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				scarpList = query.getResultList();
			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM Scrap e WHERE e.warehouseSiteName IN(:projectAndWareHouseName) OR e.fromLocation IN(:projectAndWareHouseName)");

				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				scarpList = query.getResultList();
			}

			for (int i = 0; i < scarpList.size(); i++) {
				Scrap scrap = scarpList.get(i);
				if (scrap != null) {

					scrapDtoList.add(scrapService.mapScrapDto(scrap));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--Report serviceImpl-------------scrapReport--------------------Ended-->");
		return scrapDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryRequestDto> requestsReport(InventoryEntranceDto reportsDto,
			List<String> projectAndWareHouseName, Principal principal) {
		logger.info("<--Report serviceImpl-------------getRequestReport--------------------started-->");

		List<InventoryRequest> inventoryRequestList = new ArrayList<>();
		List<InventoryRequestDto> inventoryRequestDtoList = new ArrayList<>();
		try {

			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM InventoryRequest e WHERE e.raisedDate BETWEEN :startDate AND :endDate AND requestedFrom IN (:projectAndWareHouseName)");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				inventoryRequestList = query.getResultList();

			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {

				Query query = entityManager.createQuery(
						"SELECT e FROM InventoryRequest e WHERE  requestedFrom IN (:projectAndWareHouseName)");

				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				inventoryRequestList = query.getResultList();
			}

			// inventoryRequestList=inventoryRequestRepository.getRequestReport(reportsDto.getFromDate(),reportsDto.getToDate());
			/*
			 * Query query = entityManager.createQuery(
			 * "SELECT e FROM InventoryRequest e WHERE e.raisedDate BETWEEN :startDate AND :endDate"
			 * );
			 * 
			 * query.setParameter("startDate",
			 * MasterDateUtil.converTimeStamp(reportsDto.getFromDate()
			 * +" 00:00:00")); query.setParameter("endDate",
			 * MasterDateUtil.converTimeStamp(reportsDto.getToDate()+" 23:59:59"
			 * )); inventoryRequestList= query.getResultList();
			 */
			for (int i = 0; i < inventoryRequestList.size(); i++) {
				InventoryRequest inventoryRequest = inventoryRequestList.get(i);
				if (inventoryRequest != null) {

					inventoryRequestDtoList.add(toolsRequestService.mapInventoryRequestDtoById(inventoryRequest));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--Report serviceImpl-------------getRequestReport--------------------Ended-->");

		return inventoryRequestDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> serviceReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,
			Principal principal) {
		logger.info("<--Report serviceImpl-------------serviceReport--------------------started-->");
		List<ServiceTracker> serviceList = new ArrayList<>();
		List<ServiceTrackerDto> serviceTrackerDtoList = new ArrayList<>();
		try {

			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM ServiceTracker e WHERE e.lastModifiedDate BETWEEN :startDate AND :endDate AND (e.warehouseSiteName IN(:projectAndWareHouseName) OR e.fromLocation IN(:projectAndWareHouseName))");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				serviceList = query.getResultList();
			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {

				Query query = entityManager.createQuery(
						"SELECT e FROM ServiceTracker e WHERE fromLocation IN (:projectAndWareHouseName) OR e.warehouseSiteName IN(:projectAndWareHouseName)");

				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				serviceList = query.getResultList();
			}
			// serviceList=serviceTrackerRepository.getServiceReport(reportsDto.getFromDate(),reportsDto.getToDate());

			for (int i = 0; i < serviceList.size(); i++) {
				ServiceTracker serviceTracker = serviceList.get(i);
				if (serviceTracker != null) {

					serviceTrackerDtoList.add(serviceTrackerService.mapServiceTrackerDtoById(serviceTracker));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--Report serviceImpl-------------serviceReport--------------------Ended-->");
		return serviceTrackerDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ELCPDto> elcbReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,
			Principal principal) {

		logger.info("<--Report serviceImpl-------------elcbReport--------------------started-->");

		List<ELCB> ELCBList = new ArrayList<>();
		List<ELCPDto> ELCPDtoList = new ArrayList<>();
		try {

			// ELCBList=eLCBRepository.getElcpReport(reportsDto.getFromDate(),reportsDto.getToDate());
			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM ELCB e WHERE e.updatedTime BETWEEN :startDate AND :endDate AND projectName IN (:projectAndWareHouseName)");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				ELCBList = query.getResultList();
			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {
				Query query = entityManager
						.createQuery("SELECT e FROM ELCB e WHERE projectName IN (:projectAndWareHouseName)");

				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				ELCBList = query.getResultList();

			}

			for (int i = 0; i < ELCBList.size(); i++) {
				ELCB elcb = ELCBList.get(i);
				if (elcb != null) {

					ELCPDtoList.add(eLCBService.mapELCBDto(elcb));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--Report serviceImpl-------------elcbReport--------------------Ended-->");
		return ELCPDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> worksMenDetailsReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,
			Principal principal) {
		logger.info("<--Report serviceImpl-------------worksMenDetailsReport--------------------started-->");

		List<WorksMenDetails> worksMenDetailsList = new ArrayList<>();
		List<WorksMenDetailsDto> worksMenDetailsDtoList = new ArrayList<>();
		try {

			// ELCBList=eLCBRepository.getElcpReport(reportsDto.getFromDate(),reportsDto.getToDate());
			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM WorksMenDetails e WHERE e.lastModifiedDate BETWEEN :startDate AND :endDate AND projectName IN (:projectAndWareHouseName)");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));

				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				worksMenDetailsList = query.getResultList();

			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM WorksMenDetails e WHERE  projectName IN (:projectAndWareHouseName)");

				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				worksMenDetailsList = query.getResultList();
			}

			for (int i = 0; i < worksMenDetailsList.size(); i++) {
				WorksMenDetails worksMenDetails = worksMenDetailsList.get(i);
				if (worksMenDetails != null) {

					worksMenDetailsDtoList.add(worksMenService.mapWorksMenDto(worksMenDetails));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--Report serviceImpl-------------worksMenDetailsReport--------------------Ended-->");
		return worksMenDetailsDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> inventoryInwordsReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,
			Principal principal) {
		logger.info("<--Report serviceImpl-------------worksMenDetailsReport--------------------started-->");

		List<DispatcherLog> dispatcherLogList = new ArrayList<>();
		List<DispatcherLogDto> dispatcherLogDtoList = new ArrayList<>();
		try {

			// ELCBList=eLCBRepository.getElcpReport(reportsDto.getFromDate(),reportsDto.getToDate());
			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM DispatcherLog e WHERE e.raisedDate BETWEEN :startDate AND :endDate AND requestedTo IN (:projectAndWareHouseName) AND e.status IN (:itemReceived)");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
				query.setParameter("itemReceived", InventoryConstant.ITEM_RECEIVED);
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				dispatcherLogList = query.getResultList();

			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM DispatcherLog e WHERE  requestedTo IN (:projectAndWareHouseName) AND e.status IN (:itemReceived)");
				query.setParameter("itemReceived", InventoryConstant.ITEM_RECEIVED);
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				dispatcherLogList = query.getResultList();
			}

			for (int i = 0; i < dispatcherLogList.size(); i++) {
				DispatcherLog dispatcherLog = dispatcherLogList.get(i);
				if (dispatcherLog != null) {

					dispatcherLogDtoList.add(dispatchLogService.mapDispatcherLogDto(dispatcherLog));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--Report serviceImpl-------------worksMenDetailsReport--------------------Ended-->");
		return dispatcherLogDtoList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> inventoryOutwordsReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,
			Principal principal) {
		logger.info("<--Report serviceImpl-------------worksMenDetailsReport--------------------started-->");

		List<DispatcherLog> dispatcherLogList = new ArrayList<>();
		List<DispatcherLogDto> dispatcherLogDtoList = new ArrayList<>();
		try {

			// ELCBList=eLCBRepository.getElcpReport(reportsDto.getFromDate(),reportsDto.getToDate());
			if (reportsDto.getReportCategory().equalsIgnoreCase("DateWise")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM DispatcherLog e WHERE e.raisedDate BETWEEN :startDate AND :endDate AND  e.requestedFrom IN (:projectAndWareHouseName) AND e.status IN (:itemReceived)");

				query.setParameter("startDate", MasterDateUtil.converTimeStamp(reportsDto.getFromDate() + " 00:00:00"));
				query.setParameter("endDate", MasterDateUtil.converTimeStamp(reportsDto.getToDate() + " 23:59:59"));
				query.setParameter("itemReceived", InventoryConstant.ITEM_RECEIVED);
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				dispatcherLogList = query.getResultList();

			} else if (reportsDto.getReportCategory().equalsIgnoreCase("All")) {
				Query query = entityManager.createQuery(
						"SELECT e FROM DispatcherLog e WHERE e.requestedFrom IN (:projectAndWareHouseName) AND e.status IN (:itemReceived)");
				query.setParameter("itemReceived", InventoryConstant.ITEM_RECEIVED);
				query.setParameter("projectAndWareHouseName", projectAndWareHouseName);
				dispatcherLogList = query.getResultList();
			}

			for (int i = 0; i < dispatcherLogList.size(); i++) {
				DispatcherLog dispatcherLog = dispatcherLogList.get(i);
				if (dispatcherLog != null) {

					dispatcherLogDtoList.add(dispatchLogService.mapDispatcherLogDto(dispatcherLog));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--Report serviceImpl-------------worksMenDetailsReport--------------------Ended-->");
		return dispatcherLogDtoList;
	}

}
