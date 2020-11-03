package com.fa.inventory.service.impl;

import java.math.BigInteger;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fa.inventory.common.util.MasterDateUtil;
import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.controller.InventoryController;
import com.fa.inventory.dto.DepartmentDto;
import com.fa.inventory.dto.DesignationDto;
import com.fa.inventory.dto.EmployeeDto;
import com.fa.inventory.dto.IdProofMasterDto;
import com.fa.inventory.dto.ProjectDto;
import com.fa.inventory.dto.RoleDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.dto.WareHouseDto;
import com.fa.inventory.entity.Department;
import com.fa.inventory.entity.Designation;
import com.fa.inventory.entity.Employee;
import com.fa.inventory.entity.IdProofMaster;
import com.fa.inventory.entity.Project;
import com.fa.inventory.entity.Role;
import com.fa.inventory.entity.User;
import com.fa.inventory.entity.WareHouse;
import com.fa.inventory.repository.DepartmentRepository;
import com.fa.inventory.repository.DesignationRepository;
import com.fa.inventory.repository.EmployeeRepository;
import com.fa.inventory.repository.IdProofMasterRepository;
import com.fa.inventory.repository.ProjectRepository;
import com.fa.inventory.repository.RoleRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.repository.WareHouseRepository;
import com.fa.inventory.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService{

	
	protected final Logger logger = Logger.getLogger(InventoryController.class);
	
	@Resource
	UserRepository userRepository;
	
	@Resource
	RoleRepository roleRepository;

	@Resource
	ProjectRepository projectRepository;
	
	@Resource
	DesignationRepository DesignationRepository;
	
	@Resource
	WareHouseRepository wareHouseRepository;
	
	@Resource
	EmployeeRepository employeeRepository;
	
	@Resource
	DepartmentRepository departmentRepository;
	
	@Resource
	IdProofMasterRepository idProofMasterRepository;
	
	@Resource(name="Inventory")
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UserDto> getUsersList() {
		List<UserDto> userDtoList = null;
		logger.info("<--UserManagementServiceImpl-------------getUsersList--------------------started-->");
		try {
			List<User> userList=userRepository.findAll();
			
			if(userList!=null && !userList.isEmpty())
			{
				userDtoList=new ArrayList<>();
				for(int i=0;i<userList.size();i++)
				{
					User user=userList.get(i);
					if(user!=null)
					{
						userDtoList.add(MapUserDto(user));
						
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getUsersList--------------------Ended-->");
		return userDtoList;
	}
	
	
	public UserDto MapUserDto(User user)
	{
		logger.info("<--UserManagementServiceImpl-------------MapUserDto--------------------started-->");
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setUserName(user.getUserName());
		userDto.setName(user.getName());
		userDto.setRoleType(user.getRoleType());
		userDto.setRoleSet(MapRolesDto(user.getRoles()));
		userDto.setUserNotSelectedRoles(mapUserNotSelectedRoles(user.getRoles()));
		userDto.setWareHouseDtoList(MapWareHouseDto(user.getWareHouseItem()));
		userDto.setUserNotSelectedWareHouseDtoList(mapUserNotSelectedWareHouseDtoList(user.getWareHouseItem()));
		userDto.setUserNotSelectedProjects(mapUserNotSelectedProjects(user.getProjectItem()));
		userDto.setProjectItemDtoList(mapUserSelectedProjects(user.getProjectItem()));
		
		if(user.getEmployee()!=null)
		{
			Employee employee=user.getEmployee();
			userDto.setDesignation(employee.getDesignation());
			if(employee.getMobileNumber()!=null)
			{
				userDto.setMobileNumber(String.valueOf(employee.getMobileNumber()));
			}
			userDto.setEmpid(employee.getEmployeeId());
			userDto.setEmailId(employee.getMailId());
		}
		
		
		userDto.setRole(mapRoleNames(user.getRoles()));
		logger.info("<--UserManagementServiceImpl-------------MapUserDto--------------------started-->");
		return userDto;
	}

	private List<WareHouseDto> mapUserNotSelectedWareHouseDtoList(List<WareHouse> wareHouseItem) {
		logger.info("<--UserManagementServiceImpl-------------mapUserNotSelectedWareHouseDtoList--------------------started-->");
		 List<WareHouseDto> wareHouseDtoList=new ArrayList<>();
		  int count=0;
		  try {
			  List<WareHouse> wareHouseEntityList=wareHouseRepository.findAll();
			  if(wareHouseEntityList!=null && !wareHouseEntityList.isEmpty())
				{
					for(int i=0;i<wareHouseEntityList.size();i++)
					{
						WareHouse wareHouse=wareHouseEntityList.get(i);
						if(wareHouse!=null)
						{
							for(int j=0;j<wareHouseItem.size();j++)
							{
								WareHouse userWareHouse=wareHouseItem.get(j);
								if(userWareHouse!=null)
								{
									if(wareHouse.getWareHouseName().equals(userWareHouse.getWareHouseName()))
									{
									 count++;	
									}
								}
							}
							if(count==0)
							{
								WareHouseDto wareHouseDto=new WareHouseDto();
								wareHouseDto.setId(wareHouse.getId());
								wareHouseDto.setSelected(false);
								wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
								wareHouseDtoList.add(wareHouseDto);
							}
							count=0;
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------mapUserNotSelectedWareHouseDtoList--------------------started-->");
		return wareHouseDtoList;
	}


	private List<ProjectDto> mapUserNotSelectedProjects(List<Project> projectItem) {
		List<ProjectDto> projectDtoList=new ArrayList<>();
		int count=0;
		try {
			logger.info("<--UserManagementServiceImpl-------------mapUserNotSelectedProjects--------------------started-->");
         List<Project> projectList=projectRepository.findAll();
			
			if(projectList!=null && !projectList.isEmpty())
			{
				for(int i=0;i<projectList.size();i++)
				{
					Project project=projectList.get(i);
					if(project!=null)
					{
						for(int j=0;j<projectItem.size();j++)
						{
							Project userProject=projectItem.get(j);
							if(userProject!=null)
							{
								if(project.getName().equals(userProject.getName()))
								{
								 count++;	
								}
							}
						}
						if(count==0)
						{
							ProjectDto projectDto=new ProjectDto();
							projectDto.setId(project.getId());
							projectDto.setSelected(false);
							projectDto.setName(project.getName());
							projectDtoList.add(projectDto);
						}
						count=0;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------mapUserNotSelectedProjects--------------------started-->");
		return projectDtoList;
	}


	private List<ProjectDto> mapUserSelectedProjects(List<Project> projectItem) {
		List<ProjectDto> projectDtoList=new ArrayList<>();
		try {
			logger.info("<--UserManagementServiceImpl-------------mapUserSelectedProjects--------------------started-->");	
			if(projectItem!=null && !projectItem.isEmpty())
			{
				for(int i=0;i<projectItem.size();i++)
				{
					Project project=projectItem.get(i);
					if(project!=null)
					{
					ProjectDto projectDto=new ProjectDto();	
					projectDto.setId(project.getId());
					projectDto.setSelected(true);
					projectDto.setName(project.getName());
					projectDtoList.add(projectDto);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------mapUserSelectedProjects--------------------Ended-->");
		return projectDtoList;
	}



	private List<WareHouseDto> MapWareHouseDto(List<WareHouse> wareHouseItem) {
		logger.info("<--UserManagementServiceImpl-------------MapWareHouseDto--------------------started-->");
		List<WareHouseDto> wareHouseDtoList=new ArrayList<>();
		if(wareHouseItem!=null && !wareHouseItem.isEmpty())
		{
			for(int i=0;i<wareHouseItem.size();i++)
			{
				WareHouse wareHouse=wareHouseItem.get(i);
				if(wareHouse!=null)
				{
					WareHouseDto wareHouseDto=new WareHouseDto();
					wareHouseDto.setId(wareHouse.getId());
					wareHouseDto.setSelected(true);
					wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
					wareHouseDtoList.add(wareHouseDto);
				}
			}
		}
		logger.info("<--UserManagementServiceImpl-------------MapWareHouseDto--------------------Ended-->");
		return wareHouseDtoList;
	}


	private String mapRoleNames(Set<Role> roles) {
		String roleName="";
		logger.info("<--UserManagementServiceImpl-------------MapUserDto--------------------started-->");
		for(Role r:roles)
		{
			roleName+=r.getRoleName()+",";
			
		}
		
		roleName = roleName.replaceAll(",$", "");
		logger.info("<--UserManagementServiceImpl-------------MapUserDto--------------------Ended-->");
		return roleName;
	}


	private List<RoleDto> MapRolesDto(Set<Role> roles) {
		logger.info("<--UserManagementServiceImpl-------------MapRolesDto--------------------started-->");
		List<RoleDto> roleDtoList=new ArrayList<>();
		
		try {
			for(Role r:roles)
			{
				RoleDto roleDto=new RoleDto();
				roleDto.setId(r.getId());
				roleDto.setSelected(true);
				roleDto.setRoleName(r.getRoleName());
				roleDtoList.add(roleDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--UserManagementServiceImpl-------------MapRolesDto--------------------started-->");
		return roleDtoList;
	}

	
	private List<RoleDto> mapUserNotSelectedRoles(Set<Role> roles) {
		logger.info("<--UserManagementServiceImpl-------------MapRolesDto--------------------started-->");
		List<RoleDto> roleDtoList=new ArrayList<>();
		RoleDto roleDto=null;
		int count=0;
		try {
			List<Role> roleEntityList=roleRepository.findAll();
			if(roleEntityList!=null && !roleEntityList.isEmpty())
			{
				for(int i=0;i<roleEntityList.size();i++)
				{
					Role role=roleEntityList.get(i);
					if(role!=null)
					{
						for(Role r:roles)
						{
							if(r.getRoleName().equals(role.getRoleName()))
							{
								count++;
							}
						}
						if(count==0)
						{
							roleDto=new RoleDto();
							roleDto.setId(role.getId());
							roleDto.setSelected(false);
							roleDto.setRoleName(role.getRoleName());
							roleDtoList.add(roleDto);
						}
						count=0;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("<--UserManagementServiceImpl-------------MapRolesDto--------------------started-->");
		return roleDtoList;
	}

	@Override
	public String saveUser(UserDto userDto) throws Exception
	{
		User user=new User();
		logger.info("<--UserManagementServiceImpl-------------saveUser--------------------started-->");
			if(userDto!=null && userDto.getId()!=null){
				user=editUser(userDto);
			}
			else{
				user=newUser(userDto);
			}
			userRepository.save(user);	
		logger.info("<--UserManagementServiceImpl-------------saveUser--------------------started-->");
		return "success";
	}
	
	public Set<Role> MapRoles(User user,List<RoleDto> roleDtoSet)
	{
		Set<Role> roleSet=new HashSet<>();
		logger.info("<--UserManagementServiceImpl-------------MapRoles--------------------started-->");
			for(RoleDto r:roleDtoSet)
			{
				Role role=new Role();
				if(r.getSelected()!=null)
				{
					if(r.getSelected())
					{
						role=roleRepository.findByRoleName(r.getRoleName().trim());
						if(role!=null)
						{
							roleSet.add(role);
						}
					}
				}
				
			}
		logger.info("<--UserManagementServiceImpl-------------MapRoles--------------------started-->");
		return roleSet;
	}

	@Override
	public UserDto getUser(Long id) {
		logger.info("<--UserManagementServiceImpl-------------getUser--------------------started-->");
		UserDto userDto=null;
		User user=userRepository.findOne(id);
		
		if(user!=null)
		{
			userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setUserName(user.getUserName());
			userDto.setEmpid(user.getEmpid());
			userDto.setName(user.getName());
			
			if(user.getEmployee()!= null && user.getEmployee().getMobileNumber()!=null)
			{
				userDto.setMobileNumber(user.getEmployee().getMobileNumber().toString());
				userDto.setEmailId(user.getEmployee().getMailId());
				userDto.setRoleType(user.getRoleType());
				userDto.setDesignation(user.getEmployee().getDesignation());
			}
			
			userDto.setPassword(user.getPassword());
			userDto.setSecretQuestion(user.getSecretQuestion());
			userDto.setSecretAnswer(user.getSecretAnswer());
			userDto.setTheme(user.getTheme());
			userDto.setUserNotSelectedRoles(mapUserNotSelectedRoles(user.getRoles()));
			userDto.setWareHouseDtoList(MapWareHouseDto(user.getWareHouseItem()));
			userDto.setUserNotSelectedProjects(mapUserNotSelectedProjects(user.getProjectItem()));
			userDto.setProjectItemDtoList(mapUserSelectedProjects(user.getProjectItem()));
			userDto.setRoleSet(MapRolesDto(user.getRoles()));
		}
		
		logger.info("<--UserManagementServiceImpl-------------getUser--------------------started-->");
		return userDto;
	}
	
	public String getUserSequence()
	{
		String userSeq=null;
		logger.info("<--UserManagementServiceImpl-------------getUser--------------------started-->");
		userSeq = jdbcTemplate.queryForObject("call USER_SEQ()", String.class);
		logger.info("<--UserManagementServiceImpl-------------getUser--------------------started-->");
		return userSeq;
	}


	@Override
	public List<RoleDto> getRolesNames() {
		logger.info("<--UserManagementServiceImpl-------------getRolesNames--------------------started-->");
		List<RoleDto> roleDtoList=new ArrayList<>();
		try {
			
			List<Role> rolesEntityList=roleRepository.findAll();
			for(int i=0;i<rolesEntityList.size();i++)
			{
				Role role=rolesEntityList.get(i);
				RoleDto roleDto=new RoleDto();
				roleDto.setId(role.getId());
				roleDto.setRoleName(role.getRoleName());
				roleDtoList.add(roleDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getRolesNames--------------------started-->");
		return roleDtoList;
	}


	@Override
	public UserDto getProfileDetails(Principal principal) {
		logger.info("<--UserManagementServiceImpl-------------getProfileDetails--------------------started-->");
		UserDto userDto = new UserDto();
		try {
			
			User user = new User();
			
			user = userRepository.findByUserName(principal.getName());
			
			if(user != null)
			{
				userDto = getUser(Long.valueOf(user.getId()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		logger.info("<--UserManagementServiceImpl-------------getProfileDetails--------------------started-->");
		return userDto;
        		
	}


	@Override
	public String updateProfile(UserDto userDto, Principal principal) {
		
		String status=InventoryConstant.FAILURE;
		
		logger.info("<--UserManagementServiceImpl-------------updateProfile--------------------started-->");
		try {
			
			if(userDto != null)
			{
				User user = new User();
				
				if(userDto.getId() != null)
				{
					user = userRepository.findOne(userDto.getId());
					
					if(user != null)
					{
						Employee employee=user.getEmployee();
						employee.setMailId(userDto.getEmailId());
						employee.setMobileNumber(Long.valueOf(userDto.getMobileNumber()));
						user.setSecretQuestion(userDto.getSecretQuestion());
						user.setSecretAnswer(userDto.getSecretAnswer());
						user.setEmployee(employee);
					}
				}
				user = userRepository.saveAndFlush(user);
				if(user != null)
				{
					status = InventoryConstant.SUCCESS;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
		logger.info("<--UserManagementServiceImpl-------------updateProfile--------------------started-->");
		
		return status;
	}

	@Override
	public List<WareHouseDto> getCurrentUserWareHouseDtoList(Principal principal)
	{
		List<WareHouseDto> wareHouseDtoList=null;
		List<WareHouse> wareHouseEntityList=null;
		if(principal.getName()!=null)
		{
			User user = userRepository.findByUserName(principal.getName());
			if (user.getWareHouseItem() != null) {
				wareHouseEntityList = user.getWareHouseItem();
				if (wareHouseEntityList != null) {
					wareHouseDtoList = new ArrayList<>();
					for (int k = 0; k < wareHouseEntityList.size(); k++) {
						WareHouse wareHouse = user.getWareHouseItem().get(k);
						if (wareHouse != null) {
							WareHouseDto wareHouseDto = new WareHouseDto();
							wareHouseDto.setWareHouseName(wareHouse.getWareHouseName());
							wareHouseDtoList.add(wareHouseDto);
						}
					}
				}
			}
		}
		/*console.log(JSON.stringify(wareHouseDtoList));*/
		return wareHouseDtoList;
	}


	@Override
	public List<DesignationDto> getDesignation() {
		List<DesignationDto> designationDtoList=new ArrayList<>();
		try {
			logger.info("<--UserManagementServiceImpl-------------getDesignation--------------------started-->");
			List<Designation> designationEntityList=DesignationRepository.findAll();
			for(int i=0;i<designationEntityList.size();i++)
			{
				Designation designation=designationEntityList.get(i);
				if(designation!=null)
				{
					DesignationDto designationDto=new DesignationDto();
					designationDto.setDesignation(designation.getDesignation());
					designationDto.setId(designation.getId());
					designationDto.setStatus(designation.getStatus());
					designationDtoList.add(designationDto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getDesignation--------------------Ended-->");
		return designationDtoList;
	}
	

	@Override
	public String getEmpIdSequence() {
		logger.info("GetemployeeSequence-------started");
		String empid = "";
		try {
			BigInteger empidvalue = userRepository.getEmpSequence();
			if (empidvalue != null)
				empid = String.valueOf(empidvalue);
			else
				logger.info("Code Generation Failed");
		} catch (PersistenceException pe) {
			logger.error("Employee------getEmployeeSequence-------Exception" + pe);
			logger.info("Code Generation Failed");
		}

		logger.info("GetemployeeSequence-------Ended");
		return empid;
	}
	
	@Override
	public String getEmpOffRollIdSequence() {
		logger.info("getEmpOffRollIdSequence-------started");
		String empid = "";
		try {
			BigInteger empidvalue = userRepository.getEmpOffRollSequence();
			if (empidvalue != null)
				empid = String.valueOf(empidvalue);
			else
				logger.info("Code Generation Failed");
		} catch (PersistenceException pe) {
			logger.error("Employee------getEmployeeSequence-------Exception" + pe);
			logger.info("Code Generation Failed");
		}

		logger.info("GetemployeeSequence-------Ended");
		return empid;
	}


	@Override
	public String saveNewEmployee(EmployeeDto employeeDto) throws Exception {
		logger.info("<--UserManagementServiceImpl-------------saveNewEmployee--------------------started-->");
		String status=InventoryConstant.FAILURE;
		Employee employee=new Employee();
		
		List<IdProofMaster> idProofMasterEntityList=new ArrayList<>();
		if(employeeDto.getEmployeeId()!=null) {
			employee=employeeRepository.findByEmployeeId(employeeDto.getEmployeeId());
            if(employee!=null)
            {
            	throw new Exception(InventoryConstant.THIS_EMPLOYEEID_ALREADY_EXIST);
            }
		}
			
            else{
			employee=new Employee();
			employee.setAlternateMailId(employeeDto.getAlternateEmailId());
			employee.setAlternateMobileNumber(employeeDto.getAlternateMobileNumber());
			employee.setBloodGroup(employeeDto.getBloodGroup());
			if(employeeDto.getConfirmationDate()!=null)
			{
				employee.setConfirmationDate(MasterDateUtil.convertStringToDateWithoutTime(employeeDto.getConfirmationDate()));
			}
			employee.setDateOfBirth(MasterDateUtil.convertStringToDateWithoutTime(employeeDto.getDateOfBirth()));
			employee.setDateOfJoin(MasterDateUtil.convertStringToDateWithoutTime(employeeDto.getDateOfJoin()));
			employee.setDesignation(employeeDto.getDesignation());
			employee.setDepartment(employeeDto.getDepartment());
//			employee.setEmployeeId(employeeDto.getEmployeeId());
			if(employeeDto.getEmployeeType().equalsIgnoreCase(InventoryConstant.ONR0LL))
			{
			employee.setEmployeeId(InventoryConstant.EMP_ID_PREFIX + getEmpIdSequence());
			}
			if(employeeDto.getEmployeeType().equalsIgnoreCase(InventoryConstant.OFFROLL))
			{
				employee.setEmployeeId(InventoryConstant.EMP_OFFROLL_ID_PREFIX + getEmpOffRollIdSequence());
				}
			employee.setEmployeeType(employeeDto.getEmployeeType());
			employee.setFirstName(employeeDto.getFirstName());
			employee.setGender(employeeDto.getGender());
			if(employeeDto.getGuardianName()!=null && employeeDto.getGuardianName().equalsIgnoreCase(InventoryConstant.HUSBAND))
			{
				employee.setHusbandName(employeeDto.getHusbandName());
			}
			else if(employeeDto.getGuardianName()!=null && employeeDto.getGuardianName().equalsIgnoreCase(InventoryConstant.FATHER))
			{
				employee.setFatherName(employeeDto.getFatherName());
			}
			employee.setGuardianName(employeeDto.getGuardianName());
			employee.setReligion(employeeDto.getReligion());
			employee.setLastName(employeeDto.getLastName());
			employee.setMailId(employeeDto.getEmailId());
			employee.setCompanyEmailId(employeeDto.getCompanyEmailId());
			employee.setMaritalStatus(employeeDto.getMaritalStatus());
			employee.setMobileNumber(employeeDto.getMobileNumber());
			employee.setNationality(employeeDto.getNationality());
			employee.setPanCardNumber(employeeDto.getPanCardNumber());
            employee.setPhoneStateCode(employeeDto.getPhoneStateCode());
            employee.setProof(employeeDto.getProof());
            employee.setProofNumber(employeeDto.getProofNumber());
            employee.setStatus(InventoryConstant.ACTIVE);
            employee.setSubStatus(employeeDto.getSubStatus());
            employee.setTaddress1(employeeDto.getTaddress1());
            employee.setTaddress2(employeeDto.getTaddress2());
            employee.setTaddress3(employeeDto.getTaddress3());
            employee.setTaddress4(employeeDto.getTaddress4());
            employee.setPaddress1(employeeDto.getPaddress1());
			employee.setPaddress2(employeeDto.getPaddress2());
			employee.setPaddress3(employeeDto.getPaddress3());
			employee.setPaddress4(employeeDto.getPaddress4());
			employee.setTcity(employeeDto.getTcity());
			employee.setTstate(employeeDto.getTstate());
			employee.setTpinCode(employeeDto.getTpinCode());
			employee.setPstate(employeeDto.getPstate());
			employee.setPcity(employeeDto.getPcity());
			employee.setPpinCode(employeeDto.getPpinCode());
			employee.setAadhaarNumber(employeeDto.getAadhaarNumber());
			employee.setVoterIdNumber(employeeDto.getVoterIdNumber());
			employee.setDrivingLicenseNumber(employeeDto.getDrivingLicenseNumber());
			employee.setPassportNumber(employeeDto.getPassportNumber());
			employee.setAadhaarNumber(employeeDto.getAadhaarNumber());
			employee.setVoterIdNumber(employeeDto.getVoterIdNumber());
			employee.setDrivingLicenseNumber(employeeDto.getDrivingLicenseNumber());
			if(employeeDto.getIsAddressSame()!=null && employeeDto.getIsAddressSame())
			{
				employee.setIsAddressSame(InventoryConstant.TRUE);
			}
			
			if(employeeDto.getIdProofMasterDtoList()!=null &&  !employeeDto.getIdProofMasterDtoList().isEmpty())
			{
				for(int i=0;i<employeeDto.getIdProofMasterDtoList().size();i++)
				{
					IdProofMasterDto idProofMasterDto=employeeDto.getIdProofMasterDtoList().get(i);
					if(idProofMasterDto!=null)
					{
						IdProofMaster idProofMaster=idProofMasterRepository.findOne(idProofMasterDto.getId());
						if(idProofMaster!=null)
						{
							
							if(idProofMasterDto.getName().equals(InventoryConstant.AADHAR_CARD) && idProofMasterDto.getSelected())
							{
								employee.setAadhaarNumber(idProofMasterDto.getNumber());
							}
							else if(idProofMasterDto.getName().equals(InventoryConstant.DRIVING_LICENSE) && idProofMasterDto.getSelected())
							{
								employee.setDrivingLicenseNumber(idProofMasterDto.getNumber());
							}
							else if(idProofMasterDto.getName().equals(InventoryConstant.VOTER_ID) && idProofMasterDto.getSelected())
							{
								employee.setVoterIdNumber(idProofMasterDto.getNumber());
							}
							else if(idProofMasterDto.getName().equals(InventoryConstant.PASSPORT) && idProofMasterDto.getSelected())
							{
								employee.setPassportNumber(idProofMasterDto.getNumber());
							}
							idProofMasterEntityList.add(idProofMaster);
						}
					}
				}
			}
			employee.setProofMasterList(idProofMasterEntityList);
            employee=employeeRepository.save(employee);
            if(employee!=null)
            {
            	status=InventoryConstant.SUCCESS;
            }
          }	
		logger.info("<--UserManagementServiceImpl-------------saveNewEmployee--------------------Ended-->");
		return status;
	}

	
	
	
	
	
	
	@Override
	public String editEmployee(EmployeeDto employeeDto) throws Exception {
		logger.info("<--UserManagementServiceImpl-------------editEmployee--------------------started-->");
		String status=InventoryConstant.FAILURE;
		
		
		Employee employee=new Employee();
		employee=employeeRepository.findOne(employeeDto.getId());
		if(employee!=null)
		{
			if(employee.getEmployeeId().equals(employeeDto.getEmployeeId()))
			{
			employee=mapEmployeeEntity(employee,employeeDto);
			employee.setId(employeeDto.getId());
            employee=employeeRepository.save(employee);
            if(employee!=null)
            {
            	status=InventoryConstant.SUCCESS;
            }
			}
			else{
				employee=employeeRepository.findByEmployeeId(employeeDto.getEmployeeId());
				if(employee!=null)
				{
					throw new Exception(InventoryConstant.THIS_EMPLOYEEID_ALREADY_EXIST);
				}
				else {
					employee=new Employee();
					employee=mapEmployeeEntity(employee,employeeDto);
					employee.setId(employeeDto.getId());
					employee=employeeRepository.save(employee);
					 if(employee!=null)
			            {
			            	status=InventoryConstant.SUCCESS;
			            }
				}
			}
		}
		logger.info("<--UserManagementServiceImpl-------------editEmployee--------------------Ended-->");
		return status;
	}
	
	
	public Employee mapEmployeeEntity(Employee employee,EmployeeDto employeeDto) throws Exception
	{
		logger.info("<--UserManagementServiceImpl-------------mapEmployeeEntity--------------------Started-->");
		
		List<IdProofMaster> idProofMasterEntityList=new ArrayList<>();
		
		employee.setAlternateMailId(employeeDto.getAlternateEmailId());
		employee.setAlternateMobileNumber(employeeDto.getAlternateMobileNumber());
		employee.setBloodGroup(employeeDto.getBloodGroup());
		employee.setConfirmationDate(MasterDateUtil.convertStringToDateWithoutTime(employeeDto.getConfirmationDate()));
		employee.setDateOfBirth(MasterDateUtil.convertStringToDateWithoutTime(employeeDto.getDateOfBirth()));
		employee.setDateOfJoin(MasterDateUtil.convertStringToDateWithoutTime(employeeDto.getDateOfJoin()));
		employee.setDesignation(employeeDto.getDesignation());
		employee.setDepartment(employeeDto.getDepartment());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setGender(employeeDto.getGender());
		if(employeeDto.getGuardianName()!=null && employeeDto.getGuardianName().equalsIgnoreCase(InventoryConstant.HUSBAND))
		{
			employee.setHusbandName(employeeDto.getHusbandName());
		}
		else if(employeeDto.getGuardianName()!=null && employeeDto.getGuardianName().equalsIgnoreCase(InventoryConstant.FATHER))
		{
			employee.setFatherName(employeeDto.getFatherName());
		}
		employee.setGuardianName(employeeDto.getGuardianName());
		employee.setReligion(employeeDto.getReligion());
		employee.setLastName(employeeDto.getLastName());
		employee.setMailId(employeeDto.getEmailId());
		employee.setCompanyEmailId(employeeDto.getCompanyEmailId());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setMobileNumber(employeeDto.getMobileNumber());
		employee.setNationality(employeeDto.getNationality());
		employee.setPanCardNumber(employeeDto.getPanCardNumber());
        employee.setPhoneStateCode(employeeDto.getPhoneStateCode());
        employee.setProof(employeeDto.getProof());
        employee.setProofNumber(employeeDto.getProofNumber());
        employee.setStatus(InventoryConstant.ACTIVE);
        employee.setEmployeeType(employeeDto.getEmployeeType());
        if(employeeDto.getSubStatus()!=null && employeeDto.getSubStatus().equalsIgnoreCase(InventoryConstant.RESIGNED))
        {
        	 employee.setSubStatus(employeeDto.getSubStatus());
        	 employee.setResignedDate(new Date());
        }
        else{
        	 employee.setSubStatus(employeeDto.getSubStatus());
        }
        employee.setTaddress1(employeeDto.getTaddress1());
        employee.setTaddress2(employeeDto.getTaddress2());
        employee.setTaddress3(employeeDto.getTaddress3());
        employee.setTaddress4(employeeDto.getTaddress4());
        employee.setPaddress1(employeeDto.getPaddress1());
		employee.setPaddress2(employeeDto.getPaddress2());
		employee.setPaddress3(employeeDto.getPaddress3());
		employee.setPaddress4(employeeDto.getPaddress4());
		employee.setTcity(employeeDto.getTcity());
		employee.setTstate(employeeDto.getTstate());
		employee.setTpinCode(employeeDto.getTpinCode());
		employee.setPstate(employeeDto.getPstate());
		employee.setPcity(employeeDto.getPcity());
		employee.setPpinCode(employeeDto.getPpinCode());
		
		employee.setAadhaarNumber(employeeDto.getAadhaarNumber());
		employee.setVoterIdNumber(employeeDto.getVoterIdNumber());
		employee.setDrivingLicenseNumber(employeeDto.getDrivingLicenseNumber());
		employee.setPassportNumber(employeeDto.getPassportNumber());
		if(employeeDto.getIsAddressSame()!=null && employeeDto.getIsAddressSame())
		{
			employee.setIsAddressSame(InventoryConstant.TRUE);
		}
		
		if(employeeDto.getIdProofMasterDtoList()!=null &&  !employeeDto.getIdProofMasterDtoList().isEmpty())
		{
			for(int i=0;i<employeeDto.getIdProofMasterDtoList().size();i++)
			{
				IdProofMasterDto idProofMasterDto=employeeDto.getIdProofMasterDtoList().get(i);
				if(idProofMasterDto!=null)
				{
					IdProofMaster idProofMaster=idProofMasterRepository.findOne(idProofMasterDto.getId());
					if(idProofMaster!=null)
					{
						
						if(idProofMasterDto.getName().equals(InventoryConstant.AADHAR_CARD) && idProofMasterDto.getSelected())
						{
							employee.setAadhaarNumber(idProofMasterDto.getNumber());
						}
						else if(idProofMasterDto.getName().equals(InventoryConstant.DRIVING_LICENSE) && idProofMasterDto.getSelected())
						{
							employee.setDrivingLicenseNumber(idProofMasterDto.getNumber());
						}
						else if(idProofMasterDto.getName().equals(InventoryConstant.VOTER_ID) && idProofMasterDto.getSelected())
						{
							employee.setVoterIdNumber(idProofMasterDto.getNumber());
						}
						else if(idProofMasterDto.getName().equals(InventoryConstant.PASSPORT) && idProofMasterDto.getSelected())
						{
							employee.setPassportNumber(idProofMasterDto.getNumber());
						}
						idProofMasterEntityList.add(idProofMaster);
					}
				}
			}
		}
		employee.setProofMasterList(idProofMasterEntityList);
		
		
		logger.info("<--UserManagementServiceImpl-------------mapEmployeeEntity--------------------Started-->");
		return employee;
	}
	
	
	

	@Override
	public List<EmployeeDto> getAllEmployee(Principal principal) {
		logger.info("<--UserManagementServiceImpl-------------getAllEmployee--------------------started-->");
		
		List<EmployeeDto> employeeDtosList=new ArrayList<>();
		List<IdProofMasterDto> selectedProofMasterDtoList=null;
		
		//List<IdProofMasterDto> idProofFinalMasterDtoList=null;
		
		
		
		
		List<Employee> employeesList=employeeRepository.findAll();
		try {
		if(employeesList!=null && !employeesList.isEmpty())
		{
			for (int i = 0; i < employeesList.size(); i++) {
			
				Employee employee=employeesList.get(i);
				if(employee!=null)
				{
				EmployeeDto employeeDto=new EmployeeDto();
				employeeDto.setId(employee.getId());
				employeeDto.setFullName(employee.getFirstName()+" "+ employee.getLastName());
				employeeDto.setDesignation(employee.getDesignation());
				employeeDto.setEmployeeId(employee.getEmployeeId());
				employeeDto.setMobileNumber(employee.getMobileNumber());
				employeeDto.setEmailId(employee.getMailId());
				employeeDto.setAlternateEmailId(employee.getAlternateMailId());
				employeeDto.setCompanyEmailId(employee.getCompanyEmailId());
				employeeDto.setAlternateMobileNumber(employee.getAlternateMobileNumber());
				employeeDto.setBloodGroup(employee.getBloodGroup());
				employeeDto.setConfirmationDate(MasterDateUtil.convertDateToString(employee.getConfirmationDate()));
				employeeDto.setDateOfBirth(MasterDateUtil.convertDateToString(employee.getDateOfBirth()));
				employeeDto.setDateOfJoin(MasterDateUtil.convertDateToString(employee.getDateOfJoin()));
				employeeDto.setDesignation(employee.getDesignation());
				employeeDto.setDepartment(employee.getDepartment());
				employeeDto.setEmployeeId(employee.getEmployeeId());
				employeeDto.setEmployeeType(employee.getEmployeeType());
				employeeDto.setFirstName(employee.getFirstName());
				employeeDto.setGender(employee.getGender());
				employeeDto.setGuardianName(employee.getGuardianName());
				employeeDto.setLastName(employee.getLastName());
				employeeDto.setMaritalStatus(employee.getMaritalStatus());
				employeeDto.setMobileNumber(employee.getMobileNumber());
				employeeDto.setNationality(employee.getNationality());
				employeeDto.setPanCardNumber(employee.getPanCardNumber());
				employeeDto.setPhoneStateCode(employee.getPhoneStateCode());
				//employeeDto.setProof(employee.getProof());
				//employeeDto.setProofNumber(employee.getProofNumber());
				employeeDto.setStatus(employee.getStatus());
				employeeDto.setSubStatus(employee.getSubStatus());
				employeeDto.setTaddress1(employee.getTaddress1());
				employeeDto.setTaddress2(employee.getTaddress2());
				employeeDto.setTaddress3(employee.getTaddress3());
				employeeDto.setTaddress4(employee.getTaddress4());
				employeeDto.setPaddress1(employee.getPaddress1());
				employeeDto.setPaddress2(employee.getPaddress2());
				employeeDto.setPaddress3(employee.getPaddress3());
				employeeDto.setPaddress4(employee.getPaddress4());
				employeeDto.setTcity(employee.getTcity());
				employeeDto.setTstate(employee.getTstate());
				employeeDto.setTpinCode(employee.getTpinCode());
				employeeDto.setPstate(employee.getPstate());
				employeeDto.setPcity(employee.getPcity());
				employeeDto.setPpinCode(employee.getPpinCode());
				employeeDto.setFatherName(employee.getFatherName());
				employeeDto.setHusbandName(employee.getHusbandName());
				employeeDto.setReligion(employee.getReligion());
				employeeDto.setAadhaarNumber(employee.getAadhaarNumber());
				employeeDto.setVoterIdNumber(employee.getVoterIdNumber());
				employeeDto.setDrivingLicenseNumber(employee.getDrivingLicenseNumber());
				employeeDto.setPassportNumber(employee.getPassportNumber());
				if(employee.getIsAddressSame()!=null && employee.getIsAddressSame().equals(InventoryConstant.TRUE))
				{
					employeeDto.setIsAddressSame(true);
				}
				if(employee.getProofMasterList()!=null &&  !employee.getProofMasterList().isEmpty())
				{
					selectedProofMasterDtoList=new ArrayList<>();
					for(int j=0;j<employee.getProofMasterList().size();j++)
					{
						IdProofMaster idProofMaster=employee.getProofMasterList().get(j);
						/*if(idProofMaster!=null)
						{
							IdProofMasterDto idProofMasterDto=new IdProofMasterDto();
							idProofMasterDto.setId(idProofMaster.getId());
							idProofMasterDto.setName(idProofMaster.getName());
							idProofMasterDto.setStatus(idProofMaster.getStatus());
							idProofMasterDto.setSelected(true);
							selectedProofMasterDtoList.add(idProofMasterDto);
						}*/
						
						if(idProofMaster!=null)
						{
							IdProofMasterDto idProofMasterDto=new IdProofMasterDto();
							if(idProofMaster.getName().equals(InventoryConstant.AADHAR_CARD))
							{
								//employee.setAadhaarNumber(employee.getAadhaarNumber());
								idProofMasterDto.setId(idProofMaster.getId());
								idProofMasterDto.setName(idProofMaster.getName());
								idProofMasterDto.setNumber(employee.getAadhaarNumber());
								idProofMasterDto.setSelected(true);
							}
							else if(idProofMaster.getName().equals(InventoryConstant.DRIVING_LICENSE))
							{
								//employee.setDrivingLicenseNumber(employee.getDrivingLicenseNumber());
								idProofMasterDto.setId(idProofMaster.getId());
								idProofMasterDto.setName(idProofMaster.getName());
								idProofMasterDto.setNumber(employee.getDrivingLicenseNumber());
								idProofMasterDto.setSelected(true);
							}
							else if(idProofMaster.getName().equals(InventoryConstant.VOTER_ID))
							{
								//employee.setVoterIdNumber(employee.getVoterIdNumber());
								idProofMasterDto.setId(idProofMaster.getId());
								idProofMasterDto.setName(idProofMaster.getName());
								idProofMasterDto.setNumber(employee.getVoterIdNumber());
								idProofMasterDto.setSelected(true);
							}
							else if(idProofMaster.getName().equals(InventoryConstant.PASSPORT))
							{
								//employee.setPassportNumber(employee.getPassportNumber());
								idProofMasterDto.setId(idProofMaster.getId());
								idProofMasterDto.setName(idProofMaster.getName());
								idProofMasterDto.setNumber(employee.getPassportNumber());
								idProofMasterDto.setSelected(true);
							}
							selectedProofMasterDtoList.add(idProofMasterDto);
						}
						
						
					}
					selectedProofMasterDtoList.addAll(mapEmployeeNotSelectedIdProofMaster(employee.getProofMasterList()));
				}
				
				employeeDto.setIdProofMasterDtoList(selectedProofMasterDtoList);
				employeeDtosList.add(employeeDto);
				}
				
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getAllEmployee--------------------ended-->");
		return employeeDtosList;
	}

	

	@Override
	public List<EmployeeDto> getAllAvaiableEmployee(Principal principal) {
		logger.info("<--UserManagementServiceImpl-------------getAllAvaiableEmployee--------------------started-->");
		
		List<EmployeeDto> employeeDtosList=new ArrayList<>();
		List<Employee> employeesList=employeeRepository.findAll();
		
		
		try {
		if(employeesList!=null && !employeesList.isEmpty())
		{
			for (int i = 0; i < employeesList.size(); i++) {
			
				Employee employee=employeesList.get(i);
				if(employee!=null)
				{
					EmployeeDto employeeDto=new EmployeeDto();
						
						User user = userRepository.findByEmpid(employee.getEmployeeId());
						
						if(user == null)
						{
							employeeDto.setId(employee.getId());
							employeeDto.setFullName(employee.getFirstName()+""+ employee.getLastName());
							employeeDto.setDesignation(employee.getDesignation());
							employeeDto.setEmployeeId(employee.getEmployeeId());
							employeeDto.setMobileNumber(employee.getMobileNumber());
							employeeDto.setEmailId(employee.getMailId());
							employeeDto.setAlternateEmailId(employee.getAlternateMailId());
							employeeDto.setCompanyEmailId(employee.getCompanyEmailId());
							employeeDto.setAlternateMobileNumber(employee.getAlternateMobileNumber());
							employeeDto.setBloodGroup(employee.getBloodGroup());
							employeeDto.setConfirmationDate(MasterDateUtil.convertDateToString(employee.getConfirmationDate()));
							employeeDto.setDateOfBirth(MasterDateUtil.convertDateToString(employee.getDateOfBirth()));
							employeeDto.setDateOfJoin(MasterDateUtil.convertDateToString(employee.getDateOfJoin()));
							employeeDto.setDesignation(employee.getDesignation());
							employeeDto.setDepartment(employee.getDepartment());
							employeeDto.setEmployeeId(employee.getEmployeeId());
							employeeDto.setEmployeeType(employee.getEmployeeType());
							employeeDto.setFirstName(employee.getFirstName());
							employeeDto.setGender(employee.getGender());
							employeeDto.setGuardianName(employee.getGuardianName());
							employeeDto.setLastName(employee.getLastName());
							employeeDto.setMaritalStatus(employee.getMaritalStatus());
							employeeDto.setMobileNumber(employee.getMobileNumber());
							employeeDto.setNationality(employee.getNationality());
							employeeDto.setPanCardNumber(employee.getPanCardNumber());
							employeeDto.setPhoneStateCode(employee.getPhoneStateCode());
							employeeDto.setProof(employee.getProof());
							employeeDto.setProofNumber(employee.getProofNumber());
							employeeDto.setStatus(employee.getStatus());
							employeeDto.setSubStatus(employee.getSubStatus());
							employeeDto.setTaddress1(employee.getTaddress1());
							employeeDto.setTaddress2(employee.getTaddress2());
							employeeDto.setTaddress3(employee.getTaddress3());
							employeeDto.setTaddress4(employee.getTaddress4());
							employeeDto.setPaddress1(employee.getPaddress1());
							employeeDto.setPaddress2(employee.getPaddress2());
							employeeDto.setPaddress3(employee.getPaddress3());
							employeeDto.setPaddress4(employee.getPaddress4());
							employeeDto.setTcity(employee.getTcity());
							employeeDto.setTstate(employee.getTstate());
							employeeDto.setTpinCode(employee.getTpinCode());
							employeeDto.setPstate(employee.getPstate());
							employeeDto.setPcity(employee.getPcity());
							employeeDto.setPpinCode(employee.getPpinCode());
							employeeDtosList.add(employeeDto);
						}
				}
				
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getAllAvaiableEmployee--------------------ended-->");
		return employeeDtosList;
	}
	

	@Override
	public List<DepartmentDto> getAllDepartment(Principal principal) {
		logger.info("<--UserManagementServiceImpl-------------getAllDepartment--------------------started-->");
		List<DepartmentDto> departmentDtoList=new ArrayList<>();
		List<Department> departmentList=departmentRepository.findAll();
		
		if(departmentList!=null && !departmentList.isEmpty())
		{
			for (int i = 0; i < departmentList.size(); i++) {
			
				Department department=departmentList.get(i);
				if(department!=null)
				{
				DepartmentDto departmentDto=new DepartmentDto();
				departmentDto.setId(department.getId());
				departmentDto.setName(department.getName());
				departmentDto.setStatus(department.getStatus());
				departmentDtoList.add(departmentDto);
				}
				
			}
		logger.info("<--UserManagementServiceImpl-------------getAllDepartment--------------------Ended-->");
	}
		return departmentDtoList;
	}


	@Override
	public List<IdProofMasterDto> getAllIdProofList(Principal principal) {
		logger.info("<--UserManagementServiceImpl-------------getAllIdProofList--------------------started-->");
		List<IdProofMasterDto> idProofMasterDtosList=new ArrayList<>();
		try {
			List<IdProofMaster> idProofMastersList=idProofMasterRepository.findAll();
			if(idProofMastersList!=null && !idProofMastersList.isEmpty())
			{
				for (int i = 0; i < idProofMastersList.size(); i++) {
				
					IdProofMaster idProofMaster=idProofMastersList.get(i);
					if(idProofMaster!=null)
					{
						IdProofMasterDto idProofMasterDto=new IdProofMasterDto();
						idProofMasterDto.setId(idProofMaster.getId());
						idProofMasterDto.setName(idProofMaster.getName());
						idProofMasterDto.setStatus(idProofMaster.getStatus());
						idProofMasterDtosList.add(idProofMasterDto);
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getAllIdProofList--------------------Ended-->");
		return idProofMasterDtosList;
	}
	

	public User newUser(UserDto userDto) throws Exception
	{
		logger.info("<--UserManagementServiceImpl-------------newUser--------------------started-->");
		List<Project> projectEntityList=new ArrayList<>();
		List<WareHouse> wareHouseEntityList=new ArrayList<>();
		Set<Role> roleSet=new HashSet<>();
		Md5PasswordEncoder encrpt=new Md5PasswordEncoder();
		User user=new User();
		user=userRepository.findByUserName(userDto.getUserName());
		if(user!=null && user.getUserName().equals(userDto.getUserName()))
		{
			throw new Exception(InventoryConstant.THIS_USERNAME_ALREADY_EXIST);
		}
		user=new User();
		user=userRepository.findByEmpid(userDto.getEmpid());
		if(user!=null && user.getEmpid().equals(userDto.getEmpid()))
		{
			throw new Exception(InventoryConstant.THIS_EMPLOYEEID_ALREADY_EXIST);
		}
		user=new User();
		user.setEmpid(userDto.getEmpid());
		user.setUserName(userDto.getUserName());
		user.setPassword(encrpt.encodePassword(userDto.getPassword(),InventoryConstant.ENCRYPTION_KEY));
		user.setRoleType(userDto.getRoleType());
		user.setName(userDto.getName());
		user.setCreatedBy(userDto.getUserName());
		user.setFirstLogin(InventoryConstant.TRUE);
		user.setLastModifiedBy(userDto.getUserName());
		user.setLastModifiedDate(new Timestamp(new Date().getTime()));
		user.setUserType(userDto.getUserName());
		user.setCreationDate(new Date());
		user.setCreatedBy(userDto.getUserName());
		user.setUserId(InventoryConstant.US+getUserSequence());
		user.setTheme(InventoryConstant.THEME_DEFAULT);
		user.setConfirmPassword(encrpt.encodePassword(userDto.getConfirmPassword(),InventoryConstant.ENCRYPTION_KEY));
		Employee employee=employeeRepository.findByEmployeeId(userDto.getEmpid());
		if(employee!=null)
		{
			user.setEmployee(employee);
			//employee.setUser(user);
			//employeeRepository.save(employee);
		}
		if(userDto.getRoleType().equals(InventoryConstant.OTHERS))
		{
		if(userDto.getProjectItemDtoList()!=null)
		{
			for(int i=0;i<userDto.getProjectItemDtoList().size();i++)
			{
				ProjectDto projectDto=userDto.getProjectItemDtoList().get(i);
				if(projectDto!=null)
				{
					Project project=projectRepository.findByName(projectDto.getName());
					if(project!=null)
					{
						if(projectDto.getSelected() != null && projectDto.getSelected())
						{
							projectEntityList.add(project);	
						}
					}
				}
				
			}
			user.setProjectItem(projectEntityList);
		}
		if(userDto.getRoleSet()!=null && !userDto.getRoleSet().isEmpty())
		{
			user.setRoles(MapRoles(user,userDto.getRoleSet()));
		}
		}
		if(userDto.getRoleType().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR))
		{
		if(userDto.getWareHouseDtoList()!=null)
		{
			for(int i=0;i<userDto.getWareHouseDtoList().size();i++)
			{
				WareHouseDto wareHouseDto=userDto.getWareHouseDtoList().get(i);
				if(wareHouseDto!=null)
				{
					WareHouse wareHouse=wareHouseRepository.findByWareHouseName(wareHouseDto.getWareHouseName());
					if(wareHouse!=null)
					{
						if(wareHouseDto.getSelected()!=null && wareHouseDto.getSelected())
						{
							wareHouseEntityList.add(wareHouse);	
						}
						
					}
				}
			}
			user.setWareHouseItem(wareHouseEntityList);
		}
		Role role=roleRepository.findByRoleName(userDto.getRoleType());
		if(role!=null)
		{
			roleSet.add(role);
			user.setRoles(roleSet);
		}
		}
		if(userDto.getRoleType().equals(InventoryConstant.OFFICE_ADMINISTRATOR))
		{
			Role role=roleRepository.findByRoleName(userDto.getRoleType());
			if(role!=null)
			{
				roleSet.add(role);
				user.setRoles(roleSet);
			}
		}
		logger.info("<--UserManagementServiceImpl-------------newUser--------------------Ended-->");
		return user;
	}

	
	public User editUser(UserDto userDto) throws Exception
	{
		logger.info("<--UserManagementServiceImpl-------------editUser--------------------started-->");
		List<Project> projectEntityList=new ArrayList<>();
		List<WareHouse> wareHouseEntityList=new ArrayList<>();
		Md5PasswordEncoder encrpt=new Md5PasswordEncoder();
		Set<Role> roleSet=new HashSet<>();
		User user=new User();
		user=userRepository.findOne(userDto.getId());
		if(user!=null && user.getUserName().equals(userDto.getUserName()))
		{
			//throw new Exception(InventoryConstant.THIS_USERNAME_ALREADY_EXIST);
		}
		else{
			user=userRepository.findByUserName(userDto.getUserName());
			if(user!=null)
			{
				throw new Exception(InventoryConstant.THIS_USERNAME_ALREADY_EXIST);
			}
		}
		
		user=new User();
		user=userRepository.findOne(userDto.getId());
		user.setUserName(userDto.getUserName());
		if(userDto.getResetPassword()!=null)
		{
			if(userDto.getResetPassword().equalsIgnoreCase(InventoryConstant.RESET))
			{
				user.setPassword(encrpt.encodePassword(userDto.getNewPassword(),InventoryConstant.ENCRYPTION_KEY));	
			}
		}
		
		user.setName(userDto.getName());
		user.setLastModifiedBy(userDto.getUserName());
		user.setLastModifiedDate(new Timestamp(new Date().getTime()));
		user.setCreationDate(new Date());
		user.setRoleType(userDto.getRoleType());
		user.setUserType(userDto.getUserName());
		user.setCreatedBy(userDto.getUserName());
		if(userDto.getRoleType().equals(InventoryConstant.OTHERS))
		{
		if(userDto.getRoleSet()!=null && !userDto.getRoleSet().isEmpty())
		{
			user.setRoles(new HashSet<>());
			user.setRoles(MapRoles(user, userDto.getRoleSet()));
		}
		if(userDto.getProjectItemDtoList()!=null)
		{
			for(int i=0;i<userDto.getProjectItemDtoList().size();i++)
			{
				ProjectDto projectDto=userDto.getProjectItemDtoList().get(i);
				if(projectDto!=null)
				{
					Project project=projectRepository.findByName(projectDto.getName());
					if(project!=null)
					{
						if(projectDto.getSelected()!=null)
						{
							if(projectDto.getSelected())
							{
								projectEntityList.add(project);	
							}
						}
					}
				}
			}
			user.setProjectItem(projectEntityList);
		}
		
		if(user.getWareHouseItem()!=null && !user.getWareHouseItem().isEmpty())
		{
			List<WareHouse> wareHouseList=new ArrayList<WareHouse>();
			user.setWareHouseItem(wareHouseList);
		}
		}
		if(userDto.getRoleType().equals(InventoryConstant.WAREHOUSE_ADMINISTRATOR)){
			
		if(userDto.getWareHouseDtoList()!=null)
		{
			for(int i=0;i<userDto.getWareHouseDtoList().size();i++)
			{
				WareHouseDto wareHouseDto=userDto.getWareHouseDtoList().get(i);
				if(wareHouseDto!=null)
				{
					WareHouse  wareHouse=wareHouseRepository.findByWareHouseName(wareHouseDto.getWareHouseName());
					if(wareHouse!=null)
					{
						if(wareHouseDto.getSelected()!=null)
						{
							if(wareHouseDto.getSelected())
							{
								wareHouseEntityList.add(wareHouse);	
							}
						}
					}
				}
			}
			user.setWareHouseItem(wareHouseEntityList);
		}
		Role role=roleRepository.findByRoleName(userDto.getRoleType());
		if(role!=null)
		{
			roleSet.add(role);
			user.setRoles(roleSet);
		}
		
		if(user.getProjectItem()!=null && !user.getProjectItem().isEmpty())
		{
			List<Project> projectDtoList=new ArrayList<Project>();
			user.setProjectItem(projectDtoList);
		}
		}
		if(userDto.getRoleType().equals(InventoryConstant.OFFICE_ADMINISTRATOR))
		{
			Role role=roleRepository.findByRoleName(userDto.getRoleType());
			if(role!=null)
			{
				roleSet.add(role);
				user.setRoles(roleSet);
			}
			
			if(user.getWareHouseItem()!=null && !user.getWareHouseItem().isEmpty())
			{
				List<WareHouse> wareHouseList=new ArrayList<WareHouse>();
				user.setWareHouseItem(wareHouseList);
			}
			
			if(user.getProjectItem()!=null && !user.getProjectItem().isEmpty())
			{
				List<Project> projectDtoList=new ArrayList<Project>();
				user.setProjectItem(projectDtoList);
			}
			
		}

		logger.info("<--UserManagementServiceImpl-------------editUser--------------------Ended-->");
		return user;
		
	}


	@Override
	public List<EmployeeDto> getAllEmployeeId(Principal principal) {
		logger.info("<--UserManagementServiceImpl-------------getAllEmployeeId--------------------started-->");

		List<EmployeeDto> employeeDtosList=new ArrayList<>();
		List<Employee> employeesList=employeeRepository.findAll();
		try {
		if(employeesList!=null && !employeesList.isEmpty())
		{
			for (int i = 0; i < employeesList.size(); i++) {
				
				Employee employee=employeesList.get(i);
				if(employee!=null)
				{

					if(employee.getUser()==null)
					{
						EmployeeDto employeeDto=new EmployeeDto();
						employeeDto.setEmployeeId(employee.getEmployeeId());
						employeeDtosList.add(employeeDto);
					}
				}
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------getAllEmployeeId--------------------Ended-->");
		return employeeDtosList;
	}


	public List<IdProofMasterDto> mapEmployeeNotSelectedIdProofMaster(List<IdProofMaster> EmployeeselectedIdProofMasterEntityList)
	{
		   int count=0;
		   List<IdProofMasterDto> employeeNotSelectedIdProofMasterDtoList=new ArrayList<>();
		   try {
			   logger.info("<--UserManagementServiceImpl-------------mapEmployeeNotSelectedIdProofMaster--------------------Started-->");
			   List<IdProofMaster> idProofMasterEntityList=idProofMasterRepository.findAll();
				
				if(EmployeeselectedIdProofMasterEntityList!=null && !EmployeeselectedIdProofMasterEntityList.isEmpty())
				{
					
					for(int i=0;i<idProofMasterEntityList.size();i++)
					{
						IdProofMaster idProofOriginalMaster=idProofMasterEntityList.get(i);
						if(idProofOriginalMaster!=null)
						{
							for (int j = 0; j < EmployeeselectedIdProofMasterEntityList.size(); j++) {
								
								IdProofMaster EmployeeidProofMaster=EmployeeselectedIdProofMasterEntityList.get(j);
								if(EmployeeidProofMaster!=null)
								{
									if(EmployeeidProofMaster.getName().equals(idProofOriginalMaster.getName()))
									{
										count++;
									}
								}
								
							}
							if(count==0)
							{
								IdProofMasterDto idProofMasterDto=new IdProofMasterDto();
								idProofMasterDto.setId(idProofOriginalMaster.getId());
								idProofMasterDto.setName(idProofOriginalMaster.getName());
								idProofMasterDto.setStatus(idProofOriginalMaster.getStatus());
								idProofMasterDto.setSelected(false);
								employeeNotSelectedIdProofMasterDtoList.add(idProofMasterDto);
							}
							count=0;
						}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--UserManagementServiceImpl-------------mapEmployeeNotSelectedIdProofMaster--------------------Ended-->");
		return employeeNotSelectedIdProofMasterDtoList;
	}
	
	
}
