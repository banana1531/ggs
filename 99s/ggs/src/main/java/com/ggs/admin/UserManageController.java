package com.ggs.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.MembersDTO;

@Controller
@RequestMapping("/admin")
public class UserManageController {

	@Autowired
	private UserManageService userManageService;
	
	/*** ==========================================
	 * 회원관리
	 * ***/
	
	//회원관리 메인 가기
	@RequestMapping("/memberMain.gg")
	public String memberMain() {
		return "/admin/memberMain";
	}
	
	//회원 현황
	@RequestMapping("/memberSummary.gg")
	public String memberSummary(Model model) {
		// 금일 접속자수
		model.addAttribute("todayCnt", userManageService.todayLogin());

		// 가입자수
		model.addAttribute("totalCnt", userManageService.totalCnt());

		// 주간단위 접속자수
		model.addAttribute("weekly", userManageService.weeklyLogin());
		return "/admin/memberSummary";
	}

	// 회원목록 보기
	@RequestMapping("/memberList.gg")
	public String memberList(Model model) {
		model.addAttribute("memberList", userManageService.getMembersList());
		return "/admin/memberList";
	}

	// 회원 권한 수정하기
	@RequestMapping("/memberUpdate.gg")
	public String memberUpdate(MembersDTO dto) {
		System.out.println("UserManageController.memberUpdate");
		userManageService.updateGrant(dto);
		return "redirect:/admin/memberList.gg";
	}

	// 회원 검색하기
	@RequestMapping("/memberSearch.gg")
	public String memberSearch(Model model, String search, String option) {
		model.addAttribute("memberList", userManageService.memberSearch(search, option));
		return "/admin/memberList";
	}
	
	//회원 정보 상세 보기
	@RequestMapping("/memberDetail.gg")
	public String memberDetail(Model model, String id) {
		System.out.println("memberDetail.id="+id);
		model.addAttribute("member", userManageService.getMemberDetail(id));
		return "/admin/memberDetail";
	}
}
