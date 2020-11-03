package com.fa.inventory.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.DepartmentDto;
import com.fa.inventory.dto.DesignationDto;
import com.fa.inventory.dto.DispatcherLogDto;
import com.fa.inventory.dto.EmployeeDto;
import com.fa.inventory.dto.IdProofMasterDto;
import com.fa.inventory.dto.InventoryAssignDto;
import com.fa.inventory.dto.InventoryEntranceDto;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.dto.TypeDto;
import com.fa.inventory.service.CategoryService;
import com.fa.inventory.service.DispatchLogService;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.InventoryRequestService;
import com.fa.inventory.service.ProjectService;
import com.fa.inventory.service.SmsService;
import com.fa.inventory.service.TypeService;
import com.fa.inventory.service.UserManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class InventoryController3 {

	protected final Logger logger = Logger.getLogger(InventoryController.class);

	@Autowired
	HttpSession session;
	
	@Resource
	CategoryService categoryService;
	@Resource
	TypeService typeService;
	
	
	@Resource
	InventoryManagementService inventoryManagementService;
	
	@Resource
	ProjectService projectService;
	
	@Resource
	UserManagementService userManagementService;
	
	@Resource
	DispatchLogService dispatchLogService;
	
	@Resource
	InventoryRequestService inventoryRequestService;
	
	@Resource
	SmsService smsService;
	
	@RequestMapping(value="/getAllInventoryManagement")
	public ResponseEntity<List<InventoryEntranceDto>> getAllInventoryManagement(Principal principal)
	{
		List<InventoryEntranceDto> inventoryManagementDtoList=null;
		ModelAndView model=new ModelAndView("Inventory_mgmt_table");
		logger.info("<--inventoryController3-------------getAllInventoryManagement--------------------started-->");
	try {
		 inventoryManagementDtoList=inventoryManagementService.getAllInventoryManagementList(principal);
		System.out.println("inventoryManagementDtoList==>"+new ObjectMapper().writeValueAsString(inventoryManagementDtoList));
		model.addObject("inventoryManagementDtoList", inventoryManagementDtoList);
	} catch (Exception e) {
		e.printStackTrace();
		new ResponseEntity<List<InventoryEntranceDto>>(inventoryManagementDtoList,HttpStatus.BAD_REQUEST);
	}
		logger.info("<--inventoryController3-------------getAllInventoryManagement--------------------ended-->");
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryManagementDtoList,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/saveInventoryManagement",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> saveInventoryManagement(@RequestBody InventoryEntranceDto inventoryEntranceDto,Principal principal)
	{
		ResponseDto responseDto=new ResponseDto();
		String status=null;
		logger.info("<--inventoryController3-------------saveInventoryManagement--------------------started-->");
		try {
			System.out.println("InventoryRequestDto==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDto));
			status=inventoryManagementService.saveInventoryManagement(inventoryEntranceDto,principal);
			if(status.equals(InventoryConstant.SUCCESS))
			{
				responseDto.setStatus(InventoryConstant.SUCCESS);
			}
			System.out.println("InventoryresponseDto==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDto));	
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("<--inventoryController3-------------saveInventoryManagement--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/editInventoryManagement",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> editInventoryManagement(@RequestBody InventoryEntranceDto inventoryEntranceDto,Principal principal)
	{
		ResponseDto responseDto=new ResponseDto();
		String status=null;
		logger.info("<--inventoryController3-------------editInventoryManagement--------------------started-->");
		try {
			System.out.println("editInventoryManagement InventoryRequestDto==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDto));
			status=inventoryManagementService.editInventoryManagement(inventoryEntranceDto,principal);
			if(status.equals(InventoryConstant.SUCCESS))
			{
				responseDto.setStatus(InventoryConstant.SUCCESS);
			}
			else{
				responseDto.setStatus(InventoryConstant.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--inventoryController3-------------editInventoryManagement--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/getInventoryById",method = RequestMethod.POST)
	public ModelAndView getInventoryById(HttpServletRequest request,HttpServletResponse response,Principal principal)
	{
		ModelAndView model=null;
		String id=null;
		InventoryEntranceDto inventoryEntranceDto=null;
		logger.info("<--inventoryController3-------------getInventoryById--------------------started-->");
		try {
			
			id=request.getParameter("id");
			if(id!=null && request.getParameter("page").equals(InventoryConstant.INVENTORY_EDIT_PAGE))
			{
				model=new ModelAndView("EditInventory");
				inventoryEntranceDto=inventoryManagementService.getInventoryById(id,principal);
				System.out.println("getInventoryById==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDto));
				model.addObject("inventoryManagementDto", inventoryEntranceDto);
			}
			else if(id!=null && request.getParameter("page").equals(InventoryConstant.INVENTORY_ASSIGN_PAGE))
			{
				model=new ModelAndView("AssignInventoryToProject");
				inventoryEntranceDto=inventoryManagementService.getInventoryById(id,principal);
				System.out.println("getInventoryById==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDto));
				model.addObject("inventoryManagementDto", inventoryEntranceDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getInventoryById--------------------started-->");
		return model;
	}
	
	@RequestMapping(value="/getAllCategoryTypes")
	public ResponseEntity<List<CategoryDto>> getAllCategoryTypes(Principal principal)
	{
		logger.info("<--inventoryController3-------------getAllCategoryTypes--------------------started-->");
		
		List<CategoryDto> categoryDtoList=new ArrayList<>();
		try {
			categoryDtoList=categoryService.getCategoryList(principal);
			System.out.println("categoryDtoList==>"+new ObjectMapper().writeValueAsString(categoryDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--inventoryController3-------------getAllCategoryTypes--------------------started-->");
		return new ResponseEntity<List<CategoryDto>>(categoryDtoList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllTypes")
	public ResponseEntity<List<TypeDto>> getAllTypes(Principal principal)
	{ 
		logger.info("<--inventoryController3-------------getAllTypes--------------------started-->");
		
		List<TypeDto> typeDtoList=new ArrayList<>();
		try {
		typeDtoList=typeService.getTypeList(principal);
			System.out.println("typeDtoList==>"+new ObjectMapper().writeValueAsString(typeDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--inventoryController3-------------getAllTypes--------------------started-->");
		return new ResponseEntity<List<TypeDto>>(typeDtoList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getSubCategoryByCategory",method = RequestMethod.POST)
	public ResponseEntity<List<SubCategoryDto>> getSubCategoryByCategory(@RequestParam("categoryType") String categoryType)
	{
		logger.info("<--inventoryController3-------------getSubCategoryByCategory--------------------started-->");
		
		List<SubCategoryDto> subCategoryDtoList=new ArrayList<>();
		try {
			subCategoryDtoList=categoryService.getSubCategoryByCategoryList(categoryType);
			System.out.println("subCategoryDtoList==>"+new ObjectMapper().writeValueAsString(subCategoryDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getSubCategoryByCategory--------------------started-->");
		return new ResponseEntity<List<SubCategoryDto>>(subCategoryDtoList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getCurrentUserInventoryAssign",method = RequestMethod.GET)
	public ResponseEntity<List<InventoryEntranceDto>> getCurrentUserInventoryAssign(Principal principal)
	{
		logger.info("<--inventoryController3-------------getCurrentUserInventoryAssign--------------------started-->");
		
		List<InventoryEntranceDto> inventoryEntranceDtoList=new ArrayList<>();
		try {
			inventoryEntranceDtoList=inventoryManagementService.getCurrentUserInventoryAssign(principal);
			System.out.println("getCurrentUserInventoryAssignList==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getCurrentUserInventoryAssign--------------------started-->");
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryEntranceDtoList, HttpStatus.OK);
	}
	
	/*this method is used to give the request for siteengineer to move the inventory to specified location*/
	@RequestMapping(value="/moveInventory",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> moveInventory(@RequestBody InventoryRequestDto inventoryRequestDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------moveInventory--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			responseDto=inventoryManagementService.moveInventory(inventoryRequestDto, principal);
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------moveInventory--------------------started-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	/*this method is used to move inventory to scrap or service by warehouse admin*/
	@RequestMapping(value="/moveInventoryForWarehouseAdmin",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> moveInventoryForWarehouseAdmin(@RequestBody InventoryRequestDto inventoryRequestDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------moveInventoryForWarehouseAdmin--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			responseDto=inventoryManagementService.moveInventoryByWarehouseAdmin(inventoryRequestDto, principal);
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------moveInventoryForWarehouseAdmin--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	
	/*this method is used to confirmly move the inventory to specified location by warehouse admin as per site engineer requested */
	@RequestMapping(value="/confirmMoveInventory",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> confirmMoveInventory(@RequestBody InventoryRequestDto inventoryRequestDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------confirmMoveInventory--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		String status=null;
		try {
			status=inventoryManagementService.confirmMoveInventory(inventoryRequestDto, principal);
			if(status.equals(InventoryConstant.SUCCESS))
			{
				responseDto.setStatus(InventoryConstant.SUCCESS);
			}
			else{
				responseDto.setStatus(InventoryConstant.FAILURE);
			}
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------confirmMoveInventory--------------------started-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(value="/getInventoryAssignById",method = RequestMethod.POST)
	public ModelAndView getInventoryAssignById(HttpServletRequest request,Principal principal)
	{
		logger.info("<--inventoryController3-------------getInventoryAssignById--------------------started-->");
		ModelAndView model=new ModelAndView("MoveInventory");
		try {
			String id=request.getParameter("id");
			InventoryAssignDto inventoryAssignDto=inventoryManagementService.getInventoryAssignById(id, principal);
			System.out.println("inventoryAssignDto==>"+new ObjectMapper().writeValueAsString(inventoryAssignDto));
			model.addObject("inventoryAssignDto", inventoryAssignDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getInventoryAssignById--------------------started-->");
		return model;
	}
	
	
	@RequestMapping(value="/getMoveRequestNotifications",method = RequestMethod.GET)
	public ResponseEntity<List<InventoryRequestDto>> getMoveRequestNotifications(Principal principal)
	{
		logger.info("<--inventoryController3-------------getMoveRequestNotifications--------------------started-->");
		
		List<InventoryRequestDto> inventoryRequestDtoList=new ArrayList<>();
		try {
			inventoryRequestDtoList=inventoryManagementService.getMoveRequestNotifications(principal);
			System.out.println("getMoveRequestNotificationsList==>"+new ObjectMapper().writeValueAsString(inventoryRequestDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getMoveRequestNotifications--------------------started-->");
		return new ResponseEntity<List<InventoryRequestDto>>(inventoryRequestDtoList, HttpStatus.OK);
	}
	
	/*this method is used to get confirmed entity for view by warehouse admin*/
	@RequestMapping(value="/confirmInventoryAssignById",method = RequestMethod.POST)
	public ModelAndView confirmInventoryAssignById(HttpServletRequest request,Principal principal)
	{
		logger.info("<--inventoryController3-------------confirmInventoryAssignById--------------------started-->");
		ModelAndView model=new ModelAndView("ConfirmMoveInventory");
		try {
			String id=request.getParameter("id");
			InventoryRequestDto inventoryRequestDto=inventoryManagementService.getInventoryRequestById(id, principal);
			System.out.println("confirmInventoryAssignById==>"+new ObjectMapper().writeValueAsString(inventoryRequestDto));
			model.addObject("confirmInventoryAssignDto", inventoryRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------confirmInventoryAssignById--------------------started-->");
		return model;
	}
	
	@RequestMapping(value="/getDesignation",method = RequestMethod.GET)
	public ResponseEntity<List<DesignationDto>> getDesignation(Principal principal)
	{
		logger.info("<--inventoryController3-------------getMoveRequestNotifications--------------------started-->");
		
		List<DesignationDto> designationDtoList=new ArrayList<>();
		try {
			designationDtoList=userManagementService.getDesignation();
			System.out.println("getMoveRequestNotificationsList==>"+new ObjectMapper().writeValueAsString(designationDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getMoveRequestNotifications--------------------started-->");
		return new ResponseEntity<List<DesignationDto>>(designationDtoList, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get Assign Inventory to Project by wareHouse administrator*
	 * */
	@RequestMapping(value="/AssignInventory",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> AssignInventory(@RequestBody InventoryEntranceDto inventoryEntranceDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------AssignInventory--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		String status=null;
		try {
			 status=inventoryManagementService.assignInventoryStockToProject(inventoryEntranceDto, principal);
			 if(status.equals(InventoryConstant.SUCCESS))
			 {
				 responseDto.setStatus(InventoryConstant.SUCCESS);
			 }
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------AssignInventory--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getAllInventoryManagementFromStockForAssign")
	public ResponseEntity<List<InventoryEntranceDto>> getAllInventoryManagementFromStockForAssign(Principal principal)
	{
		List<InventoryEntranceDto> inventoryManagementDtoList=null;
		ModelAndView model=new ModelAndView("Inventory_mgmt_table");
		logger.info("<--inventoryController3-------------getAllInventoryManagementFromStockForAssign--------------------started-->");
	try {
		 inventoryManagementDtoList=inventoryManagementService.getAllInventoryManagementFromStockForAssign(principal);
		System.out.println("inventoryManagementDtoList==>"+new ObjectMapper().writeValueAsString(inventoryManagementDtoList));
		model.addObject("inventoryManagementDtoList", inventoryManagementDtoList);
	} catch (Exception e) {
		e.printStackTrace();
		new ResponseEntity<List<InventoryEntranceDto>>(inventoryManagementDtoList,HttpStatus.BAD_REQUEST);
	}
		logger.info("<--inventoryController3-------------getAllInventoryManagementFromStockForAssign--------------------ended-->");
		return new ResponseEntity<List<InventoryEntranceDto>>(inventoryManagementDtoList,HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get wareHouseBlocks by wareHouseName*
	 * */
	@RequestMapping(value="/getAllWareHouseBlocksByWareHouseName",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> getAllWareHouseBlocksByWareHouseName(@RequestParam("wareHouseName") String wareHouseName,Principal principal)
	{
		logger.info("<--inventoryController3-------------getAllWareHouseBlocksByWareHouseName--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			responseDto.setResponseDtoList(inventoryManagementService.getAllWareHouseBlocksNamesByWareHouseName(wareHouseName));
			System.out.println("getAllWareHouseBlocksByWareHouseName==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllWareHouseBlocksByWareHouseName--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * getAllMyRequest
	 * */
	@RequestMapping(value="/getAllMyRequest",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getAllMyRequest(Principal principal)
	{
		logger.info("<--inventoryController3-------------getAllMyRequest--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			List<InventoryRequestDto> inventoryRequestDtoList=inventoryManagementService.getAllMyRequest(principal);
			responseDto.setResponseDtoList(inventoryRequestDtoList);
			System.out.println("getAllMyRequest==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllMyRequest--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}


	/**
	 * this method is used to save new Employee*
	 * */
	@RequestMapping(value="/saveNewEmployee",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> saveNewEmployee(@RequestBody EmployeeDto employeeDto,Principal principal)
	{
		String status=null;
		logger.info("<--inventoryController3-------------saveNewEmployee--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			status=userManagementService.saveNewEmployee(employeeDto);
			if(status.equals(InventoryConstant.SUCCESS)){
				responseDto.setStatus(InventoryConstant.SUCCESS);
			}
			System.out.println("saveNewEmployee==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------saveNewEmployee--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	
	
	/**
	 * this method is used to edit Employee with id*
	 * */
	@RequestMapping(value="/editEmployee",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> editEmployee(@RequestBody EmployeeDto employeeDto,Principal principal)
	{
		String status=null;
		logger.info("<--inventoryController3-------------editEmployee--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			status=userManagementService.editEmployee(employeeDto);
			if(status.equals(InventoryConstant.SUCCESS)){
				responseDto.setStatus(InventoryConstant.SUCCESS);
			}
			System.out.println("editEmployee==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------editEmployee--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	
	
	/**
	 * this method is used to get all employee*
	 * */
	@RequestMapping(value="/getAllEmployee",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getAllEmployee(Principal principal)
	{
		List<EmployeeDto> employeeDtoList=null;
		logger.info("<--inventoryController3-------------getAllEmployee--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			employeeDtoList=userManagementService.getAllEmployee(principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(employeeDtoList);
			System.out.println("getAllEmployee==>"+new ObjectMapper().writeValueAsString(employeeDtoList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllEmployee--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	/**
	 * this method is used to getAllAvaiableEmployee*
	 * */
	@RequestMapping(value="/getAllEmployeeId",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getAllAvaiableEmployee(Principal principal)
	{
		List<EmployeeDto> employeeDtoList=null;
		logger.info("<--inventoryController3-------------getAllEmployeeId--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			employeeDtoList=userManagementService.getAllEmployeeId(principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(employeeDtoList);
			System.out.println("getAllEmployeeId==>"+new ObjectMapper().writeValueAsString(employeeDtoList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllEmployeeId--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	/**
	 * this method is used to get all department*
	 * */
	@RequestMapping(value="/getAllDepartment",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getAllDepartment(Principal principal)
	{
		List<DepartmentDto> departmentDtoList=null;
		logger.info("<--inventoryController3-------------getAllDepartment--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			departmentDtoList=userManagementService.getAllDepartment(principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(departmentDtoList);
			System.out.println("getAllEmployee==>"+new ObjectMapper().writeValueAsString(departmentDtoList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllDepartment--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get all idProofList*
	 * */
	@RequestMapping(value="/getAllIdProofList",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getAllIdProofList(Principal principal)
	{
		List<IdProofMasterDto> idProofMasterDtoList=null;
		logger.info("<--inventoryController3-------------getAllIdProofList--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			idProofMasterDtoList=userManagementService.getAllIdProofList(principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(idProofMasterDtoList);
			System.out.println("getAllIdProofList==>"+new ObjectMapper().writeValueAsString(idProofMasterDtoList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllIdProofList--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	

	/**
	 * this method is used to add request for inventory dispatch by warehouse administrator*
	 * */
	@RequestMapping(value="/addInventoryInDispatch",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addInventoryInDispatch(@RequestBody BulkRequestResponseDto bulkRequestResponseDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------addInventoryInDispatch--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			 responseDto=dispatchLogService.addInventoryInDispatch(bulkRequestResponseDto,principal);
			System.out.println("addInventoryInDispatch==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------addInventoryInDispatch--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get all dispatch log*
	 * */
	@RequestMapping(value="/getAllDispatchLog",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getAllDispatchLog(Principal principal)
	{
		List<DispatcherLogDto> dispatcherLogDtosList=null;
		logger.info("<--inventoryController3-------------getAllDispatchLog--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			dispatcherLogDtosList=dispatchLogService.getAllDispatchLog(principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(dispatcherLogDtosList);
			System.out.println("getAllDispatchLog==>"+new ObjectMapper().writeValueAsString(dispatcherLogDtosList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getAllDispatchLog--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	/**
	 * this method is used to get all dispatch log by count*
	 * */
	@RequestMapping(value="/getDispatchLogByCount",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getDispatchLogByCount(Principal principal)
	{
		List<DispatcherLogDto> dispatcherLogDtosList=null;
		logger.info("<--inventoryController3-------------getDispatchLogByCount--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			dispatcherLogDtosList=dispatchLogService.getAllDispatcherLogByCount(principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(dispatcherLogDtosList);
			System.out.println("getAllDispatchLog==>"+new ObjectMapper().writeValueAsString(dispatcherLogDtosList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getDispatchLogByCount--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get all dispatch log by site name*
	 * */
	@RequestMapping(value="/getDispatchLogBySiteName",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> getDispatchLogBySiteName(@RequestBody DispatcherLogDto dispatcherLogDto,Principal principal)
	{
		List<DispatcherLogDto> dispatcherLogDtosList=null;
		logger.info("<--inventoryController3-------------getDispatchLogBySiteName--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			System.out.println("dispatchrequest==>"+new ObjectMapper().writeValueAsString(dispatcherLogDto));
			dispatcherLogDtosList=dispatchLogService.getDispatchLogBySiteName(dispatcherLogDto,principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(dispatcherLogDtosList);
			System.out.println("getDispatchLogBySiteName==>"+new ObjectMapper().writeValueAsString(dispatcherLogDtosList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getDispatchLogBySiteName--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get all dispatch log by requestedTo*
	 * */
	@RequestMapping(value="/getDispatchLogByRequestedTo",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> getDispatchLogByRequestedTo(@RequestBody DispatcherLogDto dispatcherLogDto,Principal principal)
	{
		List<DispatcherLogDto> dispatcherLogDtosList=null;
		logger.info("<--inventoryController3-------------getDispatchLogByRequestedTo--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			System.out.println("dispatchrequest==>"+new ObjectMapper().writeValueAsString(dispatcherLogDto));
			dispatcherLogDtosList=dispatchLogService.getDispatchLogByRequestedToAndRequestedFrom(dispatcherLogDto,principal);
			responseDto.setStatus(InventoryConstant.SUCCESS);
			responseDto.setResponseDtoList(dispatcherLogDtosList);
			System.out.println("getDispatchLogByRequestedTo==>"+new ObjectMapper().writeValueAsString(dispatcherLogDtosList));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getDispatchLogByRequestedTo--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	

	/**
	 * this method is used to generate challan number against given quantity list in dispatch log*
	 * */
	@RequestMapping(value="/generateChallanNo",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> generateChallenNo(@RequestBody BulkRequestResponseDto bulkRequestResponseDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------generateChallenNo--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			 responseDto=dispatchLogService.generateChallenNo(bulkRequestResponseDto,principal);
			System.out.println("generateChallenNo==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------generateChallenNo--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get inventory by challan No from inventoryAssign table*
	 * */
	@RequestMapping(value="/getInventoryAssignByChallanNo",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> getInventoryAssignByChallanNo(@RequestBody InventoryEntranceDto inventoryEntranceDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------getInventoryAssignByChallanNo--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		List<InventoryEntranceDto> inventoryEntranceDtosList=new ArrayList<>();
		try {
			if(inventoryEntranceDto.getChallanNo()!=null)
			{
				inventoryEntranceDtosList=inventoryManagementService.getInventoryAssignByChallanNo(inventoryEntranceDto.getChallanNo(), principal);
				if(inventoryEntranceDtosList!=null)
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
					responseDto.setResponseDtoList(inventoryEntranceDtosList);
					System.out.println("getInventoryAssignByChallanNo==>"+new ObjectMapper().writeValueAsString(inventoryEntranceDtosList));
				}
			}
			
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getInventoryAssignByChallanNo--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	/**
	 * this method is used to get inventory by challan No from inventoryAssign table*
	 * */
	@RequestMapping(value="/acceptInventoryFromWarehouseorProjectSite",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> acceptInventoryFromWarehouse(@RequestBody BulkRequestResponseDto bulkRequestResponseDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------acceptInventoryFromWarehouse--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			if(bulkRequestResponseDto!=null)
			{
				responseDto=dispatchLogService.acceptInventoryByChallaNo(bulkRequestResponseDto, principal);
			}
			
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------acceptInventoryFromWarehouse--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get notification  data by user role wise*
	 * */
	@RequestMapping(value="/getNotificationData",method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getNotificationData(Principal principal)
	{
		logger.info("<--inventoryController3-------------getNotificationData--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			responseDto.setResponseDtoList(inventoryRequestService.getNotificationData(principal));
			System.out.println("getAllDispatchLog==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------getNotificationData--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method is used to get inventory by challan No from inventoryAssign table*
	 * */
	@RequestMapping(value="/updateNotificationStatus",method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> acceptInventoryFromWarehouse(@RequestBody InventoryRequestDto InventoryRequestDto,Principal principal)
	{
		logger.info("<--inventoryController3-------------updateNotificationStatus--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		try {
			
			responseDto=inventoryRequestService.updateNotificationStatus(InventoryRequestDto,principal);
			
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------updateNotificationStatus--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	/**
	 * this method*
	 * */
	@RequestMapping(value="/sendSms",method = RequestMethod.POST)
	public ResponseEntity<String> sendSms(Principal principal,Authentication authentication)
	{
		logger.info("<--inventoryController3-------------sendSms--------------------started-->");
		ResponseDto responseDto=new ResponseDto();
		String status=null;
		try {
			status=smsService.smsResponse("","");
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController3-------------sendSms--------------------Ended-->");
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	
	
}
	
