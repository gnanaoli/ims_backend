/*package com.fa.inventory.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fa.inventory.dto.UserSessionDto;

public class ApplicationInterceptor extends HandlerInterceptorAdapter {
	
	private static final long MAX_INACTIVE_SESSION_TIME = 15000;
	
	protected final Logger logger = Logger.getLogger(UserInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		   UserSessionDto userSessionDto=(UserSessionDto) request.getSession().getAttribute("sessionContainer");
		   if(userSessionDto!=null)
		   {
			   Long timeDifference=System.currentTimeMillis()-userSessionDto.getSessionId().getLastAccessedTime();
				if(timeDifference>MAX_INACTIVE_SESSION_TIME)
				{
					SecurityContextHolder.clearContext();
			        request.logout();
			        userSessionDto.getSessionId().invalidate();
			        response.sendRedirect(request.getContextPath() + "/logout");
			        return false;
				}
				return true;
		   }
			
		return false;
	}
	
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}
	
	
	

}
*/