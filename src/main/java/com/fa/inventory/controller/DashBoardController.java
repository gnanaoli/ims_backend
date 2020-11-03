package com.fa.inventory.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.service.DashBoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DashBoardController {

	
	protected final Logger logger = Logger.getLogger(DashBoardController.class);
	
	@Resource
	DashBoardService dashBoardService;
	
	@RequestMapping(value = "/getInventoryCountFromSpecificUserProject",method=RequestMethod.GET)
	public ResponseEntity<List<InventoryEntranceDto>> getInventoryCountFromSpecificUserProject(HttpServletRequest request,HttpServletResponse response,Principal principal)
	{
		List<InventoryEntranceDto> inventoryEntranceDtoList=null;
		try {
			logger.info("<--DashBoardController-------------getInventoryCountFromSpecificUserProject--------------------started-->"+principal.getName());
            inventoryEntranceDtoList=dashBoardService.getInventoryCountFromSpecificUserProject(principal);	
            System.out.println("getInventoryCountFromSpecificUserProject==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--DashBoardController-------------getInventoryCountFromSpecificUserProject--------------------Ended-->"+principal.getName());
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryEntranceDtoList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getInventoryCountForSpecificWareHouseAdministrator",method=RequestMethod.GET)
	public ResponseEntity<List<InventoryEntranceDto>> getInventoryCountForSpecificWareHouseAdministrator(HttpServletRequest request,HttpServletResponse response,Principal principal)
	{
		List<InventoryEntranceDto> inventoryEntranceDtoList=null;
		try {
			logger.info("<--DashBoardController-------------getInventoryCountForSpecificWareHouseAdministrator--------------------started-->"+principal.getName());
            inventoryEntranceDtoList=dashBoardService.getInventoryCountForWareHouseAdministrator(principal);	
            System.out.println("getInventoryCountForSpecificWareHouseAdministrator==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--DashBoardController-------------getInventoryCountForSpecificWareHouseAdministrator--------------------Ended-->"+principal.getName());
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryEntranceDtoList, HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value = "/getInventoryCountForOfficeAdministratorFromStock",method=RequestMethod.GET)
	public ResponseEntity<List<InventoryEntranceDto>> getInventoryCountForOfficeAdministrator(HttpServletRequest request,HttpServletResponse response,Principal principal)
	{
		List<InventoryEntranceDto> inventoryEntranceDtoList=null;
		try {
			logger.info("<--DashBoardController-------------getInventoryCountForOfficeAdministratorFromStock--------------------started-->"+principal.getName());
            inventoryEntranceDtoList=dashBoardService.getInventoryCountForOfficeAdministratorFromStock(principal);	
            System.out.println("getInventoryCountForOfficeAdministratorFromStock==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--DashBoardController-------------getInventoryCountForOfficeAdministratorFromStock--------------------Ended-->"+principal.getName());
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryEntranceDtoList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getInventoryCountForOfficeAdministratorFromAssign",method=RequestMethod.GET)
	public ResponseEntity<List<InventoryEntranceDto>> getInventoryCountForOfficeAdministratorFromAssign(HttpServletRequest request,HttpServletResponse response,Principal principal)
	{
		List<InventoryEntranceDto> inventoryEntranceDtoList=null;
		try {
			logger.info("<--DashBoardController-------------getInventoryCountForOfficeAdministratorFromAssign--------------------started-->"+principal.getName());
            inventoryEntranceDtoList=dashBoardService.getInventoryCountForOfficeAdministratorFromAssign(principal);	
            System.out.println("getInventoryCountForOfficeAdministratorFromAssign==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--DashBoardController-------------getInventoryCountForOfficeAdministratorFromAssign--------------------Ended-->"+principal.getName());
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryEntranceDtoList, HttpStatus.OK);
		
	}
	
	
}
