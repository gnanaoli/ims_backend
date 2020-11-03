package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.SafetyStatusDto;
import com.fa.inventory.entity.SafetyStatus;
import com.fa.inventory.repository.SafetyStatusRespository;
import com.fa.inventory.service.SafetyService;

@Service
public class SafetyStatusServiceImpl implements SafetyService {

	protected final Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Resource
	SafetyStatusRespository safetyStatusRespository;

	@Override
	public List<SafetyStatusDto> getAllSafetyStatus(Principal principal) {

		List<SafetyStatusDto> safetyStatusDtoList = null;

		logger.info("<--SafetyStatusServiceImpl-------------getAllSafetyStatus--------------------started-->");
		try {
			List<SafetyStatus> safetyStatusEntities = safetyStatusRespository.findAll();

			if (safetyStatusEntities != null && !safetyStatusEntities.isEmpty()) {

				safetyStatusDtoList = new ArrayList<>();

				for (int i = 0; i < safetyStatusEntities.size(); i++) {

					SafetyStatus safetyStatus = safetyStatusEntities.get(i);

					if (safetyStatus != null) {

						SafetyStatusDto safetyStatusDto = new SafetyStatusDto();

						safetyStatusDto.setStatusName(safetyStatus.getStatusName());
						safetyStatusDto.setStatus(safetyStatus.getStatus());
						safetyStatusDto.setId(safetyStatus.getId());

						safetyStatusDtoList.add(safetyStatusDto);

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--SafetyStatusServiceImpl-------------getAllSafetyStatus--------------------Ended-->");

		return safetyStatusDtoList;
	}

	@Override
	public String saveSafetyStatus(SafetyStatusDto safetyStatusDto, Principal principal) throws Exception {

		String status = InventoryConstant.FAILURE;
		SafetyStatus safetyStatus = new SafetyStatus();
		logger.info("<--SafetyStatusServiceImpl-------------saveSafetyStatus--------------------started-->");

		if (safetyStatusDto != null && safetyStatusDto.getId() != null) {
			safetyStatus = new SafetyStatus();
			safetyStatus = safetyStatusRespository.findOne(safetyStatusDto.getId());
			if (safetyStatus != null)
				if (safetyStatus.getStatusName().equals(safetyStatusDto.getStatusName())) {
					safetyStatus.setId(safetyStatusDto.getId());
					safetyStatus.setStatusName(safetyStatusDto.getStatusName());
					safetyStatus.setStatus(safetyStatusDto.getStatus());
				} else {

					safetyStatus = safetyStatusRespository.findByStatusName(safetyStatusDto.getStatusName());
					if (safetyStatus != null) {
						throw new Exception(InventoryConstant.THIS_SAFTY_STATUS_ALREADY_EXISTS);
					} else {
						safetyStatus = new SafetyStatus();
						safetyStatus.setId(safetyStatusDto.getId());
						safetyStatus.setStatusName(safetyStatusDto.getStatusName());
						safetyStatus.setStatus(safetyStatusDto.getStatus());
					}
				}

		} else {

			safetyStatus = safetyStatusRespository.findByStatusName(safetyStatusDto.getStatusName());
			if (safetyStatus != null) {
				throw new Exception(InventoryConstant.THIS_SAFTY_STATUS_ALREADY_EXISTS);
			} else {
				safetyStatus = new SafetyStatus();
				safetyStatus.setStatusName(safetyStatusDto.getStatusName());
				safetyStatus.setStatus(InventoryConstant.ACTIVE);
			}
		}

		safetyStatus = safetyStatusRespository.save(safetyStatus);
		if (safetyStatus != null) {
			status = InventoryConstant.SUCCESS;
		}

		logger.info("<--SafetyService-------------saveSafetyStatus--------------------Ended-->");
		return status;
	}

}
