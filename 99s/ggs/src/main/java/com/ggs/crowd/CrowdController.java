package com.ggs.crowd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
		System.out.println("1컨트롤러 historyList ");
		
		ArrayList<AhFiveDTO> historyListFoot = crService.historyListFoot(afDTO);
		System.out.println("1컨트롤러 historyListFoot ");
		
		mv.addObject("HISTORYLIST",historyList);
		mv.addObject("HISTORYLISTFOOT",historyListFoot);

		mv.setViewName("crowd/crowdHistory");
		return mv;
		
	}
	
		@RequestMapping("/crowdHistoryGraph.gg")
		public ModelAndView crowdHistoryGraph (ModelAndView mv ,AhFiveDTO afDTO) {
			List<AhFiveDTO> crowdHistoryGraph = crService.crowdHistoryGraph(afDTO);
			System.out.println("1컨트롤러 crowdHistoryGraph "+crowdHistoryGraph);
			String yearStr = null;
			String totaltStr= null;
			List<String> yearList = new ArrayList<String>(37);
			List<String> totaltList = new ArrayList<String>(37);
			for (int i=0; i<37; i++) {
				yearStr= crowdHistoryGraph.get(i).getYearsChar();
				totaltStr= crowdHistoryGraph.get(i).getTotaltChar();
				yearList.add(yearStr);
				totaltList.add(totaltStr);
			}
			System.out.println("yearList"+yearList);
			
			mv.addObject("CROWDHISTORYGRAPH",crowdHistoryGraph);
			mv.addObject("yearList",yearList);
			mv.addObject("totaltList",totaltList);
			
			mv.setViewName("crowd/crowdHistoryGraph");
			return mv;
		}

}
