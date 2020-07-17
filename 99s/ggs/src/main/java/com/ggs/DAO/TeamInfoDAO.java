package com.ggs.DAO;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.TeamInfoDTO;

@Repository
public class TeamInfoDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	//팀 기본정보 가져오기
	public TeamInfoDTO teamDetail(String name) {
		System.out.println("TeamInfoDAO.teamDetail");
		return session.selectOne("team.teamDetail", name);
	}
	//팀이름 정보 가져오기
	public List getTeamNames() {
		return session.selectList("team.getNames");
	}
	//팀 기본정보 목록 가져오기
	public List<TeamInfoDTO> teamList(){
		return session.selectList("team.teamList");
	}
	public int updateInfo(TeamInfoDTO teamInfoDTO) {
		return session.update("team.updateInfo", teamInfoDTO);
	}
	
}