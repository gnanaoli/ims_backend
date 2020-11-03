package com.fa.inventory.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * This is an implementation class for AuthenticationFailureHandler. If
 * authentication fails, the configured AuthenticationFailureHandler will be
 * invoked.
 * 
 * @author Praveen Kumar
 *
 */
@Component
public class LoginAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String url = "";
		if (exception instanceof BadCredentialsException) {
			url = "/login?error=" + exception.getMessage();
		} else {
			url = "/login?error=" + exception.getMessage();
		}
		setDefaultFailureUrl(url);
		setRedirectStrategy(redirectStrategy);
		setUseForward(true);
		super.onAuthenticationFailure(request, response, exception);
	}

}
