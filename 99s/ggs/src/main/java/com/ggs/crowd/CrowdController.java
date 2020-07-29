package com.ggs.crowd;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ggs.DTO.AhFiveDTO;


@Controller
@RequestMapping("/crowd")
public class CrowdController {
	
	@Autowired
	CrowdService crService;
	
	@RequestMapping("/crowdHistory.gg")
	public ModelAndView crowdHistory (ModelAndView mv ,AhFiveDTO afDTO) {
		System.out.println("crowdHistory() 진입afDTO="+afDTO);
		
		//역대 관중 현황표 : 연도별로 각 팀당 몇명의 관중이 들었는지
		ArrayList<AhFiveDTO> historyList = crService.historyList(afDTO);
		System.out.println("1컨트롤러 historyList = "+historyList.size());
		
		ArrayList<AhFiveDTO> historyListFoot = crService.historyListFoot(afDTO);
		System.out.println("1컨트롤러 historyListFoot = "+historyListFoot.size());
		
//		//연도별 관중 현황 : 연도별 kbo 총 관객
//		ArrayList<AudienceHistoryDTO> yearList = crService.yearList(ahDTO);
//		
//		//구단별 관중 현황 : 무관중
//		ArrayList<AudienceHistoryDTO> teamList = crService.teamList(ahDTO);

//		ArrayList<AhFiveDTO> historyListChart = crService.historyListChart(afDTO);
//		System.out.println("1컨트롤러 historyListChart = "+historyListChart.size());
		
		
		mv.addObject("HISTORYLIST",historyList);
		mv.addObject("HISTORYLISTFOOT",historyListFoot);
		
		
		
		mv.setViewName("crowd/crowdHistory");
		return mv;
		
	}

	

}
