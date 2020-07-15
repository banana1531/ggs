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
	public ModelAndView Teamlist(ModelAndView mv) {
		System.out.println("TeamInfoController.Teamlist");
		// 1.파라미터받기

		// 2.비즈니스로직(->Service->DAO->db)
		mv.addObject("list", tService.getTeamList());
		
		// 4.View
		mv.setViewName("TeamInfo/teamlist");

		return mv;
	}
	
	
	//팀 상세 보기
	@RequestMapping("/teamDetail.gg")
	public String teamDetail(Model model, String name) {
		//팀 기본정보 가져오기
		model.addAttribute("detail", tService.teamDetail(name));
		//팀 경기 이력 가져오기
		//model.addAttribute("record", tService.teamRecord(name));
		return "";
	}
	
}
