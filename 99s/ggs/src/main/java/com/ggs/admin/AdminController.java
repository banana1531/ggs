package com.ggs.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.DeclarationDTO;
import com.ggs.DTO.BoardDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DecService decService;
	
	//관리자페이지 메인화면 가기
	@RequestMapping("/adminMain.gg")
	public String adminMain(Model model) {
		System.out.println("AdminController.adminMain()");
		model.addAttribute("boardlist", adminService.getBoardList());		//최근 등록 게시물 가져오기
		model.addAttribute("declist", decService.getDeclList());			//신고 접수 목록 가져오기
		return "/admin/adminMain";
	}
}
