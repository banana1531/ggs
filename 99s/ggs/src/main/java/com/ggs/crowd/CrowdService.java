package com.ggs.crowd;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.CrowdDAO;
import com.ggs.DTO.AhFiveDTO;
import com.ggs.DTO.PlayerInfoDTO;
import com.ggs.DTO.WeeklyCountDTO;


@Service
public class CrowdService {
	@Autowired
	CrowdDAO crDAO;


	//선수 bmi리스트
	public ArrayList<AhFiveDTO> historyList(AhFiveDTO afDTO) {
		//리스트 보여주기 
		ArrayList<AhFiveDTO> historyList=crDAO.historyList(afDTO);
		System.out.println("CrowdService의 historyList() historyList "+historyList);
		return historyList;
	}


	public ArrayList<AhFiveDTO> historyListFoot(AhFiveDTO afDTO) {
		ArrayList<AhFiveDTO> historyListFoot=crDAO.historyListFoot(afDTO);
		System.out.println("CrowdService의 historyListFoot() 진입 "+historyListFoot);
		return historyListFoot;
	}


	public List crowdHistoryGraph(AhFiveDTO afDTO) {
		List crowdHistoryGraph = crDAO.crowdHistoryGraph(afDTO);
		System.out.println("111 crowdHistoryGraph = "+crowdHistoryGraph);		
		return crowdHistoryGraph;
	}
	
	public List crowdHistoryGraph2(AhFiveDTO afDTO) {
		List crowdHistoryGraph2 = crDAO.crowdHistoryGraph2(afDTO);
		System.out.println("111 crowdHistoryGraph2 = "+crowdHistoryGraph2);		
		return crowdHistoryGraph2;
	}

	
	
}
