package com.ggs.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.MembersDTO;

@Repository
public class MembersDAO {
	
	@Autowired
	private SqlSessionTemplate session;

	public MembersDTO getMyInfo(String uid) {

		return session.selectOne("members.myinfo", uid);
	}

	public void updatePw(MembersDTO memberDTO) {
		
		
		session.update("members.updatePw", memberDTO);		
	}

	public String getPw(String uid) {

		return session.selectOne("members.getPw", uid);
	}

		
	//로그인 처리
	public MembersDTO loginProc(MembersDTO mdto) {
		System.out.println("loginProc DAO 진입");		
		MembersDTO result= (MembersDTO)session.selectOne("members.loginProc",mdto);
		return result;
	}
	
}
