﻿package com.ggs.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggs.DAO.MembersDAO;
import com.ggs.DTO.MembersDTO;

@Service
public class Memberservice {
	@Autowired
	MembersDAO mDAO;
	
	//로그인처리
	public MembersDTO loginProc(MembersDTO mdto, HttpSession session) {
		System.out.println("Memberservice-loginProc()!");						
		
		MembersDTO result = mDAO.loginProc(mdto);
		
		//로그인 실패시
		if(result==null) {
			System.out.println("회원X");
		}else {				
		//로그인 성공시 ->로그인한 유저의 정보를 세션에 저장
			System.out.println("회원O");
			session.setAttribute("UID",result.getId());
			session.setAttribute("UNAME",result.getName());
			session.setAttribute("UTEAM",result.getTeam());
			session.setAttribute("UEMAIL",result.getEmail());
			session.setAttribute("UBOARDM",result.getBoardM());
			session.setAttribute("UBOARDV",result.getBoardV());
			session.setAttribute("ULOGIN",result.getLogin());
			session.setAttribute("UPOINT",result.getPpoint());
			System.out.println("로그인 성공 "+session.getAttribute("UID")+"/"+session.getAttribute("UEMAIL"));			
		}
		return result;	
	}
	
	//메일인증
	public MembersDTO mailAuth(MembersDTO mdto) {
		System.out.println("Memberservice-mailAuth()!");
		MembersDTO result = mDAO.mailAuth(mdto);
		return result;
	}
	
	//비밀번호 변경
	public void updatePw(MembersDTO memberDTO) {
		System.out.println("Memberservice-pwChgProc()!");
		mDAO.updatePw(memberDTO);
	}
	
	//회원가입 - 아이디, 이메일 중복체크
	public MembersDTO mailAuth1(MembersDTO mdto) {
		System.out.println("Memberservice-mailAuth1()!");
		MembersDTO result = mDAO.mailAuth1(mdto);
		return result;
	}
	//회원가입 처리
	public void joinProc(MembersDTO mdto) {
		System.out.println("Memberservice-joinProc()!");
		mDAO.joinProc(mdto);
	}
	
	//로그인 기록 체크
	public int loginChk(MembersDTO result) {
		System.out.println("result="+result);
		//최종 로그인 시간 확인해서 1일이상 차이가 발생할 경우 db 업데이트
		int r=mDAO.chkLastLogin(result.getId());
		System.out.println("r="+r);
		if(r==0||r>1) {
			mDAO.insertLoginDate(result.getId());
			mDAO.updatePPoint(result);
			return r;
		}
		return 1;
	}
}