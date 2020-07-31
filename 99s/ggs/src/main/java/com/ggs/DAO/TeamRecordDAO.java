package com.ggs.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.TeamInfoDTO;
import com.ggs.DTO.TeamRecordDTO;

@Repository
public class TeamRecordDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<TeamRecordDTO> getMyTeamSchedule(String teamName){
		return session.selectList("teamRecord.myteam", teamName);
	}
	
	//팀 경기 이력 가져오기
	public List<TeamRecordDTO> teamRecord(TeamRecordDTO teamRecordDTO) {
		System.out.println("TeamRecordDAO.teamRecord. teamRecordDTO= "+teamRecordDTO);
		return session.selectList("teamRecord.teamRecord", teamRecordDTO);
	}
	
	//팀 실적 가져오기
	public TeamInfoDTO teamScore(String name) {
		TeamInfoDTO dto = new TeamInfoDTO();
		dto.setTeamName(name);
		System.out.println("teamScore() dto="+dto);
		return session.selectOne("teamRecord.teamscoreD", dto);
	}
	
	//팀 목록 가져오기
	public List<TeamInfoDTO> teamScoreList() {
		return session.selectList("teamRecord.teamscoreD");
	}

	
	//팀 경기 일정 가져오기
	public List schmatchList(TeamRecordDTO teamRecordDTO) {
		return session.selectList("teamRecord.schmatchList", teamRecordDTO);
	}

	
	//팀 경기 정보 업데이트
	public int updateTeamRecord(TeamRecordDTO teamRecordDTO) {
		return session.update("teamRecord.updateTeamRecord", teamRecordDTO);		
	}

	
	
	
}
