package com.ggs.DAO;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.TeamRecordDTO;

@Repository
public class SchMatchDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	//경기일정 리스트 가져오기
	public List<TeamRecordDTO> getschmatchList(TeamRecordDTO teamRecordDTO){
		return session.selectList("schmatch.schmatch",teamRecordDTO);
	}
	
	//경기결과 리스트 가져오기	
	public List<TeamRecordDTO> getrltmatchList(int start) {
		return session.selectList("schmatch.getrltmatchList", start);
	}

}
