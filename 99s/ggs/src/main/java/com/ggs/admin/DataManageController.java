package com.ggs.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.DTO.TeamRecordDTO;
import com.ggs.team.TeamInfoService;

@Controller
@RequestMapping("/admin")
public class DataManageController {
	
	@Autowired
	private AdminService service;	
	
	@Autowired
	private TeamInfoService teamInfoService;

	/*** ==========================================
	 * data관리
	 * ***/	
	
	//data관리 메인화면보기
	@RequestMapping("/dataMain.gg")
	public String dataMain() {
		return "/admin/dataMain";
	}
	
	//팀 기본정보 목록 가져오기
	@RequestMapping("/teamList")
	public String teamList(Model model) {
		
		model.addAttribute("list", teamInfoService.teamList());
				
		return "/admin/teamList";
	}
	
	//팀 상세 정보 수정폼 가기
	@RequestMapping("/teamDetail")
	public String teamDetail(Model model, String name) {
		//팀 상세 정보 가져오기
		model.addAttribute("team", teamInfoService.teamDetail(name));
		return "/admin/teamDetail";
	}
	
	//팀 경기 기록 페이징
	@RequestMapping("/teamRecordP")
	public String teamRecordP(String name, String pageNo, Model model) {
		List list = teamRecord(name, pageNo);
		model.addAttribute("list", list);
		model.addAttribute("totalpage", teamInfoService.totalpage(list));
		model.addAttribute("nowPage", pageNo);
		return "/admin/teamRecordList";
	}
	
	private List<TeamRecordDTO> teamRecord(String name, String pageNo) {
		return teamInfoService.teamRecord(name, pageNo);
	}
	
	//팀 상세 정보 수정
	@RequestMapping("/teamGameUpdate.gg")
	public String teamGameUpdate() {
		return "/admin/teamDetail";
	}
	
}
