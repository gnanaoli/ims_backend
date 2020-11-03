package com.fa.inventory.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fa.inventory.dto.CityDto;
import com.fa.inventory.dto.MenuDto;
import com.fa.inventory.dto.PasswordDetailRequest;
import com.fa.inventory.dto.PasswordRulesDto;
import com.fa.inventory.dto.SecretQuestionsDto;
import com.fa.inventory.dto.StateDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.entity.User;

public interface AdminService {
	
	/**
	 * ForgotPasswordDetails check with secret Question and Answer in db and
	 * Change the password
	 */
	String SaveForgotPasswordDeatails(PasswordDetailRequest passwordDetailRequest) throws Exception;

	
	User getByUserName(String userName);

	List<MenuDto> getCurrentUserPages(Principal principal);

	List<CityDto> getAllCity();


	/**
	 * Get All Secret Question from DB
	 */
	List<SecretQuestionsDto> getAllSecretQuestions();


	/**
	 * Change Password
	 * @throws Exception 
	 */
	String changePassword(UserDto userDto,Principal principal) throws Exception;


	/**
	 * saveState
	 * @throws Exception 
	 */
	String saveState(StateDto stateDto, Principal principal) throws Exception;



	/**
	 * saveCity
	 * @throws Exception 
	 */
	String saveCity(CityDto cityDto, Principal principal) throws Exception;

	/**
	 * Get All Secret Question from DB
	 */
	PasswordRulesDto getPasswordRules(Principal principal);


	String saveUserTheme(UserDto userDto, Principal principal,HttpSession httpSession) throws Exception;


	String userActive(PasswordDetailRequest passwordDetailRequest) throws Exception;




	
}
