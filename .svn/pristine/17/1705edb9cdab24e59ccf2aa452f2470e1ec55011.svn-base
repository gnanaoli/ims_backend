package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.CommonResponseDto;
import com.fa.inventory.dto.ScrapDto;
import com.fa.inventory.dto.ScrapInspectionDto;
import com.fa.inventory.entity.Scrap;

public interface ScrapService {

	/** Get All Scarp */
	
	List<ScrapDto> viewAllScrap(Principal principal);
	
	/** Get All UserScarp */
	
	List<ScrapDto> viewAllWareHouseScrap(Principal principal);
	
	
	/** Get All UserScarp */
	
	List<ScrapDto> viewAllUserScrap(Principal principal);
	
	/** Get Scarp By Id */
	
	ScrapDto findScrapById(String parameter);

	
	/** Save Scarp  */
	
	CommonResponseDto saveScrap(ScrapDto scrapDto,Principal principal);
	
	/** GetAllToolsforScrap  */

	BulkRequestResponseDto FindAllToolsforScrap(Principal principal);

	ScrapDto mapScrapDto(Scrap scrap);
	
	/** GET ALL ScrapInspection  */
	List<ScrapInspectionDto> getAllScrapInspection(Principal principal) throws Exception;


	
	
	
	
}
