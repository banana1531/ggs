package com.ggs.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ggs.DTO.TeamInfo;

public class TeamInfoDAO {
	
	
	//session정보를 받아서 처리
	public TeamInfo getTeamInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		
		//session의 team이름을 추출하여 넣어준다.
		TeamInfo myTeam = new TeamInfo();
		
		
		
		return myTeam;
	}
	
}
