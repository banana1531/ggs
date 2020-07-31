package com.ggs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GrantMCheck extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response, 
							 Object handler)
			throws Exception {		
		HttpSession session= request.getSession();
		Integer boardM=(Integer)session.getAttribute("UBOARDM");
		if(boardM==null || boardM==0) {
			//조회 권한 없음.
			System.out.println("조작 권한 없음");
			String uri = request.getRequestURI();
			uri=(uri.substring(1));
			uri=uri.substring(0, uri.indexOf("/"));
			uri="/"+uri+"/detail?"+request.getQueryString()+"&re=1";
			System.out.println(uri);
			response.sendRedirect(uri);
			return false;
		}else {
			//로그인이 된경우
			System.out.println("조작 권한 확인됨.");
			return true;
		}
	}
}
