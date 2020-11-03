package com.fa.inventory.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.CityDto;
import com.fa.inventory.dto.MenuDto;
import com.fa.inventory.dto.PasswordDetailRequest;
import com.fa.inventory.dto.PasswordRulesDto;
import com.fa.inventory.dto.SecretQuestionsDto;
import com.fa.inventory.dto.StateDto;
import com.fa.inventory.dto.UserDto;
import com.fa.inventory.dto.UserSessionDto;
import com.fa.inventory.encryptdecrypt.FaSoftwareSolutinonEncryptionDecryption;
import com.fa.inventory.entity.City;
import com.fa.inventory.entity.Country;
import com.fa.inventory.entity.PasswordRules;
import com.fa.inventory.entity.SecretQuestionsEntity;
import com.fa.inventory.entity.State;
import com.fa.inventory.entity.User;
import com.fa.inventory.repository.CityRepository;
import com.fa.inventory.repository.CountryRepository;
import com.fa.inventory.repository.PasswordRulesRepository;
import com.fa.inventory.repository.SecretQuestionsRepository;
import com.fa.inventory.repository.StateRepository;
import com.fa.inventory.repository.UserRepository;
import com.fa.inventory.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	HttpSession httpSession;

	@Resource
	UserRepository userRepository;

	@Resource
	SecretQuestionsRepository secretQuestionsRepository;

	@Resource
	CityRepository cityRepository;

	@Resource
	PasswordRulesRepository passwordRulesRepository;

	@Resource
	StateRepository stateRepository;

	@Resource
	CountryRepository countryRepository;

	FaSoftwareSolutinonEncryptionDecryption fasencrypt = new FaSoftwareSolutinonEncryptionDecryption();

	@Override
	public User getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public String SaveForgotPasswordDeatails(PasswordDetailRequest passwordDetailRequest) throws Exception {

		String status = null;
		
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		
		User user = userRepository.findByUserName(passwordDetailRequest.getUserId());
		if (user != null) {

			
			if(user.getFirstLogin().equals(InventoryConstant.TRUE))
			{
				throw new Exception(InventoryConstant.USER_IN_ACTIVE);
			}
			else if(passwordDetailRequest.getSelectedQuestion() != null && passwordDetailRequest.getQuestionAnswer() != null && user.getFirstLogin().equals(InventoryConstant.FALSE))
			{
				if (!user.getSecretQuestion().equalsIgnoreCase(passwordDetailRequest.getSelectedQuestion())) {
					throw new Exception(InventoryConstant.SECRET_QUESTION_NOT_VALID);
				}
				if(!user.getSecretAnswer().equalsIgnoreCase(passwordDetailRequest.getQuestionAnswer())) {
					throw new Exception(InventoryConstant.SECRET_ANSWER_NOT_VALID);
				}
					
					String encPass = md5PasswordEncoder.encodePassword(passwordDetailRequest.getNewPassword(), InventoryConstant.ENCRYPTION_KEY);
					
					user.setPassword(encPass);

					status = passwordValidation(passwordDetailRequest.getNewPassword());
					if (status.equals(InventoryConstant.SUCCESS)) {
						if (userRepository.saveAndFlush(user).getId() != null) {
							status = InventoryConstant.SUCCESS;
						}
					}
			}
			else if(user.getFirstLogin().equals(InventoryConstant.FALSE))
			{
				throw new Exception(InventoryConstant.ACTIVE);
			}
			else if (user.getSecretQuestion() != null && user.getSecretAnswer() != null && user.getFirstLogin().equals(InventoryConstant.FALSE)) {

				if (!user.getSecretQuestion().equalsIgnoreCase(passwordDetailRequest.getSelectedQuestion())) {
					throw new Exception(InventoryConstant.SECRET_QUESTION_NOT_VALID);
				}
				if(!user.getSecretAnswer().equalsIgnoreCase(passwordDetailRequest.getQuestionAnswer())) {
					throw new Exception(InventoryConstant.SECRET_ANSWER_NOT_VALID);
				}
					
					String encPass = md5PasswordEncoder.encodePassword(passwordDetailRequest.getNewPassword(), InventoryConstant.ENCRYPTION_KEY);
					
					user.setPassword(encPass);

					status = passwordValidation(passwordDetailRequest.getNewPassword());
					if (status.equals(InventoryConstant.SUCCESS)) {
						if (userRepository.saveAndFlush(user).getId() != null) {
							status = InventoryConstant.SUCCESS;
						}
					}
				} 
			} 
		else {
			throw new Exception(InventoryConstant.USER_NOT_VALID);
		}

		return status;
	}
	
	
	@Override
	public String userActive(PasswordDetailRequest passwordDetailRequest) throws Exception {

		String status = null;
		
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		
		User user = userRepository.findByUserName(passwordDetailRequest.getUserId());
		if (user != null) {

			
			if (user.getSecretQuestion() == null && user.getSecretAnswer() == null && user.getFirstLogin().equals(InventoryConstant.TRUE)) {
				
				status = passwordValidation(passwordDetailRequest.getNewPassword());
				if (status.equals(InventoryConstant.SUCCESS)) {
					
					String encPass = md5PasswordEncoder.encodePassword(passwordDetailRequest.getNewPassword(), InventoryConstant.ENCRYPTION_KEY);
					
					user.setPassword(encPass);
					user.setSecretQuestion(passwordDetailRequest.getSelectedQuestion());
					user.setSecretAnswer(passwordDetailRequest.getQuestionAnswer());
					user.setFirstLogin(InventoryConstant.FALSE);
					if (userRepository.saveAndFlush(user).getId() != null) {
						status = InventoryConstant.SUCCESS;
					}
				}
			}
		} else {
			throw new Exception(InventoryConstant.USER_NOT_VALID);
		}

		return status;
	}

	@Override
	public List<CityDto> getAllCity() {
		List<CityDto> cityDtoList = new ArrayList<>();
		try {
			logger.info("<--AdminServiceImpl-------------getAllCity--------------------started-->");

			List<City> cityEntityList = cityRepository.findAll();
			if (cityEntityList != null && !cityEntityList.isEmpty()) {
				for (int i = 0; i < cityEntityList.size(); i++) {
					City city = cityEntityList.get(i);
					if (city != null) {

						CityDto cityDto = new CityDto();
						cityDto.setCityName(city.getName());
						cityDto.setId(city.getId());
						cityDto.setCityCode(city.getCode());
						cityDto.setStatus(city.getStatus());

						StateDto stateDto = new StateDto();
						stateDto.setStateName(city.getState().getName());
						stateDto.setStateCode(city.getState().getCode());
						stateDto.setId(city.getState().getId());
						stateDto.setStatus(city.getState().getStatus());

						cityDto.setStateDto(stateDto);

						cityDtoList.add(cityDto);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--AdminServiceImpl-------------getAllCity--------------------Ended-->");
		return cityDtoList;
	}

	@Override
	public List<MenuDto> getCurrentUserPages(Principal principal) {
		List<MenuDto> menuItemDtoList = new ArrayList<>();
		try {
			logger.info("<--AdminServiceImpl-------------getCurrentUserPages--------------------started-->");
			List<String[]> MenuEntityList = userRepository.getCurrentPages(principal.getName(),
					InventoryConstant.ACTIVE);
			for (int i = 0; i < MenuEntityList.size(); i++) {
				Object[] menu = (Object[]) MenuEntityList.get(i);
				if (menu != null) {
					MenuDto menuDto = new MenuDto();

					menuDto.setPageName(menu[0].toString());
					menuDto.setMenuIcon(menu[1].toString());
					if (menu[2] != null && !menu[2].toString().isEmpty()) {
						menuDto.setMenuCategory(menu[2].toString());
					}
					menuDto.setMenuName(menu[3].toString());
					menuItemDtoList.add(menuDto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--AdminServiceImpl-------------getCurrentUserPages--------------------Ended-->");
		return menuItemDtoList;
	}

	@Override
	public List<SecretQuestionsDto> getAllSecretQuestions() {
		List<SecretQuestionsDto> secretQuestionsDtoList = null;
		logger.info("<--admin Service impl-------------getAllSecretQuestions--------------------started-->");
		try {
			List<SecretQuestionsEntity> secretQuestionsEntityList = secretQuestionsRepository.findAll();
			if (secretQuestionsEntityList != null && !secretQuestionsEntityList.isEmpty()) {
				secretQuestionsDtoList = new ArrayList<>();
				for (int i = 0; i < secretQuestionsEntityList.size(); i++) {
					SecretQuestionsEntity secretQuestionsEntity = secretQuestionsEntityList.get(i);

					if (secretQuestionsEntity != null) {
						SecretQuestionsDto secretQuestionsDto = new SecretQuestionsDto();
						secretQuestionsDto.setId(secretQuestionsEntity.getId());
						secretQuestionsDto.setSecretQuestion(secretQuestionsEntity.getSecretQuestion());
						secretQuestionsDto.setStatus(secretQuestionsEntity.getStatus());
						secretQuestionsDtoList.add(secretQuestionsDto);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--AdminServiceImpl-------------getAllSecretQuestions--------------------Ended-->");
		return secretQuestionsDtoList;
	}

	@Override
	public String changePassword(UserDto userDto, Principal principal) throws Exception {

		String status = InventoryConstant.FAILURE;
		logger.info("<--AdminServiceImpl-------------changePassword--------------------started-->");
		User user = new User();
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		if (userDto != null) {

			user = userRepository.findByUserName(principal.getName());

			if (user != null) {
				
				String encOldPass = md5PasswordEncoder.encodePassword(userDto.getOldPassword(), InventoryConstant.ENCRYPTION_KEY);
				
				if (user.getPassword().equals(encOldPass)) {

					status = passwordValidation(userDto.getConfirmPassword());
					if (status.equals(InventoryConstant.SUCCESS)) {
						
						String encPass = md5PasswordEncoder.encodePassword(userDto.getConfirmPassword(), InventoryConstant.ENCRYPTION_KEY);
						
						user.setPassword(encPass);
						user = userRepository.save(user);
						if (user != null) {
							status = InventoryConstant.SUCCESS;
						}
					}
				} else {
					throw new Exception(InventoryConstant.THE_OLD_PASSWORD_DOESNOT_MATCH);
				}
			}
		}

		logger.info("<--AdminServiceImpl-------------changePassword--------------------Ended-->");
		return status;
	}

	public String passwordValidation(String password) throws Exception {
		PasswordRules passwordRules = passwordRulesRepository.findOne(1l);
		if (passwordRules != null) {
			int lowerCaseCount = 0;
			int uppercaseCount = 0;
			int numberCount = 0;
			int specialCharCount = 0;

			String userPassword = password;

			for (char c : userPassword.toCharArray()) {
				if (Character.isUpperCase(c)) {
					uppercaseCount++;
				} else if (Character.isLowerCase(c)) {
					lowerCaseCount++;
				} else if (Character.isDigit(c)) {
					numberCount++;
				} else {
					specialCharCount++;
				}
			}

			if (userPassword.length() > passwordRules.getMinLengthForRegularPassword()) {
				// throw new Exception("The password must contain alteast
				// "+passwordRules.getMinLengthForRegularPassword()+"
				// characters");
				// throw new Exception("The Password Should Contain , \n " +
				// passwordRules.getMinLengthForRegularPassword() +
				// " Characters , \n" + passwordRules.getLowerCaseAlphabets() +
				// " Lowercase Characters , \n" +
				// passwordRules.getUpperCaseAlphabets() +
				// " Uppercase Characters , \n" + passwordRules.getNumerals() +
				// " Numeral Characters , \n" +
				// passwordRules.getSpeicalcharacters() + " Minimum Special
				// Character");

				throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);

			}
			if (lowerCaseCount == 0) {
				if (lowerCaseCount > passwordRules.getLowerCaseAlphabets()) {
					// throw new Exception("only
					// "+passwordRules.getLowerCaseAlphabets() +" lowercase
					// characters only allowed");
					throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
				}
				// throw new Exception("The password must contains alteast
				// "+passwordRules.getLowerCaseAlphabets()+" lower case
				// letters");
				throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
			}
			if (uppercaseCount == 0) {
				if (uppercaseCount > passwordRules.getUpperCaseAlphabets()) {
					// throw new Exception("only
					// "+passwordRules.getUpperCaseAlphabets()+" Uppercase
					// characters only allowed");
					throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
				}
				// throw new Exception("The password must contains alteast
				// "+passwordRules.getUpperCaseAlphabets()+" upper case
				// letters");
				throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
			}
			if (numberCount == 0) {
				if (numberCount > passwordRules.getNumerals()) {
					// throw new Exception("maximum
					// "+passwordRules.getNumerals()+" numerals only allowed");
					throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
				}
				// throw new Exception("The password must contains alteast
				// "+passwordRules.getNumerals()+" numbers");
				throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
			}
			if (specialCharCount == 0) {
				if (specialCharCount > passwordRules.getSpeicalcharacters()) {
					// throw new Exception("maximum
					// "+passwordRules.getSpeicalcharacters() +" special
					// characters only allowed");
					throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
				}
				// throw new Exception("The password must contains alteast
				// "+passwordRules.getSpeicalcharacters()+" special
				// Characters");
				throw new Exception(InventoryConstant.PASSWORD_NOT_VALID);
			}

		}
		return InventoryConstant.SUCCESS;
	}

	@Override
	public String saveState(StateDto stateDto, Principal principal) throws Exception {

		String status = null;

		State state = new State();

		Country country = new Country();

		if (stateDto != null && stateDto.getId() != null) {
			country = countryRepository.findByName(InventoryConstant.COUNTRY);

			state = stateRepository.findOne(stateDto.getId());

			if (state.getId() == stateDto.getId() && state.getCode() == stateDto.getStateCode()
					&& state.getName().equals(stateDto.getStateName())) {
				state.setId(stateDto.getId());
				state.setCreatedBy(state.getCreatedBy());
			} else {
				state.setCreatedBy(principal.getName());
			}

			state.setName(stateDto.getStateName());
			state.setCode(stateDto.getStateCode());
			state.setStatus(stateDto.getStatus());
			state.setLastModifiedBy(principal.getName());
			state.setLastModifiedDate(new Date());

			state.setCountry(country);

			state = stateRepository.save(state);

			if (state != null) {
				status = InventoryConstant.SUCCESS;
			}

		} else {
			country = countryRepository.findByName(InventoryConstant.COUNTRY);

			
			state = stateRepository.findByCode(stateDto.getStateCode());

			if (state != null) {
				throw new Exception(InventoryConstant.STATE_CODE_EXISTS);
			}
			
			state = stateRepository.findByName(stateDto.getStateName());

			if (state != null) {
				throw new Exception(InventoryConstant.STATE_ALREADY_EXISTS);
			}
			state = new State();

			state.setCreatedBy(principal.getName());
			state.setName(stateDto.getStateName());
			state.setCode(stateDto.getStateCode());
			state.setStatus(InventoryConstant.ACTIVE);
			state.setCreationDate(new Date());
			state.setLastModifiedBy(principal.getName());
			state.setLastModifiedDate(new Date());

			state.setCountry(country);

			state = stateRepository.save(state);

			if (state != null) {
				status = InventoryConstant.SUCCESS;
			}

		}

		return status;
	}

	@Override
	public String saveCity(CityDto cityDto, Principal principal) throws Exception {

		String status = null;

		State state = new State();

		City city = new City();

		if (cityDto != null && cityDto.getId() != null) {
			state = stateRepository.findByName(cityDto.getStateDto().getStateName());
			if(state != null)
			{
				city = cityRepository.findOne(cityDto.getId());
				
				if(city != null && city.getId().equals(cityDto.getId()))
				{
						if(city!=null && !city.getCode().equals(cityDto.getCityCode()))
						{
							city = cityRepository.findByCode(cityDto.getCityCode());
							
							if(city != null)
							{
								throw new Exception(InventoryConstant.CITY_CODE_EXISTS);
							}
						}
						if(city!=null && !city.getName().equals(cityDto.getCityName()))
						{
							city = cityRepository.findByName(cityDto.getCityName());
							
							if(city != null)
							{
								throw new Exception(InventoryConstant.CITY_ALREADY_EXISTS);
							}
						}
						
						city = cityRepository.findOne(cityDto.getId());
						
						city.setId(cityDto.getId());
						
						city.setState(state);

						city.setCode(cityDto.getCityCode());
						city.setName(cityDto.getCityName());
						city.setStateCode(cityDto.getCityCode());
						city.setLastModifiedBy(principal.getName());
						city.setLastModifiedDate(new Date());
						city.setStatus(cityDto.getStatus());

						city = cityRepository.save(city);

						if (city != null) {
							status = InventoryConstant.SUCCESS;
						}
				}
			}
			else
			{
				throw new Exception(InventoryConstant.STATE_DOESNOT_EXISTS);
			}
		} else {
			state = stateRepository.findByName(cityDto.getStateDto().getStateName());

			if (state != null) {
			
			
			city = cityRepository.findByCode(cityDto.getCityCode());

			if (city != null) {
				throw new Exception(InventoryConstant.CITY_CODE_EXISTS);
			}
			
			city = cityRepository.findByName(cityDto.getCityName());

			if (city != null) {
				throw new Exception(InventoryConstant.CITY_ALREADY_EXISTS);
			}

				city = new City();

				city.setState(state);

				city.setCode(cityDto.getCityCode());
				city.setName(cityDto.getCityName());
				city.setStateCode(cityDto.getCityCode());
				city.setCreatedBy(principal.getName());
				city.setCreationDate(new Date());
				city.setEffectiveEndDate(new Date());
				city.setEffectiveStartDate(new Date());
				city.setLastModifiedBy(principal.getName());
				city.setLastModifiedDate(new Date());
				city.setStatus(InventoryConstant.ACTIVE);

				city = cityRepository.save(city);

				if (city != null) {
					status = InventoryConstant.SUCCESS;
				}

			} else {
				throw new Exception(InventoryConstant.STATE_DOESNOT_EXISTS);
			}

		}

		return status;
	}

	@Override
	public PasswordRulesDto getPasswordRules(Principal principal) {

		logger.info("<--AdminServiceImpl-------------getPasswordRules--------------------started-->");
		PasswordRulesDto passwordRulesDto = new PasswordRulesDto();
		try {

			PasswordRules passwordRules = new PasswordRules();

			passwordRules = passwordRulesRepository.findOne(1L);

			if (passwordRules != null) {
				passwordRulesDto.setId(passwordRules.getId());
				passwordRulesDto.setExpiresAfterNDays(passwordRules.getExpiresAfterNDays());
				passwordRulesDto.setLockAfterNInactiveDays(passwordRules.getLockAfterNInactiveDays());
				passwordRulesDto.setLowerCaseAlphabets(passwordRules.getLowerCaseAlphabets());
				passwordRulesDto.setMaximumWrongAttempts(passwordRules.getMaximumWrongAttempts());
				passwordRulesDto.setMinLengthForRegularPassword(passwordRules.getMinLengthForRegularPassword());
				passwordRulesDto.setNumerals(passwordRules.getNumerals());
				passwordRulesDto.setPreventLastNPasswords(passwordRules.getPreventLastNPasswords());
				passwordRulesDto.setSpeicalcharacters(passwordRules.getSpeicalcharacters());
				passwordRulesDto.setUpperCaseAlphabets(passwordRules.getUpperCaseAlphabets());
				passwordRulesDto.setWarn_N_Days_Before_Expiry(passwordRules.getWarn_N_Days_Before_Expiry());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("<--AdminServiceImpl-------------getPasswordRules--------------------Ended-->");
		return passwordRulesDto;

	}

	@Override
	public String saveUserTheme(UserDto userDto, Principal principal, HttpSession httpSession) throws Exception {

		String status = null;
		logger.info("<--AdminServiceImpl-------------saveUserTheme--------------------started-->");
		try {

			if (userDto != null) {
				User user = userRepository.findByUserName(principal.getName());

				if (user != null) {
					user.setTheme(userDto.getTheme());

					user = userRepository.save(user);

					if (user != null) {
						status = InventoryConstant.SUCCESS;
						
						List<GrantedAuthority> authorities =user.getRoles().stream()
								.map(authority -> new SimpleGrantedAuthority(authority.getRoleName())).collect(Collectors.toList());
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUserName(),
								user.getPassword(), authorities);
						
						UserSessionDto usersessionDto=(UserSessionDto) SecurityContextHolder.getContext().getAuthentication().getDetails();
						usersessionDto.setTheme(userDto.getTheme());
						authentication.setDetails(usersessionDto);
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("<--AdminServiceImpl-------------saveUserTheme--------------------Ended-->");
		return status;
	}

}
