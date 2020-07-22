package com.ggs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GrantVCheck extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {		
		HttpSession session= request.getSession();
		Integer boardV=(Integer)session.getAttribute("UBOARDV");
		if(boardV==null || boardV==0) {
			//조회 권한 없음.
			System.out.println("조회 권한 없음");
			response.sendRedirect("/member/loginFrm.gg");
			return false;
		}else {
			//로그인이 된경우
			System.out.println("조회 권한 확인됨.");
			return true;
		}
	}
}
