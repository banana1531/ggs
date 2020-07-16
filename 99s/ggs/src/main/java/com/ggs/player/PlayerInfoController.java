package com.ggs.player;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.DAO.PlayerInfoDAO;
import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.PlayerRecordDTO;
import com.ggs.util.PageUtil;

@Controller
@RequestMapping("/player")
public class PlayerInfoController {

	@Autowired
	PlayerInfoDAO pDao;
	
	@Autowired
	PlayerInfoService pService;

	@RequestMapping("/list")
	public ModelAndView PlayerList(ModelAndView mv) {
		
		//타자랭킹 타율,홈런,타점 & 투수랭킹 평균자책점,탈삼진,피안타율
		ArrayList<PlayerRecordDTO> Ranking = pService.Ranking();
		ArrayList<PlayerRecordDTO> Ranking2 = pService.Ranking2();
		ArrayList<PlayerRecordDTO> Ranking3 = pService.Ranking3();
		ArrayList<PlayerRecordDTO> Ranking4 = pService.Ranking4();
		ArrayList<PlayerRecordDTO> Ranking5 = pService.Ranking5();
		ArrayList<PlayerRecordDTO> Ranking6 = pService.Ranking6();
		
		//3. Model
		mv.addObject("Ranking", Ranking);
		mv.addObject("Ranking2", Ranking2);
		mv.addObject("Ranking3", Ranking3);
		mv.addObject("Ranking4", Ranking4);
		mv.addObject("Ranking5", Ranking5);
		mv.addObject("Ranking6", Ranking6);
		
		//4. View
		mv.setViewName("PlayerInfo/list");
		
		return mv;
	}
	
	@RequestMapping("/info")
	public ModelAndView PlayerInfo(
			@RequestParam(value="pno") int pno,
			@RequestParam(value="position") String position,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		ArrayList<PlayerInfoDTO> common = pService.common(pno);
		
		mv.addObject("common",common);
		
		if(position.contains("투수")) {
			
			//투수의 경기기록 & 페이징
			PageUtil pInfo = pService.PlayerPage(nowPage, pno);
			ArrayList<PlayerRecordDTO> pitcher = pService.pitcher(pno, pInfo);
			
			//투수의 통산스텟
			ArrayList<PlayerRecordDTO> pitcher2 = pService.pitcher2(pno);

			mv.addObject("pitcher", pitcher);
			mv.addObject("PINFO", pInfo);
			mv.addObject("pno",pno);
			mv.addObject("position",position);
			mv.addObject("pitcher2",pitcher2);
			
			mv.setViewName("PlayerInfo/pitcher");
		}
		else {
			
			//타자의 경기기록 & 페이징
			PageUtil pInfo = pService.PlayerPage(nowPage, pno);
			ArrayList<PlayerRecordDTO> batter = pService.batter(pno, pInfo);
			
			//타자의 통산스텟
			ArrayList<PlayerRecordDTO> batter2 = pService.batter2(pno);
			
			mv.addObject("batter", batter);
			mv.addObject("PINFO", pInfo);
			mv.addObject("pno",pno);
			mv.addObject("position",position);
			mv.addObject("batter2",batter2);
			
			mv.setViewName("PlayerInfo/batter");
		}
	
		return mv;
	}
	
	@RequestMapping("/teamList")
	public ModelAndView PlayerList2(
			@RequestParam(value="teamname") String teamname,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,
			ModelAndView mv) {
		
		//팀별 선수목록 & 페이징
		PageUtil pInfo = pService.getTeamCnt(teamname, nowPage);
		ArrayList<PlayerInfoDTO> getTeamList = pService.getTeamList(teamname, pInfo);
		pInfo.setTeamname(teamname);
		
		mv.addObject("getTeamList", getTeamList);
		mv.addObject("PINFO", pInfo);
		
		mv.setViewName("PlayerInfo/PlayerTeam");
		
		return mv;
	}
	
}
