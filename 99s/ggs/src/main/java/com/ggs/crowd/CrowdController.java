package com.ggs.crowd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ggs.DTO.AudienceHistoryDTO;
import com.ggs.DTO.PlayerInfoDTO;

@Controller
@RequestMapping("/crowd")
public class CrowdController {
	
	@Autowired
	CrowdService crService;
	
	@RequestMapping("/crowdHistory.gg")
	public ModelAndView crowdHistory (ModelAndView mv ,AudienceHistoryDTO ahDTO) {
		System.out.println("crowdHistory() 진입");
		
		//역대 관중 현황표 : 연도별로 각 팀당 몇명의 관중이 들었는지
		ArrayList<AudienceHistoryDTO> historyList = crService.historyList(ahDTO);
		
		
//		//연도별 관중 현황 : 연도별 kbo 총 관객
//		ArrayList<AudienceHistoryDTO> yearList = crService.yearList(ahDTO);
//		
//		//구단별 관중 현황 : 무관중
//		ArrayList<AudienceHistoryDTO> teamList = crService.teamList(ahDTO);
		
		mv.addObject("HISTORYLIST",historyList);	
		mv.setViewName("crowd/crowdHistory");
		
		return mv;
		
	}
}
