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
		return session.selectList("teamRecord.teamRecord", teamRecordDTO);
	}
	
	//팀 실적 가져오기
	public TeamInfoDTO teamScore(String name) {
		TeamInfoDTO dto = new TeamInfoDTO();
		dto.setTeamName(name);
		return session.selectOne("teamRecord.teamScore", dto);
	}

	public List<TeamInfoDTO> teamScoreList() {
		return session.selectList("teamRecord.teamScore");
	}
	
	
}
