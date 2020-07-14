package com.ggs.member;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ggs.DTO.MembersDTO;
import com.ggs.member.Memberservice;


@Controller
@RequestMapping("/member")
public class LoginController {
	
	@Autowired
	Memberservice mService;
	
	//로그인 폼 보여주기 
	@RequestMapping("/loginFrm.gg")	
	public String loginFrm(){
		System.out.println("요청 함수 loginFrm()!"); 
		return "member/loginFrm";
	}
	
	//로그인 처리 
	@RequestMapping("loginProc")	
	public ModelAndView loginProc(MembersDTO mdto,HttpSession session,
								  ModelAndView mv){
		System.out.println("요청 함수 loginloginProc()!"); 
		//1.파라미터 받기
		String id=mdto.getId();
		String password=mdto.getPw();
		System.out.println("요청 함수 loginloginProc()id/pw= "+id+"/"+password); 
					
		//2.비즈니스로직 -> Service ->DAO ->DB
		MembersDTO dto = mService.loginProc(mdto,session);
		if (dto != null) { 
		//로그인 성공
			RedirectView rv=new RedirectView("../"); //main으로 이동하기로 변경예정
			mv.setView(rv);}
		else {
		//로그인 실패 
			mv.setViewName("member/loginFrm");
			mv.addObject("msg","fail");
		}
		return mv;
	}

}
