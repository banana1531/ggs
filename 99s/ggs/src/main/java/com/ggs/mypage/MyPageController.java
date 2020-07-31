package com.ggs.mypage;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggs.DTO.PreResultDTO;
import com.ggs.util.PageUtil;


@Controller
@RequestMapping("mypage")
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	//마이페이지 메인가기
	@RequestMapping("/mypageMain.gg")
	public String mypagemain(HttpServletRequest request, Model model,
			@RequestParam(value="result", defaultValue="1") int result) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("UID");
		String team = (String)session.getAttribute("UTEAM");
		//내가쓴글가져오기
		model.addAttribute("mylist", service.getMyArticle(id));
		System.out.println("result="+result);
		if(result==0||result>1) model.addAttribute("point", "오늘 처음 접속하셨습니다. 회원님에게 포인트 10p가 지급되었습니다.");
		
		//내가 참여한 승부예측 가져오기
		List list = service.getMyPreList(id);
		try{
			PreResultDTO dto = (PreResultDTO)list.get(0);
			model.addAttribute("totalcnt", dto.getTotalcnt());
			model.addAttribute("rate", dto.getRate());
		}catch (Exception e) {
			model.addAttribute("result", "참여하신 기록이 없습니다.");
		}
		
		model.addAttribute("myprelist", list);
		
		//내팀 최근 경기 일정 가져오기
		model.addAttribute("teamSchedule",service.getMyteamSchedule(team));
		
		return "myPage/mainMypage";
	}
	
	
	//승부예측 기록 목록 보기
	@RequestMapping("/myPreList.gg")
	public String myPreList(Model model, PreResultDTO preResultDTO,
			@RequestParam(value="pageNo", defaultValue="1") int pageNo) {
		
		List<PreResultDTO> list = service.getMyPreList(preResultDTO, pageNo);
		int totalcnt = 0;
		if(list.size()==0){
			model.addAttribute("result", "참여하신 승부예측 이력이 없습니다.");
		}else {
			totalcnt = list.get(0).getTotalcnt();
			model.addAttribute("totalcnt", totalcnt);
			model.addAttribute("rate", list.get(0).getRate());
		}
		PageUtil pageInfo = new PageUtil(pageNo, totalcnt, 10, 5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list", list);
		return "myPage/myPreList";
	}
		
}
