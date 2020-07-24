package com.ggs.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DTO.MemberStaticDTO;
import com.ggs.DTO.MembersDTO;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/admin")
public class UserManageController {

	@Autowired
	private UserManageService userManageService;
	
	/*** ==========================================
	 * 회원관리
	 * ***/

	//회원 현황
	@RequestMapping("/memberSummary.gg")
	public String memberSummary(Model model) {
		
		//접속,가입자수 통계 자료 가져오기		
		model.addAttribute("dto", userManageService.memberSummary());
		
		// 주간단위 접속자수
		model.addAttribute("weekly", userManageService.weeklyLogin());
		
		// 주간단위 가입자수
		model.addAttribute("weeklyjoin", userManageService.weeklyJoin());
		
		return "/admin/memberSummary";
	}

	// 회원목록 보기
	@RequestMapping("/memberList.gg")
	public String memberList(Model model, @RequestParam(value="pageNo", defaultValue="1") String pageNo) {
		List list = userManageService.getMembersList(pageNo);
		System.out.println(list);
		model.addAttribute("pageInfo", 
				new PageUtil(Integer.parseInt(pageNo), ((MembersDTO)list.get(0)).getTotalcnt(), 10, 10));
		model.addAttribute("memberList", list);
		return "/admin/memberList";
	}

	// 회원 권한 수정하기
	@RequestMapping("/memberUpdate.gg")
	public String memberUpdate(MembersDTO dto, @RequestParam(value="pageNo", defaultValue="1") String pageNo) {
		
		System.out.println("UserManageController.memberUpdate");
		System.out.println(dto);
		System.out.println(pageNo);
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
