package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.InventoryEntranceDto;

public interface ReportService {


	List<?> inventoryReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> scrapReport(InventoryEntranceDto reportDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> requestsReport(InventoryEntranceDto reportDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> serviceReport(InventoryEntranceDto reportDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> elcbReport(InventoryEntranceDto reportDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> worksMenDetailsReport(InventoryEntranceDto reportDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> inventoryInwordsReport(InventoryEntranceDto reportDto, List<String> projectAndWareHouseName, Principal principal);

	List<?> inventoryOutwordsReport(InventoryEntranceDto reportsDto, List<String> projectAndWareHouseName,Principal principal);


}
