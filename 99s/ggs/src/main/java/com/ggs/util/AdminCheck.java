package com.ggs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminCheck extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {		
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("UID");
		if(id==null||id.equals("admin")) {
			//로그인이 안된경우
			System.out.println("관리자 확인됨.");
			return true;
		}else {
			System.out.println("관리자가 아닙니다.");
			response.sendRedirect("/admin/fail.gg");
			return false;
		}
	}
	
	
}
