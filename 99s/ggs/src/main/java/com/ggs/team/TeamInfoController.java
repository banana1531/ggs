package com.ggs.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/team")
public class TeamInfoController {

	@Autowired
	TeamInfoService tService;
	
	//팀목록 보기
	@RequestMapping("/teamlist.gg")
	public String Teamlist(Model model) {
		model.addAttribute("list", tService.getTeamList());
		return "TeamInfo/teamlist";
	}
	
	//팀 상세 보기
	@RequestMapping("/teamDetail.gg")
	public String teamDetail(Model model, String name) {
		//팀 기본정보 가져오기
		model.addAttribute("team", tService.teamDetail(name));
		return "TeamInfo/teamDetail";
	}
	
}
