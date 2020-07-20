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
	
	//경기리스트 가져오기
	public List<TeamRecordDTO> getschmatchList(){
		return session.selectList("schmatch.schmatch");
	}
	
	public List<TeamRecordDTO> getschmatchDetail(){
		return session.selectList("schmatch.schmatchDetail");
	}
}
