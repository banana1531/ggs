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
	public HashMap loginProc(HashMap map) {
		System.out.println("loginProc DAO ����");		
		HashMap result= (HashMap)session.selectOne("members.loginProc",map);
		System.out.println("result="+result);
		return result;
	}
	
}