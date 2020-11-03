package com.fa.inventory.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/***
 * 
 *
 */
@Component
public class LoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	protected final Logger logger = Logger.getLogger(getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("Inside LoginAuthenticationSuccessHandler --Authentication Checking Started..");
		// UserContext userContext = (UserContext) authentication.getDetails();
		super.setAlwaysUseDefaultTargetUrl(true);
		super.setDefaultTargetUrl(determineTargetUrl(authentication));
		super.onAuthenticationSuccess(request, response, authentication);
		logger.info("Inside LoginAuthenticationSuccessHandler --Authentication Checking Ended..");
	}

	protected String determineTargetUrl(Authentication authentication) {
		
		return "/DashBoard";
	}

}
