package com.ggs.teamrecord;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.SchMatchDAO;
import com.ggs.DAO.TeampredictDAO;
import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.TeamRecordDTO;

@Service
public class TeampredictService {

	@Autowired
	private TeampredictDAO teampredictdao;
		
	@Autowired
	private SchMatchDAO schmatchdao;
	
	//아이디와 포인트 가져오기
	public List<MembersDTO> getRankingList(String id) {
		return teampredictdao.getRankingList(id);
	}
	
	public List<MembersDTO> getpointList(Integer ppoint) {
		return teampredictdao.getppoint(ppoint);
	}
	public List<TeamRecordDTO> getTodayMatchGno(Integer gno) {
		return teampredictdao.getTodayMatchGno(gno);
	}
	
	//오늘날짜에 해당하는 경기리스트 가져오기
	public List<TeamRecordDTO> getTodayMatch(String ateamname, String bteamname) {
		return teampredictdao.getTodayMatch(ateamname,bteamname);
	}
	//해당하는 경기리스트 출력해주기
	
	//경기리스트 오름차순으로 출력하기
	public List<TeamRecordDTO> getschmatchList(String pageNo, int month){
		System.out.println("TeampredictService.schmatchList");
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*10;
		TeamRecordDTO teamRecordDTO = new TeamRecordDTO();
		if(month>0) teamRecordDTO.setMonth(month);
		teamRecordDTO.setStart(start);		
		return schmatchdao.getschmatchList(teamRecordDTO);
	}
	
	//경기결과 오름차순으로 출력하기
	public List<TeamRecordDTO> getrltmatchList(String pageNo, String perPage, int month) {
		System.out.println("TeampredictService.getrltmatchList");
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*Integer.parseInt(perPage);
		TeamRecordDTO teamRecordDTO = new TeamRecordDTO();
		if(month>0) teamRecordDTO.setMonth(month);
		teamRecordDTO.setStart(start);
		return schmatchdao.getrltmatchList(teamRecordDTO);
	}
}

