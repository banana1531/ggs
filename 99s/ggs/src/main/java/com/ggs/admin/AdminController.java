package com.ggs.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	//관리자페이지 메인화면 가기
	@RequestMapping("/adminMain.gg")
	public String adminMain(Model model) {
		
		//최근 등록 게시물 가져오기
		model.addAttribute("boardlist", service.getBoardList());
		
		//신고접수건 목록 가져오기
		model.addAttribute("declist", service.getDeclList());
		
		
		return "/admin/adminMain";
	}
	
	
	/*** ==========================================
	 * 신고접수 현황
	 * ***/
	//접수 현황 보기
	@RequestMapping("/deSummary.gg")
	public String deSummary() {
		
		return "/admin/deSummary";
	}
	
	//미처리건 화면 보기
	@RequestMapping("/declList.gg")
	public String declList() {
		
		return "/admin/declList";
	}
	
	//미처리건 - 신고처리 화면보기
	@RequestMapping("/declDetail.gg")
	public String declDetail() {
		
		return "/admin/declDetail";
	}
	
	//미처리건 - 신고처리 하기
	@RequestMapping("/declUpdate.gg")
	public String declUpdate() {
		
		return "/admin/declUpdate";
	}
	
	//신고처리 완료 목록 보기
	@RequestMapping("/dondeclList.gg")
	public String dondeclList() {
		
		return "/admin/dondeclList";
	}
	
	//신고처리 완료 목록 검색하기
	@RequestMapping("/declSearch.gg")
	public String declSearch() {
		
		return "/admin/dondeclList";
	}
	
	
	/*** ==========================================
	 * 회원관리
	 * ***/
	//회원 현황
	@RequestMapping("/memberSummary.gg")
	public String memberSummary() {
		
		return "/admin/memberSummary";
	}
	
	//회원목록 보기
	@RequestMapping("/memberList.gg")
	public String memberList() {
		
		return "/admin/memberList";
	}
	
	//회원 권한 수정하기
	@RequestMapping("/memberUpdate.gg")
	public String memberUpdate() {
		
		return "/admin/memberList";
	}
	
	//회원 검색하기
	@RequestMapping("/memberSearch.gg")
	public String memberSearch() {
		
		return "/admin/memberList";
	}
	
	/*** ==========================================
	 * data관리
	 * ***/	
	
	//data관리 메인화면보기
	@RequestMapping("/dataMain.gg")
	public String dataMain() {
		
		return "/admin/dataMain";
	}
	
	
	//팀 상세 정보 수정
	@RequestMapping("/teamDetailUpdate.gg")
	public String teamDetailUpdate() {
		
		return "/admin/teamDetail";
	}
	
	//팀 상세 정보 수정
	@RequestMapping("/teamGameUpdate.gg")
	public String teamGameUpdate() {
		
		return "/admin/teamDetail";
	}
	
	
}
