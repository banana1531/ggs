package com.ggs.DAO;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.MembersDTO;
import com.ggs.DTO.TeamRecordDTO;

@Repository
public class TeampredictDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	//회원 순으로 가져오기
	public List<MembersDTO> getRankingList(String id) {

		return session.selectList("Members.MembersRanking",id);
		
	}
	//point 리스트 가져오기
	public List<MembersDTO> getppoint(Integer ppoint){
		return session.selectList("Members.MembersRanking",ppoint);
	}

	//해당날짜의 해당경기번호읽기
	public List<TeamRecordDTO> getTodayMatchGno(Integer gno) {
	
		return session.selectList("todaymatch.todaymatch",gno);
	}
	//홈팀 어웨이팀 가져오기
	public List<TeamRecordDTO> getTodayMatch(String ateamname, String bteamname) {

		return session.selectList("todaymatch.todaymatch");
	
	}

}