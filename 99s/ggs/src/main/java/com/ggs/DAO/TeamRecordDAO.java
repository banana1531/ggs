package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.TeamRecordDTO;

@Repository
public class TeamRecordDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	public List<TeamRecordDTO> getMyTeamSchedule(String teamName){
		
		return session.selectList("teamRecord.myteam", teamName);
	}
	
	
}