package com.fa.inventory.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.BulkRequestResponseDto;
import com.fa.inventory.dto.CategoryDto;
import com.fa.inventory.dto.CityDto;
import com.fa.inventory.dto.CommonResponseDto;
import com.fa.inventory.dto.CountryDto;
import com.fa.inventory.dto.ELCPDto;
import com.fa.inventory.dto.InventoryRequestDto;
import com.fa.inventory.dto.MenuDto;
import com.fa.inventory.dto.PasswordDetailRequest;
import com.fa.inventory.dto.PasswordRulesDto;
import com.fa.inventory.dto.ResponseDto;
import com.fa.inventory.dto.RoleDto;
import com.fa.inventory.dto.SafetyStatusDto;
import com.fa.inventory.dto.ScrapDto;
import com.fa.inventory.dto.ScrapInspectionDto;
import com.fa.inventory.dto.SecretQuestionsDto;
import com.fa.inventory.dto.ServiceInspectionDto;
import com.fa.inventory.dto.StateDto;
import com.fa.inventory.dto.SubCategoryDto;
import com.fa.inventory.dto.SupplierDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.dto.WareHouseBlocksDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.dto.WorksMenCategoryDto;
import com.fa.inventory.dto.WorksMenDetailsDto;
import com.fa.inventory.entity.User;
import com.fa.inventory.repository.MenuRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.AdminService;
import com.fa.inventory.service.BulkToolsService;
import com.fa.inventory.service.ELCBService;
import com.fa.inventory.service.InventoryManagementService;
import com.fa.inventory.service.InventoryRequestService;
import com.fa.inventory.service.ProjectService;
import com.fa.inventory.service.SafetyService;
import com.fa.inventory.service.ScrapInspectionService;
import com.fa.inventory.service.ScrapService;
import com.fa.inventory.service.ServiceInpectionService;
import com.fa.inventory.service.ServiceTrackerService;
import com.fa.inventory.service.SubCategoryService;
import com.fa.inventory.service.SupplierService;
import com.fa.inventory.service.UserManagementService;
import com.fa.inventory.service.WareHouseService;
import com.fa.inventory.service.WorksMenService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class InventoryController {

	protected final Logger logger = Logger.getLogger(InventoryController.class);

	@Autowired
	HttpSession session;
	
	@Resource
	UserManagementService userManagementService;
	
	@Resource
	AdminService adminService;
	
	@Resource
	SupplierService supplierService;
	
	@Resource
	ScrapService scrapService;
	
	@Resource
	ProjectService projectService;
	
	@Resource
	SubCategoryService subcategoryService;
	
	@Resource
	BulkToolsService bulkToolsService;
	
	@Resource
	WareHouseService wareHouseService;
	
	@Resource
	WorksMenService worksMenService;
	
	@Resource
	ELCBService elcbService;
	
	@Resource
	InventoryManagementService inventoryManagementService;
	
	@Resource
	InventoryRequestService inventoryRequestService;
	
	@Resource
	SafetyService safetyService;
	
	@Resource
	ServiceTrackerService serviceTrackerService;
	
	@Resource
	ScrapInspectionService scrapInspectionService;
	
	@Resource
	ServiceInpectionService serviceInpectionService;
	
	@Resource
	MenuRepository menuRepository;
	
	@Resource
	UserRepository userRepository;
	
	@RequestMapping(value = "/")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response,Authentication authentication) {
		ModelAndView model=new ModelAndView("login");
		String error=null;
		logger.info("<--inventoryController-------------login--------------------started-->"+authentication);
		try {
			error=request.getParameter("error");
			if(error!=null)
			{
				model.addObject("error",error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------login--------------------Ended-->"+authentication);
		return model;
	}
	
	
	@RequestMapping(value = "/login")
	public ModelAndView welcome1(HttpServletRequest request, HttpServletResponse response,Authentication authentication) {
		ModelAndView model=new ModelAndView("login");
		String error=null;
		logger.info("<--inventoryController-------------loginn--------------------started-->"+authentication);
		try {
			error=request.getParameter("error");
			if(error!=null)
			{
				model.addObject("error",error);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------loginn--------------------Ended-->"+authentication);
		return model;
	}

	@RequestMapping(value = "/ForgotPassword")
	public String ForgotPassword(HttpServletRequest request, HttpServletResponse response,Authentication authentication) {
		logger.info("<--inventoryController-------------ForgotPassword--------------------started-->"+authentication);
		//adminService.saveuser();
		logger.info("<--inventoryController-------------ForgotPassword--------------------Ended-->"+authentication);
		return "ForgotPassword";
	}
	
	
	@RequestMapping(value = "/UserActive")
	public String UserActive(HttpServletRequest request, HttpServletResponse response,Authentication authentication) {
		logger.info("<--inventoryController-------------UserActive--------------------started-->"+authentication);
		//adminService.saveuser();
		
		logger.info("<--inventoryController-------------UserActive--------------------Ended-->"+authentication);
		return "UserActive";
	}

	
	@RequestMapping(value = "/edit_supplier",method=RequestMethod.POST)
	public ModelAndView edit_supplier(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("inventoryController -- Supplier => Started" + request.getParameter("idd"));
		
		ModelAndView model =null;
		
		List<SupplierDto> supplierDto = null;
		
		try {
			model = new ModelAndView("EditSupplier");
			
			supplierDto = supplierService.findById(Long.parseLong(request.getParameter("idd")));
			
			System.out.println("supplier==>"+new ObjectMapper().writeValueAsString(supplierDto));
			
			model.addObject("lists", supplierDto);
		} catch (Exception e) {
			logger.error("Enter into IntegrationController -- paymentResponse Request Failed", e);
		}
		logger.info("inventoryController -- Supplier => ended" + request.getParameter("idd"));
		return model;
	}
	
	
	@RequestMapping(value = "/DashBoard")
	public ModelAndView DashBoard(HttpServletRequest request, HttpServletResponse response,Authentication authentication,Principal principal) {
		logger.info("<--inventoryController-------------DashBoard--------------------started-->");
		ModelAndView model=new ModelAndView("DashBoard");
		User user = null;
		try {
			System.out.println("==>"+new ObjectMapper().writeValueAsString(authentication));
			System.out.println("==>"+new ObjectMapper().writeValueAsString(principal));
			
			       user=adminService.getByUserName(principal.getName());
			       if(user.getFirstLogin().equals(InventoryConstant.TRUE))
			       {
			    	   model.addObject("userName", user.getUserName());
			    	   model=new ModelAndView("UserActive");
			       }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("pages",authentication.getDetails());
		model.addObject("roles",authentication.getAuthorities());
		
		user.setLastLoginDateTime(new Date());
		userRepository.save(user);
		
		logger.info("<--inventoryController-------------DashBoard--------------------Ended-->");
		return model;
	}
	
	@RequestMapping(value = "/getAllUsers")
	public ResponseEntity<ResponseDto> getAllUsers(HttpServletRequest request, HttpServletResponse response,Authentication authentication,Principal principal,ModelMap map)
	{
		ResponseDto responseDto=new ResponseDto();
		List<UserDto> userDtoList=null;
		logger.info("<--inventoryController-------------getAllUsers--------------------started-->");
		try {
			userDtoList=new ArrayList<>();
			userDtoList=userManagementService.getUsersList();
			if(userDtoList!=null && !userDtoList.isEmpty())
			{
				responseDto.setResponseDtoList(userDtoList);
			}
			System.out.println("authentication==>"+new ObjectMapper().writeValueAsString(authentication));
			System.out.println("getAllUserResponseDto==>"+new ObjectMapper().writeValueAsString(responseDto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------getAllUsers--------------------started-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/createUser")
	public ModelAndView newUser()
	{
		ModelAndView model=new ModelAndView("NewUser");
		logger.info("<--inventoryController-------------newUser--------------------started-->");
		try {
			List<RoleDto> roleDtoList=userManagementService.getRolesNames();
			model.addObject("roleList", roleDtoList);
			System.out.println("roleList==>"+new ObjectMapper().writeValueAsString(roleDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------newUser--------------------started-->");
		return model;
	}
	
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public ResponseEntity<ResponseDto> saveUser(@RequestBody UserDto userDto)
	{
		ResponseDto responseDto=new ResponseDto();
		String status=null;
		try {
			logger.info("<--inventoryController-------------saveUser--------------------started-->");
			System.out.println("userRequestDto==>"+new ObjectMapper().writeValueAsString(userDto));
			status=userManagementService.saveUser(userDto);
			if(status.equals("success")){
				responseDto.setStatus(status);
			}
		} catch (Exception e) {
		 responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------saveUser--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/Edituser", method=RequestMethod.POST)
	public ModelAndView editUser(HttpServletRequest request,HttpServletResponse response)
	{
		UserDto userdto=null;
		ModelAndView model=null;
		Long id=null;
		String userId=null;
		logger.info("<--inventoryController-------------editUser--------------------started-->");
		try {
			userId=request.getParameter("id");
			if(userId!=null && !userId.isEmpty())
			{
				id=Long.valueOf(userId);
				model=new ModelAndView("EditUser");
				userdto=userManagementService.getUser(id);
				model.addObject("userDto", userdto);
				System.out.println("userdto==>"+new ObjectMapper().writeValueAsString(userdto));
				return model;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------editUser--------------------started-->");
		return model;
	}
	
	
	@RequestMapping(value="/getAllRoles")
	public ResponseEntity<ResponseDto> getAllRoles()
	{
		ResponseDto responseDto=null;
		try {
			logger.info("<--inventoryController-------------getAllRoles--------------------started-->");
			List<RoleDto> roleDtoList=userManagementService.getRolesNames();
			if(roleDtoList!=null)
			{
				responseDto=new ResponseDto();
				responseDto.setResponseDtoList(roleDtoList);
			}
			System.out.println("roleDtoList==>"+new ObjectMapper().writeValueAsString(roleDtoList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------getAllRoles--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/getAllCountryAndStatesAndProject",method=RequestMethod.GET)
	public ResponseEntity<List<CountryDto>> getAllCountryAndStatesAndProject()
	{
		List<CountryDto> countryAndStateDtosList=new ArrayList<>();
		try {
			logger.info("<--inventoryController-------------getAllCountry--------------------started-->");
			countryAndStateDtosList=projectService.getAllCountryAndStatesAndProject();
			System.out.println("countryList==>"+new ObjectMapper().writeValueAsString(countryAndStateDtosList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--inventoryController-------------getAllCountry--------------------Ended-->");
		return new ResponseEntity<List<CountryDto>>(countryAndStateDtosList, HttpStatus.OK);
	}
	
	/**  ForgotPasswordDetails check with secret Question and Answer in db and Change the password **/
	
	@RequestMapping(value="/ForgotPasswordDetails", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseDto> forgotpassworddetails(@RequestBody PasswordDetailRequest passwordDetailRequest){
		
		String status = null;
		ResponseDto responseDto = new ResponseDto();
		try 
		{
			 if(passwordDetailRequest != null)
			    {
				 status=adminService.SaveForgotPasswordDeatails(passwordDetailRequest);
				 if(status!=null)
				 {
					 responseDto.setStatus(InventoryConstant.SUCCESS);
				 }
				 else {
					 responseDto.setStatus(InventoryConstant.FAILURE);
				 }
			    }			    
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			logger.info("Error message in forgorPasswordDetails method", e);
		}
	
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		
	}
	
	
	
	/**  USER ACTIVE **/
	
	@RequestMapping(value="/userActive", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseDto> userActive(@RequestBody PasswordDetailRequest passwordDetailRequest){
		
		String status = null;
		ResponseDto responseDto = new ResponseDto();
		try 
		{
			 if(passwordDetailRequest != null)
			    {
				 status=adminService.userActive(passwordDetailRequest);
				 if(status!=null)
				 {
					 responseDto.setStatus(InventoryConstant.SUCCESS);
				 }
				 else {
					 responseDto.setStatus(InventoryConstant.FAILURE);
				 }
			    }			    
		} catch (Exception e) {
			responseDto.setExceptionMessage(e.getMessage());
			logger.info("Error message in userActive method", e);
		}
	
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)	
	public ResponseEntity<ResponseDto> add_supplier_master(@RequestBody SupplierDto supplierDto,Principal principal){
		
		ResponseDto responseDto = new ResponseDto();
		String status=null;
		try
		{
			logger.info("<--inventoryController-------------AddSupplier--------------------started-->");
			if(null != supplierDto){
				status = supplierService.AddSupplier(supplierDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
			}
			
		}catch(Exception e){
			responseDto.setExceptionMessage(e.getMessage());
			e.printStackTrace();
			logger.info("Error message in Add Supplier method", e);
		}
		logger.info("<--inventoryController-------------AddSupplier--------------------Ended-->");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		
	}
	
	
	/**  Get All Supplier From Db **/
	
	@RequestMapping(value = "/GetAllSuppliers", method = RequestMethod.GET)
	@ResponseBody
	public List<SupplierDto> viewAllSuppliers(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("---- Getall supplier started---");
		List<SupplierDto> supplierDto = null;
		try {
			supplierDto = supplierService.viewAllSuppliers();
			System.out.println("supplierDtoList==>"+new ObjectMapper().writeValueAsString(supplierDto));
		} catch (Exception e) {
			logger.info("Supplier save :" + e);
		}
		logger.info("Supplier-- ViewAll ..");		
//		return new ResponseEntity<List<SupplierDto>>(supplierDto, HttpStatus.OK);
		return supplierDto;

	}
	
	
	/**  Get All Scrap From Db **/
	
	@RequestMapping(value = "/GetAllScrap", method = RequestMethod.GET)
	@ResponseBody
	public List<ScrapDto> viewAllScrap(HttpServletRequest request, HttpServletResponse response,Principal principal)
			throws Exception {
		logger.info("---- Getall scrap started---");
		List<ScrapDto> scrapDto = null;
		try {
			scrapDto = scrapService.viewAllScrap(principal);
		} catch (Exception e) {
			logger.info("GetAllScrap" + e);
		}
		logger.info("Supplier-- ViewAll ended ..");		
//		return new ResponseEntity<List<SupplierDto>>(supplierDto, HttpStatus.OK);
		return scrapDto;

	}
	
	/**  Get All UserScrap From Db **/
	
	@RequestMapping(value = "/getAllUserScrap", method = RequestMethod.GET)
	@ResponseBody
	public List<ScrapDto> getAllUserScrap(HttpServletRequest request, HttpServletResponse response,Principal principal)
			throws Exception {
		logger.info("---- getAllUserScrap started---");
		List<ScrapDto> scrapDto = null;
		try {
			scrapDto = scrapService.viewAllUserScrap(principal);
		} catch (Exception e) {
			logger.info("viewAllUserScrap" + e);
		}
		logger.info("-----getAllUserScrap Ended----");		
//		return new ResponseEntity<List<SupplierDto>>(supplierDto, HttpStatus.OK);
		return scrapDto;

	}
	
	/**  Get All WareHouseScrap From Db **/
	
	@RequestMapping(value = "/getAllWarehouseScrap", method = RequestMethod.GET)
	@ResponseBody
	public List<ScrapDto> getAllWarehouseScrap(HttpServletRequest request, HttpServletResponse response,Principal principal)
			throws Exception {
		logger.info("---- getAllWarehouseScrap started---");
		List<ScrapDto> scrapDto = null;
		try {
			scrapDto = scrapService.viewAllWareHouseScrap(principal);
		} catch (Exception e) {
			logger.info("getAllWarehouseScrap" + e);
		}
		logger.info("------- getAllWarehouseScrap ended---..");		
//		return new ResponseEntity<List<SupplierDto>>(supplierDto, HttpStatus.OK);
		return scrapDto;

	}
	
	
/**  Edit Scrap **/
	
	@RequestMapping(value = "/edit_scrap", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView edit_scrap(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("---- Get Scrap By Id---");
		ModelAndView model =null;
		ScrapDto scrapDto = null;
		try {
			model = new ModelAndView("ScrapDetails");
			
			scrapDto = scrapService.findScrapById(request.getParameter("idd"));
			
			model.addObject("lists", scrapDto);
			
			
		} catch (Exception e) {
			logger.info("Supplier save :" + e);
		}
		logger.info("----Get Scrap By Id----");	
		System.out.println("Scrap By Id==>"+new ObjectMapper().writeValueAsString(scrapDto));
		
		return model;

	}

	@RequestMapping(value="/EditScrap", method=RequestMethod.POST)
	public ModelAndView EditScrap(@RequestBody ScrapDto scrapDto,HttpServletRequest request,HttpServletResponse response,Principal principal)
	{
		
		ModelAndView model=new ModelAndView("Scrap");
		CommonResponseDto commonResponseDto=null;
		
		logger.info("<--inventoryController-------------editScrap--------------------started-->");
		try {
			
			if(null != scrapDto){
				
			commonResponseDto = scrapService.saveScrap(scrapDto,principal);
				
			}		
			
			System.out.println("==>"+new ObjectMapper().writeValueAsString(commonResponseDto));
		} catch (Exception e) {
			e.printStackTrace();
		}		
		logger.info("<--inventoryController-------------editScrap--------------------Ended-->");
		return model;
	}

/**  Get All Tools **/	
	
	@RequestMapping(value="/getAllTools", method=RequestMethod.GET)
	public ResponseEntity<BulkRequestResponseDto> getAllTools(Principal principal)
	{
	BulkRequestResponseDto bulkRequestResponseDtosList = null;
		logger.info("<--inventoryController-------------getAll Tools--------------------started-->");
	try {
		bulkRequestResponseDtosList = subcategoryService.findAllTools(principal);
		System.out.println("getAll Tools==>"+new ObjectMapper().writeValueAsString(bulkRequestResponseDtosList));
		//model.addObject("inventoryManagementDtoList", categoryDtoList);
	} catch (Exception e) {
		e.printStackTrace();
		new ResponseEntity<BulkRequestResponseDto>(bulkRequestResponseDtosList,HttpStatus.BAD_REQUEST);
	}
		logger.info("<--inventoryController-------------getAll Tools--------------------ended-->");
		return new ResponseEntity<BulkRequestResponseDto>(bulkRequestResponseDtosList,HttpStatus.OK);
	}
	
	//*** GetAllToolsforScrap ***///
	
		@RequestMapping(value="/GetAllToolsforScrap", method=RequestMethod.GET)
		public ResponseEntity<BulkRequestResponseDto> GetAllToolsforScrap(Principal principal)
		{
		BulkRequestResponseDto bulkRequestResponseDtosList = null;
			logger.info("<--inventoryController-------------GetAllToolsforScrap--------------------started-->");
		try {
			bulkRequestResponseDtosList = scrapService.FindAllToolsforScrap(principal);
			System.out.println("getAll Tools==>"+new ObjectMapper().writeValueAsString(bulkRequestResponseDtosList));
			//model.addObject("inventoryManagementDtoList", categoryDtoList);
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<BulkRequestResponseDto>(bulkRequestResponseDtosList,HttpStatus.BAD_REQUEST);
		}
			logger.info("<--inventoryController-------------GetAllToolsforScrap--------------------ended-->");
			return new ResponseEntity<BulkRequestResponseDto>(bulkRequestResponseDtosList,HttpStatus.OK);
		}
		
		
		/**  Save Bulk Tools **/	
		
		
		@RequestMapping(value="/saveBulkRequest",method=RequestMethod.POST)	
		public ResponseEntity<ResponseDto> saveBulkRequest(@RequestBody List<CategoryDto> categoryDto,Principal principal){
			ResponseDto responseDto = new ResponseDto();
			try
			{
				logger.info("<--inventoryController-------------saveBulkRequest--------------------started-->");
				if(null != categoryDto){
					responseDto = bulkToolsService.saveBulkRequest(categoryDto,principal);
				}
			}catch(Exception e){
				responseDto.setExceptionMessage(e.getMessage());
				logger.info("Error message in saveBulkRequest method", e);
			}
			logger.info("<--inventoryController-------------saveBulkRequest--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
			
		}
		
		@RequestMapping(value="/getAllCity",method=RequestMethod.GET)	
		public ResponseEntity<ResponseDto> getAllCity(){
			
			ResponseDto responseDto =null;
			List<CityDto> cityDtoList=new ArrayList<>();
			try
			{
				logger.info("<--inventoryController-------------getAllCity--------------------started-->");
					
					cityDtoList = adminService.getAllCity();
					if(cityDtoList!=null && !cityDtoList.isEmpty())
					{
						responseDto = new ResponseDto();
						responseDto.setResponseDtoList(cityDtoList);
					}
			}catch(Exception e){
				logger.info("Error in getAllCity", e);
			}
			logger.info("<--inventoryController-------------getAllCity--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
			
		}
	
		@RequestMapping(value="/getCurrentUserPages",method=RequestMethod.GET)	
		public ResponseEntity<List<MenuDto>> getCurrentUserpages(HttpServletRequest request,HttpServletResponse response,Principal principal)
		{
			List<MenuDto> menuItemDto=new ArrayList<>();
			try {
				logger.info("<--inventoryController-------------getCurrentUserPages--------------------started-->");
				menuItemDto=adminService.getCurrentUserPages(principal);
				System.out.println("getCurrentUserPagesList==>"+new ObjectMapper().writeValueAsString(menuItemDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getCurrentUserPages--------------------started-->");
			return new ResponseEntity<List<MenuDto>>(menuItemDto, HttpStatus.OK);
		}

/**  getAllSecretQuestions **/
		
		/*@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
		public String logoutDo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session= request.getSession(false);
		    SecurityContextHolder.clearContext();
		    logger.info("<--inventoryController-------------logout--------------------started-->");
		         session= request.getSession(false);
		        if(session != null) {
		            session.invalidate();
		        }
		        for(Cookie cookie : request.getCookies()) {
		            cookie.setMaxAge(0);
		        }
		        logger.info("<--inventoryController-------------logout--------------------started-->");
		    return "logout";
		}*/
		
		
		
		
		/**  getAllSecretQuestions **/
		
		@RequestMapping(value = "/getAllSecretQuestions")
		public ResponseEntity<ResponseDto> getAllSecretQuestions() {
			logger.info("<--inventoryController-------------getAllSecretQuestions--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<SecretQuestionsDto> secretQuestionsDtoList = null;
			try {
				secretQuestionsDtoList = new ArrayList<>();
				secretQuestionsDtoList = adminService.getAllSecretQuestions();
				responseDto.setResponseDtoList(secretQuestionsDtoList);
				System.out.println("responseDto==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllSecretQuestions--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		
		/**  Change Password **/
		
		@RequestMapping(value = "/ChangePassword",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> ChangePassword(@RequestBody UserDto userDto,Principal principal) {
			
			logger.info("<--inventoryController-------------ChangePassword--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = adminService.changePassword(userDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("Change Password==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------ChangePassword--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}

		
		/**  Get Profile Details **/
		
		@RequestMapping(value="/getProfileDetails")
		public ResponseEntity<UserDto> getProfileDetails(Principal principal)
		{
			UserDto userDto = null;
			//ModelAndView model=new ModelAndView("Inventory_mgmt_table");
			logger.info("<--inventoryController-------------getProfileDetails--------------------started-->");
		try {
			userDto = userManagementService.getProfileDetails(principal);
			System.out.println("inventoryManagementDtoList==>"+new ObjectMapper().writeValueAsString(userDto));
			//model.addObject("inventoryManagementDtoList", inventoryManagementDtoList);
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
		}
			logger.info("<--inventoryController-------------getProfileDetails--------------------ended-->");
			return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
		}
		
		
		/**  updateUserProfile **/
		
		@RequestMapping(value = "/updateUserProfile",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> updateUserProfile(@RequestBody UserDto userDto,Principal principal) {
			
			logger.info("<--inventoryController-------------updateUserProfile--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = userManagementService.updateProfile(userDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				else{
					responseDto.setStatus(InventoryConstant.FAILURE);
				}
				System.out.println("updateUserProfile==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------updateUserProfile--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  Save SubCategory **/
		
		@RequestMapping(value = "/saveSubCategory",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveSubCategory(@RequestBody SubCategoryDto subCategoryDto,Principal principal) {
			
			logger.info("<--inventoryController-------------saveSubCategory--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = subcategoryService.saveSubCategory(subCategoryDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveSubCategory==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveSubCategory--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  Save Block **/
		
		@RequestMapping(value = "/saveBlock",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveBlock(@RequestBody WareHouseBlocksDto wareHouseBlocksDto,Principal principal) {
			
			logger.info("<--inventoryController-------------saveBlock--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = wareHouseService.saveBlock(wareHouseBlocksDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveBlock==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveBlock--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		
		/**  getAllWareHouseBlock **/
		
		@RequestMapping(value = "/getAllWareHouseBlock")
		public ResponseEntity<ResponseDto> getAllWareHouseBlock() {
			logger.info("<--inventoryController-------------getAllWareHouseBlock--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<WareHouseDto> wareHouseBlocksDtoList = null;
			try {
				wareHouseBlocksDtoList = new ArrayList<>();
				wareHouseBlocksDtoList = wareHouseService.getAllWareHouseBlock();
				responseDto.setResponseDtoList(wareHouseBlocksDtoList);
				System.out.println("getAllWareHouseBlock==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllWareHouseBlock--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  getAllWareHouseBlock **/
		
		@RequestMapping(value = "/getAllUserWareHouseBlock")
		public ResponseEntity<ResponseDto> getAllUserWareHouseBlock(Principal principal) {
			logger.info("<--inventoryController-------------getAllUserWareHouseBlock--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<WareHouseDto> wareHouseBlocksDtoList = null;
			try {
				wareHouseBlocksDtoList = new ArrayList<>();
				wareHouseBlocksDtoList = wareHouseService.getAllUserWareHouseBlock(principal);
				responseDto.setResponseDtoList(wareHouseBlocksDtoList);
				System.out.println("getAllWareHouseBlock==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllUserWareHouseBlock--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		/**  getAllWorksmenDetails **/
		
		@RequestMapping(value = "/getAllWorksmenDetails")
		public ResponseEntity<ResponseDto> getAllWorksmenDetails(Principal principal) {
			logger.info("<--inventoryController-------------getAllWorksmenDetails--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<WorksMenDetailsDto> worksMenDetailsDtoList = null;
			try {
				worksMenDetailsDtoList = new ArrayList<>();
				worksMenDetailsDtoList = worksMenService.getAllWorksmenDetails(principal);
				responseDto.setResponseDtoList(worksMenDetailsDtoList);
				System.out.println("getAllWorksmenDetails==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllWorksmenDetails--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  getAllWorksmenDetails **/
		
		@RequestMapping(value = "/getAllWorksmenCategory")
		public ResponseEntity<ResponseDto> getAllWorksmenCategory(Principal principal) {
			logger.info("<--inventoryController-------------getAllWorksmenCategory--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<WorksMenCategoryDto> worksMenCategoryDtoList = null;
			try {
				worksMenCategoryDtoList = new ArrayList<>();
				worksMenCategoryDtoList = worksMenService.getAllWorksmenCategory(principal);
				responseDto.setResponseDtoList(worksMenCategoryDtoList);
				System.out.println("worksMenCategoryDtoList==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllWorksmenCategory--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** saveWorksMenDetails **/
		
		@RequestMapping(value = "/saveWorksMenDetails",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveWorksMenDetails(@RequestBody List<WorksMenDetailsDto> worksMenDetailsDtolist,Principal principal) {
			
			logger.info("<--inventoryController-------------saveWorksMenDetails--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = worksMenService.saveWorksMenDetails(worksMenDetailsDtolist,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveWorksMenDetails==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveWorksMenDetails--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  getAllELCB **/
		
		@RequestMapping(value = "/getAllELCB")
		public ResponseEntity<ResponseDto> getAllELCB(Principal principal) {
			logger.info("<--inventoryController-------------getAllELCB--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<ELCPDto> elcpDtoList = null;
			try {
				elcpDtoList = new ArrayList<>();
				elcpDtoList = elcbService.getAllELCB(principal);
				responseDto.setResponseDtoList(elcpDtoList);
				System.out.println("elcpDtoList==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllELCB--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** saveWorksMenDetails **/
		
		@RequestMapping(value = "/saveelcb",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveelcb(@RequestBody ELCPDto elcpDto,Principal principal) {
			
			logger.info("<--inventoryController-------------saveELCB--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = elcbService.saveELCB(elcpDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveELCB==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveELCB--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** saveWorksMenDetails **/
		
		@RequestMapping(value = "/saveWorksMenCategory",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveWorksMenCategory(@RequestBody WorksMenCategoryDto worksMenCategoryDto,Principal principal) {
			
			logger.info("<--inventoryController-------------saveWorksMenCategory--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = worksMenService.saveWorksMenCategory(worksMenCategoryDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveELCB==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveWorksMenCategory--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  getAllSafetyStatus **/
		
		@RequestMapping(value = "/getAllSafetyStatus")
		public ResponseEntity<ResponseDto> getAllSafetyStatus(Principal principal) {
			logger.info("<--inventoryController-------------getAllSafetyStatus--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			List<SafetyStatusDto> safetyStatusEntitiesList = null;
			try {
				safetyStatusEntitiesList = new ArrayList<>();
				safetyStatusEntitiesList = safetyService.getAllSafetyStatus(principal);
				responseDto.setResponseDtoList(safetyStatusEntitiesList);
				System.out.println("getAllSafetyStatus==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllSafetyStatus--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** saveState **/
		
		@RequestMapping(value = "/saveState",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveState(@RequestBody StateDto stateDto,Principal principal) {
			
			logger.info("<--inventoryController-------------saveState--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = adminService.saveState(stateDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveState==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveState--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		@PreAuthorize("hasAuthority('OFFICE ADMINISTRATOR')")
		@RequestMapping(value="/officeAdmin", method=RequestMethod.GET)
		public ModelAndView officeAdminMapping(@RequestParam("link") String link,HttpServletRequest request,HttpServletResponse response,Principal principal)
		{
			ModelAndView model=null;
			
			logger.info("<--inventoryController-------------officeAdminMapping--------------------started-->");
			try {
				    String menu=menuRepository.getMenuAccess(link, principal.getName());
				     if(menu!=null)
				     {
				    	 model=new ModelAndView(link);	 
				     }
				     else{
				    	 model=new ModelAndView("UnAuthorized");	 
				     }
			} catch (Exception e) {
				e.printStackTrace();
			}		
			logger.info("<--inventoryController-------------officeAdminMapping--------------------Ended-->");
			return model;
		}
		
		@PreAuthorize("hasAuthority('WAREHOUSE ADMINISTRATOR')")
		@RequestMapping(value="/wareHouseAdmin", method=RequestMethod.GET)
		public ModelAndView wareHouseAdminMapping(@RequestParam("link") String link,HttpServletRequest request,HttpServletResponse response,Principal principal)
		{
			ModelAndView model=null;
			
			logger.info("<--inventoryController-------------wareHouseAdminMapping--------------------started-->");
			try {
				
				String menu=menuRepository.getMenuAccess(link, principal.getName());
			     if(menu!=null)
			     {
			    	 model=new ModelAndView(link);	 
			     }
			     else{
			    	 model=new ModelAndView("UnAuthorized");	 
			     }
			} catch (Exception e) {
				e.printStackTrace();
			}		
			logger.info("<--inventoryController-------------wareHouseAdminMapping--------------------Ended-->");
			return model;
		}
		
		@PreAuthorize("hasAuthority('USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')")
		@RequestMapping(value="/common", method=RequestMethod.GET)
		public ModelAndView commonUserMapping(@RequestParam("link") String link,HttpServletRequest request,HttpServletResponse response,Principal principal)
		{
			ModelAndView model=null;
			
			logger.info("<--inventoryController-------------commonUserMapping--------------------started-->");
			try {
				 String menu=menuRepository.getMenuAccess(link, principal.getName());
			     if(menu!=null)
			     {
			    	 model=new ModelAndView(link);	 
			     }
			     else{
			    	 model=new ModelAndView("UnAuthorized");	 
			     }
			} catch (Exception e) {
				e.printStackTrace();
			}		
			logger.info("<--inventoryController-------------commonUserMapping--------------------Ended-->");
			return model;
		}
		
		/** saveCity **/
		
		@RequestMapping(value = "/saveCity",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveCity(@RequestBody CityDto cityDto,Principal principal) {
			
			logger.info("<--inventoryController-------------saveCity--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = adminService.saveCity(cityDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveCity==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveCity--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/**  getPasswordRules **/
		
		@RequestMapping(value="/getPasswordRules")
		public ResponseEntity<PasswordRulesDto> getPasswordRules(Principal principal)
		{
			PasswordRulesDto passwordRulesDto = null;
			logger.info("<--inventoryController-------------getPasswordRules--------------------started-->");
		try {
			passwordRulesDto = adminService.getPasswordRules(principal);
			System.out.println("getPasswordRules==>"+new ObjectMapper().writeValueAsString(passwordRulesDto));
		} catch (Exception e) {
			e.printStackTrace();
			new ResponseEntity<PasswordRulesDto>(passwordRulesDto,HttpStatus.BAD_REQUEST);
		}
			logger.info("<--inventoryController-------------getPasswordRules--------------------ended-->");
			return new ResponseEntity<PasswordRulesDto>(passwordRulesDto,HttpStatus.OK);
		}
		
		
		/** For getAllInspectionDetails **/

		@RequestMapping(value = "/getAllInspectionDetails")
		public ResponseEntity<ResponseDto> getAllInspectionDetails(Principal principal) {
			logger.info("<--inventoryController-------------getAllInspectionDetails--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<InventoryRequestDto> inventoryRequestDtoList = null;
			try {
				inventoryRequestDtoList = new ArrayList<>();
				inventoryRequestDtoList = inventoryRequestService.getAllInspectionDetails(principal);
				responseDto.setResponseDtoList(inventoryRequestDtoList);
				System.out.println("projectTypeDtoList==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllInspectionDetails--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		 
		/** approveInspection **/
		
		@RequestMapping(value = "/approveInspection",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> approveInspection(@RequestBody InventoryRequestDto requestDto,Principal principal) {
			
			logger.info("<--inventoryController-------------approveInspection--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status="";
			try {				
				status = inventoryRequestService.approveInspection(requestDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("approveInspection==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------approveInspection--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		} 
		
		
		
		/** verifyInspection **/
		
		@RequestMapping(value = "/verifyInspection",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> verifyInspection(@RequestBody InventoryRequestDto requestDto,Principal principal) {
			
			logger.info("<--inventoryController-------------verifyInspection--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = inventoryRequestService.verifyInspection(requestDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("verifyInspection==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------verifyInspection--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		
		/** VerifyandApproveScrapInspection **/
		
		@RequestMapping(value = "/VerifyandApproveScrapInspection",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> VerifyandApproveScrapInspection(@RequestBody ScrapInspectionDto scrapInspectionDto,Principal principal) {
			
			logger.info("<--inventoryController-------------VerifyandApproveScrapInspection--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = scrapInspectionService.VerifyandApproveScrapInspection(scrapInspectionDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("VerifyandApproveScrapInspection==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------VerifyandApproveScrapInspection--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** VerifyandApproveServiceInspection **/
		
		@RequestMapping(value = "/VerifyandApproveServiceInspection",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> VerifyandApproveServiceInspection(@RequestBody ServiceInspectionDto serviceInspectionDto,Principal principal) {
			
			logger.info("<--inventoryController-------------VerifyandApproveServiceInspection--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = serviceInpectionService.VerifyandApproveServiceInspection(serviceInspectionDto,principal);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("VerifyandApproveServiceInspection==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------VerifyandApproveServiceInspection--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		/** saveUserTheme **/
		
		@RequestMapping(value = "/saveUserTheme",method = RequestMethod.POST)
		public ResponseEntity<ResponseDto> saveUserTheme(@RequestBody UserDto userDto,Principal principal,HttpSession session) {
			
			logger.info("<--inventoryController-------------saveUserTheme--------------------started-->");
			ResponseDto responseDto=new ResponseDto();
			String status=null;
			try {				
				status = adminService.saveUserTheme(userDto,principal,session);
				if(status.equals(InventoryConstant.SUCCESS))
				{
					responseDto.setStatus(InventoryConstant.SUCCESS);
				}
				System.out.println("saveUserTheme==>"+new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				responseDto.setExceptionMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------saveUserTheme--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** For getAllScrapInspection **/

		@RequestMapping(value = "/getAllScrapInspection")
		public ResponseEntity<ResponseDto> getAllScrapInspection(Principal principal) {
			logger.info("<--inventoryController-------------getAllScrapInspection--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<ScrapInspectionDto> scrapInspectionDtoList = null;
			try {
				scrapInspectionDtoList = new ArrayList<>();
				scrapInspectionDtoList = scrapInspectionService.getAllScrapInspection(principal);
				responseDto.setResponseDtoList(scrapInspectionDtoList);
				System.out.println("scrapInspectionDtoList==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllScrapInspection--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		/** For getAllServiceInspection **/

		@RequestMapping(value = "/getAllServiceInspection")
		public ResponseEntity<ResponseDto> getAllServiceInspection(Principal principal) {
			logger.info("<--inventoryController-------------getAllServiceInspection--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<ServiceInspectionDto> serviceInspectionDtoList = null;
			try {
				serviceInspectionDtoList = new ArrayList<>();
				serviceInspectionDtoList = serviceInpectionService.getAllServiceInspection(principal);
				responseDto.setResponseDtoList(serviceInspectionDtoList);
				System.out.println("serviceInspectionDtoList==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllServiceInspection--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** For getLastOneMonthUserElcbStatus **/

		@RequestMapping(value = "/getLastOneMonthUserElcbStatus")
		public ResponseEntity<ResponseDto> getLastOneMonthUserElcbStatus(Principal principal) {
			logger.info("<--inventoryController-------------getLastOneMonthUserElcbStatus--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<ELCPDto> elcbDtoList = null;
			try {
				elcbDtoList = new ArrayList<>();
				elcbDtoList = elcbService.getLastOneMonthUserElcbStatus(principal);
				responseDto.setResponseDtoList(elcbDtoList);
				System.out.println("getLastOneMonthUserElcbStatus==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getLastOneMonthUserElcbStatus--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		/** For getLastOneMonthOfficceElcbStatus **/

		@RequestMapping(value = "/getLastOneMonthOfficeElcbStatus")
		public ResponseEntity<ResponseDto> getLastOneMonthOfficeElcbStatus(Principal principal) {
			logger.info("<--inventoryController-------------getLastOneMonthOfficeElcbStatus--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<ELCPDto> elcbDtoList = null;
			try {
				elcbDtoList = new ArrayList<>();
				elcbDtoList = elcbService.getLastOneMonthOfficeElcbStatus();
				responseDto.setResponseDtoList(elcbDtoList);
				System.out.println("getLastOneMonthOfficceElcbStatus==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getLastOneMonthOfficeElcbStatus--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** For getServiceDueDateUser **/

		@RequestMapping(value = "/getServiceDueDateUser")
		public ResponseEntity<ResponseDto> getServiceDueDateUser(Principal principal) {
			logger.info("<--inventoryController-------------getServiceDueDateUser--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<?> inventoryEntranceDtoList = null;
			try {
				inventoryEntranceDtoList = new ArrayList<>();
				inventoryEntranceDtoList = serviceTrackerService.getAllUserServiceDueDate(principal);
				responseDto.setResponseDtoList(inventoryEntranceDtoList);
				System.out.println("getAllUserServiceDueDate==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getServiceDueDateUser--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** For getServiceDueDateWareHouse **/

		@RequestMapping(value = "/getServiceDueDateWareHouse")
		public ResponseEntity<ResponseDto> getServiceDueDateWareHouse(Principal principal) {
			logger.info("<--inventoryController-------------getServiceDueDateWareHouse--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<?> inventoryEntranceDtoList = null;
			try {
				inventoryEntranceDtoList = new ArrayList<>();
				inventoryEntranceDtoList = serviceTrackerService.getAllWareHouseServiceDueDate(principal);
				responseDto.setResponseDtoList(inventoryEntranceDtoList);
				System.out.println("getServiceDueDateWareHouse==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getServiceDueDateWareHouse--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		
		/** For getAllServiceDueDate **/

		@RequestMapping(value = "/getAllServiceDueDate")
		public ResponseEntity<ResponseDto> getAllServiceDueDate(Principal principal) {
			logger.info("<--inventoryController-------------getAllServiceDueDate--------------------started-->");
			ResponseDto responseDto = new ResponseDto();
			List<?> inventoryEntranceDtoList = null;
			try {
				inventoryEntranceDtoList = new ArrayList<>();
				inventoryEntranceDtoList = serviceTrackerService.getAllServiceDueDateForAllRole(principal);
				responseDto.setResponseDtoList(inventoryEntranceDtoList);
				System.out.println("getAllServiceDueDate==>" + new ObjectMapper().writeValueAsString(responseDto));
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("<--inventoryController-------------getAllServiceDueDate--------------------Ended-->");
			return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
		}
		
		 
}
