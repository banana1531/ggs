package com.ggs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheck extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {		
		
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("UID");
		if(id==null || id.length()==0) {
			//로그인이 안된경우
			System.out.println("로그인 체크 : 로그인 안됨");
			response.sendRedirect("../member/loginFrm.gg");
			return false;
		}else {
			//로그인이 된경우
			System.out.println("로그인 체크 : 로그인 됨");
			return true;
		}
		
	}

	
}
