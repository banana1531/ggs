package com.ggs.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.MembersDTO;

@Repository
public class MembersDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	//내정보 가져오기
	public MembersDTO getMyInfo(String uid) {
		return session.selectOne("members.myinfo", uid);
	}
	
	//비밀번호 변경하기
	public void updatePw(MembersDTO memberDTO) {
		session.update("members.updatePw", memberDTO);		
	}

	//비밀번호 가져오기
	public String getPw(String uid) {
		return session.selectOne("members.getPw", uid);
	}
	
	//내정보 수정하기(선호팀)
	public int updateMyInfo(MembersDTO member) {
		return session.update("members.updateTeam", member);
	}
	
	//회원 목록 가져오기
	public List<MembersDTO> getMembersList() {
		List list = session.selectList("members.getMembersList");
		System.out.println(list);
		
		return list;
	}
	
	//로그인 처리
	public MembersDTO loginProc(HashMap map) {
		System.out.println("loginProc DAO 진입");
		MembersDTO dto = session.selectOne("members.loginProc",map);
		System.out.println("dto="+dto);
		return dto;
	}

	//가입자수 조회
	public int totalCnt() {
		return session.selectOne("members.totalCnt");
	}

}
