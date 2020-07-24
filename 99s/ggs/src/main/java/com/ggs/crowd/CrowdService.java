package com.ggs.crowd;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.CrowdDAO;
import com.ggs.DTO.AudienceHistoryDTO;

@Service
public class CrowdService {
	@Autowired
	CrowdDAO crDAO;
	
	
	//선수 bmi리스트
	public ArrayList<AudienceHistoryDTO> historyList(AudienceHistoryDTO ahDTO) {
		System.out.println("CrowdService의 historyList() 진입");
		//리스트 보여주기 
		ArrayList<AudienceHistoryDTO> historyList=crDAO.historyList(ahDTO);
		System.out.println("CrowdService의 historyList() historyList "+historyList);
		return historyList;
	}
}
