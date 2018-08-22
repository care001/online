/*
package com.line.onlineweb.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.line.onlineweb.dao.entity.LineUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

public class PowerInterceptor implements HandlerInterceptor {
	
	private static final String LOGIN_URL = "/login.html";
	private static final String NO_POWER= "/template/noPower";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		LineUser user = (LineUser) session.getAttribute("user");
		String url = request.getRequestURI();
		if (user == null&& url.contains("/user/")) {
			response.sendRedirect(getRedirectUrl(request.getContextPath(),LOGIN_URL));
			return false;
		}
		*/
/*String url = request.getRequestURI();
		url = url.substring(url.lastIndexOf("/")+1);
		if(!validatePower(session, url)){
			response.sendRedirect(getRedirectUrl(request.getContextPath(),NO_POWER));
			return false;
		}*//*

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
	private String getRedirectUrl(String contextPath, String showUrl){
		return String.format("%s%s",contextPath,showUrl);
	}

	private boolean validatePower(HttpSession session, String url){
		List<String> needPower = (List<String>) session.getAttribute("needPower");
		List<String> power = (List<String>) session.getAttribute("power");
		if(!needPower.contains(url)){
			return true;
		}else if(power.contains(url)){
			return true;
		}
		return false;
	}

}
*/
