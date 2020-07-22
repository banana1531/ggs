package com.ggs.mypage;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("mypage")
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	//마이페이지 메인가기
	@RequestMapping("/mypageMain.gg")
	public String mypagemain(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("UID");
		String team = (String)session.getAttribute("UTEAM");
		//내가쓴글가져오기
		model.addAttribute("mylist", service.getMyArticle(id));
		
		//내가 참여한 승부예측 가져오기
		model.addAttribute("myprelist", service.getMyPreList(id));
		
		//내팀 최근 경기 일정 가져오기
		model.addAttribute("teamSchedule",service.getMyteamSchedule(team));
		
		return "myPage/mainMypage";
	}
		
}
