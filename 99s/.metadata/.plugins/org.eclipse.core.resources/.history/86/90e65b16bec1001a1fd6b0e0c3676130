package com.ggs.DAO;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.FreeBoardDTO;
import com.ggs.DTO.TeamInfoDTO;

@Repository
public class TeamInfoDAO {
	
	@Inject
	private SqlSessionTemplate session;
	
	//session정보를 받아서 처리
	public TeamInfoDTO getTeamInfo() {
		System.out.println("TeamInfoDAO.getTeamInfo() 진입");
		
		String teamname = "SK";
				
		System.out.println(session.selectOne("TeamInfo.myteam").toString());
		
		return null;
	}

	public List<FreeBoardDTO> getMyArticle(String uid) {
		
		//id값으로 자유게시판 글목록 가져오기
		uid="test";
			
		List<FreeBoardDTO> list = session.selectList("memberMapper.board",uid);
		System.out.println(list.toString());
				
		return list;
	}
	
}