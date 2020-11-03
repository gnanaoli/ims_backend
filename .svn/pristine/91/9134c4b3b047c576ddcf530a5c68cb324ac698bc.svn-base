
package com.fa.inventory.config.security;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fa.inventory.constants.InventoryConstant;
import com.fa.inventory.dto.UserSessionDto;
import com.fa.inventory.encryptdecrypt.FaSoftwareSolutinonEncryptionDecryption;
import com.fa.inventory.entity.User;
import com.fa.inventory.service.AdminService;



@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

	public LoginAuthenticationProvider() {
		super();
	}

	
	protected final Logger logger = Logger.getLogger(getClass());

	//@Resource
	//BCryptPasswordEncoder encoder;

	@Resource
	AdminService adminService;
	
	FaSoftwareSolutinonEncryptionDecryption fasencryptdecrypt=new FaSoftwareSolutinonEncryptionDecryption();

	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		
		Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
		
		
		String username = (String) auth.getPrincipal();
		String password = (String) auth.getCredentials();
		String encPass = md5PasswordEncoder.encodePassword(password, InventoryConstant.ENCRYPTION_KEY);
		User user = adminService.getByUserName(username);
		
		System.out.println("Password"+ encPass); 
		if (user == null) 
		{
			logger.error(" LoginAuthenticationProvider -- authenticate -- UserNameNotFoundException " + username);
			throw new UsernameNotFoundException("User not found: " + username);
		}
		
		if (user.getEmployee() != null) 
		{
			if(user.getEmployee().getResignedDate()!=null)
			{
				logger.error(" LoginAuthenticationProvider -- authenticate -- ResignedUserNotAllowedException " + username);
				throw new UsernameNotFoundException("You are not an authenticated user");
			}
			
		}
		
		
		
		//String encryptPasswrod=fasencryptdecrypt.encryptionText(password, "FAS");
		if (!user.getUserName().equals(username)) 
		{
			logger.error(
					" LoginAuthenticationProvider -- authenticate -- Authentication Failed. Username or Password not valid. "
							+ username);
			throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
		}
		if (!user.getPassword().equals(encPass)) 
		{
			logger.error(
					" LoginAuthenticationProvider -- authenticate -- Authentication Failed. Username or Password not valid. "
							+ username);
			throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
		}
		
		if (user.getRoles() == null) 
		{
			logger.error(" LoginAuthenticationProvider -- authenticate -- User has no roles assigned" + username);
			throw new InsufficientAuthenticationException("User has no roles assigned");
		}
		List<GrantedAuthority> authorities =user.getRoles().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getRoleName())).collect(Collectors.toList());
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUserName(),
				encPass, authorities);
		
		UserSessionDto usersessionDto=new UserSessionDto();
		if(user.getEmployee()!=null)
		{
			usersessionDto.setFullName(user.getEmployee().getFirstName()+" "+user.getEmployee().getLastName());	
		}
		usersessionDto.setUserName(user.getUserName());
		usersessionDto.setUserType(user.getUserType());
		usersessionDto.setTheme(user.getTheme());
		usersessionDto.setLastLoginDateTime(user.getLastLoginDateTime());
		authentication.setDetails(usersessionDto);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return authentication;
	}
	
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

	

	
}
