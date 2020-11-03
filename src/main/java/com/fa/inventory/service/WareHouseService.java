package com.fa.inventory.service;
import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.WareHouseBlocksDto;
import com.fa.inventory.dto.WareHouseDto;

public interface WareHouseService {
String saveWareHouse(WareHouseDto wareHouseDto,Principal principal) throws Exception;
	
	//List<WareHouseDto> getAllWareHouseDtoList();


	WareHouseDto getWareHouse(Long id, Principal principal);


	List<WareHouseDto> getwareHouseList(Principal principal);

	List<WareHouseDto> getAllAciveWareHouse();

	String saveBlock(WareHouseBlocksDto wareHouseBlocksDto, Principal principal) throws Exception;

	List<WareHouseDto> getAllWareHouseBlock();

	List<WareHouseDto> getAllUserWareHouseBlock(Principal principal);

}