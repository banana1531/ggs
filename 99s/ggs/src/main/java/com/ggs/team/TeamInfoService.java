package com.ggs.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.TeamInfoDAO;
import com.ggs.DAO.TeamRecordDAO;
import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

@Service
public class TeamInfoService {

	@Autowired
	private TeamInfoDAO tDao;

	@Autowired
	private TeamRecordDAO teamRecordDAO; 
	
	//팀 목록 가져오기
	public List<TeamInfoDTO> getTeamList() {
		return teamRecordDAO.teamScoreList();
	}
	
	//팀 기본정보 목록 가져오기
	public List<TeamInfoDTO> teamList() {
		return tDao.teamList();
	}
	
	//팀 기본 정보 가져오기
	public TeamInfoDTO teamDetail(String name) {
		//기본정보 가져오기
		TeamInfoDTO teamDetail = tDao.teamDetail(name);
		//실적가져오기
		TeamInfoDTO teamRecord = teamRecordDAO.teamScore(name);
		System.out.println(teamRecord);
		
		teamDetail.setWin(teamRecord.getWin());
		teamDetail.setDraw(teamRecord.getDraw());
		teamDetail.setLose(teamRecord.getLose());
		teamDetail.setScore(teamRecord.getScore());
		teamDetail.setLoss(teamRecord.getLoss());
		return teamDetail;	
	}
	
	//팀 경기 이력 가져오기
	public List<TeamRecordDTO> teamRecord(String name, String pageNo) {
		int temp = Integer.parseInt(pageNo);
		int start = (temp-1)*5;
		TeamRecordDTO teamRecordDTO = new TeamRecordDTO();
		teamRecordDTO.setAteamname(name);
		teamRecordDTO.setStart(start);
		return teamRecordDAO.teamRecord(teamRecordDTO);
	}

	//팀 경기 이력 페이지 정보 처리하기
	public int totalpage(List list) {
		TeamRecordDTO dto = (TeamRecordDTO)list.get(0);
		int totalcnt = dto.getTotalcnt();
		int totalpage = totalcnt/5;
		if(totalcnt%5>0) totalpage++;
		return totalpage;
	}
	
}
