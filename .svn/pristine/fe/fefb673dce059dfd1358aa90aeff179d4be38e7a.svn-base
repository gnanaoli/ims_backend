package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.controller.InventoryController1;
import com.fa.inventory.dto.DesignationDto;
import com.fa.inventory.entity.Designation;
import com.fa.inventory.entity.Employee;
import com.fa.inventory.repository.DesignationRepository;
import com.fa.inventory.repository.EmployeeRepository;
import com.fa.inventory.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Resource
	DesignationRepository designationRepository;

	@Resource
	EmployeeRepository empRepository;

	protected final Logger logger = Logger.getLogger(InventoryController1.class);

	public String saveDesignation(DesignationDto designationDto, Principal principal) throws Exception {
		String status = InventoryConstant.FAILURE;
		Designation designation = new Designation();

		List<Object> designationList = null;

		logger.info("<--ProjectServiceImpl-------------saveDesignation--------------------started-->");

		if (designationDto != null && designationDto.getId() != null) {
			designation = new Designation();
			designation = designationRepository.findOne(designationDto.getId());

			designationList = empRepository.findByDesignation(designationDto.getDesignation());

			if (designationList.size() > 0) {
				throw new Exception(InventoryConstant.ALREADY_ASSIGNED);
			}

			if (designation.getDesignation().equals(designationDto.getDesignation())) {
				designation.setId(designationDto.getId());
				designation.setDesignation(designationDto.getDesignation());
				designation.setStatus(designationDto.getStatus());

				designation.setCreatedBy(designation.getCreatedBy());
				designation.setCreationDate(new Date());
				designation.setLastModifiedBy(principal.getName());
				designation.setLastModifiedDate(new Date());
			} else {

				designation = designationRepository.findByDesignation(designationDto.getDesignation());
				if (designation != null) {
					throw new Exception(InventoryConstant.THIS_DESIGNATION_ALREADY_EXISTS);
				} else {
					designation = new Designation();
					designation.setId(designationDto.getId());
					designation.setDesignation(designationDto.getDesignation());
					designation.setStatus(designationDto.getStatus());
					designation.setCreatedBy(principal.getName());
					designation.setCreationDate(new Date());
					designation.setLastModifiedBy(principal.getName());
					designation.setLastModifiedDate(new Date());
				}
			}

		} else {

			designation = designationRepository.findByDesignation(designationDto.getDesignation());
			if (designation != null) {
				throw new Exception(InventoryConstant.THIS_DESIGNATION_ALREADY_EXISTS);
			} else {
				designation = new Designation();
				designation.setDesignation(designationDto.getDesignation());
				designation.setStatus(InventoryConstant.ACTIVE);
				designation.setCreatedBy(principal.getName());
				designation.setCreationDate(new Date());
				designation.setLastModifiedBy(principal.getName());
				designation.setLastModifiedDate(new Date());
			}
		}

		designation = designationRepository.save(designation);
		if (designation != null) {
			status = InventoryConstant.SUCCESS;
		}

		logger.info("<--ProjectService-------------saveDesignation--------------------Ended-->");
		return status;
	}
}