package com.ggs.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserManageController {

	@Autowired
	private UserManageService service;
	
	/*** ==========================================
	 * 회원관리
	 * ***/
	//회원 현황
	@RequestMapping("/memberSummary.gg")
	public String memberSummary(Model model) {
		//방문자수
		/*접속자수
		 * 로그인하면 로그인시간을 DB(로그인)테이블에 업데이트, 단, 최종 접속일이 같을 경우 PASS, 다를경우 UPDATE
		 */
		
		
		//금일 접속자수
		model.addAttribute("todayCnt", service.todayLogin());
		
		//가입자수
		model.addAttribute("totalCnt", service.totalCnt());
		
		//주간단위 접속자수
		model.addAttribute("weekly", service.weeklyLogin());
		return "/admin/memberSummary";
	}
	
	//회원목록 보기
	@RequestMapping("/memberList.gg")
	public String memberList(Model model) {
		model.addAttribute("memberList", service.getMembersList());
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
}
