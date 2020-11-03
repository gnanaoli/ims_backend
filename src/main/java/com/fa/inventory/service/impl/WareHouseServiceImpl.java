package com.fa.inventory.service.impl;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.WareHouseBlocksDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.InventoryEntrance;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.entity.WareHouseBlocks;
import com.fa.inventory.repository.InventoryStockRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.repository.WareHouseBlockRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.WareHouseService;

@Service
public class WareHouseServiceImpl implements WareHouseService {

	protected final Logger logger = Logger.getLogger(ProjectServiceImpl.class);
	@Resource
	WareHouseRepository wareHouseRepository;

	@Resource
	WareHouseBlockRepository wareHouseBlockRepository;

	@Resource
	UserRepository userRepository;

	@Resource
	InventoryStockRepository inventoryStockRepository;

	/* FOR GET VALUE TO WARE HOUSE TABLE */
	@Override
	public List<WareHouseDto> getwareHouseList(Principal principal) {
		List<WareHouseDto> wareHouseDtoList = null;
		logger.info("<--WareHouse Service impl-------------getWareHouseList--------------------started-->");
		try {
			List<WareHouse> wareHouseList = wareHouseRepository.findAll();

			if (wareHouseList != null && !wareHouseList.isEmpty()) {
				wareHouseDtoList = new ArrayList<>();
				for (int i = 0; i < wareHouseList.size(); i++) {
					WareHouse wareHouse = wareHouseList.get(i);
					if (wareHouse != null) {
						wareHouseDtoList.add(MapWareHouseDto(wareHouse, principal));

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--WarehouseService-------------getProjectList--------------------Ended-->");
		return wareHouseDtoList;
	}

	public WareHouseDto MapWareHouseDto(WareHouse wareHouse, Principal principal) {
		logger.info("<--WarehouseServiceImpl-------------MapWareHouseDto--------------------started-->");
		WareHouseDto wareHouseDto = new WareHouseDto();
		try {

			wareHouseDto.setId(wareHouse.getId());
			wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
			wareHouseDto.setCode(wareHouse.getCode());
			wareHouseDto.setParentCode(wareHouse.getParentCode());
			wareHouseDto.setAddress1(wareHouse.getAddress1());
			wareHouseDto.setAddress2(wareHouse.getAddress2());
			wareHouseDto.setAddress3(wareHouse.getAddress3());
			wareHouseDto.setAreaLandmark(wareHouse.getAreaLandmark());
			wareHouseDto.setState(wareHouse.getState());
			wareHouseDto.setCity(wareHouse.getCity());
			wareHouseDto.setPinCode(Integer.toString(wareHouse.getPincode()));
			wareHouseDto.setCountry(wareHouse.getCountry());
			wareHouseDto.setEffectiveStartDate(MasterDateUtil.convertDateToString(wareHouse.getEffectiveStartDate()));
			wareHouseDto.setEffectiveEndDate(MasterDateUtil.convertDateToString(wareHouse.getEffectiveEndDate()));
			wareHouseDto.setStatus(wareHouse.getStatus());
			wareHouseDto.setCreatedBy(wareHouse.getCreatedBy());
			wareHouseDto.setCreationDate(MasterDateUtil.convertDateToStringWithTime(wareHouse.getCreationDate()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("<--WareHouseServiceImpl-------------MapWareHouse+Dto--------------------ended-->");
		return wareHouseDto;
	}

	public WareHouse MapWareHouseEntity(WareHouseDto wareHouseDto, Principal principal) {
		logger.info("<--WarehouseServiceImpl-------------MapWareHouseDto--------------------started-->");
		WareHouse wareHouse = new WareHouse();
		try {
			wareHouse.setId(wareHouseDto.getId());
			wareHouse.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(wareHouseDto.getCreationDate()));
			// wareHouse.setCreatedBy(wareHouseDto.getCreatedBy());
			wareHouse.setStatus(wareHouseDto.getStatus());
			// wareHouse.setCreationDate(MasterDateUtil.convertStringToTimeStampDate(wareHouseDto.getCreationDate()));
			wareHouse.setCreatedBy(wareHouseDto.getCreatedBy());
			wareHouse.setStatus(wareHouseDto.getStatus());
			wareHouse.setWareHouseName(wareHouseDto.getWareHouseName());
			wareHouse.setCode(wareHouseDto.getCode());
			wareHouse.setParentCode(wareHouseDto.getParentCode());
			wareHouse.setAddress1(wareHouseDto.getAddress1());
			wareHouse.setAddress2(wareHouseDto.getAddress2());
			wareHouse.setAddress3(wareHouseDto.getAddress3());
			if (wareHouseDto.getCreatedBy() != null) {
				wareHouse.setCreatedBy(wareHouseDto.getCreatedBy());
			} else {
				wareHouse.setCreatedBy(principal.getName());
			}
			if (wareHouseDto.getStatus() != null) {
				wareHouse.setCreatedBy(wareHouseDto.getStatus());
			} else {
				wareHouse.setStatus(InventoryConstant.ACTIVE);
			}
			wareHouse.setAreaLandmark(wareHouseDto.getAreaLandmark());
			wareHouse.setState(wareHouseDto.getState());
			wareHouse.setCity(wareHouseDto.getCity());
			wareHouse.setPincode(Integer.valueOf(wareHouseDto.getPinCode()));
			wareHouse.setCountry(wareHouseDto.getCountry());
			wareHouse.setEffectiveStartDate(
					MasterDateUtil.convertStringToTimeStampDate(wareHouseDto.getEffectiveStartDate()));
			wareHouse.setEffectiveEndDate(
					MasterDateUtil.convertStringToTimeStampDate(wareHouseDto.getEffectiveEndDate()));

			wareHouse.setLastModifiedBy(principal.getName());
			wareHouse.setLastModifiedDate(new Timestamp(new Date().getTime()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("<--WareHouseServiceImpl-------------MapWareHouse+Dto--------------------ended-->");
		return wareHouse;
	}

	@Override
	public String saveWareHouse(WareHouseDto wareHouseDto, Principal principal) throws Exception {

		String status = InventoryConstant.FAILURE;

		logger.info("<--wareHouseServiceImpl-------------saveWareHouse--------------------started-->");

		WareHouse wareHouse = new WareHouse();

		List<InventoryEntrance> warehouseList = null;

		if (wareHouseDto != null && wareHouseDto.getId() != null) {
			// wareHouse=new WareHouse();
			wareHouse = wareHouseRepository.findOne(wareHouseDto.getId());

			warehouseList = inventoryStockRepository.findByWareHouseSiteName(wareHouseDto.getWareHouseName());

			if (warehouseList.size() > 0) {
				throw new Exception(InventoryConstant.ALREADY_ASSIGNED);
			}

			if (wareHouse.getWareHouseName().equalsIgnoreCase(wareHouseDto.getWareHouseName())) {
				if (wareHouse.getCode().equalsIgnoreCase(wareHouseDto.getCode())) {
					wareHouse = MapWareHouseEntity(wareHouseDto, principal);
				} else {
					WareHouse wareHouse1 = new WareHouse();
					wareHouse1 = wareHouseRepository.findByCode(wareHouseDto.getCode());
					if (wareHouse1 != null) {
						throw new Exception(InventoryConstant.THIS_WARE_HOUSE_CODE_ALREADY_EXIST);
					} else {
						wareHouse = MapWareHouseEntity(wareHouseDto, principal);
					}
				}
			} else {
				wareHouse = wareHouseRepository.findByWareHouseName(wareHouseDto.getWareHouseName());
				if (wareHouse != null) {
					throw new Exception(InventoryConstant.THIS_WARE_HOUSE_ALREADY_EXIST);
				} else {

					wareHouse = wareHouseRepository.getWareHouseNameExceptInGivenId(wareHouseDto.getId(),
							wareHouseDto.getCode());
					if (wareHouse != null) {
						throw new Exception(InventoryConstant.THIS_WARE_HOUSE_CODE_ALREADY_EXIST);
					} else {
						wareHouse = MapWareHouseEntity(wareHouseDto, principal);
					}
				}
			}
		} else {
			wareHouse = new WareHouse();
			wareHouse = wareHouseRepository.findByWareHouseName(wareHouseDto.getWareHouseName());
			if (wareHouse != null) {
				throw new Exception(InventoryConstant.THIS_WARE_HOUSE_ALREADY_EXIST);
			}

			wareHouse = new WareHouse();
			wareHouse = wareHouseRepository.findByCode(wareHouseDto.getCode());
			// category=categoryRepository.findByCategoryCode(categoryDto.getCategoryCode());
			if (wareHouse != null) {
				throw new Exception(InventoryConstant.THIS_WARE_HOUSE_CODE_ALREADY_EXIST);
			} else {
				wareHouse = MapWareHouseEntity(wareHouseDto, principal);
			}
		}

		wareHouse = wareHouseRepository.save(wareHouse);
		if (wareHouse != null) {
			status = InventoryConstant.SUCCESS;
		}

		logger.info("<--WareHouseServiceImpl-------------saveWareHouse--------------------ended-->");
		return status;

	}

	/* FOR GET VALUE OF EDIT WARE HOUSE */

	@Override
	public WareHouseDto getWareHouse(Long id, Principal principal) {
		WareHouseDto wareHouseDto = null;

		try {
			WareHouse wareHouse = wareHouseRepository.findOne(id);
			if (null != wareHouse) {
				wareHouseDto = new WareHouseDto();
				wareHouseDto.setId(wareHouse.getId());
				wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
				wareHouseDto.setCode(wareHouse.getCode());
				wareHouseDto.setParentCode(wareHouse.getParentCode());
				wareHouseDto.setAddress1(wareHouse.getAddress1());
				wareHouseDto.setAddress2(wareHouse.getAddress2());
				wareHouseDto.setAddress3(wareHouse.getAddress3());
				wareHouseDto.setAreaLandmark(wareHouse.getAreaLandmark());
				wareHouseDto.setState(wareHouse.getState());
				wareHouseDto.setCity(wareHouse.getCity());
				wareHouseDto.setPinCode(Integer.toString(wareHouse.getPincode()));
				wareHouseDto.setCountry(wareHouse.getCountry());
				wareHouseDto
						.setEffectiveStartDate(MasterDateUtil.convertDateToString(wareHouse.getEffectiveStartDate()));
				wareHouseDto.setEffectiveEndDate(MasterDateUtil.convertDateToString(wareHouse.getEffectiveEndDate()));
				wareHouseDto.setStatus(wareHouse.getStatus());
				wareHouseDto.setCreatedBy(wareHouse.getCreatedBy());
				wareHouseDto.setCreationDate(MasterDateUtil.convertDateToString(wareHouse.getCreationDate()));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wareHouseDto;
	}

	/* FOR ACTIVE WARE HOUSE DROP DOWN */

	@Override
	public List<WareHouseDto> getAllAciveWareHouse() {
		List<WareHouseDto> wareHouseDtoList = new ArrayList<>();
		try {
			List<WareHouse> wareHouseList = wareHouseRepository.findByStatus(InventoryConstant.ACTIVE);

			for (int i = 0; i < wareHouseList.size(); i++) {
				WareHouse wareHouse = wareHouseList.get(i);
				if (wareHouse != null) {
					WareHouseDto wareHouseDto = new WareHouseDto();
					wareHouseDto.setId(wareHouse.getId());
					wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
					wareHouseDtoList.add(wareHouseDto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wareHouseDtoList;
	}

	@Override
	public String saveBlock(WareHouseBlocksDto wareHouseBlocksDto, Principal principal) throws Exception {

		String status = null;

		WareHouseBlocks wareHouseBlocks = new WareHouseBlocks();

		WareHouse wareHouse = new WareHouse();

		List<Object> blockList = null;

		if (wareHouseBlocksDto != null && wareHouseBlocksDto.getId() != null) {

			blockList = inventoryStockRepository.findByWareHouseBlockId(wareHouseBlocksDto.getId());

			if (blockList.size() > 0) {
				throw new Exception(InventoryConstant.ALREADY_ASSIGNED);
			}

			wareHouse = wareHouseRepository
					.findByWareHouseName(wareHouseBlocksDto.getWareHouseDto().getWareHouseName());

			if (wareHouse != null) {
				wareHouseBlocks = wareHouseBlockRepository.findOne(wareHouseBlocksDto.getId());

				if (wareHouseBlocks.getId() == wareHouseBlocksDto.getId()) {

					if (!wareHouseBlocks.getBlocksNames().equals(wareHouseBlocksDto.getBlocksNames())) {
						wareHouseBlocks = wareHouseBlockRepository
								.findByBlocksNames(wareHouseBlocksDto.getBlocksNames());

						if (wareHouseBlocks != null) {
							throw new Exception(InventoryConstant.BLOCK_ALREADY_EXISTS);
						} else {
							wareHouseBlocks = wareHouseBlockRepository.findOne(wareHouseBlocksDto.getId());
						}
					}

					if (!wareHouseBlocks.getCode().equals(wareHouseBlocksDto.getCode())) {
						wareHouseBlocks = wareHouseBlockRepository.findByCode(wareHouseBlocksDto.getCode());

						if (wareHouseBlocks != null) {
							throw new Exception(InventoryConstant.BLOCK_MODEL_ALREADY_EXISTS);
						} else {
							wareHouseBlocks = wareHouseBlockRepository.findOne(wareHouseBlocksDto.getId());
						}
					}

					wareHouseBlocks = wareHouseBlockRepository.findOne(wareHouseBlocksDto.getId());

					wareHouseBlocks.setId(wareHouseBlocks.getId());
					wareHouseBlocks.setBlocksNames(wareHouseBlocksDto.getBlocksNames());
					wareHouseBlocks.setCode(wareHouseBlocksDto.getCode());
					wareHouseBlocks.setCreatedBy(principal.getName());
					wareHouseBlocks.setCreationDate(new Date());
					wareHouseBlocks.setLastModifiedBy(principal.getName());
					wareHouseBlocks.setLastModifiedDate(new Date());
					wareHouseBlocks.setStatus(wareHouseBlocksDto.getStatus());

					wareHouseBlocks.setWareHouse(wareHouse);

					wareHouseBlocks = wareHouseBlockRepository.saveAndFlush(wareHouseBlocks);

					if (wareHouseBlocks != null) {
						status = InventoryConstant.SUCCESS;
					}
				}
			} else {
				throw new Exception(InventoryConstant.THIS_WAREHOUSE_NAME_DOESNOT_EXISTS);
			}

		} else {

			wareHouse = wareHouseRepository
					.findByWareHouseName(wareHouseBlocksDto.getWareHouseDto().getWareHouseName());
			if (wareHouse != null) {
				wareHouseBlocks = wareHouseBlockRepository.findByBlocksNames(wareHouseBlocksDto.getBlocksNames());

				if (wareHouseBlocks != null) {
					throw new Exception(InventoryConstant.BLOCK_ALREADY_EXISTS);
				}

				wareHouseBlocks = wareHouseBlockRepository.findByCode(wareHouseBlocksDto.getCode());

				if (wareHouseBlocks != null) {
					throw new Exception(InventoryConstant.BLOCK_MODEL_ALREADY_EXISTS);
				} else {

					if (wareHouse != null) {
						wareHouseBlocks = new WareHouseBlocks();

						wareHouseBlocks.setBlocksNames(wareHouseBlocksDto.getBlocksNames());
						wareHouseBlocks.setCode(wareHouseBlocksDto.getCode());
						wareHouseBlocks.setCreatedBy(principal.getName());
						wareHouseBlocks.setCreationDate(new Date());
						wareHouseBlocks.setLastModifiedBy(principal.getName());
						wareHouseBlocks.setLastModifiedDate(new Date());
						wareHouseBlocks.setStatus(InventoryConstant.ACTIVE);

						wareHouseBlocks.setWareHouse(wareHouse);

						wareHouseBlocks = wareHouseBlockRepository.save(wareHouseBlocks);

						if (wareHouseBlocks != null) {
							status = InventoryConstant.SUCCESS;
						}
					}

				}
			} else {
				throw new Exception(InventoryConstant.THIS_WAREHOUSE_NAME_DOESNOT_EXISTS);
			}

		}

		return status;

	}

	@Override
	public List<WareHouseDto> getAllWareHouseBlock() {

		List<WareHouseDto> wareHouseDtoList = null;
		List<WareHouse> wareHouseEntityList = null;
		List<WareHouseBlocksDto> wareHouseBlocksDtosList = null;
		List<WareHouseBlocks> wareHouseBlocksentityList = null;

		logger.info("<--WareHouseServiceImpl-------------getAllUserWareHouseBlock--------------------started-->");

		try {

			wareHouseEntityList = wareHouseRepository.findAll();

			if (wareHouseEntityList != null) {
				wareHouseDtoList = new ArrayList<>();
				for (int k = 0; k < wareHouseEntityList.size(); k++) {
					WareHouse wareHouse = wareHouseEntityList.get(k);
					if (wareHouse != null) {
						WareHouseDto wareHouseDto = new WareHouseDto();

						wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());

						List<WareHouseBlocks> wareHouseBlocksList = wareHouse.getWareHouseBlocksList();

						if (wareHouseBlocksList != null) {
							wareHouseBlocksDtosList = new ArrayList<>();
							for (int j = 0; j < wareHouseBlocksList.size(); j++) {

								WareHouseBlocks wareHouseBlocks = wareHouseBlocksList.get(j);
								if (wareHouseBlocks != null) {
									WareHouseBlocksDto wareHouseBlocksDto = new WareHouseBlocksDto();
									wareHouseBlocksDto.setBlocksNames(wareHouseBlocks.getBlocksNames());
									wareHouseBlocksDto.setCode(wareHouseBlocks.getCode());
									wareHouseBlocksDto.setId(wareHouseBlocks.getId());
									wareHouseBlocksDto.setStatus(wareHouseBlocks.getStatus());
									wareHouseDto.setId(wareHouseBlocks.getWareHouse().getId());
									wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
									wareHouseBlocksDtosList.add(wareHouseBlocksDto);
								}
								wareHouseDto.setWareHouseBlocksDto(wareHouseBlocksDtosList);

							}

						}

						wareHouseDtoList.add(wareHouseDto);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--WareHouseServiceImpl-------------getAllUserWareHouseBlock--------------------started-->");

		return wareHouseDtoList;
	}

	@Override
	public List<WareHouseDto> getAllUserWareHouseBlock(Principal principal) {
		logger.info("<--WareHouseServiceImpl-------------getAllUserWareHouseBlock--------------------started-->");
		List<WareHouseBlocksDto> wareHouseBlocksDtosList = null;
		;

		WareHouseDto wareHouseDto = null;
		List<WareHouseDto> wareHouseDtosList = new ArrayList<>();
		try {

			if (principal.getName() != null) {
				User user = userRepository.findByUserName(principal.getName());
				if (user != null) {

					List<WareHouse> wareHouseEntityList = user.getWareHouseItem();
					if (wareHouseEntityList != null) {
						for (int i = 0; i < wareHouseEntityList.size(); i++) {
							WareHouse wareHouse = wareHouseEntityList.get(i);
							if (wareHouse != null) {
								List<WareHouseBlocks> wareHouseBlocksEntityList = wareHouse.getWareHouseBlocksList();
								if (wareHouseBlocksEntityList != null) {
									for (int j = 0; j < wareHouseBlocksEntityList.size(); j++) {
										wareHouseDto = new WareHouseDto();
										wareHouseBlocksDtosList = new ArrayList<>();
										wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
										WareHouseBlocks wareHouseBlocks = wareHouseBlocksEntityList.get(j);
										if (wareHouseBlocks != null) {
											WareHouseBlocksDto wareHouseBlocksDto = new WareHouseBlocksDto();
											wareHouseBlocksDto.setBlocksNames(wareHouseBlocks.getBlocksNames());
											wareHouseBlocksDto.setCode(wareHouseBlocks.getCode());
											wareHouseBlocksDto.setId(wareHouseBlocks.getId());
											wareHouseBlocksDto.setStatus(wareHouseBlocks.getStatus());
											wareHouseDto.setId(wareHouseBlocks.getWareHouse().getId());
											wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
											/*
											 * wareHouseDto.setCode(wareHouse.
											 * getCode());
											 * wareHouseDto.setAddress1(
											 * wareHouse.getAddress1());
											 * wareHouseDto.setAddress2(
											 * wareHouse.getAddress2());
											 * wareHouseDto.setAddress3(
											 * wareHouse.getAddress3());
											 * wareHouseDto.setAreaLandmark(
											 * wareHouse.getAreaLandmark());
											 * wareHouseDto.setCountry(wareHouse
											 * .getCountry())
											 */;
											wareHouseBlocksDtosList.add(wareHouseBlocksDto);
										}
										wareHouseDto.setWareHouseBlocksDto(wareHouseBlocksDtosList);
										wareHouseDtosList.add(wareHouseDto);
									}
								}
							}

						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--WareHouseServiceImpl-------------getAllUserWareHouseBlock--------------------started-->");

		return wareHouseDtosList;

	}

}
