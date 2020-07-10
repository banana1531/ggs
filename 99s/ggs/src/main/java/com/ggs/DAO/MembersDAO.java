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

		
	//�α��� ó��
	public MembersDTO loginProc(MembersDTO mdto) {
		System.out.println("loginProc DAO ����");		
		MembersDTO result= (MembersDTO)session.selectOne("members.loginProc",mdto);
		return result;
	}
	
}
