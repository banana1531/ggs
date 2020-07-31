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
			List<String> yearList = new ArrayList<String>(38);
			List<String> totaltList = new ArrayList<String>(38);
			for (int i=0; i<38; i++) {
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
		
		@RequestMapping("/crowdHistoryGraph2.gg")
		public ModelAndView crowdHistoryGraph2 (ModelAndView mv ,AhFiveDTO afDTO) {
			List<AhFiveDTO> crowdHistoryGraph2 = crService.crowdHistoryGraph2(afDTO);
			System.out.println("1컨트롤러 crowdHistoryGraph2 "+crowdHistoryGraph2);
			String yearStr = null;
			String totaltStr = null;
			String samsungtStr = null;
			String kiatStr = null;
			String lottetStr = null;
			String lgtStr = null;
			String doosantStr = null;
			String hanwhatStr = null;
			String sktStr = null;
			String kiwoomtStr = null;
			String nctStr = null;
			String kttStr = null;
			
			List<String> yearList = new ArrayList<String>(38);
			List<String> totaltList = new ArrayList<String>(38);
			List<String> samsungtList = new ArrayList<String>(38);
			List<String> kiatList = new ArrayList<String>(38);
			List<String> lottetList = new ArrayList<String>(38);
			List<String> lgtList = new ArrayList<String>(38);
			List<String> doosantList = new ArrayList<String>(38);
			List<String> hanwhatList = new ArrayList<String>(38);
			List<String> sktList = new ArrayList<String>(38);
			List<String> kiwoomtList = new ArrayList<String>(38);
			List<String> nctList = new ArrayList<String>(38);
			List<String> kttList = new ArrayList<String>(38);
			
			for (int i=0; i<38; i++) {
				yearStr= crowdHistoryGraph2.get(i).getYearsChar();
				totaltStr= crowdHistoryGraph2.get(i).getTotaltChar();
				samsungtStr= crowdHistoryGraph2.get(i).getSamsungtChar();
				kiatStr= crowdHistoryGraph2.get(i).getKiatChar();
				lottetStr= crowdHistoryGraph2.get(i).getLottetChar();
				lgtStr= crowdHistoryGraph2.get(i).getLgtChar();
				doosantStr= crowdHistoryGraph2.get(i).getDoosantChar();
				hanwhatStr= crowdHistoryGraph2.get(i).getHanwhatChar();
				sktStr= crowdHistoryGraph2.get(i).getSktChar();
				kiwoomtStr= crowdHistoryGraph2.get(i).getKiwoomtChar();
				nctStr= crowdHistoryGraph2.get(i).getNctChar();
				kttStr= crowdHistoryGraph2.get(i).getKttChar();

				yearList.add(yearStr);
				totaltList.add(totaltStr);
				samsungtList.add(samsungtStr);
				kiatList.add(kiatStr);
				lottetList.add(lottetStr);
				lgtList.add(lgtStr);
				doosantList.add(doosantStr);
				hanwhatList.add(hanwhatStr);
				sktList.add(sktStr);
				kiwoomtList.add(kiwoomtStr);
				nctList.add(nctStr);
				kttList.add(kttStr);
			}//for 끝
			System.out.println("컨트롤러 samsungtList = "+samsungtList);
			
			mv.addObject("CROWDHISTORYGRAPH2",crowdHistoryGraph2);
			mv.addObject("yearList",yearList);
			mv.addObject("totaltList",totaltList);
			
			mv.addObject("samsungtList",samsungtList);
			mv.addObject("kiatList",kiatList);
			mv.addObject("lottetList",lottetList);
			mv.addObject("lgtList",lgtList);
			mv.addObject("doosantList",doosantList);
			mv.addObject("hanwhatList",hanwhatList);
			mv.addObject("sktList",sktList);
			mv.addObject("kiwoomtList",kiwoomtList);
			mv.addObject("nctList",nctList);
			mv.addObject("kttList",kttList);
			
			mv.setViewName("crowd/crowdHistoryGraph2");
			return mv;
		}
}
