/*package com.fa.inventory.config.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fa.inventory.dto.UserSessionDto;
import com.fa.inventory.entity.UserTest;
import com.fa.inventory.repository.UserTestRepository;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	HttpSession session;

	@Resource
	UserTestRepository userTestRepository;
	
	


	protected final Logger logger = Logger.getLogger(UserInterceptor.class);
	long requestStartTime;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (isUserLogged(request)) {
			return true;
		}
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public boolean isUserLogged(HttpServletRequest request) {
		try {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//UserTest userTest = userTestRepository.findByUserNameAndPassWord(username, password);
			UserTest userTest = new UserTest();
			if (userTest != null) {
				UserSessionDto userSessionDto=new UserSessionDto();
				session = request.getSession();
				userSessionDto.setRequestStartTime(System.currentTimeMillis());
				userSessionDto.setUserName(username);
				userSessionDto.setPassWord(password);
				userSessionDto.setSessionId(session);
				request.setAttribute("sessionContainer", userSessionDto);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
*/