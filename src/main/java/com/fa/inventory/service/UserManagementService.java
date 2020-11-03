package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import com.fa.inventory.dto.DepartmentDto;
import com.fa.inventory.dto.DesignationDto;
import com.fa.inventory.dto.EmployeeDto;
import com.fa.inventory.dto.IdProofMasterDto;
import com.fa.inventory.dto.RoleDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.dto.WareHouseDto;

public interface UserManagementService {
	
	List<UserDto> getUsersList();
	
	
	String saveUser(UserDto userDto) throws Exception;
	
	
	UserDto getUser(Long id);
	
	
	List<RoleDto> getRolesNames();
	
	//** Get Current User Profile Details ***//
	
	UserDto getProfileDetails(Principal principal);

	String updateProfile(UserDto userDto, Principal principal);
	
	List<WareHouseDto> getCurrentUserWareHouseDtoList(Principal principal);
	List<DesignationDto> getDesignation();


	String saveNewEmployee(EmployeeDto employeeDto) throws Exception;
	
	String editEmployee(EmployeeDto employeeDto) throws Exception;


	List<EmployeeDto> getAllEmployee(Principal principal);
	
	List<EmployeeDto> getAllAvaiableEmployee(Principal principal);


	List<DepartmentDto> getAllDepartment(Principal principal);
	
	
	List<IdProofMasterDto> getAllIdProofList(Principal principal);
	
	
	List<EmployeeDto> getAllEmployeeId(Principal principal);


	String getEmpIdSequence();


	String getEmpOffRollIdSequence();
	
	

}
