package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.controller.InventoryController1;
import com.fa.inventory.dto.DeliveryChallanDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.entity.DeliveryChallanEntity;
import com.fa.inventory.service.DeliveryChallanService;


@Service
@Transactional("InventoryTransactionManager")
public class DeliveryChallanServiceImpl implements DeliveryChallanService {

	
	
	@Resource
	DeliveryChallanService deliveryChallanService;
	
	@PersistenceContext(unitName="InventoryFactory")
	EntityManager entityManager;
	
	protected final Logger logger =	 Logger.getLogger(InventoryController1.class);
	
	
	/*@Override
	public List<?> getalldeliverychallan(InventoryEntranceDto reportDto, Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<?> getalldeliverychallan(InventoryEntranceDto reportsDto, Principal principal) {
		logger.info("<--Report serviceImpl-------------scrapReport--------------------started-->");
		
		List<DeliveryChallanEntity> DeliveryChallanEntityList =new ArrayList<>();
		List<DeliveryChallanDto> DeliveryChallanDtoList=new ArrayList<>();
		try{
			 Query query = entityManager.createQuery("SELECT e FROM DeliveryChallanEntity e WHERE e.dispatchDate BETWEEN :startDate AND :endDate");
			 query.setParameter("startDate",MasterDateUtil.convertStringToDateWithoutTime(reportsDto.getFromDate()));
			 query.setParameter("endDate",MasterDateUtil.convertStringToDateWithoutTime(reportsDto.getToDate()));
			 DeliveryChallanEntityList= query.getResultList();
		for(int i=0;i<DeliveryChallanEntityList.size();i++)
		{
			DeliveryChallanEntity deliveryChallanEntity=DeliveryChallanEntityList.get(i);
			if(deliveryChallanEntity!=null)
			{
				
				DeliveryChallanDtoList.add(mapDeliveryChallanDto(deliveryChallanEntity));
				} 
		}
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--Report serviceImpl-------------scrapReport--------------------Ended-->");
		return DeliveryChallanDtoList;
	}
	
	
	
	@Override
	public DeliveryChallanDto mapDeliveryChallanDto(DeliveryChallanEntity deliveryChallanEntity) {
		DeliveryChallanDto deliveryChallanDto= new DeliveryChallanDto();
		try{
			deliveryChallanDto.setId(deliveryChallanEntity.getId());
			deliveryChallanDto.setConsigneeName(deliveryChallanEntity.getConsigneeName());
			deliveryChallanDto.setConsigneeAddress(deliveryChallanEntity.getConsigneeAddress());
			deliveryChallanDto.setDcDate(deliveryChallanEntity.getDcDate());
			deliveryChallanDto.setDelyChallan(deliveryChallanEntity.getDelyChallan());
			deliveryChallanDto.setDispatchDate(MasterDateUtil.convertDateToString(deliveryChallanEntity.getDispatchDate()));
			deliveryChallanDto.setVehicleNo(deliveryChallanEntity.getVehicleNo());
			deliveryChallanDto.setTransCompany(deliveryChallanEntity.getTransCompany());
			deliveryChallanDto.setGstIn(deliveryChallanEntity.getGstIn());
			deliveryChallanDto.setRate(deliveryChallanEntity.getRate());
			deliveryChallanDto.setCode(deliveryChallanEntity.getCode());
			deliveryChallanDto.setChallanNo(deliveryChallanEntity.getChallanNo());
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return deliveryChallanDto;
	}

}
