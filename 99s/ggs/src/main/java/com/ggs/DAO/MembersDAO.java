package com.ggs.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggs.DTO.MembersDTO;

@Repository
public class MembersDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	

	// 내정보 가져오기
	public MembersDTO getMyInfo(String uid) {
		return session.selectOne("members.myinfo", uid);
	}

	// 비밀번호 변경하기
	public void updatePw(MembersDTO memberDTO) {
		session.update("members.updatePw", memberDTO);
	}

	// 비밀번호 가져오기
	public String getPw(String uid) {
		return session.selectOne("members.getPw", uid);
	}

	// 내정보 수정하기(선호팀)
	public int updateMyInfo(MembersDTO member) {
		return session.update("members.updateTeam", member);
	}
	
	//회원 권한 수정하기
	public int updateGrant(MembersDTO member) {
		System.out.println("MembersDAO updateGrant member="+member);
		int k = session.update("members.updateGrant", member);
		System.out.println("result="+k);
		return k;
	}

	// 회원 목록 가져오기
	public List<MembersDTO> getMembersList(MembersDTO dto) {
		System.out.println("dto="+dto);
		return session.selectList("members.getMembersList", dto);
	}

	// 로그인 처리
	public MembersDTO loginProc(MembersDTO mdto) {
		System.out.println("loginProc DAO 진입");
		MembersDTO result = (MembersDTO) session.selectOne("members.loginProc", mdto);
		return result;
	}

	// 가입자수 조회
	public int totalCnt() {
		return session.selectOne("members.totalCnt");
	}

	//최종 로그인 일자와 현재 로그인 일자 차이 가져오기
	public int chkLastLogin(String uid) {
		System.out.println("chkLastLogin. id="+uid);
		Integer t = session.selectOne("loginCount.chkLastLogin", uid);
		if(t==null) t=0;
		return t;
	}
	
	//로그인 기록 db 저장하기
	public void insertLoginDate(String uid) {
		session.insert("loginCount.insertLoginDate", uid);
	}
	
	//회원 검색
	public List<MembersDTO> memberSearch(MembersDTO search) {
		return session.selectList("members.getMembersList", search);
	}
	
	//메일인증
	public MembersDTO mailAuth(MembersDTO mdto) {
		System.out.println("mailAuth DAO 진입");	
		MembersDTO result= (MembersDTO)session.selectOne("members.mailAuth",mdto);
		return result;
	}
	
	//회원가입 - 아이디, 이메일 중복체크
	public MembersDTO mailAuth1(MembersDTO mdto) {
		System.out.println("mailAuth1 DAO 진입");	
		MembersDTO result= (MembersDTO)session.selectOne("members.mailAuth1",mdto);
		return result;
	}
	
	//회원가입처리
	public void joinProc(MembersDTO mdto) {
		System.out.println("joinProc DAO 진입");	
		session.insert("members.joinProc",mdto);
	}
}
