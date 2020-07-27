package com.ggs.mypage;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggs.team.TeamInfoService;

@Controller
@RequestMapping("mypage")
public class MyTeamDetailController {

	
	@Autowired
	private MyTeamDetailService myTeamDetailService;
	
	@Autowired
	private TeamInfoService teamInfoService;
	
	//-------------------------------------------
		//마이팀 상세정보 보기
		@RequestMapping("/myTeamDetail.gg")
		public String myTeamDetail(Model model, HttpServletRequest request) {
			HttpSession sess = request.getSession();
			String name = (String)sess.getAttribute("UTEAM");
			model.addAttribute("team", teamInfoService.teamDetail(name));
			return "myPage/myTeamDetail";
		}
		
		//상대팀 자료 가져오기 --> ajax로 구현
		@RequestMapping("/vsTeamDetail.gg")
		public void vsTeamDetail() {
			
			//파라미터
			//팀정보(이름)
			
			//비즈니스
			//비교 자료 가져오기
			
		}
		
}
